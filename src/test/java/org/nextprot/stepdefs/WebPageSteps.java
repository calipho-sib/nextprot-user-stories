package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;

import static org.nextprot.StepUtils.fluentWait;

public class WebPageSteps {

    public static final String API_URL = "http://alpha-api.nextprot.org/";
    public static final String SEARCH_URL = "http://alpha-search.nextprot.org/";
    public static final String SNORQL_URL = "http://alpha-snorql.nextprot.org/";

    public static String getNextprotPageUrl(String page) {

        switch (page) {
            case "api":
                return API_URL;
            case "search":
                return SEARCH_URL;
            case "snorql":
                return SNORQL_URL;
            case "any":
                return SEARCH_URL;
            default:
                throw new IllegalArgumentException("cannot find url for page "+page);
        }
    }

    @When("^I am on \"([^\"]*)\" nextprot page$")
    public void shouldNavigateToNextprotPage(String pageName) throws Throwable {

        WebDriverManager.getDriver().navigate().to(getNextprotPageUrl(pageName));
    }

    @Then("^the page title should be \"([^\"]*)\"$")
    public void pageTitleShouldBe(String expectedTitle) throws Throwable {
        Assert.assertTrue(WebDriverManager.getDriver().getTitle().contains(expectedTitle));
    }

    @When("^I click on link \"([^\"]*)\"$")
    public void clickOnLink(String link) throws Throwable {

        WebDriverManager.getDriver().findElement(By.linkText(link)).click();
    }

    @Then("^I should find in the page \"([^\"]*)\"$")
    public void iShouldFindInThePage(String expectedName) throws Throwable {

        Assert.assertTrue(WebDriverManager.getDriver().getPageSource().contains(expectedName));

    }

    @And("^I click on button \"([^\"]*)\"$")
    public void iClickOnButton(String name) throws Throwable {

        WebDriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'"+name+"')]")).click();
    }

    @When("^I click on dropdown$")
    public void iClickOnDropdown() throws Throwable {

        WebDriverManager.getDriver().findElement(By.xpath("//a[contains(@class, 'dropdown-toggle lgOnly ng-binding')]")).click();
    }

    @Given("^I click on \"([^\"]*)\" dropdown$")
    public void iClickOnDropdown(String elementId) throws Throwable {

        WebDriverManager.getDriver().findElement(By.id(elementId)).click();
    }

    @When("^I select all search results$")
    public void iSelectAllSearchResultWithAccession() throws Throwable {

        fluentWait(WebDriverManager.getDriver(), 20, By.id("main-clipboard-button")).click();
    }
}
