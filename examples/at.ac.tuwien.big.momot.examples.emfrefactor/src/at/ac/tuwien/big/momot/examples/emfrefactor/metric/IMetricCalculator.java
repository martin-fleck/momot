package at.ac.tuwien.big.momot.examples.emfrefactor.metric;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * This interface defines the Methods needed to calculate a metric.
 * All metric calculate classes must implement this interface.
 *
 * @author Pawel Stepien
 *
 *         Copied from EMF Refactor to avoid dependency for MOMoT Example.
 */
public interface IMetricCalculator {

   /**
    * Returns the result of the metric calculation on a given context element.
    *
    * @return metric result
    */
   double calculate();

   /**
    * Sets the context for the metric calculation.
    *
    * @param context
    */
   void setContext(List<EObject> context);

}
