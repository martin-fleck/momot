package at.ac.tuwien.big.momot.examples.refactoring;

public interface RefactoringModule {
	   static String SEPARATOR = "::";
	   static String FILE_NAME = "Refactoring";
	   static String MODULE_NAME = "";
	   static String MODULE = FILE_NAME;

	   public static interface CreateRootClass {
	      static String NAME = RefactoringModule.MODULE + RefactoringModule.SEPARATOR + "createRootClass";
	      static interface Parameter {
	         String N = CreateRootClass.NAME + RefactoringModule.SEPARATOR + "n";
	         String E1 = CreateRootClass.NAME + RefactoringModule.SEPARATOR + "e1";
	         String E2 = CreateRootClass.NAME + RefactoringModule.SEPARATOR + "e2";
	      }
	   }

	   public static interface ExtractSuperClass {
	      static String NAME = RefactoringModule.MODULE + RefactoringModule.SEPARATOR + "extractSuperClass";
	      static interface Parameter {
	         String N = ExtractSuperClass.NAME + RefactoringModule.SEPARATOR + "n";
	         String E1 = ExtractSuperClass.NAME + RefactoringModule.SEPARATOR + "e1";
	         String E2 = ExtractSuperClass.NAME + RefactoringModule.SEPARATOR + "e2";
	      }
	   }

	   public static interface PullUpAttribute {
	      static String NAME = RefactoringModule.MODULE + RefactoringModule.SEPARATOR + "pullUpAttribute";
	      static interface Parameter {
	         String E = PullUpAttribute.NAME + RefactoringModule.SEPARATOR + "e";
	         String N = PullUpAttribute.NAME + RefactoringModule.SEPARATOR + "n";
	      }
	   }

}
