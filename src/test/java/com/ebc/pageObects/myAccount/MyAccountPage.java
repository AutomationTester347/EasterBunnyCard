package com.ebc.pageObects.myAccount;

import com.ebc.pageObects.TopNavigationBar;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPage extends TopNavigationBar {

    public MyAccountPage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }

}
