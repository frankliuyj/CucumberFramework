package com.frank.cucumberframework.framework.api.apimockserver;

import java.io.File;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class DeleteContactTransformer extends ResponseDefinitionTransformer{

	public boolean applyGlobally() {
	    return false;
	}

	public ResponseDefinition transform(Request request, ResponseDefinition responseDefinition, FileSource files,
			Parameters parameters) {
		
		File file=new File("src\\test\\resources\\__files\\contact.json");
        if(file.exists()&&file.isFile())
            file.delete();
		
		ResponseDefinitionBuilder responseDefinitionBuilder = new ResponseDefinitionBuilder();
		responseDefinitionBuilder.withStatus(204);
		return responseDefinitionBuilder.build();
	}

	public String getName() {

		return getClass().getSimpleName();
	}

}
