package com.ebc.pageObects;

import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends TopNavigationBar {

    By cookieBar = By.cssSelector("div#cookie-law-info-bar");

    public Homepage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }

    public void navigateToHomePage(String url) {
        navigateToPage(url);
        getScenario().log("Navigated to home page");
    }

    public void verifyThePresenceOfThePage(String pageTitle, String firstHeader) {
        WaitForPageLoad();
        waitForTheSpinnerToBeInvisible();

        if (isElementVisibleAfterWait(cookieBar, 2)) {
            clickElement(findElement(By.cssSelector(".cookie_action_close_header")));
        }

        verifyThePage(pageTitle, firstHeader);
    }

}
