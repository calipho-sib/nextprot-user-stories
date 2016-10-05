package org.nextprot.stepdefs.api;

import cucumber.api.java.en.When;
import org.nextprot.WebDriverManager;
import org.nextprot.stepdefs.WebPageSteps;

public class EntryApiSteps {

    @When("^I do a REST request with query \"([^\"]*)\"$")
    public void iDoQuery(String query) throws Throwable {

        WebDriverManager.getDriver().navigate().to(getRESTfulURL(query));
    }

    private static String getRESTfulURL(String query) {

        return WebPageSteps.API_URL+query;
    }
}
