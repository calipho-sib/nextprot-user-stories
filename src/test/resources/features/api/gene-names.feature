Feature: Retrieve gene names from neXtProt REST API

  As a end user of api.nextprot.org
  I want to make /gene-names REST requests
  so that I can get gene names

  Background:
    Given I navigate to url of nextprot "api"

  Scenario: Retrieve gene name of a given entry accession
    When I do an API request with query "/gene-names/entry/NX_P01308.json"
    Then the page source should contain text "INS"

  Scenario: Retrieve all neXtProt gene names
    When I do an API request with query "/gene-names.json"
    Then the page source should contain texts
    | INS |
    | SCN9A |
