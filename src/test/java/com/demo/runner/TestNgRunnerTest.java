package com.demo.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
                    glue = {"com/demo/stepDefinitions", "com/demo/hooks"},
                    plugin = {"html:target/cucumber.html"},
                    dryRun = false
                    )

public class TestNgRunnerTest extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}