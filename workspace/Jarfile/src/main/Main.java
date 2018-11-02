package main;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import at.ac.tuwien.big.momot.examples.refactoring.RefractoringCostDimension;
import at.ac.tuwien.big.momot.examples.refactoring.momot.Refactoring;
import at.ac.tuwien.big.momot.examples.refactoring.momot.Refactoring_A;
import at.ac.tuwien.big.momot.examples.refactoring.momot.Refactoring_A_multi;
import at.ac.tuwien.big.momot.examples.refactoring.momot.Refactoring_B;
import at.ac.tuwien.big.momot.examples.refactoring.momot.Refactoring_B_multi;
import icmt.tool.momot.demo.ArchitectureSearchWS_A;
import icmt.tool.momot.demo.ArchitectureSearchWS_A_Dual;
import icmt.tool.momot.demo.ArchitectureSearchWS_A_Dual_NB;
import icmt.tool.momot.demo.ArchitectureSearchWS_A_NB;
import icmt.tool.momot.demo.ArchitectureSearchWS_B;
import icmt.tool.momot.demo.ArchitectureSearchWS_B_Dual;
import icmt.tool.momot.demo.ArchitectureSearchWS_B_Dual_NB;
import icmt.tool.momot.demo.ArchitectureSearchWS_B_NB;
import icmt.tool.momot.demo.ArchitectureSearchWS_C;
import icmt.tool.momot.demo.ArchitectureSearchWS_C_Dual;
import icmt.tool.momot.demo.ArchitectureSearchWS_C_Dual_NB;
import icmt.tool.momot.demo.ArchitectureSearchWS_C_NB;
import icmt.tool.momot.demo.ArchitectureSearchWS_D;
import icmt.tool.momot.demo.ArchitectureSearchWS_D_Dual;
import icmt.tool.momot.demo.ArchitectureSearchWS_D_Dual_NB;
import icmt.tool.momot.demo.ArchitectureSearchWS_D_NB;
import icmt.tool.momot.demo.ArchitectureSearchWS_E;
import icmt.tool.momot.demo.ArchitectureSearchWS_E_Dual;
import icmt.tool.momot.demo.ArchitectureSearchWS_E_Dual_NB;
import icmt.tool.momot.demo.ArchitectureSearchWS_E_NB;

public class Main {

	public static void showHelp() {
		System.err.println(
				"Usage: java -jar <thisfile>.jar "
				+ " [--batchSize count] [--batchStart count] [refractormulti|refractor|cra|cranb|nrp|cradual|cradualnb] [a|b|c|d|e]\nScrum supports only A,B,D\nNRP supports only A,B");
	}
	
	static int batchStart = 1;
	static int batchSize = 30;
	
	public static void main(String[] args) {
		List<String> newArgsL = new ArrayList<>();
		for (int i = 0; i < args.length; ++i) {
			if ("--batchSize".equals(args[i])) {
				batchSize = Integer.valueOf(args[++i]);
			} else if ("--batchStart".equals(args[i])) {
				batchStart = Integer.valueOf(args[++i]);
			} else {
				newArgsL.add(args[i]);
			}
		}
		args = newArgsL.toArray(new String[]{}); 
		if (args.length != 2) {
			showHelp();
			return;
		}
		if ("all".equals(args[0])) {
			for (String arg0 : new String[] { "refractormulti", "refractor" , "cra","cranb", "nrp", "cradual","cradualnb" /*"scrum",*/ }) {
				String[] newArgs = Arrays.copyOf(args, args.length);
				newArgs[0] = arg0;
				main(newArgs);
			}
			return;
		}
		if ("all".equals(args[1])) {
			Map<String, String[]> exStr = new HashMap<>();
			exStr.put("cra", new String[] { "a", "b",  "c",  "d",  "e" });
			exStr.put("cradual", new String[] { "a", "b",  "c",  "d",  "e" });
			exStr.put("cranb", new String[] { "a", "b",  "c",  "d",  "e" });
			exStr.put("cradualnb", new String[] { "a", "b",  "c",  "d",  "e" });
			exStr.put("nrp", new String[] { "a",  "b"});
			exStr.put("scrum", new String[] { "a", "b"});
			exStr.put("refractor", new String[] { "a" /*, "b" */});
			exStr.put("refractormulti", new String[] { "a"/*, "b" */});
			for (String arg1 : exStr.get(args[0].toLowerCase())) {
				String[] newArgs = Arrays.copyOf(args, args.length);
				newArgs[1] = arg1;
				main(newArgs);
			}
			return;
		}
		File existingOutput = new File("output");
		if (existingOutput.exists()) {
			System.out.println("Exists!");
			try {
				Files.move(existingOutput.toPath(), new File("previousoutput-" + new Random().nextInt()).toPath());
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Can't move existing folder: " + e.getMessage());
				return;
			}
		}
		Date date = new Date();
		try {
			String type = args[0];
			String experiment = args[1];
			for (int i = batchStart; i < batchSize+batchStart; ++i) {
				Field f = Class.forName("at.ac.tuwien.big.moea.experiment.instrumenter.collector.EvolutionStepLogger").getField("startIndex");
				f.set(null,i-1);
				switch (type.toLowerCase()) {
				case "cra":
					switch (experiment.toLowerCase()) {
					case "a":
						ArchitectureSearchWS_A.main(args);
						break;
					case "b":
						ArchitectureSearchWS_B.main(args);
						break;
					case "c":
						ArchitectureSearchWS_C.main(args);
						break;
					case "d":
						ArchitectureSearchWS_D.main(args);
						break;
					case "e":
						ArchitectureSearchWS_E.main(args);
						break;
					default:
						showHelp();
						return;
					}
					break;
				case "cradual":
					switch (experiment.toLowerCase()) {
					case "a":
						ArchitectureSearchWS_A_Dual.main(args);
						break;
					case "b":
						ArchitectureSearchWS_B_Dual.main(args);
						break; 
					case "c":
						ArchitectureSearchWS_C_Dual.main(args);
						break;
					case "d":
						ArchitectureSearchWS_D_Dual.main(args);
						break;
					case "e":
						ArchitectureSearchWS_E_Dual.main(args);
						break;
					default:
						showHelp();
						return;
					}
					break;
				case "cranb":
					switch (experiment.toLowerCase()) {
					case "a":
						ArchitectureSearchWS_A_NB.main(args);
						break;
					case "b":
						ArchitectureSearchWS_B_NB.main(args);
						break;
					case "c":
						ArchitectureSearchWS_C_NB.main(args);
						break;
					case "d":
						ArchitectureSearchWS_D_NB.main(args);
						break;
					case "e":
						ArchitectureSearchWS_E_NB.main(args);
						break;
					default:
						showHelp();
						return;
					}
					break;
				case "cradualnb":
					switch (experiment.toLowerCase()) {
					case "a": 
						ArchitectureSearchWS_A_Dual_NB.main(args);
						break;
					case "b":
						ArchitectureSearchWS_B_Dual_NB.main(args);
						break;
					case "c":
						ArchitectureSearchWS_C_Dual_NB.main(args);
						break;
					case "d":
						ArchitectureSearchWS_D_Dual_NB.main(args);
						break;
					case "e":
						ArchitectureSearchWS_E_Dual_NB.main(args);
						break;
					default:
						showHelp();
						return;
					}
					break;
				case "nrp":
					switch (experiment.toLowerCase()) {
					case "a":
						icmt.tool.momot.demo.NextSearch_A.main(args);
						break;
					case "b":
						icmt.tool.momot.demo.NextSearch_B.main(args);
						break;
					default:
						showHelp();
						return;
					}
					break;
				case "scrum":
					switch (experiment.toLowerCase()) {
					case "a":
						icmt.tool.momot.demo.Scrum_A.main(args);
						break;
					case "b":
						icmt.tool.momot.demo.Scrum_B.main(args);
						break;
					default:
						showHelp();
						return;
					}
					break;
			case "refractor":
				switch (experiment.toLowerCase()) {
				case "a":
					Refactoring_A.main(args);
					break;
				case "b":
					Refactoring_B.main(args);
					break;
				default:
					showHelp();
					return;
				}
				break;
			case "refractormulti":
				switch (experiment.toLowerCase()) {
				case "a":
					Refactoring_A_multi.main(args);
					break;
				case "b":
					Refactoring_B_multi.main(args);
					break;
				default:
					showHelp();
					return;
				}
				break;
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
			String newName = "momot-" + sdf.format(date) + "-" + args[0] + "-" + args[1];
			System.out.println("Rename to " + newName);
			try {
				Files.move(existingOutput.toPath(), new File(newName).toPath());
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Can't move existing folder at the end!! " + e.getMessage());
				return;
			}
		}
	}
}
