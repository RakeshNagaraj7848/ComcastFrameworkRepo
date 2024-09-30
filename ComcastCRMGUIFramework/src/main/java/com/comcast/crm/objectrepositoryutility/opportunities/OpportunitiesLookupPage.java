package com.comcast.crm.objectrepositoryutility.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesLookupPage {

	WebDriver driver;

	public OpportunitiesLookupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_text")
	private WebElement searchField;

	@FindBy(name = "search")
	private WebElement searchNowBtn;

	public void searchOpportunityName(String opportunityName) {
		searchField.sendKeys(opportunityName);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='" + opportunityName + "']")).click();
	}

}
