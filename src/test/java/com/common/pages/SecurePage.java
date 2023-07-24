package com.common.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecurePage extends BasePage {

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutButton;

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isInitialized() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        return isElementVisible(logoutButton);
    }
}
