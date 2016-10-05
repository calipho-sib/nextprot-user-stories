package org.nextprot.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.nextprot.StepUtils;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;

public class GooglePlusSteps {

    @And("^I click on google\\+ button$")
    public void iClickOnGoogleButton() throws Throwable {

        WebDriverManager.getDriver().findElement(By.className("a0-googleplus")).click();
    }

    @And("^I sign in with google\\+ as \"([^\"]*)\"$")
    public void iClickOnGoogleplusWithGoogleAs(String account) throws Throwable {

        String email = StepUtils.getProperty(account);
        String password = StepUtils.getProperty(account+".password");

        WebDriverManager.getDriver().findElement(By.id("Email")).sendKeys(email);
        WebDriverManager.getDriver().findElement(By.id("Passwd-hidden")).sendKeys(password);
    }

    @And("^I fill google\\+ email as \"([^\"]*)\"$")
    public void iFillGoogleEmailAs(String account) throws Throwable {

        String email = StepUtils.getProperty(account);
        WebDriverManager.getDriver().findElement(By.id("Email")).sendKeys(email);
    }

    @And("^I fill google\\+ password as \"([^\"]*)\"$")
    public void iFillGooglePasswordAs(String account) throws Throwable {

        String password = StepUtils.getProperty(account+".password");

        WebDriverManager.getDriver().findElement(By.id("Passwd-hidden")).sendKeys(password);
    }

    @And("^I click on google\\+ next$")
    public void iClickOnGoogleNext() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I click on google\\+ connexion$")
    public void iClickOnGoogleConnexion() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
