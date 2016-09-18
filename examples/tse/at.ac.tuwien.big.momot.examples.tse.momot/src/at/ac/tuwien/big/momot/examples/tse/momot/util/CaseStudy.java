package at.ac.tuwien.big.momot.examples.tse.momot.util;

public class CaseStudy {
	public static final String BASE_DIR = "../at.ac.tuwien.big.momot.examples.tse.resources/casestudy/";
	// relative to  base case study directory
	public static final String HENSHIN_MODULE = "../../at.ac.tuwien.big.momot.examples.tse.momot/model/modularization_rules.henshin";
	
	public interface OCL2R2ML {
		public static final String MODEL = BASE_DIR + "OCL2R2ML/transformations/OCL2R2ML/OCL2R2ML_Modularization.xmi";
		public static final String REFERENCE_DIR = BASE_DIR + "OCL2R2ML/reference/";
		public static final String REFERENCE_FILE = BASE_DIR + "OCL2R2ML/reference/OCL2R2ML_Modularization_momot.csv";
		public static final String OUTPUT_DIR = BASE_DIR + "OCL2R2ML/output/OCL2R2ML/momot/";
	}
	
	public interface R2ML2XML {
		public static final String MODEL = BASE_DIR + "OCL2R2ML/transformations/R2ML2XML/R2ML2XML_Modularization.xmi";
		public static final String REFERENCE_DIR = BASE_DIR + "OCL2R2ML/reference/";
		public static final String REFERENCE_FILE = BASE_DIR + "OCL2R2ML/reference/R2ML2XML_Modularization_momot.csv";
		public static final String OUTPUT_DIR = BASE_DIR + "OCL2R2ML/output/R2ML2XML/momot/";
	}
	
	public interface RDM2R2ML {
		public static final String MODEL = BASE_DIR + "RDM2R2ML/transformation/RDM2R2ML_Modularization.xmi";
		public static final String REFERENCE_DIR = BASE_DIR + "RDM2R2ML/reference/";
		public static final String REFERENCE_FILE = BASE_DIR + "RDM2R2ML/reference/RDM2R2ML_Modularization_momot.csv";
		public static final String OUTPUT_DIR = BASE_DIR + "RDM2R2ML/output/momot/";
	}
	
	public interface XML2Ant {
		public static final String MODEL = BASE_DIR + "XML2Ant/transformation/XML2Ant_Modularization.xmi";
		public static final String REFERENCE_DIR = BASE_DIR + "XML2Ant/reference/";
		public static final String REFERENCE_FILE = BASE_DIR + "XML2Ant/reference/XML2Ant_Modularization_momot.csv";
		public static final String OUTPUT_DIR = BASE_DIR + "XML2Ant/output/momot/";
	}
	
	public interface XML2KML {
		public static final String MODEL = BASE_DIR + "XML2KML/transformation/XML2KML_Modularization.xmi";
		public static final String REFERENCE_DIR = BASE_DIR + "XML2KML/reference/";
		public static final String REFERENCE_FILE = BASE_DIR + "XML2KML/reference/XML2KML_Modularization_momot.csv";
		public static final String OUTPUT_DIR = BASE_DIR + "XML2KML/output/momot/";
	}
	
	public interface XML2MySQL {
		public static final String MODEL = BASE_DIR + "XML2MySQL/transformation/XML2MySQL_Modularization.xmi";
		public static final String REFERENCE_DIR = BASE_DIR + "XML2MySQL/reference/";
		public static final String REFERENCE_FILE = BASE_DIR + "XML2MySQL/reference/XML2MySQL_Modularization_momot.csv";
		public static final String OUTPUT_DIR = BASE_DIR + "XML2MySQL/output/momot/";
	}
	
	public interface JavaMethods2UMLActivityDiagram {
		public static final String MODEL = BASE_DIR + "JavaMethods2UMLActivityDiagram/transformation/JavaMethods2UMLActivityDiagram_Mini_Dependencies.xmi";
		public static final String REFERENCE_DIR = BASE_DIR + "JavaMethods2UMLActivityDiagram/reference/";
		public static final String REFERENCE_FILE = BASE_DIR + "JavaMethods2UMLActivityDiagram/reference/JavaMethods2UMLActivityDiagram_Modularization_momot.csv";
		public static final String OUTPUT_DIR = BASE_DIR + "JavaMethods2UMLActivityDiagram/output/momot/";
	}
	
	public interface Ecore2Maude {
		public static final String MODEL = BASE_DIR + "Ecore2Maude/transformation/Ecore2Maude_Modularized.xmi";
		public static final String REFERENCE_DIR = BASE_DIR + "Ecore2Maude/reference/";
		public static final String REFERENCE_FILE = BASE_DIR + "Ecore2Maude/reference/Ecore2Maude_Modularized_momot.csv";
		public static final String OUTPUT_DIR = BASE_DIR + "Ecore2Maude/output/momot/";
	}
	
	public interface XHTML2XML {
		public static final String MODEL = BASE_DIR + "XHTML2XML/transformation/XHTML2XML_Modularized.xmi";
		public static final String REFERENCE_DIR = BASE_DIR + "XHTML2XML/reference/";
		public static final String REFERENCE_FILE = BASE_DIR + "XHTML2XML/reference/XHTML2XML_Modularized_momot.csv";
		public static final String OUTPUT_DIR = BASE_DIR + "XHTML2XML/output/momot/";
	}
}
