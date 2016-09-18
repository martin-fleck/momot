package at.ac.tuwien.big.momost.examples.tse.eval;

import java.util.List;


public class PairwiseExample {
	public static void main(String[] args) {
		EvaluationUtil.initStandalone();
		
		PairwiseCalculator calculator = new PairwiseCalculator(CaseStudy.XML2MySQL.MANUAL_SOLUTION);
		
		int i = 1;
		for(TransformationEvaluationMetrics metrics : calculator.calculateDirectory(
				CaseStudy.XML2MySQL.HILLCLIMBING_DIR)) {
			System.out.println(i++ + ". " + metrics);
		}
		
		System.out.println("-------------------");
		
		List<TransformationEvaluationMetrics> nsgaiii = calculator.calculateDirectory(CaseStudy.XML2MySQL.NSGAIII_DIR, "NSGA-III");
		List<TransformationEvaluationMetrics> nsgaii = calculator.calculateDirectory(CaseStudy.XML2MySQL.NSGAII_DIR, "NSGA-II");
		List<TransformationEvaluationMetrics> random = calculator.calculateDirectory(CaseStudy.XML2MySQL.RANDOM_DIR, "RandomSearch");
		List<TransformationEvaluationMetrics> hillClimbing = calculator.calculateDirectory(CaseStudy.XML2MySQL.HILLCLIMBING_DIR, "HillClimbing");
		
		EvaluationMetricsAnalysis nsgaIIIanalysis = new EvaluationMetricsAnalysis(nsgaiii);
		EvaluationMetricsAnalysis nsgaIIanalysis = new EvaluationMetricsAnalysis(nsgaii);
		EvaluationMetricsAnalysis randomAnalysis = new EvaluationMetricsAnalysis(random);
		EvaluationMetricsAnalysis hillClimbingAnalysis = new EvaluationMetricsAnalysis(hillClimbing);
		
		System.out.println("Maximum F1:");
		System.out.println("NSGA-III:     " + nsgaIIIanalysis.getMaxF1().getF1());
		System.out.println("NSGA-II:      " + nsgaIIanalysis.getMaxF1().getF1());
		System.out.println("Random:       " + randomAnalysis.getMaxF1().getF1());
		System.out.println("HillClimbing: " + hillClimbingAnalysis.getMaxF1().getF1());
		
		System.out.println("-------------------");
		
		System.out.println("Maximum Precision:");
		System.out.println("NSGA-III:     " + nsgaIIIanalysis.getMaxPrecision().getPrecision());
		System.out.println("NSGA-II:      " + nsgaIIanalysis.getMaxPrecision().getPrecision());
		System.out.println("Random:       " + randomAnalysis.getMaxPrecision().getPrecision());
		System.out.println("HillClimbing: " + hillClimbingAnalysis.getMaxPrecision().getPrecision());
		
		System.out.println("-------------------");
		
		System.out.println("Maximum Recall:");
		System.out.println("NSGA-III:     " + nsgaIIIanalysis.getMaxRecall().getRecall());
		System.out.println("NSGA-II:      " + nsgaIIanalysis.getMaxRecall().getRecall());
		System.out.println("Random:       " + randomAnalysis.getMaxRecall().getRecall());
		System.out.println("HillClimbing: " + hillClimbingAnalysis.getMaxRecall().getRecall());
	}
}
