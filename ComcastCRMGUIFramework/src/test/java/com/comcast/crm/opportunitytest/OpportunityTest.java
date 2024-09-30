package com.comcast.crm.opportunitytest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.campaign.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.campaign.CampaignLookUpPage;
import com.comcast.crm.objectrepositoryutility.campaign.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.campaign.CreatingNewCampaignPage;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.opportunities.CreatingNewOpportunityPage;
import com.comcast.crm.objectrepositoryutility.opportunities.OpportunitiesPage;
import com.comcast.crm.objectrepositoryutility.opportunities.OpportunityInformationPage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsLookupPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.product.CreatingNewProductPage;
import com.comcast.crm.objectrepositoryutility.product.ProductsLookupPage;
import com.comcast.crm.objectrepositoryutility.product.ProductsPage;

public class OpportunityTest extends BaseClass {

	@Test
	public void opportunityWithCampaginOrganizationTest() throws EncryptedDocumentException, IOException {
		HomePage homePage = new HomePage(driver);
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		CreatingNewOrganizationPage creatingNewOrganizationPage = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CreatingNewProductPage creatingNewProductPage = new CreatingNewProductPage(driver);
		CampaignsPage campaignPage = new CampaignsPage(driver);
		CreatingNewCampaignPage creatingNewCampaignPage = new CreatingNewCampaignPage(driver);
		ProductsLookupPage ProductsLookupPage = new ProductsLookupPage(driver);
		CampaignInformationPage campaignInformationPage = new CampaignInformationPage(driver);
		OpportunitiesPage opportunitiesPage = new OpportunitiesPage(driver);
		CreatingNewOpportunityPage creatingNewOpportunityPage = new CreatingNewOpportunityPage(driver);
		OrganizationsLookupPage OrganizationsLookupPage = new OrganizationsLookupPage(driver);
		CampaignLookUpPage CampaignLookUpPage = new CampaignLookUpPage(driver);
		OpportunityInformationPage OpportunityInformationPage = new OpportunityInformationPage(driver);

		String orgName = eLib.getDataFromExcel("opportunities", 1, 0).toString() + jLib.getRandomNumber();
		String productName = eLib.getDataFromExcel("opportunities", 1, 1) + jLib.getRandomNumber();
		String campaignName = eLib.getDataFromExcel("opportunities", 1, 2) + jLib.getRandomNumber();
		String opportunityName = eLib.getDataFromExcel("opportunities", 1, 3) + jLib.getRandomNumber();

		String campaignPagePartialURL = eLib.getDataFromExcel("partialURL", 2, 1);
		String productPagePartialURL = eLib.getDataFromExcel("partialURL", 1, 1);
		String organizationPagePartialURL = eLib.getDataFromExcel("partialURL", 3, 1);
		String opportunityPagePartialURL = eLib.getDataFromExcel("partialURL", 6, 1);

		homePage.getOrgLink().click();
		organizationsPage.getCreateNewOrgBtn().click();
		creatingNewOrganizationPage.createOrganization(orgName);
		organizationInformationPage.waitUntilOrganizationInformationPageLoad(driver);
		organizationInformationPage.validatingOrgHeaderNameInOrgInformationPage(orgName);
		organizationInformationPage.validatingOrgNameInOrgInformationPage(orgName);

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

		homePage.getOpportunitiesLink().click();
		opportunitiesPage.getCreateopportunitieseBtn().click();

		creatingNewOpportunityPage.getOpportunityNameEdt().sendKeys(opportunityName);
		creatingNewOpportunityPage.getRelatedToOrgNameBtn().click();
		wLib.switchToTabonURL(driver, organizationPagePartialURL);
		OrganizationsLookupPage.searchOrganizationName(orgName);
		wLib.switchToTabonURL(driver, opportunityPagePartialURL);

		creatingNewOpportunityPage.getCampaignSourceBtn().click();
		wLib.switchToTabonURL(driver, campaignPagePartialURL);
		CampaignLookUpPage.searchCampaignName(campaignName);
		wLib.switchToTabonURL(driver, opportunityPagePartialURL);
		creatingNewOpportunityPage.getSaveBtn().click();
		OpportunityInformationPage.waitForOpportunityInformationPageToLOad(driver);

		OpportunityInformationPage.validatingHeaderInfoInOpportunityInformationPage(opportunityName);
		OpportunityInformationPage.validatingopportunityNameInOpportunityInformationPage(opportunityName);
		OpportunityInformationPage.validatingCampaignNameInOpportunityInformationPage(campaignName);
		OpportunityInformationPage.validatingorganizationNameInOpportunityInformationPage(orgName);

	}
}