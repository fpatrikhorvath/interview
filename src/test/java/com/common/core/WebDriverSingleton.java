package com.common.core;

import com.common.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * WebDriverSingleton is a singleton class responsible for managing the ChromeDriver instance.
 * It ensures that only one instance of ChromeDriver is created and reused across the application.
 */
public class WebDriverSingleton {

    private static WebDriver driver;

    /**
     * Private constructor to prevent external instantiation of this class.
     * The ChromeDriver is initialized and set up with options in the constructor.
     */
    public WebDriverSingleton() {
        String path = Utils.DRIVER_DIR + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = getChromeOptions();
        driver = new ChromeDriver(options);
    }

    /**
     * Returns the instance of the WebDriver. If the instance is null, it creates a new one.
     *
     * @return The singleton instance of WebDriver.
     */
    public WebDriver getInstance() {
    //    if (driver == null) {
    //        synchronized (WebDriverSingleton.class) {
    //            if (driver == null) {
     //               new WebDriverSingleton();
     //           }
     //       }
     //   }
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