Feature: Registration to neXtProt

  As a end user of neXtProt
  I want to register
  so that I can access my user space
  and access more services

  Scenario: Register with my google account

    Given I am on page "any"
    And I am connected with my google account
    When I click on 'Login' button
    Then I am logged "false"

  Scenario: Logout from nextprot

    Given I am on page "any"
    And I am logged "true"
    When I click on 'Logout' button
    Then I am logged "true"