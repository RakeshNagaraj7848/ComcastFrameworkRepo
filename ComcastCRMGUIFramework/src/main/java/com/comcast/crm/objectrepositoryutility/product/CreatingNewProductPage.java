package com.comcast.crm.objectrepositoryutility.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {

	WebDriver driver;

	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productname")
	private WebElement productNameEdt;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
