package org.nextprot.stepdefs.search;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.nextprot.StepUtils.valueOfShouldBeStatus;

public class SaveSearchResultSteps {


    @Then("^the list \"([^\"]*)\" be saved$")
    public void theListBeSaved(String shouldStatus) throws Throwable {

        boolean shouldBeSaved = valueOfShouldBeStatus(shouldStatus);

        String value = WebDriverManager.getDriver().findElement(By.xpath("//span[contains(@class, 'badge ng-binding')]")).getText();

        System.err.println(value);
    }

    @When("^I select one search result with accession \"([^\"]*)\"$")
    public void iSelectOneSearchResultWithAccession(String accession) throws Throwable {

        WebElement ul = WebDriverManager.getDriver().findElement(By.id("search-results"));
        WebElement checkbox = ul.findElement(By.xpath("//input[@value=\""+accession+"\"]"));
        checkbox.click();
    }

    @Then("^the badge should be equal to \"([^\"]*)\"$")
    public void theBadgeShouldBeEqualTo(String expectedCountString) throws Throwable {

        String observedCountString = WebDriverManager.getDriver().findElement(By.xpath("//span[contains(@class, 'badge ng-binding')]")).getText();

        Assert.assertTrue(observedCountString.equals(expectedCountString));
    }
}
