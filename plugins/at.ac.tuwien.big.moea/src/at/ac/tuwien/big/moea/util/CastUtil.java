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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class CastUtil {
   private static final Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS = new HashMap<>();

   static {
      PRIMITIVES_TO_WRAPPERS.put(boolean.class, Boolean.class);
      PRIMITIVES_TO_WRAPPERS.put(byte.class, Byte.class);
      PRIMITIVES_TO_WRAPPERS.put(char.class, Character.class);
      PRIMITIVES_TO_WRAPPERS.put(double.class, Double.class);
      PRIMITIVES_TO_WRAPPERS.put(float.class, Float.class);
      PRIMITIVES_TO_WRAPPERS.put(int.class, Integer.class);
      PRIMITIVES_TO_WRAPPERS.put(long.class, Long.class);
      PRIMITIVES_TO_WRAPPERS.put(short.class, Short.class);
      PRIMITIVES_TO_WRAPPERS.put(void.class, Void.class);
   }

   public static <T> T asClass(final Object obj, final Class<T> clazz) {
      if(obj == null || clazz == null) {
         return null;
      }
      final Class<T> wrapper = wrap(clazz);
      if(wrapper.isInstance(obj)) {
         return wrapper.cast(obj);
      }
      return null;
   }

   public static double asDouble(final String value) {
      return Double.parseDouble(value);
   }

   public static File asFile(final String filePath) {
      if(TextUtil.isEmpty(filePath)) {
         return null;
      }
      return new File(filePath);
   }

   public static int asInteger(final String value) {
      return Integer.parseInt(value);
   }

   public static <T> T assertClass(final Object obj, final Class<T> clazz) {
      if(obj == null || clazz == null) {
         return null;
      }
      final Class<T> wrapper = wrap(clazz);
      if(wrapper.isInstance(obj)) {
         return wrapper.cast(obj);
      }
      throw new IllegalArgumentException("Object '" + obj + "' is not of type '" + clazz.getCanonicalName() + "'.");
   }

   public static Class<?> getObjectType(final Class<?> clazzA) {
      if(clazzA != null && clazzA.isPrimitive()) {
         if(clazzA == Boolean.TYPE) {
            return Boolean.class;
         } else if(clazzA == Integer.TYPE) {
            return Integer.class;
         } else if(clazzA == Float.TYPE) {
            return Float.class;
         } else if(clazzA == Byte.TYPE) {
            return Byte.class;
         } else if(clazzA == Character.TYPE) {
            return Character.class;
         } else if(clazzA == Double.TYPE) {
            return Double.class;
         } else if(clazzA == Short.TYPE) {
            return Short.class;
         } else if(clazzA == Long.TYPE) {
            return Long.class;
         }
      }
      return clazzA;
   }

   @SuppressWarnings("unchecked")
   public static <T> Class<T> wrap(final Class<T> c) {
      return c.isPrimitive() ? (Class<T>) PRIMITIVES_TO_WRAPPERS.get(c) : c;
   }

   private CastUtil() {}
}
