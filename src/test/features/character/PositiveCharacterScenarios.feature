Feature: Positive tests character https://rickandmortyapi.com/api/character

  Scenario: Open the end point character.
    Given Open the end point "/character".
    When Get the result with the end point /character.
    Then Count of characters should be 20, the next page should be "https://rickandmortyapi.com/api/character?page=2", the previous should be "null", the status code should be 200, the content type should be "application/json".

  Scenario Outline: The valid array of id character.
    Given Open the end point "/character" with the valid array of id parameter "1, 300, 671".
    When Get the result with the array of id.
    Then The id should be the from the array of id, the status code should be 200, the content type should be "application/json".
      |   1 |
      | 300 |
      | 671 |

  Scenario Outline: The valid id character.
    Given Open the end point "/character" with the valid parameter <id>.
    When Get the result with the id.
    Then The id should be <id>, the status code should be <statusCode>, the content type should be "<contentType>".

    Examples: 
      | id  | statusCode | contentType      |
      |   1 |        200 | application/json |
      | 300 |        200 | application/json |
      | 671 |        200 | application/json |

  Scenario Outline: The valid page of character.
    Given Open the end point "/character" with the valid "page" equal <param>.
    When Get the result with the page.
    Then The next page should be "<next>", the previous should be "<prev>", the status code should be <statusCode>, the content type should be "<contentType>".

    Examples: 
      | param | statusCode | contentType      | next                                              | prev                                              |
      |     1 |        200 | application/json | https://rickandmortyapi.com/api/character?page=2  | null                                              |
      |    20 |        200 | application/json | https://rickandmortyapi.com/api/character?page=21 | https://rickandmortyapi.com/api/character?page=19 |
      |    34 |        200 | application/json | null                                              | https://rickandmortyapi.com/api/character?page=33 |

  Scenario Outline: The valid name, status, species, type, gender.
    Given Open the end point "/character" with the valid "name" equal "<name>", "status" equal "<status>", "species" equal "<species>", "type" equal "<type>", "gender" equal "<gender>".
    When Get the result with the name, status, species, type, gender.
    Then The name should be "<nameCharacter>", the status should be "<statusCharacter>", the species should be "<speciesCharacter>", the type should be "<typeCharacter>", the gender should be "<genderCharacter>", the status code should be <statusCode>, the content type should be "<contentType>".

    Examples: 
      | name         | status | species | type     | gender | nameCharacter | statusCharacter | speciesCharacter | typeCharacter | genderCharacter | statusCode | contentType      |
      | Cousin Nicky | Dead   | Alien   | Parasite | Male   | Cousin Nicky  | Dead            | Alien            | Parasite      | Male            |        200 | application/json |
      | Cousin Nicky | Dead   | Alien   | Parasite |        | Cousin Nicky  | Dead            | Alien            | Parasite      |                 |        200 | application/json |
      | Cousin Nicky | Dead   | Alien   |          |        | Cousin Nicky  | Dead            | Alien            |               |                 |        200 | application/json |
      | Cousin Nicky | Dead   |         |          |        | Cousin Nicky  | Dead            |                  |               |                 |        200 | application/json |
      | Cousin Nicky |        |         |          |        | Cousin Nicky  |                 |                  |               |                 |        200 | application/json |
      |              | Dead   |         |          |        |               | Dead            |                  |               |                 |        200 | application/json |
      |              |        | Alien   |          |        |               |                 | Alien            |               |                 |        200 | application/json |
      |              |        |         | Parasite |        |               |                 |                  | Parasite      |                 |        200 | application/json |
      |              |        |         |          | Male   |               |                 |                  |               | Male            |        200 | application/json |
