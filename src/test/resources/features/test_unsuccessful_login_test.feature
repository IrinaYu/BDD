Feature: Unsuccessful Login To Jira

  @Regression @wip
  Scenario Outline: Failed Login to Jira
    Given I navigate to Jira Login Page
    And I enter user "<name>"
    And I enter "<password>"
    And I click on the login button
    Then I see "<result>"

    Examples:
      | name           | password       | result                                                              |
      | SomeName       | IrynaKapustina | Sorry, your username and password are incorrect - please try again. |
      | SomeName       | SomePassword   | Sorry, your username and password are incorrect - please try again. |
      | IrynaKapustina | SomePassword   | Sorry, your username and password are incorrect - please try again. |