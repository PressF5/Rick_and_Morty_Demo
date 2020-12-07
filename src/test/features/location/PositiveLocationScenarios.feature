Feature: Positive tests location https://rickandmortyapi.com/api/location

  Scenario: Open the end point location.
    Given Open the end point "/location".
    When Get the result with the end point /location.
    Then Count of locations should be 20, the next page should be "https://rickandmortyapi.com/api/location?page=2", the previous should be "null", the status code should be 200, the content type should be "application/json".

  Scenario Outline: The valid array of id location.
    Given Open the end point "/location" with the valid array of id parameter "1, 50, 108".
    When Get the result with the array of id.
    Then The id should be the from the array of id, the status code should be 200, the content type should be "application/json".
      |   1 |
      |  50 |
      | 108 |

  Scenario Outline: The valid id location.
    Given Open the end point "/location" with the valid parameter <id>.
    When Get the result with the id.
    Then The id should be <id>, the status code should be <statusCode>, the content type should be "<contentType>".

    Examples: 
      | id  | statusCode | contentType      |
      |   1 |        200 | application/json |
      |  50 |        200 | application/json |
      | 108 |        200 | application/json |

  Scenario Outline: The valid page of location.
    Given Open the end point "/location" with the valid "page" equal <param>.
    When Get the result with the page.
    Then The next page should be "<next>", the previous should be "<prev>", the status code should be <statusCode>, the content type should be "<contentType>".

    Examples: 
      | param | statusCode | contentType      | next                                            | prev                                            |
      |     1 |        200 | application/json | https://rickandmortyapi.com/api/location?page=2 | null                                            |
      |     3 |        200 | application/json | https://rickandmortyapi.com/api/location?page=4 | https://rickandmortyapi.com/api/location?page=2 |
      |     6 |        200 | application/json | null                                            | https://rickandmortyapi.com/api/location?page=5 |

  Scenario Outline: The valid name, type, dimension.
    Given Open the end point "/location" with the valid "name" equal "<name>" and "type" equal "<type>" and "dimension" equal "<dimension>".
    When Get the result with the name, type, dimension.
    Then The name should be "<name_location>", the type should be "<type_location>", the dimension should be "<dimension_location>", the status code should be <statusCode>, the content type should be "<contentType>".

    Examples: 
      | name          | type   | dimension       | name_location | type_location | dimension_location | statusCode | contentType      |
      | Earth (C-137) | Planet | Dimension C-137 | Earth (C-137) | Planet        | Dimension C-137    |        200 | application/json |
      | Earth (C-137) | Planet |                 | Earth (C-137) | Planet        |                    |        200 | application/json |
      | Earth (C-137) |        |                 | Earth (C-137) |               |                    |        200 | application/json |
      |               | Planet |                 |               | Planet        |                    |        200 | application/json |
      |               |        | Dimension C-137 |               |               | Dimension C-137    |        200 | application/json |
