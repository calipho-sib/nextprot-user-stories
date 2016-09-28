Feature: Search neXtProt

  As a end user of www.nextprot.org
  I want to make a search
  so that I can access to results

  Background:
    Given I am on "search" nextprot page

  Scenario: Make a simple search
    When I make a simple search with query "kinase"
    Then the page source should contain texts
      | Mitogen-activated protein kinase kinase kinase kinase 4 |
      | Aurora kinase B                                         |