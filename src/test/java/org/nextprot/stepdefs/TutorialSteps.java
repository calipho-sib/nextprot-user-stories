package org.nextprot.stepdefs;

import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TutorialSteps {

    /*
  Scenario: Search nextprot in google
    Given I navigate to url "https://www.google.ch/"
    When I make a search with query "nextprot" from input id "lst-ib" and type enter
    Then the page source should contain text "https://www.nextprot.org/"

  Scenario: Search nextprot in google (google specific)
    Given I navigate to url "https://www.google.ch/"
    When I make a google search with query "nextprot" and type enter
    Then the page source should contain texts
      | NeXtProt - Wikipedia                              |
      | neXtProt: a knowledge platform for human proteins |
      | GitHub - calipho-sib
     */
    @When("^I make a google search with query \"([^\"]*)\" and type enter$")
    public void iMakeAGoogleSearchWithQuery(String query) throws Throwable {

        iMakeASearchWithQueryFromInputId(query, "lst-ib");
    }

    @When("^I make a search with query \"([^\"]*)\" from input id \"([^\"]*)\" and type enter$")
    public void iMakeASearchWithQueryFromInputId(String query, String id) throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.id(id)).sendKeys(query);
        WebDriverManager.waitUntilFindElement(20, By.id(id)).sendKeys(Keys.ENTER);
    }
}
