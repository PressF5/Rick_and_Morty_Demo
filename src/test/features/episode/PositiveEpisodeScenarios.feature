Feature: Positive tests episode https://rickandmortyapi.com/api/episode

  Scenario: Open the end point episode.
    Given Open the end point "/episode".
    When Get the result with the end point /episode.
    Then Count of episodes should be 20, the next page should be "https://rickandmortyapi.com/api/episode?page=2", the previous should be "null", the status code should be 200, the content type should be "application/json".

  Scenario Outline: The valid array of id episode.
    Given Open the end point "/episode" with the valid array of id parameter "1, 20, 41".
    When Get the result with the array of id.
    Then The id should be the from the array of id, the status code should be 200, the content type should be "application/json".
      |  1 |
      | 20 |
      | 41 |

  Scenario Outline: The valid id episode.
    Given Open the end point "/episode" with the valid parameter <id>.
    When Get the result with the id.
    Then The id should be <id>, the status code should be <statusCode>, the content type should be "<contentType>".

    Examples: 
      | id | statusCode | contentType      |
      |  1 |        200 | application/json |
      | 20 |        200 | application/json |
      | 41 |        200 | application/json |

  Scenario Outline: The valid page of episode.
    Given Open the end point "/episode" with the valid "page" equal <param>.
    When Get the result with the page.
    Then The next page should be "<next>", the previous should be "<prev>", the status code should be <statusCode>, the content type should be "<contentType>".

    Examples: 
      | param | statusCode | contentType      | next                                           | prev                                           |
      |     1 |        200 | application/json | https://rickandmortyapi.com/api/episode?page=2 | null                                           |
      |     2 |        200 | application/json | https://rickandmortyapi.com/api/episode?page=3 | https://rickandmortyapi.com/api/episode?page=1 |
      |     3 |        200 | application/json | null                                           | https://rickandmortyapi.com/api/episode?page=2 |

  Scenario Outline: The valid name and episode.
    Given Open the end point "/episode" with the valid "name" equal "<name>" and "episode" equal "<episode>".
    When Get the result with the name and episode.
    Then The name should be "<nameEpisode>", the episode should be "<numberEpisode>", the status code should be <statusCode>, the content type should be "<contentType>".

    Examples: 
      | name  | episode | nameEpisode | numberEpisode | statusCode | contentType      |
      | Pilot | S01E01  | Pilot       | S01E01        |        200 | application/json |
      | Pilot |         | Pilot       |               |        200 | application/json |
      |       | S01E01  |             | S01E01        |        200 | application/json |
      |       | S01     |             | S01           |        200 | application/json |
      |       | E01     |             | E01           |        200 | application/json |
      | rick  |         | rick        |               |        200 | application/json |
