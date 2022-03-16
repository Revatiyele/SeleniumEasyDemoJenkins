package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonDemoPage {
	
	WebDriver driver;
	
	public RadioButtonDemoPage(WebDriver driver2) {
		this.driver=driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath = "//*[@class = 'dropdown open'] //*[text() = 'Radio Buttons Demo']")
	WebElement radioButtonDemo;
	
	@FindBy (xpath = "(//*[@class = 'radio-inline'] //input[@name = 'optradio']) [1]")
	WebElement singleRadioButton;
	
	@FindBy(id = "buttoncheck")
	WebElement firstRadioButton;
	
	@FindBy(name = "gender")
	WebElement gender;
	
	@FindBy(name = "ageGroup")
	WebElement ageGroup;
	
	@FindBy(xpath = "//*[@onclick = 'getValues();']")
	WebElement multiRadioButton;
	
	public WebElement RadioButtonDemo()
	{
		return radioButtonDemo;
	}
	
	public WebElement SingleRadioButton()
	{
		return singleRadioButton;
	}
	
	public WebElement FirstRadioButton()
	{
		return firstRadioButton;
	}
	
	public WebElement Gender()
	{
		return gender;
	}
	
	public WebElement AgeGroup()
	{
		return ageGroup;
	}
	
	public WebElement MultiRadioButton()
	{
		return multiRadioButton;
	}

}
