Feature: Search neXtProt

  As a end user of www.nextprot.org
  I want to make a search
  so that I can access to results

  @active
  Scenario: Make a simple search

    Given I am on "search" nextprot page
    When I make a simple search with query "kinase"
    Then the page source should contain texts
      | Insulin decreases blood glucose concentration                        |
      | Basement membrane-specific heparan sulfate proteoglycan core protein |