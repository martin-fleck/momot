/**
 *
 */
package at.ac.tuwien.big.momot.problem;

import at.ac.tuwien.big.moea.search.solution.generator.solution.ISolutionGenerator;
import at.ac.tuwien.big.momot.problem.solution.FutureTransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.fitness.IEGraphFitnessFunction;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.moeaframework.core.Solution;
import org.moeaframework.problem.ProblemException;

/**
 * @author sherzig
 *
 */
public class DistributedTransformationProblem extends TransformationProblem {

   private static class ProblemEvaluator implements Callable<Solution>, Serializable {
      private static final long serialVersionUID = 3270746749457668700L;
      private final DistributedTransformationProblem problem;
      private final Solution solution;

      public ProblemEvaluator(final DistributedTransformationProblem problem, final Solution solution) {
         this.problem = problem;
         this.solution = solution;
      }

      @Override
      public Solution call() throws Exception {
         this.problem.evaluateSolution(this.solution);
         return this.solution;
      }
   }

   protected ExecutorService executor = null;// Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

   public DistributedTransformationProblem(final IEGraphFitnessFunction fitnessFunction,
         final ISolutionGenerator<TransformationSolution> solutionGenerator) {
      super(fitnessFunction, solutionGenerator);

      executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
   }

   public DistributedTransformationProblem(final IEGraphFitnessFunction fitnessFunction,
         final ISolutionGenerator<TransformationSolution> solutionGenerator, final ExecutorService executorService) {
      super(fitnessFunction, solutionGenerator);

      executor = executorService;
   }

   @Override
   public void close() {
      super.close();

      executor.shutdown();
   }

   @Override
   public void evaluate(final Solution solution) {
      if(solution instanceof FutureTransformationSolution) {
         final FutureTransformationSolution futureSolution = (FutureTransformationSolution) solution;
         final Future<Solution> future = this.executor.submit(new ProblemEvaluator(this, futureSolution));

         futureSolution.setFuture(future);
      } else {
         throw new ProblemException(this, "requires FutureTransformationSolution");
      }
   }

   public void evaluateSolution(final Solution solution) {
      super.evaluate(solution);
   }

   @Override
   public Solution newSolution() {
      return new FutureTransformationSolution((TransformationSolution) super.newSolution());
   }

}
