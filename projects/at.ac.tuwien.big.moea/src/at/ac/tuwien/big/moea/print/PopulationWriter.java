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
package at.ac.tuwien.big.moea.print;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.moeaframework.core.Population;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.util.CastUtil;

public class PopulationWriter<S extends Solution> implements IPopulationWriter<S> {
	
	private ISolutionWriter<S> solutionPrinter;
	private Class<S> solutionClazz;

	public PopulationWriter(Class<S> solutionClazz, ISolutionWriter<S> solutionPrinter) {
		this.solutionClazz = solutionClazz;
		this.solutionPrinter = solutionPrinter;		
	}

	public ISolutionWriter<S> getSolutionPrinter() {
		return solutionPrinter;
	}

	@Override
	public String write(Iterable<S> population) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		write(ps, population);
		ps.close();
		try {
			return baos.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return e.getMessage();
		}
	}
	
	@Override
	public String write(Population population) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		write(ps, population);
		ps.close();
		try {
			return baos.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			return e.getMessage();
		}
	}

	@Override
	public void write(PrintStream ps, Population population) {
		if(population == null) {
			ps.println("No population.");
			return;
		}
		
		Integer size = population.size();
		
		ps.println("Population with " + size + " solution(s):");
		int solutionNr = 1;
		for(Solution solution : population) {
			ps.println("\n------------------");
			ps.println("Solution " + solutionNr++ + "/" + size);
			ps.println("------------------");
			getSolutionPrinter().write(ps, CastUtil.asClass(solution, solutionClazz));
		}
	}
	
	@Override
	public void write(PrintStream ps, Iterable<S> population) {
		if(population == null) {
			ps.println("No population.");
			return;
		}
		
		Integer size = null;
		if (population instanceof Collection<?>) 
			size = ((Collection<S>) population).size();
		
		ps.println("Population with " + size != null ? size + " " : "" + "solution(s):");
		int solutionNr = 1;
		for(Solution solution : population) {
			ps.println("\n------------------");
			ps.println("Solution " + solutionNr++ + size!= null ? "/" + size : "");
			ps.println("------------------");
			getSolutionPrinter().write(ps, CastUtil.asClass(solution, solutionClazz));
		}
	}
}