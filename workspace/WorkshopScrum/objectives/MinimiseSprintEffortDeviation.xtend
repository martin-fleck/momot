package mdetools.momot.scrum

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.EList
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation

class MinimiseSprintEffortDeviation extends AbstractModelQueryFitnessFunction {
	
	def static computeFitness(EObject model) {
				
		var fitness = (model.getFeature("sprints") as EList<EObject>).map[ sprint | 
			
			new Double((sprint.getFeature("committedItem") as EList<EObject>).fold(0d)[ result, item |
				
				result + item.getFeature("Effort") as Integer
				
			])
			
		].toList
		
		var effortStandardDeviation = new StandardDeviation().evaluate(fitness)
		
		println("Sprint effort distribution: " + fitness)
		println("Sprint effort standard deviation: " + effortStandardDeviation)
		
		return effortStandardDeviation
	}
}
