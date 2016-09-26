package org.nextprot.stepdefs;

import com.google.common.base.Predicate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageSteps {

    private static String API    = "http://dev-api.nextprot.org/";
    private static String SEARCH = "http://dev-search.nextprot.org/";
    private static String SNORQL = "http://dev-snorql.nextprot.org/";

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

    @When("^I am on nextprot page \"([^\"]*)\"$")
    public void shouldNavigateToNextprotPage(String pageName) throws Throwable {

        WebDriverManager.newDriver();
        WebDriverManager.getDriver().navigate().to(getNextprotPageUrl(pageName));
    }

    @Then("^I check page title is \"([^\"]*)\"$")
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

    @And("^I am logged \"([^\"]*)\"$")
    public void iAmLoggedTo(String expectedLogStatus) {

        boolean shouldBeLogged = Boolean.parseBoolean(expectedLogStatus);

        new WebDriverWait(WebDriverManager.getDriver(), 20).until(new Predicate<WebDriver>() {

            @Override
            public boolean apply(WebDriver driver) {

                String script = "angular.element('[ng-controller=SearchCtrl]').scope().user.profile.username";

                if (driver instanceof JavascriptExecutor) {

                    Object res = ((JavascriptExecutor) driver).executeScript(script);

                    boolean isLogged = res instanceof String && !"Guest".equals(res);

                    return shouldBeLogged == isLogged;
                }

                return false;
            }
        });
    }

    @And("^I close the browser$")
    public void iCloseTheBrowser() throws Throwable {
        WebDriverManager.closeDriver();
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
}
