Feature: Negative test https://rickandmortyapi.com/api/

  Scenario Outline: Open https://rickandmortyapi.com/api/ with the invalid endpoints.
    Given Open the end point "<endPoints>".
    When Get the error.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>".

    Examples: 
      | endPoints | error                  | statusCode | contentType      |
      | /qwerty   | There is nothing here. |        404 | application/json |
      | /123      | There is nothing here. |        404 | application/json |
