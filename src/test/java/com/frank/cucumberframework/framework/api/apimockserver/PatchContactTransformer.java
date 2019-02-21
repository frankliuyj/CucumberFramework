package com.frank.cucumberframework.framework.api.apimockserver;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class PatchContactTransformer extends ResponseDefinitionTransformer{

	public boolean applyGlobally() {
	    return false;
	}

	public ResponseDefinition transform(Request request, ResponseDefinition responseDefinition, FileSource files,
			Parameters parameters) {
		
		String body = request.getBodyAsString();
		System.out.println("*****************" + body);
		ResponseDefinitionBuilder responseDefinitionBuilder = new ResponseDefinitionBuilder();
		responseDefinitionBuilder.withHeader("header", "echo-header");
		responseDefinitionBuilder.withHeader("Content-Type", "application/json;charset=utf-8");
		responseDefinitionBuilder.withStatus(200);
		responseDefinitionBuilder.withBody(body);
		
		return responseDefinitionBuilder.build();
	}

	public String getName() {

		return getClass().getSimpleName();
	}

}
