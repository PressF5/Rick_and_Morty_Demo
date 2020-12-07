Feature: Positive test https://rickandmortyapi.com/api/

  Scenario: Open https://rickandmortyapi.com/api/
    Given Open the base url.
    When Get the values of characters, locations, episodes.
    Then The values should be "https://rickandmortyapi.com/api/character", "https://rickandmortyapi.com/api/location", "https://rickandmortyapi.com/api/episode", status code should be 200, content type should be "application/json".
