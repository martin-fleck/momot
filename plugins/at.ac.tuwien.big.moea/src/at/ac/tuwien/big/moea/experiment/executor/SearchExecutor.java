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
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.algorithm.AlgorithmTerminationException;
import org.moeaframework.algorithm.Checkpoints;
import org.moeaframework.core.Algorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Problem;
import org.moeaframework.core.comparator.ParetoDominanceComparator;
import org.moeaframework.core.spi.AlgorithmFactory;
import org.moeaframework.core.spi.ProblemFactory;
import org.moeaframework.util.TypedProperties;
import org.moeaframework.util.distributed.DistributedProblem;
import org.moeaframework.util.progress.ProgressHelper;
import org.moeaframework.util.progress.ProgressListener;

import at.ac.tuwien.big.moea.problem.ISearchProblem;
import at.ac.tuwien.big.moea.problem.SearchProblem;
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm;
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
	
	public Problem getProblem() {
		Method getProblemMethod;
		try {
			getProblemMethod = getClass().getSuperclass().getSuperclass().getDeclaredMethod("getProblemInstance");
			getProblemMethod.setAccessible(true);
			return CastUtil.asClass(getProblemMethod.invoke(this), Problem.class);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			return null;
		}
	}
	
	protected NondominatedPopulation runAlgorithm(Problem problem, int maxEvaluations) {		
		NondominatedPopulation result = newArchivePopulation();
		try {
			Algorithm algorithm = createAlgorithm(problem);
			
			while (!algorithm.isTerminated() && 
					algorithm.getNumberOfEvaluations() < maxEvaluations &&
					!isCanceled()) {
				algorithm.step();
				getProgressHelper().setCurrentNFE(algorithm.getNumberOfEvaluations());
			}

			result.addAll(algorithm.getResult());
		} finally {
			if (algorithm != null && !algorithm.isTerminated()) {
				algorithm.terminate();
			}
		}
		return result;
	}
	
	@Override
	protected NondominatedPopulation runSingleSeed(int seed, int numberOfSeeds,	int maxEvaluations) {
		if (getAlgorithmName() == null)
			throw new IllegalArgumentException("No algorithm specified");
		
		Problem problem = null;
		ExecutorService executorService = null;
		
		try {
			problem = getProblem();			
			try {
				if (getExecutorService() != null) {
					problem = new DistributedProblem(problem, getExecutorService());
				} else if (getNumberOfThreads() > 1) {
					executorService = Executors.newFixedThreadPool(getNumberOfThreads());
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
