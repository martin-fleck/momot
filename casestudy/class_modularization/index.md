---
title: MOMoT Class Modularization Case Study
layout: index
---

## Modularization Case Study
A well-known problem in software architecture design that can often not be solved through exhaustive approaches is the modularization problem, where the aim is to produce high-quality object-oriented models by grouping classes into modules.
Producing a class diagram where the right number of modules is chosen and a proper assignment of classes is realized is a non-trivial task, as the problem has an exponentially growing search space of potential partitions.

### Meta-Model
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/class_modularization/modularization_metamodel.svg" alt="Modularization Meta-Model" />
</div>

In our meta-model a system is represented by a ``ModularizationModel``, which consists of classes and modules. 
``Classes`` can have dependencies to each other and may be grouped into Modules. 
``Modules`` are the component-concept of our system and they group classes together.
A common, abstract superclass ``NamedElement`` ensures that all elements in the system have a name.

### Rules

**Create Module:**
Since at the beginning there are no modules in the input model (it only contains classes and the dependencies among them), we need a rule to create a module.
This rule creates a module within the ``ModularizationModel`` with the provided name (``moduleName``), only if a module with such a name does not already exist.

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/class_modularization/modularization_rule_createModule.svg" alt="Modularization Meta-Model" />
</div>

**Assign Class:**
Finally, once we have at least one module, we can start the modularization.
For this, we assign each ``class`` to a ``module``.
Classes which have already been assigned will not be re-assigned.

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/class_modularization/modularization_rule_assignClass.svg" alt="Modularization Meta-Model" />
</div>

### Parameters
Since when we create a new module, the ``moduleName`` parameter can not be matched automatically by the graph transformation engine, we categorize it as a so-called *user parameter* which requires user input. In an automated approach however, this user input is substituted by a value generator. We therefore provide an increasing name generator for this parameter which produces names starting with *Module* and an increment value of *A*, i.e., *ModuleA*, *ModuleB*, etc.

```
ModularizationRules.CreateModule.Parameter::MODULE_NAME : new IncrementalStringValue("Module", "A")
```

### Objectives and Constraints
Since modularization is such a common and well-studied problem, many metrics have been proposed which indicate the quality of a module.
Common metrics include coupling and cohesion and the modularization quality, which combines coupling and cohesion into a single metric.
For our example, we follow the *Equal-Size Cluster Approach*, as described by Praditwong et al in *Software Module Clustering as a Multi-Objective Search Problem*.
The goal of this approach is to produce equally-sized modules, i.e., modules that have a similar number of classes. 
Therefore, besides the above mentioned three objectives we also aim to maximize the number of modules and minimize the difference between the minimum and maximum number of classes in a module.
In order to improve efficiency, we have outsourced evaluation of the objectives and constraints into a separate class ([ModularizationCalculator](https://github.com/martin-fleck/momot/blob/master/projects/at.ac.tuwien.big.momot.examples.modularization.jsep/src/at/ac/tuwien/big/momot/examples/modularization/jsep/ModularizationCalculator.java)), which calculates the values in one iteration through the model.
In the configuration example below, you can find how this external calculation can be integrated into the fitness evaluation of MOMoT.

**Coupling:**
Coupling refers to the number of external dependencies a specific module has, i.e., the sum of inter-relationships with other modules.
Typically, low coupling is preferred as this indicates that a group covers separate functionality aspects of a system, improving the maintainability, readability and testability of the overall system.

**Cohesion:**
Cohesion refers to the dependencies within a module, i.e., the sum of intra-relationships in the module.
As opposed to coupling, the cohesion within one module should be maximized to ensure that it does not contain parts that are not part of its functionality.

**Modularization Quality:**
The modularization quality (MQ) evaluates the balance between coupling and cohesion by combining them into a single measurement.
It has been proved that the higher the value of MQ, the better the quality of the modularization.
The aim is to reward increased cohesion with a higher MQ score and to punish increased coupling with a lower MQ score.

**Number of Modules:**
We aim to maximize the number of modules to avoid having all classes in a single large module.

**Min-Max Difference:**
The difference between the module with the lowest number of classes and the module with the highest number of classes should be minimized.
By doing so, we aim to produce equally-sized modules as the optimal difference would be 0.

Furthermore, in order for our system to be valid, we define the following two constraints:

**No Unassigned Classes:** 
All classes must be assigned to a module. 
If any unassigned classes are found, the system is not considered valid.
In order to assess the magnitude of the violation, we consider the number of unassigned classes.

**No Empty Modules:**
All modules must have at least one module.
Since empty modules do not provide any value for the system, they are considered a system violation.
In order to assess the magnitude of the violation, we consider the number of empty modules.

### References
* Praditwong K, Harman M, Yao X. Software Module Clustering as a Multi-Objective Search Problem. IEEE
Transactions on Software Engineering 2011; 37(2):264–282, doi:[10.1109/TSE.2010.26](http://dx.doi.org/10.1109/TSE.2010.26).
* [Example project on GitHub](https://github.com/martin-fleck/momot/tree/master/projects/at.ac.tuwien.big.momot.examples.modularization.jsep)

### Input Example
As an example input model, we use the *mtunis* system, an operating system for educational purposes written in the Turing Language.
The system contains 20 classes and 57 dependencies among them.

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/class_modularization/modularization_model_input.svg" alt="Modularization Meta-Model" />
</div>

### Complete example configuration
```
var attribute = "calculation"
var penalty = 1000

initialization  = {
	ModularizationPackage.eINSTANCE.class // register package in standalone
}

search = {
	model = "data/input/models/mtunis.xmi"
	solutionLength = 50
	transformations = {
		modules = [ "data/modularization_jsep.henshin" ]
		parameterValues = {
			ModularizationRules.CreateModule.Parameter::MODULE_NAME :
				new IncrementalStringValue("Module", "A")
		}
	}
	fitness = {
		preprocess = { // use attribute storage for external calculation
			val root = MomotUtil.getRoot(solution.execute, typeof(ModularizationModel))
			solution.setAttribute("root", root)
			solution.setAttribute(attribute, new ModularizationCalculator(root))
		}
		objectives = { 
			Coupling : minimize { // java-like syntax
				val calculator = solution.getAttribute(attribute, typeof(ModularizationCalculator))
				calculator.metrics.coupling
			}
			Cohesion : maximize { 
				val calculator = solution.getAttribute(attribute, typeof(ModularizationCalculator))
				calculator.metrics.cohesion
			}
			NrModules : maximize "modules->size()" // OCL-specification
			MQ : maximize {
				val calculator = solution.getAttribute(attribute, typeof(ModularizationCalculator))
				calculator.metrics.modularizationQuality
			}
			MinMaxDiff : minimize {
				val calculator = solution.getAttribute(attribute, typeof(ModularizationCalculator))
				calculator.metrics.minMaxDiff
			}
			SolutionLength : minimize new TransformationLengthDimension // generic objectives
		}
		
		constraints = { // mark invalid solutions
			UnassignedClasses : minimize { 
				penalty * (root as ModularizationModel).classes.filter[c | c.module == null].size
			}
			EmptyModules : minimize { 
				penalty * (root as ModularizationModel).^modules.filter[m | m.classes.empty].size
			}
		}
		solutionRepairer = new TransformationPlaceholderRepairer
	}
	
	algorithms = {
		NSGAIII : moea.createNSGAIII(
			0, 6,
			new TournamentSelection(2),
			new OnePointCrossover(1.0), 
			new TransformationPlaceholderMutation(0.10),
			new TransformationVariableMutation(orchestration.searchHelper, 0.10))
		eMOEA : moea.createEpsilonMOEA(
			0.02,
			new TournamentSelection(2),
			new OnePointCrossover(1.0), 
			new TransformationPlaceholderMutation(0.10),
			new TransformationVariableMutation(orchestration.searchHelper, 0.10))
		RS : moea.createRandomSearch
	}
	
	equalityHelper = {
		if(left instanceof Module && right instanceof Module) {
			val leftIndex = (left.eContainer as ModularizationModel).^modules.indexOf(left)
			val rightIndex = (right.eContainer as ModularizationModel).^modules.indexOf(right)
			return leftIndex.equals(rightIndex) 
		}
		left.equals(right)
	}
} 

experiment = {
	populationSize = 300
	maxEvaluations = 21000
	nrRuns = 30
	progressListeners = [ new SeedRuntimePrintListener ]
}

analysis = {
	indicators = [ hypervolume generationalDistance contribution ]
	significance = 0.01
	show = [ aggregateValues statisticalSignificance individualValues ]
}

finalization = {
	saveAnalysis "data/output/analysis/mtunis_statistic2.txt"
	saveObjectives "data/output/approximationSet/mtunis_statistic2.pf"
	saveSolutions "data/output/models/mtunis_statistic2/"
	printSolutions 
	printObjectives 
}
```

### Output Example
One solution which has been produced by the given configuration is shown below.
In this solution, the *mtunis* system has been divided into 6 components.
The respective values for the objectives and constraints are:

<table>

<thead>
<tr>
<th>Dimension</th>
<th>Value</th>
</tr>
</thead>
<tbody>
<tr>
<td>Coupling</td>
<td style="text-align:right">68</td>
</tr>
<tr>
<td>Cohesion</td>
<td style="text-align:right">23</td>
</tr>
<tr>
<td>Modularization Quality</td>
<td style="text-align:right">1.964</td>
</tr>
<tr>
<td>Number of Modules</td>
<td style="text-align:right">6</td>
</tr>
<tr>
<td>Min-Max Difference</td>
<td style="text-align:right">5</td>
</tr>
<tr>
<td>Unassigned Classes</td>
<td style="text-align:right">0</td>
</tr>
<tr>
<td>Empty Modules</td>
<td style="text-align:right">0</td>
</tr>
</tbody>
</table>


<div style="text-align:center; margin-top: 2em">
<img src="http://martin-fleck.github.io/momot/images/casestudy/class_modularization/modularization_model_output.svg" alt="Modularization Meta-Model" />
</div>
