package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.nextprot.StepUtils;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.nextprot.StepUtils.valueOfBooleanFromNotStatus;
import static org.nextprot.WebDriverManager.fluentWaitUntilExpectedCondition;

public class WebPageSteps {

    public static final String API_URL = StepUtils.getProperty("api");
    public static final String SEARCH_URL = StepUtils.getProperty("search");
    public static final String SNORQL_URL = StepUtils.getProperty("snorql");
    public static final String ANY_URL = StepUtils.getProperty("any");

    public static String getNextprotPageUrl(String page) {

        switch (page) {
            case "api":
                return API_URL;
            case "search":
                return SEARCH_URL;
            case "snorql":
                return SNORQL_URL;
            case "any":
                return ANY_URL;
            default:
                throw new IllegalArgumentException("cannot find url for page "+page);
        }
    }

    @When("^I navigate to nextprot url \"\\{(api|search|snorql|any)\\}(/.*)?\"$")
    public void shouldNavigateToNextprotPage(String host, String path) throws Throwable {

        if (path != null)
            WebDriverManager.getDriver().navigate().to(getNextprotPageUrl(host) + path);
        else
            WebDriverManager.getDriver().navigate().to(getNextprotPageUrl(host));
    }

    @When("^I navigate to url \"([^\"]+)\"$")
    public void shouldNavigateToUrl(String url) throws Throwable {

        WebDriverManager.getDriver().navigate().to(url);
    }

    @When("^I navigate to relative url \"(/.+)\"$")
    public void shouldNavigateToRelativeUrl(String path) throws Throwable {

        String previousURL = WebDriverManager.getDriver().getCurrentUrl();

        WebDriverManager.getDriver().navigate().to(previousURL+path);
    }

    @Then("^the page title should be \"([^\"]*)\"$")
    public void pageTitleShouldBe(String expectedTitle) throws Throwable {

        fluentWaitUntilExpectedCondition(30, d -> WebDriverManager.getDriver().getPageSource().contains(expectedTitle));
    }

    @When("^I click on link text \"([^\"]*)\"$")
    public void clickOnLinkText(String link) throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.linkText(link)).click();
    }

    @When("^I click on link id \"#([^\"]*)\"$")
    public void clickOnLinkId(String linkId) throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.id(linkId)).click();
    }

    @When("^I select option \"([^\"]*)\"$")
    public void selectOptionUrl(String optionLink) throws Throwable {

        clickOnLinkText(optionLink);
    }

    @Then("^I should find in the page \"([^\"]*)\"$")
    public void iShouldFindInThePage(String expectedName) throws Throwable {

        fluentWaitUntilExpectedCondition(30, d -> WebDriverManager.getDriver().getPageSource().contains(expectedName));
    }

    @And("^I click on button \"([^\"]*)\"$")
    public void iClickOnButton(String name) throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.xpath("//button[contains(text(),'"+name+"')]")).click();
    }

    @When("^I click on logged user drop-down$")
    public void iClickOnLogginDropdown() throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.xpath("//a[contains(@class, 'dropdown-toggle lgOnly ng-binding')]")).click();
    }

    @Given("^I click on drop-down id \"#([^\"]*)\"$")
    public void iClickOnDropdownId(String elementId) throws Throwable {

        WebElement dropDownElement = WebDriverManager.waitUntilFindElement(20, By.id(elementId));

        dropDownElement.click();
    }

    @Given("^I click on drop-down \"([^\"]*)\"$")
    public void iClickOnDropdown(String name) throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.xpath("//button[contains(text(),'"+name+"')]")).click();
    }

    @Then("^the page source should( not)? contain text \"([^\"]*)\"$")
    public void thePageSourceShouldContainText(String shouldNotContainText, String text) throws Throwable {

        thePageSourceShouldContainTexts(shouldNotContainText, Collections.singletonList(text));
    }

    @Then("^the page source should( not)? contain texts$")
    public void thePageSourceShouldContainTexts(String notStatus, List<String> textList) throws Throwable {

        fluentWaitUntilExpectedCondition(30, d -> {

            boolean doContain = valueOfBooleanFromNotStatus(notStatus);

            for (String text : textList) {
                if (d != null && d.getPageSource() != null) {
                    if (d.getPageSource().contains(text) != doContain) {
                        return false;
                    }
                }
            }
            return true;
        });
    }

    @Then("^the page source should match pattern \"([^\"]*)\"$")
    public void thePageSourceShouldMatchText(String text) throws Throwable {

        thePageSourceShouldMatchTexts(Collections.singletonList(text));
    }

    @Then("^the page source should match patterns$")
    public void thePageSourceShouldMatchTexts(List<String> regExpList) throws Throwable {

        fluentWaitUntilExpectedCondition(30, d -> {

            for (String regExp : regExpList) {

                if (d != null && d.getPageSource() != null) {

                    Pattern pattern = Pattern.compile(".+" + regExp + ".+", Pattern.DOTALL);
                    Matcher regexMatcher = pattern.matcher(d.getPageSource());

                    if (!regexMatcher.find()) {
                        return false;
                    }
                }
            }
            return true;
        });
    }
}
