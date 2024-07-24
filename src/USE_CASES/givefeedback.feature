Feature: Managing User Feedback

  Scenario: Positive Feedback
    Given im a user who has order
    When I submit positive feedback
    Then I should receive a thank you message

  Scenario: Negative Feedback
    Given im a user who has order
    When I submit negative feedback
    Then I should receive an apology for the inconvenience