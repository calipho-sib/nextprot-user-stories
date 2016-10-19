Feature: Sparql search neXtProt

  As a end user of snorql.nextprot.org
  I want to make SPARQL query to nextprot
  so that I can access the results

  Scenario: Run query NXQ_00001
    Given I navigate to url of nextprot "snorql"
    And I click on list element "NXQ_00001"
    When I click on button "Go"
    Then the page source should contain texts
      | entry:NX_P15336 --- (neXtProt link) |
      | entry:NX_Q9BVC5 --- (neXtProt link) |
