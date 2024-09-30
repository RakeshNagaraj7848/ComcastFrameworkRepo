package com.comcast.crm.objectrepositoryutility.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsLookupPage {

	WebDriver driver;

	public ProductsLookupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_text")
	private WebElement searchField;

	@FindBy(name = "search")
	private WebElement searchNowBtn;

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public void searchProductName(String productName) {
		searchField.sendKeys(productName);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
	}

}
