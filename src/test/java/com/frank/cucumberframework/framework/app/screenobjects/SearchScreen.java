package com.frank.cucumberframework.framework.app.screenobjects;

import org.openqa.selenium.By;

import com.frank.cucumberframework.framework.app.androiddriver.BaseAppDriver;
import com.frank.cucumberframework.framework.utils.supporter.GetByLocator;

import io.appium.java_client.android.AndroidElement;


public class SearchScreen extends BaseScreen {

	public SearchScreen(BaseAppDriver driver) {
		super(driver);
		if (elementLocator == null)
			elementLocator = new GetByLocator("src\\test\\resources\\properties\\app\\search_screen_element.properties");
	}

	public AndroidElement getInputElement() {
		// Generate By object according to property file's definition
		By by = elementLocator.getLocator("input_box");
		return element(by);
	}

	public AndroidElement getSearchBtnElement() {
		// Generate By object according to property file's definition
		By by = elementLocator.getLocator("submit_button");
		return element(by);
	}

}
