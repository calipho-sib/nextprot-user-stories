package org.nextprot.stepdefs;

import cucumber.api.java.en.And;
import org.nextprot.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.nextprot.StepUtils.valueOfShouldBeStatus;

public class NextprotLoginSteps {

    @And("^I \"([^\"]*)\" be logged$")
    public void iAmLogged(String shouldStatus) throws Throwable {

        boolean shouldBeLogged = valueOfShouldBeStatus(shouldStatus);

        String script = "return angular.element('[ng-controller=SearchCtrl]').scope().user.profile.username";

        new WebDriverWait(WebDriverManager.getDriver(), 30).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver d) {

                if (d instanceof JavascriptExecutor) {

                    String res = (String) ((JavascriptExecutor) d).executeScript(script);

                    boolean isLogged = res != null && !"Guest".equals(res);

                    return shouldBeLogged == isLogged;
                }

                return false;
            }
        });
    }

    @And("^I click on googleplus button$")
    public void iLogWithGoogle() throws Throwable {

        WebDriverManager.getDriver().findElement(By.className("a0-googleplus")).click();
    }
}
