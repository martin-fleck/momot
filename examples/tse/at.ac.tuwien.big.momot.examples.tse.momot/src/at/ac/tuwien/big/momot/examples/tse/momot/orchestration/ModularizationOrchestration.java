package at.ac.tuwien.big.momot.examples.tse.momot.orchestration;

import org.eclipse.emf.henshin.interpreter.EGraph;

import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.tse.momot.henshin.ModularizationModule;
import at.ac.tuwien.big.momot.examples.tse.momot.util.ModularizationUtil;

public class ModularizationOrchestration extends TransformationSearchOrchestration {

	public ModularizationOrchestration(String path, String moduleFile, EGraph initialGraph, int nrVariables) {
		super(new ModuleManager(path, moduleFile), initialGraph, nrVariables);
		init();
	}
	
	public ModularizationOrchestration(ModuleManager henshinOrchestration, int nrVariables) {
		super(henshinOrchestration, nrVariables);
		init();
	}

	public ModularizationOrchestration(
			ModuleManager henshinOrchestration, EGraph problemGraph,
			int solutionLength) {
		super(henshinOrchestration, problemGraph, solutionLength);
		init();
	}

	public ModularizationOrchestration(
			ModuleManager henshinOrchestration, EGraph problemGraph) {
		super(henshinOrchestration, problemGraph);
		init();
	}

	public ModularizationOrchestration(
			ModuleManager henshinOrchestration, String problemGraphUri,
			int solutionLength) {
		super(henshinOrchestration, problemGraphUri, solutionLength);
		init();
	}

	public ModularizationOrchestration(
			ModuleManager henshinOrchestration, String problemGraphUri) {
		super(henshinOrchestration, problemGraphUri);
		init();
	}

	public ModularizationOrchestration(ModuleManager henshinOrchestration) {
		super(henshinOrchestration);
		init();
	}

	private void init() {
		ModularizationUtil.assertTransformationRoot(getProblemGraph());
		
		getModuleManager().removeUnits(
			ModularizationModule.AssignHelper.NAME,
			ModularizationModule.AssignRule.NAME);
			
		setFitnessFunction(
			new ModularizationFitnessFunction());
	}
	
	@Override
	public ModularizationFitnessFunction getFitnessFunction() {
		return (ModularizationFitnessFunction) super.getFitnessFunction();
	}
}
