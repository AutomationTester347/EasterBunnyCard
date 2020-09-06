package com.ebc.configurations;

public class RootObject {

    private String EBCTargetEnvironment;
    private TargetEnvironment[] TargetEnvironments;
    private Driver Driver;
    private EbcUser[] Users;

    public String getEBCTargetEnvironment() {
        return EBCTargetEnvironment;
    }

    public void setEBCTargetEnvironment(String eBCTargetEnvironment) {
        EBCTargetEnvironment = eBCTargetEnvironment;
    }

    public TargetEnvironment[] getTargetEnvironments() {
        return TargetEnvironments;
    }

    public void setTargetEnvironments(TargetEnvironment[] targetEnvironments) {
        TargetEnvironments = targetEnvironments;
    }

    public Driver getDriver() {
        return Driver;
    }

    public void setDriver(Driver driver) {
        Driver = driver;
    }

    public EbcUser[] getUsers() {
        return Users;
    }

    public void setUsers(EbcUser[] users) {
        Users = users;
    }

}
