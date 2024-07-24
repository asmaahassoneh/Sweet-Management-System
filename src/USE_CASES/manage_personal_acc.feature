Feature: personal acc management
  Scenario: user update info
    Given an user is logged into the Sweet Management System
    When the user press on the edit button
    Then the user should see his personal info


  Scenario: user update email
    Given an user is logged into the Sweet Management System
    When the user change email to "hiba@gmail.com"
    And press on confirm button
    Then the user email should be updated


  Scenario: user update password
    Given an user is logged into the Sweet Management System
    When the user change password to "h1122003"
    And press on confirm button
    Then the user password should be updated