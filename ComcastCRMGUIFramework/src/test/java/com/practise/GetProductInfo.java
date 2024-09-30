package com.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class GetProductInfo {
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
		int rowCount=eLib.getRowCount("amazonProduct");
		Object[][] objArr = new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++)
		{
			objArr[i][0]=eLib.getDataFromExcel("amazonProduct", i+1, 0);
			objArr[i][1]=eLib.getDataFromExcel("amazonProduct", i+1, 1);
		}
		
	
		
		return objArr;	
	}
	
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName,String productName)
	{
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.maximizeBrowserWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		String xPathOfPrice="(//span[text()='"+productName+"']/ancestor::div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/descendant::span[@class=\"a-price-whole\"])[1] ";
	String price = driver.findElement(By.xpath(xPathOfPrice)).getText();
	System.out.println(productName+" " +price);
	driver.quit();
		
		
	
		
	}
}
