package org.nextprot;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {

    // run before any scenario
    @Before
    public void setupWebDriver() {
        WebDriverManager.newDriver();
        WebDriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // run after any scenario
    @After
    public void closeWebDriver() {
        WebDriverManager.closeDriver();
    }
}
