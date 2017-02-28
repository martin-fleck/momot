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
package at.ac.tuwien.big.moea.experiment.instrumenter;

import at.ac.tuwien.big.moea.problem.ISearchProblem;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.moeaframework.Instrumenter;
import org.moeaframework.analysis.collector.Accumulator;
import org.moeaframework.analysis.collector.Collector;
import org.moeaframework.analysis.collector.InstrumentedAlgorithm;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;

public class SearchInstrumenter extends Instrumenter {
   protected List<Accumulator> accumulators = new ArrayList<>();

   private final List<String> allowedPackages;

   public SearchInstrumenter() {
      // MOEA 2.12 no longer uses "allowed packages", but instead scans everything but java.*
      // This can lead to problems in some situations where hashCode() is not implemented
      // (e.g., WekEList from ECore). Therefore, some "old" functionality is re-implemented here.
      // In tests, this lead to errors on the 1+ run
      allowedPackages = new ArrayList<>();
      allowedPackages.add("org.moeaframework");
      allowedPackages.add("at.ac.tuwien.big.moea");
      allowedPackages.add("at.ac.tuwien.big.momot");
      // super.addAllowedPackage("at.ac.tuwien.big.moea");
      // super.addAllowedPackage("at.ac.tuwien.big.momot");
   }

   public SearchInstrumenter(final ISearchProblem<? extends Solution> problem) {
      this();
      withProblem(problem);
   }

   protected void addAccumulator(final Accumulator accumulator) {
      if(!accumulators.contains(accumulator)) {
         accumulators.add(accumulator);
      }
   }

   public List<Accumulator> getAccumulators() {
      return accumulators;
   }

   @Override
   protected void instrument(final InstrumentedAlgorithm algorithm, final List<Collector> collectors,
         final Set<Object> visited, final Stack<Object> parents, final Object object, Class<?> type) {
      // super.instrument(algorithm, collectors, visited, parents, object, type);

      // From Instrumenter.java ---------->

      if(object == null) {
         return;
      } else if(type == null || type.equals(object.getClass())) {
         try {
            if(visited.contains(object)) {
               return;
            }
         } catch(final NullPointerException e) {
            // proxies will sometimes result in NPEs when calling hashCode
            return;
         }

         type = object.getClass();
      }

      if(type.isAnnotation() || type.isEnum() || type.isPrimitive()) {
         // ignore objects which are not classes or arrays
         return;
      } else if(object instanceof Instrumenter) {
         // well this is embarrassing
         return;
      } else if(type.isArray()) {
         // recursively walk the elements in the array
         for(int i = 0; i < Array.getLength(object); i++) {
            instrument(algorithm, collectors, visited, parents, Array.get(object, i), null);
         }
      } else if(object instanceof Collection) {
         // recursively walk the elements in the array
         for(final Object element : (Collection<?>) object) {
            instrument(algorithm, collectors, visited, parents, element, null);
         }
      } else if(type.getPackage() != null) {
         // NOTE: MOEA deprecated the following in their current implementation. This causes
         // side effects that are undesired when dealing with ECore models. Hence it was
         // brought back.

         // do not visit objects that are in inaccessible packages
         boolean allowed = false;

         for(final String packageName : allowedPackages) {
            if(type.getPackage().getName().startsWith(packageName)) {
               allowed = true;
               break;
            }
         }

         if(!allowed) {
            return;
         }
      }

      if(!visited.contains(object)) {
         // attach any matching collectors
         for(final Collector collector : collectors) {
            if(collector.getAttachPoint().matches(parents, object)) {
               algorithm.addCollector(collector.attach(object));
            }
         }

         visited.add(object);
      }

      // recursively walk superclass to enumerate all non-public fields
      final Class<?> superclass = type.getSuperclass();

      if(superclass != null) {
         instrument(algorithm, collectors, visited, parents, object, superclass);
      }

      // recursively walk fields
      parents.push(object);

      for(final Field field : type.getDeclaredFields()) {
         field.setAccessible(true);

         try {
            instrument(algorithm, collectors, visited, parents, field.get(object), null);
         } catch(final IllegalArgumentException e) {
            // should never occur since object is of the specified type
            e.printStackTrace();
         } catch(final IllegalAccessException e) {
            // should never occur after setting field.setAccessible(true)
            e.printStackTrace();
         }
      }

      parents.pop();

      // <--------- From Instrumenter.java

      addAccumulator(getLastAccumulator());
   }

   public SearchInstrumenter withProblem(final ISearchProblem<? extends Solution> problem) {
      return withProblemClass(problem.getClass(), problem.getFitnessFunction(), problem.getSolutionGenerator());
   }

   @Override
   public SearchInstrumenter withProblem(final Problem problemInstance) {
      return (SearchInstrumenter) super.withProblem(problemInstance);
   }

   @Override
   public SearchInstrumenter withProblemClass(final Class<?> problemClass, final Object... problemArguments) {
      return (SearchInstrumenter) super.withProblemClass(problemClass, problemArguments);
   }
}
