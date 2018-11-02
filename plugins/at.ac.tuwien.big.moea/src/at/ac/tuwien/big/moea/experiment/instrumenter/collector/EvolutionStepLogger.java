package at.ac.tuwien.big.moea.experiment.instrumenter.collector;

import at.ac.tuwien.big.moea.util.AccumulatorUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.moeaframework.analysis.collector.Accumulator;
import org.moeaframework.analysis.collector.AttachPoint;
import org.moeaframework.analysis.collector.Collector;
import org.moeaframework.core.Algorithm;
import org.moeaframework.core.EvolutionaryAlgorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Population;
import org.moeaframework.core.Solution;

public class EvolutionStepLogger implements Collector {

   private static class PartialResult implements Serializable {
      private long time;
      private int evalNum;
      private int evolutionNumb;
      private final List<double[]> paretoThings = new ArrayList<>();

      @Override
      public String toString() {
         final StringBuilder ret = new StringBuilder(
               time + "," + evolutionNumb + "," + evalNum + "," + paretoThings.size());
         for(final double[] v : paretoThings) {
            ret.append("," + v.length);
            for(final double element : v) {
               ret.append(",");
               ret.append(element);
            }
         }
         return ret.toString();
      }
   }

   public static int index;
   public static int startIndex;

   public static int CUR_RUN;

   public static String CUR_NAME;

   private int evolutionNumb;
   private final Algorithm algorithm;
   private File currentSaveFile;
   private File totalSaveFile;
   private long startTime;

   private String myName = "NOT_SET";
   private int myRun = 0;

   public EvolutionStepLogger() {
      this(null);
   }

   public EvolutionStepLogger(final Algorithm algorithm) {
      this.algorithm = algorithm;
      if(this.algorithm != null) {
         final Random randomName = new Random();
         ++index;
         myName = CUR_NAME;
         myRun = CUR_RUN;
         currentSaveFile = new File("output" + File.separator + "intermediatecurrent" + File.separator
               + algorithm.getProblem().getName() + File.separator + myName + File.separator + "steps_" + index + "_"
               + Math.abs(randomName.nextInt()) + ".csv");
         totalSaveFile = new File("output" + File.separator + "intermediatetotal" + File.separator
               + algorithm.getProblem().getName() + File.separator + myName + File.separator + "steps_" + index + "_"
               + Math.abs(randomName.nextInt()) + ".csv");
         // System.out.println("Saving results into " + currentSaveFile);
         currentSaveFile.getParentFile().mkdirs();
         totalSaveFile.getParentFile().mkdirs();
         startTime = System.nanoTime();
      }
   }

   @Override
   public Collector attach(final Object object) {
      return new EvolutionStepLogger((Algorithm) object);
   }

   @Override
   public void collect(final Accumulator accumulator) {
      final long curTime = System.nanoTime() - startTime;
      ++evolutionNumb;
      // new Exception().printStackTrace();
      {
         final NondominatedPopulation result2 = algorithm.getResult();
         final PartialResult result = writeInto(result2, totalSaveFile, curTime, evolutionNumb);
         accumulator.add(AccumulatorUtil.Keys.BASIC_STEP_FITNESS_TOTAL, result);
      }
      if(algorithm instanceof EvolutionaryAlgorithm) {
         final Population result2 = ((EvolutionaryAlgorithm) algorithm).getPopulation();
         final PartialResult result = writeInto(result2, currentSaveFile, curTime, evolutionNumb);
         accumulator.add(AccumulatorUtil.Keys.BASIC_STEP_FITNESS_CURRENT, result);
      }
   }

   @Override
   public AttachPoint getAttachPoint() {
      return AttachPoint.isSubclass(Algorithm.class).and(AttachPoint.not(AttachPoint.isNestedIn(Algorithm.class)));

   }

   private PartialResult writeInto(final Population result2, final File file, final long curTime,
         final int evolutionNumb) {
      final PartialResult result = new PartialResult();
      result.time = curTime;
      result.evalNum = algorithm.getNumberOfEvaluations();
      result.evolutionNumb = evolutionNumb;
      // new Exception().printStackTrace();
      for(final Solution sol : result2) {
         final int constPlusObj = sol.getNumberOfConstraints() + sol.getNumberOfObjectives();
         final double[] v = new double[constPlusObj];
         for(int i = 0; i < sol.getNumberOfConstraints(); ++i) {
            v[i] = sol.getConstraint(i);
         }
         for(int i = 0; i < sol.getNumberOfObjectives(); ++i) {
            v[i + sol.getNumberOfConstraints()] = sol.getObjective(i);
         }
         result.paretoThings.add(v);
      }
      // System.out.println(result.toString());
      try(final FileOutputStream fos = new FileOutputStream(file, true)) {
         fos.write((result.toString() + "\n").getBytes());
         fos.flush();
      } catch(final FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch(final IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return result;

   }

}
