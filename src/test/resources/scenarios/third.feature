@API @smoke
Feature:Contains the solution for the 3rd problem

  Scenario:Sends a GET request to the /users endpoint and then validates that
  the response contains the test object with the test data
    Given I set the "https://jsonplaceholder.typicode.com" as URI and the "" as path
    When I send a GET request to the "/users" endpoint
    Then I see "Nicholas Runolfsdottir V" in the response body
    And I see the "/responses/json/address.json" schema in the response body

