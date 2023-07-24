@UI @smoke
Feature:Contains the solution for the 1st problem

  Scenario:The user tries to login with the correct username and password combination
    Given the user is on the "/login" page
    When the user types in the "tomsmith" username and the "SuperSecretPassword!" password
    Then the user is logged in

  Scenario:The user tries to login with an incorrect username and password combination
    Given the user is on the "/login" page
    When the user types in the "tomsmith" username and the "InvalidPassword" password
    Then the user is not logged in