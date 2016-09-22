package org.nextprot;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager2 {

    public static String API    = "http://dev-api.nextprot.org/";
    public static String SEARCH = "http://dev-search.nextprot.org/";
    public static String SNORQL = "http://dev-snorql.nextprot.org/";

    private WebDriver driver;
    private Properties props;

    protected WebDriver getDriver() {
        return driver;
    }
    protected String getPropertyName(String name) {
        return props.getProperty(name);
    }

    public static WebDriver newBrowser() {

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability("webdriver.chrome.args", "/Users/fnikitin/Applications/chromedriver");

        WebDriver driver = new ChromeDriver(desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }

    @After
    public void saveScreenshotAndCloseBrowser() throws IOException {
        driver.quit();
    }

    public static String getUrl(String page) {

        switch (page) {
            case "api":
                return API;
            case "search":
                return SEARCH;
            case "snorql":
                return SNORQL;
            default:
                throw new IllegalArgumentException("cannot find url for page "+page);
        }
    }
}
