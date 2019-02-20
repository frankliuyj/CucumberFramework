package com.frank.cucumberframework.framework.context;

import com.frank.cucumberframework.framework.web.webdriver.BaseWebDriver;

public class WebTestContext {

	 private BaseWebDriver baseWebDriver = null;
	 
	 public WebTestContext(){
		 if(baseWebDriver == null) {
			 baseWebDriver = new BaseWebDriver();
			 baseWebDriver.setDriverImplicitWait(10);
		 }
	 }
	 
	 public BaseWebDriver getWebDriver() {
		 
		 return baseWebDriver;
	 }
	 
}
