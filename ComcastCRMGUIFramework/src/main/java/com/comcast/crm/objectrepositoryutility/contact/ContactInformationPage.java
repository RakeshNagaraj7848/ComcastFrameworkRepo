package com.comcast.crm.objectrepositoryutility.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ContactInformationPage {

	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();
	SoftAssert softAssert = new SoftAssert();

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderInfo;

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameInContactInfoPage;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supportStartDateInContactInfoPage;

	public WebElement getSupportStartDateInContactInfoPage() {
		return supportStartDateInContactInfoPage;
	}

	public WebElement getSupportEndDateInContactInfoPage() {
		return supportEndDateInContactInfoPage;
	}

	@FindBy(id = "dtlview_Support End Date")
	private WebElement supportEndDateInContactInfoPage;

	public WebElement getContactHeaderInfo() {
		return contactHeaderInfo;
	}

	public WebElement getLastNameInContactInfoPage() {
		return lastNameInContactInfoPage;
	}

	public void validatingContactHeaderNameInContactInformationPage(String lastName) {
		String actualContactHeaderName = contactHeaderInfo.getText();

		Assert.assertEquals(actualContactHeaderName.contains(lastName), true);

	}

	public void validatingLastNameInContactInformationPage(String lastName) {
		String actualLastName = lastNameInContactInfoPage.getText();

		Assert.assertEquals(actualLastName.contains(lastName), true);

	}

	public void waitUntilContactInformationPageLoad(WebDriver driver) {
		wLib.waitForElementPresent(driver, contactHeaderInfo);

	}

	public void validatingSupportStartDateInContactInfoPage(String actualDate) {
		String actualDateFound = supportStartDateInContactInfoPage.getText();
		softAssert.assertEquals(actualDateFound, actualDate);
		softAssert.assertAll();
	}

	public void validatingSupportEndDateInContactInfoPage(String dateRequired) {

		String actualDateAfter30Days = supportEndDateInContactInfoPage.getText();
		softAssert.assertEquals(actualDateAfter30Days, dateRequired);
		softAssert.assertAll();

	}

}
