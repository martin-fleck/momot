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
package at.ac.tuwien.big.moea.search.algorithm.operator;

import org.moeaframework.core.Variation;

public interface IProbabilityVariation extends Variation {
	static final double ALWAYS_EVOLVE = 1.0;
	static final double NEVER_EVOLVE = 0.0;
	
	double getProbability();
}
