package pages;

import base.DriverUtil;
import common.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;

public class RegisterScreenPage {

    @FindBy(css = "input[id=\"firstName\"]")
    private WebElement firstNameField;

    @FindBy(css = "input[id=\"lastName\"]")
    private WebElement lastNameField;

    @FindBy(css = "input[id=\"email\"]")
    private WebElement emailField;

    @FindBy(css = "input[id=\"userName\"]")
    private WebElement usernameField;

    @FindBy(css = "input[id=\"nickName\"]")
    private WebElement nicknameField;

    @FindBy(xpath = "(//span[@class=\"mat-mdc-button-touch-target\"])[3]")
    private WebElement calendarIcon;

    @FindBy(xpath = "(//button/span[contains(text(),'9')])[3]")
    private WebElement calendarDate;

    @FindBy(css = "input[id=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id=\"login-btn\"]")
    private WebElement registerPageRegisterButton;

    public void firstNameFieldClickAndType(String firstName) {
        firstNameField.click();
        firstNameField.sendKeys(firstName);
    }

    public void lastNameFieldClickAndType(String lastName) {
        lastNameField.click();
        lastNameField.sendKeys(lastName);
    }

    public void emailFieldClickAndType(String email) {
        emailField.click();
        emailField.sendKeys(email);
    }

    public void usernameFieldClickAndType(String username) {
        usernameField.click();
        usernameField.sendKeys(username);
    }

    public void nicknameFieldClickAndType(String nickname) {
        nicknameField.click();
        nicknameField.sendKeys(nickname);
    }

    public void calendarFieldClick() {
        calendarIcon.click();
        calendarDate.click();
    }

    public void passwordFieldClickAndType(String password) {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", passwordField);
        WaitUtils.waitForVisibilityOfElement(DriverUtil.getDriver(), passwordField);
        Actions action = new Actions(DriverUtil.getDriver());
        action.moveToElement(passwordField).click();
        passwordField.sendKeys(password);
    }

    public void clickTheRegisterButton() {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", registerPageRegisterButton);
        Actions action = new Actions(DriverUtil.getDriver());
        action.moveToElement(registerPageRegisterButton).click();
        DriverUtil.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WaitUtils.waitForPageToLoad();

    }
}
