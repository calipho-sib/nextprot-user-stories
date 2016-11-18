package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.nextprot.stepdefs.utils.StepUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

import static org.nextprot.stepdefs.utils.StepUtils.valueOfBooleanFromNotStatus;
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

        fluentWaitUntilExpectedCondition(30, d -> WebDriverManager.getDriver().getTitle().equals(expectedTitle));
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

    @Then("^the page source should( not)? contain( ignored case)? text \"([^\"]*)\"$")
    public void thePageSourceShouldContainText(String shouldNotContainText, String ignoreCase, String text) throws Throwable {

        thePageSourceShouldContainTexts(shouldNotContainText, ignoreCase, Collections.singletonList(text));
    }

    @Then("^the page source should( not)? contain( ignored case)? texts$")
    public void thePageSourceShouldContainTexts(String notStatus, String ignoreCase, List<String> textList) throws Throwable {

        boolean reverseSearch = valueOfBooleanFromNotStatus(notStatus);
        boolean caseSensitive = !" ignore case".equalsIgnoreCase(ignoreCase);

        fluentWaitUntilExpectedCondition(30, d ->
                new TextFinder(d.getPageSource(), caseSensitive, reverseSearch).findText(textList) ||
                new TextFinder(d.switchTo().frame("iframeViewer").getPageSource(), caseSensitive, reverseSearch).findText(textList)
        );
    }

    @Then("^the page source should( not)? match pattern \"([^\"]*)\"$")
    public void thePageSourceShouldMatchPattern(String shouldNotContainText, String pattern) throws Throwable {

        thePageSourceShouldMatchTexts(shouldNotContainText, Collections.singletonList(pattern));
    }

    @Then("^the page source should( not)? match patterns$")
    public void thePageSourceShouldMatchTexts(String notStatus, List<String> patternList) throws Throwable {

        boolean reverseSearch = valueOfBooleanFromNotStatus(notStatus);

        fluentWaitUntilExpectedCondition(30, d ->
                new TextFinder(d.getPageSource(), true, reverseSearch).matchPattern(patternList) ||
                new TextFinder(d.switchTo().frame("iframeViewer").getPageSource(), true, reverseSearch).matchPattern(patternList)
        );
    }
}
