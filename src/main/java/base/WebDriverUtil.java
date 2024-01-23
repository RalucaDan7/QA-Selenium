package base;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class WebDriverUtil extends DriverUtil {
    public WebDriver initWebDriver(Scenario scenario) {
        MutableCapabilities options = setupMutableCapabilitiesForChrome(scenario, getBuildNumber());
        switch (ConfigManager.getBrowser().toLowerCase()) {
            case "chrome":
                switch (ConfigManager.getExecution().toLowerCase()) {
                    case "jenkins":
                        break;
                    case "local":
                        System.setProperty("webdriver.chrome.silentOutput", "true");
                        WebDriverManager.chromedriver().setup();
                        tlDriver.set(new ChromeDriver((ChromeOptions) options));
                        break;
                    default: {
                        System.out.println("No info for driver.");
                        break;
                    }
                }
                break;
            default:
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver((FirefoxOptions) options));
                break;
        }
        tlDriver.get().manage().timeouts().setScriptTimeout(ConfigManager.DEFAULT_WAIT, TimeUnit.SECONDS);
        tlDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        tlDriver.get().manage().window().maximize();
        return tlDriver.get();
    }

    private MutableCapabilities setupMutableCapabilitiesForChrome(Scenario scenario, String buildnr) {
        MutableCapabilities options;
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--start-maximized");
        optionsChrome.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
//        optionsChrome.addArguments("--headless");        optionsChrome.addArguments("--disable-infobars");
        optionsChrome.addArguments("--disable-cache");


        Map<String, Object> prefs = new HashMap<>();
        Map<String, Object> profile = new HashMap<>();

        prefs.put("profile", profile);
        optionsChrome.setExperimentalOption("prefs", prefs);

        optionsChrome.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
        options = setWebDriverOptions(optionsChrome, scenario, buildnr);   //set the aws_proxy_muc
        return options;
    }

    private MutableCapabilities setWebDriverOptions(MutableCapabilities options, Scenario scenario, String buildnr) {
        options.setCapability("browserName", ConfigManager.getBrowser());
        return options;
    }
}
