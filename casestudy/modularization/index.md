---
title: MOMoT Modularization Case Study
layout: index
---

## Modularization Case Study
A well-known problem in software architecture design that can often not be solved through exhaustive approaches is the modularization problem where the aim is to produce high-quality object-oriented models by grouping classes into modules.
Producing a class diagram where the right number of modules is chosen and a proper assignment of classes is realized is a non-trivial task, as the problem has an exponentially growing search space of potential class partitions

### Meta-Model
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/modularization/modularization_metamodel.svg" alt="Modularization Meta-Model" />
</div>

In our meta-model a system is represented by a ``ModularizationModel``, which consists of classes and modules. 
``Classes`` can have dependencies to each other and may be grouped into Modules. 
``Modules`` are the component-concept of our system and they group classes together.
A common, abstract superclass ``NamedElement`` ensures that all elements in the system have a name.

### Rules

**Create Module:**

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/modularization/modularization_rule_createModule.svg" alt="Modularization Meta-Model" />
</div>

**Assign Class:**

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/modularization/modularization_rule_assignClass.svg" alt="Modularization Meta-Model" />
</div>

### Objectives and Constraints



### References
* [Example project on GitHub](https://github.com/martin-fleck/momot/tree/master/projects/at.ac.tuwien.big.momot.examples.modularization.jsep)

### Input Example
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/modularization/modularization_model_input.svg" alt="Modularization Meta-Model" />
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
		NSGAII : moea.createEpsilonMOEA(
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
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/modularization/modularization_model_output.svg" alt="Modularization Meta-Model" />
</div>
