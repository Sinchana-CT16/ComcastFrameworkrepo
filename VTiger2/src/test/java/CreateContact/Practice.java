package CreateContact;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Practice {
	@Test
//	public void m1() throws MalformedURLException {
//	String userName="sinchana_bVzNvU";
//	String password="8pSgxWhzow9A2LU98qEd";
//	MutableCapabilities capabilities = new MutableCapabilities();
//	capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//	capabilities.setCapability(CapabilityType.BROWSER_VERSION, "latest");
//	capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Windows 11");
//	RemoteWebDriver driver=new RemoteWebDriver(new URL("https://"+userName+":"+password+"@hub-cloud.browserstack.com/wd/hub"),capabilities);
//	driver.get("https://www.flipkart.com/");
//	System.out.println(driver.getTitle());
//	driver.quit();
	//}	
		public void m1() throws MalformedURLException {
		
			URL ipAdd=new URL("http://localhost:4444/");
			ChromeOptions options =new ChromeOptions();
			RemoteWebDriver driver=new RemoteWebDriver(ipAdd,options);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.flipkart.com/");
			System.out.println(driver.getTitle());
			driver.quit();
	}
}
