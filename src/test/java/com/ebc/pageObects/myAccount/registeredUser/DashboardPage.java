package com.ebc.pageObects.myAccount.registeredUser;

import com.ebc.pageObects.myAccount.MyAccountPage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DashboardPage extends MyAccountPage {

    public DashboardPage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }

    private WebElement getUserName(){return findElement(By.cssSelector("div[class$=MyAccount-content] p>strong:first-child"));}

    public void verifyThePresenceOfDashboardPage() {
        String expectedButtonName = "Log Out";
        String actualButtonName = getText(getLogOutButton()).trim();

        getScenario().log("Navigated to Dashboard page");

        Assert.assertTrue(actualButtonName.equalsIgnoreCase(expectedButtonName),
                "Login button name mismatch, " +
                        "Expected: " + expectedButtonName + " Actual: " + actualButtonName);

        getScenario().log("Verified the presence of Logout button");
    }

    public String getUserNameText() {
        return getText(getUserName()).trim();
    }
}
