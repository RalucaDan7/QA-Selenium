package steps;

import base.DriverUtil;
import baseTest.BaseTest;
import common.WaitUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class RegisterScreenSteps extends BaseTest {

    @And("Click on First name field and type {string}")
    public void firstNameFieldClickAndType(String firstName) {
        registerScreenPage.firstNameFieldClickAndType(firstName);
    }

    @And("Click on Last name field and type {string}")
    public void lastNameFieldClickAndType(String lastName) {
        registerScreenPage.lastNameFieldClickAndType(lastName);
    }

    @And("Click on Email field and type {string}")
    public void emailFieldClickAndType(String email) {
        registerScreenPage.emailFieldClickAndType(email);
    }

    @And("Click on Username field and type {string}")
    public void usernameFieldClickAndType(String username) {
        registerScreenPage.usernameFieldClickAndType(username);
    }

    @And("Click on Nickname field and type {string}")
    public void nicknameFieldClickAndType(String nickname) {
        registerScreenPage.nicknameFieldClickAndType(nickname);
    }

    @And("Click on calendar icon from birth date field and select any date")
    public void calendarFieldClick() {
        registerScreenPage.calendarFieldClick();
    }

    @And("Click on password field and type {string}")
    public void passwordFieldClickAndType(String password) {
        registerScreenPage.passwordFieldClickAndType(password);
    }

    @And("Click on Register button")
    public void clickTheRegisterButton() {
        registerScreenPage.clickTheRegisterButton();
    }

}