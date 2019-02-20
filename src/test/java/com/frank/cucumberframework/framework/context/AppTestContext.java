package com.frank.cucumberframework.framework.context;

import com.frank.cucumberframework.framework.app.androiddriver.BaseAppDriver;

public class AppTestContext {

	 private BaseAppDriver baseAppDriver = null;
	 
	 public AppTestContext(){
		 if(baseAppDriver == null) {
			 baseAppDriver = new BaseAppDriver();
			 baseAppDriver.setDriverImplicitWait(10);
		 }
	 }
	 
	 public BaseAppDriver getAppDriver() {
		 
		 return baseAppDriver;
	 }
	 
}
