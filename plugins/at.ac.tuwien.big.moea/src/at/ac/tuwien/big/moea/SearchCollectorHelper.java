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

   public static <S extends Serializable> List<S> getCollectedData(final Accumulator accumulator, final String key,
         final Class<S> clazz) {
      final List<S> data = new ArrayList<>();
      if(accumulator == null || key == null || clazz == null) {
         return data;
      }

      try {
         for(int i = 0; i < accumulator.size(key); i++) {
            data.add(CastUtil.asClass(accumulator.get(key, i), clazz));
         }
      } catch(final IllegalArgumentException e) {
      }
      return data;
   }

   public static <S extends Serializable> Map<Accumulator, List<S>> getCollectedData(final Instrumenter instrumenter,
         final String key, final Class<S> clazz) {
      final Map<Accumulator, List<S>> data = new HashMap<>();
      if(instrumenter == null || key == null || clazz == null) {
         return data;
      }

      final List<Accumulator> accumulators = new ArrayList<>();
      if(instrumenter instanceof SearchInstrumenter) {
         accumulators.addAll(((SearchInstrumenter) instrumenter).getAccumulators());
      } else {
         accumulators.add(instrumenter.getLastAccumulator());
      }

      try {
         for(final Accumulator accumulator : accumulators) {
            data.put(accumulator, getCollectedData(accumulator, key, clazz));
         }
      } catch(final IllegalArgumentException e) {
      }
      return data;
   }

   public static <S extends Serializable> Map<Accumulator, List<S>> getCollectedData(final SearchExecutor executor,
         final String key, final Class<S> clazz) {
      final Map<Accumulator, List<S>> data = new HashMap<>();
      if(executor == null || key == null || clazz == null) {
         return data;
      }
      return getCollectedData(executor.getInstrumenter(), key, clazz);
   }

   private Map<SearchExecutor, List<NondominatedPopulation>> results;

   public SearchCollectorHelper() {}

   public SearchCollectorHelper(final Map<SearchExecutor, List<NondominatedPopulation>> results) {
      this.results = results;
   }

   public SearchCollectorHelper(final SearchExperiment<?> experiment) {
      this.results = experiment.hasResults() ? experiment.getResults() : experiment.run();
   }

   public Set<String> getAvailableKeys() {
      if(results == null) {
         return new HashSet<>();
      }

      final Iterator<SearchExecutor> executors = getResults().keySet().iterator();
      if(!executors.hasNext()) {
         return new HashSet<>();
      }

      return executors.next().getInstrumenter().getLastAccumulator().keySet();
   }

   public Map<SearchExecutor, Map<Accumulator, List<Serializable>>> getCollectedData(final String key) {
      return getCollectedData(key, Serializable.class);
   }

   public <S extends Serializable> Map<SearchExecutor, Map<Accumulator, List<S>>> getCollectedData(final String key,
         final Class<S> clazz) {
      final Map<SearchExecutor, Map<Accumulator, List<S>>> data = new HashMap<>();
      for(final SearchExecutor executor : getResults().keySet()) {
         data.put(executor, getCollectedData(executor, key, clazz));
      }
      return data;
   }

   public Map<Accumulator, List<Serializable>> getCollectedData(final String name, final String key) {
      return getCollectedData(name, key, Serializable.class);
   }

   public <S extends Serializable> Map<Accumulator, List<S>> getCollectedData(final String name, final String key,
         final Class<S> clazz) {
      return getCollectedData(getExecutor(name), key, clazz);
   }

   public Map<SearchExecutor, Map<Accumulator, List<Serializable>>> getCollectedDataMap(final String key) {
      return getCollectedDataMap(key, Serializable.class);
   }

   public <S extends Serializable> Map<SearchExecutor, Map<Accumulator, List<S>>> getCollectedDataMap(final String key,
         final Class<S> clazz) {
      final Map<SearchExecutor, Map<Accumulator, List<S>>> data = new HashMap<>();
      for(final SearchExecutor executor : getResults().keySet()) {
         data.put(executor, getCollectedData(executor, key, clazz));
      }
      return data;
   }

   public SearchExecutor getExecutor(final String name) {
      for(final Entry<SearchExecutor, List<NondominatedPopulation>> entry : getResults().entrySet()) {
         if(entry.getKey().getName().equals(name)) {
            return entry.getKey();
         }
      }
      return null;
   }

   public Map<SearchExecutor, List<NondominatedPopulation>> getResults() {
      return results;
   }
}
