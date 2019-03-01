package com.frank.cucumberframework.framework.api.apimockserver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class PostContactTransformer extends ResponseDefinitionTransformer{

	public boolean applyGlobally() {
	    return false;
	}

	public ResponseDefinition transform(Request request, ResponseDefinition responseDefinition, FileSource files,
			Parameters parameters) {
		
		String body = request.getBodyAsString();

		try {
			File file = new File("src\\test\\resources\\__files\\contact.json");
			Writer writer = new FileWriter(file);
			writer.write(body);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ResponseDefinitionBuilder responseDefinitionBuilder = new ResponseDefinitionBuilder();
		responseDefinitionBuilder.withHeader("header", "echo-header");
		responseDefinitionBuilder.withHeader("Content-Type", "application/json;charset=utf-8");
		responseDefinitionBuilder.withStatus(201);
		responseDefinitionBuilder.withBody(body);
		
		return responseDefinitionBuilder.build();
	}

	public String getName() {

		return getClass().getSimpleName();
	}

}
