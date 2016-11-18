package at.ac.tuwien.big.momot.problem.solution.variable;

import java.util.List;

import org.eclipse.emf.henshin.model.Parameter;
import org.moeaframework.core.Variable;

public interface IChangeVariable<U> extends Variable {

	IChangeVariable<U> copy();
	
	boolean execute();
	boolean execute(boolean reexecute);
	boolean isExecuted();
	boolean isUndone();
	
	Object getResultParameterValue(U parameter);
	<T> T getResultParameterValue(U parameter, Class<T> valueClass);
	<T> T getResultParameterValue(String parameterName, Class<T> resultClass);
	
	public Object getParameterValue(U parameter);
	public <T> T getParameterValue(U parameter, Class<T> valueClass);
	public Object getParameterValue(String paramName);
	public <T> T getParameterValue(String paramName, Class<T> valueClass);
	
	void setParameterValue(Parameter parameter, Object value);
	
	public List<U> getParameters();
}
