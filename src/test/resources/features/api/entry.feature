Feature: Retrieve entry information from neXtProt REST API

  As a end user of api.nextprot.org
  I want to make REST request to the API
  so that I can read entry data

  Background:
    Given I am on "api" nextprot page

  Scenario: Retrieve entry accession in json format
    When I do a REST request with query "/entry/NX_P01308/accession.json"
    Then the page source should contain texts
      | "uniqueName" : "NX_P01308" |
      | "uniprotName" : "P01308"   |

  Scenario: Retrieve entry isoforms in xml format
    When I do a REST request with query "/entry/NX_P01308/isoform.xml"
    Then the page source should contain texts
      | <isoform-sequence name="Iso 1" accession="NX_P01308-1" database="neXtProt"                                     |
      | MALWMRLLPLLALLALWGPDPAAAFVNQHLCGSHLVEALYLVCGERGFFYTPKTRREAEDLQVGQVELGGGPGAGSLQPLALEGSLQKRGIVEQCCTSICSLYQLENYCN |

  Scenario: Retrieve entry signal peptide in xml format
    When I do a REST request with query "/entry/NX_P01308/signal-peptide.xml"
    Then the page source should contain texts
      | <annotation-category category="signal-peptide" hierarchy="positional-annotation;processing-product"> |
      | <begin position="1"/>                                                                                |
      | <end position="24"/>                                                                                 |

  Scenario: Retrieve entry in fasta format
    When I do a REST request with query "/entry/NX_P01308.fasta"
    #Then the page source should contain texts
    #  | >nxp\|NX_P01308-1\|INS\|Insulin\|Iso 1                       |
    #  | MALWMRLLPLLALLALWGPDPAAAFVNQHLCGSHLVEALYLVCGERGFFYTPKTRREAED |
    #  | LQVGQVELGGGPGAGSLQPLALEGSLQKRGIVEQCCTSICSLYQLENYCN           |