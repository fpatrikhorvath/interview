package com.common.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id="username")
    WebElement usernameInputField;
    @FindBy(id="password")
    WebElement passwordInputField;
    @FindBy(xpath="//button[@type='submit']")
    WebElement loginButton;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Checks if the page object is initialized by verifying the visibility of the login button.
     *
     * @return True if the login button is visible and the page object is initialized, otherwise false.
     */
    @Override
    public boolean isInitialized() {
        return isElementVisible(loginButton);
    }

    /**
     * Enters the specified username into the username input field.
     *
     * @param username The username to be entered.
     */
    public void enterUsername(String username) {
        enterTextToElement(usernameInputField, username);
    }

    /**
     * Enters the specified password into the password input field.
     *
     * @param password The password to be entered.
     */
    public void enterPassword(String password) {
        enterTextToElement(passwordInputField, password);
    }

    /**
     * Clicks on the login button.
     */
    public void pressLoginButton() {
        clickOnElement(loginButton);
    }
}
