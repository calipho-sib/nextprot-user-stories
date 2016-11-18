package org.nextprot.scenario.step_definition.search;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.nextprot.scenario.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


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
