package at.ac.tuwien.big.createalg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.moeaframework.Executor;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;
import org.moeaframework.core.Variation;
import org.moeaframework.core.spi.AlgorithmFactory;
import org.moeaframework.core.spi.OperatorFactory;
import org.moeaframework.core.spi.OperatorProvider;
import org.moeaframework.problem.AbstractProblem;

import at.ac.tuwien.big.moea.search.algorithm.ISolutionInitializer;
import at.ac.tuwien.big.moea.search.algorithm.local.neighborhood.MaximumDecreasingFitnessGenerator;
import at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.search.algorithm.local.neighborhood.SingleObjectiveFitnessGenerator;
import metasearch.Algorithm;
import metasearch.ChangingNeighborhood;
import metasearch.DiscardingSolutionInitializer;
import metasearch.FitnessComparatorGenerator;
import metasearch.GeneticAlgorithm;
import metasearch.HillClimbing;
import metasearch.IteratingAlgorithm;
import metasearch.LocalSearchAlgorithm;
import metasearch.MemeticAlgorithm;
import metasearch.MetasearchFactory;
import metasearch.NSGAII;
import metasearch.NSGAIII;
import metasearch.Neighborhood;
import metasearch.RandomSolutionInitializer;
import metasearch.SimulatedAnnealing;
import metasearch.SolutionInitializer;
import metasearch.impl.RandomWeightGeneratorImpl;

public class ParameterSearch {
	private CreateAlgorithm alg;
	private double globalMutateDelete = 0.25;
	private double globalMutateModify = 0.25;
	private double globalMutateChange = 0.25;
	private double memeticChance = 1.0;
	private int numEvals = 1;

	public ParameterSearch(CreateAlgorithm alg, double globalMutateDelete, double globalMutateModify,
			double globalMutateChange, int numEvals, double memeticChance) {
		this.alg = alg;
		this.globalMutateChange = globalMutateChange;
		this.globalMutateModify = globalMutateModify;
		this.globalMutateDelete = globalMutateDelete;
		this.memeticChance = memeticChance;
		this.numEvals = numEvals;
	}

	private String mainResultFile = "output/evalresults_small.txt";
	
	private FileOutputStream fos;
	{
		try {
			fos = new FileOutputStream(mainResultFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static class AlgorithmVariable implements Variable {
		private static final long serialVersionUID = 6689233993365431833L;
		private Algorithm alg;

		public AlgorithmVariable(Algorithm alg) {
			this.alg = alg;
		}

		@Override
		public Variable copy() {
			return new AlgorithmVariable(EcoreUtil.copy(alg));
		}

		@Override
		public void randomize() {
		}
	}
	
	public static class MyProblem extends AbstractProblem {
		public MyProblem(ParameterSearch This) {
			super(1, 1);
			this.This = This;
		}

		private ParameterSearch This;

		@Override
		public void close() {
			super.close();
		}
		
		double curMemeticChance = 0.0;

		@Override
		public Solution newSolution() {
			try {
				Solution sol = new Solution(getNumberOfVariables(), getNumberOfObjectives());
				curMemeticChance+= This.memeticChance;
				if (curMemeticChance < MathUtil.randomDouble()) {
					sol.setVariable(0, new AlgorithmVariable(This.createRandomIteratingAlgorithm()));
				} else {
					sol.setVariable(0, new AlgorithmVariable(This.createRandomMemeticAlgorithm()));
					curMemeticChance-= 1.0;
				}
				return sol;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		

		@Override
		public void evaluate(Solution sol) {
			AlgorithmVariable al = (AlgorithmVariable) sol.getVariable(0);
			String str = "Running " + describe(al.alg);
			System.out.println(str);
			double sum = 0.0;
			List<Double> subresult = new ArrayList<>();
			long curTime = System.currentTimeMillis();
			for (int i = 0; i < This.numEvals; ++i) {
				double result = This.alg.run(al.alg);
				subresult.add(result);
				sum += result;
				long nextTime = System.currentTimeMillis();
				System.out.print((nextTime-curTime)+" ms, ");
				curTime = nextTime;
			}
			
			System.out.println();
			sum /= This.numEvals;
			This.addResult(al.alg, sum);
			sum = 1.0 - sum;
			System.out.println("Result: "+sum+" "+Arrays.toString(subresult.toArray()));
			
			try {
				This.fos.write((sum + "," + str + "\n").getBytes());
				This.fos.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sol.setObjective(0, sum);
		}
	}

	public boolean isInit = false;
	
	public void initSearch() {
		if (!isInit) {
			isInit = true;
			OperatorFactory opfact = OperatorFactory.getInstance();
			
			opfact.addProvider(new OperatorProvider() {
				@Override
				public String getVariationHint(Problem problem) {
					return "variatechange";
				}
				@Override
				public Variation getVariation(String name, Properties properties, Problem problem) {
					if ("variatechange".equals(name)) {
						return new Variation() {
							private Random random = new Random();
							@Override
							public int getArity() {
								return 2;
							}
							@Override
							public Solution[] evolve(Solution[] parents) {
								Solution first = parents[0].copy();
								Solution second = parents[1].copy();
								AlgorithmVariable firstAlg = (AlgorithmVariable)first.getVariable(0);
								AlgorithmVariable secondAlg = (AlgorithmVariable)second.getVariable(0);
								algorithmCrossover(firstAlg.alg,secondAlg.alg);
								return new Solution[]{
										first,second
								};
							}
						};
					} else if ("mutatechange".equals(name)) {
						Variation ret = new Variation() {
							
							@Override
							public int getArity() {
								return 1;
							}
							@Override
							public Solution[] evolve(Solution[] parents) {
								Solution first = parents[0];
								Algorithm firstAlg = (Algorithm)first;
								algorithmMutate(firstAlg);
								return parents;
							}
						};
						return ret;
					}
					return null;
				}

				@Override
				public String getMutationHint(Problem problem) {
					return "mutatechange";
				}

			});
			// problem = new DistributedProblem(problem,
			// Executors.newCachedThreadPool());
		}
		
	}
	
	private Map<Algorithm,List<double[]>> evaluationResults = new HashMap<>();   

	public synchronized void addResult(Algorithm alg2, double avg, int numEval) {
		List<double[]> curEval = evaluationResults.get(alg2);
		if (curEval == null) {
			evaluationResults.put(alg2, curEval = new ArrayList<>());
		}
		curEval.add(new double[]{numEval,avg});
		writeFile();
	}
	
	public synchronized Algorithm peekBestAlgorithmBelow(int minEvals) {
		double bestValue = Double.NEGATIVE_INFINITY;
		Algorithm ret = null;
		for (Entry<Algorithm, List<double[]>> entry: evaluationResults.entrySet()) {
			double curValue = 0.0;
			double curCount = 0;
			for (double[] se: entry.getValue()) {
				curValue+= se[0]*se[1];
				curCount+= se[0];
			}
			double avgValue = curValue/curCount;
			if (curCount < minEvals && avgValue > bestValue) {
				bestValue = avgValue;
				ret = entry.getKey();
			}
		}
		return ret;
	}
	
	public void improveEvaluationReliability(int toEvals) {
		for(;;) {
			Algorithm alg = peekBestAlgorithmBelow(toEvals);
			if (alg == null) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			List<double[]> cur = evaluationResults.get(alg);
			double curCount = 0.0;
			for (double[] d: cur) {
				curCount+=d[0];
			}
			int missing = 1;//Math.min((int)Math.round(curCount),toEvals-(int)Math.round(curCount));
			double sum = 0.0;
			for (int i = 0; i < missing; ++i) {
				double result = this.alg.run(alg);
				sum+= result;
			}
			addResult(alg, sum/missing, missing);
		}
	}
	
	public void startImproveReliability(int toEvals) {
		Thread t = new Thread(()->improveEvaluationReliability(toEvals));
		t.start();
	}
	
	public synchronized void addResult(Algorithm alg2, double sum) {
		addResult(EcoreUtil.copy(alg2), sum, this.numEvals);
	}

	private int index = 0;
	
	public synchronized void writeFile() {
		writeFile(new File(mainResultFile+".last"));
		++index;
	}
	
	public void writeFile(File file) {
		try (FileOutputStream fos = new FileOutputStream(file)) {
			List<Object[]> objectArray = new ArrayList<Object[]>();
			for (Entry<Algorithm, List<double[]>> entry: evaluationResults.entrySet()) {
				double curValue = 0.0;
				double curCount = 0;
				for (double[] se: entry.getValue()) {
					curValue+= se[0]*se[1];
					curCount+= se[0];
				}
				double avgValue = curValue/curCount;
				objectArray.add(new Object[]{(Double)avgValue,""+avgValue+","+curCount+","+describe(entry.getKey())+"\n"});
			}
			Collections.sort(objectArray, new Comparator<Object[]>() {

				@Override
				public int compare(Object[] arg0, Object[] arg1) {
					return -Double.compare((Double)arg0[0], (Double)arg1[0]);
				}
			});
			for (Object[] oa: objectArray) {
				fos.write(((String)oa[1]).getBytes());
			}
			fos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void runAlgorithm() {
		startImproveReliability(30);
		Executor exec = new org.moeaframework.Executor().withAlgorithm("NSGAII")
				.withProblemClass(MyProblem.class, ParameterSearch.this).withProperty("populationSize", 10)
				.withMaxEvaluations(Integer.MAX_VALUE);
		exec.run();
		
	}

	public void algorithmCrossover(Algorithm first, Algorithm second) {
		if (first instanceof MemeticAlgorithm && second instanceof MemeticAlgorithm) {
			algorithmCrossover((MemeticAlgorithm) first, (MemeticAlgorithm) second);
		} else if (first instanceof GeneticAlgorithm && second instanceof GeneticAlgorithm) {
			// Ignore
		} else if (first instanceof LocalSearchAlgorithm && second instanceof LocalSearchAlgorithm) {
			algorithmCrossover((LocalSearchAlgorithm) first, (LocalSearchAlgorithm) second);
		} else if (first instanceof IteratingAlgorithm && second instanceof IteratingAlgorithm){ 
			algorithmCrossover((IteratingAlgorithm) first, (IteratingAlgorithm) second);
		} else {
			System.err.println("Incompatible algorithms " + first + ", " + second);
		}
	}
	

	public void algorithmCrossover(IteratingAlgorithm first, IteratingAlgorithm second) {
		
		if (MathUtil.randomDouble() < 0.15) {
			int index = MathUtil.randomInteger(7);
			//Change this
			if (index >= 1) {
				// swap
				int temp = first.getNrEvaluations();
				first.setNrEvaluations(second.getNrEvaluations());
				second.setNrEvaluations(temp);
			}
			if (index >= 2) {
				// swap
				SolutionInitializer temp = first.getSolutioninitializer();
				first.setSolutioninitializer(second.getSolutioninitializer());
				second.setSolutioninitializer(temp);
			}
			if (index >= 3) {
				// swap
				LocalSearchAlgorithm temp = first.getAlgorithm();
				first.setAlgorithm(second.getAlgorithm());
				second.setAlgorithm(temp);
			}
			if (index >= 4) {
				// swap
				FitnessComparatorGenerator temp = first.getFitnesscomparatorgenerator();
				first.setFitnesscomparatorgenerator(second.getFitnesscomparatorgenerator());
				second.setFitnesscomparatorgenerator(temp);
			}
			if (index >= 5) {
				int temp = first.getTournamentSize();
				first.setTournamentSize(second.getTournamentSize());
				second.setTournamentSize(temp);
			}
			if (index >= 6) {
				int temp = first.getTournamentRemain();
				first.setTournamentRemain(second.getTournamentRemain());
				second.setTournamentRemain(temp);
			}
		} else {
			algorithmCrossover(first.getSolutioninitializer(), second.getSolutioninitializer());
			if (Math.random() < 0.05) {
				LocalSearchAlgorithm firstA = first.getAlgorithm();
				LocalSearchAlgorithm secondA = second.getAlgorithm();
				first.setAlgorithm(secondA);
				second.setAlgorithm(firstA);
			} else {
				algorithmCrossover(first.getAlgorithm(), second.getAlgorithm());
			}
		}
	}
	
	public void algorithmCrossover(SolutionInitializer first, SolutionInitializer second) {
		if (first instanceof RandomSolutionInitializer && second instanceof RandomSolutionInitializer) {
			algorithmCrossover((RandomSolutionInitializer)first, (RandomSolutionInitializer)second);
		} else if (first instanceof DiscardingSolutionInitializer && second instanceof DiscardingSolutionInitializer) {
			algorithmCrossover((DiscardingSolutionInitializer)first, (DiscardingSolutionInitializer)second);
		}
	}
	
	public void algorithmCrossover(RandomSolutionInitializer first, RandomSolutionInitializer second) {
		//Do nothing
	}

	public void algorithmCrossover(DiscardingSolutionInitializer first, DiscardingSolutionInitializer second) {
		int index = MathUtil.randomInteger(6);
		if (index >= 1) {
			// swap
			int temp = first.getNumInitSolutions();
			first.setNumInitSolutions(second.getNumInitSolutions());
			second.setNumInitSolutions(temp);
		}
		if (index >= 2) {
			// swap
			int temp = first.getSolutionConsiderSize();
			first.setSolutionConsiderSize(second.getSolutionConsiderSize());
			second.setSolutionConsiderSize(temp);
		}
		if (index >= 3) {
			// swap
			int temp = first.getSolutionUseSize();
			first.setSolutionUseSize(second.getSolutionUseSize());
			second.setSolutionUseSize(temp);
		}
		if (index >= 4) {
			// swap
			int temp = first.getNumQueues();
			first.setNumQueues(second.getNumQueues());
			second.setNumQueues(temp);
		}
		if (index >= 5) {
			// swap
			int temp = first.getSolutionsPerQueue();
			first.setSolutionsPerQueue(second.getSolutionsPerQueue());
			second.setSolutionsPerQueue(temp);
		}
	}

	
	public void algorithmCrossover(MemeticAlgorithm first, MemeticAlgorithm second) {
		algorithmCrossover(first.getGlobalSearch(), second.getGlobalSearch());
		algorithmCrossover(first.getLocalsearchapplication(), second.getLocalsearchapplication());
	}

	public void algorithmCrossover(LocalSearchAlgorithm first, LocalSearchAlgorithm second) {
		if (first instanceof HillClimbing && second instanceof HillClimbing) {
			algorithmCrossover((HillClimbing) first, (HillClimbing) second);
		} else if (first instanceof SimulatedAnnealing && second instanceof SimulatedAnnealing) {
			algorithmCrossover((SimulatedAnnealing) first, (SimulatedAnnealing) second);
		}
	}

	public void algorithmCrossover(SimulatedAnnealing first, SimulatedAnnealing second) {
		int index = MathUtil.randomInteger(8);
		if (index >= 1) {
			// swap
			Neighborhood temp = first.getNeighborhood();
			first.setNeighborhood(second.getNeighborhood());
			second.setNeighborhood(temp);
		}
		if (index >= 2) {
			// swap
			int temp = first.getNrEvaluations();
			first.setNrEvaluations(second.getNrEvaluations());
			second.setNrEvaluations(temp);
			algorithmCrossover(first, second);
		}
		if (index >= 3) {
			// swap
			// swap
			double temp = first.getStartTemp();
			first.setStartTemp(second.getStartTemp());
			second.setStartTemp(temp);
		}
		if (index >= 4) {
			double temp = first.getTempIncrease();
			first.setTempIncrease(second.getTempIncrease());
			second.setTempIncrease(temp);
		}
		if (index >= 5) {
			int temp = first.getRestartNoBestImp();
			first.setRestartNoBestImp(second.getRestartNoBestImp());
			second.setRestartNoBestImp(temp);
		}
		if (index >= 6) {
			int temp = first.getRestartNoCurrentImp();
			first.setRestartNoCurrentImp(second.getRestartNoCurrentImp());
			second.setRestartNoCurrentImp(temp);
		}
		if (index >= 7) {
			int temp = first.getTabuSize();
			first.setTabuSize(second.getTabuSize());
			second.setTabuSize(temp);
		}
	}

	public void algorithmCrossover(HillClimbing first, HillClimbing second) {
		int index = MathUtil.randomInteger(7);
		if (index >= 1) {
			// swap
			Neighborhood temp = first.getNeighborhood();
			first.setNeighborhood(second.getNeighborhood());
			second.setNeighborhood(temp);
		}
		if (index >= 2) {
			// swap
			int temp = first.getNrEvaluations();
			first.setNrEvaluations(second.getNrEvaluations());
			second.setNrEvaluations(temp);
			algorithmCrossover(first, second);
		}
		if (index >= 3) {
			int temp = first.getNeighborsize();
			first.setNeighborsize(second.getNeighborsize());
			second.setNeighborsize(temp);
		}
		if (index >= 4) {
			int temp = first.getTabuSize();
			first.setTabuSize(second.getTabuSize());
			second.setTabuSize(temp);
		}
		if (index >= 5) {
			int temp = first.getMaxNoImprovement();
			first.setMaxNoImprovement(second.getMaxNoImprovement());
			second.setMaxNoImprovement(temp);
		}
	}

	public void algorithmCrossover(metasearch.LocalSearchApplication first, metasearch.LocalSearchApplication second) {
		int index = MathUtil.randomInteger(7);
		if (index >= 1) {
			// swap
			boolean temp = first.isLastSolution();
			first.setLastSolution(second.isLastSolution());
			second.setLastSolution(temp);
		}
		if (index >= 2) {
			// swap
			LocalSearchAlgorithm temp = first.getLocalsearchalgorithm();
			first.setLocalsearchalgorithm(second.getLocalsearchalgorithm());
			second.setLocalsearchalgorithm(temp);
			algorithmCrossover(first, second);
		}
		if (index >= 3) {
			// swap
			// swap
			double temp = first.getProbability();
			first.setProbability(second.getProbability());
			second.setProbability(temp);
		}
		if (index >= 4) {
			double temp = first.getStartAtEvalPerc();
			first.setStartAtEvalPerc(second.getStartAtEvalPerc());
			second.setStartAtEvalPerc(temp);
		}
		if (index >= 5) {
			int temp = first.getTournamentSize();
			first.setTournamentSize(second.getTournamentSize());
			second.setTournamentSize(temp);
		}
		if (index >= 6) {
			FitnessComparatorGenerator temp = first.getUsedGenerator();
			first.setUsedGenerator(second.getUsedGenerator());
			second.setUsedGenerator(temp);
		}
	}

	public void algorithmMutate(Algorithm alg) {
		if (alg instanceof MemeticAlgorithm) {
			algorithmMutate((MemeticAlgorithm) alg);
		} else if (alg instanceof GeneticAlgorithm) {
			algorithmMutate((GeneticAlgorithm) alg);
		} else if (alg instanceof LocalSearchAlgorithm) {
			algorithmMutate((LocalSearchAlgorithm) alg);
		} else if (alg instanceof IteratingAlgorithm) {
			algorithmMutate((IteratingAlgorithm) alg);
		}
	}

	public void algorithmMutate(MemeticAlgorithm alg) {
		if (MathUtil.randomDouble() < 0.1) {
			algorithmMutate(alg.getGlobalSearch());
		} else {
			if (MathUtil.randomDouble() < 0.05) {
				//Mutate local search
				int maxNrEvaluations = (this.alg.evaluationCount - this.alg.moea.getPopulationSize())
						/ this.alg.moea.getPopulationSize();
				// If evluated on 100%, you would use up all your evaluations ...
				double useEvaluationNmb = Math.random();
				useEvaluationNmb = 1.0 - useEvaluationNmb * useEvaluationNmb; // Use
				// 75%
				// for
				// local
				// search
				double factor = Math.min(10000, useEvaluationNmb / (1.0 - useEvaluationNmb));
				double thePercentValue = 16 * factor;
				alg.getLocalsearchapplication().getLocalsearchalgorithm().setNrEvaluations(Math.max(0, Math.min(maxNrEvaluations, (int) thePercentValue)));
			}
			algorithmMutate(alg.getLocalsearchapplication());
		}
	}
	
	public Algorithm createRandomIteratingAlgorithm() {
		IteratingAlgorithm ret = MetasearchFactory.eINSTANCE.createIteratingAlgorithm();
		LocalSearchAlgorithm sub = createRandomLocalSearchAlgorithm();
		ret.setAlgorithm(sub);
		ret.setFitnesscomparatorgenerator(createFitnessComparatorGenerator());
		ret.setSolutioninitializer(createRandomSolutionInitializer());
		double v = MathUtil.randomDouble();
		//0.5 = gleich hohe Zahl von runs und evaluations - beides sqrt(gesamtevaluations)
		double factor = v/(1.0-v);
		int nrEvaluations = (int)(factor*Math.sqrt(this.alg.evaluationCount));
		ret.getAlgorithm().setNrEvaluations(nrEvaluations);
		
		ret.setTournamentSize(Math.max(1, MathUtil.randomInteger(100) - 50));
		ret.setTournamentRemain(Math.max(0, MathUtil.randomInteger(200) - 100));
		return ret;
	}
	
	public FitnessComparatorGenerator createFitnessComparatorGenerator() {
		if (MathUtil.randomDouble() < 0.3) {
			return MetasearchFactory.eINSTANCE.createDecreasingMaximumComparatorGenerator();
		} else {
			return MetasearchFactory.eINSTANCE.createRandomWeightGenerator();
		}
	}

	public Algorithm createRandomMemeticAlgorithm() {
		MemeticAlgorithm ret = MetasearchFactory.eINSTANCE.createMemeticAlgorithm();
		NSGAIII global = MetasearchFactory.eINSTANCE.createNSGAIII();
		global.setMutateDelete(globalMutateDelete);
		global.setMutateModifyRule(globalMutateModify);
		global.setMutateReplaceRule(globalMutateChange);
		ret.setGlobalSearch(global);
		metasearch.LocalSearchApplication random = createRandomLSA();
		ret.setLocalsearchapplication(random);
		ret.setNrEvaluations(alg.evaluationCount);
		int maxNrEvaluations = (this.alg.evaluationCount - this.alg.moea.getPopulationSize())
				/ this.alg.moea.getPopulationSize();
		// If evluated on 100%, you would use up all your evaluations ...
		double useEvaluationNmb = Math.random();
		useEvaluationNmb = 1.0 - useEvaluationNmb * useEvaluationNmb; // Use
		// 75%
		// for
		// local
		// search
		double factor = Math.min(10000, useEvaluationNmb / (1.0 - useEvaluationNmb));
		double thePercentValue = 16 * factor;
		ret.getLocalsearchapplication().getLocalsearchalgorithm().setNrEvaluations(Math.max(0, Math.min(maxNrEvaluations, (int) thePercentValue)));
		return ret;
	}

	public metasearch.LocalSearchApplication createRandomLSA() {
		metasearch.LocalSearchApplication lsa = MetasearchFactory.eINSTANCE.createLocalSearchApplication();
		{
			double newProb = MathUtil.randomDouble(); // avg 0.5
			newProb *= newProb; // avg 0.25
			newProb *= newProb; // avg 0.0625
			lsa.setProbability(newProb);
		}
		{
			lsa.setLastSolution(MathUtil.randomDouble() < 0.3);
		}
		{
			double newProb = MathUtil.randomDouble();
			newProb *= newProb;
			lsa.setStartAtEvalPerc(newProb);
		}
		{
			lsa.setTournamentSize(Math.max(1, MathUtil.randomInteger(11) - 5));
		}
		{
			lsa.setUsedGenerator(createFitnessComparatorGenerator());
		}
		lsa.setLocalsearchalgorithm(createRandomLocalSearchAlgorithm());
		return lsa;
	}

	public void algorithmMutate(metasearch.LocalSearchApplication lsa) {
		if (MathUtil.randomDouble() < 0.2) {
			// Modify my properties
			int i = MathUtil.randomInteger(5);
			if (i == 0) {
				double newProb = MathUtil.randomDouble(); // avg 0.5
				newProb *= newProb; // avg 0.25
				newProb *= newProb; // avg 0.0625
				lsa.setProbability(newProb);
			} else if (i == 1) {
				lsa.setLastSolution(MathUtil.randomDouble() < 0.3);
			} else if (i == 2) {
				double newProb = MathUtil.randomDouble();
				newProb *= newProb;
				newProb = 1.0 - newProb;
				lsa.setStartAtEvalPerc(newProb);
			} else if (i == 3) {
				lsa.setTournamentSize(Math.max(1, MathUtil.randomInteger(11) - 5));
			} else if (i == 4) {
				if (MathUtil.randomDouble() < 0.3) {
					lsa.setUsedGenerator(MetasearchFactory.eINSTANCE.createDecreasingMaximumComparatorGenerator());
				} else {
					lsa.setUsedGenerator(MetasearchFactory.eINSTANCE.createRandomWeightGenerator());
				}
			}
		} else {
			if (MathUtil.randomDouble() < 0.05) {
				// Switch algorithm
				lsa.setLocalsearchalgorithm(createRandomLocalSearchAlgorithm());
			} else {
				algorithmMutate(lsa.getLocalsearchalgorithm());
			}
		}
	}

	public void algorithmMutate(GeneticAlgorithm alg) {
		// Don't mutate the Genetic algorithm
		if (true) {
			return;
		}
		int i = MathUtil.randomInteger(3);
		switch (i) {
		case 0:
			alg.setMutateDelete(MathUtil.randomDouble());
			break;
		case 1:
			alg.setMutateModifyRule(MathUtil.randomDouble());
			break;
		case 2:
			alg.setMutateReplaceRule(MathUtil.randomDouble());
			break;
		}
	}

	public void algorithmMutate(LocalSearchAlgorithm alg) {
		if (alg instanceof HillClimbing) {
			algorithmMutate((HillClimbing) alg);
		} else if (alg instanceof SimulatedAnnealing) {
			algorithmMutate((SimulatedAnnealing) alg);
		} else {
			System.err.println("Trying to modify unknown algorithm "+alg);
		}
	}

	public void algorithmMutate(Neighborhood nb) {
		if (nb instanceof ChangingNeighborhood) {
			ChangingNeighborhood ch = (ChangingNeighborhood) nb;
			int i = MathUtil.randomInteger(3);
			if (i == 0) {
				double prob = MathUtil.randomDouble();
				prob = 1.0 - prob * prob;
				ch.setAtEndProbability(prob);
			} else if (i == 1){
				double prob = MathUtil.randomDouble();
				prob = prob * prob * prob; // 0.125
				ch.setDeleteProbability(prob);
			} else {
				double prob = MathUtil.randomDouble();
				ch.setModifyRuleProbability(prob);
			}
		}
	}

	public LocalSearchAlgorithm createRandomLocalSearchAlgorithm() {
		ChangingNeighborhood ch = MetasearchFactory.eINSTANCE.createChangingNeighborhood();
		{
			double prob = MathUtil.randomDouble();
			prob = 1.0 - prob * prob;
			ch.setAtEndProbability(prob);
		}
		{
			double prob = MathUtil.randomDouble();
			prob = prob * prob * prob; // 0.125
			ch.setDeleteProbability(prob);
		}
		{
			double prob = MathUtil.randomDouble();
			ch.setModifyRuleProbability(prob);
		}
		if (MathUtil.randomDouble() < 0.3) {
			HillClimbing alg = MetasearchFactory.eINSTANCE.createHillClimbing();
			alg.setNeighborhood(ch);
			{
				int neighborSize = MathUtil.randomInteger(100);
				alg.setNeighborsize(neighborSize);
			}
			{
				alg.setNextImprovement(MathUtil.randomDouble() < 0.3);
			}
			{
				if (MathUtil.randomBoolean()) {
					alg.setTabuSize(0);
				} else {
					double random = MathUtil.randomDouble();
					random *= random;
					alg.setTabuSize((int) (random * (this.alg.solutionlength - 1)));
				}
			}
			{
				int maxNoImprovement = (int)Math.sqrt(MathUtil.randomInteger(1000000));
				alg.setMaxNoImprovement(maxNoImprovement);
			}
			return alg;
		} else {
			SimulatedAnnealing alg = MetasearchFactory.eINSTANCE.createSimulatedAnnealing();
			alg.setNeighborhood(ch);
			{
				int fakeNrEvaluations = alg.getNrEvaluations();
				if (fakeNrEvaluations == 0) {
					fakeNrEvaluations = 1000;
				}
				if (alg.getNrEvaluations() != 0 || MathUtil.randomDouble() < 0.7) {
					alg.setRestartNoBestImp((int) (fakeNrEvaluations * 1.2 * Math.random())+1);
				} else {
					alg.setRestartNoBestImp(Integer.MAX_VALUE);
				}
			}
			{
				int fakeNrEvaluations = alg.getNrEvaluations();
				if (fakeNrEvaluations == 0) {
					fakeNrEvaluations = 1000;
				}
				if (MathUtil.randomDouble() < 0.3 || alg.getNrEvaluations() == 0) {
					alg.setRestartNoCurrentImp(Integer.MAX_VALUE);
				} else {
					double prob = Math.random();
					prob *= prob;
					prob *= prob;
					alg.setRestartNoCurrentImp(((int) (fakeNrEvaluations * prob))+1);
				}
			}

			{
				if (MathUtil.randomBoolean()) {
					alg.setTabuSize(0);
				} else {
					double random = MathUtil.randomDouble();
					random *= random;
					alg.setTabuSize((int) (random * (this.alg.solutionlength - 1)));
				}
			}
			{
				if (MathUtil.randomDouble() < 0.1) {
					alg.setTempIncrease(0.0);
				} else {
					alg.setTempIncrease(Math.exp(-Math.random() * 10));
				}
			}
			{
				if (MathUtil.randomDouble() < 0.1) {
					alg.setStartTemp(0.0);
				} else {
					alg.setStartTemp(MathUtil.randomDouble());
				}
			}
			return alg;
		}
	}
	

	public void algorithmMutate(IteratingAlgorithm alg) {
		if (MathUtil.randomDouble() < 0.2) {
			//Modify myself
			int i = MathUtil.randomInteger(6);
			if (i == 0) {
				alg.setSolutioninitializer(createRandomSolutionInitializer());
			} else if (i == 1) {
				algorithmMutate(alg.getSolutioninitializer());
			} else if (i == 2) {
				double v = MathUtil.randomDouble();
				//0.5 = gleich hohe Zahl von runs und evaluations - beides sqrt(gesamtevaluations)
				double factor = v/(1.0-v);
				int nrEvaluations = (int)(factor*Math.sqrt(this.alg.evaluationCount));
				alg.getAlgorithm().setNrEvaluations(nrEvaluations);
			} else if (i == 4) {
				alg.setFitnesscomparatorgenerator(createFitnessComparatorGenerator());
			} else if (i == 5) {
				alg.setTournamentSize(Math.max(1, MathUtil.randomInteger(100) - 50));
			} else if (i == 6) {
				alg.setTournamentRemain(Math.max(0, MathUtil.randomInteger(200) - 100));
			}
		} else {
			if (MathUtil.randomDouble() < 0.05) {
				// Switch algorithm
				alg.setAlgorithm(createRandomLocalSearchAlgorithm());
			} else {
				algorithmMutate(alg.getAlgorithm());
			}
		}
		
	}
	
	public void algorithmMutate(SolutionInitializer initializer) {
		if (initializer instanceof RandomSolutionInitializer) {
			algorithmMutate((RandomSolutionInitializer)initializer);
		} else if (initializer instanceof DiscardingSolutionInitializer) {
			algorithmMutate((DiscardingSolutionInitializer)initializer);
		}
	}
	public void algorithmMutate(RandomSolutionInitializer initializer) {
		//No parameters
	}
	
	public SolutionInitializer createRandomSolutionInitializer() {
		if (Math.random() < 0.3) {
			return MetasearchFactory.eINSTANCE.createRandomSolutionInitializer();
		} else {
			DiscardingSolutionInitializer initializer = MetasearchFactory.eINSTANCE.createDiscardingSolutionInitializer();
			{
				double percentDrop = Math.random();
				percentDrop*= percentDrop;
				percentDrop*= Math.sqrt(Math.random());
				int drop = (int)(this.alg.evaluationCount*percentDrop);
				initializer.setNumInitSolutions(drop);
			} 
			{
				initializer.setNumQueues(1+MathUtil.randomInteger(20));
			}
			{
				double v = Math.random();
				v*=v;
				int consider = (int)(50*v*v+1);
				int use = MathUtil.randomInteger(consider)+1;
				initializer.setSolutionUseSize(use);
				initializer.setSolutionConsiderSize(consider);
			}
			{
				initializer.setSolutionsPerQueue(50+MathUtil.randomInteger(150));
			} 
			return initializer;
		}
	}
	
	public void algorithmMutate(DiscardingSolutionInitializer initializer) {
		int i = MathUtil.randomInteger(5);
		if (i == 0) {
			double percentDrop = Math.random();
			percentDrop*= percentDrop;
			int drop = (int)(this.alg.evaluationCount*percentDrop);
			initializer.setNumInitSolutions(drop);
		} else if (i == 1) {
			initializer.setNumQueues(1+MathUtil.randomInteger(20));
		} else if (i == 2) {
			double v = Math.random();
			v*=v;
			int consider = (int)(50*v*v+1);
			int use = MathUtil.randomInteger(consider)+1;
			initializer.setSolutionUseSize(use);
			initializer.setSolutionConsiderSize(consider);
		} else if (i == 3) {
			initializer.setSolutionsPerQueue(50+MathUtil.randomInteger(150));
		} 
	}

	public void algorithmMutate(HillClimbing alg) {
		int i = MathUtil.randomInteger(6);
		if (i == 0) {
			algorithmMutate(alg.getNeighborhood());
		} else if (i == 1) {
			int neighborSize = MathUtil.randomInteger(100);
			alg.setNeighborsize(neighborSize);
		} else if (i == 2) {
			alg.setNextImprovement(MathUtil.randomDouble() < 0.3);
		} else if (i == 3) {
			if (MathUtil.randomBoolean()) {
				alg.setTabuSize(0);
			} else {
				double random = MathUtil.randomDouble();
				random *= random;
				alg.setTabuSize((int) (random * (this.alg.solutionlength - 1)));
			}
		} else if (i == 4) {
			int maxNoImprovement = (int)Math.sqrt(MathUtil.randomInteger(1000000));
			alg.setMaxNoImprovement(maxNoImprovement);
		}
	}

	public void algorithmMutate(SimulatedAnnealing alg) {
		int i = MathUtil.randomInteger(6);
		if (i == 0) {
			algorithmMutate(alg.getNeighborhood());
		} else if (i == 1) {
			int fakeNrEvaluations = alg.getNrEvaluations();
			if (fakeNrEvaluations == 0) {
				fakeNrEvaluations = 1000;
			}
			if (alg.getNrEvaluations() != 0 || MathUtil.randomDouble() < 0.7) {
				alg.setRestartNoBestImp((int) (fakeNrEvaluations * 1.2 * Math.random())+1);
			} else {
				alg.setRestartNoBestImp(Integer.MAX_VALUE);
			}
		} else if (i == 2) {
			int fakeNrEvaluations = alg.getNrEvaluations();
			if (fakeNrEvaluations == 0) {
				fakeNrEvaluations = 1000;
			}
			if (MathUtil.randomDouble() < 0.3 || alg.getNrEvaluations() == 0) {
				alg.setRestartNoCurrentImp(Integer.MAX_VALUE);
			} else {
				double prob = Math.random();
				prob *= prob;
				prob *= prob;
				alg.setRestartNoCurrentImp(((int) (fakeNrEvaluations * prob))+1);
			}
		}  else if (i == 3) {
			if (MathUtil.randomBoolean()) {
				alg.setTabuSize(0);
			} else {
				double random = MathUtil.randomDouble();
				random *= random;
				alg.setTabuSize((int) (random * (this.alg.solutionlength - 1)));
			}
		} else if (i == 4) {
			if (MathUtil.randomDouble() < 0.1) {
				alg.setTempIncrease(0.0);
			} else {
				alg.setTempIncrease(Math.exp(-Math.random() * 10));
			}
		} else if (i == 5) {
			if (MathUtil.randomDouble() < 0.1) {
				alg.setStartTemp(0.0);
			} else {
				alg.setStartTemp(MathUtil.randomDouble());
			}
		}
	}

	public static String describe(GeneticAlgorithm alg) {
		return alg.getClass().getSimpleName() + ": " + alg.getNrEvaluations() + " Evaluations, "
				+ alg.getPopulationSize() + " population " + (100.0 * alg.getMutateDelete()) + "% delete, "
				+ (100 * alg.getMutateModifyRule()) + "% modify rule, " + (100 * alg.getMutateReplaceRule())
				+ "% change rule";
	}

	public static String describe(Neighborhood nbh) {
		if (nbh instanceof ChangingNeighborhood) {
			ChangingNeighborhood ch = (ChangingNeighborhood) nbh;
			return "Changing " + (100 * ch.getAtEndProbability()) + "% at end, " + (100 * ch.getDeleteProbability())
					+ "% delete";
		}
		return String.valueOf(nbh);
	}

	public static String describe(LocalSearchAlgorithm alg) {
		if (alg instanceof HillClimbing) {
			HillClimbing hc = (HillClimbing) alg;
			return "HillClimbing with " + hc.getNeighborsize() + " neighbors, " + hc.getNrEvaluations()
			+ " evaluations, " + hc.getTabuSize() + " tabu size, " + ", Neighborhood "
			+ describe(hc.getNeighborhood())+", "+hc.getMaxNoImprovement()+" no improvements";
		} else if (alg instanceof SimulatedAnnealing) {
			SimulatedAnnealing sa = (SimulatedAnnealing) alg;
			return "SimulatedAnnealing with " + sa.getNrEvaluations() + " evaluations, " + sa.getTabuSize()
			+ " tabu size, " + sa.getStartTemp() + " start temperature, " + sa.getTempIncrease()
			+ " temp increase, " + sa.getRestartNoBestImp() + " restart no best imp,"
			+ sa.getRestartNoCurrentImp() + " restart no current imp, " + ", Neighborhood "
			+ describe(sa.getNeighborhood());
		}
		return String.valueOf(alg);
	}

	public static String describe(MemeticAlgorithm alg) {
		return "Memetic with Global Search " + describe(alg.getGlobalSearch()) + " and Local Search Application "
				+ describe(alg.getLocalsearchapplication());
	}

	public static String describe(metasearch.LocalSearchApplication lsa) {
		return "with probability " + lsa.getProbability() + ", start at " + lsa.getStartAtEvalPerc()
		+ ", tournament size " + lsa.getTournamentSize() + ", fitness generator " + lsa.getUsedGenerator()
		+ ", do: " + lsa.getLocalsearchalgorithm();
	}
	
	public static String describe(SolutionInitializer initializer) {
		if (initializer instanceof RandomSolutionInitializer) {
			return "Random";
		} else if (initializer instanceof DiscardingSolutionInitializer) {
			DiscardingSolutionInitializer dsi = (DiscardingSolutionInitializer)initializer;
			return "Discarding with " + dsi.getNumInitSolutions()+" init solutions, "+dsi.getNumQueues()+" queues, "+
					dsi.getSolutionConsiderSize()+"/"+dsi.getSolutionUseSize()+" considered solutions, "+
			dsi.getSolutionsPerQueue()+" solutions per queue";
		} else {
			return String.valueOf(initializer);
		}
	}
	
	public static String describe(IteratingAlgorithm alg) {
		return "Iterating with "+alg.getNrEvaluations()+" evaluations, "+alg.getTournamentSize()+"/"+alg.getTournamentRemain()+" tournament  initializer "+describe(alg.getSolutioninitializer())+", local search " + describe(alg.getAlgorithm());
	}

	public static String describe(Algorithm alg) {
		if (alg instanceof GeneticAlgorithm) {
			return describe((GeneticAlgorithm) alg);
		} else if (alg instanceof LocalSearchAlgorithm) {
			return describe((LocalSearchAlgorithm) alg);
		} else if (alg instanceof MemeticAlgorithm) {
			return describe((MemeticAlgorithm) alg);
		} else if (alg instanceof IteratingAlgorithm){
			return describe((IteratingAlgorithm)alg);
		} else {
			return "UNknown algorithm " + alg;
		}
	}
}