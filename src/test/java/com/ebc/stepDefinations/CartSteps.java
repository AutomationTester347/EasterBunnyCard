package com.ebc.stepDefinations;

import com.ebc.context.TestContext;
import com.ebc.pageObects.CartPage;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;

public class CartSteps {
    TestContext testContext;
    Scenario scenario;
    CartPage cartPage;

    public CartSteps(TestContext testContext) {
        this.testContext = testContext;
        this.scenario = testContext.getScenario();
        this.cartPage = testContext.getCartPage();
    }

    @And("I apply this cupon code {string}")
    public void iApplyThisCuponCode(String cuponCode) {
        cartPage.applyCuponCode(cuponCode);
    }

    @And("I confirm the presence of order")
    public void iConfirmThePresenceOfOrderInPage() {
        cartPage.verifyTheOrderInCartPage(testContext.getEasterBunnyVideoCardPage().getMessageType()
                , testContext.getEasterBunnyVideoCardPage().getRecipientName()
                , testContext.getEasterBunnyVideoCardPage().getShoutOutNames());
    }
}
