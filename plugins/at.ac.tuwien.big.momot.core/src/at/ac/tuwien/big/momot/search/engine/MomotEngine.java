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
package at.ac.tuwien.big.momot.search.engine;

import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.momot.search.engine.script.DispatcherScriptEngineWrapper;
import at.ac.tuwien.big.momot.search.engine.script.ocl.OCLScriptEngine;

import java.lang.reflect.Field;

import org.eclipse.emf.henshin.interpreter.Change.CompoundChange;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;

/**
 * An extended version of the condition handler that allows to specify which
 * scripting engine handles which protocol (specified in the attribute
 * conditions).
 */
public class MomotEngine extends EngineImpl implements Engine {

   protected DispatcherScriptEngineWrapper dispatcherWrapper;

   public MomotEngine() {
      this(false, "");
   }

   public MomotEngine(final boolean deterministic, final String... globalJavaImports) {
      super(globalJavaImports);
      dispatcherWrapper = new DispatcherScriptEngineWrapper(globalJavaImports);
      dispatcherWrapper.registerScriptEngine("ocl:", new OCLScriptEngine());

      try {
         final Field scriptEngineField = getClass().getSuperclass().getDeclaredField("scriptEngine");
         scriptEngineField.setAccessible(true);
         scriptEngineField.set(this, dispatcherWrapper);
      } catch(NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
         e.printStackTrace();
      }

      setDeterministic(deterministic);
   }

   public MomotEngine(final String... globalJavaImports) {
      this(false, globalJavaImports);
   }

   @Override
   public void createChanges(final Rule rule, final EGraph graph, final Match completeMatch, final Match resultMatch,
         final CompoundChange complexChange) {
      updateOCLEngine(graph);
      super.createChanges(rule, graph, completeMatch, resultMatch, complexChange);
   }

   @Override
   public Iterable<Match> findMatches(final Rule rule, final EGraph graph, final Match partialMatch) {
      updateOCLEngine(graph);
      return super.findMatches(rule, graph, partialMatch);
   }

   public DispatcherScriptEngineWrapper getDispatcherWrapper() {
      return dispatcherWrapper;
   }

   public boolean isDeterministic() {
      return CastUtil.asClass(getOptions().get(Engine.OPTION_DETERMINISTIC), Boolean.class);
   }

   public void setDeterministic(final boolean deterministic) {
      getOptions().put(Engine.OPTION_DETERMINISTIC, deterministic);
   }

   protected void updateOCLEngine(final EGraph graph) {
      Object newContext = null;
      if(graph != null && graph.getRoots() != null && !graph.getRoots().isEmpty()) {
         newContext = graph.getRoots().get(0);
      }
      getDispatcherWrapper().getEngine(OCLScriptEngine.PROTOCOL_PREFIX).put(OCLScriptEngine.CONTEXT_VARIABLE,
            newContext);
   }

}
