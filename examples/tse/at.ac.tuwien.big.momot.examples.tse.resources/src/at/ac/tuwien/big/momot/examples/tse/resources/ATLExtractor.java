package at.ac.tuwien.big.momot.examples.tse.resources;

import java.io.IOException;

import org.eclipse.m2m.atl.core.ATLCoreException;

import at.ac.tuwien.big.momost.examples.tse.resources.types.ATL2TypesExtractor;
import at.ac.tuwien.big.momot.examples.tse.resources.modularization.ATL2ModularizationExtractor;

public class ATLExtractor {
	public static void extract(String atlFile, String inputMM, String outputMM) throws ATLCoreException, IOException {
		ATL2TypesExtractor.extract(atlFile, inputMM, outputMM);
		ATL2ModularizationExtractor.extract(atlFile, inputMM, outputMM);
	}
	
	public static void exractOCL2R2ML() throws ATLCoreException, IOException {
		extract(CaseStudy.OCL2R2ML.ATL_TRANSFORMATION,
				CaseStudy.OCL2R2ML.INPUT_MM,
				CaseStudy.OCL2R2ML.OUTPUT_MM);
	}
	
	public static void exractR2ML2XML() throws ATLCoreException, IOException {
		extract(CaseStudy.R2ML2XML.ATL_TRANSFORMATION,
				CaseStudy.R2ML2XML.INPUT_MM,
				CaseStudy.R2ML2XML.OUTPUT_MM);
	}
	
	public static void exractRDM2R2ML() throws ATLCoreException, IOException {
		extract(CaseStudy.RDM2R2ML.ATL_TRANSFORMATION,
				CaseStudy.RDM2R2ML.INPUT_MM,
				CaseStudy.RDM2R2ML.OUTPUT_MM);
	}
	
	public static void exractXML2Ant() throws ATLCoreException, IOException {
		extract(CaseStudy.XML2Ant.ATL_TRANSFORMATION,
				CaseStudy.XML2Ant.INPUT_MM,
				CaseStudy.XML2Ant.OUTPUT_MM);
	}
	
	public static void exractXML2KML() throws ATLCoreException, IOException {
		extract(CaseStudy.XML2KML.ATL_TRANSFORMATION,
				CaseStudy.XML2KML.INPUT_MM,
				CaseStudy.XML2KML.OUTPUT_MM);
	}
	
	public static void exractXML2MySQL() throws ATLCoreException, IOException {
		extract(CaseStudy.XML2MySQL.ATL_TRANSFORMATION,
				CaseStudy.XML2MySQL.INPUT_MM,
				CaseStudy.XML2MySQL.OUTPUT_MM);
	}
	
	public static void exractR2ML2RDM() throws ATLCoreException, IOException {
		extract(CaseStudy.R2ML2RDM.ATL_TRANSFORMATION,
				CaseStudy.R2ML2RDM.INPUT_MM,
				CaseStudy.R2ML2RDM.OUTPUT_MM);
	}
	
//	public static void exractJava2UML() throws ATLCoreException, IOException {
//		extract(CaseStudy.Java2UML.ATL_TRANSFORMATION,
//				CaseStudy.Java2UML.INPUT_MM,
//				CaseStudy.Java2UML.OUTPUT_MM);
//	}
//	
//	public static void exractJava2UMLHelpers() throws ATLCoreException, IOException {
//		extract(CaseStudy.Java2UMLHelpers.ATL_TRANSFORMATION,
//				CaseStudy.Java2UMLHelpers.INPUT_MM,
//				CaseStudy.Java2UMLHelpers.OUTPUT_MM);
//	}
//	
//	public static void exractCodeModel2UMLProfile() throws ATLCoreException, IOException {
//		extract(CaseStudy.CodeModel2UMLProfile.ATL_TRANSFORMATION,
//				CaseStudy.CodeModel2UMLProfile.INPUT_MM,
//				CaseStudy.CodeModel2UMLProfile.OUTPUT_MM);
//	}
//	
//	public static void exractCodeModel2UMLClassesDiagram() throws ATLCoreException, IOException {
//		extract(CaseStudy.CodeModel2UMLClassesDiagram.ATL_TRANSFORMATION,
//				CaseStudy.CodeModel2UMLClassesDiagram.INPUT_MM,
//				CaseStudy.CodeModel2UMLClassesDiagram.OUTPUT_MM);
//	}
	
	public static void main(String[] args) throws ATLCoreException, IOException {
		exractR2ML2RDM();
	}
}
