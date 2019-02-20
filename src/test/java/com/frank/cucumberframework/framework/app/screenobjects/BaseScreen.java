package com.frank.cucumberframework.framework.app.screenobjects;

import java.util.List;

import org.openqa.selenium.By;

import com.frank.cucumberframework.framework.app.androiddriver.BaseAppDriver;
import com.frank.cucumberframework.framework.utils.supporter.GetByLocator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;


public class BaseScreen {

	BaseAppDriver baseDriver = null;
	GetByLocator elementLocator = null;

	public BaseScreen(BaseAppDriver driver) {
		baseDriver = driver;
	}

	public void closePage() {
		baseDriver.stop();
	}

	public void backPage() {
		baseDriver.back();
	}

	public String getPageURL() {
		return baseDriver.getUrl();
	}

	public String getPageTitle() {
		return baseDriver.getTitle();
	}

	public AndroidElement element(By by) {
		return baseDriver.findElement(by);
	}

	public AndroidElement nodeElement(By parent, By child) {
		AndroidElement parentEle = element(parent);
		return (AndroidElement)parentEle.findElement(child);
	}

	public AndroidElement nodeElement(AndroidElement parentEle, By child) {
		return (AndroidElement)parentEle.findElement(child);
	}

	public List<AndroidElement> elements(By by) {
		return baseDriver.findElements(by);
	}

	public List<MobileElement> nodeElements(By parent, By child) {
		AndroidElement parentEle = element(parent);
		return parentEle.findElements(child);
	}

	public List<MobileElement> nodeElements(AndroidElement parentEle, By child) {
		return parentEle.findElements(child);
	}

	public void click(AndroidElement element) {
		if (element != null) {
			element.click();
		} else {
			System.out.println("Failed with click, no element avaialable.");
		}
	}

	public void sendKeys(AndroidElement element, String value) {
		if (element != null) {
			element.sendKeys(value);
		} else {
			System.out.println("Failed with sendKeys, no element avaialable.");
		}
	}

	public void clear(AndroidElement element) {
		if (element != null) {
			element.clear();
		} else {
			System.out.println("Failed with clear, no element avaialable.");
		}
	}

	public boolean assertExisted(AndroidElement element) {
		return element.isDisplayed();
	}

	public String getElementText(AndroidElement element) {
		return element.getText();
	}

}
