package Helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class DriverManager {
    public static AppiumDriver driver;

    public static void start() throws Exception {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Gagal load config.properties: " + e.getMessage());
        }

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", prop.getProperty("platformName"));
        caps.setCapability("appium:deviceName", prop.getProperty("deviceName"));
        caps.setCapability("appium:automationName", prop.getProperty("automationName"));
        caps.setCapability("appium:appPackage", prop.getProperty("appPackage"));
        caps.setCapability("appium:appActivity", prop.getProperty("appActivity"));
        caps.setCapability("appium:noReset", false);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        Utils.setDriver(driver);
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }}
