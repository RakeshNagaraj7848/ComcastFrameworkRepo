package com.comcast.crm.objectrepositoryutility.salesorder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewSalesOrderPage {

	WebDriver driver;

	public CreatingNewSalesOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "subject")
	private WebElement subjectEdt;

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	@FindBy(xpath = "//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement OrganizationNameEdt;

	@FindBy(xpath = "//textarea[@name=\"bill_street\"]")
	private WebElement billingAddress;

	public WebElement getBillingAddress() {
		return billingAddress;
	}

	public WebElement getShippingAddress() {
		return shippingAddress;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath = "//textarea[@name=\"ship_street\"]")
	private WebElement shippingAddress;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;

	@FindBy(id = "searchIcon1")
	private WebElement itemSearchIcon;

	public WebElement getItemSearchIcon() {
		return itemSearchIcon;
	}

	public WebElement getQuantityEdt() {
		return quantityEdt;
	}

	@FindAll({ @FindBy(id = "qty1"), @FindBy(name = "qty1") })
	private WebElement quantityEdt;

	public WebElement getOrganizationNameEdt() {
		return OrganizationNameEdt;
	}

	@FindBy(xpath = "//input[@name=\"potential_name\"]/following-sibling::img")
	private WebElement opportunityNameBtn;

	public WebElement getOpportunityNameBtn() {
		return opportunityNameBtn;
	}

}
