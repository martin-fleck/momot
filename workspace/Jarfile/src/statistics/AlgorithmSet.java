package statistics;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AlgorithmSet {

	public static int DIGIT_NUMBERS = 3;
	
	public static String NAN_SYMBOL = "?";
	public static String POSITIVE_INFINITY_SYMBOL = "$\\infty$";
	public static String NEGATIVE_INFINITY_SYMBOL = "$-\\infty$";
	
	public static String MAX_PREFIX = "\\textbf{";
	public static String MAX_SUFFIX = "}";
	
	public static String HEADER_PREFIX = "\\textbf{";
	public static String HEADER_SUFFIX = "}";
	
	public static Map<String,String> nameReplaceTable = new HashMap<>();
	static {
		nameReplaceTable.put("NSGAII", "NS2");
		nameReplaceTable.put("NSGAIII", "NS3");
		nameReplaceTable.put("NSGAII (NB)", "NS2 (NB)");
		nameReplaceTable.put("NSGAIII (NB)", "NS3 (NB)");
		nameReplaceTable.put("NSGAII_OM", "NS2O");
		nameReplaceTable.put("NSGAIII_OM", "NS3O");
		nameReplaceTable.put("NSGAII_OM (NB)", "NS2O (NB)");
		nameReplaceTable.put("NSGAIII_OM (NB)", "NS3O (NB)");
		nameReplaceTable.put("NSGAII_ORI", "NS2R");
		nameReplaceTable.put("NSGAIII_ORI", "NS3R");
		nameReplaceTable.put("NSGAII_ORI (NB)", "NS2R (NB)");
		nameReplaceTable.put("NSGAIII_ORI (NB)", "NS3R (NB)");
	}
	
	private List<AlgorithmSolutions> solutions = new ArrayList<>();
	
	private Map<AlgorithmSolutions, AlgorithmStatistics> statistics = new HashMap<>();
	
	public void addSolution(AlgorithmSolutions sol) {
		this.solutions.add(sol);
	}
	
	private String name;
	
	public AlgorithmSet(String name) {
		this.name = name;
	}
	
	public static AlgorithmSet readFromFolder(File folder) {
		String name = folder.getName().split("-",6)[5];
		AlgorithmSet ret = new AlgorithmSet(name);
		File total = folder.toPath().resolve("intermediatetotal").toFile();
		for (File file: total.listFiles()) {
			String problemName = file.getName();
			
			for (File sfile: file.listFiles()) {
				String algoName = sfile.getName();
				Algorithm algo = Algorithm.get(algoName);
				AlgorithmSolutions sol = new AlgorithmSolutions(algo);
				for (File steps: sfile.listFiles(new FilenameFilter() {
					
					@Override
					public boolean accept(File dir, String name) {
						return name.endsWith(".csv");
					}
				})) {
					SingleSolution ss = new SingleSolution();
					try {
						ss.readFrom(steps);
						sol.addSolution(ss);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ret.addSolution(sol);
			}
			
		}
		return ret;
	}
	
	public String header(String title, String sep) {
		StringBuilder ret = new StringBuilder(HEADER_PREFIX+title+HEADER_SUFFIX);
		
		for (Algorithm str: allAlgorithms().keySet()) {
			ret.append(sep);
			ret.append(HEADER_PREFIX+nameReplaceTable.getOrDefault(str.getName(),str.getName()).replace("_", "\\_")+HEADER_SUFFIX);
		}
		return ret.toString();
	}
	
	public TreeMap<Algorithm, AlgorithmSolutions> allAlgorithms() {
		TreeMap<Algorithm, AlgorithmSolutions> allAlgos = new TreeMap<>((x,y)->x.getName().compareTo(y.getName()));
		for (AlgorithmSolutions sol: solutions) {
			allAlgos.put(sol.getAlgorithm(),sol);
		}
		return allAlgos;
	}
	
	public String printDigits(List<Double> digitList, boolean wantMin, String sep) {
		double min = Double.POSITIVE_INFINITY;
		double max = Double.NEGATIVE_INFINITY;
		for (Double d: digitList) {
			min = Math.min(min, d);
			max = Math.max(max, d);
		}
		double fmax = wantMin?min:max;
		if (min == max) {
			//Don't do aynthing if everything equal
			fmax = Double.NaN;
		}
		StringBuilder ret = new StringBuilder();
		for (Double d: digitList) {
			ret.append(sep);
			ret.append(printDigit(d, fmax));
		}
		return ret.toString();
	}
	
	public String hyperVolumeLine(String title, String sep) {
		StringBuilder ret = new StringBuilder(HEADER_PREFIX+title+HEADER_SUFFIX);
		List<Double> digitList = new ArrayList<>();
		allAlgorithms().forEach((a,as)->{
			digitList.add(statistics.get(as).getHypervolumeAvg());
		});
		ret.append(printDigits(digitList, false, sep));
		return ret.toString();
	}
	
	public String igdLine(String title, String sep) {
		StringBuilder ret = new StringBuilder(title);
		List<Double> digitList = new ArrayList<>();
		allAlgorithms().forEach((a,as)->{
			digitList.add(statistics.get(as).getIGDAvg());
		});
		ret.append(printDigits(digitList, true, sep));
		return ret.toString();
	}
	
	public static String printDigit(double digit, double maxValue) {
		StringBuilder ret = new StringBuilder();
		boolean digitIsMax = digit==maxValue;
		if (digitIsMax) {
			ret.append(MAX_PREFIX);
		}
		if (!Double.isFinite(digit)) {
			if (Double.isNaN(digit)) {
				ret.append(NAN_SYMBOL);
			} else if (digit == Double.POSITIVE_INFINITY) {
				ret.append(POSITIVE_INFINITY_SYMBOL);
			} else if (digit == Double.NEGATIVE_INFINITY) {
				ret.append(NEGATIVE_INFINITY_SYMBOL);
			}
			if (digitIsMax) {
				ret.append(MAX_SUFFIX);
			}
			return ret.toString();
		}
		MathContext mc = new MathContext(DIGIT_NUMBERS);
		digit = new BigDecimal(digit).round(mc).doubleValue();
		
		if (digit < 0.0) {
			ret.append("-");
			digit = -digit;
		}
		String sret = String.valueOf(digit);
		if (sret.startsWith("0")) {
			sret = sret.substring(1);
		}
		String[] parts = sret.split("[eE]");
		String[] preParts = parts[0].split("\\.");
		if ("0".equals(preParts)) {
			if (preParts.length == 1) {
				//Exactly 0
				return "0";
			}
			sret = "."+preParts[1].substring(0,Math.min(preParts[1].length(), DIGIT_NUMBERS));
		} else {
			int komma = preParts[0].length();
			if (komma > DIGIT_NUMBERS) {
				if (komma > DIGIT_NUMBERS+2 || parts.length>1) {
					//Modify exponent
					int exponent = 0;
					if (parts.length>1) {
						exponent = Integer.valueOf(parts[1]);
					}
					int removeDigits = komma-DIGIT_NUMBERS;
					exponent+= removeDigits;
					parts = new String[]{parts[0].substring(0,DIGIT_NUMBERS), ""+exponent};
				}
				sret = parts[0];
			} else {
				int decimals = DIGIT_NUMBERS-preParts[0].length();
				if (decimals <= 0) {
					//Only pre
					sret = parts[0] = preParts[0];
				} else {
					sret = parts[0].substring(0,Math.min(parts[0].length(), DIGIT_NUMBERS+1));
				}
			}
		}
		
		ret.append(sret);
		if (parts.length>1){
			ret.append("e"+parts[1]);
		}
		if (digitIsMax) {
			ret.append(MAX_SUFFIX);
		}
		return ret.toString();
	}

	
	public void calculateStatistics() {
		//I don't know if that is correct
		List<SingleResult> allResults = new ArrayList<SingleResult>();
		for (AlgorithmSolutions sols: solutions) {
			allResults.addAll(sols.getAllSolutions());
		}
		SingleResult min = SingleResult.getMin(allResults);
		SingleResult max = SingleResult.getMax(allResults);
		allResults = SingleResult.getParetoSet(allResults);
		
		
		Map<AlgorithmSolutions, List<List<SingleResult>>> normalized = new HashMap<>();
		for (AlgorithmSolutions sol: solutions) {
			List<List<SingleResult>> results = new ArrayList<>();
			for (SingleSolution ss: sol.getSolutions()) {
				Collection<? extends SingleResult> allSolutions = ss.getSolutions();
				List<SingleResult> ret = new ArrayList<>();
				for (SingleResult s: allSolutions) {
					ret.add(s.normalized(min, max));
				}
				results.add(ret);
			}
			normalized.put(sol, results);
		}
		
		List<SingleResult> fallResults = allResults;
		
		Map<AlgorithmSolutions, AlgorithmStatistics> stats = this.statistics = new HashMap<>();
		normalized.forEach((k,cl)->{
			AlgorithmStatistics astats = new AlgorithmStatistics(k.getAlgorithm());
			stats.put(k, astats);
			for (List<SingleResult> v: cl) {
				List<SingleResult> inv1 = new ArrayList<>();
				for (SingleResult sr: v) {
					inv1.add(sr.inverted1());
				}
				double hypervolume = MOEAHypervolume.calculateHypervolume(inv1);
				double igd = MOEAIGD.evaluate(v, fallResults);
				astats.addHypervolume(hypervolume);
				astats.addIGD(igd);
			}
			
		});
	}
	
	public List<AlgorithmSolutions> getAlgorithmSolutions() {
		return this.solutions;
	}
	
	public Map<AlgorithmSolutions,AlgorithmStatistics> getStatisticsMap() {
		return this.statistics;
	}
	
	public String getStatisticsString() {
		StringBuilder ret = new StringBuilder();
		for (AlgorithmSolutions sol: solutions) {
			AlgorithmStatistics stat = statistics.get(sol);
			ret.append(sol.getAlgorithm().getName()+","+stat.getHypervolumeAvg()+","+stat.getIGDAvg()+"\n");
		}
		return ret.toString();
	}
	
	public void printStatistics() {
		System.out.println(getStatisticsString());
	}
	
	private boolean calculated = false;
	
	public void calculateIfNecessary() {
		if (!calculated) {
			calculated = true;
			calculateStatistics();
		}
	}
	
	public static String getHyperVolumeString(Collection<? extends AlgorithmSet> algos, String sep, String lineSep) {
		StringBuilder ret = new StringBuilder();
		Iterator<? extends AlgorithmSet> iter = algos.iterator();
		Set<Algorithm> lastAlgos = null;
		while (iter.hasNext()) {
			AlgorithmSet next = iter.next();
			Set<Algorithm> thisAlgos = new HashSet<>(next.allAlgorithms().keySet());
			boolean addHeader = false;
			if (lastAlgos == null || !lastAlgos.equals(thisAlgos)) {
				addHeader = true;
				lastAlgos = thisAlgos;
			}
			ret.append(next.getHypervolumeString(sep, lineSep, addHeader));
		}
		return ret.toString();
	}
	public static String getIGDString(Collection<? extends AlgorithmSet> algos, String sep, String lineSep) {
		StringBuilder ret = new StringBuilder();
		Iterator<? extends AlgorithmSet> iter = algos.iterator();
		Set<Algorithm> lastAlgos = null;
		while (iter.hasNext()) {
			AlgorithmSet next = iter.next();
			Set<Algorithm> thisAlgos = new HashSet<>(next.allAlgorithms().keySet());
			boolean addHeader = false;
			if (lastAlgos == null || !lastAlgos.equals(thisAlgos)) {
				addHeader = true;
				lastAlgos = thisAlgos;
			}
			ret.append(next.getIGDString(sep, lineSep, addHeader));
		}
		return ret.toString();
	}
	public String getHypervolumeString(String sep, String lineSep, boolean withHeader) {
		calculateIfNecessary();
		StringBuilder ret = new StringBuilder();
		if (withHeader) {
			ret.append(header("Hypervolume", sep)+lineSep);
		}
		ret.append(hyperVolumeLine(name, sep)+lineSep);
		return ret.toString();
	}
	public String getIGDString(String sep, String lineSep, boolean withHeader) {
		calculateIfNecessary();
		StringBuilder ret = new StringBuilder();
		if (withHeader) {
			ret.append(header("IGD", sep)+lineSep);
		}
		ret.append(igdLine(name, sep)+lineSep);
		return ret.toString();
	}
	
	public static List<AlgorithmSet> getMostRecent(File inFodler) {
		Map<String, File> files = new TreeMap<>();
		for (File file: inFodler.listFiles()) {
			String fn = file.getName();
			if (!file.isDirectory() || !fn.startsWith("momot-")) {
				continue;
			}
			String[] parts = fn.split("-",6);
			if (parts.length < 6) {
				continue;
			}
			String algoName = parts[5];
			files.merge(algoName, file, (old,newFile)->{
				if (old.lastModified() < newFile.lastModified()) {
					return newFile;
				} else {
					return old;
				}
			});
		}
		List<AlgorithmSet> ret = new ArrayList<AlgorithmSet>();
		for (Entry<String,File> entr: files.entrySet()) {
			ret.add(AlgorithmSet.readFromFolder(entr.getValue()));
		}
		return ret;
	}
	
	public String getName() {
		return name;
	}
	
	public static AlgorithmSet merge(List<AlgorithmSet> from, String name) {
		if (from.isEmpty()) {
			return null;
		}
		if (from.size() ==1) {
			return from.get(0);
		}
		if (name == null) {
			name = from.get(0).getName();
		}
		AlgorithmSet ret = new AlgorithmSet(name);
		from.forEach((as)->{
			
			as.getAlgorithmSolutions().forEach(ass->{
				ret.addSolution(ass);				
			});
		});
		return ret;
	}
	
	public static List<AlgorithmSet> regroup(List<AlgorithmSet> from, List<List<String>> regroupThings) {
		Map<String, List<AlgorithmSet>> mergeThings = new TreeMap<String, List<AlgorithmSet>>();
		Map<String,String[]> reName = new HashMap<>();
		for (List<String> list: regroupThings) {
			String first = list.get(0);
			for (int i = 0; i < list.size()-1; i+=2) {
				reName.put(list.get(i), new String[]{first,list.get(i+1)});
			}
		}
		for (AlgorithmSet as: from) {
			String name = as.getName();
			String[] spl = name.split("-",2);
			String[] reN = reName.get(spl[0]);
			String newName = (reN==null?spl[0]:reN[0])+(spl.length>1?("-"+spl[1]):"");
			String suffix = "";
			if (reN != null) {
				suffix = reN[1];
			}
			String fsuffix = suffix;
			//Add suffix
			as.getAlgorithmSolutions().forEach(x->{
				x.setAlgorithm(Algorithm.get(x.getAlgorithm().getName()+fsuffix));
			});
			mergeThings.computeIfAbsent(newName, x->new ArrayList<>()).add(as);
		}
		List<AlgorithmSet> ret = new ArrayList<AlgorithmSet>();
		mergeThings.forEach((k,v)->{
			ret.add(merge(v, k));
		});
		return ret;
	}
	
	public static void main(String[] args) {
		File file = new File(".");
		if (args.length>0) {
			file = new File(args[0]);
		}
		List<AlgorithmSet> currentSet = getMostRecent(file);
		currentSet = regroup(currentSet, Arrays.asList(Arrays.asList("cradual","","cradualnb"," (NB)"),
				Arrays.asList("cra","","cranb"," (NB)")));
		String hyperVolume = getHyperVolumeString(currentSet, " & ", " \\\\\n");
		System.out.println("Hypervolume:\n"+hyperVolume+"\n");
		String igd = getIGDString(currentSet, " & ", " \\\\\n");
		System.out.println("IGD:\n"+igd+"\n");
	}
}
