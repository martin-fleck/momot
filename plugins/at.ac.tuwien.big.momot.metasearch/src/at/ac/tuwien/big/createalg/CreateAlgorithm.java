package at.ac.tuwien.big.createalg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.osgi.internal.loader.buddy.RegisteredPolicy;

import org.moeaframework.core.Algorithm;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variation;
import org.moeaframework.core.indicator.Hypervolume;
import org.moeaframework.core.operator.CompoundVariation;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.experiment.executor.SearchExecutor;
import at.ac.tuwien.big.moea.problem.ISearchProblem;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.ISolutionInitializer;
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory;
import at.ac.tuwien.big.moea.search.algorithm.local.AbstractLocalSearchAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.local.HillClimbing;
import at.ac.tuwien.big.moea.search.algorithm.local.IFitnessComparatorGenerator;
import at.ac.tuwien.big.moea.search.algorithm.local.INeighborhoodFunction;
import at.ac.tuwien.big.moea.search.algorithm.local.SimulatedAnnealing;
import at.ac.tuwien.big.moea.search.algorithm.local.neighborhood.MaximumDecreasingFitnessGenerator;
import at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication.USE_SOLUTION_TYPE;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm;
import at.ac.tuwien.big.moea.singleobjectivizer.LinearObjectivizerProvider;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.local.neighborhood.ChangingNeighborhoodFunction;
import at.ac.tuwien.big.momot.search.algorithm.local.neighborhood.SingleObjectiveFitnessGenerator;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationParameterMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationVariableMutation;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;
import at.ac.tuwien.big.momot.util.MomotUtil;

import metasearch.ChangingNeighborhood;
import metasearch.DecreasingMaximumComparatorGenerator;
import metasearch.DiscardingSolutionInitializer;
import metasearch.FitnessComparatorGenerator;
import metasearch.GeneticAlgorithm;
import metasearch.IteratingAlgorithm;
import metasearch.LocalSearchAlgorithm;
import metasearch.LocalSearchApplication;
import metasearch.MemeticAlgorithm;
import metasearch.NSGAII;
import metasearch.NSGAIII;
import metasearch.Neighborhood;
import metasearch.RandomSolutionInitializer;
import metasearch.RandomWeightGenerator;
import metasearch.SolutionInitializer;
import metasearch.TabuSupportingLocalSearch;

public abstract class CreateAlgorithm {
	
	public TransformationSearchOrchestration search;
	public EvolutionaryAlgorithmFactory<TransformationSolution> moea;
	public LocalSearchAlgorithmFactory<TransformationSolution> local;
	public NondominatedPopulation referenceSet;
	public int evaluationCount;
	public ModuleManager moduleManager;
	{
	}
	
	public static NondominatedPopulation referenceSetFromFile(String fakeReferenceFile) {
		NondominatedPopulation referenceSet = new NondominatedPopulation();
		try (BufferedReader reader = new BufferedReader(new FileReader(fakeReferenceFile))) {
			String s;
			while ((s = reader.readLine()) != null) {
				if ("".equals(s.trim())) {
					continue;
				}
				String[] str = s.split("[,]");
				double[] objectives = new double[str.length];
				for (int i = 0; i < str.length; ++i) {
					objectives[i] = Double.valueOf(str[i]);
				}
				Solution fakeSolution = new Solution(objectives);
				referenceSet.add(fakeSolution);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return referenceSet;
	}
	
	public static void referenceSetToFile(NondominatedPopulation pop, String fakeReferenceFile) {
		try (FileOutputStream fos = new FileOutputStream(fakeReferenceFile)) {
			for (Solution s: pop) {
				double[] v = s.getObjectives();
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < v.length; ++i) {
					if (i > 0) {
						builder.append(",");
					}
					builder.append(v[i]);
				}
				builder.append("\n");
				fos.write(builder.toString().getBytes());
			}
			fos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
    
    public CreateAlgorithm(String[] modules, String initialGraph, int solutionLength, int populationSize, String fakeReferenceFile,
    		int evaluationCount, TransformationSearchOrchestration orchestration) {
    	this.modules = modules;
    	this.evaluationCount = evaluationCount;
    	this.solutionlength = solutionLength;
		this.search = orchestration;
		 moduleManager = orchestration.getModuleManager();
		 moduleManager.addModules(modules);
		 //		 if (ecoreFile != null) {
//			 moduleManager.registerMetamodel(new File(ecoreFile));
//		 }
		final EGraph graph = createInputGraph(initialGraph, moduleManager);
		orchestration.setModuleManager(moduleManager);
		orchestration.setProblemGraph(graph);
		orchestration.setSolutionLength(solutionLength);
		orchestration.setFitnessFunction(createFitnessFunction());
		
		referenceSet = referenceSetFromFile(fakeReferenceFile);
		
		
		moea = orchestration
		      .createEvolutionaryAlgorithmFactory(populationSize);
		local = orchestration .createLocalSearchAlgorithmFactory();
    }
    
    protected abstract IEGraphMultiDimensionalFitnessFunction createFitnessFunction();
    
    protected EGraph createInputGraph(final String initialGraph, final ModuleManager moduleManager) {
        final EGraph graph = moduleManager.loadGraph(initialGraph);
        return adaptInputGraph(moduleManager, graph);
     }
    


    protected EGraph adaptInputGraph(final ModuleManager moduleManager, final EGraph initialGraph) {
       final EGraph problemGraph = MomotUtil.copy(initialGraph);
       final EObject root = MomotUtil.getRoot(problemGraph);
       adaptInputModel(root);
       return MomotUtil.createEGraph(root);
    }

    
    protected final String[] modules;
	public int solutionlength;
    
    protected ModuleManager createModuleManager() {
        final ModuleManager manager = new ModuleManager();
        manager.addModules(modules);
        return manager;
     }
    
    protected abstract EObject adaptInputModel(final EObject root);

     protected abstract void adaptResultModel(final EObject root);
    
    
    private IFitnessComparatorGenerator<?,TransformationSolution> createFitnessGenerator(FitnessComparatorGenerator gen) {
    	if (gen instanceof DecreasingMaximumComparatorGenerator) {
    		return new MaximumDecreasingFitnessGenerator();
    	} else if (gen instanceof RandomWeightGenerator) {
    		return new SingleObjectiveFitnessGenerator(true);
    	} else {
    		throw new RuntimeException("Unknown type " + gen);
    	}
    }

    private  at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication 
    	createLSA(GeneticAlgorithm topAlg, LocalSearchApplication lsa, int totalEvalNumb) {
    	double prob = lsa.getProbability();
    	double getStartAtEval = lsa.getStartAtEvalPerc();
    	int tournamentSize = lsa.getTournamentSize();
    	int startStep = (int)(totalEvalNumb*getStartAtEval/topAlg.getPopulationSize());
    	
    	IFitnessComparatorGenerator<?,TransformationSolution> generator = createFitnessGenerator(lsa.getUsedGenerator());
    	
    	LocalSearchAlgorithm ls = lsa.getLocalsearchalgorithm();
    	AbstractLocalSearchAlgorithm<TransformationSolution> lalg = createLocalAlgorithm(ls);
    	at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication<TransformationSolution>
    		ret = new at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication<TransformationSolution>(
    				lalg, prob, ls.getNrEvaluations(),
    				lsa.isLastSolution()?USE_SOLUTION_TYPE.LAST:USE_SOLUTION_TYPE.BEST,
    						generator, tournamentSize, startStep);
    	return ret;
    }

	private Algorithm createMemeticAlgorithm(MemeticAlgorithm alg) {
		GeneticAlgorithm gs = alg.getGlobalSearch();
		Algorithm galg = createGeneticAlgorithm(gs);
		Field variation = null;
		Class<?> cl = galg.getClass();
		while (cl != null) {
			try {
				variation = cl.getDeclaredField("variation");
				if (variation != null) {
					break;
				}
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			cl = cl.getSuperclass();
		}
		if (variation != null) {
			try {
				at.ac.tuwien.big.moea.search.algorithm.operator.subalgo.LocalSearchApplication lsa = createLSA(
						gs,alg.getLocalsearchapplication(),alg.getNrEvaluations());
				variation.setAccessible(true);
				Variation var = (Variation)variation.get(galg);
				if (var instanceof CompoundVariation) {
					Field oper = CompoundVariation.class.getDeclaredField("operators");
					oper.setAccessible(true);
					List<Variation> sub = (List<Variation>)oper.get(var);
					sub.add(lsa);
				} else {
					CompoundVariation cv = new CompoundVariation(var,lsa);
					variation.set(galg, cv);
				}
				
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("Could not find variation field!");
		}
		return galg;
	}

	
	private INeighborhoodFunction createNeighborhood(Neighborhood nh, int neighborhoodSize)  {
		if (nh instanceof ChangingNeighborhood) {
			ChangingNeighborhood ch = (ChangingNeighborhood)nh;
			return new ChangingNeighborhoodFunction(search.getSearchHelper(),
					ch.getDeleteProbability(), ch.getModifyRuleProbability(), neighborhoodSize, ch.getAtEndProbability());
		}
		throw new RuntimeException("Unknown neighborhood " + nh);
	}
	
	private AbstractLocalSearchAlgorithm<TransformationSolution> createLocalAlgorithm(LocalSearchAlgorithm alg) {
		Neighborhood nh = alg.getNeighborhood();
		int nhsize = 1;
		if (alg instanceof metasearch.HillClimbing) {
			nhsize = ((metasearch.HillClimbing) alg).getNeighborsize();
		}
		INeighborhoodFunction nfunc = createNeighborhood(nh,nhsize);
		AbstractLocalSearchAlgorithm<TransformationSolution> ret;
		if (alg instanceof metasearch.HillClimbing) {
			metasearch.HillClimbing halg = (metasearch.HillClimbing)alg;
			ret = local.createHillClimbing(nfunc, null, halg.getMaxNoImprovement()).createAlgorithm();
		} else if (alg instanceof metasearch.SimulatedAnnealing) {
			metasearch.SimulatedAnnealing salg = (metasearch.SimulatedAnnealing)alg;
			ret = (AbstractLocalSearchAlgorithm<TransformationSolution>) 
					local.createSimulatedAnnealing(nfunc, null, salg.getTempIncrease(),
					salg.getStartTemp(), salg.getRestartNoCurrentImp(), salg.getRestartNoBestImp()).createAlgorithm();
		} else {
			throw new RuntimeException("Unknown local algorithm "+alg);
		}
		if (alg instanceof TabuSupportingLocalSearch) {
			ret.addForbiddenIndex(((TabuSupportingLocalSearch) alg).getTabuSize());
		}
		return ret;
	}

	private Algorithm createGeneticAlgorithm(GeneticAlgorithm alg) {
		double mutateDelete = alg.getMutateDelete();
		double mutateChangePar = alg.getMutateModifyRule();
		double mutateChangeRule = alg.getMutateReplaceRule();
		if (alg instanceof NSGAII) {
			return moea.createNSGAIII(new TournamentSelection(2), new OnePointCrossover(1.0),
		            new TransformationVariableMutation(search.getSearchHelper(), mutateChangeRule),
		            new TransformationParameterMutation(mutateChangePar, search.getModuleManager()),
		            new TransformationPlaceholderMutation(mutateDelete)).createAlgorithm();
		} else if (alg instanceof NSGAIII) {
			return moea.createNSGAII(new TournamentSelection(2), new OnePointCrossover(1.0),
		            new TransformationVariableMutation(search.getSearchHelper(), mutateChangeRule),
		            new TransformationParameterMutation(mutateChangePar, search.getModuleManager()),
		            new TransformationPlaceholderMutation(mutateDelete)).createAlgorithm();
		}
		throw new RuntimeException("Unknown genetic algorithm " + alg);
	}
	
	private ISolutionInitializer<TransformationSolution> createSolutionInitializer(SolutionInitializer sol) {
		if (sol instanceof RandomSolutionInitializer) {
			return new at.ac.tuwien.big.momot.search.algorithm.init.RandomSolutionInitializer<>(search.getSearchHelper());
		} else if (sol instanceof DiscardingSolutionInitializer){
			DiscardingSolutionInitializer dsi = (DiscardingSolutionInitializer)sol;
			return new at.ac.tuwien.big.momot.search.algorithm.init.DiscardingSolutionInitializer<>(
					search.getSearchHelper(),
					dsi.getNumInitSolutions()+1,dsi.getSolutionConsiderSize(),dsi.getSolutionUseSize(),
					dsi.getSolutionsPerQueue(),dsi.getNumQueues(),dsi.getNumInitSolutions(),100,search.getFitnessFunction()
					);
		} else {
			throw new RuntimeException("Unknown solution initializer "+sol);
		}
	}
	
	private Algorithm createIteratingAlgorithm(IteratingAlgorithm alg) {
		
		at.ac.tuwien.big.moea.search.algorithm.iterating.IteratingAlgorithm ret =
				new at.ac.tuwien.big.moea.search.algorithm.iterating.IteratingAlgorithm(
						search.getProblem(),
						createFitnessGenerator(alg.getFitnesscomparatorgenerator()),
						createSolutionInitializer(alg.getSolutioninitializer()),
						createLocalAlgorithm(alg.getAlgorithm()),
						alg.getAlgorithm().getNrEvaluations(),
						alg.getTournamentSize(),
						alg.getTournamentRemain()
						);
		return ret;
	}
    
    
    public IRegisteredAlgorithm<Algorithm> createAlgorithm(metasearch.Algorithm alg) {
    	return new RegisteredAlgorithm<Algorithm>() {
			@Override
			public Algorithm createAlgorithm() {
				if (alg instanceof GeneticAlgorithm) {
					return createGeneticAlgorithm((GeneticAlgorithm)alg);
				} else if (alg instanceof LocalSearchAlgorithm) {
					return createLocalAlgorithm((LocalSearchAlgorithm)alg);
				} else if (alg instanceof MemeticAlgorithm) {
					return createMemeticAlgorithm((MemeticAlgorithm)alg);
				} else if (alg instanceof IteratingAlgorithm) {
					return createIteratingAlgorithm((IteratingAlgorithm)alg);
				} else {
					throw new RuntimeException("Unsupported Algorithm "+alg);
				}
			}

		};
    }
    
    
    
    public double run(metasearch.Algorithm alg) {
    	IRegisteredAlgorithm<Algorithm> rrunalg = createAlgorithm(alg);
    	Algorithm runalg = rrunalg.createAlgorithm();
    	SearchExecutor exec = new SearchExecutor();
    	exec.withAlgorithm(runalg).withMaxEvaluations(evaluationCount).
    		withProblem((ISearchProblem)runalg.getProblem());
    	NondominatedPopulation ret = exec.runSingleSeed(0, 1, evaluationCount);
    	Hypervolume volume = new Hypervolume(search.getProblem(), referenceSet);
    	double retV = volume.evaluate(ret);
    	if (retV == 0.0) {
    		System.err.println("Bad algorithm: ");
    		for (Solution s: ret) {
    			System.out.println(Arrays.toString(s.getObjectives()));
    		}
    	}
    	return retV;
    }
    
    
}
