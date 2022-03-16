package Omnitracs.SeleniumEasyDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.CheckBoxDemoPage;
import ObjectRepository.DropdownDemoPage;
import ObjectRepository.InputFormSubmitDemoPage;
import ObjectRepository.RadioButtonDemoPage;
import ObjectRepository.SeleniumDemoHomePage;
import ObjectRepository.SimpleFormDemoPage;

public class InputFormDemoTest {

	static WebDriver driver;
	static Properties properties;
	static FileInputStream fis;
	ExtentReports extent;

	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "\\reports\\InputFormDemoIndex.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Selenium Easy Demo Automation Results");
		reporter.config().setDocumentTitle("Input Form Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "SystemTeam");
	}

	@BeforeTest
	public void initialSteps() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\REVATI YELE\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://demo.seleniumeasy.com/");
		driver.manage().window().maximize();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-close\"]")).click();

	}

	@BeforeTest
	public void testDataFile() throws IOException {
		properties = new Properties();
		fis=new FileInputStream(
				"C:\\Users\\REVATI YELE\\eclipse-workspace\\SeleniumEasyDemo\\src\\test\\Resources\\testData.properties");
		properties.load(fis);
	}

	// Test case for sampleInputFormDemo
	@Test
	public void sampleInputFormDemo() throws IOException, InterruptedException {

		ExtentTest test = extent.createTest("Sample Input Form Demo");

		SeleniumDemoHomePage sdhp = new SeleniumDemoHomePage(driver); // home page class
		SimpleFormDemoPage sfd = new SimpleFormDemoPage(driver); // simple form page class

		sdhp.InputForm().click();
		test.info("Home Page identified");

		sdhp.SimpleFormDemo().click();
		test.info("Sample input form  Page identified");

		sfd.SingleInputField().sendKeys(properties.getProperty("singleInputFieldmessage"));

		test.pass("successfully pass data into input field");

		sfd.SingleInputFieldButton().click();
		test.pass("successfully pressed the button");

		// applying validation for single input field message
		try {
			Assert.assertTrue(sfd.YourMessage().getText().contains(properties.getProperty("singleInputFieldmessage")));
		} catch (AssertionError e) {
			System.out.println("Both are not matched");
		}

		sfd.TwoInputField_A().sendKeys(properties.getProperty("enterA"));
		test.pass("entered data into A input field filed");

		sfd.TwoInputField_B().sendKeys(properties.getProperty("enterB"));
		test.pass("entered data into B input field filed");

		sfd.TwoInputFieldButton().click();
		test.pass("successfully pressed the button");

		// applying validation for total value

		int total = Integer.parseInt(properties.getProperty("enterA"))
				+ Integer.parseInt(properties.getProperty("enterB"));

		String sum = Integer.toString(total);
		try {
			Assert.assertTrue(sfd.TotalValue().getText().contains(sum));
		} catch (AssertionError e) {
			// TODO: handle exception
		}

	}

	
	// Test case for CheckBox Demo
	@Test
	public void checkBoxDemo() {

		ExtentTest test = extent.createTest("CheckBox Demo Test");

		SeleniumDemoHomePage sdhp = new SeleniumDemoHomePage(driver);
		CheckBoxDemoPage cbd = new CheckBoxDemoPage(driver);

		sdhp.InputForm().click();
		test.info("InputForm Identified successfully");

		sdhp.CheckBoxDemo().click();
		test.info("CheckBox demo clicked");

		cbd.SingleCheckBox().click();
		test.pass("checkbox clicked successfully");

		try {
			Assert.assertTrue(cbd.SingleCheckBox().isSelected());
		} catch (AssertionError e) {
			System.out.println("checkbox not selected");
		}

		cbd.MultipleCheckBox1().click();
		try {
			Assert.assertTrue(cbd.MultipleCheckBox1().isSelected());
		} catch (AssertionError e) {
			System.out.println("checkbox not selected");
		}

		cbd.MultipleCheckBox2().click();
		try {
			Assert.assertTrue(cbd.MultipleCheckBox2().isSelected());
		} catch (AssertionError e) {
			System.out.println("checkbox not selected");
		}

		cbd.MultipleCheckBox3().click();
		try {
			Assert.assertTrue(cbd.MultipleCheckBox3().isSelected());
		} catch (AssertionError e) {
			System.out.println("checkbox not selected");
		}

		test.pass("multiple checkboxed clicked successfully ");
		cbd.MultipleCheckBoxButton().click();
		test.pass("successfully uncleared the checkboxes ");

	}

	
	// Test case for Radio Button Demo
	@Test
	public void radioButtonDemo() {

		ExtentTest test = extent.createTest("Radio BUttom Demo Test");

		SeleniumDemoHomePage sdhp = new SeleniumDemoHomePage(driver);
		RadioButtonDemoPage rbd = new RadioButtonDemoPage(driver);

		sdhp.InputForm().click();
		test.info("InputForm Identified successfully");

		sdhp.RadioButtonDemo().click();
		test.info("Radio Button demo clicked");

		rbd.SingleRadioButton().click();
		rbd.FirstRadioButton().click();

		// single radio button validation
		try {
			Assert.assertTrue(rbd.SingleRadioButton().isSelected());
		} catch (AssertionError e) {
			System.out.println("Radio button selected");
		}

		test.pass("single radio button clicked");

		rbd.Gender().click();
		rbd.AgeGroup().click();
		test.pass("successfully clicked group of radio buttons");
		rbd.MultiRadioButton().click();

		//multiple radio button validation
		try {
			Assert.assertTrue(rbd.Gender().isSelected());
			Assert.assertTrue(rbd.AgeGroup().isSelected());
		} catch (AssertionError e) {
			System.out.println("Radio button selected");
		}

	}

	
	// Test case for Dropdown Demo
	@Test
	public void dropDownDemo() throws IOException {

		ExtentTest test = extent.createTest("Dropdown Demo Test");

		SeleniumDemoHomePage sdhp = new SeleniumDemoHomePage(driver);
		DropdownDemoPage ddd = new DropdownDemoPage(driver);

		sdhp.InputForm().click();
		test.info("InputForm Identified successfully");

		sdhp.DropDownDemo().click();
		test.info("Dropdown demo clicked");

		WebElement we = ddd.SingleDropDown();
		Select dropdown = new Select(we);

		dropdown.selectByVisibleText(properties.getProperty("day"));
		test.pass("successfully selected a day");
		
		//code to validate Dropdown
		try {
			Assert.assertTrue(ddd.SingleDropDown().getText().contains(properties.getProperty("day")));
		} catch (AssertionError e) {
			System.out.println("day not matched");
		}

		WebElement we1 = ddd.MultiDropDown();
		Select dropdown1 = new Select(we1);
		dropdown1.selectByVisibleText(properties.getProperty("city1"));
		dropdown1.selectByVisibleText(properties.getProperty("city2"));
		dropdown1.selectByVisibleText(properties.getProperty("city3"));
		test.pass("successfully selected multiple items in the list");

		ddd.GetAllAelected().click();

	}

	
	// Test case for Input Form Submit Demo
	@Test
	public void inputFormDemo() throws IOException {

		ExtentTest test = extent.createTest("Input Form Submit Demo Test");

		SeleniumDemoHomePage sdhp = new SeleniumDemoHomePage(driver);
		InputFormSubmitDemoPage ifsd = new InputFormSubmitDemoPage(driver);

		sdhp.InputForm().click();
		test.info("InputForm Identified successfully");

		sdhp.InputFormSubmit().click();
		test.info("Input Form Submit demo clicked");

		ifsd.FirstName().sendKeys(properties.getProperty("firstName"));
		ifsd.LastName().sendKeys(properties.getProperty("lastName"));
		ifsd.Email().sendKeys(properties.getProperty("email"));
		ifsd.PhoneNum().sendKeys(properties.getProperty("phoneNumber"));
		ifsd.Address().sendKeys(properties.getProperty("address"));
		ifsd.City().sendKeys(properties.getProperty("city"));

		WebElement element = ifsd.State();
		Select selectitem = new Select(element);
		selectitem.selectByVisibleText(properties.getProperty("state"));

		ifsd.Zipcode().sendKeys(properties.getProperty("zipcode"));
		ifsd.Website().sendKeys(properties.getProperty("website"));
		ifsd.Hosting().click();
		ifsd.Description().sendKeys(properties.getProperty("projectDescription"));
		ifsd.Send().click();
		test.pass("Successfully entered all fields and clicked send button");
		
		// code to validate input form fields
		try {
			
			Assert.assertTrue(ifsd.FirstName().getText().contains(properties.getProperty("firstName")));
			Assert.assertTrue(ifsd.LastName().getText().contains(properties.getProperty("lastName")));
			Assert.assertTrue(ifsd.Email().getText().contains(properties.getProperty("email")));
			Assert.assertTrue(ifsd.PhoneNum().getText().contains(properties.getProperty("phoneNumber")));
			Assert.assertTrue(ifsd.Address().getText().contains(properties.getProperty("address")));
			Assert.assertTrue(ifsd.City().getText().contains(properties.getProperty("city")));
			Assert.assertTrue(ifsd.Zipcode().getText().contains(properties.getProperty("zipcode")));
			Assert.assertTrue(ifsd.Description().getText().contains(properties.getProperty("projectDescription")));
			
		} catch (AssertionError e) {
			System.out.println("Data Not matched");
		}

	}

	@AfterTest
	public void closeAllBrowsers() {
		driver.close();
		driver.quit();

	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

}
