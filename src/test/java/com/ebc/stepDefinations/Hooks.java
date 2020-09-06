package com.ebc.stepDefinations;

import com.ebc.configurations.Driver;
import com.ebc.context.TestBase;
import com.ebc.context.TestContext;
import com.ebc.drivers.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks extends TestBase {
    TestContext testContext;
    WebDriver driver;

    public Hooks(TestContext testContext) {

        this.testContext = testContext;
    }

    @Before
    public void beforeTest(Scenario scenario) throws IOException {
        testContext.setScenario(scenario);
        if (driver == null) {
            createDrive();
        }


    }

    @After
    public void afterTest() {
        if (testContext.getScenario().isFailed()) {
            testContext.getHomepage().takeScreenShotAndAttachInReport();
        }

        driver.quit();
    }

    @BeforeStep
    public void beforeStep() {

    }

    @AfterStep
    public void afterStep() {

    }

    public void createDrive() throws IOException {
        Driver getDriver = config.getConfigDriver();
        driver = new DriverFactory().createDriver(getDriver.getBrowser());
        driver.manage().timeouts().pageLoadTimeout(getDriver.getTimeOutSecs(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(getDriver.getTimeOutSecs(), TimeUnit.SECONDS);
        driver.manage().window().maximize();

        testContext.setDriver(driver);
    }


}
