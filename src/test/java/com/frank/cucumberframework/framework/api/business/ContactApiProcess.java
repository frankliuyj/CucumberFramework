package com.frank.cucumberframework.framework.api.business;

import com.frank.cucumberframework.framework.api.apidriver.BaseApiDriver;
import com.frank.cucumberframework.framework.api.apiobjects.ContactApiHandler;

public class ContactApiProcess {

	private static BaseApiDriver driver = null;
	ContactApiHandler contactApiHandler = null;

	public ContactApiProcess(BaseApiDriver baseDriver) {
		driver = baseDriver;
		contactApiHandler = new ContactApiHandler(driver);
	}

	public void addContact() {
		
	}

	public void queryContact() {
		
	}
	
	public void updateContact() {
		
	}
	
	public void deleteContact() {
		
	}

}
