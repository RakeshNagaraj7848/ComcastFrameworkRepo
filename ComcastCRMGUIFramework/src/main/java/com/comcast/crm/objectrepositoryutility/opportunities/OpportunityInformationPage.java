package com.comcast.crm.objectrepositoryutility.opportunities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OpportunityInformationPage {

	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();
	SoftAssert softAssert = new SoftAssert();

	public OpportunityInformationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getOpportunityNameInOpportunityInformationPage() {
		return opportunityNameInOpportunityInformationPage;
	}

	public WebElement getRelatedToOrgNameInOpportunityInformationPage() {
		return relatedToOrgNameInOpportunityInformationPage;
	}

	public WebElement getCampaignNameInOpportunityInformationPage() {
		return campaignNameInOpportunityInformationPage;
	}

	@FindBy(id = "mouseArea_Opportunity Name")
	private WebElement opportunityNameInOpportunityInformationPage;

	@FindBy(xpath = "//td[@class=\"dvtCellInfo\"]/../../../../../../../descendant::a[@title=\"Organizations\"]/..")
	private WebElement relatedToOrgNameInOpportunityInformationPage;

	@FindBy(xpath = "(//td[@class=\"dvtCellInfo\"])[11]")
	private WebElement campaignNameInOpportunityInformationPage;

	public void validatingHeaderInfoInOpportunityInformationPage(String oppurtunityName) {
		String actualOppurtunityName = headerInfo.getText();
		Assert.assertEquals(actualOppurtunityName.contains(oppurtunityName), true);

	}

	public void validatingopportunityNameInOpportunityInformationPage(String oppurtunityName) {
		String actualOppurtunityName = opportunityNameInOpportunityInformationPage.getText();
		Assert.assertEquals(actualOppurtunityName.contains(oppurtunityName), true);

	}

	public void validatingorganizationNameInOpportunityInformationPage(String orgName) {
		String actualOrgName = relatedToOrgNameInOpportunityInformationPage.getText();
		Assert.assertEquals(actualOrgName, orgName);
	}

	public void validatingCampaignNameInOpportunityInformationPage(String campaignName) {

		String actualCampaignName = campaignNameInOpportunityInformationPage.getText();
		softAssert.assertEquals(actualCampaignName.trim(), campaignName);

	}

	public void waitForOpportunityInformationPageToLOad(WebDriver driver) {
		wLib.waitForElementPresent(driver, headerInfo);
	}

}
