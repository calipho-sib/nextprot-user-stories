package org.nextprot.stepdefs.snorql;

import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SnorqlSteps {

    @When("^I click on list element \"([^\"]*)\"$")
    public void iClickOnListElement(String arg0) throws Throwable {

        WebElement element = WebDriverManager.waitUntilFindElement(20, By.xpath("//h5[contains(@class, 'list-group-item query-0 active')]"));
        System.out.println(element.getText());
    }
}
