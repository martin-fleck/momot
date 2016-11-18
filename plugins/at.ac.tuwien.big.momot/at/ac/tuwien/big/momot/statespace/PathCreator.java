/*******************************************************************************
 * Copyright (c) 2015 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 *******************************************************************************/
package at.ac.tuwien.big.momot.statespace;

import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.InterpreterFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.statespace.Path;
import org.eclipse.emf.henshin.statespace.State;
import org.eclipse.emf.henshin.statespace.StateSpace;
import org.eclipse.emf.henshin.statespace.StateSpaceException;
import org.eclipse.emf.henshin.statespace.StateSpaceFactory;
import org.eclipse.emf.henshin.statespace.Transition;
import org.eclipse.emf.henshin.statespace.impl.ModelImpl;
import org.eclipse.emf.henshin.statespace.resource.StateSpaceResourceSet;

public class PathCreator {
	private static final Random RANDOM = new Random();
	
	private final Engine engine;
	private final Module module;
	private final StateSpaceResourceSet resourceSet;
	private final StateSpace stateSpace;
	private final MomotStateSpaceManager manager;
	
	public PathCreator(String path, String moduleFile, String stateSpaceFile) {
		this.engine = InterpreterFactory.INSTANCE.createEngine();
		this.engine.getOptions().put(Engine.OPTION_DETERMINISTIC, Boolean.TRUE); // really make sure it is deterministic
		
		this.resourceSet = new StateSpaceResourceSet(path);
		
		this.module = resourceSet.getModule(moduleFile, false);
		
		this.stateSpace = StateSpaceFactory.eINSTANCE.createStateSpace(this.module);
		this.stateSpace.getProperties().put(StateSpace.PROPERTY_COLLECT_MISSING_ROOTS, "true");
		resourceSet.saveEObject(this.stateSpace, stateSpaceFile);
		
		this.manager = new MomotStateSpaceManager(stateSpace, MomotStateExplorer.class);
	}
	
	public void addInitialState(EGraph graph) throws StateSpaceException {
		this.manager.createInitialState(new ModelImpl(graph.getRoots().get(0).eResource(), graph));
	}
	
	public EList<State> getInitialStates() {
		return manager.getStateSpace().getInitialStates();
	}
	
	public Path createRandom() throws StateSpaceException {
		return createRandom(-1);
	}
	
	public Path createRandom(int maxSteps) throws StateSpaceException {
		if(maxSteps == 0 || getInitialStates().isEmpty())
			return new Path();
		
		Path path = new Path();
		int step = 0;
		List<Transition> possibleTransitions = manager.exploreStateTransitions(getInitialStates());
		while(!possibleTransitions.isEmpty() && step <= maxSteps) {
			Transition transition = chooseTransition(possibleTransitions);
			path.add(transition);
			possibleTransitions = manager.exploreStateTransitions(transition.getTarget());
			step++;
		}
		
		return path;
	}
	
	public Transition chooseTransition(List<Transition> transitions) {
		if(transitions.size() == 0)
			return null;
		return transitions.get(RANDOM.nextInt(transitions.size()));
	}
}
