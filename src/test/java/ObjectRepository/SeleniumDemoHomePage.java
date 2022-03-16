package ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumDemoHomePage {

	WebDriver driver;
	
	public SeleniumDemoHomePage(WebDriver driver2) {
		this.driver=driver2;
		
		PageFactory.initElements(driver2, this);
	}

	
	
	//Input Form
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/a")
	WebElement inputForm;
	
	// SimpleForm Demo Locator
	
	@FindBy(xpath = "//*[text() = 'Simple Form Demo']")
	WebElement simpleFormDemo;
	

	// CheckBoxDemo Locator

	@FindBy(xpath = "//*[text() = 'Checkbox Demo']")
	WebElement checkBoxDemo;
	
	
	//Radio Button Locator
	
	@FindBy(xpath = "//*[text() = 'Radio Buttons Demo']")
	WebElement radioButtonDemo;
	
	
	//DropDown Demo Locator
	
	@FindBy(xpath = "//*[text() = 'Select Dropdown List']")
	WebElement dropDownDemo;
	
	
	//Input Form Submit Demo Locator
	
	@FindBy(xpath = "//*[text() = 'Input Form Submit']")
	WebElement inputFormSubmit;
	
	//Alerts & Models locator
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[2]/li[2]/a")
	WebElement alertsAndModels;
	
	//JavaScript Alerts Locator
	
	@FindBy(xpath = "//*[text() = 'Javascript Alerts']")
	WebElement javaScriptAlert;
	
	//Date Picker locator
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[2]/a")
	WebElement datePicker;
	
		

	

	//Input Form Method
	
	public WebElement InputForm() {
		return inputForm;
	}

	//SimpleForm Demo Method
	
	public WebElement SimpleFormDemo() {
		return simpleFormDemo;
	}

	
	//CheckBoxDemo Methods
	
	public WebElement CheckBoxDemo()
	{
		return checkBoxDemo;
	}
	
	
	//Radio Button Methods
	
	public WebElement RadioButtonDemo()
	{
		return radioButtonDemo;
	}
	
	
	//DropDown Demo Methods
	
	public WebElement DropDownDemo()
	{
		return dropDownDemo;
	}
	
	
	//Input form submit demo methods
	
	public WebElement InputFormSubmit()
	{
		return inputFormSubmit;
	}
	
	//Alerts & Models Method
	
	public WebElement AlertsAndModels()
	{
		return alertsAndModels;
	}
	
	//JavaScript alert method
	
	public WebElement JavaScriptAlert()
	{
		return javaScriptAlert;
	}
	
	//Date Picker method
	
	public WebElement DatePicker()
	{
		return datePicker;
	}
	
	

}
