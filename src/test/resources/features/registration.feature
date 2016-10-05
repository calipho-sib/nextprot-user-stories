Feature: Registration to neXtProt with auth0

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

  Scenario: Login with email account
    When I click on link "Login"
    And I sign "in" the form with email "ndu@isb-sib.ch" and password "Npteam.1"
    And I submit to auth0
    Then I "should" be logged

  Scenario: Logout from nextprot
    Given I click on link "Login"
    And I click on googleplus button
    And I "should" be logged
    When I click on dropdown
    And I click on link "Logout"
    Then I "should not" be logged

  Scenario: Error occurs when sign up with existing email account
    Given I click on link "Login"
    When I click on sign up
    And I sign "up" the form with email "ndu@isb-sib.ch" and password "Npteam.1"
    And I submit to auth0
    Then a signup error appears with message "The user already exists"
