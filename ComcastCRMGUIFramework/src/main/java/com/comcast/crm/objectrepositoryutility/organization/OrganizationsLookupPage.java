package com.comcast.crm.objectrepositoryutility.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsLookupPage {

	WebDriver driver;

	public OrganizationsLookupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_text")
	private WebElement searchField;

	@FindBy(name = "search")
	private WebElement searchNowBtn;

	public void searchOrganizationName(String orgName) {
		searchField.sendKeys(orgName);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='" +orgName+ "']")).click();

	}

}
