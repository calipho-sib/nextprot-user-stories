package org.nextprot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private static WebDriver driver;

    public static void newDriver() {

        driver = new FirefoxDriver();
    }

    public static void closeDriver() {

        driver.quit();
    }

    public static WebDriver getDriver() {

        return driver;
    }
}
