Feature: Test login functionality

  Background: 
    Given browser open
    When user given URL
@smoke
  Scenario: Check login is successful with valid Credentials
    When user enters username and password
    And user hits enter
    Then user is navigated to the home page

@data
  Scenario Outline: multiple user login
    When user given "<userName>" and "<password>"
    When user click login button
    Then user successfully login to homepage

    Examples: 
      | userName                | password     |
      | performance_glitch_user | secret_sauce |
      | problem_user            | secret_sauce |
      | hhhdejhjhfjfhjfhhhhjfhh | secret_sauce |
      | standard_user           | secret_sauce |
