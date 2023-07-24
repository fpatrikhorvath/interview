package com.common.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, getDefaultWaitInSec());
        PageFactory.initElements(driver, this);
    }

    private int getDefaultWaitInSec() {
        return Integer.parseInt(System.getProperty("defaultWaitSec"));
    }

    protected boolean isInitialized() {
        return false;
    }

    protected void enterTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void clickOnElement(WebElement element) {
        element.click();
    }

    protected boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }
}
