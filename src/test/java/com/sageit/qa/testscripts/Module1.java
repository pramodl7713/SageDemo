package com.sageit.qa.testscripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sageit.qa.pages.Anonymization;
import com.sageit.qa.pages.LoginPage;
import com.sageit.qa.testbase.TestBase;
import com.sageit.qa.utilities.UtilityFunctions;
import com.sageit.qa.utilities.Xls_Reader;

@Listeners(com.sageit.qa.utilities.Listeners.class)
public class Module1 extends TestBase {
	public Logger logger = Logger.getLogger(Module1.class);
	
	
	
		
	
	  @Test public void TrialAssureAnonymization_TC001() throws Exception {
	  
	  reader.initializeExcel("trailassure", 2);
	  TestBase.childTest=TestBase.parentTest.createNode("Trial Assure Anonymization Functionality");
	  UtilityFunctions.login();
	  Anonymization an = new Anonymization(driver,reader);
	  an.checkAnonymization();
      UtilityFunctions.logout();
	  
	  }
	 
  
		
	
	
	/*
	 * @Test public void TitleTest_TC002() throws Exception {
	 * logger.info("*************Title test case started******************");
	 * TestBase.childTest=TestBase.parentTest.
	 * createNode("To verify the titile of page"); String exptitle = "orange hrm";
	 * String acttitle = driver.getTitle(); System.out.println(acttitle);
	 * Assert.assertEquals(acttitle, exptitle);
	 * 
	 * }
	 */
	
	/*
	 * @Test public void SkipTest_TC003() {
	 * logger.info("*************Skip Exception test case started******************"
	 * );
	 * TestBase.childTest=TestBase.parentTest.createNode("This is skip exception");
	 * TestBase.childTest.log(Status.SKIP, "Test case Skipped");
	 * 
	 * throw new SkipException("Test case skipping"); }
	 * 
	 */
		
}
