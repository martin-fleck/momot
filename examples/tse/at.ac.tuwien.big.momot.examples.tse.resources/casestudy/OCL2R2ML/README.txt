*********************************************************
** Description: OCL2R2ML ATL transformation scenario
** Author: 	Milan Milanovic <milan at milanovic.org>
** Date: 	October 10, 2006
********************************************************

This ATL scenario transforms OCL (Object Constraint Language) into R2ML (REWERSE I1 Markup Language). 
It is composed of OCL EBNF injector (to OCL metamodel), transformations (OCL2R2ML) and an R2ML extractor 
that produces XML documents that conform to the R2ML syntax defined by REWERSE I1 group. To find more 
details about this transformation scenario, please refer to [1]-[2].  

See also: 
	-- R2ML2OCL transformations scenario
	-- R2ML (REWERSE I1 Rule Markup Language) - http://oxygen.informatik.tu-cottbus.de/rewerse-i1/?q=node/6
	-- Object Constraint Language - OMG Available Specification, Version 2.0, formal/06-05-01. 
                                        [Online] http://www.omg.org/cgi-bin/doc?formal/06-05-01

Transformation files:
---------------------
	- R2ML2XML.atl: ATL transformation that transforms an R2ML model into an
	                an XML models with R2ML syntax elements.

	- OCL2R2ML.atl: The core transformation, that produced an R2ML model from
                        a OCLmodel (instance of OCLmetamodel).

	- OCL2R2ML.xml: An ANT script that automatically executes the 2 ATL transformations, 
	                EBNF injector to produce OCL model from OCL file, and a XML extractor
                        to produce R2ML XML documents from R2ML model. It can be 
                        executed by right-clicking on it, then clicking on "Run As->Ant Build". 
                        To execute this transformation on other SWRL examples, place your OCL invariant files
                        in the models/ocl folder and make necessary changes in ANT script.
	  
Metamodel files:
----------------
	- XML.xmi: XML metamodel in MOF XMI 1.2 format (MOF-1.4). This metamodel is part of standard metamodels 
                   used with ATL. It is used when models are tranformed into XML documents or vice versa.

	- OCL.xmi: OCL metamodel in MOF XMI 1.2 format (MOF-1.4). This model represents an abstract syntax for
                   the OCL language.

	- R2ML.xmi: R2ML metamodel in MOF XMI 1.2 format (MOF-1.4). Metamodel of the R2ML language.
		    
	- Every metamodel have KM3 and Ecore EMF XMI 2.0 format versions.
	
Sample files:
-------------
	- Models/ocl/m1.ocl: This file is simple OCL invariant and is used as input example by 
                             this transformation scenario.

	- Models/r2ml-xml/R2MLRule.xml: This file is R2ML rule in the R2ML XML format after executing OCL EBNF injector,
                                        the OCL2R2ML transformation, the R2ML2XML transformation and XML extractor.

Other files:
------------
	- OCL-ebnfinjector.jar: OCL EBNF injector that is used to translate OCL code into OCL model.

References:
-----------
[1] Milanović, M., Gašević, D., Guirca, A., Wagner, G., Devedžić, V., "Towards Sharing Rules Between OWL/SWRL and UML/OCL", Electronic Communications of the European Association of Software Science and Technology, Volume 5, 2006.
[2] Milanović, M. "Modeling rules on the Semantic Web", master thesis, GOOD OLD AI Lab, Faculty of organizational sciences, University of Belgrade.
