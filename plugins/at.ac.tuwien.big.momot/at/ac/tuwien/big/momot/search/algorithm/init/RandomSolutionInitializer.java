package at.ac.tuwien.big.momot.search.algorithm.init;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;

import at.ac.tuwien.big.moea.problem.solution.variable.IPlaceholderVariable;
import at.ac.tuwien.big.moea.search.algorithm.ISolutionInitializer;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.TransformationPlaceholderVariable;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

public class RandomSolutionInitializer<S extends TransformationSolution>  implements ISolutionInitializer<S> {
	
	private SearchHelper helper;
	
	public RandomSolutionInitializer(SearchHelper helper) {
		this.helper = helper;
	}
	
	public int getEvaluationCount() {
		return 0;
	}
	
	public void setMaxEvaluationCount(int i) {
		
	}

	@Override
	public S getSolution(S baseSolution) {
		return (S)helper.createRandomTransformationSolution();
		/*int length = MathUtil.randomInteger(baseSolution.getNumberOfVariables());
		baseSolution = (S)baseSolution.copy();
		List<Integer> canDoIndex = new ArrayList<Integer>();
		for (int i = 0; i < baseSolution.getNumberOfVariables(); ++i) {
			Variable var = baseSolution.getVariable(i);
			if (var == null || var instanceof IPlaceholderVariable) {
				canDoIndex.add(i);
			}
		}
		List<Boolean> assignThing = new ArrayList<>();
		for (int i = 0; i < length; ++i) {
			assignThing.add(true);
		}
		while (assignThing.size() < canDoIndex.size()) {
			assignThing.add(false);
		}
		Collections.shuffle(assignThing);
		EGraph curGraph = baseSolution.initExecute();
		int curInt = 0;
		for (int i = 0; i < baseSolution.getNumberOfVariables(); ++i) {
			Variable var = baseSolution.getVariable(i);
			if (var == null || var instanceof IPlaceholderVariable) {
				if (assignThing.get(curInt)) {
					//Change
					
					
				} else {
					if (var == null) {
						baseSolution.setVariable(i, new TransformationPlaceholderVariable());
					}
				}
			} else {
				baseSolution.continueExecute(curGraph, i, true);
			}
		}*/
		
		// TODO Auto-generated method stub  	
	}

}
