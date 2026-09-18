package Practice;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.Contacts;
import ObjectRepository.HomePage;
import ObjectRepository.Organizations;

public class CreateContactTest extends BaseClass {

	@Test(groups = "ST")
	public void createContact() throws Exception {
		HomePage page = new HomePage(driver);
		Contacts c = new Contacts(driver);
		page.getContacts().click();
		c.getCreatecontact().click();
		String lastname = eu.readDataFromExcel("create", 1, 0) + ju.getRandomNumber();
		c.getLastName().sendKeys(lastname);
		c.getSave().click();
		boolean status = c.getContactinfo().getText().contains(lastname);
		Assert.assertEquals(status, true);
		Thread.sleep(4000);
	}

	@Test(groups = "RT")
	public void createContactWithOrg() throws Exception {
		// create organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizations().click();
		Organizations og = new Organizations(driver);
		og.getOrgImg().click();
		String orgName = eu.readDataFromExcel("create", 3, 0) + ju.getRandomNumber();
		og.getOrganizationName().sendKeys(orgName);
		og.getSave().click();
		Thread.sleep(2000);
		Contacts c = new Contacts(driver);
// 	navigate to create page 
		hp.getContacts().click();
		c.getCreatecontact().click();
		String lastName = eu.readDataFromExcel("create", 1, 0) + ju.getRandomNumber();
		c.getLastName().sendKeys(lastName);
		c.getOrgNameSelect().click();
		Set<String> set = driver.getWindowHandles();
// switch to child window			    
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			@Nullable
			String url = driver.getCurrentUrl();
			if (url.contains("Accounts&action"))
				break;
		}
		c.getChildWSearch().sendKeys(orgName, Keys.ENTER);
		Thread.sleep(2000);
		WebElement orgsearchname = driver.findElement(By.xpath("//a[text()='" + orgName + "']"));
		Actions act = new Actions(driver);
		act.doubleClick(orgsearchname).perform();
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
// switch back to parent window
		while (it1.hasNext()) {
			String windowId = it1.next();
			driver.switchTo().window(windowId);
			@Nullable
			String url = driver.getCurrentUrl();
			if (url.contains("Contacts&action"))
				break;
		}
		og.getSave().click();
		Thread.sleep(4000);
	}

	@Test(groups = "RT")
	public void createContactWithSupportDate() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.getContacts().click();
		Contacts c = new Contacts(driver);
		c.getCreatecontact().click();
		;
		String lastName = eu.readDataFromExcel("create", 1, 0);
		c.getLastName().sendKeys(lastName);
		c.getStartDate().clear();
		c.getStartDate().sendKeys(ju.currentDate());
		c.getEndDate().clear();
		c.getEndDate().sendKeys(ju.expDate(30));
		c.getSave().click();
		boolean status = c.getContactinfo().getText().contains(lastName);
		Assert.assertEquals(status, true);
		Thread.sleep(4000);
	}
}
