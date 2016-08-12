package at.ac.tuwien.big.momot.examples.emfrefactor.metric;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

/**
 * Copied from EMF Refactor to avoid dependency for MOMoT Example.
 */
public class OCLManager {
   private static final OCL<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, Constraint, EClass, EObject> ocl = OCL
         .newInstance(EcoreEnvironmentFactory.INSTANCE);
   private static final OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();

   public static double evaluateOCLOnContextObject(final EObject contextObject, final String expression) {
      if(contextObject == null) {
         return 0.0;
      }
      try {
         helper.setContext(contextObject.eClass());
         final OCLExpression<EClassifier> query = helper.createQuery(expression);
         final Object oclResult = ocl.evaluate(contextObject, query);
         if(oclResult instanceof Integer) {
            return (Integer) oclResult;
         } else if(oclResult instanceof Double) {
            return (Double) oclResult;
         } else if(oclResult instanceof Long) {
            return (Long) oclResult;
         } else if(oclResult instanceof Float) {
            return (Float) oclResult;
         }
      } catch(final ParserException e) {
         e.printStackTrace();
      }

      return 0.0;
   }
}
