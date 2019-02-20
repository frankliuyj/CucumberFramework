@app
Feature: Login: As a enduser of baidu search service, I can search keyword in chrome app 

  @success
  Scenario: Success
    Given visit baidu search engine homepage
    When input a keyword "test"
    And click search botton
	Then search result of "test" is shown in chrome app