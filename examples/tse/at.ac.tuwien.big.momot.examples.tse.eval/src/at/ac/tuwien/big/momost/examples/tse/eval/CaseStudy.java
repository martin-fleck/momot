package at.ac.tuwien.big.momost.examples.tse.eval;

public class CaseStudy {
	public static final String BASE_DIR = "../at.ac.tuwien.big.momot.examples.tse.resources/casestudy/";
	// relative to  base case study directory
	public static final String HENSHIN_MODULE = "../../at.ac.tuwien.big.momot.examples.tse.momot/model/modularization_rules.henshin";
	
	public interface OCL2R2ML {
		public static final String MANUAL_SOLUTION = BASE_DIR + "OCL2R2ML/manual/OCL2R2ML/OCL2R2ML_Modularization_2_10_0.20556_0.15396_0.43888.xmi";
		public static final String OUTPUT_DIR = BASE_DIR + "OCL2R2ML/output/OCL2R2ML/momot/";
		public static final String NSGAIII_DIR = OUTPUT_DIR + "nsgaiii/";
		public static final String NSGAII_DIR = OUTPUT_DIR + "nsgaii/";
		public static final String RANDOM_DIR = OUTPUT_DIR + "random/";
		public static final String HILLCLIMBING_DIR = OUTPUT_DIR + "hillClimbing/";
	}
	
	public interface R2ML2XML {
		public static final String MANUAL_SOLUTION = BASE_DIR + "OCL2R2ML/manual/R2ML2XML/placeholder.xmi";
		public static final String OUTPUT_DIR = BASE_DIR + "OCL2R2ML/output/R2ML2XML/momot/";
		public static final String NSGAIII_DIR = OUTPUT_DIR + "nsgaiii/";
		public static final String NSGAII_DIR = OUTPUT_DIR + "nsgaii/";
		public static final String RANDOM_DIR = OUTPUT_DIR + "random/";
		public static final String HILLCLIMBING_DIR = OUTPUT_DIR + "hillClimbing/";
	}
	
	public interface RDM2R2ML {
		public static final String MANUAL_SOLUTION = BASE_DIR + "RDM2R2ML/manual/placeholder.xmi";
		public static final String OUTPUT_DIR = BASE_DIR + "RDM2R2ML/output/momot/";
		public static final String NSGAIII_DIR = OUTPUT_DIR + "nsgaiii/";
		public static final String NSGAII_DIR = OUTPUT_DIR + "nsgaii/";
		public static final String RANDOM_DIR = OUTPUT_DIR + "random/";
		public static final String HILLCLIMBING_DIR = OUTPUT_DIR + "hillClimbing/";
	}
	
	public interface XML2Ant {
		public static final String MANUAL_SOLUTION = BASE_DIR + "XML2Ant/manual/placeholder.xmi";
		public static final String OUTPUT_DIR = BASE_DIR + "XML2Ant/output/momot/";
		public static final String NSGAIII_DIR = OUTPUT_DIR + "nsgaiii/";
		public static final String NSGAII_DIR = OUTPUT_DIR + "nsgaii/";
		public static final String RANDOM_DIR = OUTPUT_DIR + "random/";
		public static final String HILLCLIMBING_DIR = OUTPUT_DIR + "hillClimbing/";
	}
	
	public interface XML2KML {
		public static final String MANUAL_SOLUTION = BASE_DIR + "XML2KML/manual/placeholder.xmi";
		public static final String OUTPUT_DIR = BASE_DIR + "XML2KML/output/momot/";
		public static final String NSGAIII_DIR = OUTPUT_DIR + "nsgaiii/";
		public static final String NSGAII_DIR = OUTPUT_DIR + "nsgaii/";
		public static final String RANDOM_DIR = OUTPUT_DIR + "random/";
		public static final String HILLCLIMBING_DIR = OUTPUT_DIR + "hillClimbing/";
	}
	
	public interface XML2MySQL {
		public static final String MANUAL_SOLUTION = BASE_DIR + "XML2MySQL/manual/XML2MySQL_Modularization_2_14_0.54167_0.xmi";
		public static final String OUTPUT_DIR = BASE_DIR + "XML2MySQL/output/momot/";
		public static final String NSGAIII_DIR = OUTPUT_DIR + "nsgaiii/";
		public static final String NSGAII_DIR = OUTPUT_DIR + "nsgaii/";
		public static final String RANDOM_DIR = OUTPUT_DIR + "random/";
		public static final String HILLCLIMBING_DIR = OUTPUT_DIR + "hillClimbing/";
	}
}
