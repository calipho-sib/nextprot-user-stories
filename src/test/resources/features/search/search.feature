Feature: Search neXtProt

  As a end user of search.nextprot.org
  I want to make a simple search
  so that I can access to results

  Background:
    Given I navigate to url of nextprot "search"

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
      | link         | result                                                 |
      | Proteins     | Aurora kinase B                                        |
      | Publications | Targeting human central nervous system protein kinases |
      | Terms        | kinase binding [GO:0019900]                            |

  Scenario: Select a result after a protein search should add it to clipboard
    Given I make a simple search with query "kinase"
    When I select search result with accession "NX_O95819"
    Then the clipboard should contain "1" elements

  Scenario: Select all results after a protein search should add them to clipboard
    Given I make a simple search with query "krypton"
    When I select all search results
    Then the clipboard should contain "12" elements
