@API @smoke
Feature:Contains the solution for the 2nd problem

  Background: Sets the following parameters as the Base URI and the Path
    Given I set the "https://the-internet.herokuapp.com" as URI and the "/status_codes" as path

  Scenario:Sending a GET request to the 200 endpoint and asserting if its returning 200
    When I send a GET request to the "/200" endpoint
    Then I get 200 as response code

  Scenario:Sending a GET request to the 301 endpoint and asserting if its returning 301
    Given I turned off the automatic redirect
    When I send a GET request to the "/301" endpoint
    Then I get 301 as response code

  Scenario:Sending a GET request to the 404 endpoint and asserting if its returning 404
    When I send a GET request to the "/404" endpoint
    Then I get 404 as response code

  Scenario:Sending a GET request to the 500 endpoint and asserting if its returning 500
    When I send a GET request to the "/500" endpoint
    Then I get 500 as response code