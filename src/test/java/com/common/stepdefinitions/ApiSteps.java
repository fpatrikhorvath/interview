package com.common.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.common.Utils;
import io.restassured.module.jsv.JsonSchemaValidator;

import static org.junit.Assert.*;
import static com.common.stepdefinitions.Hooks.*;

public class ApiSteps {
    @Given("I set the {string} as URI and the {string} as path")
    public void set_uri_and_path(String uri, String path) {
        restAssured.setUriAndPath(uri, path);
    }

    @When("I send a GET request to the {string} endpoint")
    public void iSendAGETRequestToTheEndpoint(String endpoint) {
        response = restAssured.getOps(endpoint);
    }

    @Then("I get {int} as response code")
    public void iGetAsResponseCode(int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        String message = "The expected status code is " + expectedStatusCode + " but the actual is " + statusCode;
        assertEquals(message, expectedStatusCode, statusCode);
    }

    @Given("I turned off the automatic redirect")
    public void iTurnedOffTheRedirect() {
        restAssured.setFollowRedirect(false);
    }

    @Then("I see {string} in the response body")
    public void iSeeInTheResponseBody(String expectedValue) {
        boolean isContain = response.getBody().asString().contains(expectedValue);
        String message = "The " + expectedValue + " is missing from the response body!";
        assertTrue(message, isContain);
    }

    @And("I see the {string} schema in the response body")
    public void iSeeTheInTheResponseBody(String path) throws IOException {
        String expectedJsonSchema = new String(Files.readAllBytes(Paths.get(Utils.RESOURCE_DIR + path)));
        JsonSchemaValidator validator = JsonSchemaValidator.matchesJsonSchema(expectedJsonSchema);
        response.then().assertThat().body(validator);
    }
}
