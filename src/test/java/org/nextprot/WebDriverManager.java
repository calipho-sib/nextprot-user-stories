package org.nextprot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.DesiredCapabilities.chrome;

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

    static void initDriver(DriverName driverName, boolean remote) {

        if (remote) {
            driver = newRemoteWebDriver(driverName);
        }
        else {
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
    }

    private static WebDriver newFirefoxDriver() {

        System.setProperty("webdriver.firefox.bin", StepUtils.getProperty("webdriver.firefox.bin"));

        return new FirefoxDriver();
    }

    private static WebDriver newChromeDriver() {

        System.setProperty("webdriver.chrome.driver", StepUtils.getProperty("webdriver.chrome.driver"));
        DesiredCapabilities desiredCapabilities = chrome();
        desiredCapabilities.setCapability("webdriver.chrome.args", StepUtils.getProperty("webdriver.chrome.args"));

        return new ChromeDriver(desiredCapabilities);
    }

    private static WebDriver newRemoteWebDriver(DriverName driverName) {

        if (driverName == DriverName.CHROME || driverName == DriverName.FIREFOX) {

            DesiredCapabilities desiredCapabilities = (driverName == DriverName.FIREFOX) ?
                    DesiredCapabilities.firefox() : DesiredCapabilities.chrome();

            desiredCapabilities.setCapability("platform", "Linux");

            try {
                //return new RemoteWebDriver(new URL("http://miniwatt:4444/wd/hub"), desiredCapabilities);
                return new RemoteWebDriver(new URL("http://jenkins.vital-it.ch:4444/wd/hub"), desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        throw new IllegalStateException("cannot create new remote web driver for driver "+driverName);
    }

    public static void saveScreenshot(String screenshotFileName) throws IOException {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(screenshotFileName));
        System.out.println("save screenshot "+screenshotFileName);
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

    public static List<WebElement> waitUntilFindElements(int seconds, final By locator) {

        return fluentWait(seconds).until(d -> d.findElements(locator));
    }

    public static WebElement waitUntilFindElement(int seconds, final WebElement fromElement, final By locator) {

        return fluentWait(seconds).until(d -> fromElement.findElement(locator));
    }

    public static Boolean fluentWaitUntilExpectedCondition(int seconds, ExpectedCondition<Boolean> expectedCondition) {

        return fluentWait(seconds).until(expectedCondition);
    }
}
