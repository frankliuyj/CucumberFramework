package com.frank.cucumberframework.framework.web.business;

import com.frank.cucumberframework.framework.web.pageobjects.LoginPageHandler;
import com.frank.cucumberframework.framework.web.webdriver.BaseWebDriver;

public class LoginProcess {

	BaseWebDriver driver = null;
	LoginPageHandler loginHandler = null;

	public LoginProcess(BaseWebDriver baseDriver) {
		this.driver = baseDriver;
		loginHandler = new LoginPageHandler(baseDriver);
	}

	public boolean verifyPageLoadState() {
		return loginHandler.isUsernameDisplayed() && loginHandler.isPasswordDisplayed()
				&& loginHandler.isSubmitButtonDisplayed();
	}

	public void login(String username, String password) {
		loginHandler.clearUsername();
		loginHandler.inputUsername(username);
		loginHandler.clearPassword();
		loginHandler.inputPassword(password);
		loginHandler.clickSubmitBtn();
	}

	public boolean verifyFailureState() {

		return loginHandler.isErrorMsgDisplayed();
	}

}
