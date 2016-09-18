package at.ac.tuwien.big.momot.examples.tse.metric.calc;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.time.StopWatch;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import at.ac.tuwien.big.momot.examples.tse.modularization.Helper;
import at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationPackage;
import at.ac.tuwien.big.momot.examples.tse.modularization.Module;
import at.ac.tuwien.big.momot.examples.tse.modularization.Rule;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;

public class FMeasureCalculator {
//	final static String modelWithIdealClustering = "models/OCL2R2ML/OCL2R2ML_Manual_Modularization.xmi";
//	final static String modelWithComputedClustering = "models/TopWorst5/OCL2R2ML_Dependencies_32_1_5_19.xmi";

	public static void calculate(String idealModel, String directory) {
		ModularizationPackage.eINSTANCE.eClass();
		   
	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("xmi", new XMIResourceFactoryImpl());

	    /*We load the model with the types of the rules*/
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource idealResource = resSet.getResource(URI.createURI(idealModel), true);
	    Transformation  idealModularization = (Transformation) idealResource.getContents().get(0);
	    ArrayList<Pair> idealPairs = obtainPairs(idealModularization);
	    
	    File dir = new File(directory);
	    System.out.println("Files: " + dir.list().length);
	    System.out.println("File\tModules\tMinMaxDiff\tCohesionRatio\tCouplingRatio\tF-measure");
	    StopWatch watch = new StopWatch();
	    watch.start();
	    for(String file : dir.list()) {
	    	try {
		    	if(!file.endsWith(".xmi")) // only consider models
		    		continue;
		    	
			    /* We load the model with the different modules */
		    	
			    ResourceSet resourceSet = new ResourceSetImpl();
			    Resource resource = resourceSet.getResource(URI.createURI("models/All/" + file), true);	    
			    Transformation automatedModularization = (Transformation) resource.getContents().get(0);
			    
			    /* pairsIdeal contains the member pairs in the ideal clustering
			     * pairsComputed contains the member pairs in the computed clustering
			     * a contains the member pairs that occur in both partitions
			     * b contains the member pairs that occur in the ideal clustering but not in the computed clustering
			     * c contains the member pairs that occur in the computed clustering but not in the ideal clustering
			     */
			    
			    ArrayList<Pair> automatedPairs = obtainPairs(automatedModularization);
			    ArrayList<Pair> a = calculateA(idealPairs, automatedPairs);
			    ArrayList<Pair> b = calculateB_C(idealPairs, automatedPairs);
			    ArrayList<Pair> c = calculateB_C(automatedPairs, idealPairs);
			    
			    double fMeasure = (double) 2*a.size() / (2*a.size()+b.size()+c.size());
			    
			    String[] parts = file.split("_");
			    System.out.println(
			    		file + 
			    		"\t" + parts[2] + 
			    		"\t" + parts[3] + 
			    		"\t" + parts[4] + 
			    		"\t" + parts[5].replace(".xmi", "") +
			    		"\t" + fMeasure);	    
		    } catch(Exception e) {
		    	System.err.println(e.getMessage());
		    }
	    }
	    watch.stop();
    	System.out.println("Finished after " + watch);
	}
	
	private static ArrayList<Pair> obtainPairs(Transformation modelModularization){
		ArrayList<Pair> result = new ArrayList<Pair>();
		for (Module m : modelModularization.getModules()){
			for (Rule r : m.getRules()){ //we first include the member pairs between rule-rule and rule-helper
				for (Rule r2 : m.getRules()){
					/* In order to avoid pairs with the same rule and to avoid the creation of opposite pairs, we include the following condition */
					if (m.getRules().indexOf(r) < m.getRules().indexOf(r2))
						result.add(new Pair(r.getName(), r2.getName()));
				}
				for (Helper h : m.getHelpers())
						result.add(new Pair(r.getName(), h.getName()));
			}
			for (Helper h : m.getHelpers()){//and now the pairs helper-helper
				for (Helper h2 : m.getHelpers()){
					if (m.getHelpers().indexOf(h) < m.getHelpers().indexOf(h2))
						result.add(new Pair(h.getName(),h2.getName()));
				}
			}
		}
		return result;
	}
	
	private static ArrayList<Pair> calculateA(ArrayList<Pair> pairsA, ArrayList<Pair> pairsB){
		ArrayList<Pair> a = new ArrayList<Pair>();
		for (Pair p : pairsA){
			for (Pair p2 : pairsB){
				if (p.equals(p2))
					a.add(p);
			}
		}
		return a;
	}
	
	private static ArrayList<Pair> calculateB_C(ArrayList<Pair> pairsA, ArrayList<Pair> pairsB){
		ArrayList<Pair> b = new ArrayList<Pair>();
		for (Pair p : pairsA){
			if (!pairsB.contains(p) && !pairsB.contains(p.reverse(p)))
				b.add(p);
		}
		return b;
	}
	
	public static class Pair {
		private final String left;
		private final String right;
		
		public Pair (String left, String right){
			this.left = left;
			this.right = right;
		}
		
		public String getLeft() {
			return left;
		}
		
		public String getRight() {
			return right;
		}
		
		@Override
		public int hashCode() { return left.hashCode() ^ right.hashCode(); }

		/* For the comparison of two pairs, due to the way in which we compute the pairs in the Main.java program,
		 * we consider that pairs (1,2)-(1,2) are equals, but also pairs (1,2)-(2,1)
		 */
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Pair)) return false;
		    Pair pairo = (Pair) o;
		    return this.left.equals(pairo.getLeft()) &&
		           this.right.equals(pairo.getRight()) ||
		           this.left.equals(pairo.getRight()) &&
		           this.right.equals(pairo.getLeft());
		 }
		
		@Override
		public String toString(){
			return "[" + this.left + "," + this.right + "]";
		}
		
		public Pair reverse(Pair p) {
			return new Pair(p.right, p.left);
		}

	}
}
