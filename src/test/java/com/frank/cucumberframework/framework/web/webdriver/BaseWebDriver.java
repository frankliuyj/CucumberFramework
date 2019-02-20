package com.frank.cucumberframework.framework.web.webdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.frank.cucumberframework.framework.utils.datasource.CaseInputDataManager;
import com.frank.cucumberframework.framework.utils.datasource.IDataSource;

public class BaseWebDriver {

	WebDriver driver = null;
	IDataSource prop = null;

	public BaseWebDriver() {
		if (driver == null) {
			if (prop == null) {
				String args[] = new String[] { "src\\test\\resources\\properties\\web\\web_driver.properties" };
				prop = CaseInputDataManager.getDataSourceManager("properties", args);
			}

			String browserName = prop.getProperty("browser");

			if (browserName == null)
				driver = new ChromeDriver();

			if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else {
				driver = new ChromeDriver();
			}
		}
		System.out.println("Start webdriver");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void stop() {
		driver.close();
		driver.quit();
		driver=null;
		System.out.println("Stop webdriver");
	}

	public void get(String url) {
		driver.get(url);
	}

	public void back() {
		driver.navigate().back();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public List<String> getWindowsHandles() {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(winHandels);
		return handles;
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public void switchWindows(String name) {
		driver.switchTo().window(name);
	}

	public void switchAlert() {
		driver.switchTo().alert();
	}

	public void switchToModal() {
		driver.switchTo().activeElement();
	}

	public Set<Cookie> getCookie() {
		Set<Cookie> cookies = driver.manage().getCookies();
		return cookies;
	}

	public void deleteCookie() {
		driver.manage().deleteAllCookies();
	}

	public void setCookie(Cookie cookie) {
		driver.manage().addCookie(cookie);
	}

	public WebElement findElement(By by) {

		return driver.findElement(by);
	}

	public List<WebElement> findElements(By by) {

		return driver.findElements(by);
	}

	public void setDriverImplicitWait(int i) {

		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}

}
