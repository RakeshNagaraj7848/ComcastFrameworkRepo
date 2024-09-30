package com.comcast.crm.objectrepositoryutility.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")
	private WebElement signOutLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;



	@FindBy(xpath = "//a[text()='Leads']/parent::td[@class=\"tabUnSelected\"]")
	private WebElement leadsLinkLInk;
	
	
	@FindBy(xpath = "//a[text()='Opportunities']/parent::td[@class=\"tabUnSelected\"]")
	private WebElement opportunitiesLink;

	
	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}



	public WebElement getLeadsLinkLInk() {
		return leadsLinkLInk;
	}

	

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreLink;

	@FindBy(xpath = "//a[@id=\"more\" and @name=\"Invoice\"]")
	private WebElement invoiceLink;

	@FindBy(xpath = "//a[text()='Sales Order' and @id='more']")
	private WebElement salesOrderLink;

	@FindBy(xpath = "//a[@id='more'and  @name='Campaigns']")
	private WebElement campaignLink;

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getSalesOrderLink() {
		return salesOrderLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public void signOut(WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(adminImg).perform();
		signOutLink.click();

	}

	public void naviagateToSalesOrderPage(WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(moreLink).perform();
		salesOrderLink.click();

	}

	public void naviagateToCampaignPage(WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(moreLink).perform();
		campaignLink.click();

	}

}
