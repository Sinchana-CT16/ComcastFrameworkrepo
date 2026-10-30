package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample2 {
	@Test
	public void m1() throws Exception {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_forms.asp?utm_source=chatgpt.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@id='fname']")).submit();
	}
	

}
