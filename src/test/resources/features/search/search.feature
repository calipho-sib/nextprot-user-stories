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
    
  # For now, terms checked are from CVs which are in FTP site
  # TO DO: Extend to all CVs and also check that everything that should be indexed is indexed (document specs first)
  Scenario Outline: Check ACs of CV terms which exist are indexed
    Given I click on drop-down id "#search-entity"
    And I select option "Terms"
    When I make a simple search with query "<query>"
    Then the page source should contain text "<result>"

    Examples:
      | query                         | result                                      |   
      | TS-0564                       | Liver                                       |
      | CVCA_0004                     | N-linked (GlcNAc...) (complex)              |
      | DO-00615                      | SH3 domain                                  |
      | FA-03015                      | Prion family                                |
      | CVME_0001                     | Calcium                                     |
      | ME:0000002                    | impact                                      |
      | PP:0001                       | protein abundance                           |
      | CVTO_0002                     | Extracellular                               |
      
  # UPDATE at each new release
  # For now, terms checked are from CVs which are in FTP site
  # TO DO: Extend to all CVs 
  Scenario Outline: Check that the next free AC for CVs return no results
    Given I click on drop-down id "#search-entity"
    And I select option "Terms"
    When I make a simple search with query "<query>"
    Then the page source should contain text "No search results were found."

    Examples:
      | query                         |
      | TS-2449                       |
      | CVCA_0035                     |
      | DO-00913                      |
      | FA-05395                      |
      | CVME_0038                     |
      | ME:0000007                    |
      | PP:000006                     |
      | CVTO_0025                     |

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
      | Proteins     | PAp02121803                   | Ig kappa chain V-I region AG                |
      | Proteins     | PAp00134062                   | Ig kappa chain V-I region AG                |
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
