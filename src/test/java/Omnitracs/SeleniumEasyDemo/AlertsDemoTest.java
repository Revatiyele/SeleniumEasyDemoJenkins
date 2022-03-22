package Omnitracs.SeleniumEasyDemo;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.JavaScriptAlertDemoPage;
import ObjectRepository.SeleniumDemoHomePage;

public class AlertsDemoTest {
	
	static WebDriver driver;
	static Properties properties;
	static FileInputStream fis;
	
	ExtentReports extent;
	
	@BeforeTest
	public void config()
	{
		String path = System.getProperty("user.dir") + "\\reports\\AlertDemoIndex.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Selenium Easy Demo Automation Results");
		reporter.config().setDocumentTitle("Alert & Model Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "SystemTeam");
		
		
	}
	
	@BeforeTest
	
	public void initialSteps() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\REVATI YELE\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.get("https://demo.seleniumeasy.com/");
		driver.manage().window().maximize();
			
			driver.get("https://demo.seleniumeasy.com/");
	driver.manage().window().maximize();
			
		try {
			Thread.sleep(2000);
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
	
	@Test
	public void javaScriptAlertDemo() throws Exception
	{
		ExtentTest test = extent.createTest("JavaScript Demo Test");
		
		SeleniumDemoHomePage sdhp = new SeleniumDemoHomePage(driver);
		JavaScriptAlertDemoPage jsa = new JavaScriptAlertDemoPage(driver);
		
		
		sdhp.AlertsAndModels().click();
		test.info("successfully identified the alert&Models");
		
		sdhp.JavaScriptAlert().click();
		test.info("successfully clicked javascript alerts");
		
		jsa.AlertBox().click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		test.pass("successfully clicked alert box");
		this.takeSnapShot(driver, "c:/test/test.png") ;
		Thread.sleep(1000);
		
		jsa.ConfirmBox().click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		//code to check comfirmbox alert

		//code to check comfirmbox alert
		try {
			//Assert.assertTrue(jsa.ConfirmBoxMessage().getText().contains("You pressed OK!"));

			Assert.assertFalse(jsa.ConfirmBoxMessage().getText().contains("You pressed OK!"));
			this.takeSnapShot(driver, "c:/test/test.png") ;

		} catch (AssertionError e) {
			System.out.println("Confirm Box message not matched");
		}
		//test.pass("successfully clicked Confirm box");

		test.fail("successfully clicked Confirm box");
		
		Thread.sleep(1000);
		
		jsa.PromptBox().click();
		driver.switchTo().alert().sendKeys(properties.getProperty("message"));
		Thread.sleep(1000);
		driver.switchTo().alert().accept();	
		
		//code to validate Promptbox alert
		try {
			Assert.assertTrue(jsa.PromptBoxMessage().getText().contains("You have entered 'Hello Ram' !"));
		} catch (AssertionError e) {
			System.out.println("Prompt Box message not matched");
		}
		test.pass("successfully Prompt alert box");
		Thread.sleep(1000);
		
	}
	
	@AfterTest
	public void closeAllBrowsers() {
		driver.close();	
		driver.quit();
	}
	
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}

	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception
	{
	 
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	 
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	 
	File DestFile=new File(fileWithPath);
	 
	FileUtils.copyFile(SrcFile, DestFile);
	}
}
