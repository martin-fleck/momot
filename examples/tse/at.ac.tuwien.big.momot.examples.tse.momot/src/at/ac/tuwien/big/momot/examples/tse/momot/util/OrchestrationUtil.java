package at.ac.tuwien.big.momot.examples.tse.momot.util;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import at.ac.tuwien.big.moea.util.TextUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;
import at.ac.tuwien.big.momot.examples.tse.momot.henshin.ModularizationModule;
import at.ac.tuwien.big.momot.examples.tse.momot.orchestration.ModularizationOrchestration;
import at.ac.tuwien.big.momot.problem.unit.parameter.increment.IncrementalStringValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.increment.IncrementalStringValue.StringMode;

public class OrchestrationUtil {	
	public static ModuleManager FACTORY = createMomotFactory();
	
	public static HenshinResourceSet createResourceSet() {
		HenshinResourceSet resourceSet = new HenshinResourceSet();
		Module module = resourceSet.getModule("henshin/modularization_rules.henshin", false);
		Registry packageRegistry = resourceSet.getPackageRegistry();
		for (EPackage ePackage : module.getImports()) 
			packageRegistry.put(ePackage.getNsURI(), ePackage);
		return resourceSet;
	}
	
	public static ModuleManager createMomotFactory() {
		ModuleManager orchestration = new ModuleManager();	
		orchestration.addModule("henshin/modularization_rules.henshin");
		return orchestration;
	}
	
	public static ModuleManager createHenshinOrchestration() {
		return new ModuleManager("", "henshin/modularization_rules.henshin");
	}
	
	public static String getReferenceFileURI(String transformationURI) {
		String prefix = FACTORY.getBaseDir() != null ? FACTORY.getBaseDir() : "";
		return prefix + transformationURI.replaceFirst(".xmi", ".csv");
	}
	
	public static ModularizationOrchestration createReassignmentOrchestration(String initialGraph, int nrModules, int nrVariables) {
		return createReassignmentOrchestration(FACTORY.loadGraph(initialGraph), nrModules, nrVariables);
	}
	
	public static ModularizationOrchestration createReassignmentOrchestration(EGraph initialGraph, int nrModules, int nrVariables) {
		EGraph searchGraph = initialGraph.copy(null);
		Transformation root = ModularizationUtil.assertTransformationRoot(searchGraph);
		
		if(root.getModules().size() < nrModules) {
			String name = root.getModules().get(0).getName() + "A";
		    RuleApplication createModuleApp = FACTORY.createRuleApplication(ModularizationModule.CreateModule.NAME, searchGraph);
			while(root.getModules().size() < nrModules) {
				createModuleApp.setParameterValue(
						FACTORY.getParameter(ModularizationModule.CreateModule.Parameter.NAME).getName(), 
						name);
				name = TextUtil.increment(name);
				createModuleApp.execute(null);
			}
			
//			RuleApplication moveRule = FACTORY.createRuleApplication(ModularizationRules.DistributeRule.RULE, searchGraph);
//			RuleApplication moveHelper = FACTORY.createRuleApplication(ModularizationRules.DistributeHelper.RULE, searchGraph);
//			int movedRulesHelper = 0;
//			while(movedRulesHelper < (nrModules - 1)) {
//				boolean isRule = PRNG.nextBoolean();
//				RuleApplication ruleApp = isRule ? moveRule : moveHelper;
//				ruleApp.setParameterValue("source", sourceModule);
//				boolean executed = ruleApp.execute(null);
//	
//				if(executed) 
//					movedRulesHelper++;
//			}
		}
		
		ModularizationOrchestration orchestration = new ModularizationOrchestration(
				createHenshinOrchestration(), searchGraph, nrVariables);
		
		orchestration.getModuleManager().removeUnit(ModularizationModule.CreateModule.NAME);
		orchestration.getModuleManager().removeUnit(ModularizationModule.AssignRule.NAME);
		orchestration.getModuleManager().removeUnit(ModularizationModule.AssignHelper.NAME);
		orchestration.getModuleManager().removeUnit(ModularizationModule.DistributeRule.NAME);
		orchestration.getModuleManager().removeUnit(ModularizationModule.DistributeHelper.NAME);
				
		return orchestration;
	}
	

	public static ModularizationOrchestration createCreateOrchestration(String initialGraph, int nrVariables) {
		return getCreateOrchestration(FACTORY.loadGraph(initialGraph), nrVariables);
	}
	
	public static ModularizationOrchestration getCreateOrchestration(EGraph initialGraph, int nrVariables) {
		EGraph searchGraph = initialGraph.copy(null);
		Transformation root = ModularizationUtil.assertTransformationRoot(searchGraph);		
		ModularizationOrchestration orchestration = new ModularizationOrchestration(createHenshinOrchestration(), searchGraph, nrVariables);
	
		orchestration.getModuleManager().setParameterValue(
				ModularizationModule.CreateModule.Parameter.NAME, 
				new IncrementalStringValue(
						root.getModules().get(0).getName(), "A", "", StringMode.CAPITALIZED));
		
		orchestration.getModuleManager().removeUnit(ModularizationModule.DistributeRule.NAME);
		orchestration.getModuleManager().removeUnit(ModularizationModule.DistributeHelper.NAME);
		
		return orchestration;
	}
}
