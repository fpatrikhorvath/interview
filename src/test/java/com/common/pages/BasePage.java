package com.framework.common.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, getDefaultWaitInSec());
        PageFactory.initElements(driver,this);
    }
    private int getDefaultWaitInSec(){
        return Integer.parseInt(System.getProperty("defaultWaitSec"));
    }
    protected boolean isInitialized(){
        return false;
    }
}
