package at.ac.tuwien.big.momot.examples.refactoring;

public interface RefactoringModule {
   public static interface CreateRootClass {
      static interface Parameter {
         String N = CreateRootClass.NAME + RefactoringModule.SEPARATOR + "n";
         String E1 = CreateRootClass.NAME + RefactoringModule.SEPARATOR + "e1";
         String E2 = CreateRootClass.NAME + RefactoringModule.SEPARATOR + "e2";
      }

      static String NAME = RefactoringModule.MODULE + RefactoringModule.SEPARATOR + "createRootClass";
   }

   public static interface ExtractSuperClass {
      static interface Parameter {
         String N = ExtractSuperClass.NAME + RefactoringModule.SEPARATOR + "n";
         String E1 = ExtractSuperClass.NAME + RefactoringModule.SEPARATOR + "e1";
         String E2 = ExtractSuperClass.NAME + RefactoringModule.SEPARATOR + "e2";
      }

      static String NAME = RefactoringModule.MODULE + RefactoringModule.SEPARATOR + "extractSuperClass";
   }

   public static interface PullUpAttribute {
      static interface Parameter {
         String E = PullUpAttribute.NAME + RefactoringModule.SEPARATOR + "e";
         String N = PullUpAttribute.NAME + RefactoringModule.SEPARATOR + "n";
      }

      static String NAME = RefactoringModule.MODULE + RefactoringModule.SEPARATOR + "pullUpAttribute";
   }

   static String SEPARATOR = "::";

   static String FILE_NAME = "Refactoring";

   static String MODULE_NAME = "";

   static String MODULE = FILE_NAME;

}
