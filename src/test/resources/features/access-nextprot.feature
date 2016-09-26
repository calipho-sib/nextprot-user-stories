Feature: neXtProt web application is accessible

  As a user I should be able to access neXtProt web site

  Scenario: Check nextprot search title
    When I am on nextprot page "search"
    Then I check page title is "neXtProt platform"
    And I close the browser

  Scenario: Check release data version from nextprot search
    Given I am on nextprot page "search"
    When I click on link "Release contents"
    Then I should find in the page "Application release"
    And I close the browser
