package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.*;
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

    @And("^I \"([^\"]*)\" be logged$")
    public void iAmLogged(String shouldStatus) throws Throwable {

        boolean shouldBeLogged;

        if ("should".equalsIgnoreCase(shouldStatus)) {
            shouldBeLogged = true;
        }
        else if ("should not".equalsIgnoreCase(shouldStatus)) {
            shouldBeLogged = false;
        }
        else {
            throw new IllegalArgumentException(shouldStatus+": bad argument format (take only values 'should' or 'should not')");
        }

        String script = "return angular.element('[ng-controller=SearchCtrl]').scope().user.profile.username";

        WebDriver driver = WebDriverManager.getDriver();

        if (driver instanceof JavascriptExecutor) {

            String res = (String)((JavascriptExecutor) driver).executeScript(script);

            boolean isLogged = res != null && !"Guest".equals(res);

            Assert.assertTrue(shouldBeLogged == isLogged);
        }
    }

    @And("^I click on button \"([^\"]*)\"$")
    public void iClickOnButton(String name) throws Throwable {

        WebDriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'"+name+"')]")).click();
    }

    @And("^I click on googleplus button$")
    public void iLogWithGoogle() throws Throwable {

        WebDriverManager.getDriver().findElement(By.className("a0-googleplus")).click();
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
}
