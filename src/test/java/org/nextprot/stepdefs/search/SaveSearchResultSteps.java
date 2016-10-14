package org.nextprot.stepdefs.search;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.nextprot.StepUtils.fluentWaitUntilFindElement;
import static org.nextprot.StepUtils.valueOfShouldBeStatus;

public class SaveSearchResultSteps {

    @Then("^the list \"([^\"]*)\" be savable")
    public void theListMayBeSavable(String shouldStatus) throws Throwable {

        boolean shouldBeSaved = valueOfShouldBeStatus(shouldStatus);

        if (shouldBeSaved) {

            Assert.assertTrue(WebDriverManager.getDriver().getPageSource().contains("Create List"));
        } else {
            WebElement alertDiv = fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20,
                    By.xpath("//div[contains(@class, 'flashmsg alert alert-warning alert-dismissible')]"));

            Assert.assertTrue(alertDiv.getText().endsWith("Please login to save a list"));
        }
    }

    @When("^I select search result with accession \"([^\"]*)\"$")
    public void iSelectSearchResultWithAccession(String accession) throws Throwable {

        WebElement ul = fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20, By.id("search-results"));

        ul.findElement(By.xpath("//input[@value=\"" + accession + "\"]")).click();
    }

    @When("^I select all search results$")
    public void iSelectAllSearchResults() throws Throwable {

        fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20, By.id("main-clipboard-button")).click();
    }

    @Then("^the clipboard should contain \"(\\d+)\" elements$")
    public void theClipboardShouldContains(int expectedCount) throws Throwable {

        new WebDriverWait(WebDriverManager.getDriver(), 30).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver d) {

                WebElement elt = d.findElement(By.xpath("//span[contains(@class, 'badge ng-binding')]"));

                String observedCountString = elt.getText();

                return Integer.parseInt(observedCountString) ==  expectedCount;
            }
        });
    }
}
