Feature: Map variant annotation over protein isoforms.

  As a end user of api.nextprot.org
  I want to map 'variant' annotations to protein isoforms
  so that I can validate position or propagate to other isoforms

  Background:
    Given I navigate to nextprot url "{api}"

  Scenario: Validate variant feature on canonical isoform
    When I navigate to relative url "/validate-feature/variant?feature=SCN11A-p.Leu1158Pro"
    Then the page source should contain texts
      | "success" : true                                  |
      | "accession" : "NX_Q9UI33"                         |
      | "featurePropagable" : false                       |
      | "data"                                            |
      | "isoformAccession" : "NX_Q9UI33-1"                |
      | "isoformName" : "Iso 1"                           |
      | "beginIsoformPosition" : 1158                     |
      | "endIsoformPosition" : 1158                       |
      | "beginMasterPosition" : 78346                     |
      | "endMasterPosition" : 78348                       |
      | "isoSpecificFeature" : "SCN11A-iso1-p.Leu1158Pro" |
      | "canonical" : true                                |
      | "mapped" : true                                   |
      | "featurePropagable" : false                       |

  Scenario: Validate variant feature on canonical isoform from explicit entry accession
    When I navigate to relative url "/validate-feature/variant.json?feature=SCN11A-p.Leu1158Pro&accession=NX_Q9UI33"
    Then the page source should contain texts
      | "success" : true            |
      | "featurePropagable" : false |

  Scenario: Validate variant feature on specific isoform
    When I navigate to relative url "/validate-feature/variant?feature=SCN11A-iso2-p.Leu1158Pro"
    Then the page source should contain texts
      | "success" : true    |
      | "canonical" : false |

  Scenario: Validate variant feature on specific isoform and fails
    When I navigate to relative url "/validate-feature/variant?feature=SCN11A-iso1-p.Leu115Pro"
    Then the page source should contain texts
      | "success" : false                                                                                            |
      | "message" : "unexpected amino-acid: found Leu at position 115 of NX_Q9UI33 sequence instead of expected Phe" |

  Scenario: Propagate variant feature on canonical isoform
    When I navigate to relative url "/propagate-feature/variant?feature=SCN11A-p.Leu1158Pro"
    Then the page source should contain texts
      | "success" : true           |
      | "accession" : "NX_Q9UI33"  |
      | "featurePropagable" : true |
      | "NX_Q9UI33-1" : {          |
      | "NX_Q9UI33-2" : {          |
      | "NX_Q9UI33-3" : {          |
      | SCN11A-iso1-p.Leu1158Pro   |
      | SCN11A-iso2-p.Leu1158Pro   |
      | SCN11A-iso3-p.Leu1120Pro   |
