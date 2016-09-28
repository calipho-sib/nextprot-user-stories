package org.nextprot.stepdefs.search;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

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

    @Then("^the page source should contain texts$")
    public void thePageSourceShouldContainTexts(List<String> textList) throws Throwable {

        new WebDriverWait(WebDriverManager.getDriver(), 10).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver d) {

                for (String text : textList) {

                    if (!d.getPageSource().contains(text)) {
                        return false;
                    }
                }
                return true;
            }
        });
    }

    @Then("^the page source should contain text \"([^\"]*)\"$")
    public void thePageSourceShouldContainText(String text) throws Throwable {

        thePageSourceShouldContainTexts(Collections.singletonList(text));
    }
}
