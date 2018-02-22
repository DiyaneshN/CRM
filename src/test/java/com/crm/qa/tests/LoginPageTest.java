package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilazation();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void pagetitleTest()
	{
		String title = loginpage.Loginpagetitle();
		Assert.assertEquals(title, "Siebel Call Center");
	}
	
	@Test(priority=2)
	public void oraclelogoTest()
	{
		boolean logo =loginpage.oraclelogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
