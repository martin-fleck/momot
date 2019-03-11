package mdetools.momot.cra

import org.eclipse.emf.ecore.EObject

import org.eclipse.emf.common.util.EList
import icmt.tool.momot.demo.architectureCRA.ClassModel
import icmt.tool.momot.demo.architectureCRA.Method
import icmt.tool.momot.demo.architectureCRA.Attribute
import icmt.tool.momot.demo.architectureCRA.Class


class MaximiseCRA  {

	def static double computeFitness(ClassModel model) { 
		val cohesion = calculateCohesionRatio(model);
		val coupling = calculateCouplingRatio(model); 

		//println("Calculated CRA : " + (cohesion - coupling))

		return (cohesion - coupling) * -1
	}  
 
	def static double calculateCohesionRatio(ClassModel classModel) {
		
		var cohesionRatio = 0.0;
		
		for(icmt.tool.momot.demo.architectureCRA.Class classObject : classModel.classes) {
			
			val classObjectMethods = classObject.encapsulates.filter(Method)
			val classObjectAttributes = classObject.encapsulates.filter(Attribute)
			
			if(classObjectMethods.size == 0) {
				
				cohesionRatio += 0.0
				
			} else if (classObjectMethods.size == 1) {
				if(classObjectAttributes.size == 0){
					cohesionRatio += 0.0
				} else {
					val mai = mai(classObject, classObject)
					cohesionRatio += mai / Math.max(1,classObjectMethods.size * classObjectAttributes.size) as double
				}
			} else {
				if(classObjectAttributes.size == 0) {
					val mmi = mmi(classObject, classObject)
					cohesionRatio += mmi / Math.max(1,classObjectMethods.size * (classObjectMethods.size - 1)) as double
				} else {
					val mai = mai(classObject, classObject)
					val mmi = mmi(classObject, classObject)
					val maCoupling = Math.max(1,(classObjectMethods.size * classObjectAttributes.size)) as double
					val mmCoupling = Math.max(1,(classObjectMethods.size * (classObjectMethods.size - 1))) as double
					
					cohesionRatio += mai / maCoupling + mmi / mmCoupling
				}
			}
		} 
		
		cohesionRatio 
	}

	def static double calculateCouplingRatio(ClassModel classModel) {
		
		var couplingRatio = 0.0
		
		val classModelClasses = classModel.classes;
		
		for(Class classSource : classModelClasses){
			couplingRatio += calculateCouplingRatio(classSource, classModel)
		}
		
		couplingRatio
	}

	def static double calculateCouplingRatio(Class classSource, ClassModel classModel) {
		
		var couplingRatio = 0.0
		val sourceClassMethods = classSource.encapsulates.filter(Method)
		
		for(Class classTarget : classModel.classes) {
			
			if(classSource != classTarget) {		
				
				val targetClassMethods = classTarget.encapsulates.filter(Method)
				val targetClassAttributes = classTarget.encapsulates.filter(Attribute)
				 
				if(sourceClassMethods.size == 0) {
					couplingRatio += 0.0
				} else {
					
					if(targetClassMethods.size <= 1) {
						
						if(targetClassAttributes.size == 0) {
							couplingRatio += 0.0
						} else {
							couplingRatio += mai(classSource, classTarget) / Math.max(1,sourceClassMethods.size * targetClassAttributes.size) as double
						}
						
					} else {
						
						if(targetClassAttributes.size == 0){
							couplingRatio += mmi(classSource, classTarget) / Math.max(1,sourceClassMethods.size * (targetClassMethods.size -1)) as double
							
						} else {
							//XTend slows down considerably if this formula is in line
							val mai = mai(classSource, classTarget)
							val mmi = mmi(classSource, classTarget)
							
							val maCoupling = (sourceClassMethods.size * targetClassAttributes.size) as double
							val mmCoupling = (sourceClassMethods.size * (targetClassMethods.size -1)) as double
							
							if(maCoupling > 0 && mmCoupling > 0) {
								couplingRatio += mai / maCoupling + mmi / mmCoupling
							}
						}
					}
				}
			}
			
		}
		couplingRatio 
	}

	def static mai(Class classSource, Class classTarget) {
	
		var mai = 0
	
		for(Method method : classSource.encapsulates.filter(Method)){
			for(Attribute attributeTarget : classTarget.encapsulates.filter(Attribute)){
				
				val dataDependencies = method.dataDependency;
				
				if(dataDependencies.contains(attributeTarget)){
					mai++
				}
			}
		}
	
		mai
	}
	
	def static mmi(Class classSource, Class classTarget) {
	
		var mmi = 0
		
		for(Method methodSource : classSource.encapsulates.filter(Method)){
			for(Method methodTarget : classTarget.encapsulates.filter(Method)){
				
				val functionalDependencies = methodSource.functionalDependency;
				
				if(functionalDependencies.contains(methodTarget)){
					mmi++
				}
			}
		}
		
		mmi
	}
}
				