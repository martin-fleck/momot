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
package at.ac.tuwien.big.momot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.impl.ChangeImpl;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.moeaframework.core.EpsilonBoxDominanceArchive;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.NondominatedSortingPopulation;
import org.moeaframework.core.comparator.ParetoDominanceComparator;

import at.ac.tuwien.big.moea.AbstractSearchOrchestration;
import at.ac.tuwien.big.moea.print.ISolutionWriter;
import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizerProvider;
import at.ac.tuwien.big.momot.print.ITransformationSolutionPrinter;
import at.ac.tuwien.big.momot.print.TransformationSolutionWriter;
import at.ac.tuwien.big.momot.problem.ITransformationProblem;
import at.ac.tuwien.big.momot.problem.ParetoFrontStoringTransformationSearchProblem;
import at.ac.tuwien.big.momot.problem.TransformationProblem;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.IEObjectEqualityHelper;
import at.ac.tuwien.big.momot.search.engine.MomotEngine;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;
import at.ac.tuwien.big.momot.search.solution.generator.TransformationSolutionGenerator;

public class TransformationSearchOrchestration extends AbstractSearchOrchestration<TransformationSolution> {
	protected OCL ocl;
	
	protected ModuleManager moduleManager;
	protected EGraph problemGraph;
	protected SearchHelper searchHelper;
	
	protected boolean deterministic = false;
	protected List<String> globalJavaImports = new ArrayList<>();
	protected MomotEngine engine;
	private SingleObjectivizerProvider singleObjectivizerProvider;
	
	

	private IEObjectEqualityHelper equalityHelper;
	
	public TransformationSearchOrchestration() {
		super(TransformationSolution.class);
		ChangeImpl.PRINT_WARNINGS = false;
	}	
	
	public TransformationSearchOrchestration(ModuleManager moduleManager) {
		this();
		setModuleManager(moduleManager);
	}
	
	public TransformationSearchOrchestration(ModuleManager henshinOrchestration, int solutionLength) {
		this(henshinOrchestration);
		setSolutionLength(solutionLength);
	}
	
	public TransformationSearchOrchestration(ModuleManager henshinOrchestration, EGraph problemGraph) {
		this(henshinOrchestration);
		setProblemGraph(problemGraph);
	}
	
	public TransformationSearchOrchestration(ModuleManager henshinOrchestration, String problemGraphUri) {
		this(henshinOrchestration);
		setProblemGraph(problemGraphUri);
	}
	
	public TransformationSearchOrchestration(ModuleManager henshinOrchestration, EGraph problemGraph, int solutionLength) {
		this(henshinOrchestration);
		setProblemGraph(problemGraph);
		setSolutionLength(solutionLength);
	}
	
	public TransformationSearchOrchestration(ModuleManager henshinOrchestration, String problemGraphUri, int solutionLength) {
		this(henshinOrchestration);
		setProblemGraph(problemGraphUri);
		setSolutionLength(solutionLength);
	}
	
	public boolean isDeterministic() {
		return deterministic;
	}
	
	public void setDeterministic(boolean deterministic) {
		this.deterministic = deterministic;
	}
	
	public void setGlobalJavaImports(List<String> globalJavaImports) {
		this.globalJavaImports = globalJavaImports;
	}
	
	public List<String> getGlobalJavaImports() {
		return globalJavaImports;
	}
	
	public void addGlobalJavaImport(String globalJavaImport) {
		getGlobalJavaImports().add(globalJavaImport);
	}
	
	public void setModuleManager(ModuleManager moduleManager) {
		this.moduleManager = moduleManager;
	}
	
	public EGraph getProblemGraph() {
		return problemGraph;
	}
	
	public void setProblemGraph(EGraph problemGraph) {
		this.problemGraph = problemGraph;
	}
	
	public void setProblemGraph(String problemGraphUri) {
		this.problemGraph = getModuleManager().loadGraph(problemGraphUri);
	}
	
	public ModuleManager getModuleManager() {
		if(moduleManager == null)
			moduleManager = new ModuleManager();
		return moduleManager;
	}
	
	protected MomotEngine createEngine() {
		return new MomotEngine(isDeterministic(), getGlobalJavaImports().toArray(new String[0]));
	}
	
	public MomotEngine getEngine() {
		if(engine == null)
			engine = createEngine();
		return engine;
	}
	
	public SearchHelper getSearchHelper() {
		if(searchHelper == null)
			searchHelper = createSearchHelper();
		return searchHelper;
	}
	
	protected SearchHelper createSearchHelper() {
		return new SearchHelper(this);
	}
	
	public IEObjectEqualityHelper getEqualityHelper() {
		return equalityHelper;
	}
	
	public void setEqualityHelper(IEObjectEqualityHelper equalityHelper) {
		this.equalityHelper = equalityHelper;
	}
	
	@Override
	public IEGraphMultiDimensionalFitnessFunction getFitnessFunction() {
		return (IEGraphMultiDimensionalFitnessFunction) super.getFitnessFunction();
	}
	
	@Override
	protected IMultiDimensionalFitnessFunction<TransformationSolution> createFitnessFunction() {
		return new EGraphMultiDimensionalFitnessFunction();
	}	
	
	@Override
	public TransformationSolutionGenerator getSolutionGenerator() {
		return (TransformationSolutionGenerator) super.getSolutionGenerator();
	}
	
	@Override
	protected TransformationSolutionGenerator createSolutionGenerator() {
		return new TransformationSolutionGenerator(createSearchHelper());
	}
	
	@Override
	public ITransformationProblem getProblem() {
		return (ITransformationProblem) super.getProblem();
	}

	@Override
	public ITransformationProblem createProblem() {
		ITransformationProblem ret = new TransformationProblem(getFitnessFunction(), getSolutionGenerator());
		return ret;
	}
	
	@Override
	public ITransformationSolutionPrinter getSolutionPrinter() {
		return (ITransformationSolutionPrinter) super.getSolutionPrinter();
	}
	
	@Override
	public ISolutionWriter<TransformationSolution> createSolutionWriter() {
		return new TransformationSolutionWriter(getFitnessFunction());
	}
	
	protected OCL getOCL() {
		if(ocl == null)
			ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		return ocl;
	}
	
	public Helper createOCLHelper() {
		Helper helper = getOCL().createOCLHelper();
		helper.setContext(getProblemGraph().getRoots().get(0).eClass());
		return helper;
	}
	
	public String write(EGraph graph) {
		return getSolutionPrinter().write(graph);
	}
	
	public NondominatedPopulation createArchive(double... epsilon) {
		if(epsilon == null || epsilon.length == 0) 
			return new NondominatedPopulation(new ParetoDominanceComparator());
		return new EpsilonBoxDominanceArchive(epsilon);
	}
	
	public EpsilonBoxDominanceArchive createEpsilonBoxArchive(double... epsilon) {
		if(epsilon == null || epsilon.length == 0) 
			return null;
		return new EpsilonBoxDominanceArchive(epsilon);
	} 
	
	public NondominatedPopulation createPopulation() {
		return new NondominatedPopulation(new ParetoDominanceComparator());
	}
	
	public NondominatedSortingPopulation createSortingPopulation() {
		return new NondominatedSortingPopulation(new ParetoDominanceComparator());
	}
	

	public void registerMetamodel(String inputMetaModelFile) {
		getModuleManager().registerMetamodel(new File(inputMetaModelFile));
	}
}
