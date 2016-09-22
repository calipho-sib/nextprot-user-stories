package org.nextprot;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", tags = "@active", dryRun = true, plugin = {"pretty", "html:target/cucumber"})
public class CucumberRunTest {

    @Test
    public void intellijDoesNotCreateAWarningOverTheClassAnymore() {}
}
