@interviewTest 
@author:pavan 
Feature: Get vaccination sessions   

@API_TC_01
Scenario: Verify Get vaccination sessions API by district
	Given user have "appointment" API url with data "get.by.district"  
	When user send "GET" request
	Then response status code should be "200"
	And print the response body in console 

@API_TC_02
Scenario: Verify Get vaccination sessions by PIN for 7 days
	Given user have "appointment" API url with data "get.by.pincode"  
	When user send "GET" request
	Then response status code should be "200"
	And print the response body in console 