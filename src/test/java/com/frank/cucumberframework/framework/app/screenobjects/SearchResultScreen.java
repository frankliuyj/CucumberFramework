package com.frank.cucumberframework.framework.app.screenobjects;

import org.openqa.selenium.By;

import com.frank.cucumberframework.framework.app.androiddriver.BaseAppDriver;
import com.frank.cucumberframework.framework.utils.supporter.GetByLocator;

import io.appium.java_client.android.AndroidElement;


public class SearchResultScreen extends BaseScreen {

	public SearchResultScreen(BaseAppDriver driver) {
		super(driver);
		if (elementLocator == null)
			elementLocator = new GetByLocator("src\\test\\resources\\properties\\app\\search_result_screen_element.properties");
	}

	public AndroidElement getBottomInputElement() {
		// Generate By object according to property file's definition
		By by = elementLocator.getLocator("input_box2");
		return element(by);
	}



}
