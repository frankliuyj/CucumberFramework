package com.frank.cucumberframework.framework.api.business;

import org.json.JSONObject;

import com.frank.cucumberframework.framework.api.apidriver.BaseApiDriver;
import com.frank.cucumberframework.framework.api.apiobjects.ContactApiHandler;

public class ContactApiProcess {

	private BaseApiDriver driver = null;
	private ContactApiHandler contactApiHandler = null;

	public ContactApiProcess() {
		driver = new BaseApiDriver();
		contactApiHandler = new ContactApiHandler();
	}

	public boolean addContact(String json) {
		return contactApiHandler.sendPost(json);
	}

	public boolean queryContact() {
		return contactApiHandler.sendGet();
		
	}
	
	public boolean updateContact(String json) {
		
		return contactApiHandler.sendPatch(json);
	}
	
	public boolean deleteContact() {
		return contactApiHandler.sendDelete();
	}
	
	public boolean getStatusCodeCompare(int expectedCode) {
			return (contactApiHandler.getStatusCode() == expectedCode);
	}
	
	public boolean getJsonCompare() {
		//Business check for jason in response body
		JSONObject json = contactApiHandler.getJson();
		return true;
	}

}
