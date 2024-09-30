package com.comcast.crm.orgtest;

import java.io.IOException;
import org.testng.annotations.Test;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsPage;

public class CreateOrganisationWithIndustryAndTypeTest extends BaseClass {

	@Test
	public void createOrganisationWithIndustryAndTypeTest() throws IOException, InterruptedException {

		HomePage homePage = new HomePage(driver);
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		CreatingNewOrganizationPage createNewOrganizationPage = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);

		String orgName = eLib.getDataFromExcel("org", 5, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 5, 3);
		String type = eLib.getDataFromExcel("org", 5, 4);

		homePage.getOrgLink().click();

		organizationsPage.getCreateNewOrgBtn().click();

		createNewOrganizationPage.getOrganizationNameEdt().sendKeys(orgName);

		wLib.select(createNewOrganizationPage.getIndustryDropDown(), industry);

		wLib.select(createNewOrganizationPage.getTypeDropDown(), type);

		createNewOrganizationPage.getSaveBtn().click();

		organizationInformationPage.waitUntilOrganizationInformationPageLoad(driver);
		organizationInformationPage.validatingOrgHeaderNameInOrgInformationPage(orgName);
		organizationInformationPage.validatingOrgNameInOrgInformationPage(orgName);
		organizationInformationPage.validatingIndustryInOrgInfoPage(industry);
		organizationInformationPage.validatingTypeInOrgInfoPage(type);

	}
}
