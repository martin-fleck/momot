package mdetools.momot.nrp

import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.ecore.EObject
import nextReleaseProblem.NRP
import nextReleaseProblem.Customer
import nextReleaseProblem.Valuation
import java.beans.Customizer
import nextReleaseProblem.Requirement
import org.eclipse.uml2.uml.Realization
import nextReleaseProblem.RequirementRealisation
import nextReleaseProblem.SoftwareArtifact

class MaximiseSatisfaction extends AbstractModelQueryFitnessFunction {
	
	/**
	 * Computes the overall satisfaction generated by the selected software 
	 * artifacts.
	 * <p>
	 * The overall satisfaction is determined by the sum of all customer
	 * satisfactions (weighted by their importance value). 
	 * A customer's satisfaction is determined by the sum of satisfaction  
	 * contributions of the requirements directly desired by the customer.
	 * The contribution of such a requirement, in turn, is determined by its
	 * level of fulfillment weighted by its valuation assigned by the customer.
	 * </p>
	 * <p>
	 * The level of fulfillment of a requirement is usually determined by the
	 * percentage to which a software artifact realises the requirement. 
	 * However, a requirement can be simultaneously fulfilled to different
	 * degrees by different artifacts. Additionally, it can also be fulfilled
	 * by a combination of other requirements. In the latter case, the level of
	 * fulfillment is determined by the weighted sum of the levels of 
	 * fulfillment of those dependencies.
	 * In both of the above cases, the highest contribution of fulfillment
	 * will determine the overall level of fulfillment of the requirement.
	 * </p>
	 * <p>
	 * <em>Example:</em></br>
	 * Requirement A depends on two Requirements B and C. The valuations 
	 * connecting A to B and C have the values v(B)=2, v(C)=4. The level of 
	 * fulfillments are f(B)=0.8, f(C)=0.5. The level of fulfillment for A
	 * then is f(A)=(0.8*2 + 0.5*4)/6=0.6.
	 * In case there is a direct realisation for A with a percentage of 0.8
	 * the overall level of fulfillment will be max(0.6, 0.8)=0.8.
	 * </p> 
	 * 
	 */
	def static computeFitness(NRP model) {
		model.customers.fold(0.0d)[result, customer | 
			result + ((customer.importance) * customer.calculateSatisfaction)
		]
	}
	
	/**
	 * Calculates the weighted sum of all valuations of direct requirements for
	 * the given customer. Direct requirements are those which do not depend on
	 * other requirements.
	 */
	def static Double calculateSatisfaction(Customer customer) {
		val directValuations = customer.assigns.filter(v | v.contributesTo.isEmpty)
		val maxDirectValuations = directValuations.selectMaximalValuations
		maxDirectValuations.calcOverallFulfillmentContribution(customer)
	}
	
	/**
	 * Calculates the fulfillment of the given requirement, that is the highest
	 * degree to which the requirement is fulfilled by either direct 
	 * realisations or a combination of dependency requirements.
	 */
	def static Double calculateFulfillment(Requirement requirement, Customer customer) {
		val maxRealisation = requirement.realisations.filter(r | r.isImplemented).map(r | r.percentage).fold(0.0d)[result, perc | Math.max(result, perc)]
		val dependencyValuations = requirement.getDependencyValuations(customer)
		
		var aggregatedDepFulfillments = 0.0d	
		if (!dependencyValuations.isNullOrEmpty) {
			val maxDependencyValuations = dependencyValuations.selectMaximalValuations			
			aggregatedDepFulfillments = maxDependencyValuations.calcOverallFulfillmentContribution(customer)
		}
		Math.max(maxRealisation, aggregatedDepFulfillments)
	}
	
	/**
	 * Returns an iterable with all valuations of requirements which the given 
	 * requirement depends on and which have been assigned by the given 
	 * customer.
	 */	
	def static Iterable<Valuation> getDependencyValuations(Requirement requirement, Customer customer) {
		requirement.combines.filter(v | v.assignedBy.exists[c | c === customer])
	}
	
	/**
	 * From the given valuations select only those which are maximal. In other 
	 * words, if multiple valuations reference the same requirement, only the
	 * one with the highest value will be selected. If multiple valuations with
	 * the maximum value exist, only one of them will be selected.
	 */	
	def static Iterable<Valuation>  selectMaximalValuations(Iterable<Valuation> valuations) {
		valuations.filter[v1 | !(valuations.exists[v2 | v1 !== v2
			&& (v1.requirement === v2.requirement) 
			&& (v1.value) <= (v2.value as Double)
		])];				
	}
	
	/**
	 * Sums up the fulfillment contributions of the requirements referenced by
	 * the given valuations regarding the weight imposed by these valuations.
	 */
	def static Double calcOverallFulfillmentContribution(Iterable<Valuation> valuations, Customer customer) {
		if (valuations.exists[v | (v.value as Double) < 0.0d]) {
			throw new IllegalArgumentException("Valuation values need to be greater than 0.")
		}
		val sumOfWeights = valuations.map(v | v.value ).fold(0.0d)[result, value | result + value]
		if (sumOfWeights == 0.0d) {
			throw new IllegalArgumentException("The sum of valuation values may not be 0.")
		}
		valuations.map(v | (v.value ) * (v.requirement).calculateFulfillment(customer))
			.fold(0.0d)[result, weightedValue | result + weightedValue] / sumOfWeights	
	}
	
	/**
	 * Checks if a realisation is implemented. That is, if all artifacts the
	 * realisation directly or indirectly depends on are selected in the solution. 
 	 */
	def static isImplemented(RequirementRealisation realisation) {
		realisation.dependsOn.forall[sa | sa.isSelected
			&& sa.requires.forall[reqSa| reqSa.isSelected]
		]
	}

	def static isSelected(SoftwareArtifact softwareArtifact) {
		softwareArtifact.solutions.head !== null
	}
}