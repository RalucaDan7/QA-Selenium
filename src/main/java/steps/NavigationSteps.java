package steps;

import base.DriverUtil;
import baseTest.BaseTest;
import common.Constants;
import common.WaitUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class NavigationSteps extends BaseTest {
    @Given("The user navigates to home page")
    public void userNavigatesToHomePage() {
        DriverUtil.getDriver().get(Constants.BASE_URL);
        WaitUtils.waitForPageToLoad();
    }

    @Then("Check title is displayed")
    public void checkTitleTextIsDisplayed() {
        homePage.checkTitleTextIsDisplayed();
    }

}
