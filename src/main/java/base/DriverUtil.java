package base;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverUtil {
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    protected String getBuildNumber() {
        // here the build_number is set to the one defined in Jenkins
        String buildnr = System.getenv("BUILD_NUMBER");
        if ("".equals(buildnr) || buildnr == null) {
            buildnr = "" + System.currentTimeMillis();
        }
        return buildnr;
    }

    public static void closeDriver(WebDriver webDriver) {
        if (webDriver != null) {
            try {
                webDriver.quit();
                webDriver = null;
            } catch (NoSuchMethodError | NoSuchSessionException | SessionNotCreatedException ex) {
                System.out.println("An error occured while closing the driver: " + ex);
            }
        }
    }

    public static String getRunningBrowserVersion() {
        return ((RemoteWebDriver) getDriver()).getCapabilities().getBrowserVersion();
    }
}
