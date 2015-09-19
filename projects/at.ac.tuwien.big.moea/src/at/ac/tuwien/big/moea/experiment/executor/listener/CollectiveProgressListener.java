/*******************************************************************************
 * Copyright (c) 2015 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 *******************************************************************************/
package at.ac.tuwien.big.moea.experiment.executor.listener;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.moeaframework.Executor;
import org.moeaframework.core.Solution;
import org.moeaframework.util.progress.ProgressEvent;
import org.moeaframework.util.progress.ProgressListener;

import at.ac.tuwien.big.moea.experiment.instrumenter.collector.SimpleBestSolutionCollector;
import at.ac.tuwien.big.moea.print.ISolutionWriter;
import at.ac.tuwien.big.moea.util.AccumulatorUtil;
import at.ac.tuwien.big.moea.util.TextUtil;

public class CollectiveProgressListener extends AbstractProgressListener implements ProgressListener {
	
	private boolean firstCall = true;
	private PrintStream stream;
	private String separator;
	private ISolutionWriter<? extends Solution> printer;
	private boolean printObjectives = true;
	private boolean printConstraints = true;
	private boolean printSimpleAggregate = true;
	private boolean spaceColumns = false;
	
	public CollectiveProgressListener() {
		this(System.out, "\t");
	}
	
	public CollectiveProgressListener(PrintStream stream) {
		this(stream, "\t");
	}
	
	public CollectiveProgressListener(String separator) {
		this(System.out, separator);
	}
	
	public CollectiveProgressListener(PrintStream stream, String separator) {
		this.stream = stream;
		this.separator = separator;
	}
	
	public PrintStream getPrintStream() {
		return stream;
	}
	
	public String getSeparator() {
		return separator;
	}
	
	public ISolutionWriter<? extends Solution> getSolutionPrinter() {
		return printer;
	}
	
	public CollectiveProgressListener setSolutionPrinter(ISolutionWriter<? extends Solution> printer) {
		return setSolutionPrinter(printer, true, true, true);
	}
	
	public CollectiveProgressListener setSpaceColumns(boolean spaceColumns) {
		this.spaceColumns = spaceColumns;
		return this;
	}
	
	public CollectiveProgressListener setSolutionPrinter(ISolutionWriter<? extends Solution> printer, boolean printSimpleAggregate, boolean printObjectives, boolean printConstraints) {
		this.printer = printer;
		this.printSimpleAggregate = printSimpleAggregate;
		this.printObjectives = printObjectives;
		this.printConstraints = printConstraints;
		return this;
	}
		
	private IColumn createTimeColumn(ProgressEvent event) {
		return new EventColumn(event, "Elapsed/Remaining") {
			@Override
			public String getLatestData() {
				return TextUtil.toString(getEvent().getElapsedTime(), 2) + "s/" 
						+ TextUtil.toString(getEvent().getRemainingTime(), 2) + "s";
			}
		};
	}
	
	private IColumn createEvaluationColumn(ProgressEvent event) {
		return new EventColumn(event, "Evaluation") {
			@Override
			public String getLatestData() {
				return getEvent().getCurrentNFE() + "/" + getEvent().getMaxNFE(); 
			}
		};
	}
	
	private IColumn createPercentCompleteColumn(ProgressEvent event) {
		return new EventColumn(event, "%-Complete") {
			@Override
			public String getLatestData() {
				return TextUtil.toString(getEvent().getPercentComplete() * 100, 2) + "%";
			}
			
			@Override
			public int getWidth() {
				return getHeader().length();
			}
		};
	}
	
	private IColumn createSeedColumn(ProgressEvent event) {
		return new EventColumn(event, "Seed") {
			@Override
			public String getLatestData() {
				return getEvent().getCurrentSeed() + "/" + getEvent().getTotalSeeds();
			}
			
			@Override
			public int getWidth() {
				return getHeader().length();
			}
		};
	}
	
	private IColumn createAccumulatorColumn(ProgressEvent event, String key, String header) {
		return new AccumulatorColumn(
				event.getExecutor(), key, header);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<IColumn> createSolutionColumns(ProgressEvent event) {
		ArrayList<IColumn> columns = new ArrayList<>();
		if(getSolutionPrinter() == null)
			return columns;
		
		Solution bestSolution = AccumulatorUtil.getLatestBestSolution(event.getExecutor());
		if(bestSolution == null)
			return columns;
		
		if(printSimpleAggregate)
			columns.add(new AccumulatorColumn(event.getExecutor(), AccumulatorUtil.Keys.SIMPLE_BEST_SOLUTION, "Aggregated Fitness") {		
				@Override
				protected String getLatestDataString() {
					Solution bestSolution = AccumulatorUtil.getLatestBestSolution(getExecutor());
					if(bestSolution == null)
						return "";
					
					return TextUtil.toString(SimpleBestSolutionCollector.calculateAggregatedFitness(bestSolution), 10);
				}
			});
		
		if(printObjectives)
			for(int i = 0; i < bestSolution.getNumberOfObjectives(); i++)
				columns.add(new SolutionObjectiveColumn(bestSolution, i, getSolutionPrinter()));
		
		if(printConstraints)
			for(int i = 0; i < bestSolution.getNumberOfConstraints(); i++)
				columns.add(new SolutionConstraintColumn(bestSolution, i, getSolutionPrinter()));
		return columns;
	}
	
	private List<IColumn> getColumns(ProgressEvent event) {
		List<IColumn> columns = new ArrayList<>();
		columns.add(createSeedColumn(event));
		columns.add(createPercentCompleteColumn(event));
		columns.add(createEvaluationColumn(event));
		columns.add(createTimeColumn(event));
		columns.addAll(createSolutionColumns(event));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.POPULATION_SIZE, "PopulationSize"));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.INDICATOR_ADDITIVE_EPSILON, "AdditiveEpsilon"));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.INDICATOR_CONTRIBUTION, "Contribution"));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.INDICATOR_GENERATIONAL_DISTANCE, "GenerationalDistance"));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.INDICATOR_HYPERVOLUME, "Hypervolume"));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.INDICATOR_INVERTED_GENERATIONAL_DISTANCE, "InvertedGenerationalDistance"));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.INDICATOR_SPACING, "Spacing"));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.ARCHIVE_SIZE, "ArchiveSize"));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.NUMBER_OF_DOMINATING_IMPROVEMENTS, "#DominatingImprovements"));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.NUMBER_OF_IMPROVEMENTS, "#Improvements"));
		columns.add(createAccumulatorColumn(event, AccumulatorUtil.Keys.NUMBER_OF_RESTARTS, "#Restarts"));
		return columns;
	}
	
	private void printHeader(List<IColumn> columns) {
		if(!firstCall)
			return;
		
		String separator = "";
		for(IColumn column : columns) {
			String header = column.getHeader();
			if(!header.isEmpty()) {
				getPrintStream().print(separator);
				getPrintStream().printf("%-" + column.getWidth() + "s", header);
				separator = getSeparator();
			}
		}
		getPrintStream().println();
		getPrintStream().flush();
		firstCall = false;
	}

	private void printData(List<IColumn> columns) {
		String separator = "";
		for(IColumn column : columns) {
			String latestData = column.getLatestData();
			if(!latestData.isEmpty()) {
				getPrintStream().print(separator);
				if(spaceColumns)
					getPrintStream().printf("%-" + column.getWidth() + "s", latestData);
				else
					getPrintStream().print(latestData);
				separator = getSeparator();
			}
		}
		getPrintStream().println();
		getPrintStream().flush();
	}
	
	@Override
	public void update(ProgressEvent event) {
		if(!isRunning(event) || isFinished(event))
			return;
				
		List<IColumn> columns = getColumns(event);
		printHeader(columns);
		printData(columns);
	}
	
	public interface IColumn {
		String getHeader();
		String getLatestData();
		int getWidth();
	}
	
	public abstract class SolutionColumn<S extends Solution> implements IColumn {
		protected ISolutionWriter<S> printer;
		protected S solution;
		protected int index;

		public SolutionColumn(S solution, int index, ISolutionWriter<S> printer) {
			this.solution = solution;
			this.index = index;
			this.printer = printer;			
		}
		
		@Override
		public int getWidth() {
			return Math.max(20, getHeader().length());
		}
	}
	
	public class SolutionVariableColumn<S extends Solution> extends SolutionColumn<S> {

		public SolutionVariableColumn(S solution, int index,
				ISolutionWriter<S> printer) {
			super(solution, index, printer);
		}

		@Override
		public String getHeader() {
			return printer.getVariableName(index);
		}

		@Override
		public String getLatestData() {
			return printer.getVariableData(solution, index);
		}
	}
	
	public class SolutionConstraintColumn<S extends Solution> extends SolutionColumn<S> {

		public SolutionConstraintColumn(S solution, int index,
				ISolutionWriter<S> printer) {
			super(solution, index, printer);
		}

		@Override
		public String getHeader() {
			return printer.getConstraintName(index);
		}

		@Override
		public String getLatestData() {
			return printer.getConstraintData(solution, index);
		}
	}
	
	public class SolutionObjectiveColumn<S extends Solution> extends SolutionColumn<S> {

		public SolutionObjectiveColumn(S solution, int index,
				ISolutionWriter<S> printer) {
			super(solution, index, printer);
		}

		@Override
		public String getHeader() {
			return printer.getObjectiveName(index);
		}

		@Override
		public String getLatestData() {
			return printer.getObjectiveData(solution, index);
		}
	}
	
	public abstract class EventColumn implements IColumn {
		
		private String header;
		private ProgressEvent event;
		
		public EventColumn(ProgressEvent event, String header) {
			this.event = event;
			this.header = header;
		}
		
		public ProgressEvent getEvent() {
			return event;
		}
		
		@Override
		public String getHeader() {
			return header;
		}
		
		@Override
		public int getWidth() {
			return Math.max(20, getHeader().length());
		}
	}
	
	public class AccumulatorColumn implements IColumn {
		private Executor executor;
		private String key;
		private String header;
		
		public AccumulatorColumn(Executor executor, String key) {
			this(executor, key, key);	
		}
		
		public AccumulatorColumn(Executor executor, String key, String header) {
			this.executor = executor;
			this.key = key;
			this.header = header;
		}
		
		public Executor getExecutor() {
			return executor;
		}

		public String getKey() {
			return key;
		}
		
		protected boolean hasData() {
			return AccumulatorUtil.hasAccumulatorData(getExecutor(), getKey());
		}
		
		public String getHeader() {
			if(hasData())
				return header;
			return "";
		}
		
		public String getLatestData() {
			if(hasData())
				return getLatestDataString();
			return "";
		}
		
		protected String getLatestDataString() {
			return AccumulatorUtil.getLatestAccumulatorData(getExecutor(), getKey()).toString();
		}
		
		@Override
		public int getWidth() {
			return Math.max(20, getHeader().length());
		}
	}
	
}
