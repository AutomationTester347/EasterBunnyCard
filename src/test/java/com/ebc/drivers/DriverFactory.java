package com.ebc.drivers;

import com.ebc.configurations.Config;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver createDriver(String browserName) throws IOException, URISyntaxException {
        if (driver == null) {
            return new DriverFactory().create(Config.getInstance());
        } else
            return driver;
    }

    private WebDriver create(Config config) throws MalformedURLException {

        String browserName = config.getConfigDriver().getBrowser();
        MutableCapabilities driverOptions;

        if (config.getConfigDriver().isRemote()) {
            switch (browserName) {
                case "Firefox":
                    driverOptions = new FirefoxOptions();
                    break;

                case "Chrome":
                    //If a string isn't matched, it will default to ChromeDriver
                default:
                    driverOptions = new ChromeOptions();
            }

            driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), driverOptions);

        } else {

            switch (browserName) {
                case "Firefox":
                    driver = new FirefoxDriver();
                    break;

                case "Chrome":
                    //If a string isn't matched, it will default to ChromeDriver
                default:
                    driver = new ChromeDriver();
            }
        }

        //Return the driver instance to the calling class.
        return driver;
    }
}
