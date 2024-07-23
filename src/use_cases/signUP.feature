Feature: User Sign Up

  Scenario: Successful sign-up
    Given I am on the sign-up page
    When I enter a valid username "Mohammed"
    And I enter a valid email "mohammed@gmail.com"
    And I enter a valid role "Admin"
    And I enter a valid password "mohas1224"
    And I confirm the password "mohas1224"
    And I click the sign-up button
    Then I should see Account created successfully



  Scenario: Sign-up with invalid Email
    Given I am on the sign-up page
    When I enter a valid username "Mohammed"
    # entered invalid email
    And I enter a valid email "mohammed@gmail.com"
    And I enter a valid role "Admin"
    And I enter a valid password "mohas1224"
    And I confirm the password "mohas1224"
    And I click the sign-up button
    Then I should see Account created successfully




  Scenario: Sign-up with invalid password

    Given I am on the sign-up page
    When I enter a valid username "Mohammed"
    And I enter a valid email "mohammed@gmail.com"
    And I enter a valid role "Admin"
    #user enter invalid password
    And I enter a valid password "her1224"
    And I confirm the password "her1224"
    And I click the sign-up button
    Then I should see Account created successfully


  Scenario: Sign-up with invalid username
    Given I am on the sign-up page
    When I enter an invalid username "hib@123"
    And I enter a valid email "Hiba@gmail.com"
    And I enter a valid role "user"
    And I enter a valid password "Hiba8854"
    And I confirm the password "Hiba8854"
    And I click the sign-up button
    Then I should see Invalid username "the username must starts with capital letter and without space also maximum letters 10"


  Scenario: Sign-up with already used email
    Given I am on the sign-up page
    When I enter a valid username "Hiba"
    #I enter an email that is already used but i make the same script to reduce function
    And I enter a valid email "Kiba-l.com"
    And I enter a valid role "user"
    And I enter a valid password "Hiba8854"
    And I confirm the password "Hiba8854"
    And I click the sign-up button
    Then I should see Email address is already in use "the Email already used please change it "



  Scenario: Sign-up with already used pass
    Given I am on the sign-up page
    When I enter a valid username "Hiba"
    #I enter an email that is already used but i make the same script to reduce function
    And I enter a valid email "Kiba-l.com"
    And I enter a valid role "user"
    And I enter a repated pass password "A123"
    And I confirm the password "A123"
    And I click the sign-up button
    Then I should see invalid pass address is already in use

  Scenario: Passwords do not match
    Given I am on the sign-up page
    When I enter a valid username "Hiba"
    And I enter a valid email "Hiba@gmail.com"
    And I enter a valid role "raw material provider"
    And I enter a valid password "Hiba8854"
    #confirmation worng but i name it like this to reduce  functions
    And I confirm the password "Hiba54"
    And I click the sign-up button
    Then I should see Passwords do not match "passworde do not match please make sure to confirm corectly"



  Scenario: Sign-up with invalid role
    Given I am on the sign-up page
    When I enter a valid username "Hiba"
    And I enter a valid email "Niba@gmail.com"
    # when user enter wrong role  but i name it like this to reduce  functions
    And I enter a valid role "chif"
    And I enter a valid password "Hiba8854"
    And I confirm the password "Hiba8854"
    And I click the sign-up button
    Then I should see Invalid role "Please only these roles are avilable  Admin/user/raw material provider/store owner dashboard"

