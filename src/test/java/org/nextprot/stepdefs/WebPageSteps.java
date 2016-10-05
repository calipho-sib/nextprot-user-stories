package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.nextprot.StepUtils.fluentWaitUntilFindElement;

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

    @When("^I click on sign up$")
    public void iClickOnSignUp() throws Throwable {

        WebDriverManager.getDriver().findElement(By.xpath("//a[contains(@class, 'a0-sign-up a0-btn-small')]")).click();
    }

    @Given("^I click on \"([^\"]*)\" dropdown$")
    public void iClickOnDropdown(String elementId) throws Throwable {

        WebDriverManager.getDriver().findElement(By.id(elementId)).click();
    }

    @When("^I select all search results$")
    public void iSelectAllSearchResultWithAccession() throws Throwable {

        fluentWaitUntilFindElement(WebDriverManager.getDriver(), 20, By.id("main-clipboard-button")).click();
    }

    @Then("^I sign \"([^\"]*)\" the form with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iFillTheFormWithEmailAndPassword(String sign, String email, String password) throws Throwable {

        WebDriverManager.getDriver().findElement(By.id("a0-sign"+sign+"_easy_email")).sendKeys(email);
        WebDriverManager.getDriver().findElement(By.id("a0-sign"+sign+"_easy_password")).sendKeys(password);
    }

    @And("^I submit to auth0$")
    public void iSubmitToAut0() throws Throwable {

        fluentWaitUntilFindElement(WebDriverManager.getDriver(), 5, By.xpath("//button[contains(@class, 'a0-primary a0-next')]")).click();
    }

    @Then("^a signup error appears with message \"([^\"]*)\"$")
    public void aSignupErrorAppearsWithMessage(String expectedErrorMessage) throws Throwable {

        WebElement h2Element = fluentWaitUntilFindElement(WebDriverManager.getDriver(), 10, By.xpath("//h2[contains(@class, 'a0-error')]"));

        new WebDriverWait(WebDriverManager.getDriver(), 10).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver d) {

                return h2Element.getText().startsWith(expectedErrorMessage);
            }
        });
    }
}
