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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.statespace.Model;
import org.eclipse.emf.henshin.statespace.State;
import org.eclipse.emf.henshin.statespace.StateSpace;
import org.eclipse.emf.henshin.statespace.StateSpaceException;
import org.eclipse.emf.henshin.statespace.StateSpaceIndex;
import org.eclipse.emf.henshin.statespace.Transition;
import org.eclipse.emf.henshin.statespace.impl.BasicStateSpaceManager;
import org.eclipse.emf.henshin.statespace.impl.StateExplorer;

public class MomotStateSpaceManager extends BasicStateSpaceManager {

	private static Class<? extends StateExplorer> DEFAULT_EXPLORER = StateExplorer.class;

	private Class<? extends StateExplorer> explorerClass;

	public MomotStateSpaceManager(StateSpace stateSpace) {
		this(stateSpace, DEFAULT_EXPLORER);
	}

	public MomotStateSpaceManager(StateSpace stateSpace,
			Class<? extends StateExplorer> explorerClass) {
		super(stateSpace);
		this.explorerClass = explorerClass;
	}

	@Override
	protected StateExplorer acquireExplorer() {
		synchronized (explorers) {
			try {
				return explorers.pop();
			} catch (Throwable t) {
				try {
					return explorerClass.getConstructor(StateSpaceIndex.class)
							.newInstance(this);
				} catch (InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					return new StateExplorer(this);
				}
			}
		}
	}

	@Override
	public List<State> exploreState(State state, boolean generateLocation)
			throws StateSpaceException {
		return super.exploreState(state, generateLocation);
	}

	public List<State> exploreState(State state) throws StateSpaceException {
		return exploreState(state, false);
	}
	
	public List<Transition> exploreStateTransitions(List<State> states) throws StateSpaceException {
		return exploreStateTransitions(states, false);
	}

	public List<Transition> exploreStateTransitions(List<State> states, boolean generateLocation)
			throws StateSpaceException {
		List<Transition> transitions = new ArrayList<>();
		for (State state : states)
			transitions.addAll(exploreStateTransitions(state, generateLocation));
		return transitions;
	}

	public List<Transition> exploreStateTransitions(State state) throws StateSpaceException {
		return exploreStateTransitions(state, false);
	}
	
	public List<Transition> exploreStateTransitions(State state, boolean generateLocation)
			throws StateSpaceException {
		// copied from the beginning of exploreState method

		// Check if we exceeded the maximum state distance:
		if (maxStateDistance >= 0
				&& getStateDistance(state) >= maxStateDistance) {

			// START OF STATE SPACE LOCK
			synchronized (stateSpaceLock) {
				state.setOpen(false);
				state.setPruned(true);
			}
			// END OF STATE SPACE LOCK
			return Collections.emptyList();
		}

		// We need an explorer now:
		StateExplorer explorer = acquireExplorer();

		// Check if it is a goal state:
		if (explorer.isGoalState(state)) {

			// START OF STATE SPACE LOCK
			synchronized (stateSpaceLock) {
				state.setOpen(false);
				state.setPruned(true);
				state.setGoal(true);
			}
			// END OF STATE SPACE LOCK
			return Collections.emptyList();
		}

		// For debugging purposes:
		// checkEngineDeterminism(state);

		// Explore the state without changing the state space.
		// This can take some time. So no lock here.
		List<Transition> transitions = explorer.doExplore(state);

		if (transitions.isEmpty()) {
			releaseExplorer(explorer);

			// START OF STATE SPACE LOCK
			synchronized (stateSpaceLock) {
				// Mark the state as closed:
				state.setOpen(false);
			}
			// END OF STATE SPACE LOCK
			return Collections.emptyList();
		}

		// Now check which states or transitions need to be added.
		int count = transitions.size();
		int newStates = 0;
		
		for (int i = 0; i < count; i++) {

			// Transition details:
			Transition t = transitions.get(i);
			Rule rule = t.getRule();
			int match = t.getMatch();
			int[] parameters = t.getParameterKeys();

			// Get the hash and model of the new target state:
			int hashCode = t.getTarget().getHashCode();
			Model transformed = t.getTarget().getModel();

			// New state? Generate location?
			boolean newState = false;
			int[] location = generateLocation ? shiftedLocation(state,
					newStates++) : null;

			// Try to find the target state without locking the state space:
			State target;
			try {
				target = getState(transformed, hashCode);
			} catch (Throwable e) {
				target = null;
			}

			// START OF STATE SPACE LOCK
			synchronized (stateSpaceLock) {

				// Check if an equivalent state has been added in the meantime.
				if (target == null) {
					target = getState(transformed, hashCode);
				}
				// Check if the found state has been removed in the meantime.
				else if (target.getStateSpace() == null) {
					target = null;
				}

				// Ok, now we can create a new state if necessary.
				if (target == null) {
					target = createOpenState(transformed, hashCode, state,
							location);
					newState = true;
				}

				// Find or create the transition.
				int m = ignoreDuplicateTransitions ? -1 : match;
				if (newState
						|| state.getOutgoing(target, rule, m, parameters) == null) {
					t.setSource(state);
					t.setTarget(target);
					getStateSpace().incTransitionCount();
					if (stateDistanceMonitor != null) {
						stateDistanceMonitor.updateDistance(target);
					}
				}

				// Now that the transition is there, we can decide whether to
				// cache the model.
				if (newState) {
					addToCache(target, transformed);
				}

				if (i == count - 1) {
					// Mark the state as closed:
					state.setOpen(false);
				}
			}
			// END OF STATE SPACE LOCK

		}

		// Release the explorer again (not earlier).
		releaseExplorer(explorer);
		return transitions;
	}
}
