---
title: MOMoT Stack Case Study
layout: index
---

## Stack Case Study
`This page will be available soon.`

### Meta-Model
![Stack Meta-Model](http://martin-fleck.github.io/momot/images/casestudy/stack/stack_mm.svg)


### Rules
In order to manipulate a Stack model, we need to be able to shift the load from one stack to one of its neighbors. 
We therefore implement two rules: 'shiftLeft' and 'shiftRight' which do exactly that.
Both of these rules have a negative application condition (NAC) expressed in an attribute condition 'SufficientLoad'.
These NACs ensure that not more load is shifted than is available on the stack, i.e., no stack will ever have a negative load. 
Please note that this NAC could also have been expressed as an invariant in the Stack Meta-Model.
However, to demonstrate the use of attribute NACs, we have implemented it this way.

![Stack Meta-Model](http://martin-fleck.github.io/momot/images/casestudy/stack/stack_rules.svg)

### Objectives and Constraints
* Standard Deviation: To provide an equally distributed load, we minimize the standard deviations of all stacks load.
```
StandardDeviation : minimize { MathUtil.getStandardDeviation((root as StackModel).stacks.map[load]) }
```
* Solution Length: We prefer shorter solutions as the transformations are costly when executed in the real word.
```
StandardDeviation : minimize { MathUtil.getStandardDeviation((root as StackModel).stacks.map[load]) }
```

### References


### Complete example configuration

```
initialization = {
	StackPackage.eINSTANCE.class
}

search = {
	model = "model/input/model/model_five_stacks.xmi"
	solutionLength = 8
	
	transformations = {
		modules = [ "model/stack.henshin" ] 
		ignoreUnits = [ 
			StackModule.CreateStack.NAME, 
			StackModule.ConnectStacks.NAME
		]
		ignoreParameters = [
			StackModule.ShiftLeft.Parameter.FROM_LOAD,
			StackModule.ShiftLeft.Parameter.TO_LOAD,
			StackModule.ShiftRight.Parameter.FROM_LOAD, 
			StackModule.ShiftRight.Parameter.TO_LOAD
		]		
		parameterValues = {
			StackModule.ShiftLeft.Parameter.AMOUNT  : new RandomIntegerValue(1, 5)
			StackModule.ShiftRight.Parameter.AMOUNT : new RandomIntegerValue(1, 5)
		}
	}
	
	fitness = {
		objectives = { 
		 	StandardDeviation : minimize { MathUtil.getStandardDeviation((root as StackModel).stacks.map[load]) }
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
	   				new TournamentSelection(2),
	   				new OnePointCrossover(1.0), 
						new TransformationPlaceholderMutation(0.15),
						new TransformationParameterMutation(0.1, orchestration.moduleManager))
	}	
}

experiment = {
	populationSize 	= 100
	maxEvaluations 	= 5000
	nrRuns 				= 30
	referenceSet 		= "model/input/referenceSet/model_five_stacks_reference_set.pf"
	progressListeners = [ new SeedRuntimePrintListener ]
}
	
analysis = {
	indicators		= [ hypervolume additiveEpsilonIndicator maximumParetoFrontError  ]
	significance	= 0.01
	show 				= [ individualValues aggregateValues statisticalSignificance ]
}
	
finalization = {
	saveAnalysis "model/output/analysis.txt"
	
	saveObjectives "model/output/approximationSet/overall_objectives.pf"
	saveObjectives [ NSGA_III, NSGA_II ] "model/output/approximationSet/moea_objectives.pf"
	
	saveSolutions 	"model/output/solutions/all/"
	saveSolutions 	[ NSGA_III, NSGA_II ] "model/output/solutions/moea/"	
}	
```
