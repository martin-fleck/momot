package icmt.tool.momot.demo;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import icmt.tool.momot.demo.architecture.Feature;

public class AssocNext {

   public static void assocNext(final EObject container) {
      final List<Feature> allFeatures = new ArrayList<>();
      container.eAllContents().forEachRemaining((con) -> {
         if(con instanceof Feature) {
            final Feature feat = (Feature) con;
            allFeatures.add(feat);
         }
      });
      for(int i = 0; i < allFeatures.size() - 1; ++i) {
         allFeatures.get(i).setNext(allFeatures.get(i + 1));
      }
   }

}
