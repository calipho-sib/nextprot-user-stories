Feature: Registration to neXtProt with auth0

  As a end user of neXtProt
  I want to register
  so that I can access my user space
  and access more services

  Background:
    Given I navigate to url of nextprot "any"
    And I should not be logged to nextprot

  Scenario: Login with a gmail account
    Given I navigate to url "http://www.gmail.com"
    And I sign in with gmail as "ndu.google.email"
    And I navigate to url of nextprot "any"
    When I click on link text "Login"
    And I click on google+ button
    Then I should be logged to nextprot

  Scenario: Login with email account
    When I click on link text "Login"
    And I sign in with email as "ndu.email"
    And I submit to auth0
    Then I should be logged to nextprot

  Scenario: Logout from nextprot
    Given I click on link text "Login"
    And I sign in with email as "ndu.email"
    And I submit to auth0
    And I should be logged to nextprot
    When I click on logged user drop-down
    And I select option "Logout"
    Then I should not be logged to nextprot

  Scenario: Error occurs when sign up with existing email account
    Given I click on link text "Login"
    When I click on sign up
    And I sign up with email as "ndu.email"
    And I submit to auth0
    Then a signup error appears with message "The user already exists"
