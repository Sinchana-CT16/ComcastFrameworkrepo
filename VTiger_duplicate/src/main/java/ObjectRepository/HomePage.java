package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//a[text()='Contacts']")
	private WebElement contacts;
	public WebElement getContacts() {
		return contacts;
	}
	@FindBy(xpath = "//a[text()='Organizations']")
	WebElement organizations;
	public WebElement getOrganizations() {
		return organizations;
	}

}
