Feature: Add a user and log in as the user

Scenario: Add a user
	Given I can open the demo site
	When I add a user
	Then I can log in as the user