package com.practise;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CongigAnnotationTest {
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println(" BeforeSuite");
	}
	@AfterSuite
	public void asConfig()
	{
		System.out.println(" AfterSuite");
	}
	@BeforeClass
	public void bcConfig()
	{
		System.out.println(" BeforeClass");
	}
	@AfterClass
	public void acConfig()
	{
		System.out.println(" AfterClass");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println(" BeforeMethod");
	}
	@AfterMethod
	public void amConfig()
	{
		System.out.println(" AfterMethod");
	}
	@Test
	public void createContact()
	{
		System.out.println(" createContact");
	}
	
	@Test
	public void modifyContact()
	{
		System.out.println(" modifyContact");
	}
	@Test
	public void deleteContact()
	{
		System.out.println("deleteContact");
	}

}
