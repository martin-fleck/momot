package mdetools.momot.nrp

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.BasicEList
import nextReleaseProblem.NRP

class MinimiseCost extends AbstractModelQueryFitnessFunction {
	
	def static computeFitness(NRP model) {
		
		val selectedArtifactsCost =  model.solutions.head
				.selectedArtifacts.fold(0d)[
					result, artifact | 
					
					//This assumes money for now only
					result + artifact.costs.head.amount 
				]
		
		//println("Calculated selectedArtifacts cost: " + selectedArtifactsCost)
		
		return selectedArtifactsCost
		
	}
	
	/**
	 * Helper function getting the value of the named feature (if it exists) for the given EObject.
	 */
	def static Object getFeature (EObject o, String feature) {
		
		if(o === null){
			println("Null object given")
		}
		
		o.eGet(o.eClass.getEStructuralFeature(feature))
		
	}	
}