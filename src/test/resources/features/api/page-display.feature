Feature: Retrieve entry page displayability from neXtProt REST API

  As a end user of api.nextprot.org
  I want to make /entry/{entry}/page-display REST requests
  so that I can know which entry pages are displayable

  Background:
    Given I navigate to nextprot url "{api}"

  Scenario: Retrieve page display info for an entry
    When I navigate to relative url "/entry/NX_P01308/page-display.json"
    Then the page source should contain texts
    | "Function" : true      |
    | "Phenotypes" : false   |
    | "Localisation" : true  |
    | "Peptides" : true      |
    | "Expression" : true    |
    | "Exons" : false        |
    | "Proteomics" : true    |
    | "Medical" : true       |
    | "Structures" : true    |
    | "Interactions" : true  |
    | "Sequence" : true      |
    | "Identifiers" : true   |
