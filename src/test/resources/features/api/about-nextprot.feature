Feature: Display informations about neXtProt from nextProt API

  As a end user of api.nextprot.org
  I want to be able to access informations about nextprot

  Background:
    Given I navigate to url of nextprot "api"

  Scenario: Display "About" page informations
    When I click on link text "About"
    Then the page source should contain texts
      | Background                            |
      | Our vision                            |
      | Contact details                       |
      | SIB Swiss Institute of Bioinformatics |

  Scenario: Display "Copyright" page informations
    When I click on link id "copyright"
    Then the page source should contain texts
      | Copyright notice for neXtProt               |
      | 2010-2016                                   |
      | Javascript framework for website interface. |

  Scenario: Display "Legal disclaimer" page informations
    When I click on link id "legal-disclaimer"
    Then the page source should contain texts
      | Legal Disclaimer        |
      | Limitation of Liability |
      | Personal Data           |
      | Security of Access      |