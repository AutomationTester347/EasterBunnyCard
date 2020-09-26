package com.ebc.pageObects.myAccount.guestUser;

import com.ebc.pageObects.myAccount.MyAccountPage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends MyAccountPage {

    public LoginPage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }

    private WebElement getRegisterUsername() {
        return findElement(By.id("reg_username"));
    }

    private WebElement getRegisterEmail() {
        return findElement(By.id("reg_email"));
    }

    private WebElement getRegisterPassword() {
        return findElement(By.id("reg_password"));
    }

    private WebElement getRegisterButton() {
        return findElement(By.name("register"));
    }

    private WebElement getUsernameField() {
        return findElement(By.id("username"));
    }

    private WebElement getPasswordField() {
        return findElement(By.id("password"));
    }

    public void fillupRegistrationForm(String username, String email, String password) {
        fillTextField(getRegisterUsername(), username);
        getScenario().log("Value entered in username field: " + username);

        fillTextField(getRegisterEmail(), email);
        getScenario().log("Value entered in email field: " + email);

        fillTextField(getRegisterPassword(), password);
        getScenario().log("Value entered in password field: " + password);
    }

    public void clickRegisterButton() {
        clickElement(getRegisterButton());
        getScenario().log("Clicked register button");
    }

    public void fillupLoginForm(String username, String password) {
        fillTextField(getUsernameField(), username);
        getScenario().log("Value entered in username field: " + username);

        fillTextField(getPasswordField(), password);
        getScenario().log("Value entered in password field: " + password);
    }
}
