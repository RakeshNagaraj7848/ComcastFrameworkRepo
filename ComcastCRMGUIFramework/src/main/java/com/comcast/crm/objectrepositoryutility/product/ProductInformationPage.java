package com.comcast.crm.objectrepositoryutility.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ProductInformationPage {

	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();

	public ProductInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]")
	private WebElement headerInfo;

	public void waitUntilProductInformationPageLoad(WebDriver driver) {
		wLib.waitForElementPresent(driver, headerInfo);
	}

}
