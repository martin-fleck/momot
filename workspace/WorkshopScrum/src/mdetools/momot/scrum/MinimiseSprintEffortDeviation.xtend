package mdetools.momot.scrum

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.EList
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation
import SprintPlanning.Plan
import mdetools.momot.nrp.AbstractModelQueryFitnessFunction

class MinimiseSprintEffortDeviation extends AbstractModelQueryFitnessFunction {
	
	def static computeFitness(Plan model) {
				
		var fitness = (model.sprints).map[ sprint | 
			
			new Double((sprint.committedItem).fold(0d)[ result, item |
				
				result + item.effort
				
			])
			 
		].toList
		
		var effortStandardDeviation = 0.0;
		if (fitness.size >= 2)  {
			effortStandardDeviation = new StandardDeviation().evaluate(fitness)
		} else {
			effortStandardDeviation = 0.0;
		}
		
		//println("Sprint effort distribution: " + fitness)
		//println("Sprint effort standard deviation: " + effortStandardDeviation)
		
		return effortStandardDeviation
	}
}
