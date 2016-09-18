package at.ac.tuwien.big.momot.examples.tse.momot.console;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import at.ac.tuwien.big.momot.examples.tse.momot.MOMoTSearch;
import at.ac.tuwien.big.momot.examples.tse.momot.MOMoTSearchAll;
import at.ac.tuwien.big.momot.examples.tse.momot.util.ModularizationUtil;

public class Modularize {

	protected static Options options;
	
	@SuppressWarnings("static-access")
	protected static Options getOptions() {
		if(options == null) {
			Option outputDir = OptionBuilder
					.withArgName("directory")
					.hasArg()
					.withDescription("base output directory")
					.withLongOpt("output-directory")
					.withType(String.class)
					.isRequired()
					.create("o");
			
			Option transformation = OptionBuilder
					.withArgName("file")
					.hasArg()
					.withDescription("input model")
					.withLongOpt("input-model")
					.withType(String.class)
					.isRequired()
					.create("i");
			
			Option referenceFile = OptionBuilder
					.withArgName("file")
					.hasArg()
					.withDescription("reference file")
					.withLongOpt("reference-file")
					.withType(String.class)
					.create("r");
			
			Option populationSize = OptionBuilder
				.withArgName("number")
				.hasArg()
				.withDescription("Population size. Default: 100")
				.withLongOpt("population-size")
				.withType(Integer.class)
				.create("ps");
			
			Option nrIterations = OptionBuilder
				.withArgName("number")
				.hasArg()
				.withDescription("Number of iterations. Default: 100")
				.withLongOpt("nr-iterations")
				.withType(Integer.class)
				.create("ni");
			
			Option nrRuns = OptionBuilder
				.withArgName("number")
				.hasArg()
				.withDescription("Number of algorithm runs. Default: 30")
				.withLongOpt("nr-runs")
				.withType(Integer.class)
				.create("nr");
			
			Option mutProb = OptionBuilder
				.withArgName("number")
				.hasArg()
				.withDescription("Mutation Probability. Default: 0.05")
				.withLongOpt("mutation-probability")
				.withType(Double.class)
				.create("mutprob");
			
			Option emoeaEps = OptionBuilder
					.withArgName("number")
					.hasArg()
					.withDescription("eMOEA epsilon parameter. Default: 0.01")
					.withLongOpt("emoea-epsilon")
					.withType(Double.class)
					.create("emoeaeps");
			
			Option spea2Offspring = OptionBuilder
					.withArgName("number")
					.hasArg()
					.withDescription("SPEA2 offspring parameter. Default: 5")
					.withType(Integer.class)
					.create("spea2offspring");
			
			Option significance = OptionBuilder
					.withArgName("number")
					.hasArg()
					.withDescription("Analysis significance. Default: 0.01")
					.withType(Integer.class)
					.create("significance");
			
			Option moduleByModule = new Option("m", "module-by-module", false, "Use module-by-module search. Default: all-modules");
			
			options = new Options();
			options.addOption(transformation);
			options.addOption(outputDir);
			options.addOption(referenceFile);
			options.addOption(populationSize);
			options.addOption(nrIterations);
			options.addOption(nrRuns);
			options.addOption(moduleByModule);
			options.addOption(mutProb);
			options.addOption(emoeaEps);
			options.addOption(spea2Offspring);
			options.addOption(significance);
			options.addOption(new Option("nsgaiii", "NSGA-III", false, "Use NSGA-III algorithm"));
			options.addOption(new Option("spea2", "SPEA2", false, "Use SPEA2 algorithm"));
			options.addOption(new Option("random", "RandomSearch", false, "Use Random Search"));
			options.addOption(new Option("emoea", "eMOEA", false, "Use eMOEA algorithm"));
		}
		return options;
	}
	
	
	public static void main(String[] args) {
		ModularizationUtil.initStandalone();
		
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(getOptions(), args);
			
			String inputModel = null;
			String outputDir = null;
			String referenceFile = null;
			Integer populationSize = 100;
			Integer nrIterations = 100;
			Integer nrRuns = 30;
			Double mutationProbability = 0.05;
			Double eMoeaEpsilon = 0.01;
			Integer spea2Offspring = 5;
			Double significance = 0.01;
			
			if(cmd.hasOption("i")) 
				inputModel = cmd.getOptionValue("i", null);
			
			if(cmd.hasOption("o")) 
				outputDir = cmd.getOptionValue("o", null);
			
			if(cmd.hasOption("r")) 
				referenceFile = cmd.getOptionValue("r", null);
			
			if(cmd.hasOption("ps")) 
				populationSize = Integer.parseInt(cmd.getOptionValue("ps", "100"));
			
			if(cmd.hasOption("ni")) 
				nrIterations = Integer.parseInt(cmd.getOptionValue("ni", "100"));
			
			if(cmd.hasOption("nr")) 
				nrRuns = Integer.parseInt(cmd.getOptionValue("nr", "30"));
			
			if(cmd.hasOption("mutprob")) 
				mutationProbability = Double.parseDouble(cmd.getOptionValue("mutprob", "0.05"));
			
			if(cmd.hasOption("emoeaeps")) 
				eMoeaEpsilon = Double.parseDouble(cmd.getOptionValue("emoeaeps", "0.01"));
			
			if(cmd.hasOption("spea2offspring")) 
				spea2Offspring = Integer.parseInt(cmd.getOptionValue("spea2offspring", "5"));
			
			if(cmd.hasOption("significance")) 
				significance = Double.parseDouble(cmd.getOptionValue("significance", "0.01"));
			
			if(!outputDir.endsWith("/"))
				outputDir = outputDir + "/";
			
			if(cmd.hasOption("m")) {
				System.out.println("Execute a module-by-module search:");
				MOMoTSearch.executeCaseStudy(
						inputModel, referenceFile, outputDir, 
						populationSize, nrIterations, nrRuns);
			} else {
				System.out.println("Execute an all-modules search:");
				MOMoTSearchAll.executeCaseStudy(
						inputModel, referenceFile, outputDir, 
						populationSize, nrIterations, nrRuns,
						mutationProbability,
						cmd.hasOption("spea2"), cmd.hasOption("nsgaiii"), cmd.hasOption("emoea"), cmd.hasOption("random"),
						eMoeaEpsilon, spea2Offspring,
						significance);
			}			
		} catch (ParseException e) {
			System.err.println("Parsing failed. Reason: " + e.getMessage());
			
			// automatically generate the help statement
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("modularize", getOptions(), true);
		}
	}
}
