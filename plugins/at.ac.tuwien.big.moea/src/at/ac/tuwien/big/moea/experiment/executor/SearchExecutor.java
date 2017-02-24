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

import at.ac.tuwien.big.moea.problem.ISearchProblem;
import at.ac.tuwien.big.moea.problem.SearchProblem;
import at.ac.tuwien.big.moea.search.algorithm.provider.AbstractRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.provider.DynamicAlgorithmFactory;
import at.ac.tuwien.big.moea.util.CastUtil;

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

/**
 * An executor class that is based on the existing MOEA {@link Executor} and
 * modified in a way that single execution runs can also be cancelled.
 */
public class SearchExecutor extends Executor {

   private static final String ALGORITHM_NAME = "algorithmName";
   private static final String PROPERTIES_NAME = "properties";
   private static final String THREADS_NAME = "numberOfThreads";

   private static final String EXECUTOR_SERVICE_NAME = "executorService";
   private static final String CHECKPOINT_FILE_NAME = "checkpointFile";
   private static final String CHECKPOINT_FREQUENCY_NAME = "checkpointFrequency";
   private static final String ALGORITHM_FACTORY_NAME = "algorithmFactory";
   private static final String PROGRESSHELPER_NAME = "progress";
   private static final String ISCANCELED_NAME = "isCanceled";
   protected String name;
   protected Algorithm algorithm;
   protected Map<String, Field> reflectiveFields = new HashMap<>();

   public SearchExecutor() {
      final Field[] fields = getClass().getSuperclass().getDeclaredFields();
      for(final Field field : fields) {
         field.setAccessible(true);
         reflectiveFields.put(field.getName(), field);
      }
   }

   public SearchExecutor(final ISearchProblem<?> problem) {
      this();
      withProblem(problem);
   }

   public SearchExecutor(final String name) {
      this();
      setName(name);
   }

   public SearchExecutor(final String name, final SearchProblem<?> problem) {
      this();
      setName(name);
      withProblem(problem);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#checkpointEveryIteration()
    */
   @Override
   public SearchExecutor checkpointEveryIteration() {
      return (SearchExecutor) super.checkpointEveryIteration();
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#clearProperties()
    */
   @Override
   public SearchExecutor clearProperties() {
      return (SearchExecutor) super.clearProperties();
   }

   protected Algorithm createAlgorithm(final Problem problem) {
      Algorithm algorithm = getAlgorithm();

      if(getCheckpointFile() != null) {
         algorithm = new Checkpoints(algorithm, getCheckpointFile(), getCheckpointFrequency());
      }

      if(getInstrumenter() != null) {
         algorithm = getInstrumenter().instrument(algorithm);
      }
      return algorithm;
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#distributeOn(int)
    */
   @Override
   public SearchExecutor distributeOn(final int numberOfThreads) {
      return (SearchExecutor) super.distributeOn(numberOfThreads);
   }

   @Override
   public SearchExecutor distributeOnAllCores() {
      return (SearchExecutor) super.distributeOnAllCores();
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#distributeWith(java.util.concurrent.ExecutorService)
    */
   @Override
   public SearchExecutor distributeWith(final ExecutorService executorService) {
      return (SearchExecutor) super.distributeWith(executorService);
   }

   public Algorithm getAlgorithm() {
      AlgorithmFactory factory = getAlgorithmFactory();
      if(factory == null) {
         factory = new DynamicAlgorithmFactory();
      }

      final Algorithm algorithm = factory.getAlgorithm(getAlgorithmName(), getTypedProperties().getProperties(),
            getProblem());

      return algorithm;
   }

   protected AlgorithmFactory getAlgorithmFactory() {
      return getField(ALGORITHM_FACTORY_NAME, AlgorithmFactory.class);
   }

   protected String getAlgorithmName() {
      return getField(ALGORITHM_NAME, String.class, "<no-algorithm-name>");
   }

   protected AtomicBoolean getCanceled() {
      return getField(ISCANCELED_NAME, AtomicBoolean.class);
   }

   protected File getCheckpointFile() {
      return getField(CHECKPOINT_FILE_NAME, File.class);
   }

   protected int getCheckpointFrequency() {
      return getField(CHECKPOINT_FREQUENCY_NAME, Integer.class, 0);
   }

   protected ExecutorService getExecutorService() {
      return getField(EXECUTOR_SERVICE_NAME, ExecutorService.class);
   }

   protected <T> T getField(final String fieldName, final Class<T> clazz) {
      try {
         return CastUtil.asClass(reflectiveFields.get(fieldName).get(this), clazz);
      } catch(IllegalArgumentException | IllegalAccessException e) {
         e.printStackTrace();
         return null;
      }
   }

   protected <T> T getField(final String fieldName, final Class<T> clazz, final T defaultValue) {
      try {
         return CastUtil.asClass(reflectiveFields.get(fieldName).get(this), clazz);
      } catch(IllegalArgumentException | IllegalAccessException e) {
         e.printStackTrace();
         return defaultValue;
      }
   }

   public String getName() {
      if(name == null && getAlgorithm() != null) {
         return getAlgorithm().getClass().getSimpleName();
      }
      return name;
   }

   protected int getNumberOfThreads() {
      return getField(THREADS_NAME, Integer.class, 1);
   }

   public Problem getProblem() {
      Method getProblemMethod;
      try {
         getProblemMethod = getClass().getSuperclass().getSuperclass().getDeclaredMethod("getProblemInstance");
         getProblemMethod.setAccessible(true);
         return CastUtil.asClass(getProblemMethod.invoke(this), Problem.class);
      } catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
            | SecurityException e) {
         return null;
      }
   }

   protected ProgressHelper getProgressHelper() {
      return getField(PROGRESSHELPER_NAME, ProgressHelper.class);
   }

   protected TypedProperties getTypedProperties() {
      return getField(PROPERTIES_NAME, TypedProperties.class);
   }

   protected NondominatedPopulation newArchivePopulation() {
      NondominatedPopulation result;
      try {
         final Method newArchiveMethod = getClass().getSuperclass().getSuperclass().getDeclaredMethod("newArchive");
         newArchiveMethod.setAccessible(true);
         result = CastUtil.asClass(newArchiveMethod.invoke(this), NondominatedPopulation.class);
      } catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
            | SecurityException e) {
         result = new NondominatedPopulation(new ParetoDominanceComparator());
      }
      return result;
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#resetCheckpointFile()
    */
   @Override
   public SearchExecutor resetCheckpointFile() throws IOException {
      return (SearchExecutor) super.resetCheckpointFile();
   }

   @Override
   public NondominatedPopulation run() {
      setCanceled(false);
      final int maxEvaluations = getTypedProperties().getInt("maxEvaluations", 25000);
      getProgressHelper().start(1, maxEvaluations);
      final NondominatedPopulation population = runSingleSeed(1, 1, maxEvaluations);
      getProgressHelper().stop();
      return population;
   }

   protected NondominatedPopulation runAlgorithm(final Problem problem, final int maxEvaluations) {
      final NondominatedPopulation result = newArchivePopulation();
      try {
         final Algorithm algorithm = createAlgorithm(problem);

         while(!algorithm.isTerminated() && algorithm.getNumberOfEvaluations() < maxEvaluations && !isCanceled()) {
            algorithm.step();
            getProgressHelper().setCurrentNFE(algorithm.getNumberOfEvaluations());
         }

         result.addAll(algorithm.getResult());
      } finally {
         if(algorithm != null && !algorithm.isTerminated()) {
            algorithm.terminate();
         }
      }
      return result;
   }

   @Override
   protected NondominatedPopulation runSingleSeed(final int seed, final int numberOfSeeds, final int maxEvaluations) {
      if(getAlgorithmName() == null) {
         throw new IllegalArgumentException("No algorithm specified");
      }

      Problem problem = null;
      ExecutorService executorService = null;

      try {
         problem = getProblem();
         try {
            if(getExecutorService() != null) {
               problem = new DistributedProblem(problem, getExecutorService());
            } else if(getNumberOfThreads() > 1) {
               executorService = Executors.newFixedThreadPool(getNumberOfThreads());
               problem = new DistributedProblem(problem, executorService);
            }

            return runAlgorithm(problem, maxEvaluations);
         } catch(final AlgorithmTerminationException e) {
            System.err.println(e.getMessage());
            return null;
         } finally {
            if(executorService != null) {
               executorService.shutdown();
            }
         }
      } catch(SecurityException | IllegalArgumentException ex) {
         ex.printStackTrace();
         System.err.println(ex.getMessage());
         return null;
      } finally {
         if(problem != null) {
            problem.close();
         }
      }
   }

   protected void setCanceled(final boolean cancel) {
      try {
         final AtomicBoolean isCanceled = CastUtil.asClass(reflectiveFields.get(ISCANCELED_NAME).get(this),
               AtomicBoolean.class);
         isCanceled.set(cancel);
      } catch(IllegalArgumentException | IllegalAccessException e) {
         e.printStackTrace();
      }
   }

   public SearchExecutor setName(final String name) {
      this.name = name;
      return this;
   }

   public void terminateRun() {
      if(algorithm != null && !algorithm.isTerminated()) {
         algorithm.terminate();
      }
   }

   @Override
   public String toString() {
      return getClass().getSimpleName() + "['" + getName() + "']";
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#usingAlgorithmFactory(org.moeaframework.core.spi.AlgorithmFactory)
    */
   @Override
   public SearchExecutor usingAlgorithmFactory(final AlgorithmFactory algorithmFactory) {
      return (SearchExecutor) super.usingAlgorithmFactory(algorithmFactory);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#usingProblemFactory(org.moeaframework.core.spi.ProblemFactory)
    */
   @Override
   public SearchExecutor usingProblemFactory(final ProblemFactory problemFactory) {
      return (SearchExecutor) super.usingProblemFactory(problemFactory);
   }

   public <A extends Algorithm> SearchExecutor withAlgorithm(final A algorithm) {
      return withAlgorithm(new AbstractRegisteredAlgorithm<A>() {
         @Override
         public A createAlgorithm() {
            return algorithm;
         }
      }.register());
   }

   @Override
   public SearchExecutor withAlgorithm(final String algorithmName) {
      return (SearchExecutor) super.withAlgorithm(algorithmName);
   }

   @Override
   public SearchExecutor withCheckpointFile(final File checkpointFile) {
      return (SearchExecutor) super.withCheckpointFile(checkpointFile);
   }

   @Override
   public SearchExecutor withCheckpointFrequency(final int checkpointFrequency) {
      return (SearchExecutor) super.withCheckpointFrequency(checkpointFrequency);
   }

   @Override
   public SearchExecutor withEpsilon(final double... epsilon) {
      return (SearchExecutor) super.withEpsilon(epsilon);
   }

   @Override
   public SearchExecutor withInstrumenter(final Instrumenter instrumenter) {
      return (SearchExecutor) super.withInstrumenter(instrumenter);
   }

   @Override
   public SearchExecutor withMaxEvaluations(final int maxEvaluations) {
      return (SearchExecutor) super.withMaxEvaluations(maxEvaluations);
   }

   public SearchExecutor withProblem(final ISearchProblem<?> problem) {
      super.withProblemClass(problem.getClass(), problem.getFitnessFunction(), problem.getSolutionGenerator());
      return this;
   }

   @Override
   public SearchExecutor withProblem(final String problemName) {
      return (SearchExecutor) super.withProblem(problemName);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProblemClass(java.lang.Class, java.lang.Object[])
    */
   @Override
   public SearchExecutor withProblemClass(final Class<?> problemClass, final Object... problemArguments) {
      return (SearchExecutor) super.withProblemClass(problemClass, problemArguments);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProblemClass(java.lang.String, java.lang.Object[])
    */
   @Override
   public SearchExecutor withProblemClass(final String problemClassName, final Object... problemArguments)
         throws ClassNotFoundException {
      return (SearchExecutor) super.withProblemClass(problemClassName, problemArguments);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProgressListener(org.moeaframework.util.progress.ProgressListener)
    */
   @Override
   public SearchExecutor withProgressListener(final ProgressListener listener) {
      return (SearchExecutor) super.withProgressListener(listener);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperties(java.util.Properties)
    */
   @Override
   public SearchExecutor withProperties(final Properties properties) {
      return (SearchExecutor) super.withProperties(properties);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, boolean)
    */
   @Override
   public SearchExecutor withProperty(final String key, final boolean value) {
      return (SearchExecutor) super.withProperty(key, value);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, byte)
    */
   @Override
   public SearchExecutor withProperty(final String key, final byte value) {
      return (SearchExecutor) super.withProperty(key, value);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, byte[])
    */
   @Override
   public SearchExecutor withProperty(final String key, final byte[] values) {
      return (SearchExecutor) super.withProperty(key, values);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, double)
    */
   @Override
   public SearchExecutor withProperty(final String key, final double value) {
      return (SearchExecutor) super.withProperty(key, value);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, double[])
    */
   @Override
   public SearchExecutor withProperty(final String key, final double[] values) {
      return (SearchExecutor) super.withProperty(key, values);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, float)
    */
   @Override
   public SearchExecutor withProperty(final String key, final float value) {
      return (SearchExecutor) super.withProperty(key, value);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, float[])
    */
   @Override
   public SearchExecutor withProperty(final String key, final float[] values) {
      return (SearchExecutor) super.withProperty(key, values);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, int)
    */
   @Override
   public SearchExecutor withProperty(final String key, final int value) {
      return (SearchExecutor) super.withProperty(key, value);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, int[])
    */
   @Override
   public SearchExecutor withProperty(final String key, final int[] values) {
      return (SearchExecutor) super.withProperty(key, values);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, long)
    */
   @Override
   public SearchExecutor withProperty(final String key, final long value) {
      return (SearchExecutor) super.withProperty(key, value);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, long[])
    */
   @Override
   public SearchExecutor withProperty(final String key, final long[] values) {
      return (SearchExecutor) super.withProperty(key, values);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, short)
    */
   @Override
   public SearchExecutor withProperty(final String key, final short value) {
      return (SearchExecutor) super.withProperty(key, value);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, short[])
    */
   @Override
   public SearchExecutor withProperty(final String key, final short[] values) {
      return (SearchExecutor) super.withProperty(key, values);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, java.lang.String)
    */
   @Override
   public SearchExecutor withProperty(final String key, final String value) {
      return (SearchExecutor) super.withProperty(key, value);
   }

   /*
    * (non-Javadoc)
    * @see org.moeaframework.Executor#withProperty(java.lang.String, java.lang.String[])
    */
   @Override
   public SearchExecutor withProperty(final String key, final String[] values) {
      return (SearchExecutor) super.withProperty(key, values);
   }
}
