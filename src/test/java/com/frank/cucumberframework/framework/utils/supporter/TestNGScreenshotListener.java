package com.frank.cucumberframework.framework.utils.supporter;

import java.util.Iterator;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;


public class TestNGScreenshotListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		
		/*It won't work since result is not "testcase" object now, it's "testrunner", in which
		 * we can't get steps so no way to get webdriver. So use cucumber hooker instead.
		 */
		
		/*
		System.out.println(result);
		BaseWebSteps base = (BaseWebSteps) result.getInstance();
		base.getDriver().takeScreenShot();
		*/
		// TODO Auto-generated method stub
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {

		Iterator<ITestResult> iterator = context.getFailedTests().getAllResults().iterator();
		
		while(iterator.hasNext()) {
			ITestResult failedTest = iterator.next();
			ITestNGMethod method = failedTest.getMethod();
			if(context.getFailedTests().getResults(method).size() > 1) {
				iterator.remove();
			}else if(context.getPassedTests().getResults(method).size() > 0) {
				iterator.remove();
			}
		}

	}
}
