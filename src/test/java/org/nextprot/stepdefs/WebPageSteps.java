package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.nextprot.StepUtils;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.List;

import static org.nextprot.WebDriverManager.fluentWaitUntilExpectedCondition;
import static org.nextprot.WebDriverManager.waitUntilFindElement;

public class WebPageSteps {

    public static final String API_URL = StepUtils.getProperty("api.url");
    public static final String SEARCH_URL = StepUtils.getProperty("search.url");
    public static final String SNORQL_URL = StepUtils.getProperty("snorql.url");

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

    @When("^I navigate to \"([^\"]*)\" nextprot page$")
    public void shouldNavigateToNextprotPage(String pageName) throws Throwable {

        WebDriverManager.getDriver().navigate().to(getNextprotPageUrl(pageName));
    }

    @When("^I navigate to \"([^\"]*)\"$")
    public void shouldNavigateToUrl(String url) throws Throwable {

        WebDriverManager.getDriver().navigate().to(url);
    }

    @Then("^the page title should be \"([^\"]*)\"$")
    public void pageTitleShouldBe(String expectedTitle) throws Throwable {

        fluentWaitUntilExpectedCondition(30, d -> WebDriverManager.getDriver().getPageSource().contains(expectedTitle));
    }

    @When("^I click on link \"([^\"]*)\"$")
    public void clickOnLink(String link) throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.linkText(link)).click();
    }

    @Then("^I should find in the page \"([^\"]*)\"$")
    public void iShouldFindInThePage(String expectedName) throws Throwable {

        fluentWaitUntilExpectedCondition(30, d -> WebDriverManager.getDriver().getPageSource().contains(expectedName));
    }

    @And("^I click on button \"([^\"]*)\"$")
    public void iClickOnButton(String name) throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.xpath("//button[contains(text(),'"+name+"')]")).click();
    }

    @When("^I click on nextprot log dropdown$")
    public void iClickOnDropdown() throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.xpath("//a[contains(@class, 'dropdown-toggle lgOnly ng-binding')]")).click();
    }

    @Given("^I click on \"([^\"]*)\" dropdown$")
    public void iClickOnDropdown(String elementId) throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.id(elementId)).click();
    }

    @Then("^the page source should contain texts$")
    public void thePageSourceShouldContainTexts(List<String> textList) throws Throwable {

        fluentWaitUntilExpectedCondition(30, d -> {

            for (String text : textList) {
                if (!d.getPageSource().contains(text)) {
                    return false;
                }
            }
            return true;
        });
    }

    @Then("^the page source should contain text \"([^\"]*)\"$")
    public void thePageSourceShouldContainText(String text) throws Throwable {

        thePageSourceShouldContainTexts(Collections.singletonList(text));
    }
}
