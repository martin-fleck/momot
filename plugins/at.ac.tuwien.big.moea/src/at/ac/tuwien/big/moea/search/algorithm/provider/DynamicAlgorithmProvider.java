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

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.moeaframework.core.Algorithm;
import org.moeaframework.core.Problem;
import org.moeaframework.core.spi.AlgorithmProvider;

public class DynamicAlgorithmProvider extends AlgorithmProvider {

   private static Map<String, IRegisteredAlgorithm<?>> registeredAlgorithms = new HashMap<>();

   public static void clear() {
      registeredAlgorithms.clear();
   }

   public static IRegisteredAlgorithm<?> getAlgorithm(final String name) {
      return registeredAlgorithms.get(name);
   }

   public static boolean registerAlgorithm(final String name, final IRegisteredAlgorithm<?> registeredAlgorithm) {
      if(registeredAlgorithms.containsKey(name)) {
         return false;
      }
      registeredAlgorithms.put(name, registeredAlgorithm);
      return true;
   }

   public static IRegisteredAlgorithm<?> removeAlgorithm(final String name) {
      return registeredAlgorithms.remove(name);
   }

   @Override
   public Algorithm getAlgorithm(final String name, final Properties properties, final Problem problem) {
      final IRegisteredAlgorithm<?> registered = getAlgorithm(name);
      if(registered == null) {
         return null;
      }
      final Algorithm algorithm = registered.createAlgorithm();
      if(algorithm != null) {
         if(!algorithm.getProblem().getName().equals(problem.getName())) {
            System.err.println("Algorithm retrieved for wrong problem: " + algorithm.getProblem().getName() + " vs "
                  + problem.getName());
         }
      }
      return algorithm;
   }
}
