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
    @Override
    public boolean isInitialized() {
        return isElementVisible(loginButton);
    }

    public void enterUsername(String username) {
        enterTextToElement(usernameInputField,username);
    }
    public void enterPassword(String password) {
        enterTextToElement(passwordInputField,password);
    }
    public void pressLoginButton(){
        clickOnElement(loginButton);
    }
}
