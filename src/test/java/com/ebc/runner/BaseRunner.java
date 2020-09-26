package com.ebc.runner;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

public class BaseRunner {
        private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

        public static TestNGCucumberRunner getRunner(){
            return testNGCucumberRunner.get();
        }

        private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1){
            testNGCucumberRunner.set(testNGCucumberRunner1);
        }

//        @Parameters({"platformName", "udid", "deviceName", "systemPort",
//                "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort"})
        @BeforeClass(alwaysRun = true)
        public void setUpClass(/*String platformName, String udid, String deviceName, @Optional("Android") String systemPort,
                               @Optional("Android") String chromeDriverPort,
                               @Optional("iOS") String wdaLocalPort,
                               @Optional("iOS") String webkitDebugProxyPort*/) throws Exception {

//            ThreadContext.put("ROUTINGKEY", platformName + "_" + deviceName);
//
//            GlobalParams params = new GlobalParams();
//            params.setPlatformName(platformName);
//            params.setUDID(udid);
//            params.setDeviceName(deviceName);
//
//            switch(platformName){
//                case "Android":
//                    params.setSystemPort(systemPort);
//                    params.setChromeDriverPort(chromeDriverPort);
//                    break;
//                case "iOS":
//                    params.setWdaLocalPort(wdaLocalPort);
//                    params.setWebkitDebugProxyPort(webkitDebugProxyPort);
//                    break;
//            }

//            new ServerManager().startServer();
//            new DriverManager().initializeDriver();

            setRunner(new TestNGCucumberRunner(this.getClass()));
        }

        @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
        public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
            getRunner().runScenario(pickle.getPickle());
        }

        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return getRunner().provideScenarios();
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() {
            if(testNGCucumberRunner != null){
                getRunner().finish();
            }
        }
    }
