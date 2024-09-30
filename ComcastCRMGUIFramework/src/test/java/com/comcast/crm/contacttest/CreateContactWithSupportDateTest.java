package com.comcast.crm.contacttest;

import java.io.IOException;
import org.testng.annotations.Test;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.contact.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.contact.ContactsPage;
import com.comcast.crm.objectrepositoryutility.contact.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.home.HomePage;

public class CreateContactWithSupportDateTest extends BaseClass {

	@Test
	public void createContactWithSupportDateTest() throws IOException, InterruptedException {

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
}
