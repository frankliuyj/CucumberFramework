package com.frank.cucumberframework.framework.context;

import com.frank.cucumberframework.framework.api.apidriver.BaseApiDriver;

public class ApiTestContext {

	 private static BaseApiDriver baseAppDriver;
	 
	 public static BaseApiDriver getApiDriver() {
		 return baseAppDriver;
	 }
	 
 
}
