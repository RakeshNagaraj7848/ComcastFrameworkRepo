package com.comcast.crm.objectrepositoryutility.salesorder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class SalesOrderInformationPage {

	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();
	SoftAssert softAssert = new SoftAssert();

	public SalesOrderInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement headerInfo;

	@FindBy(id = "mouseArea_Subject")
	private WebElement subjectInSalesOrderInformationPage;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgNameInSalesOrderInformationPage;

	@FindBy(id = "mouseArea_Opportunity Name")
	private WebElement opportunityNameInSalesOrderInformationPage;

	@FindBy(xpath = "(//td[@class=\"crmTableRow small lineOnTop\"]/..)[1]/td[1]")
	private WebElement itemNameInSalesOrderInformationPage;

	@FindBy(xpath = "(//td[@class=\"crmTableRow small lineOnTop\"]/..)[1]/td[3]")
	private WebElement quantityInSalesOrderInformationPage;

	public void validateHeaderInSalesOrderInformationPage(String subject) {
		String actualSubjectInHeader = headerInfo.getText();
		Assert.assertEquals(actualSubjectInHeader.contains(subject), true);
	}

	public void validateSujectInSalesOrderInformationPage(String subject) {
		String actualSubject = subjectInSalesOrderInformationPage.getText();
		Assert.assertEquals(actualSubject.trim().equals(subject), true);

	}

	public void validateItemQuantityInSalesOrderInformationPage(String itemQuantity) {
		String actualQuantity = quantityInSalesOrderInformationPage.getText();
		Double parseDoubleActualQuantity = Double.parseDouble(actualQuantity);
		Double passesItemQuantity = Double.parseDouble(itemQuantity);
		Assert.assertEquals(parseDoubleActualQuantity.equals(passesItemQuantity), true);

	}

	public void validateItemNameInSalesOrderInformationPage(String itemName) {
		String actualItemName = itemNameInSalesOrderInformationPage.getText();
		Assert.assertEquals(actualItemName.trim().equals(itemName), true);

	}

	public void validateOrganizationNameInSalesOrderInformationPage(String orgName) {
		String actualOrgName = orgNameInSalesOrderInformationPage.getText();
		Assert.assertEquals(actualOrgName.trim().equals(orgName), true);

	}

	public void validateOpportunityNameInSalesOrderInformationPage(String opportunityName) {
		String actualOpportunityName = opportunityNameInSalesOrderInformationPage.getText();
		softAssert.assertEquals(actualOpportunityName.trim().equals(opportunityName), true);
		softAssert.assertAll();
	}

	public void waitForSalesOrderInformationPageToLOad(WebDriver driver) {
		wLib.waitForElementPresent(driver, headerInfo);
	}

}
