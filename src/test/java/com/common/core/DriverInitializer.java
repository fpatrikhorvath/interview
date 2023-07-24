package com.common.core;

import com.common.Utils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverInitializer {
    private WebDriver driver;
    public DriverInitializer(){
        this.driver = setUpWebdriver();
        Dimension screenSize = new Dimension(Utils.SCREEN_WIDTH,Utils.SCREEN_HEIGHT);
        this.driver.manage().window().setSize(screenSize);
    }

    private WebDriver setUpWebdriver() {
        String path = Utils.DRIVER_DIR + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = getChromeOptions();
        return new ChromeDriver(options);
    }

    private boolean isHeadless() {
        String isHeadless = System.getProperty("headless");
        if ("true".equals(isHeadless)) {
            return true;
        } else if ("false".equals(isHeadless)) {
            return false;
        } else {
            throw new WebDriverException("Invalid value for 'headless' property. It should be 'true' or 'false'.");
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(isHeadless());
        return options;
    }
    public WebDriver getDriver(){
        return driver;
    }
}
