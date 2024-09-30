package com.comcast.crm.salesordertest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.opportunities.CreatingNewOpportunityPage;
import com.comcast.crm.objectrepositoryutility.opportunities.OpportunitiesLookupPage;
import com.comcast.crm.objectrepositoryutility.opportunities.OpportunitiesPage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsLookupPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.product.CreatingNewProductPage;
import com.comcast.crm.objectrepositoryutility.product.ProductsLookupPage;
import com.comcast.crm.objectrepositoryutility.product.ProductsPage;
import com.comcast.crm.objectrepositoryutility.salesorder.CreatingNewSalesOrderPage;
import com.comcast.crm.objectrepositoryutility.salesorder.SalesOrderInformationPage;
import com.comcast.crm.objectrepositoryutility.salesorder.SalesOrderPage;

public class CreateSalesOrderTest extends BaseClass {

	@Test
	public void createSalesOrderTest() throws EncryptedDocumentException, IOException {

		HomePage homePage = new HomePage(driver);
		SalesOrderPage salesOrderPage = new SalesOrderPage(driver);
		CreatingNewSalesOrderPage CreatingNewSalesOrderPage = new CreatingNewSalesOrderPage(driver);
		OpportunitiesPage OpportunitiesPage = new OpportunitiesPage(driver);
		CreatingNewOpportunityPage CreatingNewOpportunityPage = new CreatingNewOpportunityPage(driver);
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		CreatingNewOrganizationPage creatingNewOrganizationPage = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);
		OrganizationsLookupPage organizationsLookupPage = new OrganizationsLookupPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CreatingNewProductPage CreatingNewProductPage = new CreatingNewProductPage(driver);
		OpportunitiesLookupPage opportunitiesLookupPage = new OpportunitiesLookupPage(driver);
		ProductsLookupPage ProductsLookupPage = new ProductsLookupPage(driver);
		SalesOrderInformationPage salesOrderInformationPage = new SalesOrderInformationPage(driver);

		String orgName = eLib.getDataFromExcel("salesorder", 1, 2) + jLib.getRandomNumber();
		String opportunityName = eLib.getDataFromExcel("salesorder", 1, 3) + jLib.getRandomNumber();
		String subject = eLib.getDataFromExcel("salesorder", 1, 4) + jLib.getRandomNumber();
		String billingAddress = eLib.getDataFromExcel("salesorder", 1, 5) + jLib.getRandomNumber();
		String shippingAddress = eLib.getDataFromExcel("salesorder", 1, 6) + jLib.getRandomNumber();
		String productName = eLib.getDataFromExcel("salesorder", 1, 7) + jLib.getRandomNumber();
		String itemQuantity = eLib.getDataFromExcel("salesorder", 1, 8);
		String opportunityPartialURL = eLib.getDataFromExcel("partialURL", 6, 1);
		String organizationPartialURL = eLib.getDataFromExcel("partialURL", 3, 1);
		String productPartialURL = eLib.getDataFromExcel("partialURL", 1, 1);
		String salesOrderPartialURL = eLib.getDataFromExcel("partialURL", 7, 1);

		homePage.getOrgLink().click();
		organizationsPage.getCreateNewOrgBtn().click();
		creatingNewOrganizationPage.createOrganization(orgName);
		organizationInformationPage.waitUntilOrganizationInformationPageLoad(driver);
		organizationInformationPage.validatingOrgHeaderNameInOrgInformationPage(orgName);
		organizationInformationPage.validatingOrgNameInOrgInformationPage(orgName);

		homePage.getOpportunitiesLink().click();
		OpportunitiesPage.getCreateopportunitieseBtn().click();
		CreatingNewOpportunityPage.getOpportunityNameEdt().sendKeys(opportunityName);
		CreatingNewOpportunityPage.getRelatedToOrgNameBtn().click();
		wLib.switchToTabonURL(driver, organizationPartialURL);
		organizationsLookupPage.searchOrganizationName(orgName);
		wLib.switchToTabonURL(driver, opportunityPartialURL);
		CreatingNewOpportunityPage.getSaveBtn().click();

		homePage.getProductsLink().click();
		productsPage.getCreateProductButton().click();
		CreatingNewProductPage.getProductNameEdt().sendKeys(productName);
		CreatingNewProductPage.getSaveBtn().click();

		homePage.naviagateToSalesOrderPage(driver);
		salesOrderPage.getCreateSalesOrderBtn().click();

		CreatingNewSalesOrderPage.getSubjectEdt().sendKeys(subject);

		CreatingNewSalesOrderPage.getOpportunityNameBtn().click();
		wLib.switchToTabonURL(driver, opportunityPartialURL);
		opportunitiesLookupPage.searchOpportunityName(opportunityName);
		wLib.switchToTabonURL(driver, salesOrderPartialURL);

		CreatingNewSalesOrderPage.getOrganizationNameEdt().click();
		wLib.switchToTabonURL(driver, organizationPartialURL);
		organizationsLookupPage.searchOrganizationName(orgName);
		wLib.switchToAlertAndAccept(driver);
		wLib.switchToTabonURL(driver, salesOrderPartialURL);

		CreatingNewSalesOrderPage.getBillingAddress().sendKeys(billingAddress);
		CreatingNewSalesOrderPage.getShippingAddress().sendKeys(shippingAddress);

		CreatingNewSalesOrderPage.getItemSearchIcon().click();
		wLib.switchToTabonURL(driver, productPartialURL);
		ProductsLookupPage.searchProductName(productName);
		wLib.switchToTabonURL(driver, salesOrderPartialURL);

		CreatingNewSalesOrderPage.getQuantityEdt().sendKeys(itemQuantity);

		CreatingNewSalesOrderPage.getSaveBtn().click();

		salesOrderInformationPage.waitForSalesOrderInformationPageToLOad(driver);
		salesOrderInformationPage.validateHeaderInSalesOrderInformationPage(subject);
		salesOrderInformationPage.validateSujectInSalesOrderInformationPage(subject);
		salesOrderInformationPage.validateItemNameInSalesOrderInformationPage(productName);
		salesOrderInformationPage.validateItemQuantityInSalesOrderInformationPage(itemQuantity);
		salesOrderInformationPage.validateOrganizationNameInSalesOrderInformationPage(orgName);
		salesOrderInformationPage.validateOpportunityNameInSalesOrderInformationPage(opportunityName);

	}

}
