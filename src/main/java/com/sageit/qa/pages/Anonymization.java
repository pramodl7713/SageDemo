package com.sageit.qa.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.sageit.qa.utilities.CommonFunctions;
import com.sageit.qa.utilities.UtilityFunctions;
import com.sageit.qa.utilities.Xls_Reader;

public class Anonymization {

	WebDriver driver;
	CommonFunctions key;
    public String fpath="C:\\Users\\Srinivas Krishnakar\\Desktop\\";
    public String fname;
	Xls_Reader reader;
	public Anonymization(WebDriver driver,Xls_Reader reader) {

		this.driver = driver;
		this.reader = reader;
		key = new CommonFunctions();
	}

	
	
	By demo_link = By.xpath("//a[@href='/Anonymization/Anonymization/Anonymization/23']");
	By select_File = By.xpath("//div[@class='k-button k-upload-button']");
	By review_file_domains = By.xpath("//input[@class='btn btn-primary']");
	By domain_dropdown = By.xpath("/html[1]/body[1]/div[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/span[1]/span[1]/span[1]");
	By review_var_rules_btn = By.xpath("//input[@class='btn btn-primary']");
	
	
	
	public void checkAnonymization() throws Exception {
		
		String studid = reader.getCellData2("studyid").trim();
		String uploadfile=reader.getCellData2("uploadfile").trim();

		System.out.println("STUDY ID SELECTED :."+studid);
		
		key.clickElement(demo_link, "Study ID");
		Thread.sleep(3000);
		key.clickElement(select_File, "Select File");
		
		System.out.println("UPLOADED  FILE IS :."+uploadfile);
		UtilityFunctions.fileUploadWithAWT(fpath+uploadfile+".xlsx");
		Thread.sleep(2000);
		key.clickElement(review_file_domains, "Review File Domains");
		Thread.sleep(2000);
		String domain_value = driver.findElement(domain_dropdown).getText();
		
		System.out.println("Selected value in dropdown list : " + domain_value);
		
		if(uploadfile.equals(domain_value))
		{
			key.clickElement(review_var_rules_btn, "Review Variable Rules Btn");
		}
		

	}

}
