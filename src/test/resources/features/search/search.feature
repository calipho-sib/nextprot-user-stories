Feature: Search neXtProt

  As a end user of search.nextprot.org
  I want to make a simple search to nextprot
  so that I can access the results

  Background:
    Given I navigate to nextprot url "{search}"

  Scenario: Make a simple search (protein by default)
    When I make a simple search with query "kinase"
    Then the page source should contain texts
      | Mitogen-activated protein kinase kinase kinase kinase 4 |
      | Aurora kinase B                                         |

  Scenario Outline: Make a simple search with a specified entity
    Given I click on drop-down id "#search-entity"
    And I select option "<option>"
    When I make a simple search with query "krypton"
    Then the page source should contain text "<result>"

    Examples:
      | option       | result                                                        |
      | Proteins     | Transmembrane protease serine 11B                             |
      | Publications | Exploring hydrophobic sites in proteins with xenon or krypton |
      | Terms        | Inert Gas Narcosis [D007222]                                  |

  Scenario: Select a result after a protein search should add it to clipboard
    Given I make a simple search with query "kinase"
    When I select search result with accession "NX_O95819"
    Then the clipboard should contain "1" elements

  Scenario: Select all results after a protein search should add them to clipboard
    Given I make a simple search with query "krypton"
    When I select all search results
    Then the clipboard should contain "12" elements

  Scenario Outline: Check that searching for entries in exclusion list returns no results
    Given I click on drop-down id "#search-entity"
    And I select option "Proteins"
    When I make a simple search with query '<query>'
    Then the page source should contain text "No search results were found."

    Examples:
      | query                                  |
      | P04220                                 |
      | "Ig mu heavy chain disease protein"    |
      | P04436                                 |
      | P04437                                 |
      | P01737                                 |
      | P01733                                 |
      | P04435                                 |
      | "T-cell receptor alpha chain V region" |

  # For now, terms checked are from CVs which are in FTP site
  # TO DO: Extend to all CVs and also check that everything that should be indexed is indexed (document specs first)
  Scenario Outline: Check ACs of CV terms which exist are indexed
    Given I click on drop-down id "#search-entity"
    And I select option "Terms"
    When I make a simple search with query "<query>"
    Then the page source should contain text "<result>"

    Examples:
      | query      | result                         |
      | TS-0564    | Liver                          |
      | CVCA_0004  | N-linked (GlcNAc...) (complex) |
      | DO-00615   | SH3 domain                     |
      | FA-03015   | Prion family                   |
      | CVME_0001  | Calcium                        |
      | ME:0000002 | impact                         |
      | PP:0001    | protein abundance              |
      | CVTO_0002  | Extracellular                  |

  # UPDATE at each new release
  # For now, terms checked are from CVs which are in FTP site
  # TO DO: Extend to all CVs
  @dbrelease
  Scenario Outline: Check that searching for the next free AC for CVs returns no results
    Given I click on drop-down id "#search-entity"
    And I select option "Terms"
    When I make a simple search with query "<query>"
    Then the page source should contain text "No search results were found."

    Examples:
      | query      |
      | TS-2449    |
      | CVCA_0035  |
      | DO-00913   |
      | FA-05395   |
      | CVME_0038  |
      | ME:0000007 |
      | PP:000006  |
      | CVTO_0025  |

  @dbrelease
  Scenario Outline: Check new CV terms or data in upcoming release are indexed
    Given I click on drop-down id "#search-entity"
    And I select option "<option>"
    When I make a simple search with query "<query>"
    Then the page source should contain text "<result>"

    Examples:
      | option       | query     | result                                                      |
      | Proteins     |           |                                                             |
      | Publications | 27612661  | Directed evolution of glutathione transferases              |
      | Terms        | CVCA_0034 | N-linked (GlcNAc...) (hybrid)                               |
      | Terms        | DO-00909  | K167R                                                       |
      | Terms        | FA-05394  | Class-II aminoacyl-tRNA synthetase family. Type 2 subfamily |
      | Terms        | DI-04829  | Band heterotopia                                            |
      | Terms        | DI-04857  | Sifrim-Hitz-Weiss syndrome                                  |

  @dbrelease
  Scenario Outline: Check modified CV terms or data in upcoming release are indexed
    Given I click on drop-down id "#search-entity"
    And I select option "<option>"
    When I make a simple search with query "<query>"
    Then the page source should contain text "<result>"

    Examples:
      | option | query    | result              |
      | Terms  | DO-00528 | Prospero-type homeo |
      | Terms  | FA-04941 | INKA family         |


  @dbrelease
  Scenario Outline: Check search for obsoleted (deleted) CV term or data in upcoming release returns no results
    Given I click on drop-down id "#search-entity"
    And I select option "<option>"
    When I make a simple search with query "<query>"
    Then the page source should contain text "No search results were found."

    Examples:
      | option | query     |
      | Terms  | TS-2176   |
      | Terms  | DO-00095  |
      | Terms  | CVTO_0008 |
      | Terms  | KW-0197   |
