package com.frank.cucumberframework.framework.api.apimockserver;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.frank.cucumberframework.framework.api.business.ContactResources;
import com.github.tomakehurst.wiremock.WireMockServer;

public class QueryContactStub {

	public static void queryStubRegister(WireMockServer wiremockServer) {
		wiremockServer.stubFor(get(urlEqualTo(ContactResources.getQueryContactResource()))
				.willReturn(aResponse()
					.withStatus(200)
					.withBodyFile("contact.json"))
					//.withTransformers(QueryContactTransformer.class.getSimpleName()))
				);
	}
}
