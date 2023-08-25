package com.common.stepdefinitions;


import com.common.core.RestAssuredExtension;
import com.common.core.WebDriverExtension;
import com.common.pages.LoginPage;
import com.common.pages.SecurePage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    static WebDriver driver;
    static LoginPage loginPage;
    static SecurePage securePage;
    static RestAssuredExtension restAssured;
    static Response response;

    /**
     * Sets up the web driver and initialize the page objects.
     */
    @Before("@UI")
    public static void setUpUi() {
        driver = new WebDriverExtension().getInstance();
        loginPage = new LoginPage(driver);
        securePage = new SecurePage(driver);
    }

    /**
     * Tears down the selenium after the test is finished.
     * Attach a screenshot in case a test fails.
     * Also deletes the cookies.
     *
     * @param result is the result of the last UI test run
     */
    @After("@UI")
    public static void tearDownUI(Scenario result) {
        if (result.isFailed()) {
            final byte[] SCREENSHOT = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            result.attach(SCREENSHOT, "image/png", "Screenshot");
        }
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    /**
     * Sets up the Rest Assured for the api tests, by initializing the Rest Assured.
     */
    @Before("@API")
    public static void setUpApi() {
        restAssured = new RestAssuredExtension();
    }

}
