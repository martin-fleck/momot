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
package at.ac.tuwien.big.momot.problem.solution.variable;

import java.util.List;

import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.model.Parameter;
import org.moeaframework.core.Variable;

public interface ITransformationVariable extends UnitApplication, IChangeVariable<Parameter>, Comparable<ITransformationVariable> {
	@Override
	ITransformationVariable copy();
	
	Engine getEngine();
	boolean execute();
	boolean execute(boolean reexecute);
	boolean isExecuted();
	boolean isUndone();
		

	@Override
	public default List<Parameter> getParameters() {
		return getUnit().getParameters();
	}
}
