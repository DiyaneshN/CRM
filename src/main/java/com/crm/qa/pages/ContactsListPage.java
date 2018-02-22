package com.crm.qa.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsListPage extends TestBase{
	
	
	@FindBy(xpath="//button[@title='Contacts:New']")
	WebElement newrecord;
	
	@FindBy(name="Last_Name")
	WebElement LastName;
	
	@FindBy(name="First_Name")
	WebElement FirstName;
	
	@FindBy(name="M_M")
	WebElement Title;
	
	@FindBy(xpath="//span[@class='siebui-icon-mvg']")
	WebElement AccountMVG;
	
	@FindBy(xpath="//div[@title='Contacts List Applet']//button[@title='Contacts Menu']")
	WebElement ContactsMenu;
	
	@FindBy(xpath="//div[@title='Contacts List Applet']//a[contains(text(),'Save Record')]")
	WebElement saverecord;
	
	
	//Init Elements
	public ContactsListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void Createnewrecord(String LName,String FName,String title) throws Exception
	{
		newrecord.click();
		LastName.sendKeys(LName);
		LastName.sendKeys(Keys.TAB);
		FirstName.sendKeys(FName);
		FirstName.sendKeys(Keys.TAB);
		Title.sendKeys(title);
		ContactsMenu.click();
		saverecord.click();
	}

}
