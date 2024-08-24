Feature: Profit Calculation
  Scenario:  profitButton
    When the store owner press profit button
    Then it should see the total incomes from sweet shop

  Scenario:  most solded
    When the store owner press most solded item button
    Then it should see the name for the most solded item

  Scenario:  less solded
    When the store owner press less solded item button
    Then it should see the name for the less solded item

  Scenario: Calculate Total Profits
    When the store owner press profit button
    Then it should see the total incomes from sweet shop

  Scenario: Get Most Sold Item
    When the store owner press most solded item button
    Then it should see the name for the most solded item

  Scenario: Get Less Sold Item
    When the store owner press less solded item button
    Then it should see the name for the less solded item


  Scenario: Handle File Not Found
    When the file does not exist
    Then it should handle the IOException


  Scenario: Handling Invalid Profit Values
    When the product detail contains an invalid profit value
    Then it should handle the NumberFormatException in profit calculation

