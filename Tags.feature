@mustRun
Feature: Feature to demo tags
#Tags Inheritance
#Tags that are placed above a Feature will be inherited by Scenario,Scenario Outline or Examples.

#Tags can be placed above the following Gherkin elements:
#Feature
#Scenario
#Scenario Outline
#Examples

#single tag
@smoke
Scenario: Sample 1
Given 
When 
And


@regression
Scenario: Sample 2
Given 
When 
And

#multiple tags
@smoke @regression
Scenario: Sample 3
Given 
When 
And

@important @regression
Scenario: Sample 4
Given 
When 
And

#skip or ignore case -> not









