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
package at.ac.tuwien.big.momot.search.engine.script.ocl;

import java.util.Collections;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;

import at.ac.tuwien.big.moea.util.CollectionUtil;

public class OCLScriptEngineFactory implements ScriptEngineFactory {

	@Override
	public String getEngineName() {
		return (String)getParameter(ScriptEngine.NAME);
	}

	@Override
	public String getEngineVersion() {
		return (String)getParameter(ScriptEngine.ENGINE);
	}

	@Override
	public List<String> getExtensions() {
		return Collections.unmodifiableList(CollectionUtil.newList(
				"ocl"));
	}

	@Override
	public String getLanguageName() {
		return (String)getParameter(ScriptEngine.LANGUAGE);
	}

	@Override
	public String getLanguageVersion() {
		return (String)getParameter(ScriptEngine.LANGUAGE_VERSION);
	}

	@Override
	public String getMethodCallSyntax(String obj, String m, String... args) {
		return null;
	}

	@Override
	public List<String> getMimeTypes() {
		return Collections.unmodifiableList(CollectionUtil.newList(
			"text/plain"));
	}

	@Override
	public List<String> getNames() {
		return Collections.unmodifiableList(CollectionUtil.newList(
				"ocl", "Object Constraint Language", "OCL"));
	}

	@Override
	public String getOutputStatement(String toDisplay) {
		return "'" + toDisplay + "'";
	}

	@Override
	public Object getParameter(String key) {
		if(ScriptEngine.ENGINE.equals(key))
			return "MOMoT Eclipse OCL";
		else if(ScriptEngine.ENGINE_VERSION.equals(key))
			return "1.0";
		else if(ScriptEngine.NAME.equals(key))
			return "ocl";
		else if(ScriptEngine.LANGUAGE.equals(key))
			return "OCL";
		else if(ScriptEngine.LANGUAGE_VERSION.equals(key))
			return "2.5";
		else if("THREADING".equals(key))
			return "STATELESS";
		throw new IllegalArgumentException("Parameter '" + key + "' not supported.");
	}

	@Override
	public String getProgram(String... statements) {
		return null;
	}

	@Override
	public ScriptEngine getScriptEngine() {
		return new OCLScriptEngine(this);
	}

}
