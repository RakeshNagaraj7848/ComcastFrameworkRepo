package com.comcast.crm.objectrepositoryutility.invoice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class InvoiceInformationPage {

	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();

	public InvoiceInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement headerInfo;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getSubjectIninvoiceInformationPage() {
		return subjectIninvoiceInformationPage;
	}

	public WebElement getOrganizationNameIninvoiceInformationPage() {
		return organizationNameIninvoiceInformationPage;
	}

	public WebElement getItemNameIninvoiceInformationPage() {
		return itemNameIninvoiceInformationPage;
	}

	public WebElement getQuantityIninvoiceInformationPage() {
		return quantityIninvoiceInformationPage;
	}

	@FindBy(id = "mouseArea_Subject")
	private WebElement subjectIninvoiceInformationPage;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement organizationNameIninvoiceInformationPage;

	@FindBy(xpath = "(//td[@class=\"crmTableRow small lineOnTop\"]/..)[1]/td[1]")
	private WebElement itemNameIninvoiceInformationPage;

	@FindBy(xpath = "(//td[@class=\"crmTableRow small lineOnTop\"]/..)[1]/td[3]")
	private WebElement quantityIninvoiceInformationPage;

	public void validateHeaderInInvoiceInformationPage(String subject) {
		String actualSubjectInHeader = headerInfo.getText();
		Assert.assertEquals(actualSubjectInHeader.contains(subject), true);

	}

	public void validateSujectInInvoiceInformationPage(String subject) {
		String actualSubject = subjectIninvoiceInformationPage.getText();
		Assert.assertEquals(actualSubject.trim(), subject);

	}

	public void validateItemQuantityIninvoiceInformationPage(String itemQuantity) {
		String actualQuantity = quantityIninvoiceInformationPage.getText();
		Double parseDoubleActualQuantity = Double.parseDouble(actualQuantity);
		Double passesItemQuantity = Double.parseDouble(itemQuantity);
		Assert.assertEquals(parseDoubleActualQuantity, passesItemQuantity);

	}

	public void validateItemNameIninvoiceInformationPage(String itemName) {
		String actualItemName = itemNameIninvoiceInformationPage.getText();
		Assert.assertEquals(actualItemName.trim(), itemName);
	}

	public void validateOrganizationNameIninvoiceInformationPage(String orgName) {
		String actualOrgName = organizationNameIninvoiceInformationPage.getText();
		Assert.assertEquals(actualOrgName.trim(), orgName);

	}

	public void waitForInvoiceInformationPageToLOad(WebDriver driver) {
		wLib.waitForElementPresent(driver, headerInfo);
	}

}
