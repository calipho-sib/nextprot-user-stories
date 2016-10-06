package org.nextprot;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/report.json", "junit:target/cucumber/junit.xml"})
//@CucumberOptions(glue = {"classpath:com/rd/uat"}, strict = true,
//        format = {"pretty", "html:target/cucumber", "json:target/cucumber/report.json", "junit:target/cucumber/junit.xml"})
public class CucumberRunTest {

}
