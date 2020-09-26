package com.ebc.stepDefinations;

import com.ebc.context.TestContext;
import com.ebc.pageObects.TopNavigationBar;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;

public class TopNavigationBarSteps {
    TestContext testContext;
    Scenario scenario;
    TopNavigationBar topNavigationBar;

    public TopNavigationBarSteps(TestContext testContext) {
        this.testContext = testContext;
        this.scenario = testContext.getScenario();
        this.topNavigationBar = testContext.getTopNavigationBar();
    }

    @And("I Click on the {string} from top navigation bar")
    public void iClickOnTheFromTopNavigationBar(String menuItemName) {
        topNavigationBar.clickOnOrderNowButton();
    }
}
