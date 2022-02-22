@flightdetails
Feature: feature for flight search functionality


Scenario: validate the flight search between two cities and date.

Given user is on home page of website
When user click on from box 
And selects city
Then user selects destination city
And departure date 
And return date
Then user clicks on search flight
When user is selected the flight 
And hits continue button

Scenario:

Given user is on passenger details page
When user fills contact details  
And passenger information 
Then click on continue button




Scenario:

Given user is on add-ons page
When user clicks on add your seat
And selects seat






