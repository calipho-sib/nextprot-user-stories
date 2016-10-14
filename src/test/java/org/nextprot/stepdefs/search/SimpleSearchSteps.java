package org.nextprot.stepdefs.search;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.nextprot.WebDriverManager.waitUntilFindElement;

public class SimpleSearchSteps {

    @And("^I have some result selected$")
    public void iHaveSomeResultSelected() {
    }

    @When("^I make a simple search with query \"([^\"]*)\"$")
    public void iMakeASimpleSearchWithQuery(String query) throws Throwable {

        WebElement searchField = WebDriverManager.waitUntilFindElement(20, By.id("search-query"));

        searchField.sendKeys(query);
        searchField.submit();
    }
}
