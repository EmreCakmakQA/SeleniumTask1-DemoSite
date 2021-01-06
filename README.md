# Selenium/Cucumber Task 1 - DemoSite

The aim of this repo is to demonstrate the use of cucumber and selenium. The task is to automate front end testing of a demo site.

In the demo website, you can add a user to the and then Login as that user, via the links in the nav bar at the top of the page.  

The task is to create an automated test that can create a user, and subsequently log in with that user, asserting that it was successful. 

Cucumber takes the following format, allowing for a pseudo-code approach that adds more organisation to the code.

```
Feature: Add a user and log in as the user

Scenario: Add a user
	Given I can open the demo site
	When I add a user
	Then I can log in as the user

```
The *Given, When, Then* syntax makes it great for styling off of a Jira board and incorporating user stories.

In this task, the "*Given that*" is written as follows:

```
@Given("^I can open the demo site$")
	public void i_can_open_the_demo_site() throws InterruptedException {
		driver.get(URL);
		assertEquals("FREE example PHP code and online MySQL database - example username password protected site", driver.getTitle());
	}

```

This allows for incorporation of Behaviour Driven Development.


