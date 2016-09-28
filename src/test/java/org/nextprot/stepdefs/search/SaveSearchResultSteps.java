package org.nextprot.stepdefs.search;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.nextprot.StepUtils.valueOfShouldBeStatus;

public class SaveSearchResultSteps {


    @When("^I select first search result$")
    public void iSelectFirstSearchResult() throws Throwable {

        WebElement ul = WebDriverManager.getDriver().findElement(By.id("search-results"));
        WebElement checkbox = ul.findElement(By.xpath("//input[@value=\"NX_O95819\"]"));
        checkbox.click();
    }

    @Then("^the list \"([^\"]*)\" be saved$")
    public void theListBeSaved(String shouldStatus) throws Throwable {

        boolean shouldBeSaved = valueOfShouldBeStatus(shouldStatus);

        System.err.println("todo: "+shouldStatus);
    }
}
