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
    | INS   |
    | SCN9A |

# Gene names - special cases:
# NX_Q6ZQT7 No recommended gene name or ORF name
# NX_Q9NZ38 Recommended gene name which includes a hyphen
# NX_P0C0L5 Two recommended gene names, including one which includes an underscore 
# NX_Q96IC2 ORF name which includes a period
# NX_Q8N326 Recommended gene name which includes lower case letters
# NX_O15178 Shortest recommended gene name (1-letter)
# NX_Q6UY13 ORF name (25-letter) with slash (longest?)
# NX_P68431 Entry with the 10 recommended gene names (is this the most we have?)

  Scenario Outline: Check special cases of gene names in API
    When I do an API request with query "<query>"  
    Then the page source should contain text "<result>"

 Examples: Expected query results
    | query                             | result                      |
	  | /gene-names/entry/NX_Q6ZQT7.json  | []                          | 
	  | /gene-names/entry/NX_Q9NZ38.json  | "IDI2-AS1"                  |
	  | /gene-names/entry/NX_P0C0L5.json  | "C4B_2"                     |
	  | /gene-names/entry/NX_P0C0L5.json  | "C4B"                       |
	  | /gene-names/entry/NX_Q96IC2.json  | "44M2.3"                    |	  
	  | /gene-names/entry/NX_Q8N326.json  | "C10orf111"                 |
	  | /gene-names/entry/NX_O15178.json  | "T"                         |
	  | /gene-names/entry/NX_Q6UY13.json  | "UNQ5830/PRO19650/PRO19816" |
	  | /gene-names/entry/NX_P68431.json  | "HIST1H3A"                  |
	  | /gene-names/entry/NX_P68431.json  | "HIST1H3B"                  |	  
	  | /gene-names/entry/NX_P68431.json  | "HIST1H3C"                  |
	  | /gene-names/entry/NX_P68431.json  | "HIST1H3D"                  |
	  | /gene-names/entry/NX_P68431.json  | "HIST1H3E"                  |
	  | /gene-names/entry/NX_P68431.json  | "HIST1H3F"                  |
	  | /gene-names/entry/NX_P68431.json  | "HIST1H3G"                  |
	  | /gene-names/entry/NX_P68431.json  | "HIST1H3H"                  |
	  | /gene-names/entry/NX_P68431.json  | "HIST1H3I"                  |
	  | /gene-names/entry/NX_P68431.json  | "HIST1H3J"                  |
