package org.nextprot.stepdefs.snorql;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class SnorqlSteps {

    @When("^I click on sparql query \"([^\"]*)\"$")
    public void iClickOnSparqlQueryExample(String queryName) throws Throwable {
        List<WebElement> elements = getAllPublicQueryList();
        for (WebElement we : elements) {

            if (we.getText().startsWith(queryName)) {

                we.click();
                break;
            }
        }
    }

    @Then("^the results should contain text \"([^\"]*)\"$")
    public void theSnorqlResultsShouldContainText(String expectedResult) throws Throwable {

        WebDriverManager.fluentWaitUntilExpectedCondition(45, driver -> {

            for (WebElement result : WebDriverManager.waitUntilFindElements(30, By.xpath("//a[contains(@class, 'graph-link')]"))) {

                if (result.getText().contains(expectedResult))
                    return true;
            }
            return false;
        });
    }

    private static List<WebElement> getAllPublicQueryList() {

        return WebDriverManager.waitUntilFindElements(30, By.xpath("//h5[contains(@class, 'list-group-item-heading ng-binding')]"))
                .stream().filter(e -> e.getText().startsWith("NXQ_")).collect(Collectors.toList());
    }

    @Then("^an error \"does\\s([^\"]*)\" occur$")
    public void thereIsNoError(String errorStatus) throws Throwable {

        boolean hasError = errorStatus.isEmpty();

        if (hasError) {
            WebDriverManager.fluentWaitUntilExpectedCondition(30, driver -> !WebDriverManager.waitUntilFindElement(20, By.xpath("//div[contains(@ng-show, 'error')]")).getText().isEmpty());
        }
        else {
            WebDriverManager.fluentWaitUntilExpectedCondition(30, driver -> {

                String execTimeText = WebDriverManager.waitUntilFindElement(20, By.xpath("//div[contains(@ng-show, 'executionTime')]")).getText();

                Pattern pat = Pattern.compile("Query time is .+ for (\\d+) rows");

                Matcher matcher = pat.matcher(execTimeText);

                if (matcher.find()) {

                    return Integer.parseInt(matcher.group(1)) > 0;
                }
                return false;
            });
        }
    }
}
