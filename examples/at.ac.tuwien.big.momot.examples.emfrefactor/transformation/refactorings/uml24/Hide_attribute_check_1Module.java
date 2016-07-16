public interface Hide_attribute_check_1Module {
   static String MODULE = "";
   static String SEPARATOR = "::";

   public static interface MainUnit {
      static String NAME = "mainUnit";
      static interface Parameter {
         String SELECTED_E_OBJECT = NAME + SEPARATOR + "selectedEObject";
      }
   }

   public static interface Check_isAttribute {
      static String NAME = "check_isAttribute";
      static interface Parameter {
         String PROP = NAME + SEPARATOR + "prop";
      }
   }

   public static interface Check_isNotPrivate {
      static String NAME = "check_isNotPrivate";
      static interface Parameter {
         String ATT = NAME + SEPARATOR + "att";
         String VIS = NAME + SEPARATOR + "vis";
      }
   }

   public static interface Check_hasType {
      static String NAME = "check_hasType";
      static interface Parameter {
         String ATT = NAME + SEPARATOR + "att";
      }
   }

}
