public interface Hide_attribute_executeModule {
   static String MODULE = "";
   static String SEPARATOR = "::";

   public static interface MainUnit {
      static String NAME = "mainUnit";
      static interface Parameter {
         String SELECTED_E_OBJECT = NAME + SEPARATOR + "selectedEObject";
      }
   }

   public static interface CountedGetter {
      static String NAME = "countedGetter";
      static interface Parameter {
         String SELECTED_E_OBJECT = NAME + SEPARATOR + "selectedEObject";
      }
   }

   public static interface IndepGetter {
      static String NAME = "indepGetter";
      static interface Parameter {
         String SELECTED_E_OBJECT = NAME + SEPARATOR + "selectedEObject";
      }
   }

   public static interface CountedSetter {
      static String NAME = "countedSetter";
      static interface Parameter {
         String SELECTED_E_OBJECT = NAME + SEPARATOR + "selectedEObject";
      }
   }

   public static interface IndepSetter {
      static String NAME = "indepSetter";
      static interface Parameter {
         String SELECTED_E_OBJECT = NAME + SEPARATOR + "selectedEObject";
      }
   }

   public static interface Change_visibility {
      static String NAME = "change_visibility";
      static interface Parameter {
         String ATT = NAME + SEPARATOR + "att";
      }
   }

   public static interface Create_getter {
      static String NAME = "create_getter";
      static interface Parameter {
         String ATT = NAME + SEPARATOR + "att";
         String ATTNAME = NAME + SEPARATOR + "attname";
         String OPNAME = NAME + SEPARATOR + "opname";
      }
   }

   public static interface Create_setter {
      static String NAME = "create_setter";
      static interface Parameter {
         String ATT = NAME + SEPARATOR + "att";
         String ATTNAME = NAME + SEPARATOR + "attname";
         String OPNAME = NAME + SEPARATOR + "opname";
      }
   }

}
