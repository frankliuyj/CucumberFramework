package com.frank.cucumberframework.framework.api.apiobjects;

import com.frank.cucumberframework.framework.api.apidriver.BaseApiDriver;

public class ContactApiHandler {
	
	private static BaseApiDriver apiDriver = null;

	public ContactApiHandler(BaseApiDriver driver) {
		apiDriver = driver;
	}

}
