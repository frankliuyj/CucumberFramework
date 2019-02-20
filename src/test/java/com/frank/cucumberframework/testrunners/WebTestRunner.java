package com.frank.cucumberframework.testrunners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
        features = "src\\test\\resources\\features\\web_login.feature",
        glue = "classpath:com/frank/cucumberframework/stepdefinition/web" ,
        plugin = {
	                "pretty",
	                "html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/CucumberTestReport.json",
	                "rerun:target/cucumber-reports/rerun.txt",
                },
        monochrome = true,
        tags = "@success"
)
public class WebTestRunner extends AbstractTestNGCucumberTests{

}