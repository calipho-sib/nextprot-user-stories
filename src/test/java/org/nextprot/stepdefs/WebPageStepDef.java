package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebPageStepDef {

    public static String API    = "http://dev-api.nextprot.org/";
    public static String SEARCH = "http://dev-search.nextprot.org/";
    public static String SNORQL = "http://dev-snorql.nextprot.org/";

    WebDriver driver;

    @And("^I am connected with my google account$")
    public void iAmConnectedWithMyGoogleAccount() {
    }

    @Then("^I am logged \"([^\"]*)\"$")
    public void iAmLogged(String logged) {
    }

    @When("^I click on 'Login' button$")
    public void iClickOnLoginButton() {
    }

    @When("^I click on 'Logout' button$")
    public void iClickOnLogoutButton() {
    }

    @Given("^I am on page \"([^\"]*)\"$")
    public void iAmOnPage(String page) throws Throwable {

        Assert.assertEquals(getUrl(page), driver.getCurrentUrl());
    }

    @Given("^I navigate to nextprot search page$")
    public void iShouldNavigateToSearchNextprotSearchPage() {

        driver = new FirefoxDriver();
        driver.navigate().to(SEARCH);
    }

    @When("^I click 'Release contents' link$")
    public void i_click_on_button_Release_contents() {

        driver.findElement(By.linkText("Release contents")).click();
    }

    @Then("^I should see the Application release version$")
    public void i_check_that_Application_release_is_defined() {

        String text = driver.findElement(By.xpath("//p[@class=\"ng-binding\"]")).getText();
        Assert.assertEquals("Data release: 2016-08-25", text);
        driver.quit();
    }

    @Then("^page should be valid$")
    public void pageShouldBeValid() throws Throwable {

        iAmOnPage("search");
        driver.quit();
    }

    public static String getUrl(String page) {

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

    @Given("^I am on nextprot search page$")
    public void iAmOnNextprotSearchPage() throws Throwable {
        driver = new FirefoxDriver();
        driver.navigate().to(SEARCH);
    }

    @Then("^I check page title is neXtProt platform$")
    public void iCheckPageTitleIsNeXtProtPlatform() throws Throwable {
        Assert.assertTrue(driver.getTitle().contains("neXtProt platform"));
    }
}
