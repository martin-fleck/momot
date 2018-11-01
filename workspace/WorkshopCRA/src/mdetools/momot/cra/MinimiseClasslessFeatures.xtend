package mdetools.momot.cra

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import icmt.tool.momot.demo.architectureCRA.ClassModel

class MinimiseClasslessFeatures  {
	
	def static computeFitness(ClassModel model) {
		var fitness = (model.features).filter[feature | feature.isEncapsulatedBy === null].size;
		//println("Classless features: " + fitness)
		return fitness;
	}
}
	