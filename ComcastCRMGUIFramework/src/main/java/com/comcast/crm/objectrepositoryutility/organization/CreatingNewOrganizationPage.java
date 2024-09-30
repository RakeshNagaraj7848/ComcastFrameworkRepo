package com.comcast.crm.objectrepositoryutility.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {

	WebDriver driver;

	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement organizationNameEdt;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;

	@FindBy(name = "industry")
	private WebElement industryDropDown;

	@FindBy(name = "accounttype")
	private WebElement typeDropDown;

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	@FindBy(id = "phone")
	private WebElement phoneNumberEdt;

	public WebElement getPhoneNumberEdt() {
		return phoneNumberEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOrganization(String orgName) {
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}

}
