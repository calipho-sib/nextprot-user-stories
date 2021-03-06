package org.nextprot.scenario;

import org.nextprot.scenario.step_definition.utils.PropertyRegister;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.DesiredCapabilities.chrome;
import static org.openqa.selenium.remote.DesiredCapabilities.firefox;

public class WebDriverManager {

    private enum DriverName {
        FIREFOX, CHROME, EDGE, SAFARI, IE, OPERA
    }

    private static WebDriver driver;

    public static void initDriver() {

        DriverName driverName = WebDriverManager.DriverName.valueOf(PropertyRegister.getProperty("webdriver").toUpperCase());

        DesiredCapabilities desiredCapabilities = newDesiredCapabilities(driverName);

        if (Boolean.valueOf(PropertyRegister.getProperty("webdriver.remote"))) {
            driver = newRemoteWebDriver(desiredCapabilities, PropertyRegister.getProperty("webdriver.remote.url"));
        }
        else {
            switch (driverName) {
                case FIREFOX:
                    System.setProperty("webdriver.firefox.bin", PropertyRegister.getProperty("webdriver.firefox.bin"));
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
        }
        else if (driverName == DriverName.FIREFOX) {
            desiredCapabilities = firefox();
        }

        return desiredCapabilities;
    }

    private static WebDriver newRemoteWebDriver(DesiredCapabilities desiredCapabilities, String remoteUrl) {

        try {
            return new RemoteWebDriver(new URL(remoteUrl), desiredCapabilities);
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

    /**
     * @return a list of page sources (including iframe(s))
     */
    public static List<String> getPageSources() {

        List<String> pageSources = new ArrayList<>(2);

        pageSources.add(driver.getPageSource());

        List<WebElement> iframes = WebDriverManager.waitUntilFindElements(30, By.tagName("iframe"));

        for (WebElement iframe : iframes) {

            WebDriver newDriver = driver.switchTo().frame(iframe);

            pageSources.add(newDriver.getPageSource());

            driver.switchTo().defaultContent();
        }

        return pageSources;
    }
}
