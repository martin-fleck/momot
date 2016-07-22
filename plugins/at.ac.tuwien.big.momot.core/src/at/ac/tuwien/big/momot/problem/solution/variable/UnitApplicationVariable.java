package at.ac.tuwien.big.momot.problem.solution.variable;

import at.ac.tuwien.big.moea.util.CastUtil;

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

public class UnitApplicationVariable extends UnitApplicationImpl implements IUnitApplicationVariable {
   private static final long serialVersionUID = 67960898574321022L;

   protected boolean isExecuted;
   protected boolean isUndone;

   public UnitApplicationVariable(final Engine engine, final EGraph graph, final Unit unit,
         final Assignment assignment) {
      super(engine, graph, unit, assignment);
   }

   public UnitApplicationVariable(final ITransformationVariable variable) {
      this(variable.getEngine(), variable.getEGraph(), variable.getUnit(),
            new AssignmentImpl(variable.getAssignment(), false));
   }

   @Override
   public int compareTo(final ITransformationVariable other) {
      return new Integer(this.hashCode()).compareTo(other.hashCode());
   }

   @Override
   public ITransformationVariable copy() {
      return new UnitApplicationVariable(this);
   }

   @Override
   public boolean execute() {
      return execute(null);
   }

   @Override
   public boolean execute(final ApplicationMonitor monitor) {
      isExecuted = super.execute(monitor);
      return isExecuted;
   }

   @Override
   public boolean execute(final boolean reexecute) {
      if(isExecuted && !reexecute) {
         return isExecuted;
      }
      return execute();
   }

   @Override
   public Engine getEngine() {
      return engine;
   }

   protected Parameter getParameter(final String parameterName) {
      if(unit == null) {
         throw new RuntimeException("Transformation unit not set");
      }
      final Parameter param = unit.getParameter(parameterName);
      if(param == null) {
         throw new RuntimeException(
               "No parameter \"" + parameterName + "\" in transformation unit \"" + unit.getName() + "\" found.");
      }
      return param;
   }

   @Override
   public Object getParameterValue(final Parameter parameter) {
      if(assignment == null) {
         return null;
      }
      if(parameter == null) {
         throw new IllegalArgumentException("Null parameter.");
      }
      if(parameter.getUnit() != unit) {
         throw new RuntimeException("Parameter unit invalid.");
      }

      return assignment.getParameterValue(parameter);
   }

   @Override
   public <T> T getParameterValue(final Parameter parameter, final Class<T> valueClass) {
      return CastUtil.asClass(getParameterValue(parameter), valueClass);
   }

   @Override
   public Object getParameterValue(final String parameterName) {
      return getParameterValue(getParameter(parameterName));
   }

   @Override
   public <T> T getParameterValue(final String parameterName, final Class<T> valueClass) {
      return CastUtil.asClass(getParameterValue(parameterName), valueClass);
   }

   @Override
   public Object getResultParameterValue(final Parameter parameter) {
      if(parameter == null) {
         throw new RuntimeException("Null parameter.");
      }
      if(parameter.getUnit() != unit) {
         throw new RuntimeException("Incorrect parameter unit.");
      }
      if(resultAssignment == null) {
         return null;
      }

      return resultAssignment.getParameterValue(parameter);
   }

   @Override
   public <T> T getResultParameterValue(final Parameter parameter, final Class<T> valueClass) {
      return CastUtil.asClass(getResultParameterValue(parameter.getName()), valueClass);
   }

   @Override
   public Object getResultParameterValue(final String parameterName) {
      return getResultParameterValue(getParameter(parameterName));
   }

   @Override
   public <T> T getResultParameterValue(final String parameterName, final Class<T> resultClass) {
      return getResultParameterValue(getParameter(parameterName), resultClass);
   }

   @Override
   public boolean isExecuted() {
      return isExecuted;
   }

   @Override
   public boolean isUndone() {
      return isUndone;
   }

   @Override
   public void randomize() {
      throw new IllegalAccessError("Should not be called. Is taken care of by an IPopulationGenerator.");
   }

   @Override
   public boolean redo(final ApplicationMonitor monitor) {
      final boolean redo = super.redo(monitor);
      isExecuted = isExecuted || redo;
      return redo;
   }

   @Override
   public void setParameterValue(final Parameter parameter, final Object value) {
      if(parameter == null) {
         throw new RuntimeException("Null parameter.");
      }
      if(parameter.getUnit() != unit) {
         throw new RuntimeException("Parameter unit invalid.");
      }

      if(assignment == null) {
         assignment = new AssignmentImpl(unit);
      }

      assignment.setParameterValue(parameter, value);
   }

   @Override
   public void setParameterValue(final String paramName, final Object value) {
      setParameterValue(getParameter(paramName), value);
   }

   @Override
   public String toString() {
      return getAssignment().toString();
   }

   @Override
   public boolean undo(ApplicationMonitor monitor) {
      if(appliedRules.isEmpty()) {
         return true;
      }

      if(monitor == null) {
         monitor = InterpreterFactory.INSTANCE.createApplicationMonitor();
      }
      isUndone = true;
      while(!appliedRules.isEmpty()) {
         final RuleApplication ruleApplication = appliedRules.pop();
         try {
            if(!ruleApplication.undo(monitor)) {
               isUndone = false;
               break;
            }
         } catch(final Exception e) {
         }
         undoneRules.push(ruleApplication);
      }
      monitor.notifyUndo(this, isUndone);
      return isUndone;
   }
}
