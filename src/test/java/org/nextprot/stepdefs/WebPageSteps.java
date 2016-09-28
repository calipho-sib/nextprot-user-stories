package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class WebPageSteps {

    private static String API    = "http://alpha-api.nextprot.org/";
    private static String SEARCH = "http://alpha-search.nextprot.org/";
    private static String SNORQL = "http://alpha-snorql.nextprot.org/";

    private static String getNextprotPageUrl(String page) {

        switch (page) {
            case "api":
                return API;
            case "search":
                return SEARCH;
            case "snorql":
                return SNORQL;
            case "any":
                return SEARCH;
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

    /*
    @Then("^I should see the Application release version$")
    public void i_check_that_Application_release_is_defined() {
        String text = driver.findElement(By.xpath("//p[@class=\"ng-binding\"]")).getText();
        Assert.assertEquals("Data release: 2016-08-25", text);
        driver.quit();
    } */

    public WebElement fluentWait(WebDriver driver, final By locator) {

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(driver1 -> driver1.findElement(locator));

        return foo;
    };

    @When("^I click on dropdown$")
    public void iClickOnDropdown() throws Throwable {

        WebDriverManager.getDriver().findElement(By.xpath("//a[contains(@class, 'dropdown-toggle lgOnly ng-binding')]")).click();
    }

    @Given("^I click on \"([^\"]*)\" dropdown$")
    public void iClickOnDropdown(String elementId) throws Throwable {

        System.out.println("clicking of dropdown "+elementId);

        WebDriverManager.getDriver().findElement(By.id(elementId)).click();
    }
}
