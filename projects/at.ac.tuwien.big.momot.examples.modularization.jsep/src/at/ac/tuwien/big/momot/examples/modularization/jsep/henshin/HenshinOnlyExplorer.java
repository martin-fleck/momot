package at.ac.tuwien.big.momot.examples.modularization.jsep.henshin;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.henshin.statespace.StateSpace;
import org.eclipse.emf.henshin.statespace.StateSpaceException;
import org.eclipse.emf.henshin.statespace.StateSpaceFactory;
import org.eclipse.emf.henshin.statespace.StateSpaceManager;
import org.eclipse.emf.henshin.statespace.resource.StateSpaceResourceSet;
import org.eclipse.emf.henshin.statespace.util.StateSpaceExplorationHelper;

public class HenshinOnlyExplorer {
	public static void main(String[] args) throws StateSpaceException {
		StateSpaceResourceSet resourceSet = new StateSpaceResourceSet("my/working/directory");
		StateSpace stateSpace = resourceSet.getStateSpace("myexample.statespace");
		StateSpaceManager manager = StateSpaceFactory.eINSTANCE.createStateSpaceManager(stateSpace, 4);
		 
		// Exploring:
		StateSpaceExplorationHelper helper = new StateSpaceExplorationHelper(manager);
		helper.doExploration(-1, new NullProgressMonitor());
	}
}
