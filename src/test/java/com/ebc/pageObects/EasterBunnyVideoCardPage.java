package com.ebc.pageObects;

import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class EasterBunnyVideoCardPage extends TopNavigationBar {

    private String messageType;
    private String recipientName;
    private String shoutOutNames;

    public EasterBunnyVideoCardPage(WebDriver driver, Scenario scenario) {

        super(driver, scenario);
    }

    private WebElement getRecipientNameField() {
        return findElement(By.id("bunny_recipients"));
    }

    private WebElement getShoutOutNameField() {
        return findElement(By.cssSelector(".rel-names [role=combobox] input"));
    }

    private WebElement getShoutOutNameList() {
        return findElement(By.id("select2-bunny_relation-results"));
    }

    private WebElement getSelectedShoutoutNames() {
        return findElement(By.cssSelector(".rel-names>input"));
    }

    private WebElement messageTypeRadioButton(String messageType) {
        return findElement(By.xpath("//div[label='" + messageType + "']/input"));
    }

    public void selectMessageType(String messageType) {
        clickElement(messageTypeRadioButton(messageType));
        this.messageType = messageType;
        getScenario().log("Selected the " + messageType + " message type");
    }

    public void selectRecipientName(String recipientName) {
        selectFromDropdown(getRecipientNameField(), recipientName);
        this.recipientName = recipientName;
    }

    public void selectShoutoutNames(String shoutOutNames) {
        String[] names = shoutOutNames.split(",");
        for (String name : names
        ) {
            String shoutOutName = name.trim();
            selectFromMultiSelectComboBox(getShoutOutNameField(), shoutOutName);
            getScenario().log("Selected shout out name: " + shoutOutName);
        }
        this.shoutOutNames = getSelectedShoutoutNames()
                .getAttribute("value").trim().replace(" ", "");
    }

    public String getMessageType() {
        return messageType;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getShoutOutNames() {
        return shoutOutNames;
    }

    public void fillupCustomOrderForm(List<Map<String, String>> table) throws Exception {
        for (int i = 0; i < table.size(); i++) {
            Map<String, String> row = table.get(i);
            String fieldName = row.get("Field Name");
            String fieldValue = row.get("Value");
            switch (fieldName) {
                case "Message Type":
                    selectMessageType(fieldValue);
                    break;
                case "Recipient Name":
                    selectRecipientName(fieldValue);
                    break;
                case "Shout Outs":
                    selectShoutoutNames(fieldValue);
                    break;
                default:
                    throw new Exception(fieldName + "field not found in custom order form");
            }

        }
    }
}
