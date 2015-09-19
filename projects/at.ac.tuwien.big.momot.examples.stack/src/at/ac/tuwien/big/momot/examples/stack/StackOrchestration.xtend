package at.ac.tuwien.big.momot.examples.stack

import java.util.ArrayList
import java.util.List
import at.ac.tuwien.big.moea.util.MathUtil
import at.ac.tuwien.big.momot.ModuleManager
import at.ac.tuwien.big.momot.TransformationSearchOrchestration
import at.ac.tuwien.big.momot.examples.stack.stack.Stack
import at.ac.tuwien.big.momot.examples.stack.stack.StackModel
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution
import at.ac.tuwien.big.momot.problem.unit.parameter.random.RandomIntegerValue
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer
import at.ac.tuwien.big.momot.util.MomotUtil

class StackOrchestrationXtend extends TransformationSearchOrchestration {
	int maxShift = 5

	new(String initialGraphPath, int solutionLength) {
		super(new ModuleManager("model/", "stack.henshin"), initialGraphPath, solutionLength) // henshin management
		val ModuleManager manager = getModuleManager()
		
		manager.removeUnits(StackModule::CreateStack::NAME, StackModule::ConnectStacks::NAME) // defined in same file, but not applicable
		manager.setParameterValue(StackModule::ShiftLeft::Parameter::AMOUNT, new RandomIntegerValue(1, 5))
		manager.setParameterValue(StackModule::ShiftRight::Parameter::AMOUNT, new RandomIntegerValue(1, 5))
		manager.addNonSolutionParameters(StackModule::ShiftLeft::Parameter::FROM_LOAD,
			StackModule::ShiftLeft::Parameter::TO_LOAD, 
			StackModule::ShiftRight::Parameter::FROM_LOAD, StackModule::ShiftRight::Parameter::TO_LOAD) // fitness function
			
		getFitnessFunction().addObjective(new AbstractEGraphFitnessDimension("") {
			override protected internalEvaluate(TransformationSolution solution) {
				var StackModel root = MomotUtil::getRoot(solution.execute(), typeof(StackModel))
			if(root === null) throw new IllegalArgumentException(
				"Root is not a StackModel. Did you register the respective EPackage?")
			var List<Integer> loads = new ArrayList<Integer>()
			for (Stack stack : root.getStacks())
				loads.add(stack.getLoad())
			return MathUtil::getStandardDeviation(loads)
			}
		})
		
		getFitnessFunction().addObjective(new TransformationLengthDimension())
		getFitnessFunction().setSolutionRepairer(new TransformationPlaceholderRepairer())
		setSolutionWriter(new StackSolutionWriter(getFitnessFunction()))
	}

	def void setMaxShift(int maxShift) {
		this.maxShift = maxShift
		getModuleManager().setParameterValue(StackModule::ShiftLeft::Parameter::AMOUNT,
			new RandomIntegerValue(1, getMaxShift()))
		getModuleManager().setParameterValue(StackModule::ShiftRight::Parameter::AMOUNT,
			new RandomIntegerValue(1, getMaxShift()))
	}

	def int getMaxShift() {
		return maxShift
	}

}
