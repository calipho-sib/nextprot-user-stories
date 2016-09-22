package org.nextprot.stepdefsnonactive;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GeneNameSteps {

    @Given("^entry accession is <entry>$")
    public void entryAccessionIsEntry() {
        System.out.println("entry accession is...");
    }

    @When("^submission is done$")
    public void submissionIsDone() {
        System.out.println("submission is done...");
    }

    @Then("^expecting gene names is <genes>$")
    public void expectingGeneNamesIsGenes() {

    }
}
