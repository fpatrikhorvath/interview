package com.common.stepdefinitions;

import com.common.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.common.stepdefinitions.Hooks.*;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String pageName){
        driver.navigate().to(Utils.BASE_URI + Utils.BASE_PATH + pageName);
    }

    @When("the user types in the {string} username and the {string} password")
    public void theUserTypesInTheUsernameAndThePassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.pressLoginButton();
    }

    @Then("the user is logged in")
    public void theUserIsLoggedIn() {
        assertTrue(securePage.isInitialized());
    }

    @Then("the user is not logged in")
    public void theUserIsNotLoggedIn() {
        assertTrue(loginPage.isInitialized());
    }
}
