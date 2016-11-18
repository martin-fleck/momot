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
package at.ac.tuwien.big.moea.experiment.executor.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.moeaframework.util.progress.ProgressEvent;
import org.moeaframework.util.progress.ProgressListener;

public abstract class AbstractProgressListener implements ProgressListener {
   protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("[HH:mm:ss.SSS] ");

   private int currentSeed = 0;

   public boolean isFinished(final ProgressEvent event) {
      return event.getCurrentSeed() > event.getTotalSeeds();
   }

   public boolean isRunning(final ProgressEvent event) {
      return !isFinished(event) && currentSeed > 0;
   }

   public boolean isSeedFinished(final ProgressEvent event) {
      return !isFinished(event) && event.getCurrentNFE() >= event.getMaxNFE();
   }

   public boolean isSeedStarted(final ProgressEvent event) {
      return !isFinished(event) && event.getCurrentSeed() > currentSeed;
   }

   public boolean isStarted(final ProgressEvent event) {
      return currentSeed == 0;
   }

   protected void println(final String message) {
      System.out.println(DATE_FORMAT.format(Calendar.getInstance().getTime()) + message);
   }

   @Override
   public void progressUpdate(final ProgressEvent event) {
      update(event);
      currentSeed = event.getCurrentSeed();
      if(isFinished(event)) {
         currentSeed = 0;
      }
   }

   public abstract void update(ProgressEvent event);
}
