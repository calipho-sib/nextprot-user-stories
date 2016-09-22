Feature: "Gene Names" services should provide gene names

  As a end user of API
  I want to use services in http://dev-api.nextprot.org/gene-names/
  so that I can get gene names

  Scenario Outline: Get gene name coding a given protein

    Given entry accession is <entry>
    When submission is done
    Then expecting gene names is <genes>

    Examples:
      | entry    | genes     |
      | """search""" | """[ "INS" ]""" |
