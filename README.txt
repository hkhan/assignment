ASSIGNMENT.
--------------------------------------------------------
--------------------------------------------------------

Archive Contents:
-----------------

This zip file has the following contents:

    1. An executable jar file containing the executable binary code.
    2. The project folder containing the source tree which also includes the .git folder containing some project
        development history and progression.
    3. 'rules' folder containing the default rule which can be modified and loaded for the formatter.

Requirements:
-------------

JRE 1.6 or above

Instructions:
------------

The executable jar can be run as follows:

1. execute the Demo class which demonstrates the formatting functionality
    java -jar assignment.jar

2. execute the Demo class which formats the specified input    
    java -jar assignment.jar 1234 567

3. load custom rules which can then be used to produce the formatted output. Note that only the rule text can be changed.
    java -cp ./rules:assignment.jar com.hk.text.Demo   
    
The source code is built using Maven. 'maven clean site' can be used to build the application and also generate appropriate
Javadoc, Cobertura code coverage and Findbugs reports.

Design Considerations:

The task presents relatively complex logic in terms of generating correct textual output from various combinations and
permutations of numbers. A recursion and rule-based approach has been used to meet the specification criteria as the
problem lends itself to being converted to rules which can be applied using simple logic. This allows the encapsulation
of the core logic in well-defined and simple components which can be easily tested.

- Components have been created with high cohesion (Single Responsibiliy Principle) in mind in order to perform specific tasks
- Interfaces have been used liberally in order to promote loose coupling
- Template Design Pattern has been used in the Substitution components in order to allow subclasses to provide specialized logic
- Factory Method Pattern has been used for constructing the top level Processor component
- packages are organized by feature e.g. validation

TDD has been used to develop components from lower level components, working upwards towards higher level more abstract ones.
Code has gone through several cycles of refactoring in order to work towards code which is easier to understand and maintain.