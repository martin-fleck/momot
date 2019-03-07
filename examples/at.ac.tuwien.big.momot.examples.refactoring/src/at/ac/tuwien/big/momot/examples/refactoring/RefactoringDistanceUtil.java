package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Entity;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.Property;
import at.ac.tuwien.big.momot.examples.refactoring.refactoring.RefactoringModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import emfmodeldistance.DistanceUtil;

/**
 * Class automatically generated from analyzing Petrinet metamodel and the transformation rules.
 *
 * @author Eugene Syriani
 *
 */
class RefactoringDistanceUtil extends DistanceUtil {

   RefactoringDistanceUtil() {
      movableTypes = Collections.emptySet();
      positionTypes = Collections.emptySet();
      modifiableTypes = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("Place")));
      otherTypes = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("Transition")));
   }

   @Override
   public Object getId(final EObject object) {
      /**
       * If object has no attribute with setID(true),
       * then you have to make up one unique on your own.
       * Otherwise, just call super.
       */
      if(object instanceof Entity) {
         return ((Entity) object).getName();
      } else if(object instanceof Property) {
         return ((Property) object).getName();
      } else {
         return null;
      }
   }

   @Override
   public List<Object> getModifiableAttributes(final EObject object) {
      if(object instanceof Entity) {
         final Entity ent = (Entity) object;
         final List<Object> ret = new ArrayList<>();
         ret.addAll(ent.getOwnedAttribute());
         if(ent.getGeneralization() != null) {
            ret.add(ent.getGeneralization());
         }
         return ret;
      } else {
         return Collections.emptyList();
      }
   }

   @Override
   public List<EObject> getModifiableObjects(EObject root) {
      root = getRoot(root);
      return new ArrayList<>(((RefactoringModel) root).getEntities());
   }

   @Override
   public List<EObject> getMovableObjects(final EObject root) {
      if(root instanceof RefactoringModel) {
         final RefactoringModel rm = (RefactoringModel) root;
         final List<EObject> ret = new ArrayList<>(rm.getProperties());
         return ret;
      } else {
         System.err.println("Wrong root: " + root);
      }
      return Collections.emptyList();
   }

   @Override
   public List<EObject> getOtherObjects(EObject root) {
      root = getRoot(root);
      final RefactoringModel rm = (RefactoringModel) root;
      final List<EObject> ret = new ArrayList<>(((RefactoringModel) root).getTypes());
      ret.addAll(rm.getGeneralizations());
      return ret;
   }

   @Override
   public EObject getPosition(final EObject movable) {
      if(movable instanceof Property) {
         if(movable.eContainer() instanceof Entity) {
            return movable.eContainer();
         } else if(movable.eContainer() instanceof RefactoringModel) {
            for(final Entity ent : ((RefactoringModel) movable.eContainer()).getEntities()) {
               if(ent.getOwnedAttribute().contains(movable)) {
                  return ent;
               }
            }
            return null;
         } else {
            System.err.println("Uncontained " + movable + ": " + movable.eContainer());
            return null;
         }
      }
      return null;
   }

   @Override
   public List<EObject> getPositionNeighbors(final EObject position) {
      // Superclass wäre wohl präferiert, aber?
      final EObject root = getRoot(position);

      final List<EObject> ret = new ArrayList<>(((RefactoringModel) root).getEntities());
      ret.remove(position);
      return ret;
   }

   @Override
   public List<EObject> getPositionObjects(final EObject root) {
      return new ArrayList<>(((RefactoringModel) root).getEntities());
   }

   @Override
   public EObject getRoot(EObject o) {
      if(!(o instanceof RefactoringModel)) {
         o = EcoreUtil.getRootContainer(o);
      }
      return o;
   }
}
