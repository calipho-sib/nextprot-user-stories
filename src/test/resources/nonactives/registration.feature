Feature: Registration to neXtProt

  As a end user of neXtProt
  I want to register
  so that I can access my user space
  and access more services

  Scenario Outline: Register with my google account

    Given I am on page <page>
    And I am connected with my google account
    When I click on 'Login' button
    Then I am logged "false"

    Examples:
      | page     |
      | """search""" |
      | """snorql""" |
      | """api"""    |

  Scenario Outline: Logout from nextprot

    Given I am on page <page>
    And I am logged "true"
    When I click on 'Logout' button
    Then I am logged "true"

    Examples:
    | page   |
    | """search"""|
    | """snorql""" |
    | """api"""    |