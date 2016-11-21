# Tutorial

## Create a first scenario

There is a new hidden service `https://dev-api.nextprot.org/entry-gene-names.json` returning the map of all neXtProt entry accessions and their associated gene names.

Create a new file "tutorial.feature" and write one scenario that tests that the service returns the following entries:
```
"NX_P04156" : [ "PRNP" ]
"NX_F7VJQ1" : [ "PRNP" ]
```

Here is a template for the scenario:

```
Feature: Learn gherkin and cucumber

  Scenario: As a user of api.nextprot.org I want to retrieve all accession numbers mapped with their gene names
    Given ...
    When ...
    Then ...
```

> You should reuse already defined steps in this scenario.

## Create another scenario

In the same a file "tutorial.feature", write a new scenario that search `nextprot` from google:

Here is a template for the scenario:

```
  Scenario: Search nextprot over google
    Given ...
    When ...
    Then ...
```

> Tip: You should just need to declare one new step in this scenario.
