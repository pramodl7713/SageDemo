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
	
	
	  @Test public void VerifyTitle_TC001() throws Exception {
	 
	  String exp ="FitnessGram® Login | The Cooper Institute";	  
	  TestBase.childTest=TestBase.parentTest.createNode("Verifying title of web page");
	  String act = driver.getTitle();
	  if(act.equals(exp))
	  {
		  TestBase.childTest.pass("Title is Passed : "+act);
	  }
	  else {
		  TestBase.childTest.fail("Title is not Matching");
		  TestBase.childTest.fail("Expected Title is : "+exp);
		  TestBase.childTest.fail("Actual Title is : "+act);
		  //This is newly added line
	  }
	  }
	 
  
	  @Test public void VerifyURL_TC002() throws Exception {
		  try {
		  String expval="https://myhealthyzone.fitnessgram.net/";
		  TestBase.childTest=TestBase.parentTest.createNode("Verifying URL of web page");
		  String actval = driver.getCurrentUrl();
		  if(actval.equals(expval))
		  {
			  TestBase.childTest.pass("URL test is Passed : "+actval); 
		  }
		  }catch(Exception e)
		  {
			e.printStackTrace();
			  TestBase.childTest.fail("URL is not Matching");
		  }
	  }
	  
	  @Test 
	  public void DataTest_003()
	  {}
	  
	/*
	 * @Test public void LoginTest_TC001() throws Exception {
	 * 
	 * reader.initializeExcel("trailassure", 2);
	 * TestBase.childTest=TestBase.parentTest.
	 * createNode("Trial Assure Anonymization Functionality");
	 * System.out.println("Checks Login functionality...");
	 * 
	 * }
	 */
	  
		
	
	
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
