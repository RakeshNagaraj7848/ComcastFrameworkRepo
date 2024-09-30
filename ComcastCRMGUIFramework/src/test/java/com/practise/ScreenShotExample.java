package com.practise;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.login.LoginPage;

public class ScreenShotExample {

	WebDriverUtility wLib = new WebDriverUtility();

	@Test
	public void scrrenshotOfWebPage(Method mt) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		wLib.waitForPageLoad(driver);
		wLib.takeScreenShotOfEntireWebPage(driver,mt.getName());

	}

	@Test
	public void scrrenshotOfWebElement() throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		wLib.waitForPageLoad(driver);
		LoginPage loginPage = new LoginPage(driver);

		wLib.takeScreenShotOfWebElement(loginPage.getSubmitBtn());

	}
}
