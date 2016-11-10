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
      
  # Missing examples for:	NXQ_00089  NXQ_00094 NXQ_00141
  Scenario Outline: Check saved queries run and return appropriate result
    When I click on sparql query "<query>"
    And I click on button "Go"
    Then the results should contain text "<result>"

    Examples: Expected query results
      | query     | result              |
      | NXQ_00001 | entry:NX_P31151     |
      | NXQ_00002 | entry:NX_P28290     |
      | NXQ_00003 | entry:NX_Q7Z5H5     |
      | NXQ_00004 | entry:NX_Q8IYM2     |
	  | NXQ_00005 | entry:NX_P42345     |
	  | NXQ_00006 | entry:NX_P20292     |
	  | NXQ_00007 | entry:NX_P36507     |
	  | NXQ_00008 | entry:NX_Q15768     |
	  | NXQ_00009 | entry:NX_P40200     |
	  | NXQ_00010 | entry:NX_P40926     |
	  | NXQ_00011 | entry:NX_P30622     |
	  | NXQ_00012 | entry:NX_Q99459     |
	  | NXQ_00013 | entry:NX_Q8IVT5     |
	  | NXQ_00014 | entry:NX_Q9UKW4     |
	  | NXQ_00015 | entry:NX_Q6P0Q8     |
	  | NXQ_00016 | entry:NX_Q15726     |
	  | NXQ_00017 | entry:NX_Q8NEM8     |
	  | NXQ_00018 | entry:NX_Q15417     |
	  | NXQ_00019 | entry:NX_Q6ZMW3     |
	  | NXQ_00020 | entry:NX_Q8TCY5     |
	  | NXQ_00021 | entry:NX_Q15126     |
	  | NXQ_00022 | entry:NX_Q5T1N1     |
	  | NXQ_00023 | entry:NX_Q5T1C6     |
	  | NXQ_00024 | entry:NX_Q13547     |
	  | NXQ_00025 | entry:NX_Q86V48     |
	  | NXQ_00026 | entry:NX_Q14055     |
	  | NXQ_00027 | entry:NX_Q8N766     |
	  | NXQ_00028 | entry:NX_Q5T7V8     |
	  | NXQ_00029 | entry:NX_P05186     |
	  | NXQ_00030 | entry:NX_P01275     |
	  | NXQ_00031 | entry:NX_O00453     |
	  | NXQ_00032 | entry:NX_Q15047     |
	  | NXQ_00033 | entry:NX_P08754     |
	  | NXQ_00034 | entry:NX_Q96G23     |
	  | NXQ_00035 | entry:NX_P15336     |
	  | NXQ_00036 | entry:NX_P56545     |
	  | NXQ_00037 | entry:NX_O15455     |
	  | NXQ_00038 | entry:NX_Q8NHP1     |
	  | NXQ_00039 | entry:NX_Q9Y3C8     |
	  | NXQ_00040 | entry:NX_Q13547     |
	  | NXQ_00041 | entry:NX_Q5T7P8     |
	  | NXQ_00042 | entry:NX_Q8IWT0     |
	  | NXQ_00043 | entry:NX_Q13643     |
	  | NXQ_00044 | entry:NX_Q15526     |
	  | NXQ_00045 | entry:NX_Q6GTS8     |
	  | NXQ_00047 | entry:NX_C9JDP6     |
	  | NXQ_00048 | entry:NX_Q9NP85     |
	  | NXQ_00049 | entry:NX_Q29974     |
	  | NXQ_00051 | entry:NX_Q13625     |
	  | NXQ_00052 | entry:NX_Q5T4W7     |
	  | NXQ_00053 | entry:NX_Q13835     |
	  | NXQ_00054 | entry:NX_Q7Z7D3     |
	  | NXQ_00055 | entry:NX_Q15700     |
	  | NXQ_00057 | entry:NX_Q5T9A4     |
	  | NXQ_00058 | entry:NX_Q14872     |
	  | NXQ_00059 | entry:NX_Q5JRA6     |
	  | NXQ_00060 | entry:NX_Q13571     |
	  | NXQ_00061 | entry:NX_Q15121     |
	  | NXQ_00062 | entry:NX_Q15973     |
	  | NXQ_00063 | entry:NX_Q5VZ19     |
	  | NXQ_00064 | entry:NX_Q14CN2     |
	  | NXQ_00065 | entry:NX_Q99497     |
	  | NXQ_00066 | entry:NX_P61586     |
	  | NXQ_00067 | entry:NX_Q14814     |
	  | NXQ_00068 | entry:NX_Q15619     |
	  | NXQ_00069 | entry:NX_P09769     |
	  | NXQ_00070 | entry:NX_Q15782     |
	  | NXQ_00072 | entry:NX_Q13835     |
	  | NXQ_00073 | entry:NX_Q14146     |
	  | NXQ_00074 | entry:NX_Q14774     |
	  | NXQ_00075 | entry:NX_Q8NCS4     |
	  | NXQ_00076 | entry:NX_Q14671     |
	  | NXQ_00077 | entry:NX_Q5T7N2     |
	  | NXQ_00078 | entry:NX_Q7Z5L7     |
	  | NXQ_00079 | entry:NX_Q7Z7F0     |
	  | NXQ_00080 | entry:NX_Q13698     |
	  | NXQ_00081 | entry:NX_Q6PI48     |
	  | NXQ_00082 | entry:NX_O00258     |
	  | NXQ_00083 | entry:NX_Q63ZE4     |
	  | NXQ_00084 | entry:NX_A6NHR9     |
	  | NXQ_00085 | entry:NX_Q15906     |
	  | NXQ_00086 | entry:NX_P01189     |
	  | NXQ_00087 | entry:NX_Q5JXX7     |
	  | NXQ_00090 | entry:NX_O75636     |
	  | NXQ_00092 | entry:NX_Q8NF91     |
	  | NXQ_00093 | entry:NX_P11171     |
	  | NXQ_00096 | entry:NX_O00180     |
	  | NXQ_00097 | entry:NX_P02461     |
	  | NXQ_00099 | entry:NX_A0A087X1C5 |
	  | NXQ_00100 | entry:NX_Q13571     |
	  | NXQ_00103 | entry:NX_Q5TEV5     |
	  | NXQ_00104 | entry:NX_O43426     |
	  | NXQ_00105 | entry:NX_Q13823     |
	  | NXQ_00106 | entry:NX_Q5T1S8     |
	  | NXQ_00107 | entry:NX_Q5T0J3     |
	  | NXQ_00108 | entry:NX_P19878     |
	  | NXQ_00109 | entry:NX_Q5T9L3     |
	  | NXQ_00111 | entry:NX_Q14114     |
	  | NXQ_00112 | entry:NX_Q14872     |
	  | NXQ_00113 | entry:NX_Q14739     |
	  | NXQ_00117 | entry:NX_Q15053     |
	  | NXQ_00118 | entry:NX_Q14671     |
	  | NXQ_00119 | entry:NX_Q7Z3K3     |
	  | NXQ_00127 | entry:NX_Q5T0B9     |
	  | NXQ_00128 | entry:NX_P55265     |
	  | NXQ_00130 | entry:NX_Q96LU7     |
	  | NXQ_00132 | entry:NX_Q13625     |
	  | NXQ_00135 | entry:NX_P46937     |
	  | NXQ_00136 | entry:NX_P0DME0     |
	  | NXQ_00137 | entry:NX_Q15126     |
	  | NXQ_00138 | entry:NX_P48023     |
	  | NXQ_00139 | entry:NX_Q14164     |
	  | NXQ_00140 | entry:NX_Q15392     |
	  | NXQ_00143 | entry:NX_Q5TA89     |
	  | NXQ_00144 | entry:NX_P20396     |
	  | NXQ_00145 | entry:NX_P01189     |
	  | NXQ_00146 | entry:NX_Q16777     |
	  | NXQ_00147 | entry:NX_P51587     |
	  | NXQ_00202 | entry:NX_Q5T197     |
	  | NXQ_00203 | entry:NX_Q14376     |
	  | NXQ_00204 | entry:NX_Q15513     |
	  | NXQ_00208 | entry:NX_Q99250     |
