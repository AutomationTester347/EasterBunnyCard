package com.ebc.stepDefinations;

import com.ebc.context.TestContext;
import com.ebc.pageObects.CartPage;
import com.ebc.pageObects.CheckoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {
    TestContext testContext;
    Scenario scenario;
    CheckoutPage checkoutPage;

    public CheckoutSteps(TestContext testContext) {
        this.testContext = testContext;
        this.scenario = testContext.getScenario();
        this.checkoutPage = testContext.getCheckoutPage();
    }

    @And("I confirm the presence of order in checkout page")
    public void iConfirmThePresenceOfOrderInCheckoutPage() {

    }

    @And("I fill the billing address with the following details")
    public void iFilledTheBillingAddressWithTheFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        checkoutPage.fillTheBillingDetailsForm(table);

    }

    @And("I agree with the website terms and conditions")
    public void iAgreeWithTheWebsiteTermsAndConditions() {
        checkoutPage.selectTheCheckboxOfTermsAndConditions();
    }

    @Then("I verify that the order confirmation message is {string}")
    public void iVerifyThatTheOrderConfirmationMessageIs(String message) {
        checkoutPage.verifyTheOrderConfirmationMessage(message);
    }
}
