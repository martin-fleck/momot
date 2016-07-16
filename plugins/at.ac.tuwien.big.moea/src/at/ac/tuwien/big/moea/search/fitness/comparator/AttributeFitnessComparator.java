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
package at.ac.tuwien.big.moea.search.fitness.comparator;

import java.io.Serializable;

import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.util.CastUtil;

public class AttributeFitnessComparator<C extends Comparable<C> & Serializable, S extends Solution> extends AbstractFitnessComparator<C, S> {

	private String attributeName;
	private Class<C> comparableClass;

	public AttributeFitnessComparator(String attributeName, Class<C> comparableClass) {
		this.attributeName = attributeName;
		this.comparableClass = comparableClass;
	}
	
	public String getAttributeName() {
		return attributeName;
	}
	
	public Class<C> getComparableClass() {
		return comparableClass;
	}
	
	@Override
	public C getValue(S solution) {
		return CastUtil.asClass(solution.getAttribute(getAttributeName()), getComparableClass());
	}
}
