package com.comcast.crm.objectrepositoryutility.leads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LeadInformationPage {

	WebDriverUtility wLib = new WebDriverUtility();

	public LeadInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastNameInLeadInformationPage;

	public WebElement getLastNameInLeadInformationPage() {
		return lastNameInLeadInformationPage;
	}

	public WebElement getCompanyInLeadInformationPage() {
		return companyInLeadInformationPage;
	}

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	@FindBy(id = "mouseArea_Company")
	private WebElement companyInLeadInformationPage;

	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement headerInfo;

	public void waitForOpportunityInformationPageToLOad(WebDriver driver) {
		wLib.waitForElementPresent(driver, headerInfo);
	}

	public void validatingLastNameInHeaderInLeadInformationPage(String lastName) {
		String actualLastNameInHeader = headerInfo.getText();
		Assert.assertEquals(actualLastNameInHeader, lastName);
	}

	public void validatingLastNameInLeadInformationPage(String lastName) {
		String actualLastName = lastNameInLeadInformationPage.getText();
		Assert.assertEquals(actualLastName, lastName);
	}

	public void validatingCompanyInLeadInformationPage(String company) {
		String actualCompany = companyInLeadInformationPage.getText();
		Assert.assertEquals(actualCompany, company);

	}

}