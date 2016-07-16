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

import org.moeaframework.util.progress.ProgressEvent;

import at.ac.tuwien.big.moea.util.TextUtil;

public class RuntimePrintListener extends AbstractProgressListener {

	@Override
	public void update(ProgressEvent event) {
		System.out.println(
				event.getCurrentSeed() + "/" + event.getTotalSeeds() + "- " + 
				event.getCurrentNFE() + "/" + event.getMaxNFE() + " - " +
				TextUtil.toString(event.getElapsedTime(), 2) + "s/" 
				+ TextUtil.toString(event.getRemainingTime(), 2) + "s");
	}

}
