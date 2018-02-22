package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//a[text()='My Contacts']")
	WebElement mycontacts;
	
	//Initialization GIT Check
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String contactspagetitle()
	{
		return driver.getTitle();
	}
	public ContactsListPage clickonMycontactslink()
	{
		mycontacts.click();
		return new ContactsListPage();
	}
	

}
