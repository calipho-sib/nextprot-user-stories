package org.nextprot.scenario;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".",
        format = {"pretty", "html:target/cucumber", "json:target/cucumber/report.json", "junit:target/cucumber/junit.xml"},
        tags = {"~@dbrelease"})
public class CucumberRunTest {

}
