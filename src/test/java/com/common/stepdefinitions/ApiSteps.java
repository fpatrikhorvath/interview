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

/**
 * Collection of the API step definitions
 */
public class ApiSteps {
    /**
     * Sets the URI and path for the REST Assured request.
     *
     * @param uri  The base URI to be set for the request.
     * @param path The base path to be set for the request.
     */
    @Given("I set the {string} as URI and the {string} as path")
    public void set_uri_and_path(String uri, String path) {
        restAssured.setUriAndPath(uri, path);
    }

    /**
     * Sends a GET request to the specified endpoint using REST Assured.
     *
     * @param endpoint The endpoint to which the GET request will be sent.
     */
    @When("I send a GET request to the {string} endpoint")
    public void iSendAGETRequestToTheEndpoint(String endpoint) {
        response = restAssured.getOps(endpoint);
    }

    /**
     * Validates that the response code matches the expected status code.
     *
     * @param expectedStatusCode The expected status code to be validated against the actual response code.
     */
    @Then("I get {int} as response code")
    public void iGetAsResponseCode(int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        String message = "The expected status code is " + expectedStatusCode + " but the actual is " + statusCode;
        assertEquals(message, expectedStatusCode, statusCode);
    }

    /**
     * Turns off the automatic redirect for the REST Assured request.
     */
    @Given("I turned off the automatic redirect")
    public void iTurnedOffTheRedirect() {
        restAssured.setFollowRedirect(false);
    }

    /**
     * Validates that the response body contains the expected value.
     *
     * @param expectedValue The expected value to be searched for in the response body.
     */
    @Then("I see {string} in the response body")
    public void iSeeInTheResponseBody(String expectedValue) {
        boolean isContain = response.getBody().asString().contains(expectedValue);
        String message = "The " + expectedValue + " is missing from the response body!";
        assertTrue(message, isContain);
    }

    /**
     * Validates that the response body matches the provided JSON schema.
     *
     * @param path The path to the JSON schema file to be used for validation.
     * @throws IOException If there is an issue reading the JSON schema file.
     */
    @And("I see the {string} schema in the response body")
    public void iSeeTheInTheResponseBody(String path) throws IOException {
        // Reads the JSON schema from the file specified by 'path'
        String expectedJsonSchema = new String(Files.readAllBytes(Paths.get(Utils.RESOURCE_DIR + path)));

        // Validates the response body against the JSON schema using REST Assured's JsonSchemaValidator
        JsonSchemaValidator validator = JsonSchemaValidator.matchesJsonSchema(expectedJsonSchema);
        response.then().assertThat().body(validator);
    }
}
