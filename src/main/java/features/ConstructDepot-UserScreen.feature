Feature: ConstructDepot-UserScreen

  Background:
    Given The user navigates to home page
    When Click on Login button from the upper right corner
    And Click on Username field and type "user123"
    And Click on password field and type "user@pass"
    And Click on Login button

  Scenario: ConstructDepot-UserScreen-01-View product details
    And Click on Products button
    And Hover on "Găleată mortar" and click on View Details button
    Then Check "Găleată mortar" is displayed on individual product page

  Scenario: ConstructDepot-UserScreen-02-Place succesfully an order
    And Click on Products button
    And Hover on "Găleată mortar" and click on View Details button
    And  Click on Buy now button
    And Click on Full Name field and type "Raluca Dan"
    And Click on Address field and type "Str Primaverii nr 3"
    And Click on Contact number field and type "0747485692"
    And Click on Quantity field and type "4"
    And Click on Place Order button
    Then Check "http://localhost:4200/orderConfirmed" page is visible

  Scenario: ConstructDepot-UserScreen-03-Logout successfully
    And Click on Products button
    And Click on Logout button from header
    Then Check Login button is visible

  Scenario: ConstructDepot-UserScreen-04-Home Page redirect
    And Click on Products button
    And Hover on "Găleată mortar" and click on View Details button
    And Click on Depozit materiale de constructii from header
    Then Check "http://localhost:4200" page is visible

  Scenario: ConstructDepot-UserScreen-05-Refresh Page
    And Click on refresh button
    Then Check "http://localhost:4200" page is visible

  Scenario: ConstructDepot-UserScreen-06-Filter the products by category
    And Click on Products button
    And Click on Category dropdown button
    And Select "TOOLS"
    Then Check only "TOOLS" are displayed

  Scenario: ConstructDepot-UserScreen-07-Add product to cart
    And Click on Products button
    And Hover on "Beton" and click on View Details button
    And Click on Add to Cart button
    And Click on Cart button from header
    Then Check "Beton" is in the cart

  Scenario: ConstructDepot-UserScreen-08-Add multiple products to cart
    And Click on Products button
    And Hover on "Beton uscat 30kg" and click on View Details button
    And Click on Add to Cart button
    And Click on Products button
    And Hover on "Găleată mortar" and click on View Details button
    And Click on Add to Cart button
    And Click on Cart button from header
    Then Check "Beton uscat 30kg" is in the cart
    Then Check "Găleată mortar" is in the cart
