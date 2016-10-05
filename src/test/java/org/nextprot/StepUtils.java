package org.nextprot;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class StepUtils {

    private static Properties properties;

    static {
        try {
            properties = loadProperties(StepUtils.class.getClassLoader().getResource("settings.properties").getFile());
        } catch (IOException e) {
            throw new IllegalStateException("cannot load file 'settings.properties'", e);
        }
    }

    public static boolean valueOfShouldBeStatus(String shouldStatus) {

        boolean shouldBe;

        if ("should".equalsIgnoreCase(shouldStatus)) {
            shouldBe = true;
        } else if ("should not".equalsIgnoreCase(shouldStatus)) {
            shouldBe = false;
        } else {
            throw new IllegalArgumentException(shouldStatus + ": bad argument format (take only values 'should' or 'should not')");
        }

        return shouldBe;
    }

    public static WebElement fluentWaitUntilFindElement(WebDriver driver, int seconds, final By locator) {

        Objects.requireNonNull(driver);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(seconds, TimeUnit.SECONDS)
                .pollingEvery(seconds/5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(d -> d.findElement(locator));
    }

    public static String getProperty(String name) {

        return properties.getProperty(name);
    }

    private static Properties loadProperties(String fileName) throws IOException {

        Objects.requireNonNull(fileName);

        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(fileName)) {

            prop.load(input);
        }

        return prop;
    }
}
