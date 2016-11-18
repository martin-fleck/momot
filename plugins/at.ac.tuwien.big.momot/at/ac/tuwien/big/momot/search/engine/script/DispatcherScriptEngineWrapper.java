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

import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.eclipse.emf.henshin.model.util.ScriptEngineWrapper;

public class DispatcherScriptEngineWrapper extends ScriptEngineWrapper {
	
	public DispatcherScriptEngineWrapper(String[] globalImports) {
		super(new DispatcherScriptEngine(
				new ScriptEngineWrapper(globalImports).getEngine()), 
				globalImports);
	}
	
	public ScriptEngine registerScriptEngine(String prefix, ScriptEngine engine) {
		return getEngine().registerScriptEngine(prefix, engine);
	}
	
	public ScriptEngine getEngine(String script) {
		return getEngine().getEngine(script);
	}
	
	@Override
	public DispatcherScriptEngine getEngine() {
		return (DispatcherScriptEngine) super.getEngine();
	}
	
	@Override
	public Object eval(String script, List<String> localImports)
			throws ScriptException {
		if(getEngine().isDefault(script))
			return super.eval(script, localImports);
		return getEngine().eval(script);
	}

}
