package steps;

import baseTest.BaseTest;
import cucumber.api.java.en.When;

public class HomePageSteps extends BaseTest {
    @When("Click on Register button from the upper right corner")
    public void clickOnHomePageRegisterButton() {
       homePage.clickOnHomePageRegisterButton();
    }

    @When("Click on Login button from the upper right corner")
    public void clickOnHomePageLoginButton() {
        homePage.clickOnHomePageLoginButton();
    }
}
