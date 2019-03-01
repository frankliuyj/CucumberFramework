package com.frank.cucumberframework.framework.api.apimockserver;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.frank.cucumberframework.framework.api.business.ContactResources;
import com.github.tomakehurst.wiremock.WireMockServer;

public class PostContactStub {

	public static void postStubRegister(WireMockServer wiremockServer) {
		wiremockServer.stubFor(post(urlEqualTo(ContactResources.getPostContactResource()))
				.willReturn(aResponse()
					.withTransformers(PostContactTransformer.class.getSimpleName()))
				);
	}
}
