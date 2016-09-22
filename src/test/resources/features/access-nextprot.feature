@active
Feature: neXtProt web application is accessible

  As a user I should be able to access neXtProt web site

  Scenario: Check nextprot search
    When I navigate to nextprot search page
    Then page should be valid

  Scenario: Get release data version from nextprot search
    Given I navigate to nextprot search page
    When I click 'Release contents' link
    Then I should see the Application release version
