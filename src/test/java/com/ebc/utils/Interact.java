package com.ebc.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;

public class Interact {
    private WebDriver driver;
    private Scenario scenario;
    Class interact = Interact.class;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public WebElement clickElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
        return element;
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void verifyThePage(String expectedPageTitle, By firstHeaderElement, String expectedFirstHeaderText){

        String pageTitle = getPageTitle();
        scenario.log("Got the page title, which is \"" + pageTitle + "\"");
        Assert.assertEquals(pageTitle, expectedPageTitle);
        scenario.log("Verified the page title");

        String firstHeaderText = getText(firstHeaderElement).trim();
        scenario.log("Got the text from first header and the text is \""
                + firstHeaderText + "\"");
        Assert.assertEquals(firstHeaderText, expectedFirstHeaderText);
        scenario.log("Verified the first header of the page");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public void fillTextField(By by, String value){
        driver.findElement(by).sendKeys(value);
    }

    public byte[] takeScreenShot() {
        TakesScreenshot shot = (TakesScreenshot)driver;
//        logger.info("Screen Shot taken for full driver. ");
        return shot.getScreenshotAs(OutputType.BYTES);
    }

    public byte[] takeScreenShot(By by) {
        TakesScreenshot shot = (TakesScreenshot)driver.findElement(by);
//        logger.info("Screen Shot taken for element: " + by.toString() );
        return shot.getScreenshotAs(OutputType.BYTES);
    }

    public File takeScreenShotAsFile() {
        TakesScreenshot shot = (TakesScreenshot)driver;
//        logger.info("Screen Shot taken for full driver and returned as a file.");
        return shot.getScreenshotAs(OutputType.FILE);
    }

    public File takeScreenShotAsFile(By by) {
        TakesScreenshot shot = (TakesScreenshot)driver.findElement(by);
//        logger.info("Screen Shot taken for element and returned as a file. By descp: " + by.toString());
        return shot.getScreenshotAs(OutputType.FILE);
    }

    public void takeScreenShotAndAttachInReport() {
        scenario.attach(takeScreenShot(), "image/png", scenario.getName().replace(" ", "_"));
    }
}
