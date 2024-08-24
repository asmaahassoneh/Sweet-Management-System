Feature: Allergy products

  Scenario: user Allergy
    When  the user presses the Allergy button
    Then  the market should filter the food

  Scenario:
    When the user presses the Allergy button two times
    Then all products should be returned normally