package com.common.core;

import com.common.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class webDriverExtension {

    private static WebDriver driver;

    /**
     * The ChromeDriver is initialized and set up with options in the constructor.
     */
    public webDriverExtension() {
        String path = Utils.DRIVER_DIR + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = getChromeOptions();
        driver = new ChromeDriver(options);
    }

    /**
     * Returns the WebDriver.
     */
    public WebDriver getInstance() {
        return driver;
    }

    /**
     * Creates and configures ChromeOptions for the WebDriver.
     *
     * @return ChromeOptions with desired configurations.
     */
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        if (isHeadless()) {
            options.setHeadless(isHeadless());
        }
        // Add any other desired options here
        // options.addArguments("--start-maximized");
        return options;
    }

    /**
     * Checks if the headless mode is enabled or not.
     *
     * @return True if headless mode is enabled, otherwise false.
     */
    private boolean isHeadless() {
        String isHeadless = System.getProperty("headless");
        return "true".equals(isHeadless);
    }
}