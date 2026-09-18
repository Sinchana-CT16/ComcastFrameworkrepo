package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
	WebDriver driver;
	public LogOut(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//span[@class='userName']/../../td[@class='small']/img[@src='themes/softed/images/user.PNG']" )
	private WebElement signOutImg;
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement logOut;
	public WebElement getSignOutImg() {
		return signOutImg;
	}
	
	public WebElement getLogOut() {
		return logOut;
	}
	public void logOut(){
		Actions act=new Actions(driver);
		act.moveToElement(signOutImg).click(logOut).perform();
	}

}
