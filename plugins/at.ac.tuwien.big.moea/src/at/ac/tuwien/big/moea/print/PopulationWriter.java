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

import at.ac.tuwien.big.moea.util.CastUtil;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.moeaframework.core.Population;
import org.moeaframework.core.Solution;

public class PopulationWriter<S extends Solution> implements IPopulationWriter<S> {

   private final ISolutionWriter<S> solutionPrinter;
   private final Class<S> solutionClazz;

   public PopulationWriter(final Class<S> solutionClazz, final ISolutionWriter<S> solutionPrinter) {
      this.solutionClazz = solutionClazz;
      this.solutionPrinter = solutionPrinter;
   }

   public ISolutionWriter<S> getSolutionPrinter() {
      return solutionPrinter;
   }

   @Override
   public String write(final Iterable<S> population) {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      final PrintStream ps = new PrintStream(baos);
      write(ps, population);
      ps.close();
      try {
         return baos.toString("UTF-8");
      } catch(final UnsupportedEncodingException e) {
         return e.getMessage();
      }
   }

   @Override
   public String write(final Population population) {
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      final PrintStream ps = new PrintStream(baos);
      write(ps, population);
      ps.close();
      try {
         return baos.toString("UTF-8");
      } catch(final UnsupportedEncodingException e) {
         return e.getMessage();
      }
   }

   @Override
   public void write(final PrintStream ps, final Iterable<S> population) {
      if(population == null) {
         ps.println("No population.");
         return;
      }

      Integer size = null;
      if(population instanceof Collection<?>) {
         size = ((Collection<S>) population).size();
      }

      ps.println("Population with " + size != null ? size + " " : "" + "solution(s):");
      int solutionNr = 1;
      for(final Solution solution : population) {
         ps.println("\n------------------");
         ps.println("Solution " + solutionNr++ + size != null ? "/" + size : "");
         ps.println("------------------");
         getSolutionPrinter().write(ps, CastUtil.asClass(solution, solutionClazz));
      }
   }

   @Override
   public void write(final PrintStream ps, final Population population) {
      if(population == null) {
         ps.println("No population.");
         return;
      }

      final Integer size = population.size();

      ps.println("Population with " + size + " solution(s):");
      int solutionNr = 1;
      for(final Solution solution : population) {
         ps.println("\n------------------");
         ps.println("Solution " + solutionNr++ + "/" + size);
         ps.println("------------------");
         getSolutionPrinter().write(ps, CastUtil.asClass(solution, solutionClazz));
      }
   }
}
