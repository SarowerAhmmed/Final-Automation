package com.test.run;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "json:target/cucumber.json" }, // for report
features = { "./src/main/resources/Online_Banking_Login.feature" 
}, //
glue = { "com.test.run" }, tags = { "@Smoke", "@Positive" }, 
dryRun = false, // true only when no step def
strict = true, // only step def
monochrome = true)


public class Runner extends AbstractTestNGCucumberTests {

}