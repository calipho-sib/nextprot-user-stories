package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleSearchSteps {

    @And("^I have some result selected$")
    public void iHaveSomeResultSelected() {
    }

    @When("^I make a simple search with query \"([^\"]*)\"$")
    public void iMakeASimpleSearchWithQuery(String query) throws Throwable {

        WebElement searchField = WebDriverManager.getDriver().findElement(By.id("search-query"));
        searchField.sendKeys(query);
        searchField.submit();
    }

    @Then("^Page source contains \"([^\"]*)\"$")
    public void pageSourceShouldContain(String result) throws Throwable {

        new WebDriverWait(WebDriverManager.getDriver(), 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(result);
            }
        });
    }
}
