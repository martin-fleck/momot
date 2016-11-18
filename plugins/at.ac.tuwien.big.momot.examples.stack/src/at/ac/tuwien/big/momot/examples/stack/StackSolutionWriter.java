package at.ac.tuwien.big.momot.examples.stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;

import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.moea.util.EcoreUtil;
import at.ac.tuwien.big.momot.print.TransformationSolutionWriter;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

public class StackSolutionWriter extends TransformationSolutionWriter {

	public StackSolutionWriter(IMultiDimensionalFitnessFunction<?> fitnessFunction) {
		super(fitnessFunction);
	}
	
	@Override
	public String write(TransformationSolution solution) {
		String txt = super.write(solution);
		txt += "------------\n";
		txt += printExecutionResult(solution);
		return txt;
	}
	
	@Override
	public String write(EGraph graph) {
		String result = "";
		String delim = "";
		for(EObject obj : graph) {
			if(EcoreUtil.isEClass(obj, "Stack")) {
				String id = EcoreUtil.getFeatureValue(obj, "id", String.class);
				Integer load = EcoreUtil.getFeatureValue(obj, "load", Integer.class);
				result += delim + id + ": " + load;
				delim = "\n";
			}
		}
		return result;
	}
	
	public String printExecutionResult(TransformationSolution solution) {
		EGraph result = solution.execute();
		if(result != null)
			return write(result);
		return "-no result-";
	}
}
