package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//button[@id=\"header-register-btn\"]")
    private WebElement homePageRegisterButton;
    @FindBy(css = "span[id=\"company-name\"]")
    private WebElement titleText;

    @FindBy(xpath = "//button[@id=\"header-login-btn\"]")
    private WebElement homePageLoginButton;

    public void clickOnHomePageRegisterButton() {
        homePageRegisterButton.click();
    }

    public void checkTitleTextIsDisplayed() {
        Assert.assertTrue("The title message is not displayed", titleText.isDisplayed());
    }

    public void clickOnHomePageLoginButton() {
        homePageLoginButton.click();
    }
}
