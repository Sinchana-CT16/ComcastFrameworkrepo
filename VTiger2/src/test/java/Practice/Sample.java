package Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Sample {
	@Test
	public void m1() throws MalformedURLException, InterruptedException {
		URL ipAdd=new URL("http://localhost:4444/wd/hub");
		ChromeOptions options =new ChromeOptions();
		RemoteWebDriver driver=new RemoteWebDriver(ipAdd,options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
//		Thread.sleep(3000);
		driver.quit();
	}
	

}
