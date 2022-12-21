@Feature5
@Ignore
Feature: Shadow root

  @selectorhub
  Scenario: input to shadow root
    Given go to selectorhub
    When input username textbox
    And input pizza textbox

  @shopee
  Scenario: close popup shopee
    Given go to shopee
    When close popup
