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
package at.ac.tuwien.big.momot.util;

import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.moeaframework.core.Population;
import org.moeaframework.core.Solution;

public final class MomotUtil {

   /**
    * Specific {@link CrossReferencer} to detect dangling references.
    */
   private static class DanglingReferencesDetector extends EcoreUtil.CrossReferencer {

      public DanglingReferencesDetector(final Resource resource) {
         super(resource);
         crossReference();
         done();
      }

      public DanglingReferencesDetector(final ResourceSet resourceSet) {
         super(resourceSet);
         crossReference();
         done();
      }

      @Override
      protected boolean crossReference(final EObject eObject, final EReference eReference,
            final EObject crossReferencedEObject) {
         return crossReferencedEObject.eResource() == null;
      }

   }

   public static <T extends Solution> Iterable<T> asIterables(final Population population, final Class<T> clazz) {
      final List<T> solutions = new ArrayList<>();
      for(final Solution solution : population) {
         solutions.add(CastUtil.asClass(solution, clazz));
      }
      return solutions;
   }

   public static TransformationSolution assertTransformationSolution(final Solution solution) {
      return CastUtil.assertClass(solution, TransformationSolution.class);
   }

   public static TransformationSolution asTransformationSolution(final Solution solution) {
      return CastUtil.asClass(solution, TransformationSolution.class);
   }

   // public static void cleanGraph(final EGraph graph) {
   // // Ensure that there are no dangling resources in the graph
   // // final List<EObject> toRemove = new ArrayList<>();
   // final Iterator<EObject> contents = getRoot(graph).eAllContents();
   //
   // System.out.println("Analyzing " + graph.toString());
   //
   // final Diagnostic d = Diagnostician.INSTANCE.validate(getRoot(graph));
   // final int numViolations = d.getChildren().size();
   //
   // if(numViolations > 0) {
   // System.out.println(" Invalid solution");
   // }
   //
   // while(contents.hasNext()) {
   // final EObject nextObject = contents.next();
   //
   // if(nextObject.eResource() == null) {
   // // contents.remove();
   // // System.out.println(" To remove: " + nextObject.toString());
   // // toRemove.add(nextObject);
   // } else {
   // removeDanglingReferences(nextObject.eResource());
   // }
   // }
   // //
   // // for(final EObject o : toRemove) {
   // // if(o.eContainer() != null) {
   // // // o.eContainer().eContents().remove(o);
   // // EcoreUtil.remove(o);
   // // }
   // // }
   //
   // }

   public static EGraph copy(final EGraph original) {
      if(original == null) {
         return null;
      }

      try {
         // Copy the resource: (necessary?)
         // List<EObject> roots = original.getRoots();
         // EObject root = roots.get(0);
         // Resource resource = root.eResource();
         // Copier copier = null;
         // if(resource != null) {
         // Resource copiedResource = new ResourceImpl();
         // copier = new Copier();
         // copiedResource.getContents().addAll(copier.copyAll(resource.getContents()));
         // copier.copyReferences();
         // }

         // Copy the graph:
         return original.copy(null);
      } catch(final Exception e) {
         // System.out.println("MomotUtil.copy(): " + e.getClass().getSimpleName() + ": " + e.getMessage());
         // System.out.flush();
         try {
            return original.copy(null);
         } catch(final Exception ex) {

            // System.out.println("MomotUtil.copy(): " + e.getClass().getSimpleName() + ": " + e.getMessage());
            // System.out.flush();
            final Copier copier = new Copier();
            copier.copyAll(original.getRoots());
            copier.copyReferences();

            Boolean nullObjects = false;
            final EGraph copy = new EGraphImpl(original.size());
            for(final EObject object : original) {
               final EObject objectCopy = copier.get(object);
               if(objectCopy == null) {
                  nullObjects = true;
                  break;
               }
               copy.add(objectCopy);
            }

            if(!nullObjects) {
               return copy;
            } else {
               return new EGraphImpl(EcoreUtil.copyAll(original.getRoots()));
            }
         }
      }
   }

   public static EGraph createEGraph(final EObject root) {
      return new EGraphImpl(root);
   }

   public static EGraph createEGraph(final Resource resource) {
      return new EGraphImpl(resource);
   }

   public static HenshinResourceSet createResourceSet() {
      return new HenshinResourceSet();
   }

   public static HenshinResourceSet createResourceSet(final String baseDir) {
      return new HenshinResourceSet(baseDir);
   }

   public static EObject getRoot(final EGraph graph) {
      return graph.getRoots().get(0);
   }

   public static <T extends EObject> T getRoot(final EGraph graph, final Class<T> rootClass) {
      return CastUtil.asClass(getRoot(graph), rootClass);
   }

   public static EGraph loadGraph(final HenshinResourceSet set, final String resourceUri) {
      final Resource model = set.getResource(resourceUri);
      return new EGraphImpl(model);
   }

   public static EGraph loadGraph(final String resourceUri) {
      return loadGraph(createResourceSet(), resourceUri);
   }

   public static void saveGraph(final EGraph graph, final String targetResourceUri) {
      saveGraph(createResourceSet(), graph, targetResourceUri);
   }

   public static void saveGraph(final HenshinResourceSet set, final EGraph graph, final String targetResource) {
      if(targetResource != null) {
         // Added catching since occasionally (rarely) saves can fail due to objects not being
         // contained in a resource?
         try {
            set.saveEObject(getRoot(graph), targetResource);
         } catch(final Throwable t) {
            System.out.println("[Error] Could not save solution " + getRoot(graph).toString());
         }
      }
   }

   private MomotUtil() {}
}
