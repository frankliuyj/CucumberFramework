package com.frank.cucumberframework.framework.api.apimockserver;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.patch;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.frank.cucumberframework.framework.api.business.ContactResources;
import com.github.tomakehurst.wiremock.WireMockServer;

public class PatchContactStub {

	public static void patchStubRegister(WireMockServer wiremockServer) {
		wiremockServer.stubFor(patch(urlEqualTo(ContactResources.getPatchContactResource()))
				.willReturn(aResponse()
					.withStatus(200)
					.withTransformers(PatchContactTransformer.class.getSimpleName()))
				);
	}
}
