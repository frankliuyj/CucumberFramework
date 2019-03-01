package com.frank.cucumberframework.framework.api.apimockserver;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.frank.cucumberframework.framework.api.business.ContactResources;
import com.github.tomakehurst.wiremock.WireMockServer;

public class DeleteContactStub {
	
	public static void deleteStubRegister(WireMockServer wiremockServer) {
		wiremockServer.stubFor(delete(urlEqualTo(ContactResources.getDeleteContactResource()))
				.willReturn(aResponse()
					.withTransformers(DeleteContactTransformer.class.getSimpleName()))
				);
	}
}
