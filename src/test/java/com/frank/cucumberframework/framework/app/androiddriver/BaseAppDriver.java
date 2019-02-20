package com.frank.cucumberframework.framework.app.androiddriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.frank.cucumberframework.framework.utils.datasource.CaseInputDataManager;
import com.frank.cucumberframework.framework.utils.datasource.IDataSource;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseAppDriver {

	AndroidDriver<AndroidElement> driver = null;
	IDataSource prop = null;

	public BaseAppDriver() {
		if (driver == null) {
			if (prop == null) {
				String args[] = new String[] { "src\\test\\resources\\properties\\app\\app_driver.properties" };
				prop = CaseInputDataManager.getDataSourceManager("properties", args);
			}

			String deviceName = prop.getProperty("device_name");
			String browserName = prop.getProperty("browser_name");
			String appiumServerAddress = prop.getProperty("appium_url");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
			try {
				driver = new AndroidDriver<AndroidElement> (new URL(appiumServerAddress), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Start webdriver");
	}

	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}

	public void stop() {
		driver.close();
		driver.quit();
		driver=null;
		System.out.println("Stop AppDriver");
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

	public AndroidElement findElement(By by) {

		return driver.findElement(by);
	}

	public List<AndroidElement> findElements(By by) {

		return driver.findElements(by);
	}

	public void setDriverImplicitWait(int i) {

		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}

}
