package com.sageit.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sageit.qa.utilities.Xls_Reader;

/**
 * @author Srinivas Krishnakar
 */
public class TestBase {

	// properties
	public static Properties prop;
	public static FileInputStream fi;
	public static String appurl = "";
	public static WebDriver driver;
	public static String path;
	public static String log4jConfPath;

	// extent report initializations
	String method;
	public ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;

	// creating logger class object and initializing
	private static final Logger logger = Logger.getLogger(TestBase.class);
	
	public static Xls_Reader reader;
	public static Xls_Reader writer;
	
	public static String xlfile = "C:\\Users\\Srinivas Krishnakar\\eclipse-workspace\\DemoProject\\excel-report\\tassureReport.xlsx";


	public TestBase() {
		prop = new Properties();
		try {
			fi = new FileInputStream(".\\src\\main\\java\\com\\sageit\\qa\\config\\configuration.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find Configuration file");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// lo4j configurations
		log4jConfPath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\sageit\\qa\\config\\"+ "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		
		//initializing excel file
		 reader = new Xls_Reader("C:\\Users\\Srinivas Krishnakar\\eclipse-workspace\\DemoProject\\testdata\\tassuredata.xlsx");
		 writer = new Xls_Reader("C:\\Users\\Srinivas Krishnakar\\eclipse-workspace\\DemoProject\\excel-report\\tassureReport.xlsx");
		 

	}

	// Setting up browser configurations
	@BeforeClass
	public void browserSetup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Launching chrome browser............................");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		logger.info("Entering application URL............................");

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();

	}



	@BeforeMethod
	public void methodName(Method method) {
		parentTest = extent.createTest(method.getName());
	}

	// Method to initialize extent report classes

	@BeforeTest
	public void logAndReportSetUp() {

		// extent reports
		reporter = new ExtentHtmlReporter("C:\\Users\\Srinivas Krishnakar\\eclipse-workspace\\DemoProject\\extent-report\\extentrep.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		reporter.config().setTheme(Theme.DARK);
		

	}

	@AfterMethod
	public void flush() throws IOException {
		extent.flush();
		

	}

}
