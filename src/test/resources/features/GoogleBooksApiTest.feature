Feature: Google Books API test

  @ApiTest
  Scenario: Test of cucumber book

    Given that I want to search for a book through the Google Books API
    When I place a request with the search parameter "cucumber"
    Then the response should have statuscode "200"
    And the response should include a book with the following data
      | title         | The Cucumber Book                     |
      | authors       | Matt Wynne,Aslak Hellesoy,Steve Tooke |
      | publisher     | Pragmatic Bookshelf                   |
      | publishedDate | 2017-02-17                            |