Feature: Registration to neXtProt

  As a end user of neXtProt
  I want to register
  so that I can access my user space
  and access more services

  Background:
    Given I am on "any" nextprot page
    And I "should not" be logged

  Scenario: Login with my google account
    When I click on link "Login"
    And I click on googleplus button
    Then I "should" be logged

  Scenario: Logout from nextprot
    Given I click on link "Login"
    And I click on googleplus button
    And I "should" be logged
    When I click on dropdown
    And I click on link "Logout"
    Then I "should not" be logged
