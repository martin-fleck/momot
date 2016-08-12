package at.ac.tuwien.big.momot.examples.stack;

public interface StackModule {
   public static interface ConnectStacks {
      static interface Parameter {
         String LEFT = ConnectStacks.NAME + StackModule.SEPARATOR + "left";
         String RIGHT = ConnectStacks.NAME + StackModule.SEPARATOR + "right";
      }

      static String NAME = StackModule.MODULE + StackModule.SEPARATOR + "connectStacks";
   }

   public static interface CreateStack {
      static interface Parameter {
         String STACK_ID = CreateStack.NAME + StackModule.SEPARATOR + "stackId";
         String STACK_LOAD = CreateStack.NAME + StackModule.SEPARATOR + "stackLoad";
      }

      static String NAME = StackModule.MODULE + StackModule.SEPARATOR + "createStack";
   }

   public static interface ShiftLeft {
      static interface Parameter {
         String FROM_ID = ShiftLeft.NAME + StackModule.SEPARATOR + "fromId";
         String TO_ID = ShiftLeft.NAME + StackModule.SEPARATOR + "toId";
         String AMOUNT = ShiftLeft.NAME + StackModule.SEPARATOR + "amount";
         String FROM_LOAD = ShiftLeft.NAME + StackModule.SEPARATOR + "fromLoad";
         String TO_LOAD = ShiftLeft.NAME + StackModule.SEPARATOR + "toLoad";
      }

      static String NAME = StackModule.MODULE + StackModule.SEPARATOR + "shiftLeft";
   }

   public static interface ShiftRight {
      static interface Parameter {
         String FROM_ID = ShiftRight.NAME + StackModule.SEPARATOR + "fromId";
         String TO_ID = ShiftRight.NAME + StackModule.SEPARATOR + "toId";
         String AMOUNT = ShiftRight.NAME + StackModule.SEPARATOR + "amount";
         String FROM_LOAD = ShiftRight.NAME + StackModule.SEPARATOR + "fromLoad";
         String TO_LOAD = ShiftRight.NAME + StackModule.SEPARATOR + "toLoad";
      }

      static String NAME = StackModule.MODULE + StackModule.SEPARATOR + "shiftRight";
   }

   static String SEPARATOR = "::";

   static String FILE_NAME = "stack";

   static String MODULE_NAME = "Stack";

   static String MODULE = FILE_NAME + SEPARATOR + MODULE_NAME;

}
