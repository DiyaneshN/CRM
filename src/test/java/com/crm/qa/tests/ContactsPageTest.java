package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initilazation();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(20000);
		contactspage=homepage.clickonContacts();
	}
	
	@Test(priority=1)
	public void contactspagetitleTest() throws InterruptedException
	{
		Thread.sleep(10000);
		String title = contactspage.contactspagetitle();
		Assert.assertEquals(title, "Contact Home: AATestLastName_12042017_235019480 AATestLastName_12042017_23501232");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
