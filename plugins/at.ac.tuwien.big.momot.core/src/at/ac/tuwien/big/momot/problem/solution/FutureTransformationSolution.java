/**
 *
 */
package at.ac.tuwien.big.momot.problem.solution;

import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;

import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.FrameworkException;
import org.moeaframework.core.Solution;

/**
 * @author sherzig
 *
 */
public class FutureTransformationSolution extends TransformationSolution {

   private static final long serialVersionUID = 5205800422604382867L;

   protected transient Future<Solution> future = null;
   protected transient boolean beingUpdated = false; // Fitness function evaluation computes aggregate fitness - calls
                                                     // update (synchronized method) twice otherwise

   public FutureTransformationSolution(final EGraph sourceGraph, final int numberOfVariables,
         final int numberOfObjectives) {
      super(sourceGraph, numberOfVariables, numberOfObjectives);
      // TODO Auto-generated constructor stub
   }

   public FutureTransformationSolution(final EGraph sourceGraph, final int numberOfVariables,
         final int numberOfObjectives, final int numberOfConstraints) {
      super(sourceGraph, numberOfVariables, numberOfObjectives, numberOfConstraints);
      // TODO Auto-generated constructor stub
   }

   public FutureTransformationSolution(final EGraph sourceGraph,
         final List<? extends ITransformationVariable> variables, final int numberOfObjectives) {
      super(sourceGraph, variables, numberOfObjectives);
      // TODO Auto-generated constructor stub
   }

   public FutureTransformationSolution(final EGraph sourceGraph,
         final List<? extends ITransformationVariable> variables, final int numberOfObjectives,
         final int numberOfConstraints) {
      super(sourceGraph, variables, numberOfObjectives, numberOfConstraints);
      // TODO Auto-generated constructor stub
   }

   public FutureTransformationSolution(final EGraph sourceGraph, final Solution solution) {
      super(sourceGraph, solution);
      // TODO Auto-generated constructor stub
   }

   public FutureTransformationSolution(final TransformationSearchOrchestration searchOrchestration) {
      super(searchOrchestration);
      // TODO Auto-generated constructor stub
   }

   public FutureTransformationSolution(final TransformationSolution solution) {
      super(solution);
      // TODO Auto-generated constructor stub
   }

   @Override
   public FutureTransformationSolution copy() {
      if(!beingUpdated) {
         update();
      }
      return new FutureTransformationSolution(this);
   }

   // @Override
   // public EGraph execute() {
   // return execute(false);
   // }
   //
   // @Override
   // public EGraph execute(final boolean forceExecution) {
   // update();
   //
   // return super.execute(forceExecution);
   // }

   @Override
   public double getConstraint(final int index) {
      if(!beingUpdated) {
         update();
      }

      return super.getConstraint(index);
   }

   @Override
   public double[] getConstraints() {
      if(!beingUpdated) {
         update();
      }

      return super.getConstraints();
   }

   public Future<Solution> getFuture() {
      return future;
   }

   @Override
   public double getObjective(final int index) {
      if(!beingUpdated) {
         update();
      }

      return super.getObjective(index);
   }

   @Override
   public double[] getObjectives() {
      if(!beingUpdated) {
         update();
      }

      return super.getObjectives();
   }

   public synchronized void setFuture(final Future<Solution> future) {
      this.future = future;
   }

   public synchronized void update() {
      try {
         if(future != null) {
            beingUpdated = true;

            final Solution solution = this.future.get();
            this.future = null;
            setObjectives(solution.getObjectives());
            setConstraints(solution.getConstraints());

            beingUpdated = false;
         }
      } catch(final Exception e) {
         // TODO Auto-generated catch block
         throw new FrameworkException(e);
      }
   }

}
