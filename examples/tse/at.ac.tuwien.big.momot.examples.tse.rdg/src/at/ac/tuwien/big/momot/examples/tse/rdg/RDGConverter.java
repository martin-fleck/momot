package at.ac.tuwien.big.momot.examples.tse.rdg;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.util.EcoreUtil;

import at.ac.tuwien.big.momot.examples.tse.modularization.Helper;
import at.ac.tuwien.big.momot.examples.tse.modularization.ModularizationFactory;
import at.ac.tuwien.big.momot.examples.tse.modularization.Module;
import at.ac.tuwien.big.momot.examples.tse.modularization.Rule;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;

public class RDGConverter {
	private static ModularizationFactory factory = ModularizationFactory.eINSTANCE;
	
	public static RDG toRDG(Transformation transformation) {
		Map<String, Boolean> responsibilities = new HashMap<>();
		for(Module module : transformation.getModules()) {
			for(Rule rule : module.getRules())
				responsibilities.put(rule.getName(), true);
			for(Helper helper : module.getHelpers())
				responsibilities.put(helper.getName(), false);
		}
		RDG rdg = new RDG(transformation.getName(), responsibilities);
		for(Module module : transformation.getModules()) {
			for(Rule rule : module.getRules()) {
				for(Rule target : rule.getRuleDependencies())
					rdg.setDependency(rule.getName(), target.getName());
				// inheritance is treated as normal dependency
				for(Rule target : rule.getInheritsFrom())
					rdg.setDependency(rule.getName(), target.getName());
				for(Helper target : rule.getHelperDependencies())
					rdg.setDependency(rule.getName(), target.getName());
			}
			for(Helper helper : module.getHelpers()) {
				for(Helper target : helper.getHelperDependencies())
					rdg.setDependency(helper.getName(), target.getName());
			}
		}
		return rdg;
	}
	
	public static Transformation assignModules(Transformation transformation, RDG rdg, boolean create) {
		Transformation trans = create ? EcoreUtil.copy(transformation) : transformation;
		Map<String, Rule> rules = new HashMap<>();
		Map<String, Helper> helpers = new HashMap<>();
		for(Module module : trans.getModules()) {
			for(Rule rule : module.getRules()) 
				rules.put(rule.getName(), rule);
			for(Helper helper : module.getHelpers()) 
				helpers.put(helper.getName(), helper);
		}
		
		trans.getModules().clear();
		Map<String, Module> modules = new HashMap<>();
		for(Entry<String, String> assignment : rdg.calculateModuleNameAssignment().entrySet()) {
			String moduleName = assignment.getValue();
			String responsibilityName = assignment.getKey();
			Module module = modules.get(moduleName);
			if(module == null) {
				module = factory.createModule();
				module.setName(moduleName);
				modules.put(moduleName, module);
			}
			if(rdg.isRule(responsibilityName))
				module.getRules().add(rules.get(responsibilityName));
			else
				module.getHelpers().add(helpers.get(responsibilityName));
			trans.getModules().add(module);
		}
		return trans;
	}
	
	public static Transformation assignModules(Transformation transformation, RDG rdg) {
		return assignModules(transformation, rdg, false);
	}
}
