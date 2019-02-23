package com.frank.cucumberframework.framework.api.apiobjects;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import com.frank.cucumberframework.framework.api.business.ContactResources;

import io.restassured.response.Response;


public class ContactApiHandler {
	
	Response res = null;
	
	public ContactApiHandler() {
		
	}

	public boolean sendPost(String json) {

		res = given().
			log().all().and().
			contentType("application/json;charset=utf-8").and().
			body(json).
		when().
			post(ContactResources.getPostContactResource());
		
		System.out.println("************"+res.asString());
		
		return true;
		
	}
	
	public int getStatusCode() {
		if(res!=null){
			System.out.println("************"+res.getStatusCode());
			return res.getStatusCode();
		}else
			return -1;
	}

	public JSONObject getJson() {
		if(res!=null){
			System.out.println(res.getBody().asString());
			JSONObject json = new JSONObject(res.getBody().asString());
			return json;
		}else
			return null;
	}

	public boolean sendGet() {
		
		res = given().
				log().all().
			when().
				get(ContactResources.getQueryContactResource());
			
			System.out.println("************"+res.asString());
		
		return true;
	}

	public boolean sendPatch(String json) {
		res = given().
				log().all().and().
				contentType("application/json;charset=utf-8").and().
				body(json).
			when().
				patch(ContactResources.getPatchContactResource());
			
			System.out.println("************"+res.asString());
		
		return true;
	}

	public boolean sendDelete() {
		res = given().
				log().all().
			when().
				delete(ContactResources.getDeleteContactResource());
			
			System.out.println("************"+res.asString());
		
		return true;
	}
	
	

}
