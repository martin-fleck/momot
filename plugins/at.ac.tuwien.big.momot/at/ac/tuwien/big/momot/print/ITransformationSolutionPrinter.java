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
package at.ac.tuwien.big.momot.print;

import org.eclipse.emf.henshin.interpreter.EGraph;

import at.ac.tuwien.big.moea.print.ISolutionWriter;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

public interface ITransformationSolutionPrinter extends ISolutionWriter<TransformationSolution> {
	String write(EGraph graph);
}
