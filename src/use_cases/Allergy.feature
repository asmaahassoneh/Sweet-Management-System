Feature: Allergy products

  Scenario: user Allergy
    When  the user press Allergy button
    Then  the market must filter the food

  Scenario:
    When the user press Allergy button two times
    Then  return all products normally