package org.nextprot;

import org.nextprot.stepdefs.utils.StepUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.DesiredCapabilities.chrome;
import static org.openqa.selenium.remote.DesiredCapabilities.firefox;

public class WebDriverManager {

    enum DriverName {
        FIREFOX, CHROME, EDGE, SAFARI, IE, OPERA
    }

    private static WebDriver driver;

    static void initDriver(DriverName driverName) {

        initDriver(driverName, false);
    }

    static void initRemoteDriver(DriverName driverName) {

        initDriver(driverName, true);
    }

    private static void initDriver(DriverName driverName, boolean remote) {

        DesiredCapabilities desiredCapabilities = newDesiredCapabilities(driverName);

        if (remote) {
            driver = newRemoteWebDriver(desiredCapabilities);
        }
        else {
            switch (driverName) {
                case FIREFOX:
                    System.setProperty("webdriver.firefox.bin", StepUtils.getProperty("webdriver.firefox.bin"));
                    driver = new FirefoxDriver(desiredCapabilities);
                    break;
                case CHROME:
                    driver = new ChromeDriver(desiredCapabilities);
                    break;
                default:
                    throw new IllegalStateException("cannot instanciate web driver "+driverName);
            }
        }
    }

    private static DesiredCapabilities newDesiredCapabilities(DriverName driverName) {

        DesiredCapabilities desiredCapabilities = null;

        if (driverName == DriverName.CHROME) {
            desiredCapabilities = chrome();

            desiredCapabilities.setCapability("platform", "Linux");
            desiredCapabilities.setCapability("driver.version", "2.24");
            //System.setProperty("webdriver.chrome.driver", StepUtils.getProperty("webdriver.chrome.driver"));
        }
        else if (driverName == DriverName.FIREFOX) {
            desiredCapabilities = firefox();
        }

        return desiredCapabilities;
    }

    private static WebDriver newRemoteWebDriver(DesiredCapabilities desiredCapabilities) {

        try {
            //return new RemoteWebDriver(new URL("http://miniwatt:4444/wd/hub"), desiredCapabilities);
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        throw new IllegalStateException("cannot create new remote web driver for driver "+desiredCapabilities.getBrowserName());
    }

    static void closeDriver() {

        driver.quit();
    }

    public static WebDriver getDriver() {

        return driver;
    }

    public static JavascriptExecutor getJavascriptExecutor() {

        return (JavascriptExecutor) WebDriverManager.getDriver();
    }

    static Wait<WebDriver> fluentWait(int seconds) {

        Objects.requireNonNull(driver);

        return new FluentWait<>(driver)
                .withTimeout(seconds, TimeUnit.SECONDS)
                .pollingEvery(seconds/5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public static WebElement waitUntilFindElement(int seconds, final By locator) {

        return fluentWait(seconds).until(d -> d.findElement(locator));
    }

    public static WebElement waitUntilFindElement(int seconds, final WebElement fromElement, final By locator) {

        return fluentWait(seconds).until(d -> fromElement.findElement(locator));
    }

    public static List<WebElement> waitUntilFindElements(int seconds, final By locator) {

        return fluentWait(seconds).until(d -> d.findElements(locator));
    }

    public static List<WebElement> waitUntilFindElements(int seconds, final WebElement fromElement, final By locator) {

        return fluentWait(seconds).until(d -> fromElement.findElements(locator));
    }

    public static Boolean fluentWaitUntilExpectedCondition(int seconds, ExpectedCondition<Boolean> expectedCondition) {

        return fluentWait(seconds).until(expectedCondition);
    }
}
