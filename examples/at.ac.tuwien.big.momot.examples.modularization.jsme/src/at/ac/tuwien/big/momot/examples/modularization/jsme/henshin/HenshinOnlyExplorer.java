package at.ac.tuwien.big.momot.examples.modularization.jsme.henshin;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.henshin.statespace.StateSpace;
import org.eclipse.emf.henshin.statespace.StateSpaceException;
import org.eclipse.emf.henshin.statespace.StateSpaceFactory;
import org.eclipse.emf.henshin.statespace.StateSpaceManager;
import org.eclipse.emf.henshin.statespace.resource.StateSpaceResourceSet;
import org.eclipse.emf.henshin.statespace.util.StateSpaceExplorationHelper;

public class HenshinOnlyExplorer {
   public static void main(final String[] args) throws StateSpaceException {
      final StateSpaceResourceSet resourceSet = new StateSpaceResourceSet("my/working/directory");
      final StateSpace stateSpace = resourceSet.getStateSpace("myexample.statespace");
      final StateSpaceManager manager = StateSpaceFactory.eINSTANCE.createStateSpaceManager(stateSpace, 4);

      // Exploring:
      final StateSpaceExplorationHelper helper = new StateSpaceExplorationHelper(manager);
      helper.doExploration(-1, new NullProgressMonitor());
   }
}
