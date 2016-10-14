package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.StepUtils;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.nextprot.StepUtils.valueOfShouldBeStatus;
import static org.nextprot.WebDriverManager.fluentWaitUntilExpectedCondition;

public class Auth0Steps {

    @When("^I click on sign up$")
    public void iClickOnSignUp() throws Throwable {

        WebDriverManager.waitUntilFindElement(20, By.xpath("//a[contains(@class, 'a0-sign-up a0-btn-small')]")).click();
    }

    @And("^I sign \"([^\"]*)\" with email as \"([^\"]*)\"$")
    public void iSignTheFormWithEmail(String sign, String emailPropName) throws Throwable {

        String email = StepUtils.getProperty(emailPropName);
        String password = StepUtils.getProperty(emailPropName+".password");

        Assert.assertTrue("missing password for "+emailPropName+ "", !password.isEmpty());

        WebDriverManager.waitUntilFindElement(20, By.id("a0-sign"+sign+"_easy_email")).sendKeys(email);
        WebDriverManager.waitUntilFindElement(20, By.id("a0-sign"+sign+"_easy_password")).sendKeys(password);
    }

    @And("^I submit to auth0$")
    public void iSubmitToAut0() throws Throwable {

        WebDriverManager.waitUntilFindElement(5, By.xpath("//button[contains(@class, 'a0-primary a0-next')]")).click();
    }

    @Then("^a signup error appears with message \"([^\"]*)\"$")
    public void aSignupErrorAppearsWithMessage(String expectedErrorMessage) throws Throwable {

        WebElement h2Element = WebDriverManager.waitUntilFindElement(10, By.xpath("//h2[contains(@class, 'a0-error')]"));

        fluentWaitUntilExpectedCondition(20, d -> h2Element.getText().startsWith(expectedErrorMessage));
    }

    @And("^I \"([^\"]*)\" be logged to nextprot$")
    public void iAmLoggedIn(String shouldStatus) throws Throwable {

        fluentWaitUntilExpectedCondition(30, d -> {

            if (d instanceof JavascriptExecutor) {

                String script = "return angular.element('[ng-controller=SearchCtrl]').scope().user.profile.username";

                String res = (String) ((JavascriptExecutor) d).executeScript(script);

                boolean isLogged = res != null && !"Guest".equals(res);

                return valueOfShouldBeStatus(shouldStatus) == isLogged;
            }

            return false;
        });
    }
}
