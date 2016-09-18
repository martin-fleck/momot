package at.ac.tuwien.big.momot.examples.tse.rdg.metric;

import at.ac.tuwien.big.momot.examples.tse.metric.calc.MetaModelFootprintCalculator;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType;

public class RDGMetaModelFootprintCalculator extends MetaModelFootprintCalculator {
	public static double calculate(TransformationType types, RDGTransformationMetrics metrics) {		
		double average = 0.0;
		int count = 0;
		for(Integer firstIndex : metrics.getModules()) {
			RDGModuleMetrics firstModule = metrics.getMetrics(firstIndex);
			for(Integer secondIndex : metrics.getModules()) {
				RDGModuleMetrics secondModule = metrics.getMetrics(secondIndex);
				double factor = calculateModuleIntersection(types, firstModule.getRules(), secondModule.getRules());
				if(firstIndex != secondIndex && factor >= 0.0) {
	    			count++;
	    			average += factor;
	    		}
			}
		}    
	    return average / count;
	}
}
