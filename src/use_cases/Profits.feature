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


    Scenario:  product are equally  soled number

      When the store owner press less or most  solded item button
      And both are have the same number of sellings
      Then  we must show all the name of the solded items


