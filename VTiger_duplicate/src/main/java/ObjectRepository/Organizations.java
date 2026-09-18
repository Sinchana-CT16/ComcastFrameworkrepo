package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Organizations {
	public Organizations(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement orgImg;
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgInfo;
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationName;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phone;
	@FindBy(xpath = "//input[@value='Cancel  ']/preceding-sibling::input")
	private WebElement save;
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropDown;
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDropDown;

	public WebElement getOrgImg() {
		return orgImg;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getOrgInfo() {
		return orgInfo;
	}
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	

}
