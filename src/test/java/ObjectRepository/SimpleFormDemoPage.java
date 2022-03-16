package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormDemoPage {
	
WebDriver driver;
	
	public SimpleFormDemoPage(WebDriver driver2) {
		this.driver=driver2;
		
		PageFactory.initElements(driver2, this);
	}	
	
	
	@FindBy(xpath = "//*[@class = 'dropdown open'] //*[text() = 'Simple Form Demo']")
	WebElement simpleFormDemo;
	
	@FindBy(id = "user-message")
	WebElement singleInputField;
	
	@FindBy(xpath = "//button[@onclick = 'showInput();']")
	WebElement singleInputFieldButton;
	
	@FindBy(id = "sum1")
	WebElement twoInputField_A;
	
	@FindBy(id = "sum2")
	WebElement twoInputField_B;
	
	@FindBy(xpath = "//button[@onclick = 'return total()']")
	WebElement twoInputFieldButton;
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/a")
	WebElement inputForm;
	
	@FindBy(xpath = "//*[@id = 'display']")
	WebElement yourMessage;
	
	@FindBy(xpath = "//*[@id = 'displayvalue']")
	WebElement totalValue;
	
	public WebElement InputForm() {
		return inputForm;
	}

	public WebElement SimpleFormDemo() {
		return simpleFormDemo;
	}

	public WebElement SingleInputField() {
		return singleInputField;
	}

	public WebElement SingleInputFieldButton() {
		return singleInputFieldButton;
	}

	public WebElement TwoInputField_A() {
		return twoInputField_A;
	}

	public WebElement TwoInputField_B() {
		return twoInputField_B;
	}

	public WebElement TwoInputFieldButton() {
		return twoInputFieldButton;
	}
	
	public WebElement YourMessage()
	{
		return yourMessage;
	}
	
	public WebElement TotalValue()
	{
		return totalValue;
	}

}
