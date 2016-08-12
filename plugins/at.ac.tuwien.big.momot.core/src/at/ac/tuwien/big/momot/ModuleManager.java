package at.ac.tuwien.big.momot;

import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.moea.util.TextUtil;
import at.ac.tuwien.big.momot.problem.solution.variable.RuleApplicationVariable;
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.increment.IncrementalStringValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.random.RandomDoubleValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.random.RandomIntegerValue;
import at.ac.tuwien.big.momot.search.engine.MomotEngine;
import at.ac.tuwien.big.momot.util.MomotUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.henshin.interpreter.Assignment;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class ModuleManager {
   public static IParameterValue<?> getDefaultUserParameterValue(final Parameter parameter) {
      final Class<?> clazz = CastUtil.wrap(parameter.getType().getInstanceClass());

      if(clazz == Double.class) {
         return new RandomDoubleValue();
      }

      if(clazz == Integer.class) {
         return new RandomIntegerValue();
      }

      if(clazz == String.class) {
         return new IncrementalStringValue();
      }

      return null;
   }

   public static String getQualifiedName(final Module module) {
      Assert.isNotNull(module, "module can not be null.");
      String fileName = null;
      if(module.eResource() != null) {
         fileName = module.eResource().getURI().trimFileExtension().lastSegment();
      }
      return getQualifiedName(fileName, module.getName());
   }

   public static String getQualifiedName(final Parameter parameter) {
      Assert.isNotNull(parameter, "Parameter can not be null.");
      return getQualifiedName(getQualifiedName(parameter.getUnit()), parameter.getName());
   }

   public static String getQualifiedName(final String... parts) {
      if(parts.length == 1) {
         return parts[0].replace(TextUtil.JAVA_DELIMITER, TextUtil.UML_DELIMITER);
      }

      final StringBuilder sb = new StringBuilder();

      boolean firstSegment = false;
      for(final String part : parts) {
         if(part != null && !part.isEmpty()) {
            if(firstSegment) {
               sb.append(TextUtil.UML_DELIMITER);
            }
            sb.append(part);
            firstSegment = true;
         }
      }
      return sb.toString();
   }

   public static String getQualifiedName(final Unit unit) {
      Assert.isNotNull(unit, "Unit can not be null.");
      return getQualifiedName(getQualifiedName(unit.getModule()), unit.getName());
   }

   protected String baseDir = null;

   protected HenshinResourceSet resourceSet = null;
   private List<Module> modules = new ArrayList<>();
   private final List<Unit> units = new ArrayList<>();

   private final List<Rule> rules = new ArrayList<>();
   private final List<Parameter> parameters = new ArrayList<>();

   private final Map<String, Module> nameToModules = new HashMap<>();

   private final Map<String, Unit> nameToUnits = new HashMap<>();

   private final Map<String, Parameter> nameToParameters = new HashMap<>();

   // generators for providing user parameter values
   private final Map<Parameter, IParameterValue<?>> parameterValues = new HashMap<>();

   // parameters that should not be preserved as part of the solution
   private final Set<Parameter> nonSolutionParameters = new HashSet<>();

   public ModuleManager() {
      init();
   }

   public ModuleManager(final String baseDir) {
      setBaseDir(baseDir);
   }

   public ModuleManager(final String baseDir, final String moduleUri) {
      setBaseDir(baseDir);
      addModule(moduleUri);
   }

   // getter and setter

   public void addModule(final Module module) {
      this.modules.add(module);
      initUnits(module);
   }

   public void addModule(final String moduleUri) {
      addModule(getResourceSet().getModule(moduleUri, false));
   }

   public void addModules(final String... moduleUris) {
      for(final String moduleUri : moduleUris) {
         addModule(moduleUri);
      }
   }

   public void addNonSolutionParameter(final Parameter parameter) {
      nonSolutionParameters.add(parameter);
   }

   public void addNonSolutionParameter(final String qualifiedParameterName) {
      addNonSolutionParameter(getParameter(qualifiedParameterName));
   }

   public void addNonSolutionParameter(final String qualifiedUnitName, final String parameterName) {
      addNonSolutionParameter(getParameter(qualifiedUnitName, parameterName));
   }

   public void addNonSolutionParameter(final String moduleName, final String unitName, final String parameterName) {
      addNonSolutionParameter(getParameter(moduleName, unitName, parameterName));
   }

   public void addNonSolutionParameters(final Iterable<String> qualifiedParameterNames) {
      for(final String qualifiedParameterName : qualifiedParameterNames) {
         addNonSolutionParameter(qualifiedParameterName);
      }
   }

   public void addNonSolutionParameters(final String... qualifiedParameterNames) {
      for(final String qualifiedParameterName : qualifiedParameterNames) {
         addNonSolutionParameter(qualifiedParameterName);
      }
   }

   public <T extends Assignment> T assignParameterValues(final T assignment) {
      if(assignment == null || assignment.getUnit() == null) {
         return assignment;
      }

      for(final Parameter parameter : assignment.getUnit().getParameters()) {
         final Object value = nextParameterValue(parameter);
         if(value != null) {
            assignment.setParameterValue(parameter, value);
         }
      }

      return assignment;
   }

   // getter and setter - units

   protected void clear() {
      modules.clear();
      units.clear();
      rules.clear();
      parameters.clear();
      nameToUnits.clear();
      nameToParameters.clear();

      parameterValues.clear();
      nonSolutionParameters.clear();
   }

   public <T extends Assignment> T clearNonSolutionParameters(final T assignment) {
      if(assignment == null || assignment.getUnit() == null) {
         return assignment;
      }

      for(final Parameter parameter : assignment.getUnit().getParameters()) {
         if(nonSolutionParameters.contains(parameter)) {
            assignment.setParameterValue(parameter, null);
         }
      }
      return assignment;
   }

   public Assignment clearNonSolutionParameters(final UnitApplication application) {
      return clearNonSolutionParameters(application.getAssignment());
   }

   public RuleApplication createRuleApplication(final Engine engine, final String qualifiedRuleName,
         final EGraph searchGraph) {
      final Rule rule = getRule(qualifiedRuleName);
      return new RuleApplicationVariable(engine, searchGraph, rule, null);
   }

   public RuleApplication createRuleApplication(final String qualifiedRuleName, final EGraph searchGraph) {
      return createRuleApplication(qualifiedRuleName, searchGraph, false);
   }

   public RuleApplication createRuleApplication(final String qualifiedRuleName, final EGraph searchGraph,
         final boolean deterministic) {
      return createRuleApplication(new MomotEngine(deterministic), qualifiedRuleName, searchGraph);
   }

   public String getBaseDir() {
      return baseDir;
   }

   public Module getModule(final String name) {
      return nameToModules.get(name);
   }

   public List<Module> getModules() {
      return Collections.unmodifiableList(modules);
   }

   public Parameter getParameter(final String qualifiedParameterName) {
      return nameToParameters.get(getQualifiedName(qualifiedParameterName));
   }

   public Parameter getParameter(final String qualifiedUnitName, final String parameterName) {
      return getParameter(getQualifiedName(qualifiedUnitName, parameterName));
   }

   public Parameter getParameter(final String moduleName, final String unitName, final String parameterName) {
      return getParameter(getQualifiedName(moduleName, unitName, parameterName));
   }

   // getter and setter - parameter

   public List<Parameter> getParameters() {
      return Collections.unmodifiableList(parameters);
   }

   public IParameterValue<?> getParameterValue(final Parameter parameter) {
      return parameterValues.get(parameter);
   }

   public IParameterValue<?> getParameterValue(final String qualifiedParameterName) {
      return getParameterValue(getParameter(qualifiedParameterName));
   }

   public IParameterValue<?> getParameterValue(final String qualifiedUnitName, final String parameterName) {
      return getParameterValue(getParameter(qualifiedUnitName, parameterName));
   }

   public IParameterValue<?> getParameterValue(final String moduleName, final String unitName,
         final String parameterName) {
      return getParameterValue(getParameter(moduleName, unitName, parameterName));
   }

   // remove

   public HenshinResourceSet getResourceSet() {
      return resourceSet;
   }

   public Rule getRule(final String qualifiedRuleName) {
      return getUnit(qualifiedRuleName, Rule.class);
   }

   public Rule getRule(final String moduleName, final String unitName) {
      return getUnit(moduleName, unitName, Rule.class);
   }

   public List<Rule> getRules() {
      return Collections.unmodifiableList(rules);
   }

   // remove - units

   public List<Parameter> getSolutionParameters() {
      final List<Parameter> solutionParameters = new ArrayList<>(parameters);
      solutionParameters.removeAll(nonSolutionParameters);
      return solutionParameters;
   }

   public Rule getSubRule(final String qualifiedSubRuleName) {
      final String[] parts = TextUtil.assertSplit(qualifiedSubRuleName, 2,
            "Qualified sub rule name must contain both the rule name and sub rule name.");
      return getSubRule(parts[0], parts[1]);
   }

   public Rule getSubRule(final String qualifiedRuleName, final String subRuleName) {
      final Rule rule = getRule(qualifiedRuleName);
      if(rule == null) {
         return null;
      }
      return rule.getMultiRule(subRuleName);
   }

   public List<Rule> getSubRules(final String qualifiedRuleName) {
      return getSubRules(qualifiedRuleName, false);
   }

   public List<Rule> getSubRules(final String qualifiedRuleName, final boolean deep) {
      final Rule rule = getRule(qualifiedRuleName);
      if(rule == null) {
         return new ArrayList<>();
      }
      if(!deep) {
         return rule.getMultiRules();
      } else {
         return rule.getAllMultiRules();
      }
   }

   public Unit getUnit(final String qualifiedUnitName) {
      return nameToUnits.get(getQualifiedName(qualifiedUnitName));
   }

   public <T extends Unit> T getUnit(final String qualifiedUnitName, final Class<T> clazz) {
      return CastUtil.asClass(getUnit(qualifiedUnitName), clazz);
   }

   // parameter values

   public Unit getUnit(final String moduleName, final String unitName) {
      return getUnit(getQualifiedName(moduleName, unitName));
   }

   public <T extends Unit> T getUnit(final String moduleName, final String unitName, final Class<T> clazz) {
      return CastUtil.asClass(getUnit(moduleName, unitName), clazz);
   }

   public List<Unit> getUnits() {
      return Collections.unmodifiableList(units);
   }

   public boolean hasParameterValue(final Parameter parameter) {
      return parameterValues.containsKey(parameter);
   }

   public boolean hasParameterValue(final String qualifiedParameterName) {
      return hasParameterValue(getParameter(qualifiedParameterName));
   }

   public boolean hasParameterValue(final String qualifiedUnitName, final String parameterName) {
      return hasParameterValue(getParameter(qualifiedUnitName, parameterName));
   }

   public boolean hasParameterValue(final String moduleName, final String unitName, final String parameterName) {
      return hasParameterValue(getParameter(moduleName, unitName, parameterName));
   }

   protected void init() {
      this.resourceSet = new HenshinResourceSet(getBaseDir());
      clear();
   }

   protected void initUnits() {
      for(final Module module : modules) {
         initUnits(module);
      }
   }

   protected void initUnits(final Module module) {
      if(module == null) {
         return;
      }
      final Registry packageRegistry = getResourceSet().getPackageRegistry();
      for(final EPackage ePackage : module.getImports()) {
         packageRegistry.put(ePackage.getNsURI(), ePackage);
      }

      this.nameToModules.put(getQualifiedName(module), module);
      for(final Unit unit : module.getUnits()) {
         units.add(unit);
         nameToUnits.put(getQualifiedName(unit), unit);
         if(unit instanceof Rule) {
            rules.add((Rule) unit);
         }
         for(final Parameter parameter : unit.getParameters()) {
            parameters.add(parameter);
            nameToParameters.put(getQualifiedName(parameter), parameter);
         }
      }
   }

   public EGraph loadGraph(final String resource) {
      return MomotUtil.loadGraph(getResourceSet(), resource);
   }

   public Object nextParameterValue(final Parameter parameter) {
      final IParameterValue<?> value = parameterValues.get(parameter);
      if(value == null) {
         return null;
      }
      return value.nextValue();
   }

   // convenience methods to get next parameter value

   public <T extends Object> T nextParameterValue(final Parameter parameter, final Class<T> valueType) {
      return CastUtil.asClass(nextParameterValue(parameter), valueType);
   }

   public Object nextParameterValue(final String qualifiedParameterName) {
      return nextParameterValue(getParameter(qualifiedParameterName));
   }

   public <T extends Object> T nextParameterValue(final String qualifiedParameterName, final Class<T> valueType) {
      return nextParameterValue(getParameter(qualifiedParameterName), valueType);
   }

   public Object nextParameterValue(final String qualifiedUnitName, final String parameterName) {
      return nextParameterValue(getParameter(qualifiedUnitName, parameterName));
   }

   public <T extends Object> T nextParameterValue(final String qualifiedUnitName, final String parameterName,
         final Class<T> valueType) {
      return nextParameterValue(getParameter(qualifiedUnitName, parameterName), valueType);
   }

   public Object nextParameterValue(final String moduleName, final String unitName, final String parameterName) {
      return nextParameterValue(getParameter(moduleName, unitName, parameterName));
   }

   public <T extends Object> T nextParameterValue(final String moduleName, final String unitName,
         final String parameterName, final Class<T> valueType) {
      return nextParameterValue(getParameter(moduleName, unitName, parameterName), valueType);
   }

   protected void reloadUnits() {
      units.clear();
      rules.clear();
      parameters.clear();
      nameToUnits.clear();
      nameToParameters.clear();
      initUnits();
   }

   // non-solution parameters

   public Module removeModule(final Module module) {
      if(module == null) {
         return module;
      }

      for(final Unit unit : module.getUnits()) {
         removeUnit(unit);
      }

      nameToModules.remove(getQualifiedName(module));
      modules.remove(module);

      return module;
   }

   public Module removeModule(final String moduleName) {
      return removeModule(getModule(moduleName));
   }

   public ModuleManager removeModules(final Iterable<String> moduleNames) {
      for(final String moduleName : moduleNames) {
         removeModule(getModule(moduleName));
      }
      return this;
   }

   public ModuleManager removeModules(final String... moduleNames) {
      for(final String moduleName : moduleNames) {
         removeModule(getModule(moduleName));
      }
      return this;
   }

   public Unit removeUnit(final String qualifiedUnitName) {
      return removeUnit(getUnit(qualifiedUnitName));
   }

   public <T extends Unit> T removeUnit(final String qualifiedUnitName, final Class<T> clazz) {
      return removeUnit(getUnit(qualifiedUnitName, clazz));
   }

   // clean and population methods

   public Unit removeUnit(final String moduleName, final String unitName) {
      return removeUnit(getUnit(moduleName, unitName));
   }

   public <T extends Unit> T removeUnit(final String moduleName, final String unitName, final Class<T> clazz) {
      return removeUnit(getUnit(moduleName, unitName, clazz));
   }

   public <T extends Unit> T removeUnit(final T unit) {
      if(unit == null) {
         return unit;
      }

      for(final Parameter parameter : unit.getParameters()) {
         nameToParameters.remove(getQualifiedName(parameter));
         parameters.remove(parameter);
      }

      nameToUnits.remove(getQualifiedName(unit));
      units.remove(unit);

      if(unit instanceof Rule) {
         rules.remove(unit);
      }

      return unit;
   }

   // static convenience methods

   public ModuleManager removeUnits(final Iterable<String> qualifiedUnitNames) {
      for(final String qualifiedUnitName : qualifiedUnitNames) {
         removeUnit(getUnit(qualifiedUnitName));
      }
      return this;
   }

   public ModuleManager removeUnits(final String... qualifiedUnitNames) {
      for(final String qualifiedUnitName : qualifiedUnitNames) {
         removeUnit(getUnit(qualifiedUnitName));
      }
      return this;
   }

   public void saveGraph(final EGraph graph, final String targetResource) {
      MomotUtil.saveGraph(getResourceSet(), graph, targetResource);
   }

   public void setBaseDir(final String baseDir) {
      this.baseDir = baseDir;
      init();
   }

   public void setModules(final List<Module> modules) {
      this.modules = modules;
   }

   // convenience methods

   public boolean setParameterValue(final Parameter parameter, final IParameterValue<?> value) {
      final boolean setValue = parameter != null && parameters.contains(parameter);
      if(setValue) {
         parameterValues.put(parameter, value);
      }
      return setValue;
   }

   public boolean setParameterValue(final String qualifiedParameterName, final IParameterValue<?> value) {
      return setParameterValue(getParameter(qualifiedParameterName), value);
   }

   // static convenience methods

   public boolean setParameterValue(final String qualifiedUnitName, final String parameterName,
         final IParameterValue<?> value) {
      return setParameterValue(getParameter(qualifiedUnitName, parameterName), value);
   }

   public boolean setParameterValue(final String moduleName, final String unitName, final String parameterName,
         final IParameterValue<?> value) {
      return setParameterValue(getParameter(moduleName, unitName, parameterName), value);
   }

   public void setResourceSet(final HenshinResourceSet resourceSet) {
      this.resourceSet = resourceSet;
      this.baseDir = resourceSet.getBaseDir().toString();
   }
}
