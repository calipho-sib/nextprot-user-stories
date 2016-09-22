@active
Feature: Search neXtProt

  As a end user of www.nextprot.org
  I want to make a search
  so that I can access to results

  Scenario: Make a simple search

    Given I am on page "search"
    When I submit search "kinase"
    Then I obtain 12 results

