package com.comcast.crm.objectrepositoryutility.opportunities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOpportunityPage {

	WebDriver driver;

	public CreatingNewOpportunityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "potentialname")
	private WebElement OpportunityNameEdt;

	public WebElement getRelatedToOrgNameBtn() {
		return relatedToOrgNameBtn;
	}

	@FindBy(xpath = "//input[@id=\"related_to_display\"]/following-sibling::img")
	private WebElement relatedToOrgNameBtn;
	
	
	
	@FindBy(xpath = "//input[@name=\"campaignname\"]/following-sibling::img")
	private WebElement campaignSourceBtn;

	public WebElement getCampaignSourceBtn() {
		return campaignSourceBtn;
	}

	public WebElement getOpportunityNameEdt() {
		return OpportunityNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement saveBtn;

}
