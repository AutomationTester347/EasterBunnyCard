package com.ebc.pageObects.myAccount.guestUser;

import com.ebc.pageObects.myAccount.MyAccountPage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends MyAccountPage {

    private By registerUsername = By.id("reg_username");
    private By registerEmail = By.id("reg_email");
    private By registerPassword = By.id("reg_password");
    private By registerButton = By.name("register");
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private  By loginButton = By.name("login");

    public LoginPage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }

    public void verifyThePresenceOfLoginPage() {
        String expectedButtonName = "Log In";
        String actualButtonName = getText(getLoginButton()).trim();
        scenario.log("Navigated to Login page");
        verifyThePresenceOfMyAccountPage();
        Assert.assertTrue(actualButtonName.equalsIgnoreCase(expectedButtonName),
                "Login button name mismatch, " +
                        "Expected: " + expectedButtonName + "Actual: " + actualButtonName);
        scenario.log("Verified the presence of Login button");
    }

    public void fillupRegistrationForm(String username, String email, String password) {
        fillTextField(registerUsername, username);
        scenario.log("Value entered in username field: " + username);

        fillTextField(registerEmail, email);
        scenario.log("Value entered in email field: " + email);

        fillTextField(registerPassword, password);
        scenario.log("Value entered in password field: " + password);
    }

    public void clickRegisterButton() {
        clickElement(registerButton);
        scenario.log("Clicked register button");
    }

    public void fillupLoginForm(String username,String password){
        fillTextField(usernameField, username);
        scenario.log("Value entered in username field: " + username);

        fillTextField(passwordField, password);
        scenario.log("Value entered in password field: " + password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
        scenario.log("Clicked login button");
    }
}
