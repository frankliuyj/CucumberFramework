package com.frank.cucumberframework.stepdefinition.web;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;

import com.frank.cucumberframework.framework.context.WebTestContext;
import com.frank.cucumberframework.framework.web.business.LoginProcess;
import com.frank.cucumberframework.framework.utils.supporter.GetTestcaseInputPara;

public class LoginPageSteps {

	private GetTestcaseInputPara caseInput = null;
	private WebTestContext webTestContext = null;
	private LoginProcess lp = null;

	public LoginPageSteps(WebTestContext context) {
		webTestContext = context;
		lp = new LoginProcess(webTestContext.getWebDriver());
		caseInput = new GetTestcaseInputPara("src\\test\\resources\\properties\\web\\login_page_data.properties");
	}

	@Given("^go to login page$")
	public void broswerToLoginPage() {

		webTestContext.getWebDriver().get(caseInput.getProperty("url"));
		if (!lp.verifyPageLoadState()) {
			Assert.fail("Login page element is missing, test could be interrupted");
		}
	}

	@When("^login with \"([^\"]*)\" \"([^\"]*)\"$")
	// @When("^login with {string} {string}$")
	public void loginWithCredential(String username, String password) {

		lp.login(username, password);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^should display error (.+)$")
	// @Then("^should display error {string}$")
	public void errorMsgJudge(String error) {

		String newUrl = webTestContext.getWebDriver().getUrl();
		if (newUrl.contains(caseInput.getProperty("url"))) {
			Assert.assertTrue(lp.verifyFailureState());
		} else {
			Assert.fail("URL judgement has been failed!");
		}

	}

}
