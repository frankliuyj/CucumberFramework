package com.frank.cucumberframework.framework.app.business;

import com.frank.cucumberframework.framework.app.androiddriver.BaseAppDriver;
import com.frank.cucumberframework.framework.app.screenobjects.SearchResultScreenHandler;


public class SearchResultProcess {

	BaseAppDriver driver = null;
	SearchResultScreenHandler searchResultHandler = null;

	public SearchResultProcess(BaseAppDriver baseDriver) {
		this.driver = baseDriver;
		searchResultHandler = new SearchResultScreenHandler(baseDriver);
	}

	public boolean verifyResultState(String keyword) {
		return searchResultHandler.isSearchResultDisplayed(keyword);
	}

}
