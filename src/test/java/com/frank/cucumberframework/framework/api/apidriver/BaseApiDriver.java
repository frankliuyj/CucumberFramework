package com.frank.cucumberframework.framework.api.apidriver;

import com.frank.cucumberframework.framework.utils.datasource.CaseInputDataManager;
import com.frank.cucumberframework.framework.utils.datasource.IDataSource;

import io.restassured.RestAssured;

public class BaseApiDriver {
	
	private static boolean isInitialed = false;
	
	public BaseApiDriver()
	{
		initApiDriver();
	}

	public static void initApiDriver() {
		if(isInitialed == false)
		{
			String args[] = new String[] { "src\\test\\resources\\properties\\api\\api_driver.properties" };
			IDataSource prop = CaseInputDataManager.getDataSourceManager("properties", args);
			RestAssured.baseURI = prop.getProperty("HOST");
			isInitialed = true;
		}
	}

}
