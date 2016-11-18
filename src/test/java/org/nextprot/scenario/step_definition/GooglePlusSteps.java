package org.nextprot.scenario.step_definition;

import cucumber.api.java.en.And;
import org.nextprot.scenario.WebDriverManager;
import org.nextprot.scenario.step_definition.utils.PropertyRegister;
import org.openqa.selenium.By;

public class GooglePlusSteps {

    @And("^I click on google\\+ button$")
    public void iClickOnGooglePlusButton() throws Throwable {

        WebDriverManager.waitUntilFindElement(30, By.className("a0-googleplus")).click();
    }

    @And("^I sign in with gmail as \"([^\"]*)\"$")
    public void iSignInToGmailAs(String account) throws Throwable {

        String email = PropertyRegister.getProperty(account);
        String password = PropertyRegister.getProperty(account+".password");

        WebDriverManager.waitUntilFindElement(30, By.id("Email")).sendKeys(email);

        WebDriverManager.waitUntilFindElement(30, By.id("next")).click();
        WebDriverManager.waitUntilFindElement(30, By.id("Passwd")).sendKeys(password);
        WebDriverManager.waitUntilFindElement(30, By.id("signIn")).click();
    }
}
