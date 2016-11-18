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
package at.ac.tuwien.big.moea.experiment.executor;

import java.io.File;

import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.algorithm.AbstractAlgorithm;
import org.moeaframework.algorithm.AlgorithmTerminationException;
import org.moeaframework.algorithm.Checkpoints;
import org.moeaframework.algorithm.PeriodicAction;
import org.moeaframework.analysis.collector.InstrumentedAlgorithm;
import org.moeaframework.core.Algorithm;
import org.moeaframework.core.EvolutionaryAlgorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variation;
import org.moeaframework.core.comparator.ParetoDominanceComparator;
import org.moeaframework.core.operator.CompoundVariation;
import org.moeaframework.core.spi.AlgorithmFactory;
import org.moeaframework.core.spi.ProblemFactory;
import org.moeaframework.util.TypedProperties;
import org.moeaframework.util.distributed.DistributedProblem;
import org.moeaframework.util.progress.ProgressHelper;
import org.moeaframework.util.progress.ProgressListener;

import at.ac.tuwien.big.moea.problem.IParetoFrontStoringSearchProblem;
import at.ac.tuwien.big.moea.problem.ISearchProblem;
import at.ac.tuwien.big.moea.problem.SearchProblem;
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication;
import at.ac.tuwien.big.moea.search.algorithm.provider.DynamicAlgorithmFactory;
import at.ac.tuwien.big.moea.util.CastUtil;

/**
 * An executor class that is based on the existing MOEA {@link Executor} and 
 * modified in a way that single execution runs can also be cancelled.
 */
public class SearchExecutor extends Executor {
	
	protected String name;
	protected Algorithm algorithm;
	protected Map<String, Field> reflectiveFields = new HashMap<>();
	
	private static final String ALGORITHM_NAME = "algorithmName";
	private static final String PROPERTIES_NAME = "properties";
	private static final String THREADS_NAME = "numberOfThreads";
	private static final String EXECUTOR_SERVICE_NAME = "executorService";
	private static final String CHECKPOINT_FILE_NAME = "checkpointFile";
	private static final String CHECKPOINT_FREQUENCY_NAME = "checkpointFrequency";
	private static final String ALGORITHM_FACTORY_NAME = "algorithmFactory";
	private static final String PROGRESSHELPER_NAME = "progress";
	private static final String ISCANCELED_NAME = "isCanceled";
	
	public static final boolean EVAL_MEMORY = true;
	
	public static final int MAX_SOLUTIONS = 200;
	
	public SearchExecutor() {
		Field[] fields = getClass().getSuperclass().getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			reflectiveFields.put(field.getName(), field);
		}
	}
	
	public SearchExecutor(ISearchProblem<?> problem) {
		this();
		withProblem(problem);
	}
	
	public SearchExecutor(String name) {
		this();
		setName(name);
	}
	
	public SearchExecutor(String name, SearchProblem<?> problem) {
		this();
		setName(name);
		withProblem(problem);
	}
	
	public SearchExecutor setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getName() {
		if(name == null && getAlgorithm() != null)
			return getAlgorithm().getClass().getSimpleName();
		return name;
	}
	
	public SearchExecutor withProblem(ISearchProblem<?> problem) {
		super.withProblemClass(problem.getClass(), problem.getFitnessFunction(), problem.getSolutionGenerator());
		return this;
	}
	
	protected <T> T getField(String fieldName, Class<T> clazz, T defaultValue) {
		try {
			return CastUtil.asClass(reflectiveFields.get(fieldName).get(this), clazz);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			return defaultValue;
		}
	}
	
	protected <T> void setField(String fieldName, T obj) {
		try {
			reflectiveFields.get(fieldName).set(this, obj);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	protected <T> T getField(String fieldName, Class<T> clazz) {
		try {
			return CastUtil.asClass(reflectiveFields.get(fieldName).get(this), clazz);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected String getAlgorithmName() {
		return getField(ALGORITHM_NAME, String.class, "<no-algorithm-name>");
	}
	
	protected TypedProperties getTypedProperties() {
		return getField(PROPERTIES_NAME, TypedProperties.class);
	}
	
	protected AlgorithmFactory getAlgorithmFactory() {
		return getField(ALGORITHM_FACTORY_NAME, AlgorithmFactory.class);
	}
	
	protected File getCheckpointFile() {
		return getField(CHECKPOINT_FILE_NAME, File.class);
	}
	
	protected int getCheckpointFrequency() {
		return getField(CHECKPOINT_FREQUENCY_NAME, Integer.class, 0);
	}
	
	protected ProgressHelper getProgressHelper() {
		return getField(PROGRESSHELPER_NAME, ProgressHelper.class);
	}
	
	protected int getNumberOfThreads() {
		return getField(THREADS_NAME, Integer.class, 1);
	}
	
	protected ExecutorService getExecutorService() {
		return getField(EXECUTOR_SERVICE_NAME, ExecutorService.class);
	}
	
	protected void setExecutorService(ExecutorService service) {
		setField(EXECUTOR_SERVICE_NAME, service);
	}
	
	protected AtomicBoolean getCanceled() {
		return getField(ISCANCELED_NAME, AtomicBoolean.class);
	}
	
	protected void setCanceled(boolean cancel) {
		try {
			AtomicBoolean isCanceled = CastUtil.asClass(reflectiveFields.get(ISCANCELED_NAME).get(this), AtomicBoolean.class);
			isCanceled.set(cancel);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public Algorithm getAlgorithm() {
		AlgorithmFactory factory = getAlgorithmFactory();
		if(factory == null)
			factory = new DynamicAlgorithmFactory();
		
		Algorithm algorithm = factory.getAlgorithm(
				getAlgorithmName(), 
				getTypedProperties().getProperties(), 
				getProblem());
		
		return algorithm;
	}
	
	protected Algorithm createAlgorithm(Problem problem) {	
		Algorithm algorithm = getAlgorithm();

		if (getCheckpointFile() != null) 
			algorithm = new Checkpoints(
					algorithm, 
					getCheckpointFile(),
					getCheckpointFrequency());
		
		if (getInstrumenter() != null) 
			algorithm = getInstrumenter().instrument(algorithm);		
		return algorithm;
	}
	
	protected NondominatedPopulation newArchivePopulation() {
		NondominatedPopulation result;
		try {
			Method newArchiveMethod = getClass().getSuperclass().getSuperclass().getDeclaredMethod("newArchive");
			newArchiveMethod.setAccessible(true);
			result = CastUtil.asClass(newArchiveMethod.invoke(this), NondominatedPopulation.class);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			result = new NondominatedPopulation(new ParetoDominanceComparator());
		}
		return result;
	}
	
	MethodHandle problemHandle = null;
	
	public Problem getProblem() {
		if (problemHandle == null) {
			Class<?> cur = getClass();
			while (cur != null) {
				try {
					Method m = cur.getDeclaredMethod("getProblemInstance");;
					if (m != null) {
						m.setAccessible(true);
						problemHandle = MethodHandles.lookup().unreflect(m);
						break;
					}
				} catch (NoSuchMethodException | IllegalAccessException e) {}
				cur = cur.getSuperclass();
			}
		}
		try {
			return CastUtil.asClass(problemHandle.invoke(this),Problem.class);
		} catch (Throwable e) {
			 e.printStackTrace();
			return null;
		}
	}
	
	private List<List<NondominatedPopulation>> allResultList = new ArrayList<List<NondominatedPopulation>>();
	private List<Long> peakMemory = new ArrayList<Long>();
	
	public List<Long> getPeakMemory() {
		return peakMemory;
	}
	
	public List<List<NondominatedPopulation>> getResultListsPerRun() {
		return allResultList;
	}
	
	private static MethodHandle subVariations = null;
	static {
		try {
			Field field = CompoundVariation.class.getDeclaredField("operators");
			field.setAccessible(true);
			subVariations = MethodHandles.lookup().unreflectGetter(field);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	public List<Variation> getSubVariations(CompoundVariation var)  {
		try {
			return (List<Variation>)subVariations.invoke(var);
		} catch (Throwable e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	
	private static MethodHandle setNumberOfEvaluations;
	{
		try {
			Field f = AbstractAlgorithm.class.getDeclaredField("numberOfEvaluations");
			f.setAccessible(true);
			setNumberOfEvaluations = MethodHandles.lookup().unreflectSetter(f);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	
	public void updateNumberOfEvaluations(Variation var, AbstractAlgorithm alg) {
		if (var instanceof CompoundVariation) {
			CompoundVariation cv = (CompoundVariation)var;
			for (Variation v: getSubVariations(cv)) {
				updateNumberOfEvaluations(v, alg);
			}
		} else if (var instanceof LocalSearchApplication) {
			int eval = ((LocalSearchApplication) var).pollNumberOfEvaluations();
			if (eval != 0) {
				try {
					setNumberOfEvaluations.invoke(alg, alg.getNumberOfEvaluations()+eval);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void initLSA(Variation var, AbstractAlgorithm alg) {
		if (var instanceof CompoundVariation) {
			CompoundVariation cv = (CompoundVariation)var;
			for (Variation v: getSubVariations(cv)) {
				initLSA(v, alg);
			}
		} else if (var instanceof LocalSearchApplication) {
			((LocalSearchApplication) var).init();
		}
	}

	
	private int lastIntermediateDistinctSize = 0;
	private int weedMod = 1;
	
	protected NondominatedPopulation runAlgorithm(Problem problem, int maxEvaluations) {
		
		lastIntermediate = new ArrayList<NondominatedPopulation>();
		allResultList.add(lastIntermediate);
		this.lastIntermediateDistinctSize = 0;
		long peekMemory = 0;
		long gcTime = 0;
		long startMemory = 0;
		if (EVAL_MEMORY) {
			long startTime = new Date().getTime();
			for (int i = 0; i < 4; ++i) {
				System.gc();
			}
			startMemory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		}
		long totalStart = new Date().getTime();
		weedMod = 1;
		NondominatedPopulation result = newArchivePopulation();
	
		try {
			Algorithm algorithm = createAlgorithm(problem);
			Algorithm delegate = algorithm;
			while (delegate instanceof PeriodicAction) {
				Field field = PeriodicAction.class.getDeclaredField("algorithm");
				field.setAccessible(true);
				delegate = (Algorithm)field.get(delegate);
			}
			MethodHandle handle = null;
			Class<?> cl = delegate.getClass();
			while (cl != null) {
				try {
					Field field = cl.getDeclaredField("variation");
					if (field != null) {
						field.setAccessible(true);
						if (Variation.class.isAssignableFrom(field.getType())) {
							handle = MethodHandles.lookup().unreflectGetter(field);
						}
					}
				} catch (Exception e) {
					
				}
				cl = cl.getSuperclass();
			}
			if (handle != null && delegate instanceof AbstractAlgorithm) {
				try {
					Variation var = (Variation) handle.invoke(delegate);
					initLSA(var, (AbstractAlgorithm)delegate);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int myInd = 0;
			int nextEvalCount = maxEvaluations/100;
			int ememind = 1;
			while (!algorithm.isTerminated() && 
					algorithm.getNumberOfEvaluations() < maxEvaluations &&
					!isCanceled()) {
				long curTime = new Date().getTime();
				algorithm.step();
				if (EVAL_MEMORY && algorithm.getNumberOfEvaluations() > nextEvalCount) {
					long startTime = new Date().getTime();
					nextEvalCount = (++ememind)*maxEvaluations/100;
					for (int i = 0; i < 4; ++i) {
						System.gc();
					}
					long memoryUsed = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
					peekMemory = Math.max(peekMemory, memoryUsed);
					long gcDuration = new Date().getTime()-startTime;
					gcTime+= gcDuration;
				}
				NondominatedPopulation intermediateResult = algorithm.getResult();
				for (Solution sol: intermediateResult) {
					//System.out.println("Nondominated "+ Arrays.toString(sol.getObjectives())+": "+sol);
				}
				NondominatedPopulation newPop = new NondominatedPopulation();
				for (Solution sol: intermediateResult) {
					newPop.add(new Solution(sol.getObjectives()));
				}
				if (handle != null && delegate instanceof AbstractAlgorithm) {
					try {
						Variation var = (Variation) handle.invoke(delegate);
						updateNumberOfEvaluations(var, (AbstractAlgorithm)delegate);
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				synchronized (lastIntermediate) {
					if (myInd%weedMod == 0) {
						lastIntermediate.add(newPop);
						++this.lastIntermediateDistinctSize;
						if (lastIntermediateDistinctSize >= MAX_SOLUTIONS*2) {
							//Weed out every 2nd
							weedMod*=2;
							List<NondominatedPopulation> newLastItermediate = new ArrayList<NondominatedPopulation>();
							int lastIntermediateDistinctSize = 0;
							for (int i = 0; i < lastIntermediate.size(); i+=2) {
								NondominatedPopulation add;
								if (i+1 >= lastIntermediate.size()) {
									//System.err.println("Strange intermediate size: "+lastIntermediate.size());
									add = lastIntermediate.get(lastIntermediate.size()-1);
								} else {
									add = lastIntermediate.get(i%4==0?i:i+1);
								}
								newLastItermediate.add(add);
								newLastItermediate.add(add);
								++lastIntermediateDistinctSize;
							}
							this.lastIntermediateDistinctSize = lastIntermediateDistinctSize;
							lastIntermediate.clear();
							lastIntermediate.addAll(newLastItermediate);
						}
					}
					
				}
				++myInd;
				//System.out.println("Step took " + (new Date().getTime()-curTime)+" ms");
				getProgressHelper().setCurrentNFE(algorithm.getNumberOfEvaluations());
			}
			result.addAll(algorithm.getResult());
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (algorithm != null && !algorithm.isTerminated()) {
				algorithm.terminate();
			}
			if (EVAL_MEMORY) {
				peakMemory.add(peekMemory-startMemory);
				System.out.println("Peak Memory Usage: " + (peekMemory-startMemory));
				System.out.println("GC Time: " + gcTime);
			}
		}
		return result;
	}
	
	private List<NondominatedPopulation> lastIntermediate = new ArrayList<NondominatedPopulation>();
	
	public List<NondominatedPopulation> getPopulationByIndex() {
		return lastIntermediate;
	}
	
	@Override
	public NondominatedPopulation runSingleSeed(int seed, int numberOfSeeds,	int maxEvaluations) {
		if (getAlgorithmName() == null)
			throw new IllegalArgumentException("No algorithm specified");
		
		System.gc();
		System.gc(); //Twice because that is needed sometimes (in fact, it can be an unlimited number, but we only want to delete as much as we can)
		
		lastIntermediate = new ArrayList<NondominatedPopulation>();
		Problem problem = null;
		ExecutorService executorService = null;
		
		try {
			problem = getProblem();			
			try {
				if (getExecutorService() != null) {
					problem = new DistributedProblem(problem, getExecutorService());
				} else if (getNumberOfThreads() > 1) {
					executorService = Executors.newFixedThreadPool(getNumberOfThreads());
					setExecutorService(executorService);
					problem = new DistributedProblem(problem, getExecutorService());
				}
				
				return runAlgorithm(problem, maxEvaluations);
			} catch(AlgorithmTerminationException e) {
				System.err.println(e.getMessage());
				return null;
			} finally {
				if (executorService != null) 
					executorService.shutdown();
			}
		} catch (SecurityException | IllegalArgumentException ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
			return null;
		} finally {
			if (problem != null) 
				problem.close();
		}
	}
	
	public void terminateRun() {
		if(algorithm != null && !algorithm.isTerminated())
			algorithm.terminate();
	}
	
	public <A extends Algorithm> SearchExecutor withAlgorithm(final A algorithm) {
		return withAlgorithm(new RegisteredAlgorithm<A>() {
			@Override
			public A createAlgorithm() {
				return algorithm;
			}				
		}.register());
	}
	
	@Override
	public NondominatedPopulation run() {
		setCanceled(false);
		int maxEvaluations = getTypedProperties().getInt("maxEvaluations", 25000);
		getProgressHelper().start(1, maxEvaluations);
		NondominatedPopulation population = runSingleSeed(1, 1, maxEvaluations);
		getProgressHelper().stop();
		return population;
	}
	
	@Override
	public SearchExecutor withMaxEvaluations(int maxEvaluations) {
		return (SearchExecutor) super.withMaxEvaluations(maxEvaluations);
	}
	
	@Override
	public SearchExecutor distributeOnAllCores() {
		return (SearchExecutor) super.distributeOnAllCores();
	}
	
	@Override
	public SearchExecutor withAlgorithm(String algorithmName) {
		return (SearchExecutor) super.withAlgorithm(algorithmName);
	}
	
	@Override
	public SearchExecutor withCheckpointFile(File checkpointFile) {
		return (SearchExecutor) super.withCheckpointFile(checkpointFile);
	}
	
	@Override
	public SearchExecutor withCheckpointFrequency(int checkpointFrequency) {
		return (SearchExecutor) super.withCheckpointFrequency(checkpointFrequency);
	}
	
	@Override
	public SearchExecutor withEpsilon(double... epsilon) {
		return (SearchExecutor) super.withEpsilon(epsilon);
	}
	
	@Override
	public SearchExecutor withInstrumenter(Instrumenter instrumenter) {
		return (SearchExecutor) super.withInstrumenter(instrumenter);
	}
	
	@Override
	public SearchExecutor withProblem(String problemName) {
		return (SearchExecutor) super.withProblem(problemName);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#usingAlgorithmFactory(org.moeaframework.core.spi.AlgorithmFactory)
	 */
	@Override
	public SearchExecutor usingAlgorithmFactory(AlgorithmFactory algorithmFactory) {
		return (SearchExecutor) super.usingAlgorithmFactory(algorithmFactory);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#usingProblemFactory(org.moeaframework.core.spi.ProblemFactory)
	 */
	@Override
	public SearchExecutor usingProblemFactory(ProblemFactory problemFactory) {
		return (SearchExecutor) super.usingProblemFactory(problemFactory);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProblemClass(java.lang.Class, java.lang.Object[])
	 */
	@Override
	public SearchExecutor withProblemClass(Class<?> problemClass,
			Object... problemArguments) {
		return (SearchExecutor) super.withProblemClass(problemClass, problemArguments);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProblemClass(java.lang.String, java.lang.Object[])
	 */
	@Override
	public SearchExecutor withProblemClass(String problemClassName,
			Object... problemArguments) throws ClassNotFoundException {
		return (SearchExecutor) super.withProblemClass(problemClassName, problemArguments);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#distributeWith(java.util.concurrent.ExecutorService)
	 */
	@Override
	public SearchExecutor distributeWith(ExecutorService executorService) {
		return (SearchExecutor) super.distributeWith(executorService);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#distributeOn(int)
	 */
	@Override
	public SearchExecutor distributeOn(int numberOfThreads) {
		return (SearchExecutor) super.distributeOn(numberOfThreads);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#checkpointEveryIteration()
	 */
	@Override
	public SearchExecutor checkpointEveryIteration() {
		return (SearchExecutor) super.checkpointEveryIteration();
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#resetCheckpointFile()
	 */
	@Override
	public SearchExecutor resetCheckpointFile() throws IOException {
		return (SearchExecutor) super.resetCheckpointFile();
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public SearchExecutor withProperty(String key, String value) {
		return (SearchExecutor) super.withProperty(key, value);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, float)
	 */
	@Override
	public SearchExecutor withProperty(String key, float value) {
		return (SearchExecutor) super.withProperty(key, value);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, double)
	 */
	@Override
	public SearchExecutor withProperty(String key, double value) {
		return (SearchExecutor) super.withProperty(key, value);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, byte)
	 */
	@Override
	public SearchExecutor withProperty(String key, byte value) {
		return (SearchExecutor) super.withProperty(key, value);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, short)
	 */
	@Override
	public SearchExecutor withProperty(String key, short value) {
		return (SearchExecutor) super.withProperty(key, value);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, int)
	 */
	@Override
	public SearchExecutor withProperty(String key, int value) {
		return (SearchExecutor) super.withProperty(key, value);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, long)
	 */
	@Override
	public SearchExecutor withProperty(String key, long value) {
		return (SearchExecutor) super.withProperty(key, value);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, boolean)
	 */
	@Override
	public SearchExecutor withProperty(String key, boolean value) {
		return (SearchExecutor) super.withProperty(key, value);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, java.lang.String[])
	 */
	@Override
	public SearchExecutor withProperty(String key, String[] values) {
		return (SearchExecutor) super.withProperty(key, values);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, float[])
	 */
	@Override
	public SearchExecutor withProperty(String key, float[] values) {
		return (SearchExecutor) super.withProperty(key, values);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, double[])
	 */
	@Override
	public SearchExecutor withProperty(String key, double[] values) {
		return (SearchExecutor) super.withProperty(key, values);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, byte[])
	 */
	@Override
	public SearchExecutor withProperty(String key, byte[] values) {
		return (SearchExecutor) super.withProperty(key, values);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, short[])
	 */
	@Override
	public SearchExecutor withProperty(String key, short[] values) {
		return (SearchExecutor) super.withProperty(key, values);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, int[])
	 */
	@Override
	public SearchExecutor withProperty(String key, int[] values) {
		return (SearchExecutor) super.withProperty(key, values);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperty(java.lang.String, long[])
	 */
	@Override
	public SearchExecutor withProperty(String key, long[] values) {
		return (SearchExecutor) super.withProperty(key, values);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#clearProperties()
	 */
	@Override
	public SearchExecutor clearProperties() {
		return (SearchExecutor) super.clearProperties();
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProperties(java.util.Properties)
	 */
	@Override
	public SearchExecutor withProperties(Properties properties) {
		return (SearchExecutor) super.withProperties(properties);
	}

	/* (non-Javadoc)
	 * @see org.moeaframework.Executor#withProgressListener(org.moeaframework.util.progress.ProgressListener)
	 */
	@Override
	public SearchExecutor withProgressListener(ProgressListener listener) {
		return (SearchExecutor) super.withProgressListener(listener);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "['" + getName() + "']";
	}
}
