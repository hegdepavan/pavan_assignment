@interviewTest 
@author:pavan 
Feature: Search for a product using keyword and add a random product to cart  

@UI_TC_01
Scenario: Verify search and adding a product to cart
	Given user open application url 
	When user search with keyword "dosa"
	And user select "4" th item from search suggesion list
	Then verify product details page is displayed
	When user add "3" quantity to cart
	Then user verify the added product in my basket