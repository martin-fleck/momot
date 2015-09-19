package at.ac.tuwien.big.momot.examples.refactoring;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;

import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.moea.util.EcoreUtil;
import at.ac.tuwien.big.momot.print.TransformationSolutionWriter;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

public class RefactoringSolutionWriter extends TransformationSolutionWriter {

	public RefactoringSolutionWriter(IMultiDimensionalFitnessFunction<?> fitnessFunction) {
		super(fitnessFunction);
	}
	
	@Override
	public String write(TransformationSolution solution) {
		String txt = super.write(solution);
		txt += "------------\n";
		txt += printExecutionResult(solution);
		return txt;
	}

	private String printExecutionResult(TransformationSolution solution) {
		EGraph result = solution.execute();
		if(result != null)
			return write(result);
		return "";
	}

	@SuppressWarnings("unchecked")
	@Override
	public String write(EGraph graph) {
		String result = "";
		String delim = "";
		for(EObject obj : graph) {
			if(obj.eClass().getName().equals("Entity")) {
				result += delim;
				String name = EcoreUtil.getFeatureValue(obj, "name", String.class);
				result += name;
				
				EObject generalization = EcoreUtil.getFeatureValue(obj, "generalization", EObject.class);
				if(generalization != null) {
					EObject generalizationEntity = EcoreUtil.getFeatureValue(generalization, "general", EObject.class);
					result += " : " + EcoreUtil.getFeatureValue(generalizationEntity, "name", String.class);
				}
				
				result += " {";
				
				EList<EObject> properties = EcoreUtil.getFeatureValue(obj, "ownedAttribute", EList.class);
				if(!properties.isEmpty())
					result += "\n";
				String propDelim = "";
				for(EObject property : properties) {
					String propertyName = EcoreUtil.getFeatureValue(property, "name", String.class);
					EObject propertyType = EcoreUtil.getFeatureValue(property, "type", EObject.class);
					String typeName = EcoreUtil.getFeatureValue(propertyType, "name", String.class);
					result += propDelim + "  " + propertyName + ": " + typeName;
					propDelim = ",\n";
				}
				if(!properties.isEmpty())
					result += "\n";
				result += "}\n";
//				delim = "\n";
			}
		}
		return result;
	}
}
