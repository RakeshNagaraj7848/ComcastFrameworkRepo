package com.comcast.crm.objectrepositoryutility.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveButton;

	@FindBy(name = "support_start_date")
	private WebElement supportStartDateEdt;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement organizationNameEdtBtn;

	public WebElement getOrganizationNameEdtBtn() {
		return organizationNameEdtBtn;
	}

	public void setOrganizationNameEdtBtn(WebElement organizationNameEdtBtn) {
		this.organizationNameEdtBtn = organizationNameEdtBtn;
	}

	public WebElement getSupportStartDateEdt() {
		return supportStartDateEdt;
	}

	public WebElement getSupportEndtDateEdt() {
		return supportEndtDateEdt;
	}

	@FindBy(name = "support_end_date")
	private WebElement supportEndtDateEdt;

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void createContact(String LastName) {
		lastNameEdt.sendKeys(LastName);
		saveButton.click();
	}

}
