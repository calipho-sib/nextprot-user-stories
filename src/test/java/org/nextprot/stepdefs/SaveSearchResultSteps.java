package org.nextprot.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SaveSearchResultSteps {


    @Then("^The list is saved in user space \"([^\"]*)\"$")
    public void theListIsSavedInUserSpace(String shouldBeSaved) throws Throwable {


    }

    @When("^I select first search result$")
    public void iSelectFirstSearchResult() throws Throwable {

        WebElement ul = WebDriverManager.getDriver().findElement(By.id("search-results"));
        WebElement checkbox = ul.findElement(By.xpath("//input[@value=\"NX_O95819\"]"));
        checkbox.click();
    }
}
