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
	protected static final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss.SSS] ");
	
	private int currentSeed = 0;
	
	protected void println(String message) {
		System.out.println(df.format(Calendar.getInstance().getTime()) + message);
	}
	
	public boolean isStarted(ProgressEvent event) {
		return currentSeed == 0;
	}
	
	public boolean isSeedStarted(ProgressEvent event) {
		return !isFinished(event) && event.getCurrentSeed() > currentSeed;
	}
	
	public boolean isRunning(ProgressEvent event) {
		return !isFinished(event) && currentSeed > 0;
	}
	
	public boolean isSeedFinished(ProgressEvent event) {
		return !isFinished(event) && event.getCurrentNFE() >= event.getMaxNFE();
	}
	
	public boolean isFinished(ProgressEvent event) {
		return event.getCurrentSeed() > event.getTotalSeeds();
	}	
	
	@Override
	public void progressUpdate(ProgressEvent event) {
		update(event);
		currentSeed = event.getCurrentSeed();
		if(isFinished(event)) 
			currentSeed = 0;
	}
	
	public abstract void update(ProgressEvent event);
}
