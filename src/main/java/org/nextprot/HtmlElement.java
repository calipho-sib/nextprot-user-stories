package org.nextprot;

import org.openqa.selenium.By;

public class HtmlElement extends DriverManager {

    public void clickOnLoginButton() {

        driver.findElement(By.id("Login")).sendKeys("");
    }

    public boolean isOnPage(String page) {

        driver.findElement(By.id("")).sendKeys("");
        return true;
    }
}
