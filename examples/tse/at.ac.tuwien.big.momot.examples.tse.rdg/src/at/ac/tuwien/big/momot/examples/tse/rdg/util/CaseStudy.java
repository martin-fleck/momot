package at.ac.tuwien.big.momot.examples.tse.rdg.util;

public class CaseStudy {
	public static final String BASE_DIR = "../at.ac.tuwien.big.momot.examples.tse.resources/casestudy/";
	// relative to  base case study directory
	public static final String HENSHIN_MODULE = "../../at.ac.tuwien.big.momot.examples.tse.momot/model/modularization_rules.henshin";
	
	public interface OCL2R2ML {
		public static final String MODEL = "OCL2R2ML/transformations/OCL2R2ML/OCL2R2ML_Modularization.xmi";
		public static final String TYPES = "OCL2R2ML/transformations/OCL2R2ML/OCL2R2ML_Types.xmi";
		public static final String REFERENCE_DIR = "OCL2R2ML/reference/";
		public static final String REFERENCE_FILE = "OCL2R2ML/reference/OCL2R2ML_Modularization_rdg.csv";
		public static final String OUTPUT_DIR = "OCL2R2ML/output/OCL2R2ML/rdg/";
	}
	
	public interface R2ML2XML {
		public static final String MODEL = "OCL2R2ML/transformations/R2ML2XML/R2ML2XML_Modularization.xmi";
		public static final String TYPES = "OCL2R2ML/transformations/R2ML2XML/R2ML2XML_Types.xmi";
		public static final String REFERENCE_DIR = "OCL2R2ML/reference/";
		public static final String REFERENCE_FILE = "OCL2R2ML/reference/R2ML2XML_Modularization_rdg.csv";
		public static final String OUTPUT_DIR = "OCL2R2ML/output/R2ML2XML/rdg/";
	}
	
	public interface RDM2R2ML {
		public static final String MODEL = "RDM2R2ML/transformation/RDM2R2ML_Modularization.xmi";
		public static final String TYPES = "RDM2R2ML/transformation/RDM2R2ML_Types.xmi";
		public static final String REFERENCE_DIR = "RDM2R2ML/reference/";
		public static final String REFERENCE_FILE = "RDM2R2ML/reference/RDM2R2ML_Modularization_rdg.csv";
		public static final String OUTPUT_DIR = "RDM2R2ML/output/rdg/";
	}
	
	public interface XML2Ant {
		public static final String MODEL = "XML2Ant/transformation/XML2Ant_Modularization.xmi";
		public static final String TYPES = "XML2Ant/transformation/XML2Ant_Types.xmi";
		public static final String REFERENCE_DIR = "XML2Ant/reference/";
		public static final String REFERENCE_FILE = "XML2Ant/reference/XML2Ant_Modularization_rdg.csv";
		public static final String OUTPUT_DIR = "XML2Ant/output/rdg/";
	}
	
	public interface XML2KML {
		public static final String MODEL = "XML2KML/transformation/XML2KML_Modularization.xmi";
		public static final String TYPES = "XML2KML/transformation/XML2KML_Types.xmi";
		public static final String REFERENCE_DIR = "XML2KML/reference/";
		public static final String REFERENCE_FILE = "XML2KML/reference/XML2KML_Modularization_rdg.csv";
		public static final String OUTPUT_DIR = "XML2KML/output/rdg/";
	}
	
	public interface XML2MySQL {
		public static final String MODEL = "XML2MySQL/transformation/XML2MySQL_Modularization.xmi";
		public static final String TYPES = "XML2MySQL/transformation/XML2MySQL_Types.xmi";
		public static final String REFERENCE_DIR = "XML2MySQL/reference/";
		public static final String REFERENCE_FILE = "XML2MySQL/reference/XML2MySQL_Modularization_rdg.csv";
		public static final String OUTPUT_DIR = "XML2MySQL/output/rdg/";
	}
}
