Feature: ACC management
  Scenario: Admin manages accounts
    Given an admin is logged into the Sweet Management System
    When the admin navigates to the User Management section
    Then the admin should see a list of accounts

  Scenario: Admin ADD accounts
    Given an admin is logged into the Sweet Management System
    When  the admin press add and Entered valid Data "Hiba"+"Salfeet"+"Hiba@gmail.com"+"N002"+"User"
    Then new user will be Added into dataBase

  Scenario: Admin deletes a store owner account
    Given an admin is logged into the Sweet Management System
    #the edit means delete an acc
    When the admin selects the "Edit User"
    And the admin select for the user "user"
    And should Delete the specific user "Mk123"
    Then the system should show a masseage deleted was sucsess


  Scenario: Admin edits a user account
    Given an admin is in the User Management section
    When the admin selects the "Edit User"
    And the admin updates the account to "Asma@gmail.com"+"Asma"+"User"+"Nablus"+"A441"
    And the admin submits the changes
    Then the user account with username "storeowner123" should have the updated email



  Scenario: Admin edits a user city
    Given an admin is in the User Management section
    When the admin selects the "Edit User"
    And the admin updates the city to "Salfeet"+"M123"
    Then a massege should say city updated