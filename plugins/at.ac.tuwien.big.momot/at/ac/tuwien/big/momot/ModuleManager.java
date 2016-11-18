package at.ac.tuwien.big.momot;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
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

import at.ac.tuwien.big.moea.util.CastUtil;
import at.ac.tuwien.big.moea.util.TextUtil;
import at.ac.tuwien.big.momot.problem.solution.variable.ITransformationVariable;
import at.ac.tuwien.big.momot.problem.solution.variable.RuleApplicationVariable;
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.increment.IncrementalStringValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.random.RandomDoubleValue;
import at.ac.tuwien.big.momot.problem.unit.parameter.random.RandomIntegerValue;
import at.ac.tuwien.big.momot.search.engine.MomotEngine;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class ModuleManager {
	protected String baseDir = null;
	protected HenshinResourceSet resourceSet = null;
	
	private List<Module> modules = new ArrayList<>();
	private List<Unit> units = new ArrayList<>();
	private List<Rule> rules = new ArrayList<>();
	private List<Parameter> parameters = new ArrayList<>();
	
	private Map<String, Module> nameToModules = new HashMap<>();
	private Map<String, Unit> nameToUnits = new HashMap<>();
	private Map<String, Parameter> nameToParameters = new HashMap<>();
	
	// generators for providing user parameter values
	private Map<Parameter, IParameterValue<?>> parameterValues = new HashMap<>();
	// parameters that should not be preserved as part of the solution
	private Set<Parameter> nonSolutionParameters = new HashSet<>();

	public ModuleManager() {
		init();
	}
	
	public ModuleManager(String baseDir) {
		setBaseDir(baseDir);
	}
	
	public ModuleManager(String baseDir, String moduleUri) {
		setBaseDir(baseDir);
		addModule(moduleUri);
	}
	
	protected void init() {
		this.resourceSet = new HenshinResourceSet(getBaseDir());
		clear();
	}
	
	protected void initUnits() {
		for(Module module : modules) 
			initUnits(module);
	}
	
	protected void initUnits(Module module) {
		if(module == null)
			return;
		Registry packageRegistry = getResourceSet().getPackageRegistry();
		for(EPackage ePackage : module.getImports()) 
			packageRegistry.put(ePackage.getNsURI(), ePackage);
		
		this.nameToModules.put(getQualifiedName(module), module);
		for(Unit unit : module.getUnits()) {
			units.add(unit);
			nameToUnits.put(getQualifiedName(unit), unit);
			if(unit instanceof Rule) 
				rules.add((Rule)unit);
			for(Parameter parameter : unit.getParameters()) {
				parameters.add(parameter);
				nameToParameters.put(getQualifiedName(parameter), parameter);
			}
		}
	}
	
	protected void reloadUnits() {
		units.clear();
		rules.clear();
		parameters.clear();
		nameToUnits.clear();
		nameToParameters.clear();
		initUnits();
	}
	
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
	
	// getter and setter
	
	public String getBaseDir() {
		return baseDir;
	}
	
	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
		init();
	}
	
	public HenshinResourceSet getResourceSet() {
		return resourceSet;
	}
	
	public void setResourceSet(HenshinResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		this.baseDir = resourceSet.getBaseDir().toString();
	}
	
	public void addModule(String moduleUri) {
		addModule(getResourceSet().getModule(moduleUri, false));
	}
	
	public void addModules(String... moduleUris) {
		for(String moduleUri : moduleUris)
			addModule(moduleUri);
	}
	
	public void addModule(Module module) {
		this.modules.add(module);
		initUnits(module);
	}
	
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	public List<Module> getModules() {
		return Collections.unmodifiableList(modules);
	}
	
	public Module getModule(String name) {
		return nameToModules.get(name);
	}
	
	// getter and setter - units
	
	public List<Unit> getUnits() {
		return Collections.unmodifiableList(units);
	}
	
	public List<Rule> getRules() {
		return Collections.unmodifiableList(rules);
	}
	
	public Unit getUnit(String moduleName, String unitName) {
		return getUnit(getQualifiedName(moduleName, unitName));
	}
	
	public <T extends Unit> T getUnit(String moduleName, String unitName, Class<T> clazz) {
		return CastUtil.asClass(getUnit(moduleName, unitName), clazz);
	}
	
	public Unit getUnit(String qualifiedUnitName) {
		return nameToUnits.get(getQualifiedName(qualifiedUnitName));
	}
	
	public <T extends Unit> T getUnit(String qualifiedUnitName, Class<T> clazz) {
		return CastUtil.asClass(getUnit(qualifiedUnitName), clazz);
	}
	
	public Rule getRule(String moduleName, String unitName) {
		return getUnit(moduleName, unitName, Rule.class);
	}
	
	public Rule getRule(String qualifiedRuleName) {
		return getUnit(qualifiedRuleName, Rule.class);
	}
	
	public List<Rule> getSubRules(String qualifiedRuleName) {
		return getSubRules(qualifiedRuleName, false);
	}
	
	public Rule getSubRule(String qualifiedRuleName, String subRuleName) {
		Rule rule = getRule(qualifiedRuleName);
		if(rule == null)
			return null;
		return rule.getMultiRule(subRuleName);
	}
	
	public List<Rule> getSubRules(String qualifiedRuleName, boolean deep) {
		Rule rule = getRule(qualifiedRuleName);
		if(rule == null)
			return new ArrayList<>();
		if(!deep)
			return rule.getMultiRules();
		else
			return rule.getAllMultiRules();
	}
	
	public Rule getSubRule(String qualifiedSubRuleName) {
		String[] parts = TextUtil.assertSplit(qualifiedSubRuleName, 
				2, 
				"Qualified sub rule name must contain both the rule name and sub rule name.");
		return getSubRule(parts[0], parts[1]);		
	}	
	
	// getter and setter - parameter
	
	public List<Parameter> getParameters() {
		return Collections.unmodifiableList(parameters);
	}
	
	public List<Parameter> getSolutionParameters() {
		List<Parameter> solutionParameters = new ArrayList<>(parameters);
		solutionParameters.removeAll(nonSolutionParameters);
		return solutionParameters;
	}
	
	public Parameter getParameter(String moduleName, String unitName, String parameterName) {
		return getParameter(getQualifiedName(moduleName, unitName, parameterName));
	}
	
	public Parameter getParameter(String qualifiedUnitName, String parameterName) {
		return getParameter(getQualifiedName(qualifiedUnitName, parameterName));
	}
	
	public Parameter getParameter(String qualifiedParameterName) {
		return nameToParameters.get(getQualifiedName(qualifiedParameterName));
	}
	
	// remove
	
	public Module removeModule(Module module) {
		if(module == null)
			return module;
		
		for(Unit unit : module.getUnits()) 
			removeUnit(unit);

		nameToModules.remove(getQualifiedName(module));
		modules.remove(module);
		
		return module;
	}
	
	public Module removeModule(String moduleName) {
		return removeModule(getModule(moduleName));
	}
	
	public ModuleManager removeModules(String... moduleNames) {
		for(String moduleName : moduleNames)
			removeModule(getModule(moduleName));
		return this;
	}
	
	public ModuleManager removeModules(Iterable<String> moduleNames) {
		for(String moduleName : moduleNames)
			removeModule(getModule(moduleName));
		return this;
	}
	
	// remove - units
	
	public <T extends Unit> T removeUnit(T unit) {
		if(unit == null)
			return unit;
		
		for(Parameter parameter : unit.getParameters()) {
			nameToParameters.remove(getQualifiedName(parameter));
			parameters.remove(parameter);
		}
		
		nameToUnits.remove(getQualifiedName(unit));
		units.remove(unit);
		
		if(unit instanceof Rule)
			rules.remove(unit);
		
		return unit;
	}
	
	public Unit removeUnit(String qualifiedUnitName) {
		return removeUnit(getUnit(qualifiedUnitName));
	}
	
	public Unit removeUnit(String moduleName, String unitName) {
		return removeUnit(getUnit(moduleName, unitName));
	}
	
	public <T extends Unit> T removeUnit(String qualifiedUnitName, Class<T> clazz) {
		return removeUnit(getUnit(qualifiedUnitName, clazz));
	}
	
	public <T extends Unit> T removeUnit(String moduleName, String unitName, Class<T> clazz) {
		return removeUnit(getUnit(moduleName, unitName, clazz));
	}
	
	public ModuleManager removeUnits(String... qualifiedUnitNames) {
		for(String qualifiedUnitName : qualifiedUnitNames)
			removeUnit(getUnit(qualifiedUnitName));
		return this;
	}
	
	public ModuleManager removeUnits(Iterable<String> qualifiedUnitNames) {
		for(String qualifiedUnitName : qualifiedUnitNames)
			removeUnit(getUnit(qualifiedUnitName));
		return this;
	}
	
	// parameter values
	
	public boolean setParameterValue(String moduleName, String unitName, String parameterName, IParameterValue<?> value) {
		return setParameterValue(getParameter(moduleName, unitName, parameterName), value);
	}
	
	public boolean setParameterValue(String qualifiedUnitName, String parameterName, IParameterValue<?> value) {
		return setParameterValue(getParameter(qualifiedUnitName, parameterName), value);
	}
	
	public boolean setParameterValue(String qualifiedParameterName, IParameterValue<?> value) {
		return setParameterValue(getParameter(qualifiedParameterName), value);
	}
	
	public boolean setParameterValue(Parameter parameter, IParameterValue<?> value) {
		boolean setValue = parameter != null && parameters.contains(parameter);
		if(setValue) 
			parameterValues.put(parameter, value);
		return setValue;
	}
	
	public IParameterValue<?> getParameterValue(Parameter parameter) {
		return parameterValues.get(parameter);
	}
	
	public IParameterValue<?> getParameterValue(String qualifiedParameterName) {
		return getParameterValue(getParameter(qualifiedParameterName));
	}
	
	public IParameterValue<?> getParameterValue(String qualifiedUnitName, String parameterName) {
		return getParameterValue(getParameter(qualifiedUnitName, parameterName));
	}
	
	public IParameterValue<?> getParameterValue(String moduleName, String unitName, String parameterName) {
		return getParameterValue(getParameter(moduleName, unitName, parameterName));
	}
	
	public boolean hasParameterValue(Parameter parameter) {
		return parameterValues.containsKey(parameter);
	}
	
	public boolean hasParameterValue(String qualifiedParameterName) {
		return hasParameterValue(getParameter(qualifiedParameterName));
	}
	
	public boolean hasParameterValue(String qualifiedUnitName, String parameterName) {
		return hasParameterValue(getParameter(qualifiedUnitName, parameterName));
	}
	
	public boolean hasParameterValue(String moduleName, String unitName, String parameterName) {
		return hasParameterValue(getParameter(moduleName, unitName, parameterName));
	}
	
	// convenience methods to get next parameter value
	public<T> T nextParameterValueEarly(Parameter parameter, Assignment curValue) {
		IParameterValue value = parameterValues.get(parameter);
		if(value == null || value.isLate())
			return null;
		return (T)value.nextValue(curValue);
	}
	
	// convenience methods to get next parameter value
	public<T> T nextParameterValueLate(Parameter parameter, Assignment curValue) {
		IParameterValue value = parameterValues.get(parameter);
		if(value == null || !value.isLate())
			return null;
		return (T)value.nextValue(curValue);
	}
	
	
	public<T> T nextParameterValue(Parameter parameter, Assignment curValue) {
		IParameterValue value = parameterValues.get(parameter);
		if(value == null)
			return null;
		return (T)value.nextValue(curValue);
	}
	
	public <T extends Object> T nextParameterValue(Parameter parameter, Class<T> valueType, Assignment curValue) {
		return CastUtil.asClass(nextParameterValue(parameter,curValue), valueType);
	}
	
	public<T> T nextParameterValue(String qualifiedParameterName, Assignment curValue) {
		return nextParameterValue(getParameter(qualifiedParameterName), curValue);
	}
	
	public <T extends Object> T nextParameterValue(String qualifiedParameterName, Class<T> valueType, Assignment curValue) {
		return nextParameterValue(getParameter(qualifiedParameterName), valueType, curValue);
	}
	
	public<T> T nextParameterValue(String qualifiedUnitName, String parameterName, Assignment curValue) {
		return nextParameterValue(getParameter(qualifiedUnitName, parameterName), curValue);
	}
	
	public <T extends Object> T nextParameterValue(String qualifiedUnitName, String parameterName, Class<T> valueType, Assignment curValue) {
		return nextParameterValue(getParameter(qualifiedUnitName, parameterName), valueType, curValue);
	}
	
	public<T> T nextParameterValue(String moduleName, String unitName, String parameterName, Assignment curValue) {
		return nextParameterValue(getParameter(moduleName, unitName, parameterName), curValue);
	}
	
	public <T extends Object> T nextParameterValue(String moduleName, String unitName, String parameterName, Class<T> valueType, Assignment curValue) {
		return nextParameterValue(getParameter(moduleName, unitName, parameterName), valueType, curValue);
	}
	
	// non-solution parameters
	
	public void addNonSolutionParameter(Parameter parameter) {
		nonSolutionParameters.add(parameter);
	}
	
	public void addNonSolutionParameter(String qualifiedParameterName) {
		addNonSolutionParameter(getParameter(qualifiedParameterName));
	}
	
	public void addNonSolutionParameter(String qualifiedUnitName, String parameterName) {
		addNonSolutionParameter(getParameter(qualifiedUnitName, parameterName));
	}
	
	public void addNonSolutionParameter(String moduleName, String unitName, String parameterName) {
		addNonSolutionParameter(getParameter(moduleName, unitName, parameterName));
	}
	
	public void addNonSolutionParameters(String... qualifiedParameterNames) {
		for(String qualifiedParameterName : qualifiedParameterNames)
			addNonSolutionParameter(qualifiedParameterName);
	}
	
	public void addNonSolutionParameters(Iterable<String> qualifiedParameterNames) {
		for(String qualifiedParameterName : qualifiedParameterNames)
			addNonSolutionParameter(qualifiedParameterName);
	}
	
	// clean and population methods
	
	public Assignment clearNonSolutionParameters(UnitApplication application) {
		return clearNonSolutionParameters(application.getAssignment());
	}
	
	public <T extends Assignment> T clearNonSolutionParameters(T assignment) {
		if(assignment == null || assignment.getUnit() == null)
			return assignment;
		
		for(Parameter parameter : assignment.getUnit().getParameters())
			if(nonSolutionParameters.contains(parameter))
				assignment.setParameterValue(parameter, null);			
		return assignment;
	}
	
	public Assignment assignParameterValuesLate(Assignment assignment) {
		if(assignment == null || assignment.getUnit() == null)
			return assignment;
		
		for(Parameter parameter : assignment.getUnit().getParameters()) {
			Object value = nextParameterValueLate(parameter,assignment);
			if(value != null)
				assignment.setParameterValue(parameter, value);
		}
		
		return assignment;
	}

	public Assignment assignParameterValuesEarly(Assignment assignment) {
		if(assignment == null || assignment.getUnit() == null)
			return assignment;
		
		for(Parameter parameter : assignment.getUnit().getParameters()) {
			Object value = nextParameterValueEarly(parameter,assignment);
			if(value != null)
				assignment.setParameterValue(parameter, value);
		}
		
		return assignment;
	}
	
	public <T extends Assignment> T assignParameterValues(T assignment) {
		if(assignment == null || assignment.getUnit() == null)
			return assignment;
		
		for(Parameter parameter : assignment.getUnit().getParameters()) {
			Object value = nextParameterValue(parameter,assignment);
			if(value != null)
				assignment.setParameterValue(parameter, value);
		}
		
		return assignment;
	}
	
	// static convenience methods
	
	public static String getQualifiedName(Module module) {
		Assert.isNotNull(module, "module can not be null.");
		String fileName = null;
		if(module.eResource() != null)
			fileName = module.eResource().getURI().trimFileExtension().lastSegment();
		return getQualifiedName(fileName, module.getName());
	}
	
	public static String getQualifiedName(Unit unit) {
		Assert.isNotNull(unit, "Unit can not be null.");
		return getQualifiedName(getQualifiedName(unit.getModule()), unit.getName());
	}
	
	public static String getQualifiedName(Parameter parameter) {
		Assert.isNotNull(parameter, "Parameter can not be null.");
		return getQualifiedName(getQualifiedName(parameter.getUnit()), parameter.getName());
	}
	
	public static String getQualifiedName(String... parts) {
		if(parts.length == 1) // allow for Java delimiters
			return parts[0].replace(TextUtil.JAVA_DELIMITER, TextUtil.UML_DELIMITER);
		
		StringBuilder sb = new StringBuilder();
		
		boolean firstSegment = false;
		for(int i = 0; i < parts.length; i++) {
			if(parts[i] != null && parts[i] != "") {
				if(firstSegment)
					sb.append(TextUtil.UML_DELIMITER);
				sb.append(parts[i]);
				firstSegment = true;
			}
		}
		return sb.toString();
	}
	
	public static IParameterValue<?> getDefaultUserParameterValue(Parameter parameter) {
		Class<?> clazz = CastUtil.wrap(parameter.getType().getInstanceClass());
		
		if(clazz == Double.class)
			return new RandomDoubleValue();
		
		if(clazz == Integer.class)
			return new RandomIntegerValue();

		
		if(clazz == String.class)
			return new IncrementalStringValue();
		
		return null;
	}
	
	public void registerMetamodel(File file) {
		registerMetamodel(URI.createFileURI(file.getAbsolutePath()));
	}
	
	public void registerMetamodel(URI resourceUri) {
		// enable extended metadata
		final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(resourceSet.getPackageRegistry());
		getResourceSet().getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA,
		    extendedMetaData);
		Resource r = getResourceSet().getResource(resourceUri, true);
		
		EObject eObject = r.getContents().get(0);
		if (eObject instanceof EPackage) {
		    EPackage p = (EPackage)eObject;
		    resourceSet.getPackageRegistry().put(p.getNsURI(), p);
		}
	}
	
	// convenience methods
	
	public EGraph loadGraph(String resource) {
		return MomotUtil.loadGraph(getResourceSet(), resource);
	}
	
	public void saveGraph(EGraph graph, String targetResource) {
		MomotUtil.saveGraph(getResourceSet(), graph, targetResource);
	}
	
	// static convenience methods

	public RuleApplication createRuleApplication(String qualifiedRuleName, EGraph searchGraph) {
		return createRuleApplication(qualifiedRuleName, searchGraph, false);
	}
		
	public RuleApplication createRuleApplication(String qualifiedRuleName, EGraph searchGraph, boolean deterministic) {
		return createRuleApplication(new MomotEngine(deterministic), qualifiedRuleName, searchGraph); 
	}
		
	public RuleApplication createRuleApplication(Engine engine, String qualifiedRuleName, EGraph searchGraph) {
		Rule rule = getRule(qualifiedRuleName);
		return new RuleApplicationVariable(engine, searchGraph, rule, null);
	}

}
