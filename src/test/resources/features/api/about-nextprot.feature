Feature: Display informations about neXtProt from nextProt API

  As a end user of api.nextprot.org
  I want to be able to access informations about nextprot

  Background:
    Given I navigate to url of nextprot "api"

  Scenario: Display "About" page informations
    When I click on link "About"
    Then the page source should contain texts
      | Background                            |
      | Our vision                            |
      | Contact details                       |
      | SIB Swiss Institute of Bioinformatics |

