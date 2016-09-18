package at.ac.tuwien.big.momot.examples.tse.momot.orchestration;

import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType;
import at.ac.tuwien.big.momot.examples.tse.metric.TransformationMetrics;
import at.ac.tuwien.big.momot.examples.tse.metric.calc.MetricCalculator;
import at.ac.tuwien.big.momot.examples.tse.modularization.Module;
import at.ac.tuwien.big.momot.examples.tse.modularization.Transformation;
import at.ac.tuwien.big.momot.examples.tse.momot.util.ModularizationUtil;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;

public class ModularizationFitnessFunction extends EGraphMultiDimensionalFitnessFunction {

	public static final String ATTRIBUTE_METRICS = "metrics";
	
	public ModularizationFitnessFunction() {		
		addObjective(new AbstractEGraphFitnessDimension("NrModules", FunctionType.Minimum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				int nonEmptyModules = 0;
				for(Module m : ModularizationUtil.assertTransformationRoot(solution.execute()).getModules())
					if(!m.getRules().isEmpty() || !m.getHelpers().isEmpty())
						nonEmptyModules++;
				return nonEmptyModules;
			}
		});
		
		addObjective(new AbstractEGraphFitnessDimension("MinMaxResponsibilityDifference") {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				return getMetrics(solution).getMinMaxReponsibilityDifference();
			}
		});
		
		addObjective(new AbstractEGraphFitnessDimension("CohesionRatio", FunctionType.Maximum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				return getMetrics(solution).getCohesionRatio();
			}
		});

		addObjective(new AbstractEGraphFitnessDimension("CouplingRatio") {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				return getMetrics(solution).getCouplingRatio();
			}
		});
		
//		addObjective(new MatchSolutionLengthDimension());
		
		addConstraint(new AbstractEGraphFitnessDimension("NoEmptyModule") {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				Transformation transformation = ModularizationUtil.assertTransformationRoot(solution.execute());
				for(Module module : transformation.getModules())
					if(module.getRules().isEmpty() && module.getHelpers().isEmpty())
						return CONSTRAINT_VIOLATED;
				return CONSTRAINT_OK;
			}
		});
		
//		setSolutionRepairer(new MatchPlaceholderSolutionRepairer());
	}
	
	protected TransformationMetrics getMetrics(TransformationSolution solution) {
		Object transformation = solution.getAttribute(ATTRIBUTE_METRICS);
		if(transformation instanceof TransformationMetrics)
			return (TransformationMetrics) transformation;
		return null;
	}

	@Override
	protected void preprocessEvaluation(TransformationSolution solution) {
		solution.setAttribute(
				ATTRIBUTE_METRICS, 
				MetricCalculator.calculateMetrics(
						ModularizationUtil.assertTransformationRoot(
								solution.execute())));
	}
	
	@Override
	protected void postprocessEvaluation(TransformationSolution solution,
			double result) {
		super.postprocessEvaluation(solution, result);
//		System.out.println(PrinterUtil.printTransformation(solution.getSourceGraph()));
//		System.out.println(PrinterUtil.printTransformation(solution.getResultGraph()));
	}
}
