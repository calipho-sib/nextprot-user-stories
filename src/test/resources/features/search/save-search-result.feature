Feature: Save search result as list

  As a end user of www.nextprot.org
  I want to save the result of my previous search
  so that I can access to results in my private space

  Background:
    Given I am on "search" nextprot page
    And I "should not" be logged
    And I make a simple search with query "kinase"

  Scenario: Guest cannot save selected results
    When I select first search result
    And I click on button "Save as list"
    Then the list "should not" be saved

  Scenario: Logged user can save selected results
    Given I click on link "Login"
    And I click on googleplus button
    And I "should" be logged
    When I select first search result
    And I click on button "Save as list"
    Then the list "should" be saved
