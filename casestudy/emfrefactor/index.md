---
title: MOMoT EMF Refactor Case Study
layout: index
---

## EMF Refactor Case Study
[EMF Refactor](http://www.eclipse.org/emf-refactor/) is an existing Eclipse project which can calculate metrics and perform refactorings on Ecore and UML models. 
In particular, EMF Refactor supports metrics reporting, smell detection, and refactoring for models being based on the Eclipse Modeling Framework.
The following techniques can be used in a concrete specification of a new EMF model metric, smell, or refactoring:

* *Model metrics* can be concretely specified in Java, as OCL expressions, by Henshin pattern rules, or as a combination of existing metrics using a binary operator.
* *Model smells* can be concretely specified in Java, by Henshin pattern rules, or as a combination of an existing metric and a comparator like greater than (>).
* The three parts of a *model refactoring* can be concretely specified in Java, in Henshin (pattern rules for precondition checks; transformations for the proper model change), or as a combination of existing refactorings using the CoMReL language. 

In this case study we show how EMF Refactor artifacts, i.e., the model metrics and Henshin refactorings, can be used in MOMoT.

### Meta-Model
EMF Refacor provides its techniques for both the Ecore Meta-Model and the UML Meta-Model.

### Rules
EMF Refactor provides a large number or rules to calculate model metrics and provide model refactorings.
For a complete list, please look at their [wiki page](https://wiki.eclipse.org/Techniques) at Eclipse.
However, as mentioned above, the refactorings in EMF Refactor are actually split into parts: checks and the actual model changes.
We therefore show how these two separate transformations which are usually integrated within code can be integrated using another Henshin transformation, which then can be used within MOMoT.
As example we use the ``Remove Empty Sub EClass``-Refactoring, which removes an empty sub eClass from a super class. This eClass is not associated to another eClass. It has no features, no further sub EClasses, and it is not referred to as type of an EParameter.

**Initial Check:**
The initial check ensures that all preconditions are met before executing the actual refactoring.
For the example, this involves checking that the eClass (``selectedEObject``) is not associated to another eClass, it has no features, no further sub EClasses, and it is not referred to as type of an EParameter.
All these checks are implemented separately and executed through a so called *Independent Unit*. 
Independent Units have an arbitrary number of sub-units that are checked in nondeterministic order for executability. The first sub-unit found to be executable is executed.

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/emfrefactor/emfrefactor_rule_remove_empty_sub_eclass_initialcheck.svg" alt="EMF Refactor Check Rule: Remove Empty Sub-EClass" />
</div>

**Execution:**
The specified execution rule performs the actual model change, i.e., it removes the specified class (``selectedEClass``) from the model (``EPackage``). 
As it is the case with all henshin refactorings, the actual execution is again packaged into a so called *Sequential Unit*. 
A sequential unit has an arbitrary number of sub-units that are executed in the given order.
In this case, the unit is configure to fail if not all specified rules can be executed and in case of a failure all changes will be automatically undone.

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/emfrefactor/emfrefactor_rule_remove_empty_sub_eclass_execute.svg" alt="EMF Refactor Execute Rule: Remove Empty Sub-EClass" />
</div>

**Combined Check and Execution:** 
Without re-implementing the transformations, we can combine them using a so called *Conditional Unit*.
Conditional units can be used to bring the control-flow semantics of if-then-else into transformations.
Specifically, the then-part of the unit is only executed if a match for the if-part can be found. 
If no such match can be found and the optional else-part has been given, the else-part is executed instead.
In our example, we use the initial check rule in the if-part and the execution rule in the then-part, the else-part remains empty.

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/emfrefactor/emfrefactor_rule_remove_empty_sub_eclass.svg" alt="EMF Refactor Combined Rule: Remove Empty Sub-EClass" />
</div>

### Objectives and Constraints
The metrics that are provided by EMF Refactor can be used as objectives and constraints in MOMoT. 
However, one needs to ensure that the metrics are executed on the correct context, i.e., model element.
Whereas objectives and constraints of MOMoT are typically calculated from the root node of the model, EMF Refactor metrics can be applied on any context.
Again, several metrics for Ecore and UML can be calculated and listing them is out of the scope here (please see the EMF Refactor wiki).
Therefore we provide a simple example based on reducing the number of subclasses.

**Number of Subclasses:**
In order to calculate the total number of subclasses in an Ecore model, we can use the ``NSUPEC2`` metric from EMF Refactor. 
This metric however, is not applicable for EPackages, but calculates the number of subclasses based on a given class (```context```).
In order to use the provided NSUPEC2, we therefore first obtain all eClasses from the graph (``getDomain``). 
Then we set each eClass as the respective context of the metric calculator and calculate the number of subclasses.
The sum of all number of subclasses for each eClass is the objective we aim to minimize. 

```
SubClasses : minimize {
  val subClassCalculator = new NSUPEC2() // from EMF Refactor
	val eClasses = graph.getDomain(EcorePackage.Literals.ECLASS.eClass, true)
	var subClasses = 0.0;
	for(eClass : eClasses) {
		subClassCalculator.context = #[ eClass ]
		subClasses += subClassCalculator.calculate
	}					
	return subClasses;
}
```

### References
* [EMF Refactor](http://www.eclipse.org/emf-refactor/)
* [EMF Refactor Techniques](https://wiki.eclipse.org/Techniques)
* [Example project on GitHub](https://github.com/martin-fleck/momot/tree/master/projects/at.ac.tuwien.big.momot.examples.emfrefactor)

### Complete example configuration
```
The configuration will be available until 15 October.
```
