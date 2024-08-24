Feature: Special Request Notification

  Scenario: Sending a notification email for a valid special request
    Given there exists a special request made by a user
    When the system sends a notification email to the store owner "store@example.com"
    Then the store owner should receive an email about the special request

  Scenario: Sending a notification email with special characters in subject and message
    Given there exists a special request made by a user with special characters in subject and message
    When the system sends a notification email to the store owner "store@example.com"
    Then the store owner should receive an email about the special request

  Scenario: Sending a notification email with a long subject and message
    Given there exists a special request made by a user with a long subject and message
    When the system sends a notification email to the store owner "store@example.com"
    Then the store owner should receive an email about the special request





