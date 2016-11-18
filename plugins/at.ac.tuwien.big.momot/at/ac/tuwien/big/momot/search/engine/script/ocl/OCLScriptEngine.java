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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map.Entry;

import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

import at.ac.tuwien.big.moea.util.CastUtil;

public class OCLScriptEngine extends AbstractScriptEngine {
	
	public static final String CONTEXT_VARIABLE = Environment.SELF_VARIABLE_NAME;
	public static final String PROTOCOL_PREFIX = "ocl:";
	
	protected static final String ATTRIBUTE_DEFINITION = "%s: %s = %s";
	protected static final String ATTRIBUTE_DEFINITION_STRING = "%s: %s = '%s'";
	
	protected static final String LET_EXPRESSION = "let " + ATTRIBUTE_DEFINITION + " in";
	protected static final String LET_EXPRESSION_STRING = "let " + ATTRIBUTE_DEFINITION_STRING + " in";
	
	protected ScriptEngineFactory factory;
	
	private OCL environment = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
	Helper helper = environment.createOCLHelper();		
	
	public OCLScriptEngine() { }
	
	public OCLScriptEngine(OCLScriptEngineFactory factory) {
		this.factory = factory;
	}
	
	public void setFactory(ScriptEngineFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public ScriptEngineFactory getFactory() {
		return factory;
	}
	
	@Override
	public Bindings createBindings() {
		return new SimpleBindings();
	}
	
	@Override
	public Object eval(String script, ScriptContext context)
			throws ScriptException {
		Boolean result = evalAsAttributeDefinitions(script, context);
		// unfortunately, let expressions are up to four times slower than
		// creating a new environment and (re-)define attributes.
		// evalWithLetExpressions(script, context);
		return result;
	}
	
	@Override
	public Object eval(Reader reader, ScriptContext context)
			throws ScriptException {
		BufferedReader in = new BufferedReader(reader);
		String line = null;
		StringBuilder rslt = new StringBuilder();
		try {
			while ((line = in.readLine()) != null) {
			    rslt.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return eval(rslt.toString(), context);
	}
	
	public Boolean evalAsAttributeDefinitions(String script, ScriptContext context)
			throws ScriptException {
		
		EObject self = CastUtil.asClass(context.getAttribute(CONTEXT_VARIABLE), EObject.class);
		if(self == null)
			return false;
		
		Helper helper = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE).createOCLHelper();
		helper.setContext(self.eClass());
		
		try {
			Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
			for(Entry<String, Object> e : bindings.entrySet()) {
				String name = e.getKey();
				if(name.equals(CONTEXT_VARIABLE) || e.getValue() == null)
					continue;
				
				Object value = e.getValue();			
				String typeName = value instanceof DynamicEObjectImpl ?
						((DynamicEObjectImpl)value).eClass().getName() :
						value.getClass().getSimpleName();
				
				if(typeName.equals(String.class.getSimpleName())) 
					helper.defineAttribute(String.format(ATTRIBUTE_DEFINITION_STRING, name, typeName, value));
				else if(!typeName.equals("InterpretedFunction"))
					helper.defineAttribute(String.format(ATTRIBUTE_DEFINITION, name, typeName, value));
				else
					System.err.println("Context dirty :-(");
			}
			OCLExpression query = helper.createQuery(script);
			return toBoolean(helper.getOCL().createQuery(query).evaluate(self));
		} catch (ParserException e) {
			; // fail silently
			return false;
		}
	}
	
	public Boolean evalAsLetExpressions(String script, ScriptContext context) {
		EObject self = CastUtil.asClass(context.getAttribute(CONTEXT_VARIABLE), EObject.class);
		if(self == null)
			return false;
		
		helper.setContext(self.eClass());
		try {
			Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
			String letExpressions = "";
			for(Entry<String, Object> e : bindings.entrySet()) {
				String name = e.getKey();
				if(name.equals(CONTEXT_VARIABLE))
					continue;
				Object value = e.getValue();
				if(value == null)
					continue;
				
				String typeName = e.getValue().getClass().getSimpleName();
				if(value instanceof DynamicEObjectImpl)
					typeName = ((DynamicEObjectImpl)value).eClass().getName();

				if(typeName.equals(String.class.getSimpleName())) {
					letExpressions += String.format(LET_EXPRESSION_STRING, name, typeName, value);
				} else
					letExpressions += String.format(LET_EXPRESSION, name, typeName, value);
			}
			OCLExpression query = helper.createQuery(letExpressions + script);
			Object result = helper.getOCL().createQuery(query).evaluate(self);
			return toBoolean(result);
		} catch (ParserException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected static Boolean toBoolean(Object obj) {
		if(obj instanceof Boolean)
			return (Boolean)obj;
		return false;
	}
	
}
