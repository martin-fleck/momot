package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.moea.problem.solution.variable.IPlaceholderVariable;
import at.ac.tuwien.big.moea.search.fitness.dimension.AbstractFitnessDimension;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.problem.solution.variable.IRuleApplicationVariable;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;
import at.ac.tuwien.big.momot.problem.solution.variable.UnitApplicationVariable;

import java.util.List;

import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;

public class RefractoringCostDimension extends AbstractFitnessDimension<TransformationSolution> {

   public RefractoringCostDimension() {
      super(TransformationSolution.class, "RefractoringCost", FunctionType.Minimum);
   }

   @Override
   public double evaluate(final TransformationSolution solution) {
      final int numVars = solution.getNumberOfVariables();
      double ret = 0.0;
      for(int i = 0; i < numVars; ++i) {
         final ITransformationVariable variable = solution.getVariable(i);
         if(variable == null || variable instanceof IPlaceholderVariable) {
            continue;
         }
         if(variable instanceof IRuleApplicationVariable) {

            final IRuleApplicationVariable ira = (IRuleApplicationVariable) variable;
            final Rule rule = ira.getRule();
            final String rn = rule.getName();
            System.err.println("Unknown: " + rn);
            if("createRuleClass".equals(rn)) {
               final double cost = 5.0; // For creating the class
               final Match match = ira.getCompleteMatch();
               ret += cost;
            } else if("extractSuperClass".equals(rn)) {
               final double cost = 5.0; // For creating the class
               final Match match = ira.getCompleteMatch();
               ret += cost;
            } else if("pullUpAttribute".equals(rn)) {
               final double cost = 5.0; // For creating the class
               final Match match = ira.getCompleteMatch();
               ret += cost;
            }
         } else if(variable instanceof UnitApplicationVariable) {
            final UnitApplicationVariable ira = (UnitApplicationVariable) variable;
            final Unit rule = ira.getUnit();
            final List<RuleApplication> appliedRules = ira.getAppliedRules();
            for(final RuleApplication ra : appliedRules) {
               final String rn = ra.getRule().getName();
               final Match match = ra.getCompleteMatch();
               if("createRootClass".equals(rn)) {
                  double cost = 1.0 + 2.0; // For creating the class
                  // final Match match = ira.getCompleteMatch();
                  final int multiMatchSize = match.getMultiMatches(ra.getRule().getMultiRules().get(0)).size();
                  System.out.println("CRC MultiMatchSize: " + multiMatchSize);
                  cost += multiMatchSize * 2; // 2* because a new generalisation is added
                  ret += cost;
               } else if("extractSuperClass".equals(rn)) {
                  double cost = 1.0 + 2.0; // For creating the class + the general effect
                  // final Match match = ira.getCompleteMatch();
                  final int multiMatchSize = match.getMultiMatches(ra.getRule().getMultiRules().get(0)).size();
                  System.out.println("SC MultiMatchSize: " + multiMatchSize);
                  cost += multiMatchSize * 2; // 2* because a new generalisation is added
                  ret += cost;
               } else if("pullUpAttribute".equals(rn)) {
                  double cost = 1.0; // Only consider attributes
                  // final Match match = ira.getCompleteMatch();
                  // TODO: ???
                  final int multiMatchSize = match.getMultiMatches(ra.getRule().getMultiRules().get(0)).size();
                  System.out.println("MultiMatchSize: " + multiMatchSize);
                  cost += multiMatchSize * 1;
                  ret += cost;

               } else {
                  System.err.println("Unknown: " + rn);
               }
            }
         }
      }
      return ret;
   }
}
