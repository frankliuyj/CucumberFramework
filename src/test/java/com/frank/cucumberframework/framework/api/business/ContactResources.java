package com.frank.cucumberframework.framework.api.business;

public class ContactResources {
	
	public static String getQueryContactResource() {

		String res = "/contact/query";
		return res;
	}

	public static String getPostContactResource() {

		String res = "/contact/add";
		return res;
	}
	
	public static String getPatchContactResource() {

		String res = "/contact/patch";
		return res;
	}
	
	public static String getDeleteContactResource() {

		String res = "/contact/delete";
		return res;
	}
}
