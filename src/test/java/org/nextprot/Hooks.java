package org.nextprot;

import cucumber.api.java.After;
import org.junit.Before;

public class Hooks {

    @Before
    public void setup() {
        new DriverManager().openBrowser();
    }

    @After
    public void tearDown() {
        new DriverManager().closeBrowser();
    }
}
