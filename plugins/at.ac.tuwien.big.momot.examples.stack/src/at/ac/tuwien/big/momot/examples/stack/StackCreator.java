package at.ac.tuwien.big.momot.examples.stack;

import java.util.Random;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.ProfilingApplicationMonitor;

import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.search.engine.MomotEngine;

public class StackCreator {
	public static final String EMPTY_MODEL = "empty_model.xmi";
	
	public static final StackCreator INSTANCE = new StackCreator();
	
	private ModuleManager henshin = new ModuleManager("model/");
	
	public StackCreator() {
		henshin.addModule("stack.henshin");
	}
	
	public EGraph createStacksGraph(Integer[] loads, String targetResource) {
		return createStacksGraph(loads.length, loads, targetResource);
	}
	
	public EGraph createStacksGraph(int nrStacks, Integer[] loads, String targetResource) {
		if(nrStacks != loads.length)
			throw new IllegalArgumentException("Must provide load for all stacks.");
		EGraph graph = new EGraphImpl(henshin.getResourceSet().getResource(EMPTY_MODEL));
		
		MomotEngine engine = new MomotEngine(false);
		RuleApplication createStackApp = henshin.createRuleApplication(
				engine, 
				"createStack", 
				graph);
		
		RuleApplication connectStacksApp = henshin.createRuleApplication(
				engine, 
				"connectStacks",
				graph);
		
		ProfilingApplicationMonitor monitor = new ProfilingApplicationMonitor();
		for(int i = 0; i < nrStacks; i++) {
			createStackApp.setParameterValue("stackId", newName());
			createStackApp.setParameterValue("stackLoad", loads[i]);
			createStackApp.execute(monitor);
			
			if(i > 0) {
				connectStacksApp.setParameterValue("left", previousName());
				connectStacksApp.setParameterValue("right", currentName());
				connectStacksApp.execute(monitor);
			}		
		}
		connectStacksApp.setParameterValue("left", currentName());
		connectStacksApp.setParameterValue("right", firstName());
		connectStacksApp.execute(monitor);
		
//		monitor.printStats();
		
		henshin.saveGraph(graph, targetResource);
		
		return graph;
	}

	public EGraph createStacksGraph(int nrStacks, String targetResource) {
		Integer[] loads = new Integer[nrStacks];
		for(int i = 0; i < nrStacks; i++)
			loads[i] = new Random().nextInt(10);
		return createStacksGraph(nrStacks, loads, targetResource);
	}
	
	private static final int INITIAL_VALUE = 0;
	private static final int STEP_SIZE = 1;
	
	private static int STACK_INDEX = 0;
	private static final String BASE_NAME = "Stack_";
	
	private static String firstName() {
		return BASE_NAME + (INITIAL_VALUE + STEP_SIZE);
	}
	
	private static String currentName() {
		return previousName(0);
	}
	
	private static String previousName() {
		return previousName(1);
	}
	
	private static String previousName(int steps) {
		return BASE_NAME + (STACK_INDEX - steps * STEP_SIZE);
	}
	
	protected static String nextName() {
		return nextName(1);
	}
	
	private static String nextName(int steps) {
		return BASE_NAME + (STACK_INDEX + steps * STEP_SIZE);
	}
	
	private static String newName() {
		STACK_INDEX += STEP_SIZE;
		return currentName();
	}
}
