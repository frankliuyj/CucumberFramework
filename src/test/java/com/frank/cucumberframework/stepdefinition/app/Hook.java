package com.frank.cucumberframework.stepdefinition.app;

import com.frank.cucumberframework.framework.context.AppTestContext;
import com.frank.cucumberframework.framework.utils.supporter.TakeScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

	private AppTestContext appTestContext = null;

	public Hook(AppTestContext context) {
		appTestContext = context;
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
			TakeScreenshot.takeScreenshot(appTestContext.getAppDriver().getDriver());
		    }
		appTestContext.getAppDriver().stop();
	}

	
}
