package com.comcast.crm.invoicetest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.invoice.CreatingNewInvoicePage;
import com.comcast.crm.objectrepositoryutility.invoice.InvoiceInformationPage;
import com.comcast.crm.objectrepositoryutility.invoice.InvoicePage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsLookupPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.product.CreatingNewProductPage;
import com.comcast.crm.objectrepositoryutility.product.ProductsLookupPage;
import com.comcast.crm.objectrepositoryutility.product.ProductsPage;

public class CreateInvoiceWithOrganizationandItemTest extends BaseClass {

	@Test
	public void createInvoiceWithOrganizationandItemTest() throws EncryptedDocumentException, IOException {

		HomePage homePage = new HomePage(driver);
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		CreatingNewOrganizationPage creatingNewOrganizationPage = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CreatingNewProductPage creatingNewProductPage = new CreatingNewProductPage(driver);
		InvoicePage invoicePage = new InvoicePage(driver);
		CreatingNewInvoicePage creatingNewInvoicePage = new CreatingNewInvoicePage(driver);
		OrganizationsLookupPage organizationsLookupPage = new OrganizationsLookupPage(driver);
		ProductsLookupPage productsLookupPage = new ProductsLookupPage(driver);
		InvoiceInformationPage invoiceInformationPage = new InvoiceInformationPage(driver);

		String orgName = eLib.getDataFromExcel("org", 5, 2).toString() + jLib.getRandomNumber();
		String productName = eLib.getDataFromExcel("invoice", 1, 2) + jLib.getRandomNumber();
		String subject = eLib.getDataFromExcel("invoice", 1, 3) + jLib.getRandomNumber();
		String billingAddress = eLib.getDataFromExcel("invoice", 1, 4) + jLib.getRandomNumber();
		String shippingAddress = eLib.getDataFromExcel("invoice", 1, 5) + jLib.getRandomNumber();
		String quantity = eLib.getDataFromExcel("invoice", 1, 6);
		String campaignPagePartialURL = eLib.getDataFromExcel("partialURL", 2, 1);
		String invoicePagePartialURL = eLib.getDataFromExcel("partialURL", 5, 1);
		String productPagePartialURL = eLib.getDataFromExcel("partialURL", 1, 1);

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

		wLib.mouseMoveOnElement(driver, homePage.getMoreLink());
		homePage.getInvoiceLink().click();
		invoicePage.getCreateInvoiceBtn().click();

		creatingNewInvoicePage.getSubjecttNameEdt().sendKeys(subject);

		creatingNewInvoicePage.getOrgnizationNameBtn().click();

		wLib.switchToTabonURL(driver, campaignPagePartialURL);

		organizationsLookupPage.searchOrganizationName(orgName);

		wLib.switchToAlertAndAccept(driver);

		wLib.switchToTabonURL(driver, invoicePagePartialURL);

		creatingNewInvoicePage.getBillingAddressEdt().sendKeys(billingAddress);
		creatingNewInvoicePage.getShippingAddressEdt().sendKeys(shippingAddress);

		creatingNewInvoicePage.getItemNameSearchBtn().click();

		wLib.switchToTabonURL(driver, productPagePartialURL);

		productsLookupPage.searchProductName(productName);

		wLib.switchToTabonURL(driver, invoicePagePartialURL);
		wLib.javascriptExecutorScrollBy(driver, 0, 700);

		creatingNewInvoicePage.getItemQuantityEdt().sendKeys(quantity);

		creatingNewInvoicePage.getSaveBtn().click();
		invoiceInformationPage.waitForInvoiceInformationPageToLOad(driver);
		invoiceInformationPage.validateHeaderInInvoiceInformationPage(subject);
		invoiceInformationPage.validateSujectInInvoiceInformationPage(subject);
		invoiceInformationPage.validateItemNameIninvoiceInformationPage(productName);
		invoiceInformationPage.validateItemQuantityIninvoiceInformationPage(quantity);
		invoiceInformationPage.validateOrganizationNameIninvoiceInformationPage(orgName);

	}

}
