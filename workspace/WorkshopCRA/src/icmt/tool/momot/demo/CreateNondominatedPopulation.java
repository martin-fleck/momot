package icmt.tool.momot.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;


public class CreateNondominatedPopulation {
	
	public enum ExampleType {
		Architecture(1,1), NRP(0,2), Scrum(2,2);
		
		private ExampleType(int... countEach) {
			this.countEach = countEach;
		}
		
		private int[] countEach;
	}
	
	public static class Example implements Comparable<Example> {
		ExampleType type;
		String name;
		File file;
		Boolean current;
		int number;
		
		public Example(ExampleType type, String name, Boolean current, File file) {
			this.type = type;
			this.name = name;
			this.current = current;
			this.file = file;
		}
		
		public boolean equals(Object o) {
			return ((o instanceof Example)) && Objects.equals(((Example)o).name, name) && Objects.equals(type, ((Example)o).type)
					 && Objects.equals(current, ((Example)o).current) && Objects.equals(number, ((Example)o).number);
		}
		
		public int hashCode() {
			return Objects.hash(name,type,current,number);
		}

		@Override
		public int compareTo(Example o) {
			int ret = Integer.compare(type.ordinal(),o.type.ordinal());
			if (ret != 0) {
				return ret;
			}
			ret = name.compareTo(o.name);
			if (ret == 0) {
				ret = Integer.compare(number, o.number);
			}
			if (ret == 0) {
				ret = Boolean.compare(current, o.current);
			}
			return ret;
		}
		
		public String toString() { 
			return type+": "+name+", "+current+", "+number+" @"+file.getAbsolutePath();
		}
	}

	public static Example guessType(File path) {
		if (path == null) {
			return null;
		}
		String name = path.getName();
		if (name == null) {
			return null;
		}
		String[] spl = name.split("-");
		for (int i = 0; i < spl.length; ++i) {
			String s = spl[i];
			if ("scrum".equals(s.toLowerCase())) {
				return new Example(ExampleType.Scrum, spl[i+1], null, path);
			} else if ("cra".equals(s.toLowerCase())) {
				return new Example(ExampleType.Architecture, spl[i+1], null, path);
			} else if ("nrp".equals(s.toLowerCase())) {
				return new Example(ExampleType.NRP,spl[i+1], null, path);
			}
		}
		Example ret = guessType(path.getParentFile());
		if ("intermediatecurrent".equals(path.getName())) {
			ret.current =true;
		} else if ("intermediatetotal".equals(path.getName())) {
			ret.current = false;
		}
		if (!path.isDirectory()) {
			String[] spl2 = path.getName().split("_");
			if (path.getName().endsWith(".csv") && spl2.length>1) {
				ret.number = Integer.valueOf(spl2[1]);
			}
		}
		return ret;
	}
	
	
	public static void augmentNondominatedPopulations(File file, Example type, Map<Example, TreeMap<Long,NondominatedPopulation>> allExamples) throws IOException {
		if (type == null) {
			type = guessType(file.getAbsoluteFile());
		}
		type.file = file;
		List<String> things = Files.readAllLines(file.toPath());
		TreeMap<Long,NondominatedPopulation> ret = new TreeMap<>();
		for (String line: things) {
			if (line.trim().isEmpty()) continue;
			String[] spl = line.split("\\,");
			Long nanoSeconds = Long.valueOf(spl[0]);
			Integer evolutionIndex = Integer.valueOf(spl[1]);
			Integer evaluationNumb = Integer.valueOf(spl[2]);
			Integer popluationSize = Integer.valueOf(spl[3]);
			NondominatedPopulation pop = new NondominatedPopulation();
			ret.put(nanoSeconds, pop);
			int curIndex = 4;
			while (curIndex < spl.length) {
				int numThings = Integer.valueOf(spl[curIndex]);
				double[] v = new double[numThings];
				++curIndex;
				for (int j = 0; j < numThings; ++j) {
					v[j] = Double.valueOf(spl[curIndex]);
					++curIndex;
				}
				//Stupidly, I have not distinguished between the things
				int[] exactThings = type.type.countEach;
				if (numThings != exactThings[0]+exactThings[1]) {
					throw new RuntimeException("Invalid type: "+numThings+" VS "+exactThings[0]+"/"+exactThings[1]+" for "+file.getAbsolutePath());
				}
				Solution sol = new Solution(0, exactThings[1], exactThings[0]);
				for (int i = 0; i < exactThings[0]; ++i) {
					sol.setConstraint(i, v[i]);
				}
				for (int i = 0; i < exactThings[1]; ++i) {
					sol.setObjective(i, v[i+exactThings[0]]);
				}
				pop.add(sol);
			}
		}
		allExamples.put(type, ret);
	}
	
	
	public static Map<Example, TreeMap<Long, NondominatedPopulation>> getAllPopulations(File resultFolder) throws IOException {
		Map<Example, TreeMap<Long, NondominatedPopulation>> pop = new TreeMap<CreateNondominatedPopulation.Example, TreeMap<Long,NondominatedPopulation>>();
		getAllPopulations(resultFolder, pop);
		return pop;
	}
			
	public static void getAllPopulations(File resultFolder, Map<Example, TreeMap<Long, NondominatedPopulation>> pop) throws IOException {
		if (!resultFolder.isDirectory()) {
			if (resultFolder.getName().endsWith(".csv")) {
				try {
				augmentNondominatedPopulations(resultFolder, null, pop);
				} catch  (Exception e) {
					e.printStackTrace();
					System.err.println("Error in file: "+resultFolder.getAbsolutePath()+": "+e.getMessage());
				}
			}
		} else {
			for (File file: resultFolder.listFiles()) {
				getAllPopulations(file, pop);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			args = new String[]{"E:\\jartest\\collected"};
		}
		File file = new File(args[0]);
		Map<Example, TreeMap<Long, NondominatedPopulation>> pop = getAllPopulations(file);
		pop.forEach((ex,map)->{
			System.out.println("Example: "+ex);
			map.forEach((time,sp)->{
				System.out.println("At "+time+" ns: ");
				for (Solution sol: sp) {
					System.out.println("\tSolution: "+Arrays.toString(sol.getConstraints())+" - "+Arrays.toString(sol.getObjectives()));
				}
			});
		});
	}
}
