package com.frank.cucumberframework.stepdefinition.api;

import com.frank.cucumberframework.framework.api.apimockserver.WireMockServerHandler;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;



public class Hook {

	WireMockServerHandler handler = null;
	
	public Hook() {
		
	}

	@Before
	public void preparePrecondtion() {
		
		handler = new WireMockServerHandler();
		handler.startMockServer();
	}

	

	@After
	public void executePostcondition(Scenario scenario) {
		if (scenario.isFailed()) {

		    }
		handler.stopMockServer();
	}
	
}
