package com.common.stepdefinitions;


import com.common.core.RestAssuredExtension;
import com.common.core.WebDriverSingleton;
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

    @Before("@UI")
    public static void setUpUi() {
        driver = new WebDriverSingleton().getInstance();
        loginPage = new LoginPage(driver);
        securePage = new SecurePage(driver);
    }

    @After("@UI")
    public static void tearDownUI(Scenario result) {
        if(result.isFailed()){
            final byte[] SCREENSHOT = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            result.attach(SCREENSHOT, "image/png", "Screenshot");
        }
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
    @Before("@API")
    public static void setUpApi() {
        restAssured = new RestAssuredExtension();
    }

}
