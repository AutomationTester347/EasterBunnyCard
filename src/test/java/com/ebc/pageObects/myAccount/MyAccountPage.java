package com.ebc.pageObects.myAccount;

import com.ebc.pageObects.TopNavigationBar;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPage extends TopNavigationBar {

    private final String MY_ACCOUNT_PAGE_TITLE = "My account - Easter Bunny Card";
    private final String MY_ACCOUNT_PAGE_HEADER_TEXT = "My Account.";

    private By myAccountPageHeaderElement = By.xpath("//h1[text()='My Account.']");

    public MyAccountPage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }

    public void verifyThePresenceOfMyAccountPage(){
        verifyThePage(MY_ACCOUNT_PAGE_TITLE, myAccountPageHeaderElement, MY_ACCOUNT_PAGE_HEADER_TEXT);
    }
}
