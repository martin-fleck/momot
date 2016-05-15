---
title: MOMoT - Marrying Search-based Optimization and Model Transformation Technology
layout: index
---
### What is MOMoT?
<img src="images/logo.png" style="max-width:230px; float: right; padding: 10px;">
<div stlye="float:left; clear:both;">MOMoT is a framework that combines model-driven engineering (MDE) techniques with search-based optimization (population-based search and local search) to solve highly complex problems on model level.

In this framework, problems are represented through Ecore meta-models and their respective model instances. 
These problem instances can be manipulated through dedicated model transformations modeled as graph transformation rules Henshin. 
Desired and prohibited characteristics (objectives and constraints) of the output model can be specified using OCL or a Java-like expression language (Xbase).
Search-based optimization techniques can then be used to search for a Pareto-optimal set of transformation orchestrations, i.e., an ordered sequence of transformations and their parameters, to produce models with these characteristics.
</div>

### How to use MOMoT?
MOMoT is developed for the Eclipse platform and provides a dedicated configuration language providing support for model  engineers to configure the search process.
MOMoT has been successfully applied on several case studies which showcase how to use MOMoT in a specific scenario.
A description about the specific case study, the necessary inputs and the configuration can be found on the respective case study page: 

* [Stack](casestudy/stack)
* [Class Modularization](casestudy/class_modularization)
* [Class Diagram Restructuring](casestudy/class_restructuring)
* [EMF Refactor](casestudy/emfrefactor)
* [Class Responsibility Assignment](casestudy/class_responsibility_assignment)
* [Towards Generic Modularization](casestudy/generic_modularization)


You can view download the necessary Eclipse plugins projects from [GitHub](https://github.com/martin-fleck/momot) or directly using the [Eclipse Update Site](http://martin-fleck.github.io/momot/eclipse/updates/). As dependencies you also need to have [Xtext](www.eclipse.org/Xtext/) and [Henshin](http://www.eclipse.org/henshin/) installed which are automatically retrieved when you use the update site.

### Authors and Contributors
MOMoT has been developed by Martin Fleck ([@martin-fleck](https://github.com/martin-fleck)), Javier Troya ([@javitroya](https://github.com/javitroya)) and Manuel Wimmer ([@manuelWimmer](https://github.com/manuelWimmer)).
At this point, we would like to thank the developers of the following frameworks, which we have used in order to develop MOMoT:

* [Eclipse Henshin](http://www.eclipse.org/henshin/): Henshin is used to formulate the transformation units to manipulate the model.
* [MOEA Framework](http://moeaframework.org/): The MOEA framework provides the basis for formulating the transformation orchestration problem as an optimization problem. It already supports a lot of algorithms which are re-used in MOMoT.
* [Eclipse OCL Project](http://projects.eclipse.org/projects/modeling.mdt.ocl): The OCL Project is used to evaluate objectives and constraints specified in the OCL language.
* [Eclipse Xbase](https://wiki.eclipse.org/Xbase): Xbase is a statically typed expression language for Java, that is implemented in Xtext and we have used it to implement the configuration language.

### Related Publications
* Fleck M, Troya J, Wimmer M. Marrying Search-based Optimization and Model Transformation Technology. *Proc. of the 1st North American Search Based Software Engineering Symposium (NasBASE’15)*, 2015. To appear. [PDF](downloads/NasBASE_MOMoT.pdf).

### Support or Contact
If you have encountered any problems with MOMoT or have suggestions of how we can improve it, please do not hesitate to contact [Martin Fleck](http://www.big.tuwien.ac.at/staff/mfleck).
