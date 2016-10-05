Feature: Retrieve entry information from neXtProt REST API

  As a end user of api.nextprot.org
  I want to make REST request to the API
  so that I can read entry data

  Background:
    Given I am on "api" nextprot page

    # Should be uncommented once branch 'page-content' has been merged to 'develop'
    # Scenario: Retrieve page display info for an entry
    #  When I do a REST request with query "/entry/NX_P01308/page-display.json"
    #  Then the page source should contain texts
    #   | "Function" : true      |
    #   | "Phenotypes" : false   |
    #   | "Localisation" : true  |
    #   | "Peptides" : true      |
    #   | "Expression" : true    |
    #   | "Exons" : false        |
    #   | "Proteomics" : true    |
    #   | "Medical" : true       |
    #   | "Structures" : true    |
    #   | "Interactions" : true  |
    #   | "Sequence" : true      |
    #   | "Identifiers" : true   |
