package com.frank.cucumberframework.framework.app.screenobjects;

import com.frank.cucumberframework.framework.app.androiddriver.BaseAppDriver;

public class SearchResultScreenHandler {

	public BaseAppDriver driver = null;
	public SearchResultScreen searchResultScreen = null;

	public SearchResultScreenHandler(BaseAppDriver baseDriver) {
		this.driver = baseDriver;
		searchResultScreen = new SearchResultScreen(driver);
	}

	public boolean isSearchResultDisplayed(String keyword) {
		String content = searchResultScreen.getBottomInputElement().getText();
		if(content != null && content.equalsIgnoreCase("nxt"))
			return true;
		else
			return false;
	}
}
