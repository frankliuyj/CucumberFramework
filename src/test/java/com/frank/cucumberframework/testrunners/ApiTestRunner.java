package com.frank.cucumberframework.testrunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src\\test\\resources\\features\\api_contact_curd.feature",
        glue = "classpath:com/frank/cucumberframework/stepdefinition/api" ,
        plugin = {
	                "pretty",
	                "html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/CucumberTestReport.json",
	                "rerun:target/cucumber-reports/rerun.txt",
                },
        monochrome = true
)
public class ApiTestRunner extends AbstractTestNGCucumberTests{

}