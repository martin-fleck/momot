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
package at.ac.tuwien.big.moea.experiment.executor.listener.terminate;

import at.ac.tuwien.big.moea.experiment.executor.SearchExecutor;
import at.ac.tuwien.big.moea.experiment.executor.listener.AbstractProgressListener;
import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.moea.util.MathUtil;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.moeaframework.util.progress.ProgressEvent;

public class RuntimeTerminateListener extends AbstractProgressListener {

   private final long terminationTime;
   private StopWatch watch;

   public RuntimeTerminateListener(final int minutes, final int seconds, final int milliseconds) {
      this(0, 0, minutes, seconds, milliseconds);
   }

   public RuntimeTerminateListener(final int days, final int hours, final int minutes, final int seconds,
         final int milliseconds) {
      this.terminationTime = MathUtil.toNanoseconds(days, hours, minutes, seconds, milliseconds);
   }

   public RuntimeTerminateListener(final long terminationTime) {
      this.terminationTime = terminationTime;
   }

   protected SearchExecutor getExecutor(final ProgressEvent event) {
      if(event == null) {
         return null;
      }
      return CastUtil.asClass(event.getExecutor(), SearchExecutor.class);
   }

   protected boolean terminateRun(final ProgressEvent event) {
      final SearchExecutor executor = getExecutor(event);
      if(executor == null) {
         return false;
      }
      return true;
   }

   protected boolean terminateRun(final ProgressEvent event, final boolean condition) {
      if(!condition) {
         return false;
      }
      return terminateRun(event);
   }

   @Override
   public void update(final ProgressEvent event) {
      if(isSeedStarted(event)) {
         watch = new StopWatch();
         watch.start();
      }

      if(terminateRun(event, watch.getNanoTime() > terminationTime)) {
         watch.stop();
         System.out.println("--> Run " + event.getCurrentSeed() + " of " + event.getTotalSeeds()
               + " has been terminated after " + watch + ", because the time limit of "
               + DurationFormatUtils.formatDurationHMS(terminationTime / MathUtil.MILLISECONS_TO_NS)
               + " has been reached.\n");
      }
   }
}
