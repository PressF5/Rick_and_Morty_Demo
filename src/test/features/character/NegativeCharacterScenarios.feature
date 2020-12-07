Feature: Negative tests character https://rickandmortyapi.com/api/character.

  Scenario Outline: The invalid array of id character.
    Given Open the end point "/character" with the invalid array of id parameter "<arrayId>".
    When Get the error with the array of id.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid array id.

    Examples: 
      | arrayId       | error                                                                                | statusCode | contentType      |
      | 0,-1,-200,672 | Character not found                                                                  |        404 | application/json |
      | qwerty, 100   | Cast to Number failed for value \\"NaN\\" at path \\"id\\" for model \\"Character\\" |        500 | application/json |

  Scenario Outline: The invalid id character.
    Given Open the end point "/character" with the invalid parameter "<id>".
    When Get the error with the id.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid parameter id.

    Examples: 
      | id     | error                       | statusCode | contentType      |
      |      0 | Character not found         |        404 | application/json |
      |     -1 | Character not found         |        404 | application/json |
      |   -200 | Character not found         |        404 | application/json |
      |    672 | Character not found         |        404 | application/json |
      | qwerty | Hey! you must provide an id |        500 | application/json |

  Scenario Outline: The invalid page of character.
    Given Open the end point "/character" with the invalid "page" equal <param>.
    When Get the error with the page.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid page.

    Examples: 
      | param | error                 | statusCode | contentType      |
      |     0 | There is nothing here |        404 | application/json |
      |    -1 | There is nothing here |        404 | application/json |
      |  -200 | There is nothing here |        404 | application/json |
      |    35 | There is nothing here |        404 | application/json |
      |   100 | There is nothing here |        404 | application/json |

  Scenario Outline: The invalid name, status, species, type, gender.
    Given Open the end point "/character" with the invalid "name" equal "<name>", "status" equal "<status>", "species" equal "<species>", "type" equal "<type>", "gender" equal "<gender>".
    When Get the error with the name, status, species, type, gender.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid name, status, species, type, gender.

    Examples: 
      | name    | status  | species | type    | gender  | error                 | statusCode | contentType      |
      | qwerty1 | qwerty2 | qwerty3 | qwerty4 | qwerty5 | There is nothing here |        404 | application/json |
      | qwerty1 | qwerty2 | qwerty3 | qwerty4 |         | There is nothing here |        404 | application/json |
      | qwerty1 | qwerty2 | qwerty3 |         |         | There is nothing here |        404 | application/json |
      | qwerty1 | qwerty2 |         |         |         | There is nothing here |        404 | application/json |
      | qwerty1 |         |         |         |         | There is nothing here |        404 | application/json |
      |         | qwerty2 |         |         |         | There is nothing here |        404 | application/json |
      |         |         | qwerty3 |         |         | There is nothing here |        404 | application/json |
      |         |         |         | qwerty4 |         | There is nothing here |        404 | application/json |
      |         |         |         |         | qwerty5 | There is nothing here |        404 | application/json |
