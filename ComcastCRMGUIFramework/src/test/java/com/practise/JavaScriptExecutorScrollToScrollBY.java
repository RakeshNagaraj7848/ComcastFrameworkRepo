package com.practise;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.login.LoginPage;

public class JavaScriptExecutorScrollToScrollBY {

	WebDriverUtility wLib = new WebDriverUtility();

	@Test
	public void javascriptExecutorScrollTo() throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		wLib.maximizeBrowserWindow(driver);
		wLib.waitForPageLoad(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToAppplication("admin", "admin");
		Thread.sleep(30000);

		wLib.javascriptExecutorScrollTo(driver, 0, 500);
		Thread.sleep(3000);
		driver.quit();

	}

	@Test
	public void javascriptExecutorScrollBy() throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		wLib.maximizeBrowserWindow(driver);
		wLib.waitForPageLoad(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToAppplication("admin", "admin");
		Thread.sleep(30000);

		wLib.javascriptExecutorScrollBy(driver, 0, 500);
		Thread.sleep(3000);
		driver.quit();

	}

}
