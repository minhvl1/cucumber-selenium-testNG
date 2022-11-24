@Feature4
Feature: Demo API

  @get
  Scenario: API get method
    Given send get method with id="1"
    When show get response body
    Then id contains "1"


