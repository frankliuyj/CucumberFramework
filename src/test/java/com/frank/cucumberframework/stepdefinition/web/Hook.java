package com.frank.cucumberframework.stepdefinition.web;

import com.frank.cucumberframework.framework.context.WebTestContext;
import com.frank.cucumberframework.framework.utils.supporter.TakeScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

	private WebTestContext webTestContext = null;

	public Hook(WebTestContext context) {
		webTestContext = context;
	}

	@Before
	public void preparePrecondtion() {
		
	}

	

	@After
	public void executePostcondition(Scenario scenario) {
		if (scenario.isFailed()) {
		      // Take a screenshot...
		      //final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
		      //scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
				TakeScreenshot.takeScreenshot(webTestContext.getWebDriver().getDriver());
		    }
		webTestContext.getWebDriver().stop();
	}

	
}
