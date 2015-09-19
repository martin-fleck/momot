---
title: MOMoT Class Diagram Restructuring Case Study
layout: index
---

## Class Diagram Restructuring Case Study
This case study is taken from the Transformation Tool Contest of 2013 and aims at minimizing the attributes and classes in a system.

`This page will be available soon.`


### Meta-Model
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/restructuring/restructuring_mm.svg" alt="Class Diagram Restructuring Meta-Model" />
</div>

### Rules
In the class diagram restructuring case study we use three rules to manipulate a class diagram and enhance its quality:

**Create Root Class**
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/restructuring/restructuring_rule_createRootClass.svg" alt="Restructuring Rule: Create Root Class" />
</div>

**Extract Super Class**
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/restructuring/restructuring_rule_extractSuperClass.svg" alt="Restructuring Rule: Extract Super Class" />
</div>
 
**Pull Up Attribute**
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/restructuring/restructuring_rule_pullUpAttribute.svg" alt="Restructuring Rule: Pull Up Attribute" />
</div>

### Objectives and Constraints
As objective we want to reduce the number of entities (attributes and classes) as a lower number of entities can be managed much more easily. 

**Content Size:** We prefer shorter solutions as the transformations are costly when executed in the real word.
```
ContentSize : minimize "propertys->size() * 1.1 + entitys->size()"
```

**Solution Length:** We prefer shorter solutions as the transformations are costly when executed in the real word.

```
SolutionLength 	: minimize new TransformationLengthDimension
```

### References
* [Example project on GitHub](https://github.com/martin-fleck/momot/tree/master/projects/at.ac.tuwien.big.momot.examples.refactoring)
* [Transformation Tool Contest](http://www.transformation-tool-contest.eu/)

### Complete example configuration
```
initialization = {
	RefactoringPackage::eINSTANCE.eClass
}

search = {
	model = "model/SeveralRefactorings.xmi"
	solutionLength = 10
	
	transformations = {
		modules = [ "model/Refactoring.henshin" ]
	}
	
	fitness = {
		objectives = {
			SolutionLength : minimize new TransformationLengthDimension
			ContentSize : minimize "propertys->size() * 1.1 + entitys->size()"
		}
		solutionRepairer = new TransformationPlaceholderRepairer
	}
	
	algorithms = {
		NSGAII : moea.createNSGAII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),  
				new TransformationPlaceholderMutation(0.15))
		NSGAIII : moea.createNSGAIII(
				new TournamentSelection(2),
				new OnePointCrossover(1.0),  
				new TransformationPlaceholderMutation(0.15))
	}
}
experiment = {
	populationSize = 50
	maxEvaluations = 1500
	nrRuns = 30
	progressListeners = [ new SeedRuntimePrintListener ]
}

finalization = {
	saveObjectives "model/output/referenceSet/approximation_set.pf"
	saveSolutions "model/output/solutions/"
}
```
