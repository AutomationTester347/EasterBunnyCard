package com.ebc.stepDefinations;

import com.ebc.context.TestContext;
import com.ebc.pageObects.EasterBunnyVideoCardPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class EasterBunnyVideoCardSteps {

    TestContext testContext;
    Scenario scenario;
    EasterBunnyVideoCardPage easterBunnyVideoCardPage;

    public EasterBunnyVideoCardSteps(TestContext testContext) {
        this.testContext = testContext;
        this.scenario = testContext.getScenario();
        this.easterBunnyVideoCardPage = testContext.getEasterBunnyVideoCardPage();
    }

    @Then("I remove the order")
    public void iRemoveTheOrder() {
    }

    @And("I confirm that order has been removed from the cart")
    public void iConfirmThatOrderHasBeenRemovedFromTheCart() {
    }

    @When("I fill custom order form with the following information")
    public void iFillCustomOrderFormWithTheFollowingInformation(DataTable dataTable) throws Exception {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        easterBunnyVideoCardPage.fillupCustomOrderForm(table);
    }
}
