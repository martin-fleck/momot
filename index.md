---
title: MOMoT - Marrying Search-based Optimization and Model Transformation Technology
layout: index
---
### What is MOMoT?
MOMoT is a framework that combines model-driven engineering (MDE) techniques with search-based optimization (population-based search and local search) to solve highly complex problems on model level.

In this framework, problems are represented thorugh Ecore meta-models and their respective model instances. 
These problem instances can be manipulated through dedicated model transformations modeled as graph transformation rules Henshin. 
Desired and prohibited characteristics (objectives and constraints) of the output model can be specified using OCL or a Java-like expression language (Xbase).
Search-based optimization techniques can then be used to search for a Pareto-optimal set of transformation orchestrations, i.e., an ordered sequence of transformations and their parameters, to produce models with these characteristics.

### How to use MOMoT?
MOMoT is developed for the Eclipse platform and provides a dedicates configuration language providing support for model  engineers to configure the search process.
MOMoT has been successfully applied on several case studies which showcase how to use MOMoT in a specific scenario.
A description about the specific case study, the necessary inputs and the configuration can be found on the respective case study page: 

* [Stack](casestudy/stack): A simple DSL to balance the load between a set of stacks.
* [Modularization](casestudy/modularization): Building modules based on a set of classes and five objectives.
* [Class Diagram Restructuring](casestudy/restructuring): This case study is taken from the [Transformation Tool Contest](http://www.transformation-tool-contest.eu/) of 2013 and aims at minimizing the attributes and classes in a system.
* [EMF Refactor](casestudy/emfrefactor): EMF Refactor is an existing Eclipse project which can calculate metrics and perform refactorings on Ecore and UML models. In this case study we show how their artifacts can be used in MOMoT. *Note: Currently only a base version of this is online. The final case study will be available until 15 October.*

### Authors and Contributors
MOMoT has been developed by Martin Fleck ([@martin-fleck](https://github.com/martin-fleck)), Javier Troya ([@javitroya](https://github.com/javitroya)) and Manuel Wimmer.
At this point, we would like to thank the developers of the following frameworks, which we have used in order to develop MOMoT:

* [Eclipse Henshin](http://www.eclipse.org/henshin/): Henshin is used to formulate the transformation units to manipulate the model.
* [MOEA Framework](http://moeaframework.org/): The MOEA framework provides the basis for formulating the transformation orchestration problem as an optimization problem. It already supports a lot of algorithms which are re-used in MOMoT.
* [Eclipse OCL Project](http://projects.eclipse.org/projects/modeling.mdt.ocl): The OCL Project is used to evaluate objectives and constraints specified in the OCL language.
* [Eclipse Xbase](https://wiki.eclipse.org/Xbase): Xbase is a statically typed expression language for Java, that is implemented in Xtext and we have used it to implement the configuration language.

### Support or Contact
If you have encountered any problems with MOMoT or have suggestions of how we can improve it, please do not hesitate to contact Martin Fleck.
