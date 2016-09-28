Feature: Registration to neXtProt

  As a end user of neXtProt
  I want to register
  so that I can access my user space
  and access more services

  Scenario: Register with my google account

    Given I am on "any" nextprot page
    And I "should not" be logged
    When I click on link "Login"
    And I click on googleplus button
    Then I "should" be logged

  Scenario: Logout from nextprot

    Given I am on "any" nextprot page
    And I "should" be logged
    When I click on link "Logout"
    Then I "should not" be logged
