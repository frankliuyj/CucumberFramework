package com.frank.cucumberframework.framework.web.pageobjects;

import com.frank.cucumberframework.framework.web.webdriver.BaseWebDriver;

public class HomePageHandler {

	public BaseWebDriver driver = null;
	public HomePage homePage = null;

	public HomePageHandler(BaseWebDriver baseDriver) {
		this.driver = baseDriver;
		homePage = new HomePage(driver);
	}

	public boolean isPersonalInfoDisplayed() {

		return homePage.isPersonalInfoDisplayed();
	}

	public boolean isLogputDisplayed() {

		return homePage.isLogoutDisplayed();
	}

}
