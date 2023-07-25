@API @smoke
Feature:Contains the solution for the 3rd problem
  Background:Sets the BaseUri for the Rest Assured
    Given I set the "https://jsonplaceholder.typicode.com" as URI and the "" as path

  Scenario:Sends a GET request to the /users endpoint and then validates that
  the response contains the test object with the test data
    When I send a GET request to the "/users" endpoint
    Then I see "Nicholas Runolfsdottir V" in the response body
    When I send a GET request to the "/users?name=Nicholas Runolfsdottir V" endpoint
    And I see the following values in the response body
      | "street": "Ellsworth Summit" |
      | "suite": "Suite 729"         |
      | "city": "Aliyaview"          |
      | "zipcode": "45169"           |
      | "lat": "-14.3990"            |
      | "lng": "-120.7677"           |