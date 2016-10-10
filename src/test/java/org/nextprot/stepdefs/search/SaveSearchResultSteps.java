package org.nextprot.stepdefs.search;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.StepUtils;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.nextprot.StepUtils.valueOfShouldBeStatus;

public class SaveSearchResultSteps {

    @Then("^the list \"([^\"]*)\" be savable")
    public void theListBeSaved(String shouldStatus) throws Throwable {

        boolean shouldBeSaved = valueOfShouldBeStatus(shouldStatus);

        if (shouldBeSaved) {

            Assert.assertTrue(WebDriverManager.getDriver().getPageSource().contains("Create List"));
        } else {
            WebElement alertDiv = StepUtils.fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20,
                    By.xpath("//div[contains(@class, 'flashmsg alert alert-warning alert-dismissible')]"));

            Assert.assertTrue(alertDiv.getText().endsWith("Please login to save a list"));
        }
    }

    @When("^I select one search result with accession \"([^\"]*)\"$")
    public void iSelectOneSearchResultWithAccession(String accession) throws Throwable {

        WebElement ul = StepUtils.fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20, By.id("search-results"));
        WebElement checkbox = ul.findElement(By.xpath("//input[@value=\""+accession+"\"]"));
        checkbox.click();
    }

    @Then("^the clipboard count should be equal to \"([^\"]*)\"$")
    public void theBadgeShouldBeEqualTo(String expectedCountString) throws Throwable {

        WebElement elt = StepUtils.fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20,
                By.xpath("//span[contains(@class, 'badge ng-binding')]"));

        String observedCountString = elt.getText();

        Assert.assertTrue("observed count: "+observedCountString, observedCountString.equals(expectedCountString));
    }
}
