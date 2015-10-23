package com.epam.singleton.driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kateryna_Symonova on 10/6/2015.
 */
public class SingletonWebDriver {
    private static WebDriver driver = null;

    private SingletonWebDriver () {}

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeWebBrowser(){
        driver.quit();
        driver = null;
    }

    public static WebDriver restartWebDriver (){
        closeWebBrowser();
        return getWebDriverInstance();
    }

}
