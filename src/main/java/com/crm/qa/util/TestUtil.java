package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.plaf.FileChooserUI;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICITWAIT = 60;
	static Workbook book;
	static Sheet sheet;
	
	public Object[][] gettestdata(String sheetname)
	{
		FileInputStream fp= null;
		try {
			fp = new FileInputStream("D:\\Maven_Projects\\pageobjectmodeltest\\src\\main\\java\\com\\crm\\qa\\testdata\\Testdata.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fp);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
						
			}
		}
		return data;
	}
	
	public static void takescreenshot() throws Exception
	{
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
		FileHandler.copy(file,new File(currentdir+"\\screenshots"+System.currentTimeMillis()+".png"));

    }
	}
