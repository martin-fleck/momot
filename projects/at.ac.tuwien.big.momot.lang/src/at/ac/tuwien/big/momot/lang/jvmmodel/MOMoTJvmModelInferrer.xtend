package at.ac.tuwien.big.momot.lang.jvmmodel

import at.ac.tuwien.big.moea.SearchAnalysis
import at.ac.tuwien.big.moea.SearchExperiment
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzer
import at.ac.tuwien.big.moea.print.IPopulationWriter
import at.ac.tuwien.big.moea.print.ISolutionWriter
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory
import at.ac.tuwien.big.moea.search.algorithm.LocalSearchAlgorithmFactory
import at.ac.tuwien.big.moea.search.algorithm.provider.IRegisteredAlgorithm
import at.ac.tuwien.big.moea.search.algorithm.provider.RegisteredAlgorithm
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension
import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType
import at.ac.tuwien.big.momot.ModuleManager
import at.ac.tuwien.big.momot.TransformationResultManager
import at.ac.tuwien.big.momot.TransformationSearchOrchestration
import at.ac.tuwien.big.momot.lang.momot.AlgorithmReferences
import at.ac.tuwien.big.momot.lang.momot.AlgorithmSpecification
import at.ac.tuwien.big.momot.lang.momot.FitnessDimensionConstructor
import at.ac.tuwien.big.momot.lang.momot.FitnessDimensionOCL
import at.ac.tuwien.big.momot.lang.momot.FitnessDimensionSpecification
import at.ac.tuwien.big.momot.lang.momot.FitnessDimensionType
import at.ac.tuwien.big.momot.lang.momot.FitnessDimensionXBase
import at.ac.tuwien.big.momot.lang.momot.FitnessFunctionSpecification
import at.ac.tuwien.big.momot.lang.momot.MOMoTSearch
import at.ac.tuwien.big.momot.lang.momot.ModelsCommand
import at.ac.tuwien.big.momot.lang.momot.ObjectivesCommand
import at.ac.tuwien.big.momot.lang.momot.ParmeterValueSpecification
import at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand
import at.ac.tuwien.big.momot.lang.momot.SearchOrchestration
import at.ac.tuwien.big.momot.lang.momot.SolutionsCommand
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution
import at.ac.tuwien.big.momot.problem.unit.parameter.IParameterValue
import at.ac.tuwien.big.momot.problem.unit.parameter.comparator.IEObjectEqualityHelper
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension
import at.ac.tuwien.big.momot.search.fitness.dimension.OCLQueryDimension
import at.ac.tuwien.big.momot.search.solution.repair.ITransformationRepairer
import at.ac.tuwien.big.momot.util.MomotUtil
import com.google.inject.Inject
import java.io.File
import java.io.IOException
import java.util.Arrays
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.henshin.interpreter.EGraph
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
import org.moeaframework.core.Population
import org.moeaframework.util.progress.ProgressListener

import at.ac.tuwien.big.moea.experiment.analyzer.kneepoint.PopulationAnalyzer
import at.ac.tuwien.big.moea.experiment.analyzer.kneepoint.PopulationAnalyzer.FitnessComparison
import java.util.List
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet

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
			searchOrchestration.moduleOrchestration != null &&
			searchOrchestration.moduleOrchestration.parameterValues != null)
			for(parameterValue : searchOrchestration?.moduleOrchestration?.parameterValues) {
				parameterValueMethods.put(parameterValue, MOMoTInferrer::Name::METHOD_CREATE_PARAMETER_VALUE_PREFIX  + index)
				parameterKeyFields.put(parameterValue, MOMoTInferrer::Name::FIELD_CREATE_PARAMETER_VALUE_KEY + index)
				index++
			}
		
		index = 0;
		val objectives = searchOrchestration?.fitnessFunction?.objectives
		if(objectives != null)
			for(objective : objectives) {
				dimensionMethods.put(objective, MOMoTInferrer::Name::METHOD_CREATE_OBJECTIVE_PREFIX + index)
				dimensionHelperMethods.put(objective, MOMoTInferrer::Name::METHOD_CREATE_OBJECTIVE_HELPER_PREFIX + index++)
			}
		
		index = 0
		val constraints = searchOrchestration?.fitnessFunction?.constraints
		if(constraints != null)
			for(constraint : constraints) {
				dimensionMethods.put(constraint, MOMoTInferrer::Name::METHOD_CREATE_CONSTRAINT_PREFIX + index)
				dimensionHelperMethods.put(constraint, MOMoTInferrer::Name::METHOD_CREATE_CONSTRAINT_HELPER_PREFIX + index++)
			}		
		
		index = 0;
		val algorithmSpecs = searchOrchestration?.algorithms?.specifications
		if(algorithmSpecs != null)
			for(algorithm : algorithmSpecs) {
				algorithmMethods.put(algorithm, MOMoTInferrer::Name::METHOD_CREATE_ALGORITHM_PREFIX + index)
				algorithmHelperMethods.put(algorithm, MOMoTInferrer::Name::METHOD_CREATE_ALGORITHM_HELPER_PREFIX + index++)
			}
		
		index = 0
		val listeners = experimentOrchestration?.progressListeners
		if(listeners != null)
			for(listener : listeners)
				listenerMethods.put(listener, MOMoTInferrer::Name::METHOD_CREATE_LISTENER_PREFIX + index++)

		index = 0
		val collectors = experimentOrchestration?.customCollectors
		if(collectors != null)
			for(collector : collectors)
				collectorMethods.put(collector, MOMoTInferrer::Name::METHOD_CREATE_COLLECTOR_PREFIX + index++)
			
		names.put(it, basePath)
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
			return "(String[])null"
		elements.map[a | "\"" + a.name + "\""].join(', ')
	}
	
	def asStringList(AlgorithmReferences it) {
		if(it == null || elements == null || elements.isEmpty)
			return ""
		elements.map[a | "\'" + a.name + "\'"].join(', ')
	}
	
	def asStringInfo(AlgorithmReferences it) {
		if(it == null || elements == null || elements.isEmpty)
			return "all algorithms"
		elements.map[a | "\'" + a.name + "\'"].join(', ')
	}
	
	def asString(Object it) {
		"\"" + toString + "\""
	}
	
	def asSingleString(Object it) {
		"\'" + toString + "\'"
	}
	
	def hasAlgorithms(ResultManagementCommand it) {
		algorithms != null && !algorithms.elements.isEmpty
	}

   def dispatch void infer(MOMoTSearch search, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
   	search.initNames
   	 
      val searchOrchestration = search.getSearchOrchestration
    	val transformations = search.searchOrchestration?.moduleOrchestration	
   	val fitnessFunction = searchOrchestration?.fitnessFunction		
   	val experiment = search.getExperimentOrchestration
   	val analysis = search.getAnalysisOrchestration
   	val resultManagement = search.resultManagement
   		
   	val voidRef = typeRef(void)
		val doubleRef = typeRef(double)
		val intRef = typeRef(int)
		val booleanRef = typeRef(boolean)
		val stringRef = typeRef(String)
		val arraysRef = typeRef(Arrays)
		val resultManagerRef = typeRef(TransformationResultManager)
		val algorithmRef = typeRef(Algorithm)
		val searchExperimentRef = typeRef(SearchExperiment, typeRef(TransformationSolution))
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
		val parameterValueRef = typeRef(IParameterValue, wildcard)
		val oclQueryDimensionRef = typeRef(OCLQueryDimension)
	   val parserExceptionRef = typeRef(ParserException)
	   val moduleManagerRef = typeRef(ModuleManager)
	   val moeaFactoryRef = typeRef(EvolutionaryAlgorithmFactory, typeRef(TransformationSolution))
	   val registeredAlgorithmInterfaceRef = typeRef(IRegisteredAlgorithm)   			
	   val localFactoryRef = typeRef(LocalSearchAlgorithmFactory, typeRef(TransformationSolution))
	   val registeredAlgorithmRef = typeRef(RegisteredAlgorithm)
	   val ioExceptionRef = typeRef(IOException)
		val searchAnalysisRef = typeRef(SearchAnalysis)
	   val searchAnalyzerRef = typeRef(SearchAnalyzer)
	   val fileRef = typeRef(File)
	   val iEObjectEqualityHelperRef = typeRef(IEObjectEqualityHelper)
	   val populationAnalyzerRef = typeRef(PopulationAnalyzer)
	   val fitnessComparisonRef = typeRef(FitnessComparison)
	   val solutionWriterRef = typeRef(ISolutionWriter, typeRef(TransformationSolution))
	   val populationWriterRef = typeRef(IPopulationWriter, typeRef(TransformationSolution))
	   val populationRef = typeRef(Population)
	   val fileListRef = typeRef(List, typeRef(File))
   	val henshinResourceSetRef = typeRef(HenshinResourceSet)
   	
   	acceptor.accept(search.toClass(search.javaClassName)) [	   		
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
			
			members += searchOrchestration.model.toField(MOMoTInferrer::Name::FIELD_INITIAL_MODEL, stringRef) [
				static = true
				final = true
				visibility = JvmVisibility::PROTECTED
				initializer = searchOrchestration.model.path
			]
			
	   	members += searchOrchestration.solutionLength.toField(MOMoTInferrer::Name::FIELD_SOLUTION_LENGTH, intRef) [
	   		static = true
	   		final = true
	   		visibility = JvmVisibility::PROTECTED
	   		initializer = searchOrchestration.solutionLength
	   	]
	   	
			var JvmGenericType fitnessFunctionClass = null
  			if(fitnessFunction.needsClass) {
  				fitnessFunctionClass = fitnessFunction.toClass(fitnessFunction.javaClassName) [
   				superTypes += fitnessFunction.superConstructorRef
   				
   				if(fitnessFunction.preprocess != null)
	   				members += fitnessFunction.preprocess.toMethod(MOMoTInferrer::Name::METHOD_FITNESS_PREPROCESS, voidRef) [
	   					visibility = JvmVisibility::PROTECTED
	   					annotations += annotationRef(Override)
	   					parameters += fitnessFunction.preprocess.toParameter(MOMoTInferrer::Name::PARAM_SOLUTION, transformationSolutionRef)
   						
	   					body = fitnessFunction.preprocess
	   				]
	   				
   				if(fitnessFunction.postprocess != null)
	   				members += fitnessFunction.preprocess.toMethod(MOMoTInferrer::Name::METHOD_FITNESS_POSTPROCESS, voidRef) [
	   					visibility = JvmVisibility::PROTECTED
	   					annotations += annotationRef(Override)
	   					parameters += fitnessFunction.preprocess.toParameter(MOMoTInferrer::Name::PARAM_SOLUTION, transformationSolutionRef)
	   					parameters += fitnessFunction.preprocess.toParameter(MOMoTInferrer::Name::PARAM_AGGREGATED_FITNESS, doubleRef)
	   					body = fitnessFunction.postprocess
	   				]
  				]
  				members += fitnessFunctionClass
  			}
   		
  			members += transformations.modules.toField(MOMoTInferrer::Name::FIELD_MODULES, stringArrayRef) [
				final = true
				visibility = JvmVisibility::PROTECTED
				initializer = transformations.modules
			]
  			
  			if(transformations.unitsToRemove != null)
				members += transformations.unitsToRemove.toField(MOMoTInferrer::Name::FIELD_UNITS_TO_REMOVE, stringArrayRef) [
					final = true
					visibility = JvmVisibility::PROTECTED
					initializer = transformations.unitsToRemove
				]

   		if(searchOrchestration.fitnessFunction.constructor != null && !searchOrchestration.fitnessFunction.needsClass)
   			members += searchOrchestration.fitnessFunction.constructor.toField(MOMoTInferrer::Name::FIELD_FITNESS_FUNCTION, fitnessFunctionInterfaceRef) [
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
				members += transformations.nonSolutionParameters.toField(MOMoTInferrer::Name::FIELD_NON_SOLUTION_PARAMETERS, stringArrayRef) [
   				final = true
   				visibility = JvmVisibility::PROTECTED
   				initializer = transformations.nonSolutionParameters
   			]
   					   		
   		if(searchOrchestration.fitnessFunction.solutionRepairer != null)
   			members += searchOrchestration.fitnessFunction.solutionRepairer.toField(MOMoTInferrer::Name::FIELD_SOLUTION_REPAIRER, transformationRepairerRef) [
   				final = true
   				visibility = JvmVisibility::PROTECTED
   				initializer = searchOrchestration.fitnessFunction.solutionRepairer
   			]
  			   			
  			if(experiment.populationSize != 0)
   			members += search.toField(MOMoTInferrer::Name::FIELD_POPULATION_SIZE, intRef) [
   				final = true
   				visibility = JvmVisibility::PROTECTED
   				initializer = experiment.populationSize
   			]
  			
  			members += search.toField(MOMoTInferrer::Name::FIELD_MAX_EVALUATIONS, intRef) [
  				final = true
  				visibility = JvmVisibility::PROTECTED
  				initializer = experiment.maxEvaluations
  			]
  			
  			members += search.toField(MOMoTInferrer::Name::FIELD_NR_RUNS, intRef) [
  				final = true
  				visibility = JvmVisibility::PROTECTED
  				initializer = experiment.nrRuns
  			]
  			
  			members += search.toField(MOMoTInferrer::Name::FIELD_BASE_NAME, stringRef) [
  				visibility = JvmVisibility::PROTECTED
  			]
  			
  			if(experiment.referenceSet != null)
   			members += search.toField(MOMoTInferrer::Name::FIELD_REFERENCE_SET, stringRef) [
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
  						parameters += search.toParameter(MOMoTInferrer::Name::PARAM_ORCHESTRATION, searchOrchestrationRef)
  						body = new StringConcatenationClient() {
							override protected appendTo(TargetStringConcatenation it) {
								appendLine(fitnessDimensionRef.type, "<TransformationSolution> dimension = ", dimension.helperMethodName, "();");
								appendLine("dimension.setName(\"", name, "\");");
								appendLine("dimension.setFunctionType(", dimension.direction.FQN, ");");
								appendLine("return dimension;");
	   						}
	   					}
   				]
   			} else if(dimension instanceof FitnessDimensionXBase) {
   				members += dimension.value.toMethod(dimension.helperMethodName, doubleRef) [
   					visibility = JvmVisibility::PROTECTED
   						
   					parameters += searchOrchestration.toParameter(MOMoTInferrer::Name::PARAM_SOLUTION, transformationSolutionRef)
   					parameters += searchOrchestration.toParameter(MOMoTInferrer::Name::PARAM_GRAPH, eGraphRef)
   					parameters += searchOrchestration.toParameter(MOMoTInferrer::Name::PARAM_ROOT, eObjectRef)
   					body = dimension.value
   				]  					
   					
   				members += dimension.value.toMethod(dimension.methodName, fitnessDimensionRef) [
   					visibility = JvmVisibility::PROTECTED
   					parameters += search.toParameter(MOMoTInferrer::Name::PARAM_ORCHESTRATION, searchOrchestrationRef)
   					body = new StringConcatenationClient() {
							override protected appendTo(TargetStringConcatenation it) {
								appendLine("return new ", graphDimensionRef.type, "(\"", name, "\", ", dimension.direction.FQN, ") {");
								appendLine("   @Override");
								appendLine("   protected double internalEvaluate(", transformationSolutionRef.type, " ", MOMoTInferrer::Name::PARAM_SOLUTION, ") {");
								appendLine("		", eGraphRef, " ", MOMoTInferrer::Name::PARAM_GRAPH, " = ", MOMoTInferrer::Name::PARAM_SOLUTION, ".execute();")
								appendLine("      ", eObjectRef, " root = ", momotUtilRef.type, ".getRoot(", MOMoTInferrer::Name::PARAM_GRAPH, ");")
								appendLine("      return ", dimension.helperMethodName, "(", MOMoTInferrer::Name::PARAM_SOLUTION, ", ", MOMoTInferrer::Name::PARAM_GRAPH, ", ", MOMoTInferrer::Name::PARAM_ROOT, ");");
								appendLine("   }");
								appendLine("};");
	   					}
	   				}
   				]
   			} else if(dimension instanceof FitnessDimensionOCL) {
   				val oclDimension = dimension as FitnessDimensionOCL
   				members += oclDimension.query.toMethod(dimension.methodName, fitnessDimensionRef) [
  						visibility = JvmVisibility::PROTECTED
  						parameters += search.toParameter(MOMoTInferrer::Name::PARAM_ORCHESTRATION, searchOrchestrationRef)
  						body = new StringConcatenationClient() {
							override protected appendTo(TargetStringConcatenation it) {						
								val query = (oclDimension.query as XStringLiteral).value
								appendLine("try {")
								append("   return new ", oclQueryDimensionRef.type, "(\"", name, "\", ", oclDimension.direction.FQN, ", \"", query, "\", ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".createOCLHelper()");
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
   			
  			members += searchOrchestration.toMethod(MOMoTInferrer::Name::METHOD_CREATE_MODULE_MANAGER, moduleManagerRef) [
  				visibility = JvmVisibility::PROTECTED
  				body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(moduleManagerRef.type, " manager = new ", moduleManagerRef.type, "();");
   					appendLine("manager.addModules(", MOMoTInferrer::Name::FIELD_MODULES, ");");
   					if(transformations.unitsToRemove != null)
   						appendLine("manager.removeUnits(", MOMoTInferrer::Name::FIELD_UNITS_TO_REMOVE, ");");
   					if(transformations.nonSolutionParameters != null)
   						appendLine("manager.addNonSolutionParameters(", MOMoTInferrer::Name::FIELD_NON_SOLUTION_PARAMETERS, ");");
   					for(p : transformations.parameterValues)
   						appendLine("manager.setParameterValue(", p.fieldName, ", ", p.methodName, "());")
   					appendLine("return manager;");
	  				}
	  			}
   		]
   			
   		val fitnessFunctionRef = if(fitnessFunctionClass != null) fitnessFunctionClass.typeRef else typeRef(EGraphMultiDimensionalFitnessFunction)
   		members += searchOrchestration.toMethod(MOMoTInferrer::Name::METHOD_CREATE_FITNESS_FUNCTION, fitnessFunctionInterfaceRef) [
   			visibility = JvmVisibility::PROTECTED
   			parameters += search.toParameter(MOMoTInferrer::Name::PARAM_ORCHESTRATION, searchOrchestrationRef)
   			body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						if(searchOrchestration.fitnessFunction.constructor != null && !searchOrchestration.fitnessFunction.needsClass) {
   						appendLine(fitnessFunctionInterfaceRef.type, " function = ", MOMoTInferrer::Name::FIELD_FITNESS_FUNCTION, ";");
   					} else {
   						appendLine(fitnessFunctionInterfaceRef.type, " function = new ", fitnessFunctionRef.type, "();");
					} 
					for(objective : searchOrchestration.fitnessFunction.objectives)
   						appendLine("function.addObjective(", objective.methodName, "(", MOMoTInferrer::Name::PARAM_ORCHESTRATION, "));");
   					for(constraint : searchOrchestration.fitnessFunction.constraints) 
   						appendLine("function.addConstraint(", constraint.methodName, "(", MOMoTInferrer::Name::PARAM_ORCHESTRATION, "));");
   					if(searchOrchestration.fitnessFunction.solutionRepairer != null)
   						appendLine("function.setSolutionRepairer(", MOMoTInferrer::Name::FIELD_SOLUTION_REPAIRER, ");");
   					appendLine("return function;");
	   			}
	   		}
   		]   			
   			
   		for(algorithm : searchOrchestration.algorithms.specifications) {
   			val type = algorithm.call.inferredType ?: registeredAlgorithmInterfaceRef		
				val algorithmMethod = search.toMethod(algorithm.methodName, type) [
					visibility = JvmVisibility::PROTECTED
					parameters += search.toParameter(MOMoTInferrer::Name::PARAM_ORCHESTRATION, searchOrchestrationRef)
   				parameters += search.toParameter(MOMoTInferrer::Name::PARAM_MOEA_FACTORY, moeaFactoryRef)
   				parameters += search.toParameter(MOMoTInferrer::Name::PARAM_LOCAL_FACTORY, localFactoryRef)
   				body = algorithm.call
   			]

   			members += algorithmMethod
   			if(algorithm.call instanceof XConstructorCall) {
   				algorithmMethod.simpleName = algorithm.helperMethodName
   				
   				members += search.toMethod(algorithm.methodName, registeredAlgorithmInterfaceRef) [
   					visibility = JvmVisibility::PROTECTED
   					parameters += search.toParameter(MOMoTInferrer::Name::PARAM_ORCHESTRATION, searchOrchestrationRef)
   					parameters += search.toParameter(MOMoTInferrer::Name::PARAM_MOEA_FACTORY, moeaFactoryRef)
   					parameters += search.toParameter(MOMoTInferrer::Name::PARAM_LOCAL_FACTORY, localFactoryRef)
   					body = new StringConcatenationClient() {
							override protected appendTo(TargetStringConcatenation it) {
								appendLine("return new ", registeredAlgorithmRef.type, "<Algorithm>() {");
								appendLine("   @Override");
								appendLine("   public ", algorithmRef.type, " createAlgorithm() {");
								appendLine("      return ", algorithm.helperMethodName, "(",  MOMoTInferrer::Name::PARAM_ORCHESTRATION, ", ", MOMoTInferrer::Name::PARAM_MOEA_FACTORY, ", ", MOMoTInferrer::Name::PARAM_LOCAL_FACTORY, ");");
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
  					members += searchOrchestration.equalityHelper.method.toMethod(MOMoTInferrer::Name::METHOD_CREATE_EQUALITY_HELPER_HELPER, booleanRef) [
  						visibility = JvmVisibility::PROTECTED
  						parameters += searchOrchestration.equalityHelper.method.toParameter(MOMoTInferrer::Name::PARAM_EQUALITY_LEFT, eObjectRef)
  						parameters += searchOrchestration.equalityHelper.method.toParameter(MOMoTInferrer::Name::PARAM_EQUALITY_RIGHT, eObjectRef)
  						body = searchOrchestration.equalityHelper.method
  					]
  					members += searchOrchestration.equalityHelper.method.toMethod(MOMoTInferrer::Name::METHOD_CREATE_EQUALITY_HELPER, iEObjectEqualityHelperRef) [
  						visibility = JvmVisibility::PROTECTED
  						body = new StringConcatenationClient() {
							override protected appendTo(TargetStringConcatenation it) {
								appendLine("return new ", iEObjectEqualityHelperRef.type, "() {");
								appendLine("   @Override");
								appendLine("   public ", booleanRef.type, " equals(EObject left, EObject right) {");
								appendLine("      return ", MOMoTInferrer::Name::METHOD_CREATE_EQUALITY_HELPER_HELPER, "(left, right);");
								appendLine("   }");
								appendLine("};");
							}
						}
  					]
  				} // searchOrchestration.equalityHelper.method != null
   			else if(searchOrchestration.equalityHelper.call != null) {
   				members += searchOrchestration.equalityHelper.call.toMethod(MOMoTInferrer::Name::METHOD_CREATE_EQUALITY_HELPER, iEObjectEqualityHelperRef) [
   					visibility = JvmVisibility::PROTECTED
   					body = searchOrchestration.equalityHelper.call
   				]
   			} // searchOrchestration.equalityHelper.call != null
   		} // searchOrchestration.equalityHelper != null
   			
  			members += searchOrchestration?.model?.path?.toMethod(MOMoTInferrer::Name::METHOD_CREATE_INPUT_GRAPH, eGraphRef) [
  				visibility = JvmVisibility::PROTECTED
  				parameters += searchOrchestration.model.path.toParameter(MOMoTInferrer::Name::PARAM_INITIAL_GRAPH, stringRef)
  				parameters += searchOrchestration.model.path.toParameter(MOMoTInferrer::Name::PARAM_MODULE_MANAGER, moduleManagerRef)
  				body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(eGraphRef.type, " ", MOMoTInferrer::Name::PARAM_GRAPH, " = ", MOMoTInferrer::Name::PARAM_MODULE_MANAGER, ".loadGraph(", MOMoTInferrer::Name::PARAM_INITIAL_GRAPH, ");")
						if(searchOrchestration.model.adaptation != null) 
							appendLine("return ", MOMoTInferrer::Name::METHOD_ADAPT_INPUT_GRAPH, "(", MOMoTInferrer::Name::PARAM_MODULE_MANAGER, ", ", MOMoTInferrer::Name::PARAM_GRAPH, ");")
						else
							appendLine("return ", MOMoTInferrer::Name::PARAM_GRAPH, ";")
					}
				}
  			]
   			
  			if(searchOrchestration?.model?.adaptation != null) {
  				members += searchOrchestration.model.adaptation.toMethod(MOMoTInferrer::Name::METHOD_ADAPT_INPUT_GRAPH, eGraphRef) [
  					visibility = JvmVisibility::PROTECTED
  					parameters += searchOrchestration.model.path.toParameter(MOMoTInferrer::Name::PARAM_MODULE_MANAGER, moduleManagerRef)
  					parameters += searchOrchestration.model.path.toParameter(MOMoTInferrer::Name::PARAM_INITIAL_GRAPH, eGraphRef)
  					body = new StringConcatenationClient() {
						override protected appendTo(TargetStringConcatenation it) {
							appendLine(eGraphRef.type, " problemGraph = ", momotUtilRef.type, ".copy(", MOMoTInferrer::Name::PARAM_INITIAL_GRAPH, ");")
							appendLine(eObjectRef.type, " ", MOMoTInferrer::Name::PARAM_ROOT, " = ", momotUtilRef.type, ".getRoot(problemGraph);")
							appendLine("return ", momotUtilRef.type, ".createEGraph(", MOMoTInferrer::Name::METHOD_ADAPT_INPUT_MODEL, "(", MOMoTInferrer::Name::PARAM_ROOT, "));")
						}
					}
  				]
   				
  				members += searchOrchestration.model.adaptation.toMethod(MOMoTInferrer::Name::METHOD_ADAPT_INPUT_MODEL, eObjectRef) [
  					visibility = JvmVisibility::PROTECTED
  					parameters += searchOrchestration.model.path.toParameter(MOMoTInferrer::Name::PARAM_ROOT, eObjectRef)
  					body = searchOrchestration.model.adaptation
  				]
  			} // searchOrchestration.model.adaptation != null		
   			
  			members += search.toMethod(MOMoTInferrer::Name::METHOD_CREATE_ORCHESTRATION, searchOrchestrationRef) [
  				visibility = JvmVisibility::PROTECTED
  				parameters += searchOrchestration.toParameter(MOMoTInferrer::Name::PARAM_INITIAL_GRAPH, stringRef)
  				parameters += searchOrchestration.toParameter(MOMoTInferrer::Name::PARAM_SOLUTION_LENGTH, intRef)
  				body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(searchOrchestrationRef.type, " ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, " = new ", searchOrchestrationRef.type, "();")
						appendLine(moduleManagerRef.type, " ", MOMoTInferrer::Name::PARAM_MODULE_MANAGER, " = ", MOMoTInferrer::Name::METHOD_CREATE_MODULE_MANAGER, "();")
						appendLine(eGraphRef.type, " ", MOMoTInferrer::Name::PARAM_GRAPH, " = ", MOMoTInferrer::Name::METHOD_CREATE_INPUT_GRAPH, "(", MOMoTInferrer::Name::PARAM_INITIAL_GRAPH, ", ", MOMoTInferrer::Name::PARAM_MODULE_MANAGER, ");")
						appendLine(MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".setModuleManager(", MOMoTInferrer::Name::PARAM_MODULE_MANAGER, ");")
						appendLine(MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".setProblemGraph(", MOMoTInferrer::Name::PARAM_GRAPH, ");")
						appendLine(MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".setSolutionLength(", MOMoTInferrer::Name::PARAM_SOLUTION_LENGTH, ");")
   						appendLine(MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".setFitnessFunction(", MOMoTInferrer::Name::METHOD_CREATE_FITNESS_FUNCTION, "(", MOMoTInferrer::Name::PARAM_ORCHESTRATION, "));")
						if(searchOrchestration.equalityHelper != null)
							appendLine(MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".setEqualityHelper(", MOMoTInferrer::Name::METHOD_CREATE_EQUALITY_HELPER, "());")
						newLine
						appendLine(moeaFactoryRef.type, "<TransformationSolution> ", MOMoTInferrer::Name::PARAM_MOEA_FACTORY, " = ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".createEvolutionaryAlgorithmFactory(", MOMoTInferrer::Name::FIELD_POPULATION_SIZE, ");")
						appendLine(localFactoryRef.type, "<TransformationSolution> ", MOMoTInferrer::Name::PARAM_LOCAL_FACTORY, " = ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".createLocalSearchAlgorithmFactory();")
						for(algorithm : searchOrchestration.algorithms.specifications) 
							appendLine(MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".addAlgorithm(\"" + algorithm.name + "\", ", 
								algorithm.methodName, "(",  MOMoTInferrer::Name::PARAM_ORCHESTRATION, ", ", MOMoTInferrer::Name::PARAM_MOEA_FACTORY, ", ", MOMoTInferrer::Name::PARAM_LOCAL_FACTORY, "));");
						newLine
						appendLine("return ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ";");
					}
				}
   		]
   			
  			members += search.toMethod(MOMoTInferrer::Name::METHOD_CREATE_EXPERIMENT, searchExperimentRef) [
  				visibility = JvmVisibility::PROTECTED
  				parameters += search.toParameter(MOMoTInferrer::Name::PARAM_ORCHESTRATION, searchOrchestrationRef)
  				body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(searchExperimentRef.type, "<TransformationSolution> experiment = new ", searchExperimentRef.type, "<TransformationSolution>(", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ", ", MOMoTInferrer::Name::FIELD_MAX_EVALUATIONS + ");");
						if(experiment.referenceSet != null)
							appendLine("experiment.setReferenceSetFile(", MOMoTInferrer::Name::FIELD_REFERENCE_SET, ");")
						appendLine("experiment.setNumberOfRuns(", MOMoTInferrer::Name::FIELD_NR_RUNS, ");")
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
   			
   		members += search.toMethod(MOMoTInferrer::Name::METHOD_DERIVE_BASE_NAME, voidRef) [
	   		visibility = JvmVisibility::PROTECTED
	   		parameters += search.toParameter(MOMoTInferrer::Name::PARAM_ORCHESTRATION, searchOrchestrationRef)
	   		body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(eObjectRef, " ", MOMoTInferrer::Name::PARAM_ROOT, " = ", momotUtilRef.type, ".getRoot(", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".getProblemGraph());")
						appendLine("if(", MOMoTInferrer::Name::PARAM_ROOT, " == null || ", MOMoTInferrer::Name::PARAM_ROOT, ".eResource() == null || ", MOMoTInferrer::Name::PARAM_ROOT, ".eResource().getURI() == null)")
						appendLine("\t", MOMoTInferrer::Name::FIELD_BASE_NAME, " = getClass().getSimpleName();")
						appendLine("else")
						appendLine("\t", MOMoTInferrer::Name::FIELD_BASE_NAME, " = ", MOMoTInferrer::Name::PARAM_ROOT, ".eResource().getURI().trimFileExtension().lastSegment();")
					}
				}
	   	]
   			
   		if(analysis != null) {
   			members += analysis.significance.toField(MOMoTInferrer::Name::FIELD_SIGNIFICANCE_LEVEL, doubleRef) [
	   			visibility = JvmVisibility::PROTECTED
	   			initializer = analysis.significance
   			]
   				
	   		members += analysis.toMethod(MOMoTInferrer::Name::METHOD_PERFORM_ANALYSIS, searchAnalyzerRef) [
	   			visibility = JvmVisibility::PROTECTED
	   			parameters += search.toParameter(MOMoTInferrer::Name::PARAM_EXPERIMENT, searchExperimentRef)
	   			body = new StringConcatenationClient() {
						override protected appendTo(TargetStringConcatenation it) {
							appendLine(searchAnalysisRef.type, " analysis = new ", searchAnalysisRef.type, "(", MOMoTInferrer::Name::PARAM_EXPERIMENT, ");");
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
							appendLine("analysis.setSignificanceLevel(", MOMoTInferrer::Name::FIELD_SIGNIFICANCE_LEVEL, ");")
							appendLine(searchAnalyzerRef.type, " ", MOMoTInferrer::Name::PARAM_SEARCH_ANALYZER, " = analysis.analyze();")
							if(analysis.printCommand != null) {
								appendLine("System.out.println(\"---------------------------\");")
								appendLine("System.out.println(\"Analysis Results\");")
								appendLine("System.out.println(\"---------------------------\");")
								appendLine(MOMoTInferrer::Name::PARAM_SEARCH_ANALYZER, ".printAnalysis();")
								appendLine("System.out.println(\"---------------------------\");")
							}
							if(analysis.saveCommand != null) {
								val saveFile = (analysis.saveCommand.file as XStringLiteral).value
								appendLine("try {")
	   						appendLine("\t", "System.out.println(\"- Save Analysis to ", saveFile.asSingleString, "\");")
								appendLine("\t", MOMoTInferrer::Name::PARAM_SEARCH_ANALYZER, ".saveAnalysis(new ", fileRef.type, "(\"", saveFile, "\"));")
								appendLine("} catch(", ioExceptionRef.type, " e) {")
								appendLine("\t", "e.printStackTrace();")
								appendLine("}")
							}
							if(analysis.boxplotCommand != null) {
								val saveDir = (analysis.boxplotCommand.directory as XStringLiteral).value
	   						appendLine("System.out.println(\"- Save Indicator BoxPlots to ", saveDir.asSingleString, "\");")
								appendLine(MOMoTInferrer::Name::PARAM_SEARCH_ANALYZER, ".saveIndicatorBoxPlots(")
								appendLine("\t", "\"", saveDir, "\"", ",")
								appendLine("\t", MOMoTInferrer::Name::FIELD_BASE_NAME)
								appendLine(");")
							}
							appendLine("return ", MOMoTInferrer::Name::PARAM_SEARCH_ANALYZER, ";")
						}
					}
	   		]
	   	} // analysis != null
	   		
	   	if(resultManagement != null) {  			
	   		members += resultManagement.toMethod(MOMoTInferrer::Name::METHOD_HANDLE_RESULTS, resultManagerRef) [
	   			visibility = JvmVisibility::PROTECTED
	   			parameters += search.toParameter(MOMoTInferrer::Name::PARAM_EXPERIMENT, searchExperimentRef)
	   			body = new StringConcatenationClient() {
						override protected appendTo(TargetStringConcatenation it) {
							appendLine(solutionWriterRef.type, "<TransformationSolution> ", MOMoTInferrer::Name::PARAM_SOLUTION_WRITER, " = ", MOMoTInferrer::Name::PARAM_EXPERIMENT, ".getSearchOrchestration().createSolutionWriter();")
							appendLine(populationWriterRef.type, "<TransformationSolution> ", MOMoTInferrer::Name::PARAM_POPULATION_WRITER, " = ", MOMoTInferrer::Name::PARAM_EXPERIMENT, ".getSearchOrchestration().createPopulationWriter();")
							appendLine(resultManagerRef.type, " resultManager = new ", resultManagerRef.type, "(", MOMoTInferrer::Name::PARAM_EXPERIMENT, ");");
							
							appendLine(populationRef, " ", MOMoTInferrer::Name::PARAM_POPULATION, ";")
							resultManagement.commands.forEach[ command |
								val isKneepoint = command.neighborhoodSize != 0 || command.maxNeighborhoodSize
								appendLine(MOMoTInferrer::Name::PARAM_POPULATION, " = ")
								if(isKneepoint) {
									appendLine("\t", "new ", populationAnalyzerRef.type, "(", resultManagerRef.type, ".createApproximationSet(", MOMoTInferrer::Name::PARAM_EXPERIMENT, "))")
									appendLine("\t\t", ".getKneePointSolutions(")
									appendLine("\t\t\t", resultManagerRef.type, ".createApproximationSet(", MOMoTInferrer::Name::PARAM_EXPERIMENT, ", ", command.algorithms.asString, "),")
									if(command.neighborhoodSize != 0) 
										appendLine("\t\t\t", command.neighborhoodSize, ",")
									else
										appendLine("\t\t\t", MOMoTInferrer::Name::FIELD_POPULATION_SIZE, "-1,")
									appendLine("\t\t\t", fitnessComparisonRef.type, ".PROPER_UTILITY);")
								} else {
									appendLine("\t", resultManagerRef.type, ".createApproximationSet(", MOMoTInferrer::Name::PARAM_EXPERIMENT, ", ", command.algorithms.asString, ");")
								
								}
								if(command instanceof ObjectivesCommand) {
									val realCommand = command as ObjectivesCommand
									if(realCommand.file != null) {
										if(isKneepoint) {
											append("System.out.println(\"- Save Kneepoint Objectives of ", realCommand.algorithms.asStringInfo, "")
											if(realCommand.neighborhoodSize != 0) 
												append(" with ", realCommand.neighborhoodSize, " neighbors")
											else
												append(" with maximum neighbors")
											appendLine(" to ", realCommand.file.asSingleString, "\");")
										} else {
											appendLine("System.out.println(\"- Save objectives of ", realCommand.algorithms.asStringInfo, " to ", realCommand.file.asSingleString, "\");")
										}
										appendLine(resultManagerRef.type, ".saveObjectives(")
										appendLine("\t", realCommand.file.asString, ",")
										appendLine("\t", MOMoTInferrer::Name::PARAM_POPULATION)
										appendLine(");")
									}
									if(realCommand.printOutput) {
										appendLine("System.out.println(\"---------------------------\");")
										if(isKneepoint) {
											append("System.out.println(\"Kneepoint Objectives of ", realCommand.algorithms.asStringInfo, "")
											if(realCommand.neighborhoodSize != 0) 
												appendLine(" with ", realCommand.neighborhoodSize, " neighbors\");")
											else
												appendLine(" with maximum neighbors\");")
										} else {
											appendLine("System.out.println(\"Objectives of ", realCommand.algorithms.asStringInfo, "\");")
										}
										appendLine("System.out.println(\"---------------------------\");")
										appendLine("System.out.println(", resultManagerRef.type, ".printObjectives(")
										appendLine("\t", MOMoTInferrer::Name::PARAM_POPULATION)
										appendLine("));")
									}
								}
								else if(command instanceof SolutionsCommand) {
									val realCommand = command as SolutionsCommand
									if(realCommand.file != null) {
										if(isKneepoint) {
											append("System.out.println(\"- Save Kneepoint solutions of ", realCommand.algorithms.asStringInfo, "")
											if(realCommand.neighborhoodSize != 0) 
												append(" with ", realCommand.neighborhoodSize, " neighbors")
											else
												append(" with maximum neighbors")
											appendLine(" to ", realCommand.file.asSingleString, "\");")
										} else {
											appendLine("System.out.println(\"- Save solutions of ", realCommand.algorithms.asStringInfo, " to ", realCommand.file.asSingleString, "\");")
										}
										appendLine(resultManagerRef.type, ".savePopulation(")
										appendLine("\t", realCommand.file.asString, ",")
										appendLine("\t", MOMoTInferrer::Name::PARAM_POPULATION, ",")
										appendLine("\t", MOMoTInferrer::Name::PARAM_POPULATION_WRITER)
										appendLine(");")
									}
									if(realCommand.directory != null) {
										appendLine("System.out.println(\"- Save solutions of ", realCommand.algorithms.asStringInfo, " to ", realCommand.file.asSingleString, "\");")
										appendLine(resultManagerRef.type, ".saveSolutions(")
										appendLine("\t", realCommand.directory.asString, ",")
										appendLine("\t", MOMoTInferrer::Name::FIELD_BASE_NAME, ",")
										appendLine("\t", momotUtilRef.type, ".asIterables(")
										appendLine("\t\t", MOMoTInferrer::Name::PARAM_POPULATION, ",")
										appendLine("\t\t", transformationSolutionRef.type, ".class),")
										appendLine("\t", MOMoTInferrer::Name::PARAM_SOLUTION_WRITER)
										appendLine(");")
									}
									if(realCommand.printOutput) {
										appendLine("System.out.println(\"---------------------------\");")
										if(isKneepoint) {
											append("System.out.println(\"Kneepoint solutions of ", realCommand.algorithms.asStringInfo, "")
											if(realCommand.neighborhoodSize != 0) 
												appendLine(" with ", realCommand.neighborhoodSize, " neighbors\");")
											else
												appendLine(" with maximum neighbors\");")
										} else {
											appendLine("System.out.println(\"Solutions of ", realCommand.algorithms.asStringInfo, "\");")
										}
										appendLine("System.out.println(\"---------------------------\");")
										appendLine(resultManagerRef.type, ".printPopulation(")
										appendLine("\t", MOMoTInferrer::Name::PARAM_POPULATION, ",")
										appendLine("\t", MOMoTInferrer::Name::PARAM_POPULATION_WRITER)
										appendLine(");")
									}
								}
								else if(command instanceof ModelsCommand) {
									val realCommand = command as ModelsCommand
									if(realCommand.directory != null) {
										if(isKneepoint) {
											append("System.out.println(\"- Save Kneepoint models of ", realCommand.algorithms.asStringInfo, "")
											if(realCommand.neighborhoodSize != 0) 
												append(" with ", realCommand.neighborhoodSize, " neighbors")
											else
												append(" with maximum neighbors")
											appendLine(" to ", realCommand.directory.asSingleString, "\");")
										} else {
											appendLine("System.out.println(\"- Save models of ", realCommand.algorithms.asStringInfo, " to ", realCommand.directory.asSingleString, "\");")
										}
										if(resultManagement.adaptModels == null) {
											appendLine(resultManagerRef.type, ".saveModels(")
											appendLine("\t", realCommand.directory.asString, ",")
											appendLine("\t", MOMoTInferrer::Name::FIELD_BASE_NAME, ",")
											appendLine("\t", MOMoTInferrer::Name::PARAM_POPULATION)
											appendLine(");")
										} else {
											appendLine(MOMoTInferrer::Name::METHOD_ADAPT_MODELS, "(", resultManagerRef.type, ".saveModels(")
											appendLine("\t", realCommand.directory.asString, ",")
											appendLine("\t", MOMoTInferrer::Name::FIELD_BASE_NAME, ",")
											appendLine("\t", MOMoTInferrer::Name::PARAM_POPULATION)
											appendLine("));")
										}
									}
									if(realCommand.printOutput) {
										appendLine("System.out.println(\"---------------------------\");")
										if(isKneepoint) {
											append("System.out.println(\"Kneepoint models of ", realCommand.algorithms.asStringInfo, "")
											if(realCommand.neighborhoodSize != 0) 
												appendLine(" with ", realCommand.neighborhoodSize, " neighbors\");")
											else
												appendLine(" with maximum neighbors\");")
										} else {
											appendLine("System.out.println(\"Models of ", realCommand.algorithms.asStringInfo, "\");")
										}
										appendLine("System.out.println(\"---------------------------\");")
										appendLine("System.out.println(", resultManagerRef.type, ".printModels(")
										appendLine("\t", MOMoTInferrer::Name::PARAM_POPULATION)
										appendLine("));")
									}
								}
								appendLine();
							]
							
							appendLine("return ", MOMoTInferrer::Name::PARAM_RESULT_MANAGER, ";")
						}
					}
	   		]
	   		if(resultManagement.adaptModels != null) {
	   			members += resultManagement.adaptModels.toMethod(MOMoTInferrer::Name::METHOD_ADAPT_MODELS, voidRef) [
	   				visibility = JvmVisibility::PROTECTED
	   				parameters += resultManagement.adaptModels.toParameter(MOMoTInferrer::Name::PARAM_MODEL_FILES, fileListRef)
	   				body = new StringConcatenationClient() {
		   				override protected appendTo(TargetStringConcatenation it) {
		   					appendLine(henshinResourceSetRef.type, " set = new ", henshinResourceSetRef.type, "();")
		   					appendLine("for(", fileRef.type, " file : ", MOMoTInferrer::Name::PARAM_MODEL_FILES, ") {")
		   					appendLine("\t", eGraphRef.type, " graph = ", momotUtilRef.type, ".loadGraph(file.getPath());")
		   					appendLine("\t", eObjectRef.type, " ", MOMoTInferrer::Name::PARAM_ROOT, " = ", momotUtilRef.type, ".getRoot(graph);")
		   					appendLine("\t", MOMoTInferrer::Name::METHOD_ADAPT_MODEL, "(", MOMoTInferrer::Name::PARAM_ROOT, ");")
		   					appendLine("\t", momotUtilRef.type, ".saveGraph(graph, file.getPath());")
		   					appendLine("}")
		   				}
		   			}
	   			]
	   			
	   			members += resultManagement.adaptModels.toMethod(MOMoTInferrer::Name::METHOD_ADAPT_MODEL, voidRef) [
	   				visibility = JvmVisibility::PROTECTED
	   				parameters += resultManagement.adaptModels.toParameter(MOMoTInferrer::Name::PARAM_ROOT, eObjectRef)
	   				body = resultManagement.adaptModels
	   			] 
	   		}
   		} // resultManagement != null
   			
   		members += search.toMethod(MOMoTInferrer::Name::METHOD_PRINT_SEARCH_INFO, voidRef) [
   			parameters += search.toParameter(MOMoTInferrer::Name::PARAM_ORCHESTRATION, searchOrchestrationRef)
   			body = new StringConcatenationClient() {
   				override protected appendTo(TargetStringConcatenation it) {
   					appendLine("System.out.println(\"-------------------------------------------------------\");")
   					appendLine("System.out.println(\"Search\");")
   					appendLine("System.out.println(\"-------------------------------------------------------\");")
    					appendLine("System.out.println(\"InputModel:      \" + ", MOMoTInferrer::Name::FIELD_INITIAL_MODEL, ");")
    					appendLine("System.out.println(\"Objectives:      \" + ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".getFitnessFunction().getObjectiveNames());")
   					appendLine("System.out.println(\"NrObjectives:    \" + ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".getNumberOfObjectives());")
    					appendLine("System.out.println(\"Constraints:     \" + ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".getFitnessFunction().getConstraintNames());")
   					appendLine("System.out.println(\"NrConstraints:   \" + ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".getNumberOfConstraints());")
   					appendLine("System.out.println(\"Transformations: \" + ", arraysRef.type, ".toString(", MOMoTInferrer::Name::FIELD_MODULES, "));")
						appendLine("System.out.println(\"Units:           \" + ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".getModuleManager().getUnits());")
   					appendLine("System.out.println(\"SolutionLength:  \" + ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ".getSolutionLength());")
   					appendLine("System.out.println(\"PopulationSize:  \" + ", MOMoTInferrer::Name::FIELD_POPULATION_SIZE,");")
   					appendLine("System.out.println(\"Iterations:      \" + ", MOMoTInferrer::Name::FIELD_MAX_EVALUATIONS, " / ", MOMoTInferrer::Name::FIELD_POPULATION_SIZE, ");")
   					appendLine("System.out.println(\"MaxEvaluations:  \" + ", MOMoTInferrer::Name::FIELD_MAX_EVALUATIONS,");")
   					appendLine("System.out.println(\"AlgorithmRuns:   \" + ", MOMoTInferrer::Name::FIELD_NR_RUNS,");")
   					appendLine("System.out.println(\"---------------------------\");")
   				}	
   			}
   		]
   			
   		members += search.toMethod(MOMoTInferrer::Name::METHOD_PERFORM_SEARCH, voidRef) [
   			parameters += searchOrchestration.toParameter(MOMoTInferrer::Name::PARAM_INITIAL_GRAPH, stringRef)
   			parameters += searchOrchestration.toParameter(MOMoTInferrer::Name::PARAM_SOLUTION_LENGTH, intRef)
   			body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						appendLine(searchOrchestrationRef.type, " ", MOMoTInferrer::Name::PARAM_ORCHESTRATION, " = ", MOMoTInferrer::Name::METHOD_CREATE_ORCHESTRATION ,"(", MOMoTInferrer::Name::PARAM_INITIAL_GRAPH, ", ", MOMoTInferrer::Name::PARAM_SOLUTION_LENGTH, ");");
						appendLine(MOMoTInferrer::Name::METHOD_DERIVE_BASE_NAME, "(", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ");")
						appendLine(MOMoTInferrer::Name::METHOD_PRINT_SEARCH_INFO, "(", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ");")
						appendLine(searchExperimentRef.type, "<TransformationSolution> ", MOMoTInferrer::Name::PARAM_EXPERIMENT, " = ", MOMoTInferrer::Name::METHOD_CREATE_EXPERIMENT, "(", MOMoTInferrer::Name::PARAM_ORCHESTRATION, ");");
						appendLine(MOMoTInferrer::Name::PARAM_EXPERIMENT, ".run();")
						if(analysis != null) {
   						appendLine("System.out.println(\"-------------------------------------------------------\");")
   						appendLine("System.out.println(\"Analysis\");")
   						appendLine("System.out.println(\"-------------------------------------------------------\");")
							appendLine(MOMoTInferrer::Name::METHOD_PERFORM_ANALYSIS, "(", MOMoTInferrer::Name::PARAM_EXPERIMENT, ");");
						}
						if(resultManagement != null)  {
   						appendLine("System.out.println(\"-------------------------------------------------------\");")
   						appendLine("System.out.println(\"Results\");")
   						appendLine("System.out.println(\"-------------------------------------------------------\");")
							appendLine(MOMoTInferrer::Name::METHOD_HANDLE_RESULTS, "(", MOMoTInferrer::Name::PARAM_EXPERIMENT, ");");
						}
					}		
   			}
   		]
   			
   		if(search.initialization != null)
	   		members += search.toMethod(MOMoTInferrer::Name::METHOD_INIT, voidRef) [
	   			static = true
	   			body = search.initialization
	   		]
   			
   		if(search.finalization != null)
	   		members += search.toMethod(MOMoTInferrer::Name::METHOD_FINAL, voidRef) [
	   			static = true
	   			body = search.finalization
	   		]
   			
   		val searchClassRef = typeRef(search.javaClassName)
   		members += search.toMethod(MOMoTInferrer::Name::METHOD_MAIN, voidRef) [
   			parameters += search.toParameter("args", stringArrayRef)
   			varArgs = true
   			static = true
   			body = new StringConcatenationClient() {
					override protected appendTo(TargetStringConcatenation it) {
						if(search.initialization != null)
							appendLine(MOMoTInferrer::Name::METHOD_INIT, "();");
						appendLine(searchClassRef.type, " search = new ", searchClassRef.type, "();");
						appendLine("search.", MOMoTInferrer::Name::METHOD_PERFORM_SEARCH, "(", MOMoTInferrer::Name::FIELD_INITIAL_MODEL, ", ", MOMoTInferrer::Name::FIELD_SOLUTION_LENGTH, ");")
						if(search.finalization != null)
							appendLine(MOMoTInferrer::Name::METHOD_FINAL, "();");
					}		
   			}
   		]
   	]
   }
}

