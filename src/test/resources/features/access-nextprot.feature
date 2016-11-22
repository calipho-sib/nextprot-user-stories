Feature: Test neXtProt web application accessibility

  As a user I should be able to access neXtProt web site

  Scenario Outline: Check nextprot page title
    When I navigate to nextprot url "<page>"
    Then the page title should be "<title>"

    Examples: Expected page titles
      | page     | title             |
      | {search} | neXtProt platform |
      | {api}    | neXtProt REST API |
      | {snorql} | neXtProt SnorQL   |

