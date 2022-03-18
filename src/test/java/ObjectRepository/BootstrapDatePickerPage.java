package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BootstrapDatePickerPage {
	
WebDriver driver;
	
	public BootstrapDatePickerPage(WebDriver driver2) {
		this.driver=driver2;
		
		PageFactory.initElements(driver2, this);
	}
	
	//BootStrap Date Picker locator
	//BootStrap Date Picker locator
		

	@FindBy(xpath = "//*[@class = 'dropdown-menu'] //*[text() = 'Bootstrap Date Picker']")
	WebElement bootstrapDatePicker;
	
	//Bootstrap single date field field
	@FindBy(css = "[class = 'input-group date'] [class = 'form-control']")
	WebElement singleDateField;
	
	@FindBy(css = "[class = 'input-daterange input-group'] [placeholder = 'Start date']")
	WebElement startDate;
	
	@FindBy(css = "[class = 'input-daterange input-group'] [placeholder = 'End date']")
	WebElement endDate;
	
	//BootStrap Date Picker method
	
	public WebElement BootstrapDatePicker()
	{
		return bootstrapDatePicker;
	}
	 
	//BootStrap SingleDateField
	public WebElement SingleDateField()
	{
		return singleDateField;
	}
	
	public WebElement StartDate()
	{
		return startDate;
	}
	
	public WebElement EndDate()
	{
		return endDate;
	}

}
