package com.ebc.pageObects;

import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CheckoutPage extends TopNavigationBar {

    public CheckoutPage(WebDriver driver, Scenario scenario) {

        super(driver, scenario);
    }

    private WebElement getCountryList() {
        return findElement(By.cssSelector("[id$='billing_country-results']"));
    }

    private WebElement getCountryTextField() {
        return findElement(By.cssSelector("input[aria-owns$='billing_country-results']"));
    }

    private WebElement getTermsAndConditionsCheckbox() {
        return findElement(By.cssSelector("input#terms"));
    }

    private WebElement getBillingDetailsField(String fieldName) {
        return findElement(By.xpath(
                "//div[@id='customer_details']//label[starts-with(text(), '" + fieldName + "')]/parent::p/span/*[not(@aria-hidden)]"));
    }

    public void fillTheBillingDetailsForm(List<Map<String, String>> table) {
        for (int i = 0; i < table.size(); i++) {
            Map<String, String> row = table.get(i);
            String fieldName = row.get("Field Name");
            String fieldValue = row.get("Value");
            WebElement fieldElement = getBillingDetailsField(fieldName);

            switch (fieldName) {
                case "Country / Region":
                case "State":
                    WebElement field = fieldElement.findElement(By.xpath(".//span[@role='textbox']"));
                    slectFromComboBox(field, fieldValue);
                    break;
                default:
                    fillTextField(fieldElement, fieldValue);
            }
        }
    }

    public void selectTheCheckboxOfTermsAndConditions() {
        clickElement(getTermsAndConditionsCheckbox());
    }

    public void verifyTheOrderConfirmationMessage(String message) {
        Assert.assertTrue(validateElementIsDisplayed(findElement(By.xpath("//p[text()='" + message + "']"))));

        String orderNumber = getText(findElement(By.cssSelector(".order>strong")));
        getScenario().log("Order Number is: " + orderNumber);
    }
}
