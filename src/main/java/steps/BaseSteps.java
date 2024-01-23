package steps;

import base.DriverUtil;
import baseTest.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class BaseSteps extends BaseTest {
    @Then("Check {string} page is visible")
    public void checkPageIsVisible(String page) {
        basePage.checkPageIsVisible(page);
    }


}
