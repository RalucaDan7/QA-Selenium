package steps;

import baseTest.BaseTest;
import cucumber.api.java.en.And;

public class LoginScreenSteps extends BaseTest {
    @And("Click on Login button")
    public void clickOnLoginPageLoginButton() {
        loginScreenPage.clickOnLoginPageLoginButton();
    }
}
