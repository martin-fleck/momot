---
title: MOMoT Class Diagram Restructuring Case Study
layout: index
---

## Class Diagram Restructuring Case Study
This case study is taken from the [Transformation Tool Contest](http://www.transformation-tool-contest.eu/) of 2013 and aims at minimizing the attributes and classes in a system through in-place refactoring transformations. 
A problem instance consists of a set of classes and their attributes as well as possible inheritance relationships between the classes.
The goal is to remove duplicate attributes from the overall class diagram, and to identify new classes which abstract data features shared in a group of classes in order to minimize the number of entities, i.e., classes and attributes.

### Meta-Model
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/restructuring/restructuring_mm.svg" alt="Class Diagram Restructuring Meta-Model" />
</div>

In our meta-model we represent the complete system as a ``model`` which consists of entities (i.e., classes) and properties (i.e., attributes). ``Entities`` can have an inheritance relation (expressed through ``Generalization``) and ``properties`` have a specific ``type``, e.g., Integer.
All elements in the system are identified through a unique name. 

### Rules
In the class diagram restructuring case study we use three rules to manipulate a system and enhance its quality. 
The parameters of all rules can be matched automatically by the graph transformation engine and do not require any additional input from the user.

**Pull Up Attribute:** 
This rule moves an attribute (``n``) that exists in all sub-classes of a specific class (``e``) into the respective class. 
The provided OCL negative application condition ensures that this rule is only applied if all sub-classes of the specified class contain the attribute.
Please note that a nested rule in Henshin (indicated by a ``*`` in the action name) is executed as often as possible if the outer rule matches.

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/restructuring/restructuring_rule_pullUpAttribute.svg" alt="Restructuring Rule: Pull Up Attribute" />
</div>

**Extract Super Class:**
This rule is similar to the first one, in that it moves a common attribute (``n``).
However, in this scenario, not all sub-classes of an already existing superclass share that attribute.
Therefore, we introduce a new level of inheritance and create a new superclass for that attribute which in turn inherits from the original superclass.
The rule is formulated in a way so that it only fires if at least two classes (``e1`` and ``e2``) share an attribute.

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/restructuring/restructuring_rule_extractSuperClass.svg" alt="Restructuring Rule: Extract Super Class" />
</div>

**Create Root Class:** 
This rule is used to create a new class for a common attribute (``n``) for classes that do not already have a superclass. 
The rule is formulated in a way so that it only fires if at least two classes (``e1`` and ``e2``) share an attribute.

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/restructuring/restructuring_rule_createRootClass.svg" alt="Restructuring Rule: Create Root Class" />
</div> 


### Objectives and Constraints
As objective we want to reduce the number of elements (attributes and classes) as a lower number of elements can be managed much more easily. 
However, in this case study, the order in which the three rules are executed has a direct effect on the quality of the resulting model.
In this sense, pulling up attributes should have priority over extracting super classes and this one over creating root classes.
Such a definition of rule priority is only possible by using the *Priority Units* of Henshin or by putting a weight on how the number of elements is calculated.

**Content Size:** 
Weighted number of elements with a focus on number of classes (``entitiys``) so that a higher number of classes results in a worse fitness than a higher number of attributes (``propertys``).
This ensures that the creation of classes is avoided if possible.

```
ContentSize : minimize "propertys->size() * 1.1 + entitys->size()"
```

**Solution Length:** We prefer shorter solutions as the transformations are costly when executed.

```
SolutionLength 	: minimize new TransformationLengthDimension
```

### Resources
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
