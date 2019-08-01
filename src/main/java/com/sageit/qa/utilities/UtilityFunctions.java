package com.sageit.qa.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import com.sageit.qa.pages.LoginPage;
import com.sageit.qa.testbase.TestBase;

/**
 * 
 * @author Srinivas Krishnakar
 * This class contains the methods/functions which are commonly used across the application
 * for example login,logout etc..
 */
public class UtilityFunctions extends TestBase {
	
	static WebDriver driver =TestBase.driver;
	
	public static void login()
	{
		LoginPage lp = new LoginPage(driver);
		String demoi= prop.getProperty("clientid");				  
		String un=prop.getProperty("userid");
		String pas=prop.getProperty("password");
		  
          try {
			lp.login(demoi, un, pas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void logout()
	{
		LoginPage lp = new LoginPage(driver);

		try {
			lp.logoutApp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}
	
	
	
	public static void fileUploadWithAWT(String fpath) throws AWTException
	{
		  try {
		
			StringSelection stringSelection = new StringSelection(fpath);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);
	 
	        Robot robot = null;
	 
            robot = new Robot();
	 
	        robot.delay(2000);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(2000);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        TestBase.childTest.pass("File uploaded successfully... "+fpath);
	        } catch (AWTException e) {
	            e.printStackTrace();
	            System.out.println("Please Check File name, Unable to upload file");
	            throw e;
	        }
	}

}
