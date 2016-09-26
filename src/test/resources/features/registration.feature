Feature: Registration to neXtProt

  As a end user of neXtProt
  I want to register
  so that I can access my user space
  and access more services

  Scenario: Register with my google account

    Given I am on nextprot page "any"
    And I am logged "false"
    When I click on link "Login"
    And I click on link "Login with Google"
    Then I am logged "true"
    And I close the browser

  Scenario: Logout from nextprot

    Given I am on nextprot page "any"
    And I am logged "true"
    When I click on link "Logout"
    Then I am logged "false"
    And I close the browser