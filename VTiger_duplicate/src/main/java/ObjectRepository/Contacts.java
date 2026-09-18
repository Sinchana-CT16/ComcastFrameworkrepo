package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {
	
	
	public Contacts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createcontact;
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@id='mobile']")
	private WebElement mobileNo;
	@FindBy(xpath = "//input[@title='Save [Alt+S]' and @class='crmButton small save']")
	private WebElement save;
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactinfo;
	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement startDate;
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement endDate;
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement orgNameSelect;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement childWSearch;

	public WebElement getCreatecontact() {
		return createcontact;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getMobileNo() {
		return mobileNo;
	}
	public WebElement getSave() {
		return save;
	}
	public WebElement getContactinfo() {
		return contactinfo;
	}
	public WebElement getStartDate() {
		return startDate;
	}
	public WebElement getEndDate() {
		return endDate;
	}
	public WebElement getOrgNameSelect() {
		return orgNameSelect;
	}
	public WebElement getChildWSearch() {
		return childWSearch;
	}
}
