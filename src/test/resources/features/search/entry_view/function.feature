Feature: Function view for neXtProt entries

  As a end user of nextprot.org/entry/{entry_accession}/function
  I want to view data displayed for a specific entry

  Scenario: Get function page title
    Given I navigate to nextprot url "{search}/entry/NX_P52701/function"
    Then the page title should be "MSH6 - DNA mismatch repair protein Msh6 - Function"