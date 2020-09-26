package com.ebc.pageObects;

import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage extends TopNavigationBar {

    public CartPage(WebDriver driver, Scenario scenario) {

        super(driver, scenario);
    }

    private List<WebElement> getOrderDetailElements() {
        return findElements(By.cssSelector(
                ".custom-order-txt>p, .order_details p"));
    }

    private WebElement getCuponCodeField() {
        return findElement(By.id("coupon_code"));
    }


    public void verifyTheOrderInCartPage(String messageType, String recipientName, String shoutOutNames) {
        //Have to avoid the hard coded later
        String[] messageTypeInCartPage = getOrderDetailElements().get(0).getText().split(":");
        String[] recipientNameInCartPage = getOrderDetailElements().get(1).getText().split(":");
        String shoutOutNamesInCartPage = getOrderDetailElements().get(2)
                .getText().trim().replace(" ", "");
        Assert.assertEquals(messageTypeInCartPage[messageTypeInCartPage.length - 1].trim(), messageType);
        Assert.assertEquals(recipientNameInCartPage[recipientNameInCartPage.length - 1].trim(), recipientName);
        Assert.assertEquals(shoutOutNamesInCartPage, shoutOutNames);
    }

    public void applyCuponCode(String cuponCode) {
        fillTextField(getCuponCodeField(), cuponCode);
        clickButton("Apply coupon");
        getScenario().log("Applied the cupon code");
    }
}
