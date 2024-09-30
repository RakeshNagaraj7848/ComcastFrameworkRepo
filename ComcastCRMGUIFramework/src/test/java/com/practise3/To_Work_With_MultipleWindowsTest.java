package com.practise3;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class To_Work_With_MultipleWindowsTest extends WebDriverUtility {
	@Test
	public void workingWithMultipleWindowTest() {

		String parentWindowTitle = "";
		String childWindowTitle = "";
		String childWindowId = null;
		String childWindow2="";
		WebDriver driver = new ChromeDriver();
		maximizeBrowserWindow(driver);
		waitForPageLoad(driver);
		driver.get("https://demowebshop.tricentis.com/");
		String parentwindowId = driver.getWindowHandle();
		parentWindowTitle = driver.getTitle();
		System.out.println(" parent window tile " + parentWindowTitle);
		driver.findElement(By.xpath("//a[text()='Facebook']")).click();

		Set<String> windowIds = driver.getWindowHandles();

		for (String id : windowIds) {
			if (id != parentwindowId) {
				childWindowId = id;
			}
		}
		driver.switchTo().window(childWindowId);
		childWindowTitle = driver.getTitle();
		System.out.println(" child  window tile  after switch to child" + childWindowTitle);
		
		Set<String> windowIds1 = driver.getWindowHandles();
		for (String id : windowIds) {
			if (id != parentwindowId && id!=childWindowId) {
				childWindow2 = id;
			}
		}
		
		
		// 
		driver.quit();
		
		

	}
}
