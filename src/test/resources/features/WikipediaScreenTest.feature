Feature: Wikipedia webpage test

  @ScreenTest
  Scenario: Test of Cucumber page

    Given that I am on the Wikipedia homepage
    When I search for "Cucumber (software)"
    Then I should be redirected to the page of Cucumber (software)
    And not to the page of the vegetable cucumber

