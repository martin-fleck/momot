package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringPackage;

import java.io.File;
import java.util.Stack;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import emfmodeldistance.DistanceCalculator;

public class EMFCompareDistance extends DistanceCalculator {

   private static EMFCompareDistance INSTANCE;

   public static double calculateFitness(final EObject model) {
      return INSTANCE.calculateDistance(model);
   }

   public static void initWith(final File modelFile) {
      INSTANCE = new EMFCompareDistance(modelFile);
   }

   private EMFCompare ecomp;

   private double matches;

   private double differences;
   private double distance;

   public EMFCompareDistance(final File targetModel) {
      super(targetModel);
      try {
         this.ecomp = EMFCompare.builder().build();
      } catch(final Exception e) {
         e.printStackTrace();
      }
   }

   @Override
   protected double calculate(final EObject model) throws Exception {
      double emf_distance = 0.0;
      final IComparisonScope scope = new DefaultComparisonScope(this.targetModel, model, null);
      final Comparison comp = ecomp.compare(scope);
      matches = 0;
      differences = 0;
      // Really simple, let's see how good it is
      // Decrease severity the lower you go
      for(final Match m : comp.getMatches()) {
         ++matches;
         double curWeight = 1.0;
         final Stack<Stack<Match>> curMatches = new Stack();
         final Stack<Match> curmStack = new Stack<>();
         curmStack.addAll(m.getSubmatches());
         curMatches.add(curmStack);
         while(!curMatches.isEmpty()) {
            final Stack<Match> curStack = curMatches.peek();
            if(curStack.isEmpty()) {
               curMatches.pop();
               curWeight *= 2;
            } else {
               final Match curMatch = curStack.pop();
               if(curMatch.getLeft() != null && curMatch.getRight() != null) {
                  matches += curWeight;
               } else {
                  differences += curWeight;
               }
               // for (Diff diff : curMatch.getDifferences().size()) {
               // // DifferenceKind kind = diff.getKind();
               // differences += curWeight;
               // }
               differences += curWeight * curMatch.getDifferences().size();
               final Stack<Match> subStack = new Stack<>();
               subStack.addAll(curMatch.getSubmatches());
               curMatches.push(subStack);
               curWeight *= 0.5;
            }
         }
      }
      emf_distance = differences / (matches + differences);
      emf_distance = Math.pow(emf_distance, 2); // ... to decrease smaller parts??
      return emf_distance;
   }

   public double getDifferences() {
      return differences;
   }

   @Override
   public double getDistance() {
      return distance;
   }

   @Override
   protected EPackage getEPackageInstance() {
      return RefactoringPackage.eINSTANCE;
   }

   public double getMatches() {
      return matches;
   }

   @Override
   public String getReportLine() {
      return "Distance between '" + firstResourceName + "' and '" + secondResourceName + "' is " + distance + " ("
            + matches + "/" + differences + ")\n";
   }
}
