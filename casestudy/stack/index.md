---
title: MOMoT Stack Case Study
layout: index
---

## Stack Case Study
The Stack case study is an artificial, simple problem domain which may abstract from the area of logistics.
In this case study we have a set of containers (stacks) which carry a specific load. 
The containers are connected in a circular way so that each container has a left and a right neighbor.
The task is now to ensure that the overall load is equally distributed between the containers and that the load balancing is done in as few steps as possible.

### Meta-Model
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/stack/stack_mm.svg" alt="Stack Meta-Model" />
</div>

In the meta-model the whole system is represented as a ```StackModel``` containing a number of stacks. 
Each ```Stack``` has a specified load and is uniquely identified through an id.
Stacks are connected to each other so that each stack has a left and right neighbor so that the left neighbor of one stack is its right neighbor. 

### Rules
<div style="text-align:center">
<img src="http://martin-fleck.github.io/momot/images/casestudy/stack/stack_rules.svg" alt="Stack Rules" />
</div>

In order to manipulate a Stack model, we need to be able to shift the load from one stack to one of its neighbors. 
We therefore implement two rules: *shiftLeft* and *shiftRight* which do exactly that.
Both of these rules have a negative application condition (NAC) expressed in an attribute condition *SufficientLoad*.
These NACs ensure that not more load is shifted than is available on the stack, i.e., no stack will ever have a negative load. 
Please note that this NAC could also have been expressed as an invariant in the Stack Meta-Model.
However, to demonstrate the use of attribute NACs, we have implemented it this way.

### Parameters
Since when we shift a load from one stack to another, the ``amount`` parameter can not be matched automatically by the graph transformation engine, we categorize it as a so called *user parameter* which requires user input. In an automated approach however, this user input is substituted by a random value generator. We therefore provide a random integer generator for this parameter which produces results in the range from 1 to 5.

```
StackModule.ShiftLeft.Parameter.AMOUNT  : new RandomIntegerValue(1, 5)
StackModule.ShiftRight.Parameter.AMOUNT : new RandomIntegerValue(1, 5)
```

### Objectives and Constraints
**Standard Deviation:** To provide an equally distributed load, we minimize the standard deviations of all stacks load.

```
StandardDeviation : minimize { 
	MathUtil.getStandardDeviation((root as StackModel).stacks.map[load])
}
```

**Solution Length:** We prefer shorter solutions as the transformations are costly when executed in the real word.

```
SolutionLength 	: minimize new TransformationLengthDimension
```

### Resources
* [Example project on GitHub](https://github.com/martin-fleck/momot/tree/master/projects/at.ac.tuwien.big.momot.examples.stack)

### Complete example configuration

```
initialization = { // register stack meta-model etc.
	StackPackage.eINSTANCE.class
}

search = {
	model = "model/input/model/model_five_stacks.xmi"
	solutionLength = 8
	
	transformations = {
		modules = [ "model/stack.henshin" ] 
		ignoreParameters = [ // not needed in solution
			StackModule.ShiftLeft.Parameter.FROM_LOAD,
			StackModule.ShiftLeft.Parameter.TO_LOAD,
			StackModule.ShiftRight.Parameter.FROM_LOAD, 
			StackModule.ShiftRight.Parameter.TO_LOAD
		]		
		parameterValues = { // values for user parameters
			StackModule.ShiftLeft.Parameter.AMOUNT  : new RandomIntegerValue(1, 5)
			StackModule.ShiftRight.Parameter.AMOUNT : new RandomIntegerValue(1, 5)
		}
	}
	
	fitness = {
		objectives = { 
		 	StandardDeviation : minimize { 
		 		MathUtil.getStandardDeviation((root as StackModel).stacks.map[load])
		 	}
		 	SolutionLength 	: minimize new TransformationLengthDimension
		}
		solutionRepairer = new TransformationPlaceholderRepairer
	}
	
	algorithms = {
	   Random	: moea.createRandomSearch()
	   NSGA_II	: moea.createNSGAII(
	   				new TournamentSelection(2),
	   				new OnePointCrossover(1.0), 
					new TransformationPlaceholderMutation(0.15),
					new TransformationParameterMutation(0.1, orchestration.moduleManager))
	   NSGA_III	: moea.createNSGAIII(
	   				4,
	   				new TournamentSelection(2),
	   				new OnePointCrossover(1.0), 
					new TransformationPlaceholderMutation(0.15),
					new TransformationParameterMutation(0.1, orchestration.moduleManager))
	}	
}

experiment = {
	populationSize    = 100
	maxEvaluations    = 5000
	nrRuns            = 30
	referenceSet      = "model/input/referenceSet/model_five_stacks_reference_set.pf"
	progressListeners = [ new SeedRuntimePrintListener ]
}
	
analysis = {
	indicators   = [ hypervolume additiveEpsilonIndicator maximumParetoFrontError  ]
	significance = 0.01
	show         = [ individualValues aggregateValues statisticalSignificance ]
}
	
finalization = {
	saveAnalysis   "model/output/analysis.txt"
	saveObjectives "model/output/approximationSet/overall_objectives.pf"
	saveObjectives [ NSGA_III, NSGA_II ] "model/output/approximationSet/moea_objectives.pf"
	saveSolutions  "model/output/solutions/all/"
	saveSolutions  [ NSGA_III, NSGA_II ] "model/output/solutions/moea/"	
}	
```
