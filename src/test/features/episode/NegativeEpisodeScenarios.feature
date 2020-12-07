Feature: Negative tests episode https://rickandmortyapi.com/api/episode.

  Scenario Outline: The invalid array of id episode.
    Given Open the end point "/episode" with the invalid array of id parameter "<arrayId>".
    When Get the error with the array of id.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid array id.

    Examples: 
      | arrayId      | error                                                                              | statusCode | contentType      |
      | 0,-1,-200,50 | episode not found                                                                  |        404 | application/json |
      | qwerty, 100  | Cast to Number failed for value \\"NaN\\" at path \\"id\\" for model \\"Episode\\" |        500 | application/json |

  Scenario Outline: The invalid id episode.
    Given Open the end point "/episode" with the invalid parameter "<id>".
    When Get the error with the id.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid parameter id.

    Examples: 
      | id     | error                       | statusCode | contentType      |
      |      0 | Episode not found           |        404 | application/json |
      |     -1 | Episode not found           |        404 | application/json |
      |   -200 | Episode not found           |        404 | application/json |
      |     50 | Episode not found           |        404 | application/json |
      | qwerty | Hey! you must provide an id |        500 | application/json |

  Scenario Outline: The invalid page of episode.
    Given Open the end point "/episode" with the invalid "page" equal <param>.
    When Get the error with the page.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid page.

    Examples: 
      | param | error                 | statusCode | contentType      |
      |     0 | There is nothing here |        404 | application/json |
      |    -1 | There is nothing here |        404 | application/json |
      |  -200 | There is nothing here |        404 | application/json |
      |     4 | There is nothing here |        404 | application/json |
      |   100 | There is nothing here |        404 | application/json |

  Scenario Outline: The invalid name and episode.
    Given Open the end point "/episode" with the invalid "name" equal "<name>" and "episode" equal "<episode>".
    When Get the error with the name and page.
    Then The error should be "<error>", the status code should be <statusCode>, the content type should be "<contentType>" with the invalid name and episode.

    Examples: 
      | name   | episode | error                 | statusCode | contentType      |
      | qwerty | s123    | There is nothing here |        404 | application/json |
      | qwerty |         | There is nothing here |        404 | application/json |
      |        | s123    | There is nothing here |        404 | application/json |
