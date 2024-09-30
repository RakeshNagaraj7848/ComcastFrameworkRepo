package com.comcast.crm.objectrepositoryutility.invoice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewInvoicePage {

	WebDriver driver;

	public CreatingNewInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "subject")
	private WebElement subjecttNameEdt;

	@FindBy(xpath = "//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement orgnizationNameBtn;

	@FindBy(xpath = "//textarea[@name=\"bill_street\"]")
	private WebElement billingAddressEdt;

	@FindBy(id = "searchIcon1")
	private WebElement itemNameSearchBtn;

	public WebElement getItemNameSearchBtn() {
		return itemNameSearchBtn;
	}

	public WebElement getItemQuantityEdt() {
		return itemQuantityEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(id = "qty1")
	private WebElement itemQuantityEdt;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;

	public WebElement getBillingAddressEdt() {
		return billingAddressEdt;
	}

	public WebElement getShippingAddressEdt() {
		return shippingAddressEdt;
	}

	@FindBy(xpath = "//textarea[@name=\"ship_street\"]")
	private WebElement shippingAddressEdt;

	public WebElement getSubjecttNameEdt() {
		return subjecttNameEdt;
	}

	public WebElement getOrgnizationNameBtn() {
		return orgnizationNameBtn;
	}

}
