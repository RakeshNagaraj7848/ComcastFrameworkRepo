package com.comcast.crm.objectrepositoryutility.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = " //img[@alt=\"Create Contact...\"]")
	private WebElement createContactButton;

	public WebElement getCreateContactButton() {
		return createContactButton;
	}

}
