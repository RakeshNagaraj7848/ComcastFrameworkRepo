package com.comcast.crm.orgtest;

import java.io.IOException;
import org.testng.annotations.Test;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsPage;

public class DeleteOrganisationTest extends BaseClass {

	@Test
	public void deleteOrganisationTest() throws IOException, InterruptedException {

		HomePage homePage = new HomePage(driver);
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		CreatingNewOrganizationPage creatingNewOrganizationPage = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);

		String orgName = eLib.getDataFromExcel("org", 19, 2) + jLib.getRandomNumber();
		String organizationNameDRoDown = eLib.getDataFromExcel("org", 19, 3);

		homePage.getOrgLink().click();

		organizationsPage.getCreateNewOrgBtn().click();

		creatingNewOrganizationPage.createOrganization(orgName);

		organizationInformationPage.waitUntilOrganizationInformationPageLoad(driver);

		organizationInformationPage.validatingOrgHeaderNameInOrgInformationPage(orgName);

		organizationInformationPage.validatingOrgNameInOrgInformationPage(orgName);

		organizationsPage.deleteOrganization(orgName, organizationNameDRoDown, driver);

		organizationsPage.validatingDeletdOrganization(orgName, organizationNameDRoDown);

	}
}
