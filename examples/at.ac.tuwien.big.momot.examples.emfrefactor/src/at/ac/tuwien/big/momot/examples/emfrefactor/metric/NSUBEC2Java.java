package at.ac.tuwien.big.momot.examples.emfrefactor.metric;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * Java alternative to the OCL implementation of {@link NSUBEC}.
 *
 * @author Martin Fleck
 */
public final class NSUBEC2Java implements IMetricCalculator {

   private List<EObject> context;

   @Override
   public double calculate() {
      final EObject contextObject = context.get(0);
      if(!(contextObject instanceof EClass)) {
         return 0.0;
      }

      final EClass eClass = (EClass) contextObject;
      double subClass = 0.0;
      for(final EClassifier classifier : eClass.getEPackage().getEClassifiers()) {
         if(classifier instanceof EClass && ((EClass) classifier).getESuperTypes().contains(eClass)) {
            subClass++;
         }
      }
      return subClass;
   }

   @Override
   public void setContext(final List<EObject> context) {
      this.context = context;
   }
}
