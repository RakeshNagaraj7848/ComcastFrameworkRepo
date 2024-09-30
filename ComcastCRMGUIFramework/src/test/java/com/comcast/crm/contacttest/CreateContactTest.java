package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.contact.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.contact.ContactsPage;
import com.comcast.crm.objectrepositoryutility.contact.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsLookupPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsPage;

public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContactWithMandatoryFieldTest() throws EncryptedDocumentException, IOException {
		System.out.println("createContactWithMandatoryFieldTest ");

		HomePage homePage = new HomePage(driver);
		ContactsPage contactPage = new ContactsPage(driver);
		CreatingNewContactPage creatingNewContactPage = new CreatingNewContactPage(driver);
		ContactInformationPage contactInformationPage = new ContactInformationPage(driver);

		int randomInt = jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + randomInt;

		homePage.getContactsLink().click();

		contactPage.getCreateContactButton().click();

		creatingNewContactPage.createContact(lastName);

		contactInformationPage.waitUntilContactInformationPageLoad(driver);

		contactInformationPage.validatingContactHeaderNameInContactInformationPage(lastName);

		contactInformationPage.validatingLastNameInContactInformationPage(lastName);

	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws IOException, InterruptedException {
		System.out.println("createContactWithSupportDateTest ");

		HomePage homePage = new HomePage(driver);
		ContactsPage contactPage = new ContactsPage(driver);
		CreatingNewContactPage creatingNewContactPage = new CreatingNewContactPage(driver);
		ContactInformationPage contactInformationPage = new ContactInformationPage(driver);

		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		String actualDate = jLib.getSystemDateyyyymmdd();
		String dateRequired = jLib.getRequiredDateyyyymmdd(30);

		homePage.getContactsLink().click();

		contactPage.getCreateContactButton().click();

		creatingNewContactPage.getLastNameEdt().sendKeys(lastName);

		creatingNewContactPage.getSupportStartDateEdt().clear();
		creatingNewContactPage.getSupportStartDateEdt().sendKeys(actualDate);

		creatingNewContactPage.getSupportEndtDateEdt().clear();
		creatingNewContactPage.getSupportEndtDateEdt().sendKeys(dateRequired);
		creatingNewContactPage.getSaveButton().click();

		contactInformationPage.waitUntilContactInformationPageLoad(driver);

		contactInformationPage.validatingSupportStartDateInContactInfoPage(actualDate);

		contactInformationPage.validatingSupportEndDateInContactInfoPage(dateRequired);

	}

	@Test(groups = "regressionTest")
	public void createContactWithOrganisationSwitchingContactTest() throws IOException, InterruptedException {
		System.out.println("createContactWithOrganisationSwitchingContactTest ");

		HomePage homePage = new HomePage(driver);
		ContactsPage contactPage = new ContactsPage(driver);
		CreatingNewContactPage creatingNewContactPage = new CreatingNewContactPage(driver);
		ContactInformationPage contactInformationPage = new ContactInformationPage(driver);
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		CreatingNewOrganizationPage creatingNewOrganizationPage = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);
		OrganizationsLookupPage organizationsLookupPage = new OrganizationsLookupPage(driver);

		int randomInt = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("org", 5, 2) + randomInt;
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + randomInt;
		String organizationPagePartialURL = eLib.getDataFromExcel("partialURL", 3, 1);
		String contactPagePartialURL = eLib.getDataFromExcel("partialURL", 4, 1);

		homePage.getOrgLink().click();

		organizationsPage.getCreateNewOrgBtn().click();

		creatingNewOrganizationPage.createOrganization(orgName);

		organizationInformationPage.waitUntilOrganizationInformationPageLoad(driver);

		organizationInformationPage.validatingOrgHeaderNameInOrgInformationPage(orgName);

		organizationInformationPage.validatingOrgNameInOrgInformationPage(orgName);

		homePage.getContactsLink().click();

		contactPage.getCreateContactButton().click();

		creatingNewContactPage.getLastNameEdt().sendKeys(lastName);

		creatingNewContactPage.getOrganizationNameEdtBtn().click();

		wLib.switchToTabonURL(driver, organizationPagePartialURL);

		organizationsLookupPage.searchOrganizationName(orgName);

		wLib.switchToTabonURL(driver, contactPagePartialURL);

		creatingNewContactPage.getSaveButton().click();

		contactInformationPage.waitUntilContactInformationPageLoad(driver);

		contactInformationPage.validatingContactHeaderNameInContactInformationPage(lastName);

		contactInformationPage.validatingLastNameInContactInformationPage(lastName);

	}

}
