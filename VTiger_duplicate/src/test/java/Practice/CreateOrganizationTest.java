package Practice;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseClass.BaseClass;
import GenericUtility.PropertiesUtility;
import ListnerUtility.ListImpClass;
import ObjectRepository.Contacts;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.Organizations;

public class CreateOrganizationTest extends BaseClass{
	@Test(groups = "ST")
	public void createOrganizationTest() throws Exception {
		//navigate to org page
		ListImpClass.test.log(Status.INFO, "navigate org page");
	    HomePage hp = new HomePage(driver);
	    hp.getOrganizations().click();
	    //navigate to create org page
	    ListImpClass.test.log(Status.INFO, "navigate to create org page");
	    Organizations og = new Organizations(driver);
	    og.getOrgImg().click();
	    //read data from Excel
	    ListImpClass.test.log(Status.INFO, "read data from Excel");
	    String orgName=eu.readDataFromExcel("create", 1, 0)+ju.getRandomNumber();
	    og.getOrganizationName().sendKeys(orgName);
	    og.getSave().click();
	    Thread.sleep(2000);
	   boolean status=og.getOrgInfo().getText().contains(orgName);
	    Assert.assertEquals(status, true);
	    Thread.sleep(4000);
	}

	@Test(groups = "RT")
	public void createOrganizationWithMobileTest() throws Exception {
	    HomePage hp = new HomePage(driver);
	    hp.getOrganizations().click();
	    Organizations og = new Organizations(driver);
	    og.getOrgImg().click();
	    String orgName=eu.readDataFromExcel("create", 1, 0) + ju.getRandomNumber();
	    og.getOrganizationName().sendKeys(orgName);
	    og.getPhone().sendKeys(eu.readDataFromExcel("create", 1, 1));
	    og.getSave().click();
	    Thread.sleep(2000);
	    boolean status=og.getOrgInfo().getText().contains(orgName);
	    Assert.assertEquals(status, true);
	    Thread.sleep(4000);
	}
	@Test(groups = "RT")
	public void createOrgWithIndustryAndType() throws Exception {
		HomePage hp=new HomePage(driver);
		hp.getOrganizations().click();
		Organizations og=new Organizations(driver);
		og.getOrgImg().click();
	    String orgName=eu.readDataFromExcel("create", 1, 0) + ju.getRandomNumber();
        og.getOrganizationName().sendKeys(orgName);
        Select s=new Select(og.getIndustryDropDown());
        s.selectByContainsVisibleText("Engineering");
        Select s1=new Select(og.getTypeDropDown());
        s1.selectByContainsVisibleText("Analyst");
        og.getSave().click();
		Thread.sleep(4000);
		    
	}
	
	
	
}
