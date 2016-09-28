Feature: Save search result as list

  As a end user of www.nextprot.org
  I want to save the result of my previous search
  so that I can access to results in my private space

  Scenario: Guest cannot save selected results

    Given I am on "search" nextprot page
    And I make a simple search with query "kinase"
    When I select first search result
    And I "should not" be logged
    And I click on button "Save as list"
    Then The list is saved in user space "false"

  Scenario: Logged user can save selected results

    Given I am on "search" nextprot page
    And I make a simple search with query "kinase"
    When I select first search result
    And I "should" be logged
    And I click on button "Save as list"
    Then The list is saved in user space "true"