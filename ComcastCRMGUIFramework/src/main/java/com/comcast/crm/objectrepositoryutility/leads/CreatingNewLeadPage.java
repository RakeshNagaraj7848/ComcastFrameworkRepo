package com.comcast.crm.objectrepositoryutility.leads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {

	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getCompanyEdt() {
		return companyEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(name = "company")
	private WebElement companyEdt;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;

	public void createLeadWithMandatoryInformation(String lastName, String company) {

		lastNameEdt.sendKeys(lastName);
		companyEdt.sendKeys(company);
		saveBtn.click();

	}

}