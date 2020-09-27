package com.ebc.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.List;

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

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public WebElement findElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    private void applyJsOnElement(WebElement element, String js) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("(function (e) {" + js + "})(arguments[0])", element);
    }

    public WebElement clickElement(WebElement element) {
        element.click();
        return element;
    }

    public void applyActionClick(WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).click().perform();
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void verifyThePageTitle(String expectedPageTitle) {
        String pageTitle = getPageTitle();
        scenario.log("Got the page title, which is \"" + pageTitle + "\"");
        Assert.assertEquals(pageTitle, expectedPageTitle);
        scenario.log("Verified the page title");
    }

    public void verifyThePage(String expectedPageTitle, String expectedFirstHeader) {
        verifyThePageTitle(expectedPageTitle);
        validateElementIsDisplayed(findElement(By.xpath("//*[text()='" + expectedFirstHeader + "']")));
        scenario.log("Verified the first header of the page");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public void fillTextField(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void applyActionSendKeys(WebElement element, String value) {
        Actions act = new Actions(driver);
        act.moveToElement(element).click().sendKeys(value).perform();
    }

    public void scrollToElement(WebElement element) {
        applyJsOnElement(element, "e.scrollIntoView(true)");
    }

    public Boolean validateElementIsDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void selectFromDropdown(WebElement dropdownField, String value) {
        Select dropdown = new Select(dropdownField);
        dropdown.selectByVisibleText(value);
    }

    public void slectFromComboBox(WebElement comboBoxField, String value) {
        clickElement(comboBoxField);
        String id = comboBoxField.findElement(By.xpath("./.."))
                .getAttribute("aria-activedescendant");

        WebElement textField = findElement(
                By.cssSelector("input[aria-activedescendant='" + id + "']"));
        fillTextField(textField, value);

        id = comboBoxField.findElement(By.xpath("./.."))
                .getAttribute("aria-activedescendant");

        clickElement(findElement(By.cssSelector("li[id='" + id + "']")));
    }

    public void selectFromMultiSelectComboBox(WebElement comboBoxField, String value) {
        String attribute = "aria-activedescendant";
        clickElement(comboBoxField);

        if (!isAttributePresenceInElement(comboBoxField, attribute)) {
            clickElement(comboBoxField);
        }

        fillTextField(comboBoxField, value);
        String id = comboBoxField.getAttribute(attribute);
        clickElement(findElement(By.cssSelector("li[id='" + id + "']")));
    }

    public void clickButton(String buttonName) {
        clickElement(findElement(
                By.xpath(
                        "//*[contains(@class, 'button') and contains(text(),'" + buttonName + "')]")));
    }

    public Boolean isElementVisibleAfterWait(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException timeoutException) {
            return false;
        }
    }

    public Boolean isAttributePresenceInElement(WebElement element, String attribute) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    public void waitForTheSpinnerToBeInvisible() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".blockUI.blockElement"));

        if (elements.size() != 0) {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
        }
    }

    public void WaitForPageLoad() {
        var wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
    }

    public byte[] takeScreenShot() {
        TakesScreenshot shot = (TakesScreenshot) driver;
//        logger.info("Screen Shot taken for full driver. ");
        return shot.getScreenshotAs(OutputType.BYTES);
    }

    public byte[] takeScreenShot(By by) {
        TakesScreenshot shot = (TakesScreenshot) driver.findElement(by);
//        logger.info("Screen Shot taken for element: " + by.toString() );
        return shot.getScreenshotAs(OutputType.BYTES);
    }

    public File takeScreenShotAsFile() {
        TakesScreenshot shot = (TakesScreenshot) driver;
//        logger.info("Screen Shot taken for full driver and returned as a file.");
        return shot.getScreenshotAs(OutputType.FILE);
    }

    public File takeScreenShotAsFile(By by) {
        TakesScreenshot shot = (TakesScreenshot) driver.findElement(by);
//        logger.info("Screen Shot taken for element and returned as a file. By descp: " + by.toString());
        return shot.getScreenshotAs(OutputType.FILE);
    }

    public void takeScreenShotAndAttachInReport() {
        scenario.attach(takeScreenShot(), "image/png", scenario.getName().replace(" ", "_"));
    }
}
