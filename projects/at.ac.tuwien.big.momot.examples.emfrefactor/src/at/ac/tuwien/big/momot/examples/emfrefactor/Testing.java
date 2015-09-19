package at.ac.tuwien.big.momot.examples.emfrefactor;

import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UMLFactory;

public class Testing {
public static void main(String[] args) {
	Class clazz = UMLFactory.eINSTANCE.createClass();
	Class clazz2 = UMLFactory.eINSTANCE.createClass();
	System.out.println(clazz.equals(clazz2));
	EqualityHelper helper = new EqualityHelper();
	System.out.println(helper.equals(clazz, clazz2));
}
}
