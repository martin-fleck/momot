package at.ac.tuwien.big.momot.examples.stack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;
import org.moeaframework.core.indicator.Hypervolume;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.createalg.CreateAlgorithm;
import at.ac.tuwien.big.moea.SearchAnalysis;
import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.SearchResultManager;
import at.ac.tuwien.big.moea.experiment.analyzer.kneepoint.PopulationAnalyzer;
import at.ac.tuwien.big.moea.experiment.executor.SearchExecutor;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.problem.IParetoFrontStoringSearchProblem;
import at.ac.tuwien.big.moea.problem.solution.ParetoFront;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.ISolutionInitializer;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.iterating.IteratingAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.local.AbstractLocalSearchAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.local.HillClimbing;
import at.ac.tuwien.big.moea.search.algorithm.local.IDeltaEstimator;
import at.ac.tuwien.big.moea.search.algorithm.local.IDeltaEstimatorGenerator;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparator;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparatorGenerator;
import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhoodFunction;
import at.ac.tuwien.big.moea.search.algorithm.local.SimulatedAnnealing;
import at.ac.tuwien.big.moea.search.algorithm.local.neighborhood.MaximumDecreasingFitnessGenerator;
import at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication;
import at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication.USE_SOLUTION_TYPE;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.fitness.comparator.ObjectiveFitnessComparator;
import at.ac.tuwien.big.moea.singleobjectivizer.LinearObjectivizerProvider;
import at.ac.tuwien.big.moea.singleobjectivizer.LinearSingleObjectivizer;
import at.ac.tuwien.big.moea.singleobjectivizer.ObjectiveAdder;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizer;
import at.ac.tuwien.big.moea.singleobjectivizer.SingleObjectivizerProvider;
import at.ac.tuwien.big.momot.TransformationResultManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.stack.stack.StackPackage;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.init.DiscardingSolutionInitializer;
import at.ac.tuwien.big.momot.search.algorithm.init.RandomSolutionInitializer;
import at.ac.tuwien.big.momot.search.algorithm.local.neighborhood.ChangingNeighborhoodFunction;
import at.ac.tuwien.big.momot.search.algorithm.local.neighborhood.IncreasingNeighborhoodFunction;
import at.ac.tuwien.big.momot.search.algorithm.local.neighborhood.SingleObjectiveFitnessGenerator;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationParameterMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationVariableMutation;

public class StackSearch {
	public static final int SOLUTION_LENGTH = 20;
	public static final int POPULATION_SIZE = 100;
	public static final int MAX_EVALUATIONS = POPULATION_SIZE * 400;
	
	//public static final String INPUT_MODEL = "input/model/model_five_stacks.xmi";
	
	public static final String INPUT_MODEL = "comparison_11-4-2-5-0-19-12-14-7-2.xmi";
	
//	private static final String REFERENCE_SET = "model/input/referenceSet/model_five_stacks_reference_set.pf";
	public static final int NR_RUNS = 30;
	
	public final static int HILL_STEPS = 20;

	public final static int SA_STEPS = 2000;
	
	public static final String FAKE_REF = "output/fakeReferences.txt";
	

	public final static boolean DO_IMPROVEMENT = false;
	
	public static void main(String[] args) throws IOException {
		StackPackage.eINSTANCE.eClass();
		
		SingleObjectivizerProvider provider = new LinearObjectivizerProvider();
		final ObjectiveAdder adder = new ObjectiveAdder();
		
		// search orchestration
		final StackOrchestration search = new StackOrchestration(provider, INPUT_MODEL, SOLUTION_LENGTH);		
		
		// algorithms
		EvolutionaryAlgorithmFactory<TransformationSolution> moea = search.createEvolutionaryAlgorithmFactory(POPULATION_SIZE);
		
		LocalSearchAlgorithmFactory<TransformationSolution> local = search.createLocalSearchAlgorithmFactory();
		
		RegisteredAlgorithm<HillClimbing<TransformationSolution>> hillClimbing = local.createHillClimbing(
				new IncreasingNeighborhoodFunction(search.getSearchHelper(), 100),
				new ObjectiveFitnessComparator<TransformationSolution>(
						search.getFitnessFunction().getObjectiveIndex("Standard Deviation")),10);
		
		
		
		RegisteredAlgorithm<HillClimbing<TransformationSolution>> hillClimbing2 = local.createHillClimbing(
				new IncreasingNeighborhoodFunction(search.getSearchHelper(), 100),
				new IFitnessComparator<Double, TransformationSolution>() {

					
					
					@Override
					public int compare(TransformationSolution arg0, TransformationSolution arg1) {
						return getValue(arg0).compareTo(getValue(arg1));
					}

					@Override
					public Double getValue(TransformationSolution solution) {
						Problem curProblem = search.getProblem();
						if (curProblem instanceof IParetoFrontStoringSearchProblem) {
							return ((IParetoFrontStoringSearchProblem<?>)curProblem).getCurrentSingleObjectivizer().calculateSingleObjective(solution);
						} 
						return adder.calculateSingleObjective(solution);
					}
				},10);
		
		search.addAlgorithm("SA-HighTemp", createSA(search, local, true, false, 0.07));
		
		search.addAlgorithm("NSGA-III", moea.createNSGAIII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),
	            new TransformationVariableMutation(search.getSearchHelper(), 0.25),
	            new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.25)));
		
		
		search.addAlgorithm("NSGA-II", moea.createNSGAII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),
	            new TransformationVariableMutation(search.getSearchHelper(), 0.25),
	            new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.25)));
		
		
		search.addAlgorithm("E-MOEA", moea.createEpsilonMOEA(0.01,
				new TournamentSelection(2),
				new OnePointCrossover(1.0),
	            new TransformationVariableMutation(search.getSearchHelper(), 0.25),
	            new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.25)));
		
		search.addAlgorithm("Hill", createHill(search, local, true, false, 10, 10));

	     // search.addAlgorithm("NSGAIII-SA-Lowtemp-T6-Wait",
	     //       createNSGAIIMemSA(search, moea, local, true, 0, 0.005, false, false, 4, 100));
		/*
		search.addAlgorithm("NSGA-III", moea.createNSGAIII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.1)));
		
		search.addAlgorithm("EpsilonMOEA", moea.createEpsilonMOEA(
				0.027,
				new TournamentSelection(2),
				new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.1)));
		
		//search.addAlgorithm("Random", moea.createRandomSearch());
		/*
		search.addAlgorithm("NSGA-II-Memetic",moea.createNSGAII(new TournamentSelection(2),
				new OnePointCrossover(1.0),
				new TransformationParameterMutation(0.25, search.getModuleManager()),
				new TransformationPlaceholderMutation(0.1),
				new LocalSearchApplication<>(hillClimbing2.createAlgorithm(),0.1,15,USE_SOLUTION_TYPE.BEST)
				));*/
				
		
		//search.addAlgorithm("RandomSearch", moea.createRandomSearch()); 
		
		// algorithms
		
		//search.addAlgorithm("IHillClimbing", hillClimbing);
		
		
		/*search.addAlgorithm("RandomDescent", local.createRandomDescent(
				new IncreasingNeighborhoodFunction(search.getSearchHelper(), 100),
				new ObjectiveFitnessComparator<TransformationSolution>(
						search.getFitnessFunction().getObjectiveIndex("Standard Deviation"))));*/
	
		// experiment
		SearchExperiment<TransformationSolution> experiment = new SearchExperiment<TransformationSolution>(search, MAX_EVALUATIONS);
//		experiment.setReferenceSetFile(REFERENCE_SET);
		experiment.setNumberOfRuns(NR_RUNS);
		experiment.addProgressListener(new SeedRuntimePrintListener());
		
		experiment.run();
		 
		// analysis
		SearchAnalysis analysis = new SearchAnalysis(experiment);
		analysis.setAllIndicators(true);
		analysis.setShowAll(true);
//		SearchAnalyzer analyzer = analysis.analyze();
		
		// check collected data
//		SearchCollectorHelper helper = new SearchCollectorHelper(experiment);
//		System.out.println(helper.getAvailableKeys());
//		System.out.println(helper.getCollectedData("R3Indicator"));
//		System.out.println(helper.getCollectedData("NSGA-II", "R3Indicator"));
		
		// result management
		TransformationResultManager resultManager = new TransformationResultManager(experiment);
		System.out.println("\nReferenceSet:");
		System.out.println(resultManager.printReferenceSet());
		System.out.println("ApproximationSet:");
		System.out.println(resultManager.printObjectives());
		
		resultManager.setBaseDirectory("model/output_test/solutions/moea/");
		resultManager.saveModels("EpsilonMOEA", "NSGA-III", "NSGA-II", "NSGA-II-Memetic", "RandomSearch");
		
		resultManager.setBaseDirectory("model/output_test/solutions/local/");
		resultManager.saveModels("HillClimbing", "RandomDescent");
		
		resultManager.setBaseDirectory("model/output_test/approximationSet/");
		resultManager.saveObjectives("approximation_set_all.pf");
		
		resultManager.setBaseDirectory("model/output_test/approximationSet/moea/");
		resultManager.saveObjectives("approximation_set_epsilonmoea.pf", "EpsilonMOEA");
		resultManager.saveObjectives("approximation_set_nsgaiii.pf", "NSGA-III");
		resultManager.saveObjectives("approximation_set_nsgaii.pf", "NSGA-II");
		resultManager.saveObjectives("approximation_set_nsgaiimem.pf", "NSGA-II-Memetic");
		resultManager.saveObjectives("approximation_set_random.pf", "RandomSearch");
		resultManager.saveObjectives("approximation_set_evolutionary.pf", "EpsilonMOEA", "NSGA-III", "NSGA-II", "NSGA-II-Memetic", "RandomSearch");
		
		resultManager.setBaseDirectory("model/output_test/approximationSet/local/");
		resultManager.saveObjectives("approximation_set_hillclimbing.pf", "HillClimbing");
		resultManager.saveObjectives("approximation_set_randomdescent.pf", "RandomDescent");
		resultManager.saveObjectives("approximation_set_local.pf", "HillClimbing", "RandomDescent");
		
		analysis.analyze().printAnalysis();
//		analyzer.saveAnalysis(new File("model/output/analysis.txt"));
		
		
	     final PopulationAnalyzer analyzer = new PopulationAnalyzer(
	             SearchResultManager.createApproximationSet(experiment));

	       final Hypervolume hypervolume = new Hypervolume(experiment.getSearchOrchestration().getProblem(),
	             analyzer.getReferenceSet());

	       final ParetoFront<Solution> par = new ParetoFront<Solution>();
	       for(final Solution sol : analyzer.getReferenceSet()) {
	          par.tryAdd(sol);
	       }
	       
	       CreateAlgorithm.referenceSetToFile(analyzer.getReferenceSet(), FAKE_REF + ".new");

	       final int objectiveNum = experiment.getSearchOrchestration().getNumberOfObjectives();

	       final SingleObjectivizer objectivizer = provider.provide(par.getParetoFront());
	       LinearSingleObjectivizer lso;
	       if(objectivizer instanceof ObjectiveAdder) {
	          final double[] dbl = new double[objectiveNum];
	          final double[] bestObj = analyzer.getBestObjectives();
	          final double[] worstObj = analyzer.getWorstObjectives();
	          for(int i = 0; i < bestObj.length; ++i) {
	             if(bestObj[i] == worstObj[i]) {
	                dbl[i] = 0.1;
	             } else {
	                dbl[i] = 1.0 / Math.abs(worstObj[i] - bestObj[i]);
	             }
	          }
	          lso = new LinearSingleObjectivizer(dbl);
	       } else {
	          lso = (LinearSingleObjectivizer) objectivizer;
	       }

	       final Problem problem = experiment.getSearchOrchestration().getProblem();

	       for(final IRegisteredAlgorithm alg : experiment.getSearchOrchestration().getAlgorithms()) {
	          final String name = experiment.getSearchOrchestration().getAlgorithmName(alg);
	          int index = 1;
	          int baseIndex = 0;
	          final File file = new File("output/models/" + name + "/");
	          if(!file.exists()) {
	             file.mkdirs();
	          }
	          try {
	             final FileOutputStream csvList = new FileOutputStream(new File(file, "hypervolume.csv"));
	             final FileOutputStream solutionList = new FileOutputStream(new File(file, "solutionObjectives.csv"));
	             final FileOutputStream csvListImp = new FileOutputStream(new File(file, "hypervolume_improve.csv"));
	             csvListImp.write("Base,Hill,SA\n".getBytes());
	             if(DO_IMPROVEMENT) {
	                for(final Entry<SearchExecutor, List<NondominatedPopulation>> entry : experiment.getResults()
	                      .entrySet()) {

	                   NondominatedPopulation pop = null;
	                   double bestVolumeV = Double.NEGATIVE_INFINITY;
	                   for(final NondominatedPopulation p : entry.getValue()) {
	                      final double curVal = hypervolume.evaluate(p);
	                      if(curVal > bestVolumeV) {
	                         pop = p;
	                         bestVolumeV = curVal;
	                      }
	                   }

	                   System.out.println("For results of " + entry.getKey().getName());
	                   if(pop != null) {
	                      int improved = 0;
	                      int nonimproved = 0;
	                      final NondominatedPopulation targethill = new NondominatedPopulation();
	                      for(int i = 0; i < 1 + objectiveNum; ++i) {
	                         for(final org.moeaframework.core.Solution sol : pop) {
	                            final SingleObjectiveFitnessGenerator gen = new SingleObjectiveFitnessGenerator(false);
	                            gen.setState(i);
	                            final INeighborhoodFunction<TransformationSolution> func = new ChangingNeighborhoodFunction(
	                                  ((TransformationSearchOrchestration) experiment.getSearchOrchestration())
	                                        .getSearchHelper(),
	                                  0.1, 0.0, 100, 0.7);
	                            final IFitnessComparator comp = gen.generateComparator(problem,
	                                  (TransformationSolution) sol, analyzer.getReferenceSet());
	                            final HillClimbing<TransformationSolution> hc = new HillClimbing<TransformationSolution>(
	                                  problem, (TransformationSolution) sol, func, comp, 10);
	                            for(int k = 0; k < HILL_STEPS / (1 + objectiveNum); ++k) {
	                               hc.step();
	                               if(hc.isTerminated()) {
	                                  break;
	                               }
	                            }
	                            final Solution best = hc.getBestSolution();
	                            if(Arrays.equals(best.getObjectives(), sol.getObjectives())) {
	                               nonimproved++;
	                            } else {
	                               ++improved;
	                            }
	                            targethill.add(hc.getBestSolution());
	                         }
	                      }
	                      System.out.println("Hill improved: " + improved + "/" + nonimproved + " --> "
	                            + hypervolume.evaluate(pop) + " VS " + hypervolume.evaluate(targethill));

	                      improved = nonimproved = 0;
	                      final NondominatedPopulation targethillmax = new NondominatedPopulation();
	                      for(int i = 0; i < 1 + objectiveNum; ++i) {
	                         for(final org.moeaframework.core.Solution sol : pop) {
	                            final IDeltaEstimatorGenerator gen = new MaximumDecreasingFitnessGenerator();
	                            final INeighborhoodFunction<TransformationSolution> func = new ChangingNeighborhoodFunction(
	                                  ((TransformationSearchOrchestration) experiment.getSearchOrchestration())
	                                        .getSearchHelper(),
	                                  0.1, 0.0, 50, 0.7);
	                            final IFitnessComparator comp = gen.generateComparator(problem, sol, analyzer.getReferenceSet());
	                            final HillClimbing<TransformationSolution> hc = new HillClimbing<TransformationSolution>(
	                                  problem, (TransformationSolution) sol, func, comp, 10);
	                            for(int k = 0; k < HILL_STEPS / (1 + objectiveNum); ++k) {
	                               hc.step();
	                               if(hc.isTerminated()) {
	                                  break;
	                               }
	                            }
	                            final Solution best = hc.getBestSolution();
	                            if(Arrays.equals(best.getObjectives(), sol.getObjectives())) {
	                               nonimproved++;
	                            } else {
	                               ++improved;
	                            }
	                            targethillmax.add(hc.getBestSolution());
	                         }
	                      }
	                      System.out.println("Hill-MAX improved: " + improved + "/" + nonimproved + " --> "
	                            + hypervolume.evaluate(pop) + " VS " + hypervolume.evaluate(targethillmax));

	                      final NondominatedPopulation targetsa = new NondominatedPopulation();
	                      improved = nonimproved = 0;
	                      for(int i = 0; i < 1 + objectiveNum; ++i) {
	                         for(final org.moeaframework.core.Solution sol : pop) {
	                            final SingleObjectiveFitnessGenerator gen = new SingleObjectiveFitnessGenerator(false);
	                            gen.setState(i);

	                            final INeighborhoodFunction<TransformationSolution> func = new ChangingNeighborhoodFunction(
	                                  ((TransformationSearchOrchestration) experiment.getSearchOrchestration())
	                                        .getSearchHelper(),
	                                  0.1, 0.0, 50, 0.7);
	                            final IDeltaEstimator comp = gen.generateComparator(problem, (TransformationSolution) sol, analyzer.getReferenceSet());
	                            final SimulatedAnnealing hc = new SimulatedAnnealing(problem, sol, func, comp, 0.005, 30, 30,
	                                  800);
	                            for(int k = 0; k < SA_STEPS / (1 + objectiveNum); ++k) {
	                               hc.step();
	                            }
	                            final Solution best = hc.getBestSolution();
	                            if(Arrays.equals(best.getObjectives(), sol.getObjectives())) {
	                               nonimproved++;
	                            } else {
	                               ++improved;
	                            }
	                            targetsa.add(best);
	                         }
	                      }
	                      System.out.println("SA improved: " + improved + "/" + nonimproved + " --> "
	                            + hypervolume.evaluate(pop) + " VS " + hypervolume.evaluate(targetsa));

	                      final NondominatedPopulation targetsamax = new NondominatedPopulation();
	                      improved = nonimproved = 0;
	                      for(final org.moeaframework.core.Solution sol : pop) {
	                         final MaximumDecreasingFitnessGenerator gen = new MaximumDecreasingFitnessGenerator<Solution>();
	                         final INeighborhoodFunction<TransformationSolution> func = new ChangingNeighborhoodFunction(
	                               ((TransformationSearchOrchestration) experiment.getSearchOrchestration())
	                                     .getSearchHelper(),
	                               0.1, 0.0, 50, 0.7);
	                         final IDeltaEstimator comp = gen.generateComparator(problem, sol, analyzer.getReferenceSet());
	                         final SimulatedAnnealing hc = new SimulatedAnnealing(problem, sol, func, comp, 0.005, 30, 30,
	                               800);
	                         for(int k = 0; k < SA_STEPS / (1 + objectiveNum); ++k) {
	                            hc.step();
	                         }
	                         final Solution best = hc.getBestSolution();
	                         if(Arrays.equals(best.getObjectives(), sol.getObjectives())) {
	                            nonimproved++;
	                         } else {
	                            ++improved;
	                         }
	                         targetsamax.add(best);
	                      }
	                      System.out.println("SA-M improved: " + improved + "/" + nonimproved + " --> "
	                            + hypervolume.evaluate(pop) + " VS " + hypervolume.evaluate(targetsamax));
	                      csvListImp.write((hypervolume.evaluate(pop) + "," + hypervolume.evaluate(targethill) + ","
	                            + hypervolume.evaluate(targethillmax) + "," + hypervolume.evaluate(targetsa) + ","
	                            + hypervolume.evaluate(targetsamax) + "\n").getBytes());
	                   }
	                }
	             }

	             for(final Entry<SearchExecutor, List<NondominatedPopulation>> entry : experiment.getResults().entrySet()) {	            	 
	                if(name.equals(entry.getKey().getName())) {
	                	++baseIndex;
	                	index = 1;
	                   final List<List<NondominatedPopulation>> populationList = entry.getKey().getResultListsPerRun();

	                   int maxListSize = 0;
	                   for(int i = 0; i < populationList.size(); ++i) {
	                      maxListSize = Math.max(maxListSize, populationList.get(i).size());
	                   }
	                   for(int i = 0; i < maxListSize; ++i) {
	                      boolean first = true;
	                      for(final List<NondominatedPopulation> pList : populationList) {
	                         if(first) {
	                            first = false;
	                         } else {
	                            csvList.write(",".getBytes());
	                         }
	                         if(pList.size() > i) {
	                            final NondominatedPopulation subpopulation = pList.get(i);
	                            final double ret = hypervolume.evaluate(subpopulation);
	                            csvList.write(String.valueOf(ret).getBytes());
	                         }
	                      }
	                      csvList.write("\n".getBytes());
	                   }

	                   csvList.write("\n\n\n".getBytes());

	                   int popNum = 0;

	                   for(final NondominatedPopulation pop : entry.getValue()) {
	                      int sind = 0;
	                      for(final org.moeaframework.core.Solution sol : pop) {
	                         final File solFile = new File(file, "solution_" + popNum + "-" + sind + ".xmi");
	                         TransformationResultManager.saveModel(solFile, sol);
	                         final StringBuilder builder = new StringBuilder();
	                         builder.append(popNum + "," + sind);
	                         final double[] v = sol.getObjectives();
	                         for(final double element : v) {
	                            builder.append("," + element);
	                         }
	                         builder.append("\n");
	                         solutionList.write(builder.toString().getBytes());
	                         ++index;
	                         ++sind;
	                      }
	                      ++popNum;
	                   }
	                   
	               
	                }
	             }
	             solutionList.flush();
	             solutionList.close();
	             csvList.flush();
	             csvList.close();
	             csvListImp.flush();
	             csvListImp.close();
	          } catch(final IOException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	          }
	       }
		
	}
	

	   protected static IRegisteredAlgorithm<IteratingAlgorithm<TransformationSolution>> createHill(
	         final TransformationSearchOrchestration search,
	         final LocalSearchAlgorithmFactory<TransformationSolution> local, final boolean randomizeLocalSearch,
	         final boolean randomInit, final int neighborhood, final int maxNoImprovements) {

	      final RegisteredAlgorithm simulatedAnnealing = local.createHillClimbing(
	            new ChangingNeighborhoodFunction(search.getSearchHelper(), 0.1, 0.0, neighborhood, 0.7), null,
	            maxNoImprovements);
	      final IFitnessComparatorGenerator<Double, TransformationSolution> randomizedGenerator = new SingleObjectiveFitnessGenerator(
	            randomizeLocalSearch);

	      return local.createIterating(simulatedAnnealing, randomizedGenerator, () -> {
	         final ISolutionInitializer<TransformationSolution> initializer;
	         if(randomInit) {
	            return new RandomSolutionInitializer<>(search.getSearchHelper());
	         } else {
	            return new DiscardingSolutionInitializer<>(search.getSearchHelper(), 100, 8, 2, 50, 8, 200, 20,
	                  search.getFitnessFunction());
	         }
	      }, randomInit ? 500 : 300);

	   }

	   protected static IRegisteredAlgorithm<IteratingAlgorithm<TransformationSolution>> createSA(
	         final TransformationSearchOrchestration search,
	         final LocalSearchAlgorithmFactory<TransformationSolution> local, final boolean randomizeLocalSearch,
	         final boolean randomInit, final double temperature) {

	      final RegisteredAlgorithm simulatedAnnealing = local.createSimulatedAnnealing(
	            new ChangingNeighborhoodFunction(search.getSearchHelper(), 0.1, 0.0, 10, 0.7), null, temperature, 0.2
	            /* 0.2/0.007 */, 50, 1000);
	      final IFitnessComparatorGenerator<Double, TransformationSolution> randomizedGenerator = new SingleObjectiveFitnessGenerator(
	            randomizeLocalSearch);

	      return local.createIterating(simulatedAnnealing, randomizedGenerator, () -> {
	         final ISolutionInitializer<TransformationSolution> initializer;
	         if(randomInit) {
	            return new RandomSolutionInitializer<>(search.getSearchHelper());
	         } else {
	            return new DiscardingSolutionInitializer<>(search.getSearchHelper(), 100, 8, 2, 50, 8, 200, 20,
	                  search.getFitnessFunction());
	         }
	      }, randomInit ? 250 : 1000);

	   }

	   protected static IRegisteredAlgorithm<NSGAII> createNSGAIIMemSA(final TransformationSearchOrchestration search,
	         final EvolutionaryAlgorithmFactory<TransformationSolution> moea,
	         final LocalSearchAlgorithmFactory<TransformationSolution> local, final boolean randomizeLocalSearch,
	         final int tabuSize, final double temperature, final boolean burst, final boolean useLast,
	         final int tournamentSize, final int minStep) {
	      final RegisteredAlgorithm simulatedAnnealing = local.createSimulatedAnnealing(
	            new ChangingNeighborhoodFunction(search.getSearchHelper(), 0.1, 0.0, 1, 0.7), null, temperature,
	            0.2 /* 0.2/0.05 */, 30, 500);
	      final IFitnessComparatorGenerator<?, TransformationSolution> randomizedGenerator = new SingleObjectiveFitnessGenerator(
	            randomizeLocalSearch);
	      final SimulatedAnnealing sa = (SimulatedAnnealing) simulatedAnnealing.createAlgorithm();
	      sa.setForbiddenIndices(tabuSize);
	      final LocalSearchApplication lsa = new LocalSearchApplication<>(sa, burst ? 0.02 : 0.2, burst ? 1000 : 100,
	            useLast ? USE_SOLUTION_TYPE.LAST : USE_SOLUTION_TYPE.BEST, randomizedGenerator, tournamentSize, minStep

	      );
	      return moea.createNSGAIII(new TournamentSelection(2), new OnePointCrossover(1.0),
	            new TransformationVariableMutation(search.getSearchHelper(), 0.5),
	            new TransformationParameterMutation(0.5, search.getModuleManager()),
	            new TransformationPlaceholderMutation(0.5), lsa);
	   }

}
