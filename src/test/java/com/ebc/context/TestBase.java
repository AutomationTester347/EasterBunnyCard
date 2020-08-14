package com.ebc.context;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TestBase {
    protected String browser = LoadProperties().getProperty("browser");
    protected String baseUrl = LoadProperties().getProperty("baseUrl");
    protected String password = LoadProperties().getProperty("password");
    protected int timeOutSec = Integer.parseInt(LoadProperties().getProperty("timeOutSec"));

    public Properties LoadProperties() {

        try {
            InputStream inStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            Properties prop = new Properties();
            prop.load(inStream);
            return prop;
        } catch (Exception e) {
            System.out.println("File not found exception thrown for config.properties file.");
            return null;
        }

    }

    public String getRandomString(){
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        return simpleDateFormat.format(currentDate);
    }
}
