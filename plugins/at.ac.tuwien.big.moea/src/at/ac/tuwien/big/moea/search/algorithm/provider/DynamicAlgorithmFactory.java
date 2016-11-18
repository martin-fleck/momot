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
package at.ac.tuwien.big.moea.search.algorithm.provider;

import java.util.Properties;

import org.moeaframework.core.Algorithm;
import org.moeaframework.core.Problem;
import org.moeaframework.core.spi.AlgorithmFactory;

public class DynamicAlgorithmFactory extends AlgorithmFactory {

	private DynamicAlgorithmProvider dynamicProvider = new DynamicAlgorithmProvider();
	
	@Override
	public synchronized Algorithm getAlgorithm(String name, 
			Properties properties, Problem problem) {
		Algorithm algorithm = dynamicProvider.getAlgorithm(name, properties, problem);
		if (algorithm != null) 
			return algorithm;
		return super.getAlgorithm(name, properties, problem);
	}
}
