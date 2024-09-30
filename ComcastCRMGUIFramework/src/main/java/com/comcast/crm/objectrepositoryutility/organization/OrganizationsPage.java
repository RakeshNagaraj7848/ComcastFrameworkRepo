package com.comcast.crm.objectrepositoryutility.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.home.HomePage;

public class OrganizationsPage {

	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = " //img[@alt=\"Create Organization...\"]")
	private WebElement createNewOrgBtn;

	@FindBy(name = "search_text")
	private WebElement searchEdt;

	@FindBy(name = "search_field")
	private WebElement searchDropDown;

	@FindBy(name = "submit")
	private WebElement searchBtn;

	@FindBy(xpath = "//span[ contains(text(),'No Organization Found !')]")
	private WebElement NoOrgFoundMessageHeader;

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public void deleteOrganization(String orgName, String organizationNameDRoDown, WebDriver driver) {
		HomePage homePage = new HomePage(driver);
		homePage.getOrgLink().click();
		searchEdt.sendKeys(orgName);
		wLib.selectByValue(searchDropDown, organizationNameDRoDown);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']/../../td[8]/a[text()='del']")).click();
		wLib.switchToAlertAndAccept(driver);
	}

	public void validatingDeletdOrganization(String orgName, String organizationNameDRoDown) {
		searchEdt.sendKeys(orgName);
		wLib.selectByValue(searchDropDown, organizationNameDRoDown);
		searchBtn.click();
		if (NoOrgFoundMessageHeader.isDisplayed()) {
			System.out.println(" organization deleted successfully test = pass");
		} else {
			System.out.println(" organization  not deleted successfully");
		}

	}

}
