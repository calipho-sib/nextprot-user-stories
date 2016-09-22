package org.nextprot.stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.nextprot.HtmlElement;

public class WebPage {

    HtmlElement htmlElement = new HtmlElement();

    @And("^I am connected with my google account$")
    public void iAmConnectedWithMyGoogleAccount() {
    }

    @Then("^I am logged \"([^\"]*)\"$")
    public void iAmLogged(String logged) {
    }

    @When("^I click on 'Login' button$")
    public void iClickOnLoginButton() {
    }

    @When("^I click on 'Logout' button$")
    public void iClickOnLogoutButton() {
    }

    @Given("^I am on page \"([^\"]*)\"$")
    public void iAmOnPage(String page) throws Throwable {

        Assert.assertTrue(htmlElement.isOnPage(page));
    }
}
