package com.comcast.crm.orgtest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsPage;
//@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class CreateOrganisationWithPhoneNumberTest extends BaseClass {
	@Test
	public void createOrganisationWithPhoneNumberTest() throws IOException, InterruptedException {

		HomePage homePage = new HomePage(driver);
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		CreatingNewOrganizationPage createNewOrganizationPage = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);

		String orgName = eLib.getDataFromExcel("org", 9, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 9, 3);

		homePage.getOrgLink().click();

		organizationsPage.getCreateNewOrgBtn().click();

		createNewOrganizationPage.getOrganizationNameEdt().sendKeys(orgName);

		createNewOrganizationPage.getPhoneNumberEdt().sendKeys(phoneNumber);

		createNewOrganizationPage.getSaveBtn().click();

		organizationInformationPage.waitUntilOrganizationInformationPageLoad(driver);
		organizationInformationPage.validatingOrgHeaderNameInOrgInformationPage(orgName);
		organizationInformationPage.validatingOrgNameInOrgInformationPage(orgName);
		organizationInformationPage.validatingPhoneNumberInOrgInfoPage(phoneNumber);

	}
}
