package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import GenericUtility.DatabaseUtility;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesUtility;
import ObjectRepository.LogOut;
import ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;

	PropertiesUtility p=new PropertiesUtility();
	DatabaseUtility db=new DatabaseUtility();
	public ExcelUtility eu=new ExcelUtility();
	public JavaUtility ju=new JavaUtility();
	
	@BeforeSuite(groups = {"ST","RT"})
	public void confogBc() throws Exception {
		System.out.println("database connection,reports");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"ST","RT"})
	public void congigBC() throws Exception {
		
		String BROWSER = p.getPropertiesData("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver= driver=new EdgeDriver();
		}
		else {
			driver= driver=new ChromeDriver();
		}
		sdriver=driver;
		System.out.println("launch browser");

	}
	@BeforeMethod(groups = {"ST","RT"})
	public void congigBM() throws Exception {
		LoginPage lp=new LoginPage(driver);
		String USERNAME=p.getPropertiesData("username");
		String PASSWORD=p.getPropertiesData("password");
		String  URL=p.getPropertiesData("url");
		lp.userLogin(URL,USERNAME, PASSWORD);
		System.out.println("login to application");

	}
	@AfterMethod(groups = {"ST","RT"})
	public void configAM() {
		LogOut lg=new LogOut(driver);
		lg.logOut();
		System.out.println("logout");

	}
	@AfterClass(groups = {"ST","RT"})
	public void congigAC() {
		System.out.println("close browser");
		driver.quit();
		
	}
	@AfterSuite(groups = {"ST","RT"})
	public void congigAS()throws Exception {
		System.out.println("close connection");
		
		//db.closeDatabaseConnection() ;
	}
	
}
