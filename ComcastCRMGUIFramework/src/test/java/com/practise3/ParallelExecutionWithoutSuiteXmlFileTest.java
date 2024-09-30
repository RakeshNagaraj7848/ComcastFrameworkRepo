package com.practise3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelExecutionWithoutSuiteXmlFileTest {

	@Test(invocationCount = 2, threadPoolSize = 2)
	public void parallelExecutionTest() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.close();

	}

}
