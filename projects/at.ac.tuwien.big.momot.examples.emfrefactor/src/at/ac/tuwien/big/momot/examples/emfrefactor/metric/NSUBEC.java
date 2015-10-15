package at.ac.tuwien.big.momot.examples.emfrefactor.metric;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * Implemented as other metrics in EMF Refactor. 
 * Re-implemented separately to avoid dependency for MOMoT example.
 * 
 * @author Martin Fleck
 *
 */
public final class NSUBEC implements IMetricCalculator {

	private final String expression = 
		"self.ePackage.eClassifiers->select(e | e.oclIsKindOf(EClass) and e.oclAsType(EClass).eSuperTypes->exists(s | s = self))->size()";	
	private List<EObject> context; 
		
	@Override
	public void setContext(List<EObject> context) {
		this.context = context;
	}	
		
	@Override
	public double calculate() {	
		EObject contextObject = context.get(0);
		double eval = OCLManager.evaluateOCLOnContextObject(contextObject, expression);
		return eval;
	}
}