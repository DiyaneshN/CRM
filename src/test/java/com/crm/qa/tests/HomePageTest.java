package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilazation();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void HomepagetitleTest() throws InterruptedException
	{
		Thread.sleep(20000);
		String title = homepage.HomepageTitle();
		Assert.assertEquals(title, "Siebel Web Call Center Home","HomePage Title doesn't match");
	}
	
	@Test(priority=2)
	public void logoutTest() throws InterruptedException
	{
		Thread.sleep(20000);
		loginpage=homepage.logout();
	}
	@Test(priority=3)
	public void ContactslinkTest() throws InterruptedException 
	{
		Thread.sleep(20000);
		contactspage=homepage.clickonContacts();
		
	}

	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
