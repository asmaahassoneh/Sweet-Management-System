Feature: best sale

  Scenario: Monitoring daily sales
    Given I'm the store owner
    And there are sales data for today
    When I request the daily sales report
    Then the system displays the total sales for today

  Scenario: Monitoring sales by product
    Given I'm the store owner
    And there are sales data for all products
    When I request the sales report for a specific product
    Then the system displays the total sales for that product

  Scenario: Monitoring profits
    Given an admin is logged into the Sweet Management System
    And there are sales data for all products
    When I request the profits report
    Then the system displays the total profits for the store

  Scenario: Monitoring profits by product
    Given I'm the store owner or an admin is logged into the Sweet Management System
    And there are sales data for all products
    When I request the profits report for a specific product
    Then the system displays the total profits for that product

  Scenario: Identifying best-selling products by sales count
    Given I'm the store owner or an admin is logged into the Sweet Management System
    And there are products in my store with sales data
    When I request the top 5 best-selling products by sales count
    Then the system displays the top 5 products with the highest sales count
