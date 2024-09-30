package com.comcast.crm.objectrepositoryutility.campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {
	WebDriver driver;

	public CreatingNewCampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignname")
	private WebElement campaignNameEdt;

	public WebElement getCampaignNameEdt() {
		return campaignNameEdt;
	}

	@FindBy(xpath = "//input[@name='product_name']/following-sibling::img")
	private WebElement productSelectButton;

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getProductSelectButton() {
		return productSelectButton;
	}

}
