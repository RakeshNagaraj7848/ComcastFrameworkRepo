package com.comcast.crm.objectrepositoryutility.campaign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CampaignInformationPage {
	WebDriver driver;
	WebDriverUtility wLib = new WebDriverUtility();
	SoftAssert softAssert = new SoftAssert();

	public CampaignInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement campaignHeaderInfo;

	public WebElement getCampaignHeaderInfo() {
		return campaignHeaderInfo;
	}

	public void setCampaignHeaderInfo(WebElement campaignHeaderInfo) {
		this.campaignHeaderInfo = campaignHeaderInfo;
	}

	public WebElement getCampaignNameInCampaignInfoPage() {
		return campaignNameInCampaignInfoPage;
	}

	public void setCampaignNameInCampaignInfoPage(WebElement campaignNameInCampaignInfoPage) {
		this.campaignNameInCampaignInfoPage = campaignNameInCampaignInfoPage;
	}

	public WebElement getProductNameInCampaignInfoPage() {
		return productNameInCampaignInfoPage;
	}

	public void setProductNameInCampaignInfoPage(WebElement productNameInCampaignInfoPage) {
		this.productNameInCampaignInfoPage = productNameInCampaignInfoPage;
	}

	@FindBy(id = "mouseArea_Campaign Name")
	private WebElement campaignNameInCampaignInfoPage;

	@FindBy(id = "mouseArea_Product")
	private WebElement productNameInCampaignInfoPage;

	public void waitUntilCampaignInformationPageLoad(WebDriver driver) {
		wLib.waitForElementPresent(driver, campaignHeaderInfo);

	}

	public void validatingCampaignHeaderInfoInCampaignInfoPage(String campaginName) {

		String actualCampaignName = campaignHeaderInfo.getText();

		Assert.assertEquals(actualCampaignName.contains(campaginName), true);
	}

	public void validatingCampaignNameInCampaignInfoPage(String campaginName) {

		String actualCampaignName = campaignNameInCampaignInfoPage.getText();

		Assert.assertEquals(actualCampaignName.contains(campaginName), true);

	}

	public void validatingProductNameInCampaignInfoPage(String productName) {

		String actualProductName = productNameInCampaignInfoPage.getText();
		softAssert.assertNotEquals(actualProductName, productName);
		softAssert.assertAll();
	}

}
