package com.sageit.qa.utilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.sageit.qa.testbase.TestBase;

public class Listeners extends TestBase implements ITestListener {

	public static String tmname = "";
	public static String[] tcnamenum;
	public static String testname = "";
	public static String testid = "";
	public static String sheetname = "Sheet1";
	public static int rcount;
	public static int status_code;

	public void onTestStart(ITestResult result) {

		tmname = result.getMethod().getMethodName();
		System.out.println("****************************************************************************************************************");
		System.out.println("*						 " + tmname + " TESTCASE STARTED"+"											");
		System.out.println("*****************************************************************************************************************");
		tcnamenum = CommonFunctions.tcNameSplit(tmname);
		testname = tcnamenum[0];
		testid = tcnamenum[1];
	}

	public void onTestSuccess(ITestResult result) {

		status_code = result.getStatus();

		rcount = writer.getRowCount("Sheet1");
		int r = rcount;
		System.out.println("Rowcount in Listener" + rcount);
		writer.setCellData("Sheet1", "TestCase Name", rcount + 1, testname);
		writer.setCellData("Sheet1", "TestCase_ID", rcount + 1, testid);
		writer.setCellData("Sheet1", "Status", rcount + 1, "Pass");

		try {
			writer.fillGreenColor("Sheet1", r, 2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {

		String file_path = TakingScreenshot.failedScreenshot(driver, result.getMethod().getMethodName());

		TestBase.childTest.log(Status.FAIL, result.getMethod().getMethodName() + " is failed");
		TestBase.childTest.log(Status.FAIL, "Failed : " + result.getThrowable().getMessage());
		try {
			TestBase.childTest.fail("Test case failed",
					MediaEntityBuilder.createScreenCaptureFromPath(file_path).build());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		status_code = result.getStatus();

		rcount = writer.getRowCount("Sheet1");
		int r = rcount;
		System.out.println("Rowcount in Listener" + rcount);
		writer.setCellData("Sheet1", "TestCase Name", rcount + 1, testname);
		writer.setCellData("Sheet1", "TestCase_ID", rcount + 1, testid);
		writer.setCellData("Sheet1", "Status", rcount + 1, "Fail");

		try {
			writer.fillRedColor("Sheet1", r, 2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		TestBase.childTest.log(Status.SKIP, result.getMethod().getMethodName() + " is skipped");
		int x = result.getStatus();
		System.out.println("Skipped Status ===>" + x);

		int rcount = writer.getRowCount("Sheet1");
		System.out.println("Rowcount in Listener" + rcount);
		writer.setCellData("Sheet1", "TestCase Name", rcount + 1, testname);
		writer.setCellData("Sheet1", "TestCase_ID", rcount + 1, testid);
		writer.setCellData("Sheet1", "Status", rcount + 1, "Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
