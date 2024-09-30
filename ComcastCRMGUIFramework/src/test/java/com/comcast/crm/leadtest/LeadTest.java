package com.comcast.crm.leadtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.home.HomePage;
import com.comcast.crm.objectrepositoryutility.leads.CreatingNewLeadPage;
import com.comcast.crm.objectrepositoryutility.leads.LeadInformationPage;
import com.comcast.crm.objectrepositoryutility.leads.LeadsPage;

public class LeadTest extends BaseClass {

	@Test
	public void createLeadTest() throws EncryptedDocumentException, IOException {
		HomePage homePage = new HomePage(driver);
		LeadsPage leadsPage = new LeadsPage(driver);
		CreatingNewLeadPage creatingNewLeadPage = new CreatingNewLeadPage(driver);
		LeadInformationPage leadInformationPage = new LeadInformationPage(driver);

		String lastName = eLib.getDataFromExcel("leads", 1, 0) + jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("leads", 1, 1) + jLib.getRandomNumber();

		homePage.getLeadsLinkLInk().click();
		leadsPage.getCreateLeadBtn().click();
		creatingNewLeadPage.createLeadWithMandatoryInformation(lastName, company);
		leadInformationPage.waitForOpportunityInformationPageToLOad(driver);

		leadInformationPage.validatingLastNameInHeaderInLeadInformationPage(lastName);
		leadInformationPage.validatingLastNameInLeadInformationPage(lastName);
		leadInformationPage.validatingCompanyInLeadInformationPage(company);

	}

}
