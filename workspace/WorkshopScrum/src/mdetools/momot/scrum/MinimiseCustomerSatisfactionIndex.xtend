package mdetools.momot.scrum

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.EList
import java.util.ArrayList
import SprintPlanning.Plan
import mdetools.momot.nrp.AbstractModelQueryFitnessFunction 
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation 

class MinimiseCustomerSatisfactionIndex extends AbstractModelQueryFitnessFunction { 
	 
	def static computeFitness(Plan model) {		
		 
		val sprints = (model.sprints) 
		val standardDeviationCalculator = new StandardDeviation();
		
		val stakeholderImportanceSprintDeviation = new ArrayList<Double>();
		
		(model.stakeholders).forEach[stakeholder |
			
			var effortAccrossSprints = sprints.map[
			sprint | new Double(sprint.committedItem
				.filter[ item | item.stakeholder.equals(stakeholder)]
				.fold(0d)[result, item | result + item.importance])
			]
			if (effortAccrossSprints.size < 2) {
				stakeholderImportanceSprintDeviation.add(0.0);
			} else {
				stakeholderImportanceSprintDeviation.add(standardDeviationCalculator.evaluate(effortAccrossSprints))
			}
		]
		
		var importanceStandardDeviation = 0.0;
		if (stakeholderImportanceSprintDeviation.size >= 2) {
			importanceStandardDeviation =  standardDeviationCalculator.evaluate(stakeholderImportanceSprintDeviation)
		}
		
		//println("Sprint stakeholder importance distribution: " + stakeholderImportanceSprintDeviation)
		//println("Sprint Customer Satisfaction Index: " + importanceStandardDeviation)
		
		return importanceStandardDeviation;
	}
}
