package at.ac.tuwien.big.momot.examples.tse.metric.calc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.StopWatch;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleType;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType;
import at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.tse.modularization.Module;
import at.ac.tuwien.big.momot.examples.tse.modularization.Rule;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;

public class MetaModelFootprintCalculator {
	public static final String UNDEFINED = "OclUndefined";
	public static final String NULL = "null";
	public static final String PRIMITIVE_TYPES = "PrimitiveTypes";
	
	private static void init() {
		RuleTypePackage.eINSTANCE.eClass();
		ModularizationPackage.eINSTANCE.eClass();
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
	}
	
	public static double calculate(String typesURI, String transformationURI) {
		init();
		
		/* We load the model with the types of the rules */
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource typesResource = resSet.getResource(URI.createURI(typesURI), true);
	    TransformationType types = (TransformationType) typesResource.getContents().get(0);
	    
	    /* We load the model with the different modules */
	    Resource moduleResource = resSet.getResource(URI.createURI(transformationURI), true);	    
	    Transformation transformation = (Transformation) moduleResource.getContents().get(0);
	    
	    return calculate(types, transformation);
	}

	public static double calculate(TransformationType types, Transformation transformation) {		
		double average = 0.0;
		int count = 0;
		for(Module firstModule : transformation.getModules()) {
	    	for(Module secondModule : transformation.getModules()) {
	    		if(transformation.getModules().indexOf(firstModule) != 
	    				transformation.getModules().indexOf(secondModule)) {
	    			double factor = calculateModuleIntersection(types, firstModule, secondModule);
		    		if(factor >= 0.0) {
		    			count++;
		    			average += factor;
		    		}
	    		}	    		
	    	}
	    }
		double footprint = count == 0 ? 0.0 : average / count;
		if(Double.isNaN(footprint))
			System.out.println(average + " / " + count);
		return footprint;
	}
	
	/*This method calculates the number of common MM elements used in modules m1 and m2 with respect to the number of MM elements in m1*/
	private static double calculateModuleIntersection(TransformationType modelRuleTypes, Module firstModule, Module secondModule) {
		List<String> firstModuleNames = new ArrayList<>();
    	List<String> secondModuleNames = new ArrayList<String>();
    	
    	for (Rule r : firstModule.getRules())
    		firstModuleNames.add(r.getName());
    	
    	for (Rule r : secondModule.getRules())
    		secondModuleNames.add(r.getName());
    	
    	return calculateModuleIntersection(modelRuleTypes, firstModuleNames, secondModuleNames);
	}
	
	protected static double calculateModuleIntersection(TransformationType modelRuleTypes, 
			List<String> firstModuleRuleNames, List<String> secondModuleRuleNames) {
		
		HashSet<String> firstModuleMMF = (HashSet<String>) new HashSet<String>();
		HashSet<String> secondModuleMMF = (HashSet<String>) new HashSet<String>();
		
    	// get footprints for each module based on their rules
    	for (RuleType r : modelRuleTypes.getRules()){
    		if (firstModuleRuleNames.contains(r.getName()))
    			firstModuleMMF.addAll(r.getAllFootPrints());
    		if (secondModuleRuleNames.contains(r.getName()))
    			secondModuleMMF.addAll(r.getAllFootPrints());
    	}
    	
    	// clean up footprints
    	firstModuleMMF = removeIncorrectOCLTypes(firstModuleMMF);
    	secondModuleMMF = removeIncorrectOCLTypes(secondModuleMMF);
    	
    	// calculate intersection
    	int firstModuleMMFsize = firstModuleMMF.size();
    	HashSet<String> intersectingMMF = firstModuleMMF;
    	intersectingMMF.retainAll(secondModuleMMF);
    	
    	// calculate intersection relative to first module
    	return firstModuleMMFsize > 0 ? intersectingMMF.size() / (double) firstModuleMMFsize : -1.0;
	}
	
	private static HashSet<String> removeIncorrectOCLTypes(HashSet<String> set) {
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String val = it.next();
			if(val == UNDEFINED || val == NULL)
				it.remove();
		}
		return set;
	}
	
	public static void main(String[] args) {			
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("xmi", new XMIResourceFactoryImpl());
	   
		
		String base = "";
		String typesModel = base + "models/OCL2R2ML/OCL2R2ML_Types.xmi";
		String moduleModel = base + "models/OCL2R2ML/OCL2R2ML_Dependencies_7_10_7.79881_1.70613.xmi";
		
		init();
		/* We load the model with the types of the rules */
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource typesResource = resSet.getResource(URI.createURI(typesModel), true);
	    TransformationType types = (TransformationType) typesResource.getContents().get(0);
	    
	    /* We load the model with the different modules */
	    Resource moduleResource = resSet.getResource(URI.createURI(moduleModel), true);	    
	    Transformation transformation = (Transformation) moduleResource.getContents().get(0);
		
		StopWatch watch = new StopWatch();
		watch.start();
		for(int i = 0; i < 5000; i++) {
			calculate(types, transformation);
//			System.out.println(calculate(typesModel, moduleModel));
		}
		watch.stop();
		System.out.println("5000: " + watch);
	}

}
