package at.ac.tuwien.big.moea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.moeaframework.Instrumenter;
import org.moeaframework.analysis.collector.Accumulator;
import org.moeaframework.core.NondominatedPopulation;

import at.ac.tuwien.big.moea.experiment.executor.SearchExecutor;
import at.ac.tuwien.big.moea.experiment.instrumenter.SearchInstrumenter;
import at.ac.tuwien.big.moea.util.CastUtil;

public class SearchCollectorHelper {

	private Map<SearchExecutor, List<NondominatedPopulation>> results;

	public SearchCollectorHelper() { }
	
	public SearchCollectorHelper(Map<SearchExecutor, List<NondominatedPopulation>> results) {
		this.results = results;
	}
	
	public SearchCollectorHelper(SearchExperiment<?> experiment) {
		this.results = experiment.hasResults() ? experiment.getResults() : experiment.run();
	}
	
	public Map<SearchExecutor, List<NondominatedPopulation>> getResults() {
		return results;
	}
	
	public SearchExecutor getExecutor(String name) {
		for(Entry<SearchExecutor, List<NondominatedPopulation>> entry : getResults().entrySet())
			if(entry.getKey().getName().equals(name))
				return entry.getKey();
		return null;
	}
	
	public Set<String> getAvailableKeys() {
		if(results == null)
			return new HashSet<>();
		
		Iterator<SearchExecutor> executors = getResults().keySet().iterator();
		if(!executors.hasNext())
			return new HashSet<>();
		
		return executors.next().getInstrumenter().getLastAccumulator().keySet();
	}
	
	public <S extends Serializable> Map<SearchExecutor, Map<Accumulator, List<S>>> getCollectedData(String key, Class<S> clazz) {
		Map<SearchExecutor, Map<Accumulator, List<S>>> data = new HashMap<>();
		for(SearchExecutor executor : getResults().keySet()) 
			data.put(executor, getCollectedData(executor, key, clazz));
		return data;
	}
	
	public Map<SearchExecutor, Map<Accumulator, List<Serializable>>> getCollectedDataMap(String key) {
		return getCollectedDataMap(key, Serializable.class);
	}
	
	public <S extends Serializable> Map<SearchExecutor, Map<Accumulator, List<S>>> getCollectedDataMap(String key, Class<S> clazz) {
		Map<SearchExecutor, Map<Accumulator, List<S>>> data = new HashMap<>();
		for(SearchExecutor executor : getResults().keySet()) 
			data.put(executor, getCollectedData(executor, key, clazz));
		return data;
	}
	
	public Map<SearchExecutor, Map<Accumulator, List<Serializable>>> getCollectedData(String key) {
		return getCollectedData(key, Serializable.class);
	}
	
	public Map<Accumulator, List<Serializable>> getCollectedData(String name, String key) {
		return getCollectedData(name, key, Serializable.class);
	}
	
	public <S extends Serializable> Map<Accumulator, List<S>> getCollectedData(String name, String key, Class<S> clazz) {
		return getCollectedData(getExecutor(name), key, clazz);
	}

	public static <S extends Serializable> Map<Accumulator, List<S>> getCollectedData(SearchExecutor executor, String key, Class<S> clazz) {
		Map<Accumulator, List<S>> data = new HashMap<>();
		if(executor == null || key == null || clazz == null)
			return data;
		return getCollectedData(executor.getInstrumenter(), key, clazz);
	}
	
	public static <S extends Serializable> Map<Accumulator, List<S>> getCollectedData(Instrumenter instrumenter, String key, Class<S> clazz) {
		Map<Accumulator, List<S>> data = new HashMap<>();
		if(instrumenter == null || key == null || clazz == null)
			return data;
		
		List<Accumulator> accumulators = new ArrayList<>();
		if(instrumenter instanceof SearchInstrumenter)
			accumulators.addAll(((SearchInstrumenter) instrumenter).getAccumulators());
		else
			accumulators.add(instrumenter.getLastAccumulator());
		
		try {
			for(Accumulator accumulator : accumulators)
				data.put(accumulator, getCollectedData(accumulator, key, clazz));
		} catch(IllegalArgumentException e) {
		}
		return data;
	}
	
	public static <S extends Serializable> List<S> getCollectedData(Accumulator accumulator, String key, Class<S> clazz) {
		List<S> data = new ArrayList<>();
		if(accumulator == null || key == null || clazz == null)
			return data;
		
		try {
			for(int i = 0; i < accumulator.size(key); i++)
				data.add(CastUtil.asClass(accumulator.get(key, i), clazz));
		} catch(IllegalArgumentException e) {
		}
		return data;
	}
}
