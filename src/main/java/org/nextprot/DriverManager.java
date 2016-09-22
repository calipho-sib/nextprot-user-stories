package org.nextprot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;
    private Properties props;

    public void openBrowser() {

        props = readPropertiesFromFile("config.properties");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void closeBrowser() {

        driver.quit();
    }

    protected String getProperty(String name) {

        return props.getProperty(name);
    }

    private static Properties readPropertiesFromFile(String filename) {

        Properties props = new Properties();

        try (InputStream input = new FileInputStream(filename)) {

            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return props;
    }
}
