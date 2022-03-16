package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownDemoPage {
	
	WebDriver driver;
	
	public DropdownDemoPage(WebDriver driver2) {
		this.driver=driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath = "//*[@class = 'dropdown open'] //*[text() = 'Select Dropdown List']")
	WebElement dropDownDemo;
	
	@FindBy(id = "select-demo")
	WebElement singleDropDown;
	
	@FindBy(id = "multi-select")
	WebElement multiDropDown;
	
	@FindBy(xpath = "//*[@id=\"printAll\"]")
	WebElement getAllAelected;
	
	public WebElement DropDownDemo()
	{
		return dropDownDemo;
	}
	
	public WebElement SingleDropDown()
	{
		return singleDropDown;
	}
	
	public WebElement MultiDropDown()
	{
		return multiDropDown;
	}
	
	public WebElement GetAllAelected()
	{
		return getAllAelected;
	}

}
