@active
Feature: neXtProt web application is accessible

  As a user I should be able to access neXtProt web site

  Scenario: Check nextprot search title
    When I am on nextprot search page
    Then I check page title is neXtProt platform

  Scenario: Check release data version from nextprot search
    Given I am on nextprot search page
    When I click 'Release contents' link
    Then I should see the Application release version
