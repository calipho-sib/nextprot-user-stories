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
      | option       | result                                                            |
      | Proteins     | Transmembrane protease serine 11B                                 |
      | Publications | Exploring hydrophobic sites in proteins with xenon or krypton     |
      | Terms        | Inert Gas Narcosis [D007222]                                      |

  Scenario: Select a result after a protein search should add it to clipboard
    Given I make a simple search with query "kinase"
    When I select search result with accession "NX_O95819"
    Then the clipboard should contain "1" elements

  Scenario: Select all results after a protein search should add them to clipboard
    Given I make a simple search with query "krypton"
    When I select all search results
    Then the clipboard should contain "12" elements

  Scenario Outline: Check new, modified, excluded or obsolete data indexation in new release 2016_10
    Given I click on drop-down id "#search-entity"
    And I select option "<option>"
    When I make a simple search with query "<query>"
    Then the page source should contain text "<result>"

    Examples:
      | option       | query                         | result                                      |
      | Proteins     | P01593                        | Ig kappa chain V-I region AG                |
      | Proteins     | P04220                        | No search results were found.               |
      | Proteins     | P04436                        | No search results were found.               |
      | Proteins     | P04437                        | No search results were found.               |
      | Proteins     | P01737                        | No search results were found.               |
      | Proteins     | P01733                        | No search results were found.               |
      | Proteins     | P04435                        | No search results were found.               |
      | Proteins     | ENSG00000239975               | Ig kappa chain V-I region AG                |
      | Proteins     | ENST00000390265               | Ig kappa chain V-I region AG                |
      | Proteins     | ENSP00000374800               | Ig kappa chain V-I region AG                |
      | Proteins     | COSM5518288                   | Endothelial PAS domain-containing protein 1 |
      | Proteins     | COSM1532223                   | No search results were found.               |
      | Publications | 21636302                      | severe neuromuscular phenotype              |
      | Publications | 27663366                      | No search results were found.               |
      | Terms        | You-Hoover-Fong syndrome      | You-Hoover-Fong syndrome                    |
      | Terms        | DI-01661                      | Gillespie syndrome                          |
      | Terms        | DI-01848                      | No search results were found.               |
      | Terms        | DO-00904                      | PP1-binding                                 |
      | Terms        | DO-00864                      | C2HC MYST-type                              |
      | Terms        | DO-00106                      | No search results were found.               |
      | Terms        | DO-00905                      | No search results were found.               |
      | Terms        | FA-05386                      | Integrator subunit 8 family                 |
      | Terms        | FA-01918                      | IspD/TarI cytidylyltransferase family       |
      | Terms        | FA-05376                      | No search results were found.               |
      | Terms        | KW-0181                       | No search results were found.               |
      | Terms        | KW-1185                       | No search results were found.               |
