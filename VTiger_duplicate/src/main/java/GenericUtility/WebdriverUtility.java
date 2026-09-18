package GenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverUtility {
	WebDriver driver;
	public WebDriver LaunchBrowser() throws Exception {
		PropertiesUtility p=new PropertiesUtility();
		String browser=p.getPropertiesData("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			return new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			return driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			return driver=new EdgeDriver();
		}
		else {
			return driver=new ChromeDriver();
		}
	}
	public Timeouts delay() {
		 return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
