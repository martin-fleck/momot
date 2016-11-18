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
package at.ac.tuwien.big.moea.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EcoreUtil {
	/**
	 * Returns the value of the given feature if the objects eClass 
	 * corresponds to the eClass of the feature containing class and
	 * if the value is instantiable from the expected type, otherwise
	 * null is returned.
	 * 
	 * @param obj
	 * @param feature
	 * @param expectedType
	 * @return 
	 */
	public static <T> T getFeatureValue(EObject obj, EStructuralFeature feature, Class<T> expectedType) {
		return CastUtil.asClass(getFeatureValueObject(obj, feature), expectedType);
	}
	
	public static <T> T getFeatureValue(EObject obj, String featureName, Class<T> expectedType) {
		return CastUtil.asClass(getFeatureValueObject(obj, featureName), expectedType);
	}
	
	public static Object getFeatureValueObject(EObject obj, String featureName) {
		if(obj == null || featureName == null)
			return null;
		EStructuralFeature feature = getStructuralFeature(obj, featureName);
		if(feature == null)
			return null;
		return obj.eGet(feature);
	}
	
	/**
	 * Returns the value of the given feature if the objects eClass 
	 * corresponds to the eClass of the feature containing class, 
	 * otherwise null is returned.
	 * 
	 * @param obj
	 * @param feature
	 * @return 
	 */
	public static Object getFeatureValueObject(EObject obj, EStructuralFeature feature) {
		if(feature == null || !isEClass(obj, feature.getEContainingClass())) 
			return null;
		
//		DynamicEObjectImpl dynamic = asClass(obj, DynamicEObjectImpl.class);
//		if(dynamic != null)
//			return dynamic.dynamicGet(feature.getFeatureID());
		return obj.eGet(obj.eClass().getEStructuralFeature(feature.getFeatureID()));
	}
	
	public static EStructuralFeature getStructuralFeature(EObject obj, String featureName) {
		return obj.eClass().getEStructuralFeature(featureName);
	}
	
	public static boolean isEClass(EObject obj, EClass clazz) {
		if(obj == null || clazz == null)
			return false;
		return obj.eClass().getClassifierID() == clazz.getClassifierID();
	}
	
	public static boolean isEClass(EObject obj, String clazzName) {
		if(obj == null || clazzName == null)
			return false;
		return obj.eClass().getName().equals(clazzName);
	}
}
