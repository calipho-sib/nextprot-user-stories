package org.nextprot;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    enum DriverName {
        FIREFOX, CHROME, EDGE, SAFARI, IE, OPERA
    }

    private static WebDriver driver;

    static void initDriver(DriverName driverName) {

        switch (driverName) {
            case FIREFOX:
                driver = newFirefoxDriver();
                break;
            case CHROME:
                driver = newChromeDriver();
                break;
            default:
                throw new IllegalStateException("cannot instanciate web driver "+driverName);
        }
    }

    private static WebDriver newFirefoxDriver() {

        System.setProperty("webdriver.firefox.bin", StepUtils.getProperty("webdriver.firefox.bin"));

        return new FirefoxDriver();
    }

    private static WebDriver newChromeDriver() {

        System.setProperty("webdriver.chrome.driver", StepUtils.getProperty("webdriver.chrome.driver"));
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability("webdriver.chrome.args", StepUtils.getProperty("webdriver.chrome.args"));

        return new ChromeDriver(desiredCapabilities);
    }

    static void closeDriver() {

        driver.quit();
    }

    public static WebDriver getDriver() {

        return driver;
    }

    public static Wait<WebDriver> fluentWait(int seconds) {

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

    public static Boolean fluentWaitUntilExpectedCondition(int seconds, ExpectedCondition<Boolean> expectedCondition) {

        return fluentWait(seconds).until(expectedCondition);
    }
}
