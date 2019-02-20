package com.frank.cucumberframework.framework.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.frank.cucumberframework.framework.utils.supporter.GetByLocator;
import com.frank.cucumberframework.framework.web.webdriver.BaseWebDriver;

public class HomePage extends BasePage {

	public HomePage(BaseWebDriver driver) {
		super(driver);
		if (elementLocator == null)
			elementLocator = new GetByLocator("src\\test\\resources\\properties\\web\\home_page_element.properties");
	}

	public WebElement getAccountElement() {
		// Generate By object according to property file's definition
		By by = elementLocator.getLocator("personal_info");
		return element(by);
	}

	public boolean isLogoutDisplayed() {
		return assertExisted(getLogoutElement());
	}

	public WebElement getLogoutElement() {
		// Generate By object according to property file's definition
		By by = elementLocator.getLocator("logout");
		return element(by);
	}

	public boolean isPersonalInfoDisplayed() {
		return assertExisted(getAccountElement());
	}
}
