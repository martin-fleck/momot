package at.ac.tuwien.big.momot.examples.stack;

public interface StackModule {
   static String SEPARATOR = "::";
   static String FILE_NAME = "stack";
   static String MODULE_NAME = "Stack";
   static String MODULE = FILE_NAME + SEPARATOR + MODULE_NAME;

   public static interface CreateStack {
      static String NAME = StackModule.MODULE + StackModule.SEPARATOR + "createStack";
      static interface Parameter {
         String STACK_ID = CreateStack.NAME + StackModule.SEPARATOR + "stackId";
         String STACK_LOAD = CreateStack.NAME + StackModule.SEPARATOR + "stackLoad";
      }
   }

   public static interface ShiftLeft {
      static String NAME = StackModule.MODULE + StackModule.SEPARATOR + "shiftLeft";
      static interface Parameter {
         String FROM_ID = ShiftLeft.NAME + StackModule.SEPARATOR + "fromId";
         String TO_ID = ShiftLeft.NAME + StackModule.SEPARATOR + "toId";
         String AMOUNT = ShiftLeft.NAME + StackModule.SEPARATOR + "amount";
         String FROM_LOAD = ShiftLeft.NAME + StackModule.SEPARATOR + "fromLoad";
         String TO_LOAD = ShiftLeft.NAME + StackModule.SEPARATOR + "toLoad";
      }
   }

   public static interface ConnectStacks {
      static String NAME = StackModule.MODULE + StackModule.SEPARATOR + "connectStacks";
      static interface Parameter {
         String LEFT = ConnectStacks.NAME + StackModule.SEPARATOR + "left";
         String RIGHT = ConnectStacks.NAME + StackModule.SEPARATOR + "right";
      }
   }

   public static interface ShiftRight {
      static String NAME = StackModule.MODULE + StackModule.SEPARATOR + "shiftRight";
      static interface Parameter {
         String FROM_ID = ShiftRight.NAME + StackModule.SEPARATOR + "fromId";
         String TO_ID = ShiftRight.NAME + StackModule.SEPARATOR + "toId";
         String AMOUNT = ShiftRight.NAME + StackModule.SEPARATOR + "amount";
         String FROM_LOAD = ShiftRight.NAME + StackModule.SEPARATOR + "fromLoad";
         String TO_LOAD = ShiftRight.NAME + StackModule.SEPARATOR + "toLoad";
      }
   }

}
