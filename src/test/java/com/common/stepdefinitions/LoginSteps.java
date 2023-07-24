package com.common.stepdefinitions;

import com.common.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.common.stepdefinitions.Hooks.*;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    /**
     * Navigates the web browser to the specified page by combining the
     * base URI and base path with the given page name.
     *
     * @param pageName The name of the page to navigate to.
     */
    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String pageName) {
        driver.navigate().to(Utils.BASE_URI + Utils.BASE_PATH + pageName);
    }

    /**
     * Enters the provided username and password into the
     * input fields on the login page and clicks the login button.
     *
     * @param username The username to enter.
     * @param password The password to enter.
     */
    @When("the user types in the {string} username and the {string} password")
    public void theUserTypesInTheUsernameAndThePassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.pressLoginButton();
    }

    /**
     * Asserts that the user is logged in by checking if the page is initialized.
     */
    @Then("the user is logged in")
    public void theUserIsLoggedIn() {
        assertTrue(securePage.isInitialized());
    }

    /**
     * Checks that the user is not logged in by checking if the login page is initialized.
     */
    @Then("the user is not logged in")
    public void theUserIsNotLoggedIn() {
        assertTrue(loginPage.isInitialized());
    }
}
