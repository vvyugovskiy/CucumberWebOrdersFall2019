@addOrder

Feature: Add order
  As user, I want to be able to create new orders

  Scenario: Create order
    Given user is on the login page
    And user logs in
    And user navigates to "Order" page
    When user enters product information:
      | Product     | Quantity | Price per unit | Discount |
      | ScreenSaver | 12       | 20             | 10      |
    And user click on calculate button
    Then user should verify that total "216" is displayed
    When user enters address information:
      | Customer name | Street | City     | State    | Zip   |
      | Test User     | 5 Ave  | New York | New York | 10011 |
    And user enters payment information:
      | Card | Card Nr:    | Expire date (mm/yy) |
      | Visa | 12345667890 | 04/25               |
    And user click on process button
    And use navigates to "View all orders" page
    Then user verifies that order is displayed
      | Name      | Product     |
      | Test User | ScreenSaver |