package at.ac.tuwien.big.momot.problem.solution.variable;

import org.eclipse.emf.henshin.interpreter.Assignment;
import org.eclipse.emf.henshin.interpreter.Change;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.impl.AssignmentImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;

import at.ac.tuwien.big.moea.util.CastUtil;

public class RuleApplicationVariable extends RuleApplicationImpl implements IRuleApplicationVariable {

	private static final long serialVersionUID = 5601540634156998449L;

	public RuleApplicationVariable(RuleApplicationVariable variable) {
		this(variable.getEngine(), variable.getEGraph(), 
				variable.getRule(), new AssignmentImpl(variable.getAssignment(), false));
	}
	
	public RuleApplicationVariable(Engine engine, EGraph graph, Rule rule,
			Assignment partialMatch) {
		super(engine, graph, rule, partialMatch);
	}

	@Override
	public Engine getEngine() {
		return engine;
	}
	
	@Override
	public boolean isExecuted() {
		return isExecuted;
	}
	
	@Override
	public boolean isUndone() {
		return isUndone;
	}
	
	public Change getChange() {
		return change;
	}
	
	@Override
	public boolean execute() {
		return execute(true);
	}
	
	@Override
	public boolean execute(boolean reexecute) {
		if(isExecuted && !reexecute)
			return isExecuted;
		return execute(null);
	}
	
	protected Parameter getParameter(String parameterName) {
		if(unit == null)
			throw new RuntimeException("Transformation unit not set");
		Parameter param = unit.getParameter(parameterName);
		if(param == null)
			throw new RuntimeException("No parameter \"" + parameterName + "\" in transformation unit \"" + unit.getName() + "\" found.");
		return param;
	}
	
	@Override
	public Object getResultParameterValue(String parameterName) {
		return getResultParameterValue(getParameter(parameterName));
	}
	
	@Override
	public Object getResultParameterValue(Parameter parameter) {
		if(parameter == null) 
			throw new RuntimeException("Null parameter.");
		if(parameter.getUnit() != unit) 
			throw new RuntimeException("Incorrect parameter unit.");
		if(resultMatch == null)
			return null;
		
		return resultMatch.getParameterValue(parameter);
	}
	
	@Override
	public <T> T getResultParameterValue(Parameter parameter, Class<T> valueClass) {
		return CastUtil.asClass(getResultParameterValue(parameter.getName()), valueClass);
	}	
	
	@Override
	public <T> T getResultParameterValue(String parameterName, Class<T> resultClass) {
		return getResultParameterValue(getParameter(parameterName), resultClass);
	}
	
	@Override
	public Object getParameterValue(Parameter parameter) {
		if(partialMatch == null)
			return null;
		if(parameter == null)
			throw new IllegalArgumentException("Null parameter.");
		if(parameter.getUnit() != unit)
			throw new RuntimeException("Parameter unit invalid.");

		return partialMatch.getParameterValue(parameter);
	}
	
	@Override
	public Object getParameterValue(String parameterName) {
		return getParameterValue(getParameter(parameterName));
	}
	
	@Override
	public <T> T getParameterValue(Parameter parameter, Class<T> valueClass) {
		return CastUtil.asClass(getParameterValue(parameter), valueClass);
	}
	
	@Override
	public <T> T getParameterValue(String parameterName, Class<T> valueClass) {
		return CastUtil.asClass(getParameterValue(parameterName), valueClass);
	}
	
	@Override
	public void setParameterValue(String paramName, Object value) {
		setParameterValue(getParameter(paramName), value);
	}
	
	@Override
	public void setParameterValue(Parameter parameter, Object value) {
		if(parameter == null) 
			throw new RuntimeException("Null parameter.");
		if(parameter.getUnit() != unit)
			throw new RuntimeException("Parameter unit invalid.");
		
		if(partialMatch == null) 
			partialMatch = new MatchImpl((Rule) unit);
		
		partialMatch.setParameterValue(parameter, value);
		completeMatch = null;
		isCompleteMatchDerived = false;
	}
	
	@Override
	public int compareTo(ITransformationVariable other) {
		return new Integer(this.hashCode()).compareTo(other.hashCode());
	}

	@Override
	public ITransformationVariable copy() {
		return new RuleApplicationVariable(this);
	}
	
	@Override
	public String toString() {
		return getAssignment().toString();
	}

	@Override
	public void randomize() {
		throw new IllegalAccessError("Should not be called. Is taken care of by an IPopulationGenerator.");
	}
}
