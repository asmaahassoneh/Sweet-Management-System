Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid username and password "Asma"+"A123"
    And the user clicks the login button
    Then the user should be redirected to the dashboard


  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username or password "mohamm"+"85544"
    And the user clicks the login button
    Then the user should see an error message indicating incorrect credentials

  Scenario: Unsuccessful login with missing credentials
    Given the user is on the login page
    When the user leaves the username or password field empty
    And the user clicks the login button
    Then the user should see an error message indicating that all fields are required
