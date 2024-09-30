package com.comcast.crm.baseclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.login.LoginPage;

public class BaseClass {

	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void bsConfig() {

		dLib.getDataBaseConnection();
		System.out.println(" connect to database and report config in @BeforeSuite ");

	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void bcConfig() throws IOException {
		// String browser
		// String BROWSER = browser;
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {

			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {

			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {

			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver = new FirefoxDriver();
		//sdriver = driver;
		UtilityClassObject.setDriver(driver);
		System.out.println(" launch browser in @BeforeClass");

	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void bmConfig() throws IOException {
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginPage loginPage = new LoginPage(driver);
		driver.get(URL);
		wLib.maximizeBrowserWindow(driver);
		wLib.waitForPageLoad(driver);
		loginPage.loginToAppplication(USERNAME, PASSWORD);
		System.out.println(" login to application in @BeforeMethod");
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void amConfig() {
		HomePage homePage = new HomePage(driver);
		homePage.signOut(driver);
		System.out.println(" logout to appplication in @AfterMethod");
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void acConfig() {
		driver.quit();
		System.out.println(" close browser in @AfterClass ");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void asConfig() {
		dLib.closeDataBaseConnection();
		System.out.println(" disconnnect to database and report backup in @AfterSuite");
	}
}
