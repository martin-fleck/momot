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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.moeaframework.core.Solution;

import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

public class MomotUtil {
	
	public static EGraph copy(EGraph original) {
		if(original == null)
			return null;

		try {
			// Copy the resource: (necessary?)
//			List<EObject> roots = original.getRoots();
//			EObject root = roots.get(0);
//			Resource resource = root.eResource();
//			Copier copier = null;
//			if(resource != null) {
//				Resource copiedResource = new ResourceImpl();
//				copier = new Copier();
//				copiedResource.getContents().addAll(copier.copyAll(resource.getContents()));
//				copier.copyReferences();
//			}
			
			// Copy the graph:
			EGraph copiedGraph = original.copy(null);
			
			return copiedGraph;
			
		} catch(Exception e) {
			System.out.println("MomotUtil.copy(): Error: " + e.getMessage());
			System.out.flush();
			return original.copy(null);
		}
	}
	
	public static TransformationSolution asTransformationSolution(Solution solution) {
		return CastUtil.asClass(solution, TransformationSolution.class);
	}
	
	public static TransformationSolution assertTransformationSolution(Solution solution) {
		return CastUtil.assertClass(solution, TransformationSolution.class);
	}
	
	public static HenshinResourceSet createResourceSet() {
		return new HenshinResourceSet();
	}
	
	public static HenshinResourceSet createResourceSet(String baseDir) {
		return new HenshinResourceSet(baseDir);
	}
	
	public static EGraph loadGraph(String resourceUri) {
		return loadGraph(createResourceSet(), resourceUri);
	}
	
	public static EGraph loadGraph(HenshinResourceSet set, String resourceUri) {
		Resource model = set.getResource(resourceUri);
		return new EGraphImpl(model);
	}
	
	public static EObject getRoot(EGraph graph) {
		return graph.getRoots().get(0);
	}
	
	public static <T extends EObject> T getRoot(EGraph graph, Class<T> rootClass) {
		return CastUtil.asClass(getRoot(graph), rootClass);
	}
	
	public static void saveGraph(HenshinResourceSet set, EGraph graph, String targetResource) {
		if(targetResource != null)
			set.saveEObject(getRoot(graph), targetResource);
	}
	
	public static void saveGraph(EGraph graph, String targetResourceUri) {
		saveGraph(createResourceSet(), graph, targetResourceUri);
	}
}
