package org.nextprot;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class StepUtils {

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
}
