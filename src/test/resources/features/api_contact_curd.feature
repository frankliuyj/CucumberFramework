@api
Feature: API tests to demonstrate CRUD operations for contacts
  
  //@first
  Scenario: Add a contact
    When I create an contact
      | name     | Lucy     |
      | mobile   | 123456   |
	And POST request to URI "/contact/add"
    Then get a 201 http status code
	And contact content in json format


  Scenario: Query the contact
    When GET request to URI "/contact/query"
    Then get a 200 http status code
    And contact content in json format
    
  
  Scenario: Update the contact
    When PATCH request update an Item
      | mobile   | 666666   |
    And PATCH request to URI "/contact/patch"
    Then get a 200 http status code
    And contact content in json format
  @first
  Scenario: Delete the contact
    When DELETE request to URI "/contact/delete"
    Then get a 204 http status code
