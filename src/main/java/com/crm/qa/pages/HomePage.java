package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//button[@title='First Level View Bar']")
	WebElement L1viewbar;
	
	@FindBy(xpath="//li/a[text()='Accounts']")
	WebElement Accountslink;
	
	@FindBy(xpath="//li/a[text()='Contacts']")
	WebElement Contactslink;
	
	@FindBy(xpath="//li[@title='Settings']")
	WebElement Settings;
	
	@FindBy(xpath="//button[@title='Logout']")
	WebElement Logout;
	
	//Initialization
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String HomepageTitle()
	{
		return driver.getTitle();
	}
	
	public AccountsPage clickonAccounts()
	{
		L1viewbar.click();
		Accountslink.click();
		return new AccountsPage();
	}
	
	public ContactsPage clickonContacts() throws InterruptedException
	{
		L1viewbar.click();
		Thread.sleep(2000);
		Contactslink.click();
		return new ContactsPage();
	}
	
	public LoginPage logout()
	{
		Settings.click();
		Logout.click();
		return new LoginPage();
	}
}
