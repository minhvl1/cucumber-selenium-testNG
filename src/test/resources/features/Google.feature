@Feature1
Feature: test google search

  @Test1
  Scenario:search youtube in google
    Given open browser
    When Search "youtube"
    And Click search button
    Then See result page
    And URL contains "youtube"


  @Test2
  Scenario:search facebook in google
    Given open browser
    When Search "facebook"
    And Click search button
    Then See result page
    And URL contains "facebook"
