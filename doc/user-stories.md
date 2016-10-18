Cucumber is an awesome tool that can help us create living documentation. It is a great way to gain a better understanding of how it should function.

It utilizes Gherkin – a language that is at the core of Cucumber’s ability to both document and automate tests. It allows for writing tests around how a feature should behave – a process known as Behaviour Driven Development.
We will gain a better understanding of what is being tested and how a feature should function – something that is along the same lines as writing user stories.

# Gherkin, the `user story` language

Gherkin is a declarative language - you write your code in such a way that it describes what you want to do (like SQL).

Each `feature` is defined by a bunch of `scenarii` or `user-stories`.

A scenario focuses on 3 step definitions:

1. an established condition
2. an action
3. an expected result

Each step is a declaration of what the user is doing in the scenario.

Example:
```
Scenario: User navigates to profile page
Given I am on the home page
When I log in
Then I should be directed to my profile page
```

To be automatically tested by cucumber, each step definition is mapped to java code that handle execution of the step.

Thanks to its declarative language, it's not so hard for non-developers to write them.
Thus we can decouple the definition of a scenario (done by both collaborators) from the attached function (done by developers).

# Features editors

We need the help of a text editor to formalize those user-stories. Depending on the profile of the writer, there are some alternative solutions.

## for developers

Developers already uses IDE to write code (Eclipse, Intellij, ...). Most of them provides plugins for cucumber/gherkin.

## for non developers

They need a simpler, more generic editor that supports cucumber and gherkin.

This editor should provide:

1. syntax highlighting for gherkin
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

All our `feature`s are actually located in our github repository named [```nextprot-user-stories```](https://github.com/calipho-sib/nextprot-user-stories/tree/develop/src/test/resources/features)

## Download folder /features 

> I Highly recommend to get all directory features/ to profit from complete auto-completion

Open your browser to [DownGit](https://minhaskamal.github.io/DownGit/#/home) then paste the link `https://github.com/calipho-sib/nextprot-user-stories/tree/develop/src/test/resources/features`
and click on `Download`

## File `features.properties`

This file contains variables that can be referenced in step definitions.

For example the variable `search` is referenced in the following step:
```
I navigate to url of nextprot "search"
```

Here variable "search" is like an alias for url "http://dev-search.nextprot.org/".

## Development cycle and coordination between feature writers and java coders (TODO, TOTHINK)

There are a list of steps that are already mapped to java code in this repository.
They are accessible through auto-completion when writing `scenario`

When new steps are created, new handlers must be provided by a developer to execute the step with `cucumber`.

# Tutorial: create a first scenario

There is a new service `https://dev-api.nextprot.org/entry-gene-names.json` that returns the map of all neXtProt entry accessions and their associated gene names.

Create a new file "/api/playground-api.feature" and write one scenario that tests that the service returns the following entries:
```
"NX_P04156" : [ "PRNP" ]
"NX_F7VJQ1" : [ "PRNP" ]
```

Here is a template for the scenario:

```
Feature: Test API to learn cucumber

  As a end user of api.nextprot.org
  I want to make API requests
  so that I can get some data

  Scenario: Retrieve all accession numbers mapped with their gene names
    Given ...
    When ...
    Then ...
```

You should not need to declare new step in this scenario.

# Useful links

- [gherkin](https://cucumber.io/docs/reference)
- [atom](https://atom.io)