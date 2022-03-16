package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputFormSubmitDemoPage {
	
	WebDriver driver;
	
	public InputFormSubmitDemoPage(WebDriver driver2) {
		this.driver=driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath = "//*[@class = 'dropdown open'] //*[text() = 'Input Form Submit']")
	WebElement inputFormSubmit;
	
	@FindBy(xpath = "//input[@name = 'first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name = 'last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name = 'email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name = 'phone']")
	WebElement phoneNum;
	
	@FindBy(xpath = "//input[@name = 'address']")
	WebElement address;
	
	@FindBy(xpath = "//input[@name = 'city']")
	WebElement city;
	
	@FindBy(css = ".form-control.selectpicker")
	WebElement state;
	
	@FindBy(xpath = "//input[@name = 'zip']")
	WebElement zipcode;
	
	@FindBy(xpath = "//input[@name = 'website']")
	WebElement website;
	
	@FindBy(xpath = "//input[@value = 'yes']")
	WebElement hosting;
	
	@FindBy(xpath = "//textarea[@name = 'comment']")
	WebElement description;
	
	@FindBy(xpath = "//*[text() = 'Send ']")
	WebElement send;
	
	
	public WebElement InputFormSubmit()
	{
		return inputFormSubmit;
	}
	
	public WebElement FirstName()
	{
		return firstName;
	}
	
	public WebElement LastName()
	{
		return lastName;
	}
	
	public WebElement Email()
	{
		return email;
	}
	
	public WebElement PhoneNum()
	{
		return phoneNum;
	}
	
	public WebElement Address()
	{
		return address;
	}
	
	public WebElement City()
	{
		return city;
	}
	
	public WebElement State()
	{
		return state;
	}
	
	public WebElement Zipcode()
	{
		return zipcode;
	}
	
	public WebElement Website()
	{
		return website;
	}
	
	public WebElement Hosting()
	{
		return hosting;
	}
	
	public WebElement Description()
	{
		return description;
	}
	
	public WebElement Send()
	{
		return send;
	}

}
