package com.sageit.qa.utilities;

import org.openqa.selenium.By;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.utils.Reader;
import com.sageit.qa.testbase.TestBase;


/**
 * @author Srinivas Krishnakar
 */
public class CommonFunctions extends TestBase {
	
	/**
	 * Used to type data into the textfield
	 * @param locator--get for OR pages
	 * @param testdata--get from sources 
	 * @throws Exception 
	 */
	
	

	
	public void sendValue(By locator, String testdata,String ename) throws Exception 
	{
		
		try {
			driver.findElement(locator).sendKeys(testdata);
			TestBase.childTest.pass("Value entered successfully in "+ename);
		} catch (Exception e) {
			TestBase.childTest.fail("Unable to enter value in "+ename);
			TestBase.childTest.info(e);
			throw e;
			
		}
		
	}
	
	
	
	
	
	/**
	 * Used to perforn click action on elements
	 * @param locator--get it from particular OR pages
	 * @throws Exception 
	 */
	public void clickElement(By locator, String elename) throws Exception
	{
		try {
			driver.findElement(locator).click();
			TestBase.childTest.pass("Performed click successfully "+elename);
		} catch (Exception e) {
			e.toString();
			TestBase.childTest.fail("Unable to perform click action on "+elename);
			TestBase.childTest.info(e);
			throw e;

		}
	
	}
	
	
	public static String[] tcNameSplit(String tname)
	{
		
		String []nm = tname.split("_");
		nm[0].trim();
		nm[1].trim();
		return nm;

	}
	
	

}
