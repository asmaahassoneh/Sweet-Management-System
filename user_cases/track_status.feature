Scenario: Placing a new order
Given I'm a customer
And I have added products to my cart
When I complete the checkout process
Then the system creates a new order with a status of "Pending"
And the order is assigned a unique order ID

Scenario: Updating order status
Given I'm the store owner
And there is an order with a status of "Pending"
When I update the order status to "Shipped"
Then the system updates the order status to "Shipped"
