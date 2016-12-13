# neXtProt step definitions conventions

Here are a few already defined step definitions that should be reuse anywhere it is indicated:

## Url navigation

    I navigate to url "http://.."
  Navigating to url defined in quoted value 
  
    I navigate to nextprot url "{np-page}/path" 
  Navigating to nextprot url defined in alias (with curly brackets) defined in `features.properties`
  
    I navigate to relative url "/path"
  Navigating to url from current url location to given path

## Page interaction

    I click on link text "link_name"
  Clicking on a link by name (ex: `Login`)
   
    I click on link id "#link_id"
  Clicking on a link by id (ex: `#copyright` in nextprot-api page)

## Assertion testing

    the page source should (not) contain (ignored case) text(s) "text or data table texts"
  Check text(s) existence (or not<sup>1</sup>) in page source<sup>2</sup> in sensitive or insensitive case mode
 
    the page source should (not) match pattern(s) "pattern or data table patterns"
  Check that pattern(s) match (or not) the page source
 
    the page title should be "<expected title>"
  Check the page title have to be equal to expected title
  
    I should (not) be logged to nextprot
  Check if user is logged (or not) in nextprot.

### Notes:
  1. Optional text, put in parenthesis, change the meaning of the step definition
  2. Page source is composed of main page source plus all potential embedded pages (such as iframe)
