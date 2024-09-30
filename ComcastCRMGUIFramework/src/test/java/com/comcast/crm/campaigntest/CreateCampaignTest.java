package com.comcast.crm.campaigntest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.campaign.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.campaign.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.campaign.CreatingNewCampaignPage;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.product.CreatingNewProductPage;
import com.comcast.crm.objectrepositoryutility.product.ProductsLookupPage;
import com.comcast.crm.objectrepositoryutility.product.ProductsPage;

public class CreateCampaignTest extends BaseClass {

	@Test
	public void createCampaignWithProductTest() throws EncryptedDocumentException, IOException {

		HomePage homePage = new HomePage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CreatingNewProductPage creatingNewProductPage = new CreatingNewProductPage(driver);
		CampaignsPage campaignPage = new CampaignsPage(driver);
		CreatingNewCampaignPage creatingNewCampaignPage = new CreatingNewCampaignPage(driver);
		ProductsLookupPage ProductsLookupPage = new ProductsLookupPage(driver);
		CampaignInformationPage campaignInformationPage = new CampaignInformationPage(driver);

		String productName = eLib.getDataFromExcel("campaign", 1, 0) + jLib.getRandomNumber();
		String campaignName = eLib.getDataFromExcel("campaign", 1, 1) + jLib.getRandomNumber();
		String campaignPagePartialURL = eLib.getDataFromExcel("partialURL", 2, 1);
		String productPagePartialURL = eLib.getDataFromExcel("partialURL", 1, 1);

		homePage.getProductsLink().click();

		productsPage.getCreateProductButton().click();
		creatingNewProductPage.getProductNameEdt().sendKeys(productName);

		creatingNewProductPage.getSaveBtn().click();

		homePage.naviagateToCampaignPage(driver);

		campaignPage.getCreateCampaignBtn().click();

		creatingNewCampaignPage.getCampaignNameEdt().sendKeys(campaignName);

		creatingNewCampaignPage.getProductSelectButton().click();

		wLib.switchToTabonURL(driver, productPagePartialURL);
		ProductsLookupPage.searchProductName(productName);

		wLib.switchToTabonURL(driver, campaignPagePartialURL);

		creatingNewCampaignPage.getSaveBtn().click();

		campaignInformationPage.waitUntilCampaignInformationPageLoad(driver);
		campaignInformationPage.validatingCampaignHeaderInfoInCampaignInfoPage(campaignName);
		campaignInformationPage.validatingCampaignNameInCampaignInfoPage(campaignName);
		campaignInformationPage.validatingProductNameInCampaignInfoPage(productName);

	}

}
