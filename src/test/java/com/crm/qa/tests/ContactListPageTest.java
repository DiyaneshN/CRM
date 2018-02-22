package com.crm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsListPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactListPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	ContactsListPage contactslistpage;
	TestUtil testutil = new TestUtil();
	
	public ContactListPageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setup() throws InterruptedException
	{
		initilazation();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(20000);
		contactspage=homepage.clickonContacts();
		Thread.sleep(20000);
		contactslistpage=contactspage.clickonMycontactslink();
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data = testutil.gettestdata("Contacts");
		return data;
	}
	
	@Test(dataProvider="getdata")
	public void createreordTest(String Lname, String Fname, String title) throws Exception
	{
		Thread.sleep(20000);
		contactslistpage.Createnewrecord(Lname, Fname, title);
	}
	
	@AfterMethod()
	public void teardown()
	{
		driver.quit();
	}

}
