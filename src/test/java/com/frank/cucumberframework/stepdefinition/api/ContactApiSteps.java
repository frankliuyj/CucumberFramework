package com.frank.cucumberframework.stepdefinition.api;

import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;

import com.frank.cucumberframework.framework.api.business.ContactApiProcess;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ContactApiSteps {
	
	private ContactApiProcess apiProcess = null;
	private JSONObject json = null;
	
	public ContactApiSteps() {
		apiProcess = new ContactApiProcess();		
	}
	
	@When("I create an contact")
	public void createContact(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		
		json = new JSONObject();
		for(String key : map.keySet()) {
			json.put(key, map.get(key));
		}
					
	}

	@When("POST request to URI {string}")
	public void postToURI(String string) {

		Assert.assertTrue(apiProcess.addContact(json.toString()));
	}

	@Then("get a {int} http status code")
	public void getStatusCode(Integer code) {
		
		Assert.assertTrue(apiProcess.getStatusCodeCompare(code.intValue()));
	}

	@Then("contact content in json format")
	public void getJsonFile() {

		Assert.assertTrue(apiProcess.getJsonCompare());
	}

	@When("GET request to URI {string}")
	public void getToURI(String string) {
		Assert.assertTrue(apiProcess.queryContact());
	}



	@When("PATCH request update an Item")
	public void patchContact(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		json = new JSONObject();
		for(String key : map.keySet()) {
			json.put(key, map.get(key));
		}
	}

	@When("PATCH request to URI {string}")
	public void patchToURI(String string) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(apiProcess.updateContact(json.toString()));
	}
	
	@When("DELETE request to URI {string}")
	public void deleteToURI(String string) {
		Assert.assertTrue(apiProcess.deleteContact());
	}
	
}
