/**
 * 
 */
package com.sageit.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sageit.qa.testbase.TestBase;

/**
 * @author Srinivas Krishnakar
 * Description--This method captures screenshot on the event of testcase failure
 */
public class TakingScreenshot extends TestBase{
	
	public static String datename;
	
	public static String failedScreenshot(WebDriver driver, String methodname) {
		
		
		datename= new SimpleDateFormat("dd_MM_yyyy_hhmmss").format(new Date());
		 String path= "C:\\Users\\Srinivas Krishnakar\\eclipse-workspace\\DemoProject\\screenshots\\"+methodname+datename+".jpeg";
		 
		//String path= ".\\screenshots\\"+System.currentTimeMillis();
		
		File src_path = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
		File dest_path=new File(path);
		try {
			FileUtils.copyFile(src_path, dest_path);
			System.out.println("****SCREENSHOT CAPTURED*****");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
