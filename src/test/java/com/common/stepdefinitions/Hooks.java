package com.common.stepdefinitions;


import com.common.core.DriverInitializer;
import com.common.pages.LoginPage;
import io.cucumber.java.Before;

public class Hooks {
    private static DriverInitializer driverInit;
    private static LoginPage loginPage;

    @Before("@UI")
    public void setUpUi() {
        driverInit = new DriverInitializer();
        loginPage = new LoginPage(driverInit.getDriver());

    }
}
