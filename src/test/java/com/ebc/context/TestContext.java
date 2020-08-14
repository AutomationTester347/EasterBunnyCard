package com.ebc.context;

import com.ebc.pageObects.Homepage;
import com.ebc.pageObects.TopNavigationBar;
import com.ebc.pageObects.myAccount.guestUser.LoginPage;
import com.ebc.pageObects.myAccount.registeredUser.DashboardPage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class TestContext {

    public WebDriver driver;
    public Scenario scenario;
    private String userName;
    private TopNavigationBar topNavigationBar;
    private Homepage homepage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public TopNavigationBar getTopNavigationBar() {
        return topNavigationBar;
    }

    public Homepage getHomepage() {
        return homepage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        return dashboardPage;
    }

    public String getUserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public void initializePageObjectClasses() {
        topNavigationBar = new TopNavigationBar(driver, scenario);
        homepage = new Homepage(driver, scenario);
        loginPage = new LoginPage(driver, scenario);
        dashboardPage = new DashboardPage(driver, scenario);
    }
}
