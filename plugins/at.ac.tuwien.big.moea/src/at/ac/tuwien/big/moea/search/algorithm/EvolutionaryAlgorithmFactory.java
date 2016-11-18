package at.ac.tuwien.big.moea.search.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.moeaframework.algorithm.AdaptiveTimeContinuation;
import org.moeaframework.algorithm.EpsilonMOEA;
import org.moeaframework.algorithm.IBEA;
import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.algorithm.PAES;
import org.moeaframework.algorithm.PESA2;
import org.moeaframework.algorithm.RandomSearch;
import org.moeaframework.algorithm.ReferencePointNondominatedSortingPopulation;
import org.moeaframework.algorithm.SMSEMOA;
import org.moeaframework.algorithm.SPEA2;
import org.moeaframework.algorithm.VEGA;
import org.moeaframework.core.FitnessEvaluator;
import org.moeaframework.core.Initialization;
import org.moeaframework.core.Selection;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variation;
import org.moeaframework.core.fitness.IndicatorFitnessEvaluator;
import org.moeaframework.core.operator.CompoundVariation;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;
import org.moeaframework.core.operator.UniformSelection;
import org.moeaframework.core.operator.real.UM;

import at.ac.tuwien.big.moea.ISearchOrchestration;
import at.ac.tuwien.big.moea.search.algorithm.operator.mutation.PlaceholderMutation;
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm;
import at.ac.tuwien.big.moea.search.solution.generator.IInjectedPopulationGenerator;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationParameterMutation;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationVariableMutation;
import at.ac.tuwien.big.momot.search.solution.executor.SearchHelper;

public class EvolutionaryAlgorithmFactory<S extends Solution> extends AbstractAlgorithmFactory<S> {
	protected int populationSize = 100;
	protected List<S> initialSolutions = new ArrayList<>();
		
	public EvolutionaryAlgorithmFactory() { }
	
	public EvolutionaryAlgorithmFactory(ISearchOrchestration<S> searchOrchestration) {
		setSearchOrchestration(searchOrchestration);
	}
	
	public int getPopulationSize() {
		return populationSize;
	}
	
	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}
	
	public List<S> getInitialSolutions() {
		return initialSolutions;
	}
	
	public void setInitialSolutions(List<S> initialSolutions) {
		this.initialSolutions = initialSolutions;
	}
	
	public void addInitialSolution(S solution) {
		this.initialSolutions.add(solution);
	}
	
	protected Variation createVariation(Variation...variation) {
		return new CompoundVariation(variation);
	}
	
	protected Initialization createInitialization() {
		IInjectedPopulationGenerator<S> initialization = 
				getSearchOrchestration().createPopulationGenerator(getPopulationSize());
		initialization.addInjectedSolutions(getInitialSolutions());
		return initialization;
	}
	
	public IRegisteredAlgorithm<RandomSearch> createRandomSearch() {
		return new RegisteredAlgorithm<RandomSearch>() {
			@Override
			public RandomSearch createAlgorithm() {
				return new RandomSearch(
						createProblem(), 
						createInitialization(), 
						createPopulation());
			}
		};
	}
	
	public IRegisteredAlgorithm<NSGAII> createNSGAII() {
		return createNSGAII(
				new TournamentSelection(2), 
				new OnePointCrossover(1.0), 
				new PlaceholderMutation(0.10));
	}
	
	
	public IRegisteredAlgorithm<NSGAII> createNSGAII(final Selection selection, final Variation... variation) {
		return new RegisteredAlgorithm<NSGAII>() {
			@Override
			public NSGAII createAlgorithm() {
				return new NSGAII(createProblem(), 
						createSortingPopulation(), 
						createEpsilonBoxArchive(), 
						selection,
						createVariation(variation),
						createInitialization());
			}
		};
	}	
	
	/*public IRegisteredAlgorithm<NSGAII> createNSGAIII() {
		return createNSGAIII(4, 0, 
				new TournamentSelection(2), 
				new OnePointCrossover(1.0),
				new PlaceholderMutation(0.10));
	}*/
	
	/*public IRegisteredAlgorithm<NSGAII> createNSGAIII(SearchHelper helper, double deletePercentage, double mutationRate) {
		return createNSGAIII(4, 0, 
				new TournamentSelection(2), 
				new OnePointCrossover(1.0), 
				new PlaceholderMutation(deletePercentage*mutationRate),
				new TransformationVariableMutation(helper,(1.0-deletePercentage)*mutationRate*0.5),
				new TransformationParameterMutation(helper,(1.0-deletePercentage)*mutationRate*0.5));
	}*/
	
	public IRegisteredAlgorithm<NSGAII> createNSGAIII(final Selection selection, final Variation... variation) {
		return createNSGAIII(4, 0, selection, variation);
	}
	
	public IRegisteredAlgorithm<NSGAII> createNSGAIII(final int divisions, final Selection selection, final Variation... variation) {
		return createNSGAIII(divisions, 0, selection, variation);
	}
	
	public IRegisteredAlgorithm<NSGAII> createNSGAIII(final int divisionsOuter, final int divisionsInner, final Selection selection, final Variation... variation) {
		return new RegisteredAlgorithm<NSGAII>() {
			@Override
			public NSGAII createAlgorithm() {
				return new NSGAII(createProblem(), 
						new ReferencePointNondominatedSortingPopulation(
								getSearchOrchestration().getProblem().getNumberOfObjectives(),
								divisionsOuter, divisionsInner),
						createEpsilonBoxArchive(), 
						selection,
						createVariation(variation),
						createInitialization());
			}
		};
	}
	
	public IRegisteredAlgorithm<AdaptiveTimeContinuation> createENSGAII(final double injectionRate, final Selection selection, final Variation... variation) {
		return new RegisteredAlgorithm<AdaptiveTimeContinuation>() {
			@Override
			public AdaptiveTimeContinuation createAlgorithm() {
				return new AdaptiveTimeContinuation(
						createNSGAII(selection, variation).createAlgorithm(),
						100, 100, 1.0 / injectionRate,
						getPopulationSize(),
						getPopulationSize() * 10,
						new UniformSelection(),
						new UM(1.0));
			}
		};
	}
	
	public RegisteredAlgorithm<EpsilonMOEA> createEpsilonMOEA() {
		return createEpsilonMOEA(0.01, 
				new TournamentSelection(2), 
				new OnePointCrossover(1.0), 
				new PlaceholderMutation(0.10));
	}
	
	public RegisteredAlgorithm<EpsilonMOEA> createEpsilonMOEA(final double epsilon, final Selection selection, final Variation... variation) {
		return new RegisteredAlgorithm<EpsilonMOEA>() {
			@Override
			public EpsilonMOEA createAlgorithm() {
				return new EpsilonMOEA(createProblem(), 
						createPopulation(), 
						createEpsilonBoxArchive(epsilon), 
						selection, 
						createVariation(variation), 
						createInitialization());
			}
		};
	}
	
	public RegisteredAlgorithm<SPEA2> createSPEA2(final int numberOfOffspring, final Variation... variation) {
		return createSPEA2(numberOfOffspring, 1, variation);
	}
	
	public RegisteredAlgorithm<SPEA2> createSPEA2(final int numberOfOffspring, final int k, final Variation... variation) {
		return new RegisteredAlgorithm<SPEA2>() {
			@Override
			public SPEA2 createAlgorithm() {
				return new SPEA2(
						createProblem(), 
						createInitialization(),
						createVariation(variation), 
						numberOfOffspring, k);
			}				
		};
	}
	
	public RegisteredAlgorithm<PAES> createPAES(final int bisections, final int archiveSize, final Variation... variation) {
		return new RegisteredAlgorithm<PAES>() {
			@Override
			public PAES createAlgorithm() {
				return new PAES(
						createProblem(), 
						createVariation(variation), 
						bisections, archiveSize);
			}				
		};
	}
	
	public RegisteredAlgorithm<PESA2> createPESA2(final int bisections, final int archiveSize, final Variation... variation) {
		return new RegisteredAlgorithm<PESA2>() {
			@Override
			public PESA2 createAlgorithm() {
				return new PESA2(
						createProblem(), 
						createVariation(variation), 
						createInitialization(),
						bisections, archiveSize);
			}				
		};
	}
	
	public RegisteredAlgorithm<IBEA> createIBEA(final IndicatorFitnessEvaluator evaluator, final Variation... variation) {
		return new RegisteredAlgorithm<IBEA>() {
			@Override
			public IBEA createAlgorithm() {
				return new IBEA(
						createProblem(),
						createPopulation(),
						createInitialization(),
						createVariation(variation),
						evaluator);
			}				
		};
	}
	
	public RegisteredAlgorithm<SMSEMOA> createSMSEMOA(final FitnessEvaluator evaluator, final Variation... variation) {
		return new RegisteredAlgorithm<SMSEMOA>() {
			@Override
			public SMSEMOA createAlgorithm() {
				return new SMSEMOA(
						createProblem(),
						createInitialization(),
						createVariation(variation),
						evaluator);
			}				
		};
	}
	
	public RegisteredAlgorithm<VEGA> createVEGA(final Variation... variation) {
		return new RegisteredAlgorithm<VEGA>() {
			@Override
			public VEGA createAlgorithm() {
				return new VEGA(
						createProblem(),
						createPopulation(),
						createPopulation(),
						createInitialization(),
						createVariation(variation));
			}				
		};
	}
}
