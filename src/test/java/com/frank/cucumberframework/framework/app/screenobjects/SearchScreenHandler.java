package com.frank.cucumberframework.framework.app.screenobjects;

import com.frank.cucumberframework.framework.app.androiddriver.BaseAppDriver;

public class SearchScreenHandler {

	public BaseAppDriver driver = null;
	public SearchScreen searchScreen = null;

	public SearchScreenHandler(BaseAppDriver baseDriver) {
		this.driver = baseDriver;
		searchScreen = new SearchScreen(driver);
	}

	public void inputKeyword(String keyword) {
		searchScreen.sendKeys(searchScreen.getInputElement(), keyword);
	}

	public void clearKeyword() {
		searchScreen.clear(searchScreen.getInputElement());
	}

	public void clickSubmitBtn() {
		searchScreen.click(searchScreen.getSearchBtnElement());
	}

	public boolean isSearchDisplayed() {
		return searchScreen.assertExisted(searchScreen.getInputElement());
	}

}
