Feature: Retrieve entry information from neXtProt REST API

  As a end user of api.nextprot.org
  I want to make REST request to the API
  so that I can read entry data

  Background:
    Given I navigate to nextprot url "{api}"

  Scenario: Retrieve entry accession in json format
    When I navigate to relative url "/entry/NX_P01308/accession.json"
    Then the page source should contain texts
      | "uniqueName" : "NX_P01308" |
      | "uniprotName" : "P01308"   |

  Scenario: Retrieve entry isoforms in xml format
    When I navigate to relative url "/entry/NX_P01308/isoform.xml"
    Then the page source should contain texts
      | <isoform-sequence name="Iso 1" accession="NX_P01308-1" database="neXtProt"                                     |
      | MALWMRLLPLLALLALWGPDPAAAFVNQHLCGSHLVEALYLVCGERGFFYTPKTRREAEDLQVGQVELGGGPGAGSLQPLALEGSLQKRGIVEQCCTSICSLYQLENYCN |

  Scenario: Retrieve entry signal peptide in xml format
    When I navigate to relative url "/entry/NX_P01308/signal-peptide.xml"
    Then the page source should contain texts
      | <annotation-category category="signal-peptide" hierarchy="positional-annotation;processing-product"> |
      | <begin position="1"/>                                                                                |
      | <end position="24"/>                                                                                 |

    # TODO: behave differently given the browser:
    # - in firefox a dialog for saving fasta file pops-up
    # - in chrome it is content is rendered in the page
    # We have to find a way of control this behavior (MIME)
  Scenario: Retrieve entry in fasta format
    When I navigate to relative url "/entry/NX_P01308.fasta"
    Then the page source should contain texts
      | &gt;nxp\|NX_P01308-1\|INS\|Insulin\|Iso 1                    |
      | MALWMRLLPLLALLALWGPDPAAAFVNQHLCGSHLVEALYLVCGERGFFYTPKTRREAED |
      | LQVGQVELGGGPGAGSLQPLALEGSLQKRGIVEQCCTSICSLYQLENYCN           |
