package at.ac.tuwien.big.momot.examples.stack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.moeaframework.core.Problem;

import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizerProvider;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.stack.stack.Stack;
import at.ac.tuwien.big.momot.examples.stack.stack.StackModel;
import at.ac.tuwien.big.momot.problem.ITransformationProblem;
import at.ac.tuwien.big.momot.problem.ParetoFrontStoringTransformationSearchProblem;
import at.ac.tuwien.big.momot.problem.TransformationProblem;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.unit.parameter.random.RandomIntegerValue;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class StackOrchestration extends TransformationSearchOrchestration {

	private int maxShift = 5;
	private SingleObjectivizerProvider provider;
	
	public static final String MODULE_DIR = "model/";
	public static final String HENSHIN_FILE = "stack.henshin";
	
	public static final String[] modules = new String[]{HENSHIN_FILE};
	
	public StackOrchestration(SingleObjectivizerProvider provider, String initialGraphPath, int nrVariables) {
		super(new ModuleManager(MODULE_DIR, HENSHIN_FILE), initialGraphPath, nrVariables);
		this.provider = provider;
		
		IEGraphMultiDimensionalFitnessFunction fitnessFunction = getFitnessFunction();
		fitnessFunction.setSolutionRepairer(new TransformationPlaceholderRepairer()); // replace not executed rules with empty rules
		
		fitnessFunction.addObjective(new AbstractEGraphFitnessDimension("Standard Deviation") {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				StackModel stacks = MomotUtil.getRoot(solution.execute(), StackModel.class);
				List<Integer> loads = new ArrayList<Integer>();
				for(Stack stack : stacks.getStacks()) {
					int load = stack.getLoad();
					loads.add(load);
				}
					
				return MathUtil.getStandardDeviation(loads);
			}
		});
		
		fitnessFunction.addObjective(new TransformationLengthDimension());
		
		setSolutionWriter(new StackSolutionWriter(getFitnessFunction()));
		
		getModuleManager().removeUnits(
				StackModule.CreateStack.NAME,
				StackModule.ConnectStacks.NAME);	// defined in same file, but not applicable
		
		ModuleManager moduleManager = getModuleManager();
		moduleManager.addNonSolutionParameters(
				StackModule.ShiftLeft.Parameter.FROM_LOAD,
				StackModule.ShiftLeft.Parameter.TO_LOAD,
				StackModule.ShiftRight.Parameter.FROM_LOAD,
				StackModule.ShiftRight.Parameter.TO_LOAD);
		moduleManager.setParameterValue(StackModule.ShiftLeft.Parameter.AMOUNT, new RandomIntegerValue(1, getMaxShift()));
		moduleManager.setParameterValue(StackModule.ShiftRight.Parameter.AMOUNT, new RandomIntegerValue(1, getMaxShift()));
		
	}

	public void setMaxShift(int maxShift) {
		this.maxShift = maxShift;
		getModuleManager().setParameterValue(StackModule.ShiftLeft.Parameter.AMOUNT, new RandomIntegerValue(1, getMaxShift()));
		getModuleManager().setParameterValue(StackModule.ShiftRight.Parameter.AMOUNT, new RandomIntegerValue(1, getMaxShift()));
	}
	
	public int getMaxShift() {
		return maxShift;
	}
	
	/**Creates a pareto front storing problem*/
	@Override
	public ITransformationProblem createProblem() {
		ITransformationProblem ret = super.createProblem();
		return ret;
	}

	
}
