package Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice {

    RemoteWebDriver driver;

    @Test
    @Parameters("browser")
    public void m1(String browser) throws MalformedURLException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        URL ipAdd = new URL("http://localhost:4444/");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(ipAdd, options);

        } else if (browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();
            driver = new RemoteWebDriver(ipAdd, options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(ipAdd, options);
        }

        driver.get("https://www.flipkart.com/");

        System.out.println(driver.getTitle());

        driver.quit();
    }
}