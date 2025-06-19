package Helper;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.time.Duration;
import java.util.Map;

public class Utils {

    private static AppiumDriver driver;

    public static void setDriver(AppiumDriver driverInstance) {
        driver = driverInstance;
    }

//    public static AppiumDriver getDriver() {
//        if (driver == null) {
//            throw new RuntimeException("Driver is null. Panggil setDriver() dulu sebelum digunakan.");
//        }
//        return driver;
//    }

    public static Map<String, Object> getLocatorMap(String yamlPath) {
        InputStream input = Utils.class.getClassLoader()
                .getResourceAsStream("locators/" + yamlPath + ".yaml");

        if (input == null) {
            throw new RuntimeException("Locator YAML not found: " + yamlPath);
        }

        Yaml yaml = new Yaml();
        return yaml.load(input);
    }

    public static By getBy(String yamlPath, String locatorName) {
        Map<String, Object> locators = getLocatorMap(yamlPath);
        String raw = (String) locators.get(locatorName);

        if (raw == null) {
            throw new RuntimeException("Locator name not found: " + locatorName);
        }

        String[] parts = raw.split(":", 2);
        String by = parts[0].trim().toLowerCase();
        String value = parts[1].trim();

        switch (by) {
            case "xpath":
                return By.xpath(value);
            default:
                throw new RuntimeException("Unsupported locator type: " + by);
        }
    }

    public static WebElement waitUntilVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitUntilVisibleFromYaml(String yamlPath, String locatorName, int timeoutInSeconds) {
        By locator = Utils.getBy(yamlPath, locatorName);
        return waitUntilVisible(locator, timeoutInSeconds);
    }

    public static void clickFromYaml(String yamlPath, String locatorName) {
        By locator = getBy(yamlPath, locatorName);
        driver.findElement(locator).click();
    }

    public static void verifyElementExist(String yamlPath, String locatorName) {
        By locator = getBy(yamlPath, locatorName);
        driver.findElement(locator).isDisplayed();
    }

    public static String getText(String yamlPath, String locatorName) {
        By locator = getBy(yamlPath, locatorName);
        String text = driver.findElement(locator).getText();
        return text;
    }




}