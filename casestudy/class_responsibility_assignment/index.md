---
title: MOMoT Class Responsibility Assignment Case Study
layout: index
---

## Class Class Responsibility Assignment Case Study
A well-known problem in software architecture design that can often not be solved through exhaustive approaches is the class responsibility assignment (CRA) problem, where the aim is to produce high-quality object-oriented models by grouping methods and attributes into classes.
When solving the CRA, you need to decide where features, under the form of class methods and attributes they manipulate, belong and how objects should interact.
Therefore, CRA is a non-trivial problem, often requiring human judgement and decision-making.

### Meta-Model
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/class_responsibility_assignment/cra_metamodel.svg" alt="Class Responsibility Assignment Meta-Model" />
</div>

In our meta-model a system is represented by a ``ClassModel``, which consists of classes and features. 
``Classes`` represent classes as known from common object-oriented programming language. 
A class serves as a container object for behavioral features (``Methods``) and data features (``Attributes``).
A method is used to describe a piece of executable behavior. 
Attributes are used to store concrete data values.
In the given metamodel we have *functional dependencies*, which refer to the dependencies among methods, and *data dependencies*, which refer to the dependencies between methods and attributes.
A common, abstract superclass ``NamedElement`` ensures that all elements in the system have a name.

### Rules

Our main idea to tackle the CRA problem, is to first, create as many classes as features in the input model to cover the worst case scenario, i.e., the case where all features are in a separate class. 
Second, we randomly assign any features which are not already contained in a class randomly to a class.
Third, we use the metaheuristic search to correct this random assignment by intelligently reassigning features to other classes.
And finally, we remove any empty classes from the solution models.

Following this approach, we need transformations to create classes and randomly assign features to them, and we need a transformation to reassign these features to optimize our objectives.
In order to demonstrate the expressive power of our configuration language, the first two transformations are realized directly as behavioural code in the search configuration file.

**Reassign Feature:**
The remaining transformation that is also used during the search process and reassigns features from one class to another.
For this, we assign a feature with the name ``featureName`` to a class with name ``className``.
Any prior encapsulation relation this feature had will be deleted.

<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/class_responsibility-assignment/cra_rule.svg" alt="Class Responsibility Assignment Rule" />
</div>

### Objectives and Constraints
Since modularization is such a common and well-studied problem, many metrics have been proposed which indicate the quality of a class.
Common metrics include coupling and cohesion.
In order to specify what needs to be optimized through MOMoT, i.e., the objectives, we need to define how to measure the coupling and cohesion ratio for our problem domain.
To calculate those properties, we create a Java class ([ModularizationCalculator](https://github.com/martin-fleck/momot/blob/master/projects/icmt.tool.momot.demo/src/icmt/tool/momot/demo/FitnessCalculator.java)), that uses the automatically generated model API and implements the formulas defined by Masoud and Jalili.
In the configuration example below, you can find how this external calculation can be integrated into the fitness evaluation of MOMoT.

**Coupling Ratio:**
Coupling refers to the number of external dependencies a specific module has, i.e., the sum of inter-relationships with other modules.
Typically, low coupling is preferred as this indicates that a group covers separate functionality aspects of a system, improving the maintainability, readability and testability of the overall system.

**Cohesion Ratio:**
Cohesion refers to the dependencies within a module, i.e., the sum of intra-relationships in the module.
As opposed to coupling, the cohesion within one module should be maximized to ensure that it does not contain parts that are not part of its functionality.

**Solution Length:**
Furthermore, we are interested in the length of the solution, i.e., the number of transformations needed to create the model with optimized coupling and cohesion.

### References
* M. Bowman, L. C. Briand and Y. Labiche: "Solving the Class Responsibility Assignment Problem in Object-Oriented Analysis with Multi-Objective Genetic Algorithms" in IEEE Transactions on Software Engineering, vol. 36, no. 6, pp. 817-837, 2010. doi:[10.1109/TSE.2010.70](http://dx.doi.org/10.1109/TSE.2010.70).
* Hamid Masoud, Saeed Jalili: "A clustering-based model for class responsibility assignment problem in object-oriented analysis" in Journal of Systems and Software, volume 93, pp. 110-131, 2014. doi:[10.1016/j.jss.2014.02.053](http://dx.doi.org/10.1016/j.jss.2014.02.053)
* [Example project on GitHub](https://github.com/martin-fleck/momot/tree/master/projects/icmt.tool.momot.demo)


### Complete example configuration
```
initialization = {
	ArchitecturePackage.eINSTANCE.eClass // register package
	System.out.println("Search started.");
}

search = {
	model          = {
		file       = "problem/Cart_Item.xmi"
		adapt      = {
			// add one class per feature
			var cm = root as ClassModel
			for(i : 0 ..< cm.features.size - cm.classes.size) {
				var newClass = ArchitectureFactory::eINSTANCE.createClass()
				newClass.name = "Class_" + i
				cm.classes.add(newClass)
			}
			for(feature : cm.features) // distribute features randomly
				if(feature.isEncapsulatedBy == null)
					cm.classes.get(MathUtil.randomInteger(cm.classes.size)).encapsulates.add(feature)
			return cm
		}
	}
	solutionLength  = 30 // at most 30 orchestrated transformation units

	transformations = {
		modules = [ "transformations/architecture.henshin" ]
	}

	fitness         = {
		objectives = {
			CouplingRatio : minimize { FitnessCalculator.calculateCoupling(root as ClassModel) }
			CohesionRatio : maximize { FitnessCalculator.calculateCohesion(root as ClassModel) }
			SolutionLength : minimize new TransformationLengthDimension
		}
	}

	algorithms      = {
		Random  : moea.createRandomSearch()
		NSGAIII : moea.createNSGAIII()
		eMOEA   : moea.createEpsilonMOEA()
	}
}

experiment = {
	populationSize    = 100
	maxEvaluations    = 10000
	nrRuns            = 10
	progressListeners = [ new SeedRuntimePrintListener ]
}

analysis = {
	indicators       = [ hypervolume invertedGenerationalDistance ]
	significance     = 0.01
	show             = [ aggregateValues statisticalSignificance individualValues ]
	outputFile       = "output/analysis/analysis.txt"
	boxplotDirectory = "output/analysis/"
	printOutput
}

results = {
	adaptModels = {
		// remove empty classes 
		val cm = root as ClassModel
		val emptyClasses = cm.classes.filter[c | c.encapsulates.size == 0]
		cm.classes.removeAll(emptyClasses)
	}
	
	// save objectives
	objectives = {
		outputFile      = "output/objectives/objective_values.txt"
		printOutput
	}
	
	objectives = {
		outputFile      = "output/objectives/random_objective_values.txt"
		algorithms      = [ Random ]
	}

	// save solutions, i.e., transformation orchestrations
	solutions  = {
		outputFile      = "output/solutions/all_solutions.txt"
		outputDirectory = "output/solutions/"
	}

	// save models resulting from the orchestrated transformations
	models     = {
		outputDirectory = "output/models/"
	}
	
	// select kneepoint models for further inspection
	models     = {
		neighborhoodSize = maxNeighborhoodSize
		outputDirectory  = "output/models/kneepoints/"
	}
}

finalization = {
	System.out.println("Search finished.");
}
```
