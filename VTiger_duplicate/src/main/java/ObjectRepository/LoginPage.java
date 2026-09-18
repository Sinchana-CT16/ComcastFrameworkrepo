package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='user_name']")
	WebElement username;
	@FindBy(xpath="//input[@name='user_password']")
	WebElement password;
	@FindBy(id="submitButton")
	WebElement login;
	
	public void userLogin(String url,String un,String pwd) {
		driver.get(url);
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		login.click();
	}

}
