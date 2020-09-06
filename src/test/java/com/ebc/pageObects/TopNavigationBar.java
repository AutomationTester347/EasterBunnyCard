package com.ebc.pageObects;

import com.ebc.utils.Interact;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopNavigationBar extends Interact {
    public Scenario scenario;

    private By loginButton = By.cssSelector(".top-nav-item .login-in");
    private By viewCartButton = By.cssSelector(".top-nav-item .et-cart-info");
    private By logOutButton = By.cssSelector(".top-nav-item >ul>li:last-child");
    //private By orderNowButton = By.xpath()

    public TopNavigationBar(WebDriver driver, Scenario scenario) {
        setDriver(driver);
        setScenario(scenario);
        this.scenario = scenario;
    }

    public void clickOnloginButton() {
        clickElement(loginButton);
        scenario.log("clicked login Button");
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getViewCartButton() {
        return viewCartButton;
    }

    public By getLogOutButton() {
        return logOutButton;
    }
}
