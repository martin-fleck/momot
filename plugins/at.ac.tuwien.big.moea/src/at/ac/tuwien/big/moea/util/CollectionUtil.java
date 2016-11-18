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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class CollectionUtil {
   public static <T extends Object> List<T> addAll(final List<T> firstList, final List<T> secondList) {
      final List<T> result = new ArrayList<>(firstList);
      result.addAll(secondList);
      return result;
   }

   public static <T> void addNonNull(final List<T> list, final T element) {
      if(list != null && element != null) {
         list.add(element);
      }
   }

   public static <T> T getRandomElement(final List<T> collection) {
      if(collection == null || collection.size() == 0) {
         return null;
      }
      return collection.get(MathUtil.randomInteger(collection.size()));
   }

   public static <T> T getRandomElement(final Set<T> collection) {
      if(collection == null || collection.size() == 0) {
         return null;
      }
      final int elemIndex = MathUtil.randomInteger(collection.size());
      int i = -1;
      for(final T elem : collection) {
         if(++i == elemIndex) {
            return elem;
         }
      }
      return collection.iterator().next();
   }

   public static <T> T getRandomElement(final T[] collection) {
      if(collection == null || collection.length == 0) {
         return null;
      }
      return collection[MathUtil.randomInteger(collection.length)];
   }

   public static <T extends Comparable<T>> T max(final Collection<T> collection) {
      if(collection == null || collection.size() <= 0) {
         return null;
      }
      T max = null;
      for(final T elem : collection) {
         if(max == null || elem.compareTo(max) > 0) {
            max = elem;
         }
      }
      return max;
   }

   public static <T extends Comparable<T>> T min(final Collection<T> collection) {
      if(collection == null || collection.size() <= 0) {
         return null;
      }
      T max = null;
      for(final T elem : collection) {
         if(max == null || elem.compareTo(max) < 0) {
            max = elem;
         }
      }
      return max;
   }

   @SafeVarargs
   public static <T> List<T> newList(final T... elements) {
      final ArrayList<T> list = new ArrayList<>();
      for(final T element : elements) {
         list.add(element);
      }
      return list;
   }

   public static <T> void removeNull(final List<T> list) {
      boolean removed = list.remove(null);
      while(removed) {
         removed = list.remove(null);
      }
   }

   @SuppressWarnings("unchecked")
   public static <T extends Object> T[] toArray(final Set<T> set) {
      return (T[]) set.toArray();
   }

   private CollectionUtil() {}
}
