package com.frank.cucumberframework.framework.web.pageobjects;

import com.frank.cucumberframework.framework.web.webdriver.BaseWebDriver;


public class LoginPageHandler {

	public BaseWebDriver driver = null;
	public LoginPage loginPage = null;

	public LoginPageHandler(BaseWebDriver driver) {
		this.driver = driver;
		loginPage = new LoginPage(driver);
	}

	public boolean isUsernameDisplayed() {
		return loginPage.assertExisted(loginPage.getUsernameElement());
	}

	public boolean isPasswordDisplayed() {
		return loginPage.assertExisted(loginPage.getPasswordElement());
	}

	public boolean isSubmitButtonDisplayed() {
		return loginPage.assertExisted(loginPage.getSubmitButtonElement());
	}

	public void inputUsername(String username) {
		loginPage.sendKeys(loginPage.getUsernameElement(), username);
	}

	public void clearUsername() {
		loginPage.clear(loginPage.getUsernameElement());
	}

	public void inputPassword(String password) {
		loginPage.sendKeys(loginPage.getPasswordElement(), password);
	}

	public void clearPassword() {
		loginPage.clear(loginPage.getPasswordElement());
	}

	public void clickSubmitBtn() {
		loginPage.click(loginPage.getSubmitButtonElement());
	}

	public boolean isErrorMsgDisplayed() {

		return loginPage.assertExisted(loginPage.getErrorMsgElement());
	}

}
