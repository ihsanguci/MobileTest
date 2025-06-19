package StepDefinitions;

import Helper.DriverManager;

import Helper.Utils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {
    AppiumDriver driver;
//    LoginPage loginPage;

    @Before
    public void setup() throws Exception {
        DriverManager.start();
        driver = DriverManager.getDriver();
    }

    @After
    public void teardown() {
        DriverManager.quit();
    }

    @Given("User Already in main screen")
    public void user_is_on_login_screen() {
    }

    @When("^(.*) User click (.*)?")
    public void userClick(String yamlPath, String locatorName) {
        Utils.waitUntilVisibleFromYaml(yamlPath, locatorName,5);
        Utils.clickFromYaml(yamlPath, locatorName);
    }
    @When("^User generate password (.*)?")
    public void generatePassword(String password) {
        Utils.waitUntilVisible(By.xpath("//android.widget.TextView[@text=\"1\"]"),5);
        String[] pass = password.split("");
        for(int i=1 ; i<=6 ; i++){
            driver.findElement(By.xpath("//android.widget.TextView[@text=\""+pass[i]+"\"]")).click();
        }
    }

    @When("^(.*) User verify element is visible (.*)?")
    public void isVisible(String yamlPath, String locatorName) {
        Utils.waitUntilVisibleFromYaml(yamlPath, locatorName,5);
        Utils.verifyElementExist(yamlPath, locatorName);
    }

    @When("^(.*) User verify text (.*) using locator (.*)?")
    public void isVisible(String yamlPath, String expected, String locatorName) {
        Utils.waitUntilVisibleFromYaml(yamlPath, locatorName,10);
        assertEquals(expected, Utils.getText(yamlPath,locatorName));
    }




}
