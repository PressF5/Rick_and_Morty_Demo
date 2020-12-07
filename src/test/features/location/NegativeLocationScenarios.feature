Feature: Negative tests location https://rickandmortyapi.com/api/location.

  Scenario Outline: The invalid array of id location.
    Given Open the end point "/location" with the invalid array of id parameter "<arrayId>".
    When Get the error with the array of id.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid array id.

    Examples: 
      | arrayId       | error                                                                               | statusCode | contentType      |
      | 0,-1,-200,109 | Location not found                                                                  |        404 | application/json |
      | qwerty, 100   | Cast to Number failed for value \\"NaN\\" at path \\"id\\" for model \\"Location\\" |        500 | application/json |

  Scenario Outline: The invalid id location.
    Given Open the end point "/location" with the invalid parameter "<id>".
    When Get the error with the id.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid parameter id.

    Examples: 
      | id     | error                       | statusCode | contentType      |
      |      0 | Location not found          |        404 | application/json |
      |     -1 | Location not found          |        404 | application/json |
      |   -150 | Location not found          |        404 | application/json |
      |    109 | Location not found          |        404 | application/json |
      | qwerty | Hey! you must provide an id |        500 | application/json |

  Scenario Outline: The invalid page of location.
    Given Open the end point "/location" with the invalid "page" equal <param>.
    When Get the error with the page.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid page.

    Examples: 
      | param | error                 | statusCode | contentType      |
      |     0 | There is nothing here |        404 | application/json |
      |    -1 | There is nothing here |        404 | application/json |
      |   -20 | There is nothing here |        404 | application/json |
      |     7 | There is nothing here |        404 | application/json |
      |    25 | There is nothing here |        404 | application/json |

  Scenario Outline: The invalid name, type, dimension.
    Given Open the end point "/location" with the invalid "name" equal "<name>" and "type" equal "<type>" and "dimension" equal "<dimension>".
    When Get the error with the name, type, dimension.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid name, type, dimension.

    Examples: 
      | name    | type    | dimension | error                 | statusCode | contentType      |
      | qwerty1 | qwerty2 | qwerty3   | There is nothing here |        404 | application/json |
      | qwerty1 | qwerty2 |           | There is nothing here |        404 | application/json |
      | qwerty1 |         |           | There is nothing here |        404 | application/json |
      |         | qwerty2 |           | There is nothing here |        404 | application/json |
      |         |         | qwerty3   | There is nothing here |        404 | application/json |
