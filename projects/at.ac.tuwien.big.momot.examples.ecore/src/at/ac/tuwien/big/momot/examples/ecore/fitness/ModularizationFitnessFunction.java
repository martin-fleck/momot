package at.ac.tuwien.big.momot.examples.ecore.fitness;

import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType;
import at.ac.tuwien.big.momot.examples.ecore.fitness.metric.LanguageMetrics;
import at.ac.tuwien.big.momot.examples.ecore.fitness.metric.MetricsCalculator;
import at.ac.tuwien.big.momot.examples.ecore.modularization.Language;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class ModularizationFitnessFunction extends EGraphMultiDimensionalFitnessFunction {
	public static final String ATTRIBUTE_METRICS = "metrics";

	public ModularizationFitnessFunction() {
//		addObjective(new AbstractEGraphFitnessDimension("VocabularyDistance", FunctionType.Minimum) {
//			@Override
//			protected double internalEvaluate(TransformationSolution solution) {
//				return getMetrics(solution).getVocabularyDistance();
//			}
//		});
		
		addObjective(new AbstractEGraphFitnessDimension("Coupling", FunctionType.Minimum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				return getMetrics(solution).getCoupling();
			}
		});
		
		addObjective(new AbstractEGraphFitnessDimension("Cohesion", FunctionType.Maximum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				return getMetrics(solution).getCohesion();
			}
		});
		
		addObjective(new AbstractEGraphFitnessDimension("MinMaxDiff", FunctionType.Minimum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				return getMetrics(solution).getMinMaxDiff();
			}
		});
		
		addObjective(new AbstractEGraphFitnessDimension("NrModules", FunctionType.Maximum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				return getMetrics(solution).getNrModules();
			}
		});
	}
	
	protected LanguageMetrics getMetrics(TransformationSolution solution) {
		Object metrics = solution.getAttribute(ATTRIBUTE_METRICS);
		if(metrics instanceof LanguageMetrics)
			return (LanguageMetrics) metrics;
		return null;
	}
	
	@Override
	protected void preprocessEvaluation(TransformationSolution solution) {
		solution.setAttribute(
				ATTRIBUTE_METRICS, 
				MetricsCalculator.calculate(
					MomotUtil.getRoot(solution.execute(),
					Language.class)));
	}
}
