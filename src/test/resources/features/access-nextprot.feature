Feature: neXtProt web application is accessible

  As a user I should be able to access neXtProt web site

  @active
  Scenario Outline: Check nextprot page title
    When I am on nextprot page "<page>"
    Then I check page title is "<title>"

    Examples: Expected page titles
    |page  |title            |
    |search|neXtProt platform|
    |api   |neXtProt REST API|
    |snorql|neXtProt SnorQL  |

