Feature: Managing User Feedback

  Scenario: Positive Feedback
    Given an admin is logged into the Sweet Management System
    When I receive positive feedback
    Then I should send a thank you message

  Scenario: Negative Feedback
    Given an admin is logged into the Sweet Management System
    When I receive negative feedback
    Then I should send an apology for the inconvenience