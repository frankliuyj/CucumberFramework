package com.frank.cucumberframework.stepdefinition.web;

import cucumber.api.java.en.Then;
import org.testng.Assert;

import com.frank.cucumberframework.framework.context.WebTestContext;
import com.frank.cucumberframework.framework.web.business.HomeProcess;
import com.frank.cucumberframework.framework.utils.supporter.GetTestcaseInputPara;



public class HomePageSteps {

	GetTestcaseInputPara caseInput;
	WebTestContext webTestContext;
	HomeProcess hp;
	 
	 public HomePageSteps(WebTestContext context) {
		 webTestContext = context;
		 hp = new HomeProcess(webTestContext.getWebDriver());
		 caseInput = new GetTestcaseInputPara("src\\test\\resources\\properties\\web\\home_page_data.properties");
	 }	


	@Then("^redirect to dashboard page$")
	public void enterIntoDashboard() {
		String destinationKeywords = caseInput.getProperty("destination_keyword");

		String newUrl = webTestContext.getWebDriver().getUrl();
		if (newUrl.contains(destinationKeywords)) {
			Assert.assertTrue(hp.verifyUserLoginState());
		} else {
			Assert.fail("URL judgement has been failed!");
		}
	}
}
