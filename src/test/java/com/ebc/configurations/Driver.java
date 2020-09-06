package com.ebc.configurations;

public class Driver {
    private boolean Remote;
    private String Browser;
    private String Platform;
    private int TimeOutSecs;

    public boolean isRemote() {
        return Remote;
    }

    public void setRemote(boolean remote) {
        Remote = remote;
    }

    public String getBrowser() {
        return Browser;
    }

    public void setBrowser(String browser) {
        Browser = browser;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }

    public int getTimeOutSecs() {
        return TimeOutSecs;
    }

    public void setTimeOutSecs(int timeOutSecs) {
        TimeOutSecs = timeOutSecs;
    }
}
