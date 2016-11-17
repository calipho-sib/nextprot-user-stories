Feature: Function view for neXtProt entries

  As a end user of nextprot.org/entry/{entry_accession}/function
  I want to view data displayed for a specific entry

  Scenario: Get function page title
    Given I navigate to nextprot url "{search}/entry/NX_P52701/function"
    Then the page title should be "MSH6 - DNA mismatch repair protein Msh6 - Function"

  Scenario Outline: Check categories of annotations found in Function view (SP_FV_33 and SP_FV_36)
    Given I navigate to nextprot url "<query>"
    Then the page source should contain text "<result>"

 Examples: Expected query results
      | query                             | result                                         |
      | {search}/entry/NX_O43290/function |	ALLERGEN                                       |
	  | {search}/entry/NX_P10109/function | BIOPHYSICOCHEMICAL PROPERTIES                  |
	  | {search}/entry/NX_Q8WVF1/function | BIOPHYSICOCHEMICAL PROPERTIES                  |
	  | {search}/entry/NX_Q2M3T9/function | BIOPHYSICOCHEMICAL PROPERTIES                  |
	  | {search}/entry/NX_Q13268/function | BIOPHYSICOCHEMICAL PROPERTIES                  |
	  | {search}/entry/NX_Q5TA31/function | CAUTION                                        |
	  | {search}/entry/NX_Q13547/function |	ENZYMATIC ACTIVITY                             |
	  | {search}/entry/NX_P51800/function |	ENZYMATIC ACTIVITY                             | 
	  | {search}/entry/NX_Q5T7P8/function |	ENZYMATIC ACTIVITY                             |
	  | {search}/entry/NX_F8WCM5/function |	GO MOLECULAR FUNCTION                          |
	  | {search}/entry/NX_Q15513/function |	GO BIOLOGICAL PROCESS                          |
	  | {search}/entry/NX_Q13571/function | KEGG PATHWAYS                                  |
	  | {search}/entry/NX_Q5TAG4/function | NOTE                                           |
	  | {search}/entry/NX_P01308/function |	OVERVIEW                                       |	  
	  | {search}/entry/NX_Q13625/function | REACTOME PATHWAYS                              |
	  | {search}/entry/NX_Q5TAQ9/function | UNIPATHWAYS                                    |
	  | {search}/entry/NX_Q14146/function | There is no Function data for this entry.      |

# Carbonic anhydrase 2 [EC 4.2.1.1] (CA2) [NX_P00918]
# Entry with many categories and sub-categories of annotations	  
  Scenario Outline: Check all categories and sub-categories of annotations for NX_P00918 (SP_FV_33 and SP_FV_36)
    Given I navigate to nextprot url "{search}/entry/NX_P00918/function"
    Then the page source should contain text "<result>"

 Examples: Expected query results
      | result                                                                             |
	  | OVERVIEW                                                                           |
      | GO MOLECULAR FUNCTION                                                              |
      | GO BIOLOGICAL PROCESS                                                              |
      | ENZYMATIC ACTIVITY                                                                 |
      | This protein acts as an enzyme. It is known to catalyze the following reaction     |
      | It requires the following cofactor                                                 |
      | It is regulated in the following manner                                            |	  
      | KEGG PATHWAYS                                                                      |
	  | REACTOME PATHWAYS                                                                  |
	  | NOTE                                                                               |
	  | BIOPHYSICOCHEMICAL PROPERTIES                                                      |
	  | Absorption                                                                         |
      | Kinetic parameters                                                                 |
      | Dependence                                                                         |	  

	  
  Scenario Outline: Check special cases in annotations found in Function view (SP_FV_36 and SP_FV_37)
    Given I navigate to nextprot url "<query>"
    Then the page source should contain text "<result>"

 Examples: Expected query results
      | query                             | result                                         |	  
	  | {search}/entry/NX_P38398/function |	(PubMed:                                       |	  
	  | {search}/entry/NX_Q8WVF1/function |	described in PubMed:                           |
	  | {search}/entry/NX_P52701/function |	Contributes to                                 |	  
	  | {search}/entry/NX_Q06187/function |	Not                                            |
	  | {search}/entry/NX_Q969P6/function |	Not                                            |
	  | {search}/entry/NX_P38398/function |	Gold                                           |                                           
	  | {search}/entry/NX_F8WCM5/function |	Silver                                         |
	  | {search}/entry/NX_P52701/function |	neXtProt                                       |	  

# Entries with no GO annotations and only one category of keywords selected for testing (SP_FV_75)  
  Scenario Outline: Check categories of keywords found in Function view
    Given I navigate to nextprot url "<query>"
    Then the page source should contain text "<result>"

 Examples: Expected query results
      | query                             | result                     |
	  | {search}/entry/NX_Q5SZI1/function |	MOLECULAR FUNCTION         |
	  | {search}/entry/NX_Q8TF61/function |	BIOLOGICAL PROCESS	       |  
	  | {search}/entry/NX_P61583/function |	TECHNICAL TERM             |	  

# Cellular tumor antigen p53 (TP53) [NX_P04637]	  
# Entry with 2 (of the 3) categories of keywords (use AC as this is stable)
  Scenario Outline: Check all 9 keywords for the well-known protein p53 (SP_FV_75)
    Given I navigate to nextprot url "{search}/entry/NX_P04637/function"
    Then the page source should contain text "<result>"

 Examples: Expected query results
      | result  |
      |	KW-0053 |
      | KW-0090 |
      | KW-0131 |
      | KW-0945 | 
      | KW-1210 |
      | KW-0804 |
      | KW-0805 |
      | KW-0010 |
      | KW-0678 |

  Scenario Outline: Check categories of cross-references found in Function view
    Given I navigate to nextprot url "<query>"
    Then the page source should contain text "<result>"

 Examples: Expected query results
      | query                             | result                            |
	  | {search}/entry/NX_Q8TDD5/function |	Chemistry                         |
	  | {search}/entry/NX_P42574/function |	Enzyme and pathway databases      |
	  | {search}/entry/NX_P42574/function |	Other                             |	  
	  | {search}/entry/NX_P42658/function |	Protein family/group databases    |	  

	  
# TO DO: Add period after BRENDA CAZy MEROPS TCDB if going in Further external links in NP2 
  Scenario Outline: Check cross-references found in Function view
    Given I navigate to nextprot url "<query>"
    Then the page source should contain text "<result>"

 Examples: Expected query results
      | query                             | result                     |
	  | {search}/entry/NX_Q06187/function |	BRENDA:                    |
	  | {search}/entry/NX_Q96KX0/function |	CAZy                       |
	  | {search}/entry/NX_P42658/function |	ESTHER:                    |
	  | {search}/entry/NX_P01308/function |	GeneWiki:                  |
	  | {search}/entry/NX_Q14146/function |	GenomeRNAi:                |
	  | {search}/entry/NX_Q8TDD5/function |	GuidetoPHARMACOLOGY:       |	  
	  | {search}/entry/NX_P47897/function |	MoonProt:                  |
	  | {search}/entry/NX_Q58DX5/function |	MEROPS:                    |
	  | {search}/entry/NX_Q13547/function |	PRO:                       |	  
	  | {search}/entry/NX_P42574/function |	SABIO-RK:                  |
	  | {search}/entry/NX_P39877/function |	SwissLipids:               |	  
	  | {search}/entry/NX_Q8NCS7/function |	TCDB                       |

# Angiotensin-converting enzyme [EC 3.2.1.-, EC 3.4.15.1] (ACE) [NX_P12821]	  
# Entry with 3 (of the the 4) categories of cross-references 
  Scenario Outline: Check all 5 cross-references for the well-characterized protein ACE
    Given I navigate to nextprot url "{search}/entry/NX_P12821/function"
    Then the page source should contain text "<result>"

 Examples: Expected query results
      | result                |
      | SABIO-RK:             |	  
      | GeneWiki:             |
      | GenomeRNAi:           |
      | PRO:                  |
	  | GuidetoPHARMACOLOGY:  |
	  
  Scenario Outline: Check sections or keywords which should be absent from Function view
    Given I navigate to nextprot url "<query>"
    Then the page source should not contain text "<result>"

 Examples: Expected query results
      | query                             | result                     |	  
	  | {search}/entry/NX_Q14146/function |	Keywords                   |
	  | {search}/entry/NX_Q7Z2R9/function |	Further external links     |
	  | {search}/entry/NX_Q7Z2R9/function |	KW-1185                    |	  

  Scenario Outline: Check properties of cross-references in Function view
    Given I navigate to nextprot url "<query>"
    Then the page source should contain text "<result>"

 Examples: Expected query results
      | query                             | result                                |
	  | {search}/entry/NX_P42658/function |	 [ Family name: DPP4N Peptidase S9 ]  |
