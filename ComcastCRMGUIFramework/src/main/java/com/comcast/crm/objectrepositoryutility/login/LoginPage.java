package com.comcast.crm.objectrepositoryutility.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement userNameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordNameEdt;

	@FindBy(id = "submitButton")
	private WebElement submitBtn;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordNameEdt() {
		return passwordNameEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void loginToAppplication(String username, String password) {

		userNameEdt.sendKeys(username);
		passwordNameEdt.sendKeys(password);
		submitBtn.click();
	}

}
