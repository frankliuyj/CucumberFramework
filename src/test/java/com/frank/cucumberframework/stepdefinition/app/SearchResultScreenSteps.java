package com.frank.cucumberframework.stepdefinition.app;

import cucumber.api.java.en.Then;
import org.testng.Assert;

import com.frank.cucumberframework.framework.app.business.SearchResultProcess;
import com.frank.cucumberframework.framework.context.AppTestContext;
import com.frank.cucumberframework.framework.context.WebTestContext;
import com.frank.cucumberframework.framework.web.business.HomeProcess;
import com.frank.cucumberframework.framework.utils.supporter.GetTestcaseInputPara;



public class SearchResultScreenSteps {

	GetTestcaseInputPara caseInput;
	AppTestContext appTestContext;
	SearchResultProcess sp;
	 
	 public SearchResultScreenSteps(AppTestContext context) {
		 appTestContext = context;
		 sp = new SearchResultProcess(appTestContext.getAppDriver());
		 caseInput = new GetTestcaseInputPara("src\\test\\resources\\properties\\app\\search_result_screen_data.properties");
	 }	


	 @Then("search result of {string} is shown in chrome app")
	 public void isSearchResultPageShown(String keyword) {
			String newUrl = appTestContext.getAppDriver().getUrl();
			if (newUrl.contains(caseInput.getProperty("url"))) {
				Assert.assertTrue(sp.verifyResultState(keyword));
			} else {
				Assert.fail("URL judgement has been failed!");
			}	     
	 }
}
