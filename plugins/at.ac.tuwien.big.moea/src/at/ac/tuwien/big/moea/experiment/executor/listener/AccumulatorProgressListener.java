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

import java.util.ArrayList;
import java.util.List;

import org.moeaframework.Executor;
import org.moeaframework.Instrumenter;
import org.moeaframework.analysis.collector.Accumulator;
import org.moeaframework.util.progress.ProgressEvent;

public class AccumulatorProgressListener extends AbstractProgressListener{

	private List<Accumulator> accumulators = new ArrayList<>();
	
	@Override
	public void update(ProgressEvent event) {
		if (isSeedFinished(event) || isFinished(event)) {
			Executor executor = event.getExecutor();
			Instrumenter instrumenter = executor.getInstrumenter();
			
			accumulators.add(instrumenter.getLastAccumulator());
		}
	}

	public List<Accumulator> getAccumulators() {
		return accumulators;
	}
	
	public AccumulatorProgressListener reset() {
		accumulators.clear();
		return this;
	}
}
