Feature: Retrieve gene names from neXtProt REST API

  As a end user of api.nextprot.org
  I want to make /gene-names REST requests
  so that I can get gene names

  Background:
    Given I am on "api" nextprot page

  Scenario: Retrieve gene name of a given entry accession
    When I do a REST request with query "/gene-names/entry/NX_P01308.json"
    Then the page source should contain text "INS"

  ## The following scenario is not runnable as this service is too slow if absence of cache :(
  #Scenario: Retrieve all neXtProt gene names
  #  When I do a REST request with query "/gene-names"
  #  Then the page source should contain texts
  #  | INS |
  #  | SCN9A |