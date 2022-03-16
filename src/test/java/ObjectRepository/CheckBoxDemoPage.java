package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxDemoPage {
	
	WebDriver driver;
	
	public CheckBoxDemoPage(WebDriver driver2) {
		this.driver=driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath = "//*[text() = 'Checkbox Demo']")
	WebElement checkBoxDemo;

	@FindBy(xpath = "//*[@id=\"isAgeSelected\"]")
	WebElement singleCheckBox;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input")
	WebElement multipleCheckBox1;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input")
	WebElement multipleCheckBox2;

	@FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input")
	WebElement multipleCheckBox3;

	@FindBy(id = "check1")
	WebElement multipleCheckBoxButton;
	
	
	public WebElement CheckBoxDemo()
	{
		return checkBoxDemo;
	}
	
	public WebElement SingleCheckBox()
	{
		return singleCheckBox;
	}
	
	public WebElement MultipleCheckBox1()
	{
		return multipleCheckBox1;
	}
	
	public WebElement MultipleCheckBox2()
	{
		return multipleCheckBox2;
	}
	
	public WebElement MultipleCheckBox3()
	{
		return multipleCheckBox3;
	}
	
	public WebElement MultipleCheckBoxButton()
	{
		return multipleCheckBoxButton;
	}

}
