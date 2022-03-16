package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertDemoPage {
	
WebDriver driver;
	
	public JavaScriptAlertDemoPage(WebDriver driver2) {
		this.driver=driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath = "//button[@onclick = 'myAlertFunction()']")
	WebElement alertBox;
	
	@FindBy(xpath = "//button[@onclick = 'myConfirmFunction()']")
	WebElement confirmBox;
	
	@FindBy(xpath = "//button[@onclick = 'myPromptFunction()']")
	WebElement promptBox;
	
	@FindBy(xpath = "//*[@id = 'confirm-demo']")
	WebElement confirmBoxMessage;
	
	@FindBy(xpath = "//*[@id = 'prompt-demo']")
	WebElement promptBoxMessage;
	
	
	public WebElement AlertBox()
	{
		return alertBox;
	}
	
	public WebElement ConfirmBox()
	{
		return confirmBox;
	}
	
	public WebElement PromptBox()
	{
		return promptBox;
	}
	
	public WebElement ConfirmBoxMessage()
	{
		return confirmBoxMessage;
	}

	public WebElement PromptBoxMessage()
	{
		return promptBoxMessage;
	}

}
