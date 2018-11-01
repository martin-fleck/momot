package mdetools.momot.scrum

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.EList
import mdetools.momot.nrp.AbstractModelQueryFitnessFunction
import SprintPlanning.Plan;

class HasTheAllowedMaximalNumberOfSprints extends AbstractModelQueryFitnessFunction {
	
	def static computeFitness(Plan model) {
		
		var workitems = (model.backlog).workitems;
		
		var totalEffort = workitems.fold(0)[result, item | result + (item.effort) ];
		
		var desiredSprints = 0d;
		var maximumVelocity = 25;
		
		if(totalEffort > maximumVelocity){
		
			desiredSprints = Double.parseDouble(totalEffort.toString) / maximumVelocity;
		
			if(desiredSprints -  desiredSprints.intValue > 0.5d){
				desiredSprints = Math.ceil(desiredSprints)
			} else {
				desiredSprints = Math.floor(desiredSprints)
			}
		
		}
		
		var sprints = (model.sprints).filter[ 
			sprint | (sprint.committedItem).length > 0].toList
		
		
		//println("Counted sprints: " + sprints.length)
		//println("Counted maximal desired sprints: " + desiredSprints)
		
		//If we have less than the minimum number of desired sprints
		if(sprints.length > desiredSprints) {
			return  desiredSprints - sprints.length;
		}
		
		return 0
		
	}
}