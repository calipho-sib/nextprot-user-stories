package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.StepUtils;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

import static org.nextprot.StepUtils.fluentWaitUntilFindElement;

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

        Assert.assertTrue(WebDriverManager.getDriver().getTitle().contains(expectedTitle));
    }

    @When("^I click on link \"([^\"]*)\"$")
    public void clickOnLink(String link) throws Throwable {

        StepUtils.fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20, By.linkText(link)).click();
    }

    @Then("^I should find in the page \"([^\"]*)\"$")
    public void iShouldFindInThePage(String expectedName) throws Throwable {

        Assert.assertTrue(WebDriverManager.getDriver().getPageSource().contains(expectedName));
    }

    @And("^I click on button \"([^\"]*)\"$")
    public void iClickOnButton(String name) throws Throwable {

        StepUtils.fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20,
                By.xpath("//button[contains(text(),'"+name+"')]")).click();
    }

    @When("^I click on nextprot log dropdown$")
    public void iClickOnDropdown() throws Throwable {

        StepUtils.fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20,
                By.xpath("//a[contains(@class, 'dropdown-toggle lgOnly ng-binding')]")).click();
    }

    @Given("^I click on \"([^\"]*)\" dropdown$")
    public void iClickOnDropdown(String elementId) throws Throwable {

        WebDriverManager.getDriver().findElement(By.id(elementId)).click();
    }

    @When("^I select all search results$")
    public void iSelectAllSearchResultWithAccession() throws Throwable {

        fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20, By.id("main-clipboard-button")).click();
    }

    @Then("^the page source should contain texts$")
    public void thePageSourceShouldContainTexts(List<String> textList) throws Throwable {

        new WebDriverWait(WebDriverManager.getDriver(), 30).until(new ExpectedCondition<Boolean>() {

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
