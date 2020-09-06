package com.ebc.stepDefinations;

import com.ebc.context.TestBase;
import com.ebc.context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class CommonSteps extends TestBase {
    TestContext testContext;
    Scenario scenario;

    public CommonSteps(TestContext testContext) {
        this.testContext = testContext;
        this.scenario = testContext.getScenario();
    }

    @Given("home page is presented")
    public void homePageIsPresented() {
        testContext.initializePageObjectClasses();
        testContext.getHomepage().navigateToHomePage(config.getConfigEnvironement().getUrl());
    }

    @Given("login page is presented")
    public void loginPageIsPresented() {
        testContext.getTopNavigationBar().clickOnloginButton();
        testContext.getLoginPage().verifyThePresenceOfLoginPage();
    }

    @When("user fillup the registration form with valid information")
    public void userFillupTheRegistrationFormWithValidInformation() {
        String userName = "RegUser" + getRandomString();
        String email = userName + "@ebc.com";
        testContext.getLoginPage().fillupRegistrationForm(userName, email, config.getConfigUsers()[0].getPassword());
        testContext.setuserName(userName);
    }

    @And("click on the Register button")
    public void clickOnTheRegisterButton() {
        testContext.getLoginPage().clickRegisterButton();
    }

    @Then("dashboard with username is appeared")
    public void dashboardWithUsernameIsAppeared() {
        testContext.getDashboardPage().verifyThePresenceOfDashboardPage();
        String dashBoardUserName = testContext.getDashboardPage().getUserNameText();
        String expectedUserName = testContext.getUserName();
        Assert.assertEquals(dashBoardUserName, expectedUserName);
        scenario.log("Verified userName from dashboard");

    }

    @When("I enter Username as {string} and Password as {string}")
    public void iEnterUsernameAsAndPasswordAs(String username, String password) {
        testContext.getLoginPage().fillupLoginForm(username, password);
        testContext.getLoginPage().clickRegisterButton();
        testContext.setuserName(username);
    }
}
