package com.practise2;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngReportTest {
	@Test
	public void createOrgPrintInOnlyReport()
	{
		Reporter.log("orhanisation create successfully");
		Reporter.log("step1");
		Reporter.log("step2");
		Reporter.log("step3");
		Reporter.log("step4");
		Reporter.log("step5");
		
	}
	
	
	@Test
	public void createOrgPrintInBothReportAndConsole()
	{
		Reporter.log("orhanisation create successfully");
		Reporter.log("step5",true);
		Reporter.log("step6",true);
		Reporter.log("step7",true);
		Reporter.log("step8",true);
		Reporter.log("step9",true);
		
	}
	

}
