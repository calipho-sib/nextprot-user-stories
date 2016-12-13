# Gherkin, the `user story` language

Cucumber is an awesome tool that can help us create living documentation. It is a great way to gain a better understanding of how it should function.

It utilizes Gherkin – a language that is at the core of Cucumber’s ability to both document and automate tests. It allows for writing tests around how a feature should behave – a process known as Behaviour Driven Development.

We will gain a better understanding of what is being tested and how a feature should function – something that is along the same lines as writing user stories.

# Gherkin language in a nutshell

Gherkin is a declarative language - you write your code in such a way that it describes what you want to do.

Each `feature` is defined as a bunch of `scenarios` or `user-stories`.

A scenario focuses on 3 kind of step definitions:

1. `Given`... an established condition
2. `When` ... an action
3. `Then` ... an expected result

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

# Useful links

- [gherkin](https://cucumber.io/docs/reference)
