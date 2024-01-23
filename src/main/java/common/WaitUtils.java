package common;

import base.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import static java.lang.Thread.sleep;

public class WaitUtils {
    public static void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        };
        try {
            sleep(1000);
            WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
    public static void waitForVisibilityOfElement(WebDriver driver, WebElement element) {

        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(300));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }


}
