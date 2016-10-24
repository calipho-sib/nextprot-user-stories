Feature: Sparql search neXtProt

  As a end user of snorql.nextprot.org
  I want to make SPARQL query to nextprot
  so that I can access the results

  Background:
    Given I navigate to url of nextprot "snorql"

  Scenario: Run sparql query NXQ_00001
    When I click on sparql query "NXQ_00001"
    And I click on button "Go"
    Then the page source should contain texts
      | entry:NX_P15336 |
      | entry:NX_Q9BVC5 |

  Scenario Outline: Run 3 sparql queries
    When I click on sparql query "<query>"
    And I click on button "Go"
    Then the results should contain text "<result>"

    Examples: Expected query results
      | query     | result          |
      | NXQ_00001 | entry:NX_P15336 |
      | NXQ_00002 | entry:NX_Q9BWT1 |
      | NXQ_00003 | entry:NX_P58182 |

  Scenario Outline: Run all sparql queries
    When I click on sparql query "<query>"
    And I click on button "Go"
    Then an error "does not" occur

    Examples: Expected query results
      | query     |
      | NXQ_00001 |
      | NXQ_00002 |
      | NXQ_00003 |
      | NXQ_00004 |
      | NXQ_00005 |
      | NXQ_00006 |
      | NXQ_00007 |
      | NXQ_00008 |
      | NXQ_00009 |
      | NXQ_00010 |
      | NXQ_00011 |
      | NXQ_00012 |
      | NXQ_00013 |
      | NXQ_00014 |
      | NXQ_00015 |
      | NXQ_00016 |
      | NXQ_00017 |
      | NXQ_00018 |
      | NXQ_00019 |
      | NXQ_00020 |
      | NXQ_00021 |
      | NXQ_00022 |
      | NXQ_00023 |
      | NXQ_00024 |
      | NXQ_00025 |
      | NXQ_00026 |
      | NXQ_00027 |
      | NXQ_00028 |
      | NXQ_00029 |
      | NXQ_00030 |
      | NXQ_00031 |
      | NXQ_00032 |
      | NXQ_00033 |
      | NXQ_00034 |
      | NXQ_00035 |
      | NXQ_00036 |
      | NXQ_00037 |
      | NXQ_00038 |
      | NXQ_00039 |
      | NXQ_00040 |
      | NXQ_00041 |
      | NXQ_00042 |
      | NXQ_00043 |
      | NXQ_00044 |
      | NXQ_00045 |
      | NXQ_00047 |
      | NXQ_00048 |
      | NXQ_00049 |
      | NXQ_00051 |
      | NXQ_00052 |
      | NXQ_00053 |
      | NXQ_00054 |
      | NXQ_00055 |
      | NXQ_00057 |
      | NXQ_00058 |
      | NXQ_00059 |
      | NXQ_00060 |
      | NXQ_00061 |
      | NXQ_00062 |
      | NXQ_00063 |
      | NXQ_00064 |
      | NXQ_00065 |
      | NXQ_00066 |
      | NXQ_00067 |
      | NXQ_00068 |
      | NXQ_00069 |
      | NXQ_00070 |
      | NXQ_00072 |
      | NXQ_00073 |
      | NXQ_00074 |
      | NXQ_00075 |
      | NXQ_00076 |
      | NXQ_00077 |
      | NXQ_00078 |
      | NXQ_00079 |
      | NXQ_00080 |
      | NXQ_00081 |
      | NXQ_00082 |
      | NXQ_00083 |
      | NXQ_00084 |
      | NXQ_00085 |
      | NXQ_00086 |
      | NXQ_00087 |
      | NXQ_00089 |
      | NXQ_00090 |
      | NXQ_00092 |
      | NXQ_00093 |
      | NXQ_00094 |
      | NXQ_00096 |
      | NXQ_00097 |
      | NXQ_00099 |
      | NXQ_00100 |
      | NXQ_00103 |
      | NXQ_00104 |
      | NXQ_00105 |
      | NXQ_00106 |
      | NXQ_00107 |
      | NXQ_00108 |
      | NXQ_00109 |
      | NXQ_00111 |
      | NXQ_00112 |
      | NXQ_00113 |
      | NXQ_00117 |
      | NXQ_00118 |
      | NXQ_00119 |
      | NXQ_00124 |
      | NXQ_00125 |
      | NXQ_00126 |
      | NXQ_00127 |
      | NXQ_00128 |
      | NXQ_00130 |
      | NXQ_00131 |
      | NXQ_00132 |
      | NXQ_00134 |
      | NXQ_00135 |
      | NXQ_00136 |
      | NXQ_00137 |
      | NXQ_00138 |
      | NXQ_00139 |
      | NXQ_00140 |
      | NXQ_00141 |
      | NXQ_00143 |
      | NXQ_00144 |
      | NXQ_00145 |
      | NXQ_00146 |
      | NXQ_00147 |
      | NXQ_00148 |
      | NXQ_00149 |
      | NXQ_00202 |
      | NXQ_00203 |
      | NXQ_00204 |
      | NXQ_00208 |
      | NXQ_00209 |