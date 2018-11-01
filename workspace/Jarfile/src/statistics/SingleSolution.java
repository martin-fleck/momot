package statistics;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SingleSolution {
	
	private String name;
	private Algorithm algorithm;
	private long time;
	private int iterNmb;
	private int fitnessCount;
	private int solutionNumb;
	private int parameterCount;
	private List<SingleResult> solutions = new ArrayList<>();
	
	public void readFrom(File file) throws IOException {
		List<String> lines = Files.readAllLines(file.toPath());
		String[] lastArr = null;
		for (String line: lines) {
			String[] newArr = line.split(",");
			if (newArr.length<3){
				continue;
			}
			lastArr = newArr;			
		}
		if (lastArr == null) {return;}
		this.time = Long.valueOf(lastArr[0]);
		this.iterNmb = Integer.valueOf(lastArr[1]);
		this.fitnessCount = Integer.valueOf(lastArr[2]);
		this.solutionNumb = Integer.valueOf(lastArr[3]);
		this.parameterCount = Integer.valueOf(lastArr[4]);
		int index = 5;
		for (int i  = 0; i < solutionNumb; ++i) {
			double[] vals = new double[parameterCount];
			for (int j = 0; j < parameterCount; ++j) {
				vals[j] = Double.valueOf(lastArr[index]);
				++index;
			}
			solutions.add(new SingleResult(vals));
		}
		
	}
	
	public String toString() {
		return solutions.toString();
	}

	public Collection<? extends SingleResult> getSolutions() {
		return solutions;
	}

}
