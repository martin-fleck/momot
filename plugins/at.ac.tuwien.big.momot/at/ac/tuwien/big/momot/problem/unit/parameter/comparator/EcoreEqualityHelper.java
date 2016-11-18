package at.ac.tuwien.big.momot.problem.unit.parameter.comparator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;

public class EcoreEqualityHelper implements IEObjectEqualityHelper {
	protected EqualityHelper helper = new EqualityHelper();

	@Override
	public boolean equals(EObject left, EObject right) {
		return helper.equals(left, right);
	}

}
