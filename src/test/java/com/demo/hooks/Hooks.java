package com.demo.hooks;

import com.demo.context.TestContext;
import com.demo.driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;
    private final TestContext testContext;

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void beforeScenario(){
        driver = DriverManager.initializeDriver(System.getProperty("browser", "chrome"));
        testContext.driver = driver;
    }

    @After
    public void afterScenario(){
        testContext.driver.quit();
    }
}
