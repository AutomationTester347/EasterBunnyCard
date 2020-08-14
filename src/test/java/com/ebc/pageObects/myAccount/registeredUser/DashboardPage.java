package com.ebc.pageObects.myAccount.registeredUser;

import com.ebc.pageObects.myAccount.MyAccountPage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends MyAccountPage {

    private By userName = By.cssSelector("div[class$=MyAccount-content] p>strong:first-child");

    public DashboardPage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }

    public void verifyThePresenceOfDashboardPage() {
        String expectedButtonName = "Log Out";
        String actualButtonName = getText(getLogOutButton()).trim();

        scenario.log("Navigated to Dashboard page");

        verifyThePresenceOfMyAccountPage();

        Assert.assertTrue(actualButtonName.equalsIgnoreCase(expectedButtonName),
                "Login button name mismatch, " +
                        "Expected: " + expectedButtonName + " Actual: " + actualButtonName);

        scenario.log("Verified the presence of Logout button");
    }

    public String getUserNameText() {
        return getText(userName).trim();
    }
}
