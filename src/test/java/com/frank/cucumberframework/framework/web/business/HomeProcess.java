package com.frank.cucumberframework.framework.web.business;

import com.frank.cucumberframework.framework.web.pageobjects.HomePageHandler;
import com.frank.cucumberframework.framework.web.webdriver.BaseWebDriver;

public class HomeProcess {

	BaseWebDriver driver = null;
	HomePageHandler homeHandler = null;

	public HomeProcess(BaseWebDriver baseDriver) {
		this.driver = baseDriver;
		homeHandler = new HomePageHandler(baseDriver);
	}

	public boolean verifyUserLoginState() {
		return homeHandler.isPersonalInfoDisplayed() && homeHandler.isLogputDisplayed();
	}

}
