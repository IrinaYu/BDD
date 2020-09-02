@Regression
Feature: Create Issue


   Background: Login to JIRA
    Given I navigate to Jira Login Page
    And I enter user name - "IrynaKapustina"
    And I enter password - "IrynaKapustina"
    And I click on the login button
    Then I am on the Home Page


#  @Regression
   Scenario: Create Issue
    And I click Create button
    Then I am in the Create Issue form
    And I fill Project field - "Webinar (WEBINAR)"
    And I fill Issue Type field - "Задача"
    And I fill Summary field - "Summary"
    And I fill Reporter field - "IrynaKapustina"
    When I click Submit button
    Then Pop up with number of created issue is shown



