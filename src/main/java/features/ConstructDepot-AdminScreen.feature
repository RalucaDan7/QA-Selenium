Feature: ConstructDepot-AdminScreen

  Background:
    Given The user navigates to home page
    When Click on Login button from the upper right corner
    And Click on Username field and type "admin123"
    And Click on password field and type "admin@pass"
    And Click on Login button

  Scenario: ConstructDepot-AdminScreen-01-successfully addition of new products with admin credentials
    And Click on Add new product button
    And Click on Product name field and type "Silicon sanitar alb"
    And Click on Product description field and type "•Tip produs: Material de etanşare •Model: Silicon •Ingrediente:Silicon cu structură reticulată acetică"
    And Click on Product Action Price and type "80"
    And Click on Product Discounted Price and type "68"
    And Drag and drop a file in the specific box
    And Click on Add Product Button
    And Click on Products button
    Then Check "Silicon sanitar alb" is displayed