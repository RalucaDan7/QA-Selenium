Feature: ConstructDepot-LoginScreen

  Background:
    Given The user navigates to home page

  Scenario: ConstructDepot-LoginScreen-01-Admin login successfully
    When Click on Login button from the upper right corner
    And Click on Username field and type "admin123"
    And Click on password field and type "admin@pass"
    And Click on Login button
    Then Check "http://localhost:4200/admin" page is visible

  Scenario: ConstructDepot-LoginScreen-02-User login successfully
    When Click on Login button from the upper right corner
    And Click on Username field and type "user123"
    And Click on password field and type "user@pass"
    And Click on Login button
    Then Check "http://localhost:4200" page is visible

  Scenario: ConstructDepot-LoginScreen-03-Login unsuccessfully with non existing credentials
    When Click on Login button from the upper right corner
    And Click on Username field and type "iulia5"
    And Click on password field and type "iulia@pass"
    And Click on Login button
    Then Check "http://localhost:4200/login" page is visible