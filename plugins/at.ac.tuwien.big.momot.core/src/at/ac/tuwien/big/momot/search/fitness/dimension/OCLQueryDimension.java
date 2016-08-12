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
package at.ac.tuwien.big.momot.search.fitness.dimension;

import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCL.Query;

public class OCLQueryDimension extends AbstractEGraphFitnessDimension {

   private static Query createQuery(final Helper helper, final String queryExpression, final String... defExpressions)
         throws ParserException {
      if(helper.getEnvironment().getSelfVariable() == null) {
         throw new IllegalArgumentException(
               "Classifier context of the OCL Helper class must be set to the root element class of the graph.");
      }

      for(final String defExpression : defExpressions) {
         helper.defineAttribute(defExpression);
      }

      return helper.getOCL().createQuery(helper.createQuery(queryExpression));
   }

   private final Query oclQuery;

   public OCLQueryDimension(final Query oclQuery) throws ParserException {
      this(oclQuery.getExpression().toString(), oclQuery);
   }

   public OCLQueryDimension(final String name, final FunctionType type, final Query oclQuery) throws ParserException {
      super(name, type);
      this.oclQuery = oclQuery;
   }

   public OCLQueryDimension(final String name, final FunctionType type, final String queryExpression,
         final Helper helper, final String... defExpressions) throws ParserException {
      this(name, type, createQuery(helper, queryExpression, defExpressions));
   }

   public OCLQueryDimension(final String queryExpression, final Helper helper, final String... defExpressions)
         throws ParserException {
      this(queryExpression, createQuery(helper, queryExpression, defExpressions));
   }

   public OCLQueryDimension(final String name, final Query oclQuery) throws ParserException {
      super(name);
      this.oclQuery = oclQuery;
   }

   public OCLQueryDimension(final String name, final String queryExpression, final Helper helper,
         final String... defExpressions) throws ParserException {
      this(name, createQuery(helper, queryExpression, defExpressions));
   }

   public Query getOclQuery() {
      return oclQuery;
   }

   @Override
   protected double internalEvaluate(final TransformationSolution solution) {
      final EGraph resultGraph = solution.execute();
      if(resultGraph == null || getOclQuery() == null) {
         return WORST_FITNESS;
      }

      try {
         final EObject root = resultGraph.getRoots().get(0);
         final Object result = getOclQuery().evaluate(root);
         // System.out.println(getName() + " = " + result);
         return Double.parseDouble(result.toString());
      } catch(final NumberFormatException e) {
         return WORST_FITNESS;
      }
   }
}
