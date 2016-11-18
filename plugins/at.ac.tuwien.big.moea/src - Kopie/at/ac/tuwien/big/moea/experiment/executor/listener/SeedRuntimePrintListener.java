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

import org.apache.commons.lang3.time.StopWatch;
import org.moeaframework.util.progress.ProgressEvent;

public class SeedRuntimePrintListener extends AbstractProgressListener {

	private StopWatch seedWatch = new StopWatch();
	private StopWatch totalWatch = new StopWatch();

	@Override
	public void update(ProgressEvent event) {
		if(isStarted(event))
			if(!totalWatch.isStarted())
				totalWatch.start();
		
		if(isStarted(event) || isSeedStarted(event)) {
			if(!seedWatch.isStarted()) 
				seedWatch.start();
			println("Run " + event.getCurrentSeed() + " of " + event.getTotalSeeds() + " started.");
		}
		
		if(isSeedFinished(event)) {
			seedWatch.stop();
			println("Run " + event.getCurrentSeed() + " of " + event.getTotalSeeds() + " terminated after " + seedWatch + " (" + seedWatch.getTime() + " ms).");
			seedWatch.reset();
		}
			
		if(isFinished(event)) {
			totalWatch.stop();
			println("Total runtime for " + event.getTotalSeeds() + " seeds: " + totalWatch + " (" + totalWatch.getTime() + " ms).");
			totalWatch.reset();
		}
	}

}
