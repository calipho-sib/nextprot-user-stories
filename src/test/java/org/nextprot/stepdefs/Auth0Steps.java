package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.nextprot.StepUtils.fluentWaitUntilFindElement;
import static org.nextprot.StepUtils.valueOfShouldBeStatus;

public class Auth0Steps {

    @When("^I click on sign up$")
    public void iClickOnSignUp() throws Throwable {

        WebDriverManager.getDriver().findElement(By.xpath("//a[contains(@class, 'a0-sign-up a0-btn-small')]")).click();
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

    @And("^I \"([^\"]*)\" be logged$")
    public void iAmLogged(String shouldStatus) throws Throwable {

        boolean shouldBeLogged = valueOfShouldBeStatus(shouldStatus);

        String script = "return angular.element('[ng-controller=SearchCtrl]').scope().user.profile.username";

        new WebDriverWait(WebDriverManager.getDriver(), 30).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver d) {

                if (d instanceof JavascriptExecutor) {

                    String res = (String) ((JavascriptExecutor) d).executeScript(script);

                    boolean isLogged = res != null && !"Guest".equals(res);

                    return shouldBeLogged == isLogged;
                }

                return false;
            }
        });
    }

    @And("^I click on googleplus button$")
    public void iLogWithGoogle() throws Throwable {

        WebDriverManager.getDriver().findElement(By.className("a0-googleplus")).click();
    }
}
