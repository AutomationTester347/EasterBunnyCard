package com.ebc.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = "com/ebc/stepDefinations",
        monochrome = true,
        plugin = {
                "json:target/cucumber-report/cucumber.json"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
