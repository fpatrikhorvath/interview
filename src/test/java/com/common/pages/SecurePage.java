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

    /**
     * Checks if the page object is initialized by verifying the visibility of the logout button.
     * Waits until the logout button becomes visible before performing the check.
     *
     * @return True if the logout button is visible and the page object is initialized, otherwise false.
     */
    @Override
    public boolean isInitialized() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        return isElementVisible(logoutButton);
    }
}
