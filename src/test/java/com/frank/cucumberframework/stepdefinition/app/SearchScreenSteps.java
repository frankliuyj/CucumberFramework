package com.frank.cucumberframework.stepdefinition.app;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;

import com.frank.cucumberframework.framework.app.business.SearchProcess;
import com.frank.cucumberframework.framework.context.AppTestContext;
import com.frank.cucumberframework.framework.utils.supporter.GetTestcaseInputPara;

public class SearchScreenSteps {

	private GetTestcaseInputPara caseInput = null;
	private AppTestContext appTestContext = null;
	private SearchProcess sp = null;

	public SearchScreenSteps(AppTestContext context) {
		appTestContext = context;
		sp = new SearchProcess(appTestContext.getAppDriver());
		caseInput = new GetTestcaseInputPara("src\\test\\resources\\properties\\app\\search_screen_data.properties");
	}
	
	@Given("visit baidu search engine homepage")
	public void browserToSearchPage() {
		appTestContext.getAppDriver().get(caseInput.getProperty("url"));
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (!sp.verifyPageLoadState()) {
			Assert.fail("Search page element is missing, test could be interrupted");
		}
	}

	@When("input a keyword {string}")
	public void inputKeyword(String keyword) {
		sp.inputKeyword(keyword);

	}

	@When("click search botton")
	public void click_search_botton() {
		sp.startSearch();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
