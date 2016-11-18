package at.ac.tuwien.big.momot.problem.solution.variable;

import org.eclipse.emf.henshin.interpreter.ApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.Assignment;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.InterpreterFactory;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.AssignmentImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Unit;

import at.ac.tuwien.big.moea.util.CastUtil;


public class UnitApplicationVariable extends UnitApplicationImpl implements IUnitApplicationVariable {
	private static final long serialVersionUID = 67960898574321022L;
	
	protected boolean isExecuted, isUndone;
	
	public UnitApplicationVariable(ITransformationVariable variable) {
		this(variable.getEngine(), variable.getEGraph(), 
			variable.getUnit(), new AssignmentImpl(variable.getAssignment(), false));
	}
	
	public UnitApplicationVariable(Engine engine, EGraph graph, Unit unit,
			Assignment assignment) {
		super(engine, graph, unit, assignment);
	}
	
	@Override
	public Engine getEngine() {
		return engine;
	}

	@Override
	public boolean execute(ApplicationMonitor monitor) {
		isExecuted = super.execute(monitor);
		return isExecuted;
	}
	
	@Override
	public boolean execute(boolean reexecute) {
		if(isExecuted && !reexecute)
			return isExecuted;
		return execute();
	}
	
	@Override
	public boolean execute() {
		return execute(null);
	}
	
	@Override
	public boolean isExecuted() {
		return isExecuted;
	}

	@Override
	public boolean undo(ApplicationMonitor monitor) {
		if (appliedRules.isEmpty()) 
			return true;
		
		if (monitor == null) 
			monitor = InterpreterFactory.INSTANCE.createApplicationMonitor();
		isUndone = true;
		while (!appliedRules.isEmpty()) {
			RuleApplication ruleApplication = appliedRules.pop();
			try {
				if (!ruleApplication.undo(monitor)) {
					isUndone = false;
					break;
				}
			} catch(Exception e) {
				; // TODO: fail silently for now?
			}
			undoneRules.push(ruleApplication);
		}
		monitor.notifyUndo(this, isUndone);
		return isUndone;
	}
	
	@Override
	public boolean redo(ApplicationMonitor monitor) {
		boolean redo = super.redo(monitor);
		isExecuted = isExecuted || redo;
		return redo;
	}
	
	@Override
	public boolean isUndone() {
		return isUndone;
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
		if(resultAssignment == null)
			return null;
		
		return resultAssignment.getParameterValue(parameter);
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
		if(assignment == null)
			return null;
		if(parameter == null)
			throw new IllegalArgumentException("Null parameter.");
		if(parameter.getUnit() != unit)
			throw new RuntimeException("Parameter unit invalid.");

		return assignment.getParameterValue(parameter);
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
		
		if(assignment == null) 
			assignment = new AssignmentImpl(unit);
		
		assignment.setParameterValue(parameter, value);
	}
	
	@Override
	public int compareTo(ITransformationVariable other) {
		return new Integer(this.hashCode()).compareTo(other.hashCode());
	}

	@Override
	public ITransformationVariable copy() {
		return new UnitApplicationVariable(this);
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
