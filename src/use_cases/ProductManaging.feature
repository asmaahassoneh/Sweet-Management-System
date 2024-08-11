Feature: Edit product
  Scenario: adding a product
    Given I'm the store owner
    When  i add new item to the SweetStore "cookies"+"123578"+"dark Cake without sugar"+"2024/07/28"+"25"+"250"+" true"+"images/djdj.pnj"
    Then the product add successfully


  Scenario: Adding a product with missing data
    Given I'm the store owner
    When i add a product with missing information "dark cake"+"123578"+"dark Cake without sugar"+"2024/07/28"+"25"+"0"+"true"+"images/djdj.pnj"
    Then the product is not added and an error message is displayed

  Scenario: Updating a product
    Given I'm the store owner
    When i choose a product with id for updating it "dark cake"+"123578"+"dark Cake without sugar"+"2024/07/28"+"200"+"20"+" milk "+"images/djdj.pnj"
    Then the product is updated successfully


  Scenario:  Repated serial number for product
    Given I'm the store owner
    When  the id repated "123578"
    Then error message to change the id


  Scenario: Removing a product
    Given I'm the store owner
    When I remove the product from my store "123578"
    Then the product  is removed successfully
