package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SimpleSearch {

    @When("^I submit a search for a protein$")
    public void i_search_for_a_protein() {
    }

    @Then("^I see results$")
    public void i_see_results() {
    }

    @Given("^I already submit a search \"([^\"]*)\"$")
    public void iAlreadyMadeASearch(String searchMade) {
    }

    @And("^I have some result selected$")
    public void iHaveSomeResultSelected() {
    }
}
