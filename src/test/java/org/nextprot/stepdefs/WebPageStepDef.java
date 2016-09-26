package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebPageStepDef {

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
            default:
                throw new IllegalArgumentException("cannot find url for page "+page);
        }
    }

    private WebDriver driver;

    @When("^I am on nextprot page \"([^\"]*)\"$")
    public void shouldNavigateToNextprotPage(String pageName) throws Throwable {

        driver = new FirefoxDriver();
        driver.navigate().to(getNextprotPageUrl(pageName));
    }

    @Then("^I check page title is \"([^\"]*)\"$")
    public void pageTitleShouldBe(String expectedTitle) throws Throwable {
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    @When("^I navigate to \"([^\"]*)\"$")
    public void shouldClickOnLink(String link) throws Throwable {

        driver.findElement(By.linkText(link)).click();
    }

    @Then("^I should find in the page \"([^\"]*)\"$")
    public void iShouldFindInThePage(String expectedName) throws Throwable {

        Assert.assertTrue(driver.getPageSource().contains(expectedName));

    }

    @And("^I close the browser$")
    public void iCloseTheBrowser() throws Throwable {
        driver.close();
    }

    /* @And("^I am connected with my google account$")
    public void iAmConnectedWithMyGoogleAccount() {
    }

    @Then("^I am logged \"([^\"]*)\"$")
    public void iAmLogged(String logged) {
    }

    @Then("^I should see the Application release version$")
    public void i_check_that_Application_release_is_defined() {

        String text = driver.findElement(By.xpath("//p[@class=\"ng-binding\"]")).getText();
        Assert.assertEquals("Data release: 2016-08-25", text);
        driver.quit();
    } */
}
