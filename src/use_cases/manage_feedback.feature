Feature: Feedback Handling

  Scenario: Handling positive feedback as Excellent
    When I receive positive feedback as Excellent
    Then I should send a thank you message for Excellent

  Scenario: Handling positive feedback as good
    When I receive positive feedback as good
    Then I should send a thank you message for good

  Scenario: Handling positive feedback as Medium
    When I receive positive feedback as Medium
    Then I should send a thank you message for Medium

  Scenario: Handling negative feedback as poor
    When I receive negative feedback as poor
    Then I should send an apology for poor

  Scenario: Handling negative feedback as very bad
    When I receive negative feedback as very bad
    Then I should send an apology for very bad
