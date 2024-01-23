Feature: ConstructDepot-RegisterScreen

  Background:
    Given The user navigates to home page

  Scenario: ConstructDepot-RegisterScreen-01-Account creation successfully
    When Click on Register button from the upper right corner
    And Click on First name field and type "Raluca"
    And Click on Last name field and type "Dan"
    And Click on Email field and type "ralucadan7@yahoo.com"
    And Click on Username field and type "Ralu7"
    And Click on Nickname field and type "Ralu"
    And Click on calendar icon from birth date field and select any date
    And Click on password field and type "raluca@pass"
    And Click on Register button
    Then Check "http://localhost:4200" page is visible

    Scenario: ConstructDepot-Register screen-02–Account creation failed with an invalid email address
      When Click on Register button from the upper right corner
      And Click on First name field and type "Denis"
      And Click on Last name field and type "Stoia"
      And Click on Email field and type "denis85-"
      And Click on Username field and type "Denis23"
      And Click on Nickname field and type "Denis"
      And Click on calendar icon from birth date field and select any date
      And Click on password field and type "denis@pass"
      And Click on Register button
      Then Check "http://localhost:4200/register" page is visible

  Scenario: ConstructDepot-Register screen-03-Account creation failed with an used email address
    When Click on Register button from the upper right corner
    And Click on First name field and type "Ion"
    And Click on Last name field and type "Popescu"
    And Click on Email field and type "ralucadan7@yahoo.com"
    And Click on Username field and type "IonPopescu"
    And Click on Nickname field and type "Ion"
    And Click on calendar icon from birth date field and select any date
    And Click on password field and type "ion@pass"
    And Click on Register button
    Then Check "http://localhost:4200/register" page is visible





