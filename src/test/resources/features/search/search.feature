Feature: Search neXtProt

  As a end user of search.nextprot.org
  I want to make a simple search
  so that I can access to results

  Background:
    Given I am on "search" nextprot page

  Scenario: Make a simple search (protein by default)
    When I make a simple search with query "kinase"
    Then the page source should contain texts
      | Mitogen-activated protein kinase kinase kinase kinase 4 |
      | Aurora kinase B                                         |

  Scenario Outline: Make a simple search with a specified entity
    Given I click on "search-entity" dropdown
    And I click on link "<link>"
    When I make a simple search with query "kinase"
    Then the page source should contain text "<result>"

    Examples:
      | link         | result                                                                                                     |
      | Proteins     | Aurora kinase B                                                                                            |
      | Publications | Conformation-Selective Analogues of Dasatinib Reveal Insight into Kinase Inhibitor Binding and Selectivity |

  Scenario: Select a result after a protein search should add it to clipboard
    Given I make a simple search with query "kinase"
    When I select one search result with accession "NX_O95819"
    Then the badge should be equal to "1"