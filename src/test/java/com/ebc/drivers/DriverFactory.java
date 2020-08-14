package com.ebc.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver createDriver(String browserName) {
        if (driver == null) {
            return new DriverFactory().create(browserName);
        } else
            return driver;
    }

    private WebDriver create(String browserName) {
        //A simple switch statement to determine which driver/service to create.

        switch (browserName) {
            case "Firefox":
                driver = new FirefoxDriver();
                break;

            case "Chrome":
                //If a string isn't matched, it will default to ChromeDriver
            default:
                //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }

        //Return the driver instance to the calling class.
        return driver;
    }
}
