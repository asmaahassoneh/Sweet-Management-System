Feature: Managing User Feedback

  Scenario: Positive Feedback
    When I receive positive feedback
    Then I should send a thank you message "good"

  Scenario: Negative Feedback
    When I receive negative feedback
    #value must be (very bad or poor) else will be wrong
    Then I should send an apology for the inconvenience "very"