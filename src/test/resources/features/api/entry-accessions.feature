Feature: Retrieve entry accession numbers from neXtProt REST API

  As a end user of api.nextprot.org
  I want to make /entry-accessions REST requests
  so that I can get accession numbers

  Background:
    Given I navigate to url of nextprot "api"

  Scenario: Retrieve all accession numbers
    When I do an API request with query "/entry-accessions"
    Then the page source should contain texts
      | NX_O00115 |
      | NX_Q7Z6P3 |
      | NX_Q969W0 |

  Scenario: Retrieve all accession numbers from chromosome Y
    When I do an API request with query "/entry-accessions/chromosome/Y.json"
    Then the page source should contain texts
      | NX_A2RUG3 |
      | NX_A6NDE4 |
      | NX_A6NEQ0 |

  Scenario: Retrieve accession number given a gene name
    When I do an API request with query "/entry-accessions/gene/INSR.json"
    Then the page source should contain texts
      | NX_P06213 |
