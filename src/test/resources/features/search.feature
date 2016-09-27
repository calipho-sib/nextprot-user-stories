Feature: Search neXtProt

  As a end user of www.nextprot.org
  I want to make a search
  so that I can access to results

  Scenario: Make a simple search

    Given I am on nextprot page "search"
    When I make a simple search with query "kinase"
    Then Page source contains "Insulin decreases blood glucose concentration"
