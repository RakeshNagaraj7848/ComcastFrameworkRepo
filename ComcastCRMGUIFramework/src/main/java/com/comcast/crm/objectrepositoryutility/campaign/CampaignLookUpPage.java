package com.comcast.crm.objectrepositoryutility.campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignLookUpPage {
	WebDriver driver;

	public CampaignLookUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement searchField;

	@FindBy(name = "search")
	private WebElement searchNowBtn;

	public void searchCampaignName(String campaignName) {
		searchField.sendKeys(campaignName);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='" +campaignName+ "']")).click();

	}

}
