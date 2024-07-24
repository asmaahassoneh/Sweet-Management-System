Feature: Notifications via email

  Scenario: Receive notifications [via email] for special requests
    Given I'm the store owner
    And there exists a special request made by a user
    When the system sends a notification email to the store owner
    Then the store owner should receive an email about the special request


