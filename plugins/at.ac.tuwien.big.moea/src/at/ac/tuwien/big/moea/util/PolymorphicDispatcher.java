/*******************************************************************************
 * Copyright (c) 2008, 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package at.ac.tuwien.big.moea.util;

import com.google.common.base.Predicate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PolymorphicDispatcher<T> {

   public static class DefaultErrorHandler<T> implements ErrorHandler<T> {
      @Override
      public T handle(final Object[] params, final Throwable e) {
         return ExceptionUtil.throwUncheckedException(e);
      }
   }

   public interface ErrorHandler<P> {
      P handle(Object[] params, Throwable throwable);
   }

   protected class MethodDesc {
      private final Object target;
      private final Method method;

      protected MethodDesc(final Object target, final Method method) {
         super();
         this.target = target;
         this.method = method;
      }

      public Class<?> getDeclaringClass() {
         return method.getDeclaringClass();
      }

      public Method getMethod() {
         return method;
      }

      public Class<?>[] getParameterTypes() {
         return method.getParameterTypes();
      }

      public Object getTarget() {
         return target;
      }

      public boolean isInvokeable(final List<Class<?>> paramTypes) {
         if(getParameterTypes().length != paramTypes.size()) {
            return false;
         }
         for(int i = 0; i < paramTypes.size(); i++) {
            final Class<?> paramClass = paramTypes.get(i);
            if(paramClass != null && !Void.class.equals(paramClass) && !CastUtil.getObjectType(getParameterTypes()[i])
                  .isAssignableFrom(CastUtil.getObjectType(paramClass))) {
               return false;
            }
         }
         return true;
      }

      @Override
      public String toString() {
         return this.method.toString();
      }
   }

   public static class MethodNameFilter implements Predicate<Method> {

      protected final int maxParams;

      protected final String methodName;

      protected final int minParams;

      public MethodNameFilter(final String methodName, final int minParams, final int maxParams) {
         this.maxParams = maxParams;
         this.methodName = methodName;
         this.minParams = minParams;
      }

      @Override
      public boolean apply(final Method param) {
         return param.getName().equals(methodName) && param.getParameterTypes().length >= minParams
               && param.getParameterTypes().length <= maxParams;
      }

      public int getMaxParams() {
         return maxParams;
      }

      public int getMinParams() {
         return minParams;
      }

      @Override
      public String toString() {
         return "'" + methodName + "'";
      }
   }

   private static class NoSuchMethodException extends java.lang.NoSuchMethodException {

      private static final long serialVersionUID = 1L;
      private final Predicate<Method> methodFilter;
      private final Object[] params;

      NoSuchMethodException(final Predicate<Method> methodFilter, final Object[] params) {
         this.methodFilter = methodFilter;
         this.params = params;
      }

      @Override
      public String getMessage() {
         return "Couldn't find method '" + methodFilter.toString() + "' for objects " + Arrays.toString(params);
      }
   }

   public static class NullErrorHandler<T> implements ErrorHandler<T> {

      public static <T> ErrorHandler<T> get() {
         return new NullErrorHandler<>();
      }

      @Override
      public T handle(final Object[] params, final Throwable throwable) {
         // ignore
         return null;
      }
   }

   public static class Predicates {

      public static Predicate<Method> forName(final String name) {
         return new MethodNameFilter(name, 1, 1);
      }

      public static Predicate<Method> forName(final String name, final int params) {
         return new MethodNameFilter(name, params, params);
      }

   }

   public static <T> PolymorphicDispatcher<T> createForSingleTarget(final Predicate<Method> methodFilter,
         final Object singleTarget) {
      return new PolymorphicDispatcher<>(Collections.singletonList(singleTarget), methodFilter);
   }

   public static <T> PolymorphicDispatcher<T> createForSingleTarget(final String methodName, final int min,
         final int max, final Object singleTarget) {
      return new PolymorphicDispatcher<>(methodName, min, max, Collections.singletonList(singleTarget));
   }

   public static <T> PolymorphicDispatcher<T> createForSingleTarget(final String methodName,
         final Object singleTarget) {
      return new PolymorphicDispatcher<>(methodName, Collections.singletonList(singleTarget));
   }

   public static <T> PolymorphicDispatcher<T> createForVarTarget(final String methodName, final Object... targets) {
      return new PolymorphicDispatcher<>(methodName, Arrays.asList(targets));
   }

   private final List<? extends Object> targets;

   private final Predicate<Method> methodFilter;

   private List<MethodDesc> declaredMethodsByParameterType;

   private final ErrorHandler<T> handler;

   private final SimpleCache<List<Class<?>>, List<MethodDesc>> cache = new SimpleCache<>(paramTypes -> {
      final List<MethodDesc> result = new ArrayList<>();
      final Iterator<MethodDesc> iterator = declaredMethodsByParameterType.iterator();
      while(iterator.hasNext()) {
         final MethodDesc methodDesc = iterator.next();
         if(methodDesc.isInvokeable(paramTypes)) {
            if(result.isEmpty()) {
               result.add(methodDesc);
            } else {
               final int compare = compare(result.get(0), methodDesc);
               if(compare < 0) {
                  result.clear();
                  result.add(methodDesc);
               } else if(compare == 0) {
                  result.add(methodDesc);
               }
            }
         }
      }
      return result;
   });

   public PolymorphicDispatcher(final List<? extends Object> targets, final Predicate<Method> methodFilter) {
      this(targets, methodFilter, new DefaultErrorHandler<T>());
   }

   public PolymorphicDispatcher(final List<? extends Object> targets, final Predicate<Method> methodFilter,
         final ErrorHandler<T> handler) {
      this.targets = targets;
      this.methodFilter = methodFilter;
      this.handler = handler;
      declaredMethodsByParameterType = getDeclaredMethodsOrderedBySpecificParameterType();
   }

   public PolymorphicDispatcher(final String methodName, final int minParams, final int maxParams,
         final List<? extends Object> targets) {
      this(methodName, minParams, maxParams, targets, new DefaultErrorHandler<T>());
   }

   public PolymorphicDispatcher(final String methodName, final int minParams, final int maxParams,
         final List<? extends Object> targets, final ErrorHandler<T> handler) {
      this(targets, new MethodNameFilter(methodName, minParams, maxParams), handler);
   }

   public PolymorphicDispatcher(final String methodName, final List<? extends Object> targets) {
      this(methodName, 1, 1, targets);
   }

   protected int compare(final MethodDesc o1, final MethodDesc o2) {
      final List<Class<?>> paramTypes1 = Arrays.asList(o1.getParameterTypes());
      final List<Class<?>> paramTypes2 = Arrays.asList(o2.getParameterTypes());

      // sort by number of parameters
      if(paramTypes1.size() > paramTypes2.size()) {
         return 1;
      }
      if(paramTypes2.size() > paramTypes1.size()) {
         return -1;
      }

      // sort by parameter types from left to right
      for(int i = 0; i < paramTypes1.size(); i++) {
         final Class<?> class1 = paramTypes1.get(i);
         final Class<?> class2 = paramTypes2.get(i);

         if(class1.equals(class2)) {
            continue;
         }
         if(class1.isAssignableFrom(class2) || Void.class.equals(class2)) {
            return -1;
         }
         if(class2.isAssignableFrom(class1) || Void.class.equals(class1)) {
            return 1;
         }
      }

      // sort by declaring class (more specific comes first).
      if(!o1.getDeclaringClass().equals(o2.getDeclaringClass())) {
         if(o1.getDeclaringClass().isAssignableFrom(o2.getDeclaringClass())) {
            return 1;
         }
         if(o2.getDeclaringClass().isAssignableFrom(o1.getDeclaringClass())) {
            return -1;
         }
      }

      // sort by target
      final int compareTo = ((Integer) targets.indexOf(o2.target)).compareTo(targets.indexOf(o1.target));
      return compareTo;
   }

   protected MethodDesc createMethodDesc(final Object target, final Method method) {
      return new MethodDesc(target, method);
   }

   private List<MethodDesc> getDeclaredMethodsOrderedBySpecificParameterType() {
      final ArrayList<MethodDesc> cachedDescriptors = new ArrayList<>();
      for(final Object target : targets) {
         Class<?> current = target.getClass();
         while(current != Object.class) {
            final Method[] methods = current.getDeclaredMethods();
            for(final Method method : methods) {
               if(methodFilter.apply(method)) {
                  cachedDescriptors.add(createMethodDesc(target, method));
               }
            }
            current = current.getSuperclass();
         }
      }
      Collections.sort(cachedDescriptors, (o1, o2) -> PolymorphicDispatcher.this.compare(o1, o2));
      return cachedDescriptors;
   }

   /**
    * @return
    */
   protected Class<?> getDefaultClass(final int paramIndex) {
      return Void.class;
   }

   /**
    * @param params
    * @return
    */
   private List<Class<?>> getTypes(final Object[] params) {
      final List<Class<?>> result = new ArrayList<>(params.length);
      for(int i = 0; i < params.length; i++) {
         if(params[i] != null) {
            result.add(params[i].getClass());
         } else {
            result.add(getDefaultClass(i));
         }
      }
      return result;
   }

   protected T handleAmbigousMethods(final List<MethodDesc> result, final Object... params) {
      throw new IllegalStateException("Ambiguous methods " + result + " for params " + Arrays.toString(params));
   }

   protected T handleNoSuchMethod(final Object... params) {
      return handler.handle(params, new NoSuchMethodException(methodFilter, params));
   }

   @SuppressWarnings("unchecked")
   public T invoke(final Object... params) {
      if(methodFilter instanceof MethodNameFilter) {
         final MethodNameFilter filter = (MethodNameFilter) methodFilter;
         if(params.length < filter.getMinParams() || params.length > filter.getMaxParams()) {
            throw new IllegalArgumentException("Wrong number of arguments. Expected " + filter.getMinParams() + " to "
                  + filter.getMaxParams() + ".");
         }
      }
      final List<MethodDesc> result = cache.get(getTypes(params));
      // check if ambiguous
      if(result.size() > 1) {
         return handleAmbigousMethods(result, params);
      }

      if(result.isEmpty()) {
         return handleNoSuchMethod(params);
      }

      try {
         final MethodDesc current = result.get(0);
         current.method.setAccessible(true);
         return (T) current.method.invoke(current.target, params);
      } catch(final InvocationTargetException e) {
         if(e.getTargetException() instanceof Error) {
            throw(Error) e.getTargetException();
         }
         return handler.handle(params, e.getTargetException());
      } catch(final IllegalArgumentException e) {
         return handler.handle(params, e);
      } catch(final IllegalAccessException e) {
         return handler.handle(params, e);
      }
   }
}
