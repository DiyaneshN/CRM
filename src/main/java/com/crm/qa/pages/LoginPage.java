package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object Repository
	
	@FindBy(name="SWEUserName")
	WebElement username;
	
	@FindBy(name="SWEPassword")
	WebElement password;
	
	@FindBy(xpath="//*[contains(@onclick,'SWEExecuteLogin')]")
	WebElement loginbtn;
	
	@FindBy(id="loginLogo")
	WebElement oraclelogo;
	
	//PageFactory Initialization
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public HomePage login(String un,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbtn.click();
		
		return new HomePage();
	}
	
	public String Loginpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean oraclelogo()
	{
		return oraclelogo.isDisplayed();
	}

}
