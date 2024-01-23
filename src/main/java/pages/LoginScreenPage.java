package pages;

import common.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreenPage {
    @FindBy(css = "button[id=\"login-btn\"]")
    private WebElement loginPageLoginButton;

    public void clickOnLoginPageLoginButton() {
        loginPageLoginButton.click();
    }
}
