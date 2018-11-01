package mdetools.momot.scrum

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.EList
import java.util.ArrayList
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation

class MinimiseCustomerSatisfactionIndex extends AbstractModelQueryFitnessFunction {
	
	def static computeFitness(EObject model) {		
		
		val sprints = (model.getFeature("sprints") as EList<EObject>)
		val standardDeviationCalculator = new StandardDeviation();
		
		val stakeholderImportanceSprintDeviation = new ArrayList<Double>();
		
		(model.getFeature("stakeholders") as EList<EObject>).forEach[stakeholder |
			
			
			var effortAccrossSprints = sprints.map[
			sprint | new Double((sprint.getFeature("committedItem") as EList<EObject>)
				.filter[ item | item.getFeature("stakeholder").equals(stakeholder)]
				.fold(0d)[result, item | result + item.getFeature("Importance") as Integer])
			]
			
			stakeholderImportanceSprintDeviation.add(standardDeviationCalculator.evaluate(effortAccrossSprints))
		]
		
		var importanceStandardDeviation = standardDeviationCalculator.evaluate(stakeholderImportanceSprintDeviation)
		
		println("Sprint stakeholder importance distribution: " + stakeholderImportanceSprintDeviation)
		println("Sprint Customer Satisfaction Index: " + importanceStandardDeviation)
		
		return importanceStandardDeviation;
	}
}
