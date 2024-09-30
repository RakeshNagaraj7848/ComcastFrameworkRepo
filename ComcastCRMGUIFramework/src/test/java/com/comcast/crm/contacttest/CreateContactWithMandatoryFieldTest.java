package com.comcast.crm.contacttest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.contact.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.contact.ContactsPage;
import com.comcast.crm.objectrepositoryutility.contact.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.home.HomePage;

public class CreateContactWithMandatoryFieldTest extends BaseClass {

	@Test(invocationCount = 2, threadPoolSize = 2)
	public void createContactWithMandatoryFieldTest() throws EncryptedDocumentException, IOException {

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
}
