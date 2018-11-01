package mdetools.momot.nrp

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.BasicEList

class MinimiseCost extends AbstractModelQueryFitnessFunction {
	
	def static computeFitness(EObject model) {
		
		val selectedArtifactsCost =  model.getReferenceFeature("solutions").head
				.getReferenceFeature("selectedArtifacts").fold(0d)[
					result, artifact | 
					
					//This assumes money for now only
					result + artifact.getReferenceFeature("costs").head.getFeature("amount") as Double
				]
		
		println("Calculated selectedArtifacts cost: " + selectedArtifactsCost)
		
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