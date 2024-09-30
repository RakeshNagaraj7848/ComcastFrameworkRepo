package com.practise3;

import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class To_Work_With_ExtentReportsTest {

	@Test
	public void extentReportTest() {
		String date =new Date().toString().replace(" ","_").replace(":","_");
		// STACK REPORT CONFIGURATION
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report_"+date+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);

		// ENVIRONMENT CONFIGURATION SETTING AND CREATING TEST IN A REPORT
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("BROWSER", "CHROME");
		report.setSystemInfo("OS", "WINDOW-10");
		report.setSystemInfo("ENVIRONMENT", "QA");

		ExtentTest test = report.createTest("extentReportTest");

		test.log(Status.INFO, " login to application ");
//		test.log(Status.FAIL, " LOGIN FAILED");
//		test.log(Status.SKIP, " LOGIN FAILED");
		test.log(Status.PASS, " LOGIN FAILED");

		// report back up
		report.flush();

	}
}
