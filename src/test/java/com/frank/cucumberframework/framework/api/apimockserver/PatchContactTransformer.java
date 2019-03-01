package com.frank.cucumberframework.framework.api.apimockserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;

import org.json.JSONObject;

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
		JSONObject new_obj = new JSONObject(body);
		JSONObject old_obj = retriveJsonObject();
		Iterator<String> it = new_obj.keys();
		while(it.hasNext()) {
			String key = it.next();
			Object value = new_obj.get(key);
			old_obj.put(key, value);
		}
		
		renewJsonFile(old_obj);
		
		ResponseDefinitionBuilder responseDefinitionBuilder = new ResponseDefinitionBuilder();
		responseDefinitionBuilder.withHeader("header", "echo-header");
		responseDefinitionBuilder.withHeader("Content-Type", "application/json;charset=utf-8");
		responseDefinitionBuilder.withStatus(200);
		responseDefinitionBuilder.withBody(old_obj.toString());
		
		return responseDefinitionBuilder.build();
	}

	public String getName() {

		return getClass().getSimpleName();
	}
	
	public JSONObject retriveJsonObject() {
		
		JSONObject old_obj = null;
		try {
			File file = new File("src\\test\\resources\\__files\\contact.json");
		    StringBuilder stringBuilder = new StringBuilder();
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bfReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = bfReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bfReader.close();
            
            String jsonString = stringBuilder.toString();
            old_obj = new JSONObject(jsonString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return old_obj;
	}
	
	public void renewJsonFile(JSONObject json) {
		
		String body = json.toString();
		try {
			File file = new File("src\\test\\resources\\__files\\contact.json");
			Writer writer = new FileWriter(file);
			writer.write(body);
			writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
