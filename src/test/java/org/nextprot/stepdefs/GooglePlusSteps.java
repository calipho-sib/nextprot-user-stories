package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import org.nextprot.StepUtils;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GooglePlusSteps {

    @And("^I click on google\\+ button$")
    public void iClickOnGooglePlusButton() throws Throwable {

        WebDriverManager.getDriver().findElement(By.className("a0-googleplus")).click();
    }

    @And("^I sign in with gmail as \"([^\"]*)\"$")
    public void iSignInToGmailAs(String account) throws Throwable {

        String email = StepUtils.getProperty(account);
        String password = StepUtils.getProperty(account+".password");

        WebElement element = WebDriverManager.getDriver().findElement(By.id("Email"));
        element.sendKeys(email);
        WebDriverManager.getDriver().findElement(By.id("next")).click();
        WebDriverManager.getDriver().findElement(By.id("Passwd")).sendKeys(password);
        WebDriverManager.getDriver().findElement(By.id("signIn")).click();
    }
}
