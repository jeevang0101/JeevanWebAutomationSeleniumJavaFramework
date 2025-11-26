package com.demo.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("Invalid Browser : " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

/*
*
* BELOW CODE IS USED WHEN USING THREADLOCAL Class
* INSTEAD OF PICOCONTAINER DEPENDENCY INJECTION (DI) TO SUPPORT PARALLEL EXECUTION
*
*/

//    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//
//    public static void setDriver(WebDriver driverInstance) {
//        driver.set(driverInstance);
//    }
//
//    public static void unload() {
//        driver.remove();
//    }
}