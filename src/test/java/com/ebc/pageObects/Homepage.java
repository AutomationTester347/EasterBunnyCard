package com.ebc.pageObects;

import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends TopNavigationBar {

    private final String HOME_PAGE_TITLE = "Home - Easter Bunny Card";
    private final String HOME_PAGE_HEADER_TEXT = "Personal Easter Greetings with Mr Bunny video messages!";

    private By homePageHeaderElement = By.cssSelector("h2[class$=module_header]");

    public Homepage(WebDriver driver, Scenario scenario) {
        super(driver, scenario);
    }

    public void navigateToHomePage(String url) {
        navigateToPage(url);
        scenario.log("Navigated to home page");
        verifyThePresenceOfHomePage();
    }

    public void verifyThePresenceOfHomePage() {
        verifyThePage(HOME_PAGE_TITLE, homePageHeaderElement, HOME_PAGE_HEADER_TEXT);
    }

}
