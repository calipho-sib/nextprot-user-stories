Cucumber is an awesome tool that can help us create living documentation. It is a great way to gain a better understanding of how it should function.

It utilizes Gherkin – a language that is at the core of Cucumber’s ability to both document and automate tests. It allows for writing tests around how a feature should behave – a process known as Behaviour Driven Development.

We will gain a better understanding of what is being tested and how a feature should function – something that is along the same lines as writing user stories.

# Gherkin, the `user story` language

Gherkin is a declarative language - you write your code in such a way that it describes what you want to do.

Each `feature` is defined as a bunch of `scenarios` or `user-stories`.

A scenario focuses on 3 kind of step definitions (+ gherkin keywords):

1. an established condition (`Given`...)
2. an action (`When`...)
3. an expected result (`Then`...)

Each step is a declaration of what the user is doing in the scenario.

Example:
```
Scenario: User navigates to profile page
Given the user is in the home page
When he logs in
Then he should be directed to his profile page
```

To be automatically tested by cucumber, each step definition is mapped to java code that handles execution of the step.

Thanks to its declarative language, it's not so hard for non-developers to write them.

Thus we can decouple the definition of a scenario (done by both collaborators) from the attached function (done by developers).

# `user story` compliant editors

We need the help of a text editor to formalize those user-stories. Depending on the profile of the writer, there are some alternative solutions.

## for developers

Developers already uses IDE to write code (Eclipse, Intellij, ...). Most of them provides plugins for cucumber/gherkin.

## for non developers

They need a simpler editor that supports `gherkin` syntax only.

In my opinion, this editor should be able to provide:

1. syntax highlighting for `gherkin`
2. auto-completion on existed feature steps

Here are the most popular modern editors tested for our needs:

- [Brackets.io](http://brackets.io/), an open source code editor for web designers and front-end developers initiated by adobe
- [Visual-studio-code](https://code.visualstudio.com/?utm_expid=101350005-28.R1T8FshdTBWEfZjY0s7XKQ.0&utm_referrer=https%3A%2F%2Fwww.google.ch%2F) is a code editor by microsoft
- [Atom](https://atom.io/) is a text editor developed by github

`Brackets` and `Visual-studio` actually supports syntax highlighting for gherkin but unfortunately not yet auto-completion :(

`Atom` comes with both needed requirements :)

## Installation of ```Atom```

1. First go to web site https://atom.io/ and download the latest release.
2. Launch Atom
3. Click on `Atom/Preferences`
4. Select tab `Install` and search `cucumber` packages
5. Install packages `cucumber` and `cucumber-autocomplete`
6. Select tab `Package` and click on `cucumber-autocomplete` settings, fill `Path` to `/.`

## An example of feature in `Atom`:

![feature](img/example-feature-in-atom.png)

# neXtProt user-stories

Some `feature`s have already been written for neXtProt. They are available from our github repository named [```nextprot-user-stories```](https://github.com/calipho-sib/nextprot-user-stories/tree/develop/src/test/resources/features).

I Highly recommend to get those features (accessed in folder features/) to profit from complete auto-completion of `Atom`.

## Download folder `features/` for full auto-completion

1. Open your browser to [DownGit](https://minhaskamal.github.io/DownGit/#/home) 
2. Paste the link `https://github.com/calipho-sib/nextprot-user-stories/tree/develop/src/test/resources/features`
3. Click on `Download`. 
4. Unzip `features.zip`
5. Open directory `features/` with `Atom`

Here is a snapshot of auto-complete in action with `Atom`:

![feature](img/auto-complete-in-atom.png)

> Note that right after typing `gherkin` keywords (`Given`, `And`, `When`, ...), the auto-completion directly proposes existing steps.
It is also possible to type `ctrl-space` to ask for auto-completion.

> Also note that auto-completion in `Atom` actually ONLY WORKS WITHOUT INTERNAL SPACES.

## File `features.properties`

This file contains variables that can be referenced in step definitions.

For example the variable `search` is referenced in the following step:
```
I navigate to url of nextprot "search"
```

Here variable "search" is an alias for url "http://dev-search.nextprot.org/".

## Development cycle and coordination between feature writers and java coders (TODO, TOTHINK)

There is a list of step definitions already mapping java code in this repository.
They are accessible through auto-completion when writing future `scenario`.

When new steps are created, it is not executable by `cucumber` and the java logic will have to be written by a developer.

# General step definitions

Here are a few already defined step definitions that should be reuse anywhere it is indicated:

## Url navigation

- I navigate to url "url": goto url defined in quoted value 
- I navigate to nextprot url "{np-page}/..." : goto nextprot url defined in alias (with curly brackets) defined in `features.properties`

## Page interaction

- I click on link text "link_name": clicking on a link by name (ex: `Login`)
- I click on link id "#link_id": clicking on a link by id (ex: `#copyright` in nextprot-api page)

## Assertion testing

- the page source should (or not) contain text(s) "text or data table texts" : check that single (or multiple) text(s) found in page source (inverted if "should not")
- the page source should match pattern(s) "pattern or data table patterns": check that one (or multiple) pattern(s) match the page source
- the page title should be "<expected title>": the page title have to be equal to expected title
- I should (or not) be logged to nextprot: check user is logged in nextprot (negative and positive assertion).

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

# Useful links

- [gherkin](https://cucumber.io/docs/reference)
- [atom](https://atom.io)