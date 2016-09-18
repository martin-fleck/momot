package at.ac.tuwien.big.momost.examples.tse.eval;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;

public class EvaluationUtil {
	
	public static void initStandalone() {
		ModularizationPackage.eINSTANCE.eClass();
//		RuleTypePackage.eINSTANCE.eClass();
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("xmi", new XMIResourceFactoryImpl());
	}
	
	public static Transformation assertTransformation(Resource resource) {
		if(resource == null)
			throw new IllegalArgumentException("Resource can not be null.");
		
		EObject root = resource.getContents().get(0);
		
		if(!(root instanceof Transformation))
			throw new IllegalArgumentException("Not a Transformation. Make sure the package is registered and initialized.");
		
		Transformation transformation = (Transformation) root;
		if(transformation.getModules().isEmpty())
			throw new IllegalArgumentException("No modules in transformation.");
		
		return transformation;
	}
}
