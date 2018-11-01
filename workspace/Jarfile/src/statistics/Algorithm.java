package statistics;

import java.util.HashMap;
import java.util.Map;

public class Algorithm {
	
	private String name;
	
	public Algorithm(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	private static Map<String, Algorithm> algorithms = new HashMap<>();
	
	public static Algorithm get(String name) {
		return algorithms.computeIfAbsent(name, x->new Algorithm(x));
	}
	
	public String toString() {
		return name;
	}

}
