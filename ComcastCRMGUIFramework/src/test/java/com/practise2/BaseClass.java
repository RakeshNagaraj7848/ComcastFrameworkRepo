package com.practise2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
		@BeforeSuite
		public void bsConfig()
		{
			System.out.println(" connect to database and report config in @BeforeSuite");
		}

		@BeforeClass
		public void bcConfig()
		{
			System.out.println(" launch browser in  @BeforeClass");
		}
		
		
		@BeforeMethod
		public void bmConfig()
		{
			System.out.println(" login to application in @BeforeMethod ");
		}
		
		@AfterMethod
		public void amConfig()
		{
			System.out.println(" logout to appplication in @AfterMethod");
		}
		
		@AfterClass
		public void acConfig()
		{
			System.out.println(" close browser in @AfterClass");
		}
		
		@AfterSuite
		public void asConfig()
		{
			System.out.println(" disconnnect to database and report backup in @AfterSuite");
		}

}
