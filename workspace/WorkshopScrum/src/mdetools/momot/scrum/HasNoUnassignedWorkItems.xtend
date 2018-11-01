package mdetools.momot.scrum

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import mdetools.momot.nrp.AbstractModelQueryFitnessFunction
import SprintPlanning.Plan

class HasNoUnassignedWorkItems extends AbstractModelQueryFitnessFunction {
	
	def static computeFitness(Plan model) {
		
		var workItems = (model.backlog).workitems
		var fitness = 0
		
		if(workItems !== null) {
			fitness = workItems.filter[workItem | workItem.isPlannedFor === null].toList.length
		}
		
		//println("Unassigned backlog work items: " + fitness)
		
		return fitness
	}
}