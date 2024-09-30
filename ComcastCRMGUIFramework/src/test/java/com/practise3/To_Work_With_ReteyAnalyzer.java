package com.practise3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class To_Work_With_ReteyAnalyzer {
	int count =0;
	int limitCount=5;
	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListenerImplmentationClass.class)
	public void activateSim()
	{
		System.out.println(" activate sim ");
		System.out.println(" step -1");
		Assert.assertEquals("Login", "Login ");
		System.out.println(" step -2");
		System.out.println(" step -3");
		
	}

}
