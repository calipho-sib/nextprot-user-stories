Feature: Retrieve entry information from neXtProt REST API

  As a end user of api.nextprot.org
  I want to make REST request to the API
  so that I can read entry data

  Background:
    Given I am on "api" nextprot page

  Scenario: Retrieve entry in fasta format
    When I do a REST request with query "/entry/NX_P01308.fasta"
    #Then the page source should contain texts
    #  | >nxp\|NX_P01308-1\|INS\|Insulin\|Iso 1                       |
    #  | MALWMRLLPLLALLALWGPDPAAAFVNQHLCGSHLVEALYLVCGERGFFYTPKTRREAED |
    #  | LQVGQVELGGGPGAGSLQPLALEGSLQKRGIVEQCCTSICSLYQLENYCN           |