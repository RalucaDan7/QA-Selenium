package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ConfigManager {
    public static final long DEFAULT_WAIT = 20;
    private static final String path;
    private static String browser;
    private static String baseUrl;
    private static final String execution;
    private static String confFile;

    static {
        path = loadSystemProperties();
        baseUrl = System.getProperty("testautomation.baseUrl");
        browser = System.getProperty("testautomation.browser");
        execution = System.getProperty("testautomation.execution");
    }

    private static String loadSystemProperties() {
        String path = "";
        String confFileName;

        try {
            File file;
            path = "src/main/resources/";
            confFileName = "testautomationLocal.properties";
            confFile = path + confFileName;
            file = new File(confFile);

            if (!file.exists()) {
                path = "./src/main/resources/";
                confFile = path + confFileName;
                file = new File(confFile);
            }
            FileInputStream fileInput = new FileInputStream(file);
            Properties sysProperties = new Properties();
            sysProperties.load(fileInput);
            @SuppressWarnings("rawtypes") Enumeration keys = sysProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                String value = sysProperties.getProperty(key);
                System.setProperty(key, value);
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
        return path;
    }

    public static String getBrowser() {
        if (browser == null || browser.isEmpty()) {
            System.out.println("The browser was not specified in " + confFile);
            System.exit(0);
        }
        return browser;
    }


    public static String getBaseUrl() {
        if (baseUrl == null || baseUrl.isEmpty()) {
            System.out.println("The base url of the target test application was not specified or is empty in " + confFile);
            System.exit(0);
        }
        return baseUrl;
    }

    public static String getExecution() {
        if (execution == null || execution.isEmpty()) {
            System.out.println("Execution is not provided in " + confFile);
            System.exit(0);
        }
        return execution;
    }
}
