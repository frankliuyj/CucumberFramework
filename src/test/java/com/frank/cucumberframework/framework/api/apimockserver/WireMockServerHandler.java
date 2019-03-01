package com.frank.cucumberframework.framework.api.apimockserver;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class WireMockServerHandler {
	WireMockServer wiremockServer = null;
	
	@SuppressWarnings("unchecked")
	public WireMockServerHandler() {
		if(wiremockServer == null) {
			WireMockConfiguration con = new WireMockConfiguration().port(9088);
			con.extensions(PostContactTransformer.class,PatchContactTransformer.class,
					QueryContactTransformer.class,DeleteContactTransformer.class);
			con.disableRequestJournal();
			wiremockServer = new WireMockServer(con);
			stubsRegister(wiremockServer);
		}
		
	}

	private void stubsRegister(WireMockServer wiremockServer) {
		PostContactStub.postStubRegister(wiremockServer);
		PatchContactStub.patchStubRegister(wiremockServer);
		QueryContactStub.queryStubRegister(wiremockServer);
		DeleteContactStub.deleteStubRegister(wiremockServer);
		
	}
	
	public void startMockServer() {
		wiremockServer.start();
	}
	
	public void stopMockServer() {
		wiremockServer.stop();
	}
	
	
	
	

	
	

}
