package com.frank.cucumberframework.framework.app.business;

import com.frank.cucumberframework.framework.app.androiddriver.BaseAppDriver;
import com.frank.cucumberframework.framework.app.screenobjects.SearchScreenHandler;

public class SearchProcess {

	BaseAppDriver driver = null;
	SearchScreenHandler searchHandler = null;

	public SearchProcess(BaseAppDriver baseDriver) {
		this.driver = baseDriver;
		searchHandler = new SearchScreenHandler(baseDriver);
	}

	public boolean verifyPageLoadState() {
		return searchHandler.isSearchDisplayed();
	}

	public void inputKeyword(String keyword) {
		searchHandler.clearKeyword();
		searchHandler.inputKeyword(keyword);
	}
	
	public void startSearch() {
		searchHandler.clickSubmitBtn();
	}

}
