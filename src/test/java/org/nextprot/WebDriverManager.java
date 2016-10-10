package org.nextprot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverManager {

    private static WebDriver driver;

    static void initFirefoxDriver() {

        driver = newFirefoxDriver();
    }

    static void initChromeDriver() {

        driver = newChromeDriver();
    }

    private static WebDriver newChromeDriver() {

        System.setProperty("webdriver.chrome.driver", StepUtils.getProperty("webdriver.chrome.driver"));
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability("webdriver.chrome.args", StepUtils.getProperty("webdriver.chrome.args"));

        return new ChromeDriver(desiredCapabilities);
    }

    private static WebDriver newFirefoxDriver() {

        return new FirefoxDriver();
    }

    static void closeDriver() {

        driver.quit();
    }

    public static WebDriver getDriver() {

        return driver;
    }
}
