package com.practise3;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class To_Work_With_ExtentReports_With_Screenshot {

	@Test
	public void extentReportWithScreenShotTest() {

		// STACK REPORT CONFIGURATION
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);

		// ENVIRONMENT CONFIGURATION SETTING AND CREATING TEST IN A REPORT
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("BROWSER", "CHROME");
		report.setSystemInfo("OS", "WINDOW-10");
		report.setSystemInfo("ENVIRONMENT", "QA");

		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		TakesScreenshot ts = (TakesScreenshot)driver;
		String path =ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("extentReportTest");
		
		if("HDFC".equals("FCHD"))
		{
			test.log(Status.PASS, " test pass");
		}
		else
		{
			test.addScreenCaptureFromBase64String(path," error file");
			
		}
		
		

		// report back up
		report.flush();

	}
}
