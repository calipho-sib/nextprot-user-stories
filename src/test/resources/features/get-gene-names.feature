Feature: "Gene Names" services should work as expected

  As a end user of API
  I want to use services in http://dev-api.nextprot.org/gene-names/
  so that I can get gene names

  Scenario: Get gene name coding a given protein

    Given I am on API service 'Gene Names'
    And I clicked on link '/gene-names/entry/{entryAccession}'
    When I type a valid value to entryAccession
    And I click on 'Submit' button
    Then I get back a json array with all gene names coding the given protein

