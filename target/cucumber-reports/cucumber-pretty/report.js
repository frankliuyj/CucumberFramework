$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/mobile_search.feature");
formatter.feature({
  "name": "Login: As a enduser of baidu search service, I can search keyword in chrome app",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@app"
    }
  ]
});
formatter.scenario({
  "name": "Success",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@app"
    },
    {
      "name": "@success"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "visit baidu search engine homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchScreenSteps.browserToSearchPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "input a keyword \"test\"",
  "keyword": "When "
});
formatter.match({
  "location": "SearchScreenSteps.inputKeyword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click search botton",
  "keyword": "And "
});
formatter.match({
  "location": "SearchScreenSteps.click_search_botton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "search result of \"test\" is shown in chrome app",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchResultScreenSteps.isSearchResultPageShown(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\r\n\tat org.testng.Assert.assertTrue(Assert.java:44)\r\n\tat org.testng.Assert.assertTrue(Assert.java:54)\r\n\tat com.frank.cucumberframework.stepdefinition.app.SearchResultScreenSteps.isSearchResultPageShown(SearchResultScreenSteps.java:31)\r\n\tat ✽.search result of \"test\" is shown in chrome app(src/test/resources/features/mobile_search.feature:9)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});