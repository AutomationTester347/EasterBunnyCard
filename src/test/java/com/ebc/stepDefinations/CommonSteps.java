package com.ebc.stepDefinations;

import com.ebc.context.TestBase;
import com.ebc.context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


public class CommonSteps extends TestBase {
    TestContext testContext;
    Scenario scenario;

    public CommonSteps(TestContext testContext) {
        this.testContext = testContext;
        this.scenario = testContext.getScenario();
    }

    @Given("{string} page is presented")
    public void pageIsPresented(String pageName, DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        String pageTitle = table.get(0).get("Page Title");
        String firstHeader = table.get(0).get("First Header");

        testContext.getHomepage().verifyThePresenceOfThePage(pageTitle, firstHeader);
    }

    @Given("I navigate to Home page")
    public void iNavigateToHomePage() {
        testContext.initializePageObjectClasses();
        testContext.getHomepage().navigateToHomePage(config.getConfigEnvironement().getUrl());
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

    @And("I click on the {string} button")
    public void iClickOnTheButton(String buttonName) {
        testContext.getHomepage().clickButton(buttonName);
        testContext.getHomepage().waitForTheSpinnerToBeInvisible();
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
        testContext.setuserName(username);
    }

    @And("I Click on the {string} link from top header")
    public void iClickOnTheLinkFromTopHeader(String arg0) {
        testContext.getTopNavigationBar().clickOnloginButton();
    }
}
