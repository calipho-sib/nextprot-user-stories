@active
Feature: Save search result

  As a end user of www.nextprot.org
  I want to save the result of my previous search
  so that I can access to results in my private space

  Scenario: Save a private list of selected results

    Given I already submit a search "true"
    And I have some result selected
    And I am logged "true"
    When I click on 'Save as list'
    Then The list is saved in my private space
