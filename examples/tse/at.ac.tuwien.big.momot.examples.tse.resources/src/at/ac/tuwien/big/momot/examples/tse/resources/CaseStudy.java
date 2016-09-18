package at.ac.tuwien.big.momot.examples.tse.resources;

public class CaseStudy {
	public interface OCL2R2ML {
		public static final String INPUT_MM = "casestudy/OCL2R2ML/metamodels/OCL/OCL.ecore";
		public static final String OUTPUT_MM = "casestudy/OCL2R2ML/metamodels/r2ml/r2ml.ecore";
		public static final String ATL_TRANSFORMATION = "casestudy/OCL2R2ML/transformations/OCL2R2ML/OCL2R2ML.atl";
	}
	
	public interface R2ML2XML {
		public static final String INPUT_MM = "casestudy/OCL2R2ML/metamodels/r2ml/r2ml.ecore";
		public static final String OUTPUT_MM = "casestudy/OCL2R2ML/metamodels/OCL/OCL.ecore";
		public static final String ATL_TRANSFORMATION = "casestudy/OCL2R2ML/transformations/R2ML2XML/R2ML2XML.atl";
	}
	
	public interface RDM2R2ML {
		public static final String INPUT_MM = "casestudy/RDM2R2ML/metamodels/rdm.ecore";
		public static final String OUTPUT_MM = "casestudy/RDM2R2ML/metamodels/r2ml.ecore";
		public static final String ATL_TRANSFORMATION = "casestudy/RDM2R2ML/transformation/RDM2R2ML.atl";
	}
	
	public interface R2ML2RDM {
		public static final String INPUT_MM = "casestudy/R2ML2RDM/metamodels/r2ml.ecore";
		public static final String OUTPUT_MM = "casestudy/R2ML2RDM/metamodels/rdm.ecore";
		public static final String ATL_TRANSFORMATION = "casestudy/R2ML2RDM/transformation/R2ML2RDM.atl";
	}
	
	public interface XML2Ant {
		public static final String INPUT_MM = "casestudy/XML2Ant/metamodels/XML.ecore";
		public static final String OUTPUT_MM = "casestudy/XML2Ant/metamodels/Ant.ecore";
		public static final String ATL_TRANSFORMATION = "casestudy/XML2Ant/transformation/XML2Ant.atl";
	}
	
	public interface XML2KML {
		public static final String INPUT_MM = "casestudy/XML2KML/metamodels/XML.ecore";
		public static final String OUTPUT_MM = "casestudy/XML2KML/metamodels/KML.ecore";
		public static final String ATL_TRANSFORMATION = "casestudy/XML2KML/transformation/XML2KML.atl";
	}
	
	public interface XML2MySQL {
		public static final String INPUT_MM = "casestudy/XML2MySQL/metamodels/XML.ecore";
		public static final String OUTPUT_MM = "casestudy/XML2MySQL/metamodels/MySQL.ecore";
		public static final String ATL_TRANSFORMATION = "casestudy/XML2MySQL/transformation/XML2MySQL.atl";
	}
	
	public interface JavaMethods2UMLActivityDiagram {
		public static final String INPUT_MM = "casestudy/JavaMethods2UMLActivityDiagram/metamodels/XML.ecore";
		public static final String OUTPUT_MM = "casestudy/JavaMethods2UMLActivityDiagram/metamodels/MySQL.ecore";
		public static final String ATL_TRANSFORMATION = "casestudy/JavaMethods2UMLActivityDiagram/transformation/JavaMethods2UMLActivityDiagram_Mini.atl";
	}
	
	public interface Ecore2Maude {
		public static final String INPUT_MM = "casestudy/Ecore2Maude/metamodels/Ecore.ecore";
		public static final String OUTPUT_MM = "casestudy/Ecore2Maude/metamodels/Maude.ecore";
		public static final String ATL_TRANSFORMATION = "...";
	}	
	
	public interface XHTML2XML {
		public static final String INPUT_MM = "casestudy/XHTML2XML/metamodels/XHTML.ecore";
		public static final String OUTPUT_MM = "casestudy/XHTML2XML/metamodels/XML.ecore";
		public static final String ATL_TRANSFORMATION = "...";
	}
	
//	public interface Java2UML {
//		public static final String INPUT_MM = "casestudy/Java2UML/metamodels/java.ecore";
//		public static final String OUTPUT_MM = "casestudy/Java2UML/metamodels/UML.ecore";
//		public static final String ATL_TRANSFORMATION = "casestudy/Java2UML/transformations/Java2UML/Java2UML.atl";
//	}
//	
//	public interface Java2UMLHelpers {
//		public static final String INPUT_MM = "casestudy/Java2UML/metamodels/java.ecore";
//		public static final String OUTPUT_MM = "casestudy/Java2UML/metamodels/UML.ecore";
//		public static final String ATL_TRANSFORMATION = "casestudy/Java2UML/transformations/Java2UML/Java2UMLHelpers.atl";
//	}
//	
//	public interface CodeModel2UMLProfile {
//		public static final String INPUT_MM = "casestudy/Java2UML/metamodels/java.ecore";
//		public static final String OUTPUT_MM = "casestudy/Java2UML/metamodels/UML.ecore";
//		public static final String ATL_TRANSFORMATION = "casestudy/Java2UML/transformations/CodeModel2UMLProfile/CodeModel2UMLProfile.atl";
//	}
//	
//	public interface CodeModel2UMLClassesDiagram {
//		public static final String INPUT_MM = "casestudy/Java2UML/metamodels/java.ecore";
//		public static final String OUTPUT_MM = "casestudy/Java2UML/metamodels/UML.ecore";
//		public static final String ATL_TRANSFORMATION = "casestudy/Java2UML/transformations/CodeModel2UMLClassesDiagram/CodeModel2UMLClassesDiagram.atl";
//	}
}
