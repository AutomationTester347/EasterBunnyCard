package com.ebc.pageObects;

import com.ebc.utils.Interact;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopNavigationBar extends Interact {

    public TopNavigationBar(WebDriver driver, Scenario scenario) {
        setDriver(driver);
        setScenario(scenario);
    }

    private WebElement getLoginButton() {
        return findElement(By.cssSelector(".top-nav-item .login-in"));
    }

    private WebElement getViewCartButton() {
        return findElement(By.cssSelector(".top-nav-item .et-cart-info"));
    }

    public WebElement getLogOutButton() {
        return findElement(By.cssSelector(".top-nav-item >ul>li:last-child"));
    }

    private WebElement getOrderNowButton() {
        return findElement(By.xpath("//ul[@id='top-menu']//span[text()='Order Now']"));
    }

    public void clickOnloginButton() {
        clickElement(getLoginButton());
        getScenario().log("clicked login Button");
    }

    public void clickOnOrderNowButton() {
        clickElement(getOrderNowButton());
        getScenario().log("clicked orderNow button");
    }
}
