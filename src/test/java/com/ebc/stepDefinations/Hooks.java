package com.ebc.stepDefinations;

import com.ebc.configurations.Driver;
import com.ebc.context.TestBase;
import com.ebc.context.TestContext;
import com.ebc.drivers.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class Hooks extends TestBase {
    TestContext testContext;
    WebDriver driver;

    public Hooks(TestContext testContext) {

        this.testContext = testContext;
    }

    @Before
    public void beforeTest(Scenario scenario) throws IOException, URISyntaxException {
        testContext.setScenario(scenario);
        if (driver == null) {
            createDrive();
        }

    }

    @After
    public void afterTest() {
        Scenario scenario = testContext.getScenario();
        if (scenario.isFailed()) {
            TakesScreenshot shot = (TakesScreenshot) driver;
            byte[] data = shot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName().replace(" ", "_"));
        }

        driver.quit();
    }

    @BeforeStep
    public void beforeStep() {

    }

    @AfterStep
    public void afterStep() {

    }

    public void createDrive() throws IOException, URISyntaxException {
        Driver getDriver = config.getConfigDriver();
        driver = new DriverFactory().createDriver(getDriver.getBrowser());
        driver.manage().timeouts().pageLoadTimeout(getDriver.getTimeOutSecs(), TimeUnit.SECONDS);
        driver.manage().window().maximize();

        testContext.setDriver(driver);
    }


}
