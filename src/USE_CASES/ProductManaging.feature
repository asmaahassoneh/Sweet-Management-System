Feature: Edit product
  Scenario: adding a product
    Given I'm the store owner
    When the name is "cheesecake" and the price is 25 and the num of available is 1 and the description is "good way" and the recipes is "egg/milk" and the cost is 20 and the discount is 10
    Then the product add successfully

  Scenario: Adding a product with duplicate name
    Given I'm the store owner
    And there is a product named "cheesecake" in my store
    When the name is "cheesecake" and the price is 25 and the num of available is 1 and the description is "good way" and the recipes is "egg/milk" and the cost is 20 and the discount is 10
    Then an error message is displayed indicating the product name already exists

  Scenario: Adding a product with invalid data
    Given I'm the store owner
    When the name is "" and the price is -1 and the num of available is 0 and the description is "" and the recipes is "" and the cost is -1 and the discount is -1
    Then the product is not added and an error message is displayed

  Scenario: Updating a product
    Given I'm the store owner
    And there is a product named "cheesecake" in my store
    When I update the product with new price 30 and the num of available is 2 and description "delicious" and the recipes is "egg/milk/water" and the cost is 25 and the discount is 5
    Then the product "cheesecake" is updated successfully

  Scenario: Adding a product with a non-numeric price
    Given I'm the store owner
    When the name is "cheesecake" and the price is "abc" and the num of available is 1 and the description is "good way" and the recipes is "egg/milk" and the cost is 20 and the discount is 10
    Then the product is not added and an error message is displayed indicating the price must be a numeric value

  Scenario: Removing a product
    Given I'm the store owner
    And there is a product named "cheesecake" in my store
    When I remove the product from my store
    Then the product "cheesecake" is removed successfully
