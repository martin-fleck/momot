package at.ac.tuwien.big.momot.examples.stack;

import at.ac.tuwien.big.createalg.CreateAlgorithm;
import at.ac.tuwien.big.createalg.ParameterSearch;
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension;
import at.ac.tuwien.big.moea.singleobjectivizer.LinearObjectivizerProvider;
import at.ac.tuwien.big.moea.util.MathUtil;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.examples.stack.stack.StackPackage;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.util.MomotUtil;

import com.google.common.base.Objects;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;



public class StackCreateAlgorithm extends CreateAlgorithm {

   public static final String INITIAL_MODEL = "";

   public static void main(final String[] args) {
	StackPackage.eINSTANCE.eClass();
      final StackCreateAlgorithm aca = new StackCreateAlgorithm();
      final ParameterSearch search = new ParameterSearch(aca, 0.25, 0.25, 0.25, 1, 0.0);
      search.initSearch();
      search.runAlgorithm();

   }

   public StackCreateAlgorithm() {
      super(new String[]{}, StackSearch.INPUT_MODEL, StackSearch.SOLUTION_LENGTH,
    		  StackSearch.POPULATION_SIZE, StackSearch.FAKE_REF, StackSearch.MAX_EVALUATIONS, new StackOrchestration(
    				  new LinearObjectivizerProvider(),
    				  StackSearch.INPUT_MODEL,
    				  StackSearch.SOLUTION_LENGTH));
   }
   @Override
   protected EObject adaptInputModel(final EObject root) {
      return root;
   }

   @Override
   protected void adaptResultModel(final EObject root) {
   }

   @Override
   protected IEGraphMultiDimensionalFitnessFunction createFitnessFunction() {
	   return search.getFitnessFunction();
   }

}
