package baseTest;

import base.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;


public class BaseTest {
    public BaseTest() {
        initPages(DriverUtil.getDriver());
    }
    protected BasePage basePage;
    protected HomePage homePage;
    protected RegisterScreenPage registerScreenPage;

    protected AdminScreenPage adminScreenPage;

    protected LoginScreenPage loginScreenPage;

    protected UserScreenPage userScreenPage;

    public void initPages(WebDriver driver) {
        basePage = new BasePage();
        PageFactory.initElements(driver, basePage);
        homePage = new HomePage();
        PageFactory.initElements(driver, homePage);
        registerScreenPage = new RegisterScreenPage();
        PageFactory.initElements(driver, registerScreenPage);
        adminScreenPage = new AdminScreenPage();
        PageFactory.initElements(driver, adminScreenPage);
        loginScreenPage=new LoginScreenPage();
        PageFactory.initElements(driver,loginScreenPage);
        userScreenPage=new UserScreenPage();
        PageFactory.initElements(driver,userScreenPage);
    }
}
