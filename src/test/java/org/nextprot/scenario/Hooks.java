package org.nextprot.scenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {

    // run before any scenario
    @Before
    public void setupWebDriver() {

        WebDriverManager.initDriver();
    }

    // run after any scenario
    @After
    public void closeWebDriver() {

        WebDriverManager.closeDriver();
    }
}
