package com.frank.cucumberframework.framework.utils.supporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	public static void takeScreenshot(WebDriver driver) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String dateStr = sf.format(date);
		String path = driver.getClass().getSimpleName() + "_" + dateStr + ".png";
		String currentPath = System.getProperty("user.dir"); // get current work dir

		TakesScreenshot shot = (TakesScreenshot) driver;
		File scrFile = shot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Take Screenshot successfully");
		}
	}

}
