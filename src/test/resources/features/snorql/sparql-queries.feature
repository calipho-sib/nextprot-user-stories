Feature: Sparql search neXtProt

  As a end user of snorql.nextprot.org
  I want to make SPARQL query to nextprot
  so that I can access the results

  Background:
    Given I navigate to url of nextprot "snorql"

  Scenario: Run sparql query NXQ_00001
    When I click on sparql query "NXQ_00001"
    And I click on button "Go"
    Then the page source should contain texts
      | entry:NX_P15336 |
      | entry:NX_Q9BVC5 |

  Scenario Outline: Run 3 sparql queries
    When I click on sparql query "<query>"
    And I click on button "Go"
    Then the results should contain text "<result>"

    Examples: Expected query results
      | query     | result          |
      | NXQ_00001 | entry:NX_P15336 |
      | NXQ_00002 | entry:NX_Q9BWT1 |
      | NXQ_00003 | entry:NX_P58182 |

  # perharps not a good idea to run all
  Scenario Outline: Run all sparql queries
    When I click on sparql query "<query>"
    And I click on button "Go"
    Then an error "does not" occur

    Examples: Expected query results
      | query     |
      | NXQ_00001 |
      | NXQ_00002 |
      | NXQ_00003 |
      | NXQ_00004 |
      | NXQ_00005 |
      | NXQ_00006 |
      | NXQ_00007 |
      | NXQ_00008 |
      | NXQ_00009 |
      | NXQ_00010 |