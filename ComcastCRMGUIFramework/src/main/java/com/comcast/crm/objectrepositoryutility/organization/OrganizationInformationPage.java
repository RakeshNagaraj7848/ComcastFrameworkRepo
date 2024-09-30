package com.comcast.crm.objectrepositoryutility.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationInformationPage {

	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();
	SoftAssert softAssert = new SoftAssert();

	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement headerInfo;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgNameInOrgInfoPage;

	@FindBy(id = "dtlview_Phone")
	private WebElement phoneNumberInOrgInfoPage;

	@FindBy(id = "mouseArea_Industry")
	private WebElement industryInOrgInfoPage;

	public WebElement getIndustryInOrgInfoPage() {
		return industryInOrgInfoPage;
	}

	public WebElement getTypeInOrgInfoPage() {
		return typeInOrgInfoPage;
	}

	@FindBy(id = "mouseArea_Type")
	private WebElement typeInOrgInfoPage;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getOrgNameInOrgInfoPage() {
		return orgNameInOrgInfoPage;
	}

	public WebElement getPhoneNumberInOrgInfoPage() {
		return phoneNumberInOrgInfoPage;
	}

	public void waitUntilOrganizationInformationPageLoad(WebDriver driver) {
		wLib.waitForElementPresent(driver, headerInfo);

	}

	public void validatingOrgHeaderNameInOrgInformationPage(String orgName) {
		String actualOrgHeaderName = headerInfo.getText();
		Assert.assertEquals(actualOrgHeaderName.contains(orgName), true);

	}

	public void validatingOrgNameInOrgInformationPage(String orgName) {
		String actualOrgName = orgNameInOrgInfoPage.getText();
		Assert.assertEquals(actualOrgName.trim().equals(orgName), true);

	}

	public void validatingPhoneNumberInOrgInfoPage(String phoneNumber) {
		String actualPhoneNumber = phoneNumberInOrgInfoPage.getText();
		softAssert.assertEquals(actualPhoneNumber.equals(phoneNumber), true);
		softAssert.assertAll();

	}

	public void validatingIndustryInOrgInfoPage(String industry) {
		String actualIndustryName = industryInOrgInfoPage.getText();
		softAssert.assertEquals(actualIndustryName.equals(industry), true);
		softAssert.assertAll();

	}

	public void validatingTypeInOrgInfoPage(String type) {
		String actualTypeName = typeInOrgInfoPage.getText();
		softAssert.assertEquals(actualTypeName.equals(type), true);
		softAssert.assertAll();

	}
}
