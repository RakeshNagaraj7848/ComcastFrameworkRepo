package com.practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Baseclass {
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println(" connect to database and report config");
	}

	@BeforeClass
	public void bcConfig()
	{
		System.out.println(" launch browser");
	}
	
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println(" login to application");
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println(" logout to appplication");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println(" close browser");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println(" disconnnect to database and report backup");
	}
	
}
