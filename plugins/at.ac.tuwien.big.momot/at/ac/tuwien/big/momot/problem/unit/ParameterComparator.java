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
package at.ac.tuwien.big.momot.problem.unit;

import java.util.Comparator;

import org.eclipse.emf.henshin.model.Parameter;

public class ParameterComparator implements Comparator<Parameter> {

	@Override
	public int compare(Parameter p1, Parameter p2) {
		String p1QN = p1.getUnit().getName() + "::" + p1.getName();
		String p2QN = p2.getUnit().getName() + "::" + p2.getName();
		
		return p1QN.compareTo(p2QN);
	}

}
