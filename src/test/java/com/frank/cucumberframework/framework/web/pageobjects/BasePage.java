package com.frank.cucumberframework.framework.web.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.frank.cucumberframework.framework.utils.supporter.GetByLocator;
import com.frank.cucumberframework.framework.web.webdriver.BaseWebDriver;

public class BasePage {

	BaseWebDriver baseDriver = null;
	GetByLocator elementLocator = null;

	public BasePage(BaseWebDriver driver) {
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

	public WebElement element(By by) {
		return baseDriver.findElement(by);
	}

	public WebElement nodeElement(By parent, By child) {
		WebElement parentEle = element(parent);
		return parentEle.findElement(child);
	}

	public WebElement nodeElement(WebElement parentEle, By child) {
		return parentEle.findElement(child);
	}

	public List<WebElement> elements(By by) {
		return baseDriver.findElements(by);
	}

	public List<WebElement> nodeElements(By parent, By child) {
		WebElement parentEle = element(parent);
		return parentEle.findElements(child);
	}

	public List<WebElement> nodeElements(WebElement parentEle, By child) {
		return parentEle.findElements(child);
	}

	public void click(WebElement element) {
		if (element != null) {
			element.click();
		} else {
			System.out.println("Failed with click, no element avaialable.");
		}
	}

	public void sendKeys(WebElement element, String value) {
		if (element != null) {
			element.sendKeys(value);
		} else {
			System.out.println("Failed with sendKeys, no element avaialable.");
		}
	}

	public void clear(WebElement element) {
		if (element != null) {
			element.clear();
		} else {
			System.out.println("Failed with clear, no element avaialable.");
		}
	}

	public boolean assertExisted(WebElement element) {
		return element.isDisplayed();
	}

	public String getElementText(WebElement element) {
		return element.getText();
	}

}
