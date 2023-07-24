package com.common.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * It's an abstract parent for all the Pages we use.
 * Contains all the most primary methods.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, getDefaultWaitInSec());
        PageFactory.initElements(driver, this);
    }

    /**
     * Gets the default wait time from the CLI.
     *
     * @return the value of that as an int value
     */
    private int getDefaultWaitInSec() {
        return Integer.parseInt(System.getProperty("defaultWaitSec"));
    }

    /**
     * The visibility state of the page.
     * @return true if its visible
     */
    protected boolean isInitialized() {
        return false;
    }

    /**
     * Enters the specified text into the given web element.
     *
     * @param element The web element where the text will be entered.
     * @param text    The text to be entered into the web element.
     */
    protected void enterTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Clicks on the specified web element.
     *
     * @param element The web element to be clicked.
     */
    protected void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * Checks if the specified web element is visible on the webpage.
     *
     * @param element The web element to be checked for visibility.
     * @return True if the web element is visible, any other case its false.
     */
    protected boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }
}
