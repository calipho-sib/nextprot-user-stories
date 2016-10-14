Feature: Save search result as list

  As a end user of www.nextprot.org
  I want to save the result of my previous search
  so that I can access to results in my private space

  Background:
    Given I navigate to "search" nextprot page
    And I "should not" be logged to nextprot
    And I make a simple search with query "kinase"

  Scenario: Guest cannot save selected results
    When I select search result with accession "NX_O95819"
    And I click on button "Save as list"
    Then the list "should not" be savable

  Scenario: Logged user can save selected results
    Given I click on link "Login"
    And I sign "in" with email as "ndu.email"
    And I submit to auth0
    When I select search result with accession "NX_O95819"
    And I click on button "Save as list"
    Then the list "should" be savable
