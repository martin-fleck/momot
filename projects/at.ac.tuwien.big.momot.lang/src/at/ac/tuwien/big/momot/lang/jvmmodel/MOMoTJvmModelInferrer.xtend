package at.ac.tuwien.big.momot.lang.jvmmodel

import at.ac.tuwien.big.moea.SearchAnalysis
import at.ac.tuwien.big.moea.SearchExperiment
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType
import at.ac.tuwien.big.momot.ModuleManager
import at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmReferences
import at.ac.tuwien.big.momot.lang.mOMoT.AlgorithmSpecification
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionConstructor
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionOCL
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionSpecification
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionType
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessDimensionXBase
import at.ac.tuwien.big.momot.lang.mOMoT.FitnessFunctionSpecification
import at.ac.tuwien.big.momot.lang.mOMoT.MOMoTSearch
import at.ac.tuwien.big.momot.lang.mOMoT.ParmeterValueSpecification
import at.ac.tuwien.big.momot.lang.mOMoT.SaveObjectivesCommand
import at.ac.tuwien.big.momot.lang.mOMoT.SearchOrchestration
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution
import com.google.inject.Inject
import java.io.File
import java.io.IOException
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.ocl.ParserException
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtend2.lib.StringConcatenationClient.TargetStringConcatenation
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.moeaframework.analysis.collector.Collector
import org.moeaframework.core.Algorithm
import org.moeaframework.util.progress.ProgressListener

import static at.ac.tuwien.big.momot.lang.jvmmodel.MOMoTJvmModelInferrer.*
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction
import at.ac.tuwien.big.momot.TransformationResultManager
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension
import at.ac.tuwien.big.momot.util.MomotUtil
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction
import at.ac.tuwien.big.momot.search.solution.repair.ITransformationRepairer
import at.ac.tuwien.big.momot.TransformationSearchOrchestration
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue
import at.ac.tuwien.big.momot.search.fitness.dimension.OCLQueryDimension
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.IEObjectEqualityHelper
import org.eclipse.emf.henshin.interpreter.EGraph

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class MOMoTJvmModelInferrer extends AbstractModelInferrer {

    /**
     * convenience API to build and initialize JVM types and their members.
     */
	@Inject extension JvmTypesBuilder
	
	static val FIELD_INITIAL_MODEL = "INITIAL_MODEL"
	static val FIELD_SOLUTION_LENGTH = "SOLUTION_LENGTH"
	
	static val FIELD_MODULES = "modules"
	static val FIELD_UNITS_TO_REMOVE = "unitsToRemove"
	static val FIELD_NON_SOLUTION_PARAMETERS = "nonSolutionParameters"
	static val FIELD_SOLUTION_REPAIRER = "solutionRepairer"
	static val FIELD_FITNESS_FUNCTION = "fitnessFunction"
	static val FIELD_POPULATION_SIZE = "populationSize"
	static val FIELD_MAX_EVALUATIONS = "maxEvaluations"
	static val FIELD_NR_RUNS = "nrRuns"
	static val FIELD_REFERENCE_SET = "referenceSet"
	static val FIELD_SIGNIFICANCE_LEVEL = "significanceLevel"
	static val FIELD_CREATE_PARAMETER_VALUE_KEY = "_parameterValueKey_"
	
	static val METHOD_CREATE_MODULE_MANAGER = "createModuleManager"
	static val METHOD_CREATE_FITNESS_FUNCTION = "createFitnessFunction"
	static val METHOD_CREATE_OBJECTIVE_PREFIX = "_createObjective_"
	static val METHOD_CREATE_OBJECTIVE_HELPER_PREFIX = "_createObjectiveHelper_"
	static val METHOD_CREATE_CONSTRAINT_PREFIX = "_createConstraint_"
	static val METHOD_CREATE_CONSTRAINT_HELPER_PREFIX = "_createConstraintHelper_"
	static val METHOD_CREATE_LISTENER_PREFIX = "_createListener_"
	static val METHOD_CREATE_COLLECTOR_PREFIX = "_createCollector_"
	static val METHOD_CREATE_EQUALITY_HELPER = "_createEqualityHelper_"
	static val METHOD_CREATE_EQUALITY_HELPER_HELPER = "_createEqualityHelperHelper_"
	static val METHOD_CREATE_PARAMETER_VALUE_PREFIX = "_createParameterValue_"
	static val METHOD_CREATE_ALGORITHM_PREFIX = "_createRegisteredAlgorithm_"
	static val METHOD_CREATE_ALGORITHM_HELPER_PREFIX = "_createAlgorithm_"
	static val METHOD_MAIN = "main"
	static val METHOD_INIT = "init"
	static val METHOD_PERFORM_SEARCH = "performSearch"
	static val METHOD_CREATE_ORCHESTRATION = "createOrchestration"
	static val METHOD_CREATE_EXPERIMENT = "createExperiment"
	static val METHOD_PERFORM_ANALYSIS = "performAnalysis"
	static val METHOD_HANDLE_RESULTS = "handleResults"	
	static val METHOD_CUSTOM_HANDLE_RESULTS = "customHandleResults"	
	static val METHOD_FITNESS_PREPROCESS = "preprocessEvaluation"
	static val METHOD_FITNESS_POSTPROCESS = "postprocessEvaluation"
	
	static val PARAM_INITIAL_GRAPH = "initialGraph"
	static val PARAM_SOLUTION_LENGTH = "solutionLength"
	static val PARAM_ORCHESTRATION = "orchestration"
	static val PARAM_MOEA_FACTORY = "moea"
	static val PARAM_LOCAL_FACTORY = "local"
	static val PARAM_EXPERIMENT = "experiment"
	static val PARAM_RESULT_MANAGER = "resultManager"
	static val PARAM_SOLUTION = "solution"
	static val PARAM_AGGREGATED_FITNESS = "aggregatedFitness"
	static val PARAM_GRAPH = "graph"
	static val PARAM_ROOT = "root"
	static val PARAM_EQUALITY_LEFT = "left"
	static val PARAM_EQUALITY_RIGHT = "right"
	
   					
	var Map<ParmeterValueSpecification, String> parameterValueMethods = new HashMap
	var Map<ParmeterValueSpecification, String> parameterKeyFields = new HashMap
	var Map<FitnessDimensionSpecification, String> dimensionMethods = new HashMap
	var Map<FitnessDimensionSpecification, String> dimensionHelperMethods = new HashMap
	var Map<XExpression, String> listenerMethods = new HashMap
	var Map<XExpression, String> collectorMethods = new HashMap
	var Map<AlgorithmSpecification, String> algorithmMethods = new HashMap
	var Map<AlgorithmSpecification, String> algorithmHelperMethods = new HashMap
	var Map<EObject, String> names = new HashMap
	
	def void initNames(MOMoTSearch it) {
		parameterValueMethods.clear
		parameterKeyFields.clear
		dimensionMethods.clear
		dimensionHelperMethods.clear
		listenerMethods.clear
		collectorMethods.clear
		algorithmMethods.clear
		algorithmHelperMethods.clear
		names.clear
			
		var index = 0;
		if(searchOrchestration != null && 
			searchOrchestration.transformationOrchestration != null &&
			searchOrchestration.transformationOrchestration.parameterValues != null)
			for(parameterValue : searchOrchestration?.transformationOrchestration?.parameterValues) {
				parameterValueMethods.put(parameterValue, METHOD_CREATE_PARAMETER_VALUE_PREFIX  + index)
				parameterKeyFields.put(parameterValue, FIELD_CREATE_PARAMETER_VALUE_KEY + index)
				index++
			}
		
		index = 0;
		for(objective : searchOrchestration?.fitnessFunction?.objectives) {
			dimensionMethods.put(objective, METHOD_CREATE_OBJECTIVE_PREFIX + index)
			dimensionHelperMethods.put(objective, METHOD_CREATE_OBJECTIVE_HELPER_PREFIX + index++)
		}
		
		index = 0
		for(constraint : searchOrchestration?.fitnessFunction?.constraints) {
			dimensionMethods.put(constraint, METHOD_CREATE_CONSTRAINT_PREFIX + index)
			dimensionHelperMethods.put(constraint, METHOD_CREATE_CONSTRAINT_HELPER_PREFIX + index++)
		}		
		
		index = 0;
		for(algorithm : searchOrchestration?.algorithms?.specifications) {
			algorithmMethods.put(algorithm, METHOD_CREATE_ALGORITHM_PREFIX + index)
			algorithmHelperMethods.put(algorithm, METHOD_CREATE_ALGORITHM_HELPER_PREFIX + index++)
		}
		
		index = 0
		for(listener : experimentOrchestration?.progressListeners)
			listenerMethods.put(listener, METHOD_CREATE_LISTENER_PREFIX + index++)

		index = 0
		for(collector : experimentOrchestration?.customCollectors)
			collectorMethods.put(collector, METHOD_CREATE_COLLECTOR_PREFIX + index++)
			
		names.put(it, basePath + "Search")
		if(searchOrchestration != null) {
			names.put(searchOrchestration, basePath + "SearchOrchestration")
			if(searchOrchestration.fitnessFunction != null) 
				names.put(searchOrchestration.fitnessFunction, baseName + "FitnessFunction")
		}
	}
	
	def getMethodName(ParmeterValueSpecification it) { 
   		parameterValueMethods.get(it)
   	}
   	
   	def getFieldName(ParmeterValueSpecification it) { 
   		parameterKeyFields.get(it)
   	}
   	
   	def getMethodName(FitnessDimensionSpecification it) { 
   		dimensionMethods.get(it)
   	}
   	
   	def getHelperMethodName(FitnessDimensionSpecification it) { 
   		dimensionHelperMethods.get(it)
   	}
   	
   	def getListenerMethodName(XExpression it) { 
   		listenerMethods.get(it)
   	}
   	
   	def getCollectorMethodName(XExpression it) { 
   		collectorMethods.get(it)
   	}
   	
   	def getMethodName(AlgorithmSpecification it) { 
   		algorithmMethods.get(it)
   	}

   	def getHelperMethodName(AlgorithmSpecification it) { 
   		algorithmHelperMethods.get(it)
   	}
	
	def getBaseName(MOMoTSearch it) {
		name ?: eResource.URI.trimFileExtension.lastSegment
	}
	
	def getBasePath(MOMoTSearch it) {
		if(package == null)
			baseName
		else
			package + "." + baseName
	}
	
	def getJavaClassName(MOMoTSearch it) {
		names.get(it)
	}
	
	def getJavaClassName(SearchOrchestration it) {
		names.get(it)
	}
	
	def getJavaClassName(FitnessFunctionSpecification it) {
		names.get(it)
	}
	
	def getDirection(FitnessDimensionSpecification it) {
		if(type == FitnessDimensionType.MAXIMIZE)
			return FunctionType.Maximum
		return FunctionType.Minimum
	}
	
	def getFQN(FunctionType it) {
		class.canonicalName + "." + name
	}
	
	def needsClass(FitnessFunctionSpecification it) {
		preprocess != null || postprocess != null
	}
	
	def getSuperConstructorRef(FitnessFunctionSpecification it) {
   		return typeRef(EGraphMultiDimensionalFitnessFunction)
	}
	
	def getConstructorRef(FitnessFunctionSpecification it) {
	 	if(needsClass)
  			return typeRef(javaClassName)
  		return typeRef(EGraphMultiDimensionalFitnessFunction)
	}
	
	def append(TargetStringConcatenation it, Object... objects) {
		for(Object obj : objects)
			append(obj)
	}
	
	def appendLine(TargetStringConcatenation it, Object... objects) {
		for(Object obj : objects)
			append(obj)
		newLine
	}
	
	def appendLine(TargetStringConcatenation it, Object object) {
		append(object)
		newLine
	}
	
	def asString(AlgorithmReferences it) {
		if(it == null || elements == null || elements.isEmpty)
			return ""
		elements.map[a | "\"" + a.name + "\""].join(', ')
	}
	
	def hasAlgorithms(SaveObjectivesCommand it) {
		algorithms != null && !algorithms.elements.isEmpty
	}

   def dispatch void infer(MOMoTSearch search, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
   	search.initNames
   	 
      val searchOrchestration = search.getSearchOrchestration
    	val transformations = search.searchOrchestration?.transformationOrchestration	
   	val fitnessFunction = searchOrchestration?.fitnessFunction		
   	val experiment = search.getExperimentOrchestration
   	val analysis = search.getAnalysisOrchestration
   	val resultManagement = search.resultManagement
   		
   	val voidRef = typeRef(void)
		val doubleRef = typeRef(double)
		val intRef = typeRef(int)
		val booleanRef = typeRef(boolean)
		val stringRef = typeRef(String)
		val resultManagerRef = typeRef(TransformationResultManager)
		val algorithmRef = typeRef(Algorithm)
		val searchExperimentRef = typeRef(SearchExperiment)
		val listenerRef = typeRef(ProgressListener)
		val collectorRef = typeRef(Collector)
		val stringArrayRef = typeRef(String).addArrayTypeDimension
		val graphDimensionRef = typeRef(AbstractEGraphFitnessDimension)
		val momotUtilRef = typeRef(MomotUtil)
		val eObjectRef = typeRef(EObject)
		val eGraphRef = typeRef(EGraph)
		val transformationSolutionRef = typeRef(TransformationSolution)
		val fitnessDimensionRef = typeRef(IFitnessDimension, typeRef(TransformationSolution))
		val fitnessFunctionInterfaceRef = typeRef(IEGraphMultiDimensionalFitnessFunction)
		val transformationRepairerRef = typeRef(ITransformationRepairer)
		val searchOrchestrationRef = typeRef(TransformationSearchOrchestration)
		val parameterValueRef = typeRef(IParameterValue)
		val oclQueryDimensionRef = typeRef(OCLQueryDimension)
	   	val parserExceptionRef = typeRef(ParserException)
	   	val moduleManagerRef = typeRef(ModuleManager)
	   	val moeaFactoryRef = typeRef(EvolutionaryAlgorithmFactory, typeRef(TransformationSolution))
	   	val localFactoryRef = typeRef(LocalSearchAlgorithmFactory, typeRef(TransformationSolution))
	   	val registeredAlgorithmInterfaceRef = typeRef(IRegisteredAlgorithm)   			
	   	val registeredAlgorithmRef = typeRef(RegisteredAlgorithm)
	   	val ioExceptionRef = typeRef(IOException)
		val searchAnalysisRef = typeRef(SearchAnalysis)
	   	val searchAnalyzerRef = typeRef(SearchAnalyzer)
	   	val fileRef = typeRef(File)
	   	val iEObjectEqualityHelper = typeRef(IEObjectEqualityHelper)
   		
   		acceptor.accept(search.toClass(search.javaClassName)) [
   			members += searchOrchestration.toField(MOMoTJvmModelInferrer.FIELD_INITIAL_MODEL, stringRef) [
					static = true
					final = true
					visibility = JvmVisibility::PROTECTED
					initializer = searchOrchestration.model
				]
			
			
	   		members += searchOrchestration.toField(FIELD_SOLUTION_LENGTH, intRef) [
	   			static = true
	   			final = true
	   			visibility = JvmVisibility::PROTECTED
	   			initializer = searchOrchestration.solutionLength
	   		]
	   		
	   		for (declaredVariable : search.variables) {
				val type = declaredVariable.type 
						?: declaredVariable?.init?.inferredType
						?: stringRef
				members += declaredVariable.toField (declaredVariable.name, type) [
					static = true
					visibility = JvmVisibility::PROTECTED
					initializer = declaredVariable.init
				]
			}
			
			var JvmGenericType fitnessFunctionClass = null
   			if(fitnessFunction.needsClass) {
   				fitnessFunctionClass = fitnessFunction.toClass(fitnessFunction.javaClassName) [
	   				superTypes += fitnessFunction.superConstructorRef
	   				
	   				if(fitnessFunction.preprocess != null)
		   				members += fitnessFunction.preprocess.toMethod(METHOD_FITNESS_PREPROCESS, voidRef) [
		   					visibility = JvmVisibility::PROTECTED
		   					annotations += annotationRef(Override)
		   					parameters += fitnessFunction.preprocess.toParameter(PARAM_SOLUTION, transformationSolutionRef)
	   						
		   					body = fitnessFunction.preprocess
		   				]
		   				
	   				if(fitnessFunction.postprocess != null)
		   				members += fitnessFunction.preprocess.toMethod(METHOD_FITNESS_POSTPROCESS, voidRef) [
		   					visibility = JvmVisibility::PROTECTED
		   					annotations += annotationRef(Override)
		   					parameters += fitnessFunction.preprocess.toParameter(PARAM_SOLUTION, transformationSolutionRef)
		   					parameters += fitnessFunction.preprocess.toParameter(PARAM_AGGREGATED_FITNESS, doubleRef)
		   					body = fitnessFunction.postprocess
		   				]
   				]
   				members += fitnessFunctionClass
   			}
	   		
   			members += transformations.modules.toField(FIELD_MODULES, stringArrayRef) [
				final = true
				visibility = JvmVisibility::PROTECTED
				initializer = transformations.modules
			]
   			
   			if(transformations.unitsToRemove != null)
				members += transformations.unitsToRemove.toField(FIELD_UNITS_TO_REMOVE, stringArrayRef) [
					final = true
					visibility = JvmVisibility::PROTECTED
					initializer = transformations.unitsToRemove
				]

	   		if(searchOrchestration.fitnessFunction.constructor != null && !searchOrchestration.fitnessFunction.needsClass)
	   			members += searchOrchestration.fitnessFunction.constructor.toField(FIELD_FITNESS_FUNCTION, fitnessFunctionInterfaceRef) [
	   				final = true
	   				visibility = JvmVisibility::PROTECTED
	   				initializer = searchOrchestration.fitnessFunction.constructor
	   			]
   			
   			for(parameter : transformations.parameterValues) 
   				members += parameter.name.toField(parameter.fieldName, stringRef) [
   					final = true
   					visibility = JvmVisibility::PROTECTED
   					initializer = parameter.name
   				]
   			
   			if(transformations.nonSolutionParameters != null)
				members += transformations.nonSolutionParameters.toField(at.ac.tuwien.big.momot.lang.jvmmodel.MOMoTJvmModelInferrer.FIELD_NON_SOLUTION_PARAMETERS, stringArrayRef) [
	   				final = true
	   				visibility = JvmVisibility::PROTECTED
	   				initializer = transformations.nonSolutionParameters
	   			]
   					   		
	   		if(searchOrchestration.fitnessFunction.solutionRepairer != null)
	   			members += searchOrchestration.fitnessFunction.solutionRepairer.toField(FIELD_SOLUTION_REPAIRER, transformationRepairerRef) [
	   				final = true
	   				visibility = JvmVisibility::PROTECTED
	   				initializer = searchOrchestration.fitnessFunction.solutionRepairer
	   			]
   			   			
   			if(experiment.populationSize != 0)
	   			members += search.toField(FIELD_POPULATION_SIZE, intRef) [
	   				final = true
	   				visibility = JvmVisibility::PROTECTED
	   				initializer = experiment.populationSize
	   			]
   			
   			members += search.toField(FIELD_MAX_EVALUATIONS, intRef) [
   				final = true
   				visibility = JvmVisibility::PROTECTED
   				initializer = experiment.maxEvaluations
   			]
   			
   			members += search.toField(FIELD_NR_RUNS, intRef) [
   				final = true
   				visibility = JvmVisibility::PROTECTED
   				initializer = experiment.nrRuns
   			]
   			
   			if(experiment.referenceSet != null)
	   			members += search.toField(FIELD_REFERENCE_SET, stringRef) [
	   				final = true
	   				visibility = JvmVisibility::PROTECTED
	   				initializer = experiment.referenceSet
	   			]

			for(parameter : transformations.parameterValues) 
	   			members += parameter.call.toMethod(parameter.methodName, parameterValueRef) [
   					visibility = JvmVisibility::PROTECTED
   					body = parameter.call
   				]

 			val dimensions = searchOrchestration.fitnessFunction.objectives + searchOrchestration.fitnessFunction.constraints  			
   			for(dimension : dimensions) {
   				val name = dimension.name
   				if(dimension instanceof FitnessDimensionConstructor) {
	   				members += dimension.call.toMethod(dimension.helperMethodName, fitnessDimensionRef) [
   						visibility = JvmVisibility::PROTECTED
   						body = dimension.call
   					]
   					
   					members += dimension.call.toMethod(dimension.methodName, fitnessDimensionRef) [
   						visibility = JvmVisibility::PROTECTED
   						parameters += search.toParameter(PARAM_ORCHESTRATION, searchOrchestrationRef)
   						body = new StringConcatenationClient() {
							override protected appendTo(TargetStringConcatenation it) {
								appendLine(fitnessDimensionRef.type, " dimension = ", dimension.helperMethodName, "();");
								appendLine("dimension.setName(\"", name, "\");");
								appendLine("dimension.setFunctionType(", dimension.direction.FQN, ");");
								appendLine("return dimension;");
	   						}
	   					}
   					]
   				} else if(dimension instanceof FitnessDimensionXBase) {
   					members += dimension.value.toMethod(dimension.helperMethodName,	doubleRef) [
   						visibility = JvmVisibility::PROTECTED
   						
   						parameters += searchOrchestration.toParameter(PARAM_SOLUTION, transformationSolutionRef)
   						parameters += searchOrchestration.toParameter(PARAM_GRAPH, eGraphRef)
   						parameters += searchOrchestration.toParameter(PARAM_ROOT, eObjectRef)
   						body = dimension.value
   					]  					
   					
   					members += dimension.value.toMethod(dimension.methodName, fitnessDimensionRef) [
   						visibility = JvmVisibility::PROTECTED
   						parameters += search.toParameter(PARAM_ORCHESTRATION, searchOrchestrationRef)
   						body = new StringConcatenationClient() {
							override protected appendTo(TargetStringConcatenation it) {
								appendLine("return new ", graphDimensionRef.type, "(\"", name, "\", ", dimension.direction.FQN, ") {");
								appendLine("   @Override");
								appendLine("   protected double internalEvaluate(", transformationSolutionRef.type, " ", PARAM_SOLUTION, ") {");
								appendLine("		", eGraphRef, " ", PARAM_GRAPH, " = ", PARAM_SOLUTION, ".execute();")
								appendLine("      ", eObjectRef, " root = ", momotUtilRef.type, ".getRoot(", PARAM_GRAPH, ");")
								appendLine("      return ", dimension.helperMethodName, "(", PARAM_SOLUTION, ", ", PARAM_GRAPH, ", ", PARAM_ROOT, ");");
								appendLine("   }");
								appendLine("};");
	   						}
	   					}
   					]
   				} else if(dimension instanceof FitnessDimensionOCL) {
   					val oclDimension = dimension as FitnessDimensionOCL

   					members += oclDimension.query.toMethod(dimension.methodName, fitnessDimensionRef) [
   						visibility = JvmVisibility::PROTECTED
   						parameters += search.toParameter(PARAM_ORCHESTRATION, searchOrchestrationRef)
   						body = new StringConcatenationClient() {
							override protected appendTo(TargetStringConcatenation it) {
								
								val query = (oclDimension.query as XStringLiteral).value
								appendLine("try {")
								append("   return new ", oclQueryDimensionRef.type, "(\"", name, "\", ", oclDimension.direction.FQN, ", \"", query, "\", ", PARAM_ORCHESTRATION, ".createOCLHelper()");
								for(String defExpression : oclDimension.defExpressions.map[e | e.expression])
									append(", \"", defExpression, "\"")
								appendLine(");");
								appendLine("} catch(", parserExceptionRef.type, " e) {")
								appendLine("   e.printStackTrace();")
								appendLine("}")
								appendLine("return null;")
	   						}
	   					}
   					]
   				}
   			}
   			
   			
   			members += searchOrchestration.toMethod(METHOD_CREATE_MODULE_MANAGER, moduleManagerRef) [
   				visibility = JvmVisibility::PROTECTED
   				body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(moduleManagerRef.type, " manager = new ", moduleManagerRef.type, "();");
   						appendLine("manager.addModules(", FIELD_MODULES, ");");
   						if(transformations.unitsToRemove != null)
   							appendLine("manager.removeUnits(", FIELD_UNITS_TO_REMOVE, ");");
   						if(transformations.nonSolutionParameters != null)
   							appendLine("manager.addNonSolutionParameters(", FIELD_NON_SOLUTION_PARAMETERS, ");");
   						for(p : transformations.parameterValues)
   							appendLine("manager.setParameterValue(", p.fieldName, ", ", p.methodName, "());")
   						appendLine("return manager;");
	   				}
	   			}
   			]
   			
   			val fitnessFunctionRef = if(fitnessFunctionClass != null) fitnessFunctionClass.typeRef else typeRef(EGraphMultiDimensionalFitnessFunction)
   			members += searchOrchestration.toMethod(METHOD_CREATE_FITNESS_FUNCTION, fitnessFunctionInterfaceRef) [
   				visibility = JvmVisibility::PROTECTED
   				parameters += search.toParameter(PARAM_ORCHESTRATION, searchOrchestrationRef)
   				body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						if(searchOrchestration.fitnessFunction.constructor != null && !searchOrchestration.fitnessFunction.needsClass) {
   							appendLine(fitnessFunctionInterfaceRef.type, " function = ", FIELD_FITNESS_FUNCTION, ";");
   						} else {
   							appendLine(fitnessFunctionInterfaceRef.type, " function = new ", fitnessFunctionRef.type, "();");
						} 
						for(objective : searchOrchestration.fitnessFunction.objectives)
   							appendLine("function.addObjective(", objective.methodName, "(", PARAM_ORCHESTRATION, "));");
   						for(constraint : searchOrchestration.fitnessFunction.constraints) 
   							appendLine("function.addConstraint(", constraint.methodName, "(", PARAM_ORCHESTRATION, "));");
   						if(searchOrchestration.fitnessFunction.solutionRepairer != null)
   							appendLine("function.setSolutionRepairer(", FIELD_SOLUTION_REPAIRER, ");");
   						appendLine("return function;");
	   				}
	   			}
   			]   			
   			
   			for(algorithm : searchOrchestration.algorithms.specifications) {
   				val type = algorithm.call.inferredType ?: registeredAlgorithmInterfaceRef
   				
				val algorithmMethod = search.toMethod(algorithm.methodName, type) [
					visibility = JvmVisibility::PROTECTED
					parameters += search.toParameter(PARAM_ORCHESTRATION, searchOrchestrationRef)
	   				parameters += search.toParameter(PARAM_MOEA_FACTORY, moeaFactoryRef)
	   				parameters += search.toParameter(PARAM_LOCAL_FACTORY, localFactoryRef)
	   				body = algorithm.call
	   			]
	   			members += algorithmMethod
	   			
	   			if(algorithm.call instanceof XConstructorCall) {
	   				algorithmMethod.simpleName = algorithm.helperMethodName
	   				
	   				members += search.toMethod(algorithm.methodName, registeredAlgorithmInterfaceRef) [
	   					visibility = JvmVisibility::PROTECTED
	   					parameters += search.toParameter(PARAM_ORCHESTRATION, searchOrchestrationRef)
	   					parameters += search.toParameter(PARAM_MOEA_FACTORY, moeaFactoryRef)
	   					parameters += search.toParameter(PARAM_LOCAL_FACTORY, localFactoryRef)
	   					body = new StringConcatenationClient() {
								override protected appendTo(TargetStringConcatenation it) {
									appendLine("return new ", registeredAlgorithmRef.type, "<Algorithm>() {");
									appendLine("   @Override");
									appendLine("   public ", algorithmRef.type, " createAlgorithm() {");
									appendLine("      return ", algorithm.helperMethodName, "(",  PARAM_ORCHESTRATION, ", ", PARAM_MOEA_FACTORY, ", ", PARAM_LOCAL_FACTORY, ");");
									appendLine("   }");
									appendLine("};");
								}
						}
	   				]										
				} 
			}
   			
   			for(listener : experiment.progressListeners) {
   				members += search.toMethod(listener.listenerMethodName, listenerRef) [
   					visibility = JvmVisibility::PROTECTED
   					body = listener
   				]
   			}
   			
   			for(collector : experiment.customCollectors) {
   				members += search.toMethod(collector.collectorMethodName, collectorRef) [
   					body = collector
   				]
   			}
   			
   			if(searchOrchestration.equalityHelper != null) {
   				if(searchOrchestration.equalityHelper.method != null) {
   					members += searchOrchestration.equalityHelper.method.toMethod(METHOD_CREATE_EQUALITY_HELPER_HELPER, booleanRef) [
   						visibility = JvmVisibility::PROTECTED
   						parameters += searchOrchestration.equalityHelper.method.toParameter(PARAM_EQUALITY_LEFT, eObjectRef)
   						parameters += searchOrchestration.equalityHelper.method.toParameter(PARAM_EQUALITY_RIGHT, eObjectRef)
   						body = searchOrchestration.equalityHelper.method
   					]
   					members += searchOrchestration.equalityHelper.method.toMethod(METHOD_CREATE_EQUALITY_HELPER, iEObjectEqualityHelper) [
   						visibility = JvmVisibility::PROTECTED
   						body = new StringConcatenationClient() {
								override protected appendTo(TargetStringConcatenation it) {
									appendLine("return new ", iEObjectEqualityHelper.type, "() {");
									appendLine("   @Override");
									appendLine("   public ", booleanRef.type, " equals(EObject left, EObject right) {");
									appendLine("      return ", METHOD_CREATE_EQUALITY_HELPER_HELPER, "(left, right);");
									appendLine("   }");
									appendLine("};");
								}
							}
   					]
   				}
   				else if(searchOrchestration.equalityHelper.call != null) {
   					members += searchOrchestration.equalityHelper.call.toMethod(METHOD_CREATE_EQUALITY_HELPER, iEObjectEqualityHelper) [
   						visibility = JvmVisibility::PROTECTED
   						body = searchOrchestration.equalityHelper.call
   					]
   				}
   			}
   			
   			members += search.toMethod(METHOD_CREATE_ORCHESTRATION, searchOrchestrationRef) [
   				visibility = JvmVisibility::PROTECTED
   				parameters += searchOrchestration.toParameter(PARAM_INITIAL_GRAPH, stringRef)
   				parameters += searchOrchestration.toParameter(PARAM_SOLUTION_LENGTH, intRef)
   				body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(searchOrchestrationRef.type, " ", PARAM_ORCHESTRATION, " = new ", searchOrchestrationRef.type, "();");
						appendLine(PARAM_ORCHESTRATION, ".setModuleManager(", METHOD_CREATE_MODULE_MANAGER, "());")
						appendLine(PARAM_ORCHESTRATION, ".setProblemGraph(", PARAM_INITIAL_GRAPH, ");")
						appendLine(PARAM_ORCHESTRATION, ".setSolutionLength(", PARAM_SOLUTION_LENGTH, ");")
   						appendLine(PARAM_ORCHESTRATION, ".setFitnessFunction(", METHOD_CREATE_FITNESS_FUNCTION, "(", PARAM_ORCHESTRATION, "));");
						if(searchOrchestration.equalityHelper != null)
							appendLine(PARAM_ORCHESTRATION, ".setEqualityHelper(", METHOD_CREATE_EQUALITY_HELPER, "());")
						newLine
						appendLine(moeaFactoryRef.type, " ", PARAM_MOEA_FACTORY, " = ", PARAM_ORCHESTRATION, ".createEvolutionaryAlgorithmFactory(", FIELD_POPULATION_SIZE, ");")
						appendLine(localFactoryRef.type, " ", PARAM_LOCAL_FACTORY, " = ", PARAM_ORCHESTRATION, ".createLocalSearchAlgorithmFactory();")
						for(algorithm : searchOrchestration.algorithms.specifications) 
							appendLine(PARAM_ORCHESTRATION, ".addAlgorithm(\"" + algorithm.name + "\", ", 
								algorithm.methodName, "(",  PARAM_ORCHESTRATION, ", ", PARAM_MOEA_FACTORY, ", ", PARAM_LOCAL_FACTORY, "));");
						newLine
						appendLine("return ", PARAM_ORCHESTRATION, ";");
					}
				}
   			]
   			
   			members += search.toMethod(METHOD_CREATE_EXPERIMENT, searchExperimentRef) [
   				visibility = JvmVisibility::PROTECTED
   				parameters += search.toParameter(PARAM_ORCHESTRATION, searchOrchestrationRef)
   				body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(searchExperimentRef.type, " experiment = new ", searchExperimentRef.type, "(", PARAM_ORCHESTRATION, ", ", FIELD_MAX_EVALUATIONS + ");");
						if(experiment.referenceSet != null)
							appendLine("experiment.setReferenceSetFile(", FIELD_REFERENCE_SET, ");")
						appendLine("experiment.setNumberOfRuns(", FIELD_NR_RUNS, ");")
						for(listener : experiment.progressListeners)
							appendLine("experiment.addProgressListener(", listener.listenerMethodName, "());")
						for(customCollector : experiment.customCollectors)
							appendLine("experiment.addCustomCollector(", customCollector.collectorMethodName, "());")
						if(experiment.collectors != null) {
							if(experiment.collectors.additiveEpsilonIndicator)
								appendLine("experiment.setAdditiveEpsilonIndicator(true);")
							if(experiment.collectors.hypervolume)
								appendLine("experiment.setHypervolume(true);")
							if(experiment.collectors.generationalDistance)
								appendLine("experiment.setGenerationalDistance(true);")
							if(experiment.collectors.invertedGenerationalDistance)
								appendLine("experiment.setInvertedGenerationalDistance(true);")
							if(experiment.collectors.spacing)
								appendLine("experiment.setSpacing(true);")
							if(experiment.collectors.contribution)
								appendLine("experiment.setContribution(true);")
							if(experiment.collectors.r1)
								appendLine("experiment.setR1(true);")
							if(experiment.collectors.r2)
								appendLine("experiment.setR2(true);")
							if(experiment.collectors.r3)
								appendLine("experiment.setR3(true);")
							if(experiment.collectors.adaptiveMultimethodVariation)
								appendLine("experiment.setAdaptiveMultimethodVariation(true);")
							if(experiment.collectors.adaptiveTimeContinuation)
								appendLine("experiment.setAdaptiveTimeContinuation(true);")
							if(experiment.collectors.approximationSet)
								appendLine("experiment.setApproximationSet(true);")
							if(experiment.collectors.epsilonProgress)
								appendLine("experiment.setEpsilonProgress(true);")
							if(experiment.collectors.elapsedTime)
								appendLine("experiment.setElapsedTime(true);")
							if(experiment.collectors.populationSize)
								appendLine("experiment.setPopulationSize(true);")
						}
						appendLine("return experiment;")
					}
				}
   			]
   			
   			
   			if(analysis != null) {
   				members += analysis.significance.toField(FIELD_SIGNIFICANCE_LEVEL, doubleRef) [
	   				visibility = JvmVisibility::PROTECTED
	   				initializer = analysis.significance
   				]
   				
	   			members += analysis.toMethod(METHOD_PERFORM_ANALYSIS, searchAnalyzerRef) [
	   				visibility = JvmVisibility::PROTECTED
	   				parameters += search.toParameter(PARAM_EXPERIMENT, searchExperimentRef)
	   				body = new StringConcatenationClient() {
						override protected appendTo(TargetStringConcatenation it) {
							appendLine(searchAnalysisRef.type, " analysis = new ", searchAnalysisRef.type, "(", PARAM_EXPERIMENT, ");");
							if(analysis.indicators != null) {
								if(analysis.indicators.additiveEpsilonIndicator)
									appendLine("analysis.setAdditiveEpsilonIndicator(true);")
								if(analysis.indicators.hypervolume)
									appendLine("analysis.setHypervolume(true);")
								if(analysis.indicators.generationalDistance)
									appendLine("analysis.setGenerationalDistance(true);")
								if(analysis.indicators.invertedGenerationalDistance)
									appendLine("analysis.setInvertedGenerationalDistance(true);")
								if(analysis.indicators.spacing)
									appendLine("analysis.setSpacing(true);")
								if(analysis.indicators.contribution)
									appendLine("analysis.setContribution(true);")
								if(analysis.indicators.r1)
									appendLine("analysis.setR1(true);")
								if(analysis.indicators.r2)
									appendLine("analysis.setR2(true);")
								if(analysis.indicators.r3)
									appendLine("analysis.setR3(true);")
								if(analysis.indicators.maximumParetoFrontError)
									appendLine("analysis.setMaximumParetoFrontError(true);")
							}
							if(analysis.show != null) {
								if(analysis.show.aggregate)
									appendLine("analysis.setShowAggregate(true);")
								if(analysis.show.individual)
									appendLine("analysis.setShowIndividualValues(true);")
								if(analysis.show.statisticalSignificance)
									appendLine("analysis.setShowStatisticalSignificance(true);")
							}
							appendLine("analysis.setSignificanceLevel(", FIELD_SIGNIFICANCE_LEVEL, ");")
							appendLine("return analysis.analyze();")
						}
					}
	   			]
	   		}
	   		
	   		if(resultManagement != null) {
		   		if(resultManagement.doCommand != null) {
	   				members += resultManagement.doCommand.toMethod(METHOD_CUSTOM_HANDLE_RESULTS, voidRef) [
	   					visibility = JvmVisibility::PROTECTED
	   					parameters += resultManagement.doCommand.toParameter(PARAM_RESULT_MANAGER, resultManagerRef)
	   					body =resultManagement.doCommand
	   				]
	   			}
   			
	   			members += resultManagement.toMethod(METHOD_HANDLE_RESULTS, resultManagerRef) [
	   				visibility = JvmVisibility::PROTECTED
	   				parameters += search.toParameter(PARAM_EXPERIMENT, searchExperimentRef)
	   				body = new StringConcatenationClient() {
						override protected appendTo(TargetStringConcatenation it) {
							appendLine(resultManagerRef.type, " resultManager = new ", resultManagerRef.type, "(", PARAM_EXPERIMENT, ");");
							if(resultManagement.saveObjectives != null) {
								for(command : resultManagement.saveObjectives) {
									append(PARAM_RESULT_MANAGER, ".saveApproximationSetObjectives(\"", command.getFile, "\"")
									if(command.hasAlgorithms) 
										append(", ", command.getAlgorithms.asString, "")
									appendLine(");")
								}
							}
							if(resultManagement.saveSolutions != null) {
								for(command : resultManagement.saveSolutions) {
									appendLine(PARAM_RESULT_MANAGER, ".setBaseDirectory(\"", command.getDirectory, "\");")
									appendLine(PARAM_RESULT_MANAGER, ".saveApproximationSetGraphs(", command.getAlgorithms.asString, ");")
								}
							}
							if(resultManagement.printSolutions != null) {
								for(command : resultManagement.printSolutions) {
									appendLine("System.out.println(", PARAM_RESULT_MANAGER, ".printApproximationSet(", command.algorithms.asString, "));")
								}
							}
							if(resultManagement.printObjectives != null) {
								for(command : resultManagement.printObjectives) {
									appendLine("System.out.println(", PARAM_RESULT_MANAGER, ".printApproximationSetObjectives(", command.getAlgorithms.asString, "));")
								}
							}
							if(resultManagement.doCommand != null)
								appendLine(METHOD_CUSTOM_HANDLE_RESULTS, "(", PARAM_RESULT_MANAGER, ");")
							appendLine("return ", PARAM_RESULT_MANAGER, ";")
						}
					}
					
	   			]
   			}
   			
   			
   			members += search.toMethod(METHOD_PERFORM_SEARCH, voidRef) [
   				parameters += searchOrchestration.toParameter(PARAM_INITIAL_GRAPH, stringRef)
   				parameters += searchOrchestration.toParameter(PARAM_SOLUTION_LENGTH, intRef)
   				body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(searchOrchestrationRef.type, " ", PARAM_ORCHESTRATION, " = ", METHOD_CREATE_ORCHESTRATION ,"(", PARAM_INITIAL_GRAPH, ", ", PARAM_SOLUTION_LENGTH, ");");
						appendLine(searchExperimentRef.type, " ", PARAM_EXPERIMENT, " = ", METHOD_CREATE_EXPERIMENT, "(", PARAM_ORCHESTRATION, ");");
						appendLine("experiment.run();")
						if(analysis != null) {
							appendLine(searchAnalyzerRef.type, " analyzer = ", METHOD_PERFORM_ANALYSIS, "(", PARAM_EXPERIMENT, ");");
							if(resultManagement != null && resultManagement.saveAnalysis != null) {
								val saveFile = (resultManagement.saveAnalysis.file as XStringLiteral).value
								appendLine("try {")
								appendLine("   analyzer.saveAnalysis(new ", fileRef.type, "(\"", saveFile, "\"));")
								appendLine("} catch(", ioExceptionRef.type, " e) {")
								appendLine("   e.printStackTrace();")
								appendLine("}")
							}
						}
						if(resultManagement != null) 
							appendLine(METHOD_HANDLE_RESULTS, "(", PARAM_EXPERIMENT, ");");
					}		
   				}
   			]
   			
   			members += search.toMethod(METHOD_INIT, voidRef) [
   				static = true
   				body = search.initialization
   			]
   			
   			val searchClassRef = typeRef(search.javaClassName)
   			members += search.toMethod(METHOD_MAIN, voidRef) [
   				parameters += search.toParameter("args", stringArrayRef)
   				varArgs = true
   				static = true
   				body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(METHOD_INIT, "();");
						appendLine(searchClassRef.type, " search = new ", searchClassRef.type, "();");
						appendLine("search.", METHOD_PERFORM_SEARCH, "(", FIELD_INITIAL_MODEL, ", ", FIELD_SOLUTION_LENGTH, ");")
					}		
   				}
   			]
   		]
   	}
}

