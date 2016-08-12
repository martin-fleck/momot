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
package at.ac.tuwien.big.momot.search.engine.script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

import org.eclipse.emf.henshin.model.util.ScriptEngineWrapper;

public class DispatcherScriptEngine extends AbstractScriptEngine {

   protected ScriptEngineFactory factory;
   protected Map<String, ScriptEngine> prefixEngines = new HashMap<>();
   protected final ScriptEngine defaultEngine;

   public DispatcherScriptEngine(final DispatcherScriptEngineFactory factory) {
      this(factory, new ScriptEngineWrapper(new String[] {}).getEngine());
   }

   public DispatcherScriptEngine(final DispatcherScriptEngineFactory factory, final ScriptEngine defaultEngine) {
      this(defaultEngine);
      this.factory = factory;
   }

   public DispatcherScriptEngine(final ScriptEngine defaultEngine) {
      this.defaultEngine = defaultEngine;
   }

   @Override
   public Bindings createBindings() {
      return new SimpleBindings();
   }

   @Override
   public Object eval(final Reader reader, final ScriptContext context) throws ScriptException {
      final BufferedReader in = new BufferedReader(reader);
      String line = null;
      final StringBuilder rslt = new StringBuilder();
      try {
         while((line = in.readLine()) != null) {
            rslt.append(line);
         }
      } catch(final IOException e) {
         e.printStackTrace();
      }
      return eval(rslt.toString(), context);
   }

   @Override
   public Object eval(final String script, final ScriptContext context) throws ScriptException {
      Object eval = null;
      for(final Entry<String, ScriptEngine> protocolEngine : prefixEngines.entrySet()) {
         if(script.startsWith(protocolEngine.getKey())) {
            final ScriptEngine prefixEngine = protocolEngine.getValue();
            eval = prefixEngine.eval(script.substring(protocolEngine.getKey().length()), prefixEngine.getContext());
         }
      }
      if(eval == null) {
         eval = defaultEngine.eval(script, defaultEngine.getContext());
      }
      return eval;
   }

   public ScriptEngine getEngine(final String script) {
      for(final Entry<String, ScriptEngine> protocolEngine : prefixEngines.entrySet()) {
         if(script.startsWith(protocolEngine.getKey())) {
            return protocolEngine.getValue();
         }
      }
      return defaultEngine;
   }

   @Override
   public ScriptEngineFactory getFactory() {
      return factory;
   }

   public boolean hasKnownPrefix(final String script) {
      for(final Entry<String, ScriptEngine> protocolEngine : prefixEngines.entrySet()) {
         if(script.startsWith(protocolEngine.getKey())) {
            return true;
         }
      }
      return false;
   }

   public boolean isDefault(final String script) {
      return !hasKnownPrefix(script); // handled by Henshin (Rhino JavaScript Engine)
   }

   @Override
   public void put(final String key, final Object value) {
      super.put(key, value);
      defaultEngine.put(key, value);
      for(final ScriptEngine engine : prefixEngines.values()) {
         engine.put(key, value);
      }
   }

   public ScriptEngine registerScriptEngine(final String prefix, final ScriptEngine engine) {
      return prefixEngines.put(prefix, engine);
   }

   public void setFactory(final ScriptEngineFactory factory) {
      this.factory = factory;
   }

}
