package com.comcast.crm.orgtest;

import java.io.IOException;

import org.testng.annotations.Test;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.organization.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.organization.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createOrganisationWithMandatoryFieldTest() throws IOException, InterruptedException {
		System.out.println("createOrganisationWithMandatoryFieldTest ");

		HomePage homePage = new HomePage(driver);
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		CreatingNewOrganizationPage creatingNewOrganizationPage = new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);

		String orgName = eLib.getDataFromExcel("org", 5, 2).toString() + jLib.getRandomNumber();

		homePage.getOrgLink().click();

		organizationsPage.getCreateNewOrgBtn().click();

		creatingNewOrganizationPage.createOrganization(orgName);

		organizationInformationPage.waitUntilOrganizationInformationPageLoad(driver);

		organizationInformationPage.validatingOrgHeaderNameInOrgInformationPage(orgName);

		organizationInformationPage.validatingOrgNameInOrgInformationPage(orgName);

	}

	@Test(groups = "regressionTest")
	public void createOrganisationWithIndustryAndTypeTest() throws IOException, InterruptedException {
		System.out.println("createOrganisationWithIndustryAndTypeTest ");
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

	@Test(groups = "regressionTest")
	public void createOrganisationWithPhoneNumberTest() throws IOException, InterruptedException {
		System.out.println("createOrganisationWithPhoneNumberTest ");
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

	@Test(groups = "regressionTest")
	public void deleteOrganisationTest() throws IOException, InterruptedException {
		System.out.println("deleteOrganisationTest ");
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

	}

}
