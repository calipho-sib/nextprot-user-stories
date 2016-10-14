package org.nextprot.stepdefs.search;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.nextprot.StepUtils.valueOfShouldBeStatus;
import static org.nextprot.WebDriverManager.fluentWaitUntilExpectedCondition;
import static org.nextprot.WebDriverManager.waitUntilFindElement;

public class SaveSearchResultSteps {

    @Then("^the list \"([^\"]*)\" be savable")
    public void theListMayBeSavable(String shouldStatus) throws Throwable {

        fluentWaitUntilExpectedCondition(30, d -> {

            if (valueOfShouldBeStatus(shouldStatus)) {

                return WebDriverManager.getDriver().getPageSource().contains("Create List");
            } else {
                WebElement alertDiv = WebDriverManager.waitUntilFindElement(20,
                        By.xpath("//div[contains(@class, 'flashmsg alert alert-warning alert-dismissible')]"));

                return alertDiv.getText().endsWith("Please login to save a list");
            }
        });
    }

    @When("^I select search result with accession \"([^\"]*)\"$")
    public void iSelectSearchResultWithAccession(String accession) throws Throwable {

        WebElement ul = WebDriverManager.waitUntilFindElement(20, By.id("search-results"));

        waitUntilFindElement(20, ul, By.xpath("//input[@value=\"" + accession + "\"]")).click();
    }

    @When("^I select all search results$")
    public void iSelectAllSearchResults() throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.id("main-clipboard-button")).click();
    }

    @Then("^the clipboard should contain \"(\\d+)\" elements$")
    public void theClipboardShouldContains(int expectedCount) throws Throwable {

        fluentWaitUntilExpectedCondition(30, d -> {

                WebElement elt = d.findElement(By.xpath("//span[contains(@class, 'badge ng-binding')]"));
                String observedCountString = elt.getText();
                return Integer.parseInt(observedCountString) ==  expectedCount;
            }
        );
    }
}
