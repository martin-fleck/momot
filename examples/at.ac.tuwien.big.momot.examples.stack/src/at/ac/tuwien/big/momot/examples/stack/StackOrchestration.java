package at.ac.tuwien.big.momot.examples.stack;

import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.stack.stack.Stack;
import at.ac.tuwien.big.momot.examples.stack.stack.StackModel;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.unit.parameter.random.RandomIntegerValue;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import at.ac.tuwien.big.momot.util.MomotUtil;

import java.util.ArrayList;
import java.util.List;

public class StackOrchestration extends TransformationSearchOrchestration {

   private int maxShift = 5;

   public StackOrchestration(final String initialGraphPath, final int nrVariables) {
      super(new ModuleManager("model/", "stack.henshin"), initialGraphPath, nrVariables);

      final IEGraphMultiDimensionalFitnessFunction fitnessFunction = getFitnessFunction();
      fitnessFunction.setSolutionRepairer(new TransformationPlaceholderRepairer()); // replace not executed rules with
                                                                                    // empty rules

      fitnessFunction.addObjective(new AbstractEGraphFitnessDimension("Standard Deviation") {
         @Override
         protected double internalEvaluate(final TransformationSolution solution) {
            final StackModel stacks = MomotUtil.getRoot(solution.execute(), StackModel.class);
            final List<Integer> loads = new ArrayList<>();
            for(final Stack stack : stacks.getStacks()) {
               final int load = stack.getLoad();
               loads.add(load);
            }

            return MathUtil.getStandardDeviation(loads);
         }
      });

      fitnessFunction.addObjective(new TransformationLengthDimension());

      setSolutionWriter(new StackSolutionWriter(getFitnessFunction()));

      getModuleManager().removeUnits(StackModule.CreateStack.NAME, StackModule.ConnectStacks.NAME); // defined in same
                                                                                                    // file, but not
                                                                                                    // applicable

      final ModuleManager moduleManager = getModuleManager();
      moduleManager.addNonSolutionParameters(StackModule.ShiftLeft.Parameter.FROM_LOAD,
            StackModule.ShiftLeft.Parameter.TO_LOAD, StackModule.ShiftRight.Parameter.FROM_LOAD,
            StackModule.ShiftRight.Parameter.TO_LOAD);
      moduleManager.setParameterValue(StackModule.ShiftLeft.Parameter.AMOUNT, new RandomIntegerValue(1, getMaxShift()));
      moduleManager.setParameterValue(StackModule.ShiftRight.Parameter.AMOUNT,
            new RandomIntegerValue(1, getMaxShift()));
   }

   public int getMaxShift() {
      return maxShift;
   }

   public void setMaxShift(final int maxShift) {
      this.maxShift = maxShift;
      getModuleManager().setParameterValue(StackModule.ShiftLeft.Parameter.AMOUNT,
            new RandomIntegerValue(1, getMaxShift()));
      getModuleManager().setParameterValue(StackModule.ShiftRight.Parameter.AMOUNT,
            new RandomIntegerValue(1, getMaxShift()));
   }
}
