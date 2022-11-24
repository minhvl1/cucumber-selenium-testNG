@Feature4
Feature: Demo API

  @getvalueAPI
  Scenario: API get method
    Given send get method with id="1"
    When show get response body
    Then id contains "1"

#  @getMethodApi
#  Scenario: test api
#    Given test

#  @postMethodApi
#  Scenario: test post api
#    Given test post
