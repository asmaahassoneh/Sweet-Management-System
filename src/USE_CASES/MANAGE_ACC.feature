Feature: ACC management
  Scenario: Admin manages accounts
    Given an admin is logged into the Sweet Management System
    When the admin navigates to the User Management section
    Then the admin should see a list of accounts

  Scenario: Admin deletes a store owner account
    Given an admin is logged into the Sweet Management System
    #the edit means delete an acc
    When the admin selects the "Edit User"
    And the admin select for the user "JohnDoe123"
    Then the system should delete the store owner account
    And confirm deletion

  Scenario: Admin edits a user account email
    Given an admin is in the User Management section
    And there is a user account with username "storeowner123"
    When the admin selects the "Edit User"
    And the admin updates the email to "newowner@example.com"
    And the admin submits the changes
    Then the user account with username "storeowner123" should have the updated email

  Scenario: Admin edits a user account salary
    Given an admin is in the User Management section
    And there is a user account with username "storeowner123"
    When the admin selects the "Edit User"
    And the admin updates the salary to 1000
    And the admin submits the changes
    Then the user account with username "storeowner123" should have the updated salary
