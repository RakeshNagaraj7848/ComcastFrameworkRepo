package com.practise;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ReadDataFromExcel {

	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();

@Test
	public void readDataFromExcel(Method mt) throws IOException, Throwable {
//		List<String> readingMutltipleDataFromExcel = eLib.readingMutltipleDataFromExcel("Sheet2");
//		for (String a : readingMutltipleDataFromExcel) {
//			System.out.println(a + "\t");
//		}
//		System.out.println(readingMutltipleDataFromExcel);

	   WebDriver driver = new ChromeDriver();
	   driver.get("http://localhost:8888/");
	   wLib.waitForPageLoad(driver);
	   wLib.takeScreenShotOfEntireWebPage(driver,mt.getName());   

	}
}
