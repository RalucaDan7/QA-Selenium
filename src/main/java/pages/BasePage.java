package pages;

import base.DriverUtil;
import common.WaitUtils;
import org.junit.Assert;

public class BasePage {
    public void checkPageIsVisible(String pageName){
        WaitUtils.waitForPageToLoad();
        Assert.assertTrue("The URL of " + pageName + " is not correct", DriverUtil.getDriver().getCurrentUrl().contains(pageName));
    }
}
