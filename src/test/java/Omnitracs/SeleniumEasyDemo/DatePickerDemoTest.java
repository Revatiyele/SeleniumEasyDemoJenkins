package Omnitracs.SeleniumEasyDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.BootstrapDatePickerPage;
import ObjectRepository.SeleniumDemoHomePage;

public class DatePickerDemoTest {

	static WebDriver driver;
	static Properties properties;
	static FileInputStream fis;

	ExtentReports extent;

	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "\\reports\\DatePickerDemoIndex.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Selenium Easy Demo Automation Results");
		reporter.config().setDocumentTitle("Alert & Model Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "SystemTeam");

	}

	@BeforeTest
	public void initialSteps() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\REVATI YELE\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		driver = new ChromeDriver();

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
	public void BootstrapDatePicker() {
		ExtentTest test = extent.createTest("Sample Input Form Demo");

		SeleniumDemoHomePage sdhp = new SeleniumDemoHomePage(driver); // home page class
		BootstrapDatePickerPage bdp = new BootstrapDatePickerPage(driver);

		sdhp.DatePicker().click();

		bdp.BootstrapDatePicker().click();

		bdp.SingleDateField().click();

		// code to select single date filed
		int count = driver.findElements(By.cssSelector(".day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.cssSelector(".day")).get(i).getText();

			if (text.equalsIgnoreCase("16")) {
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}

		test.pass("Date seleted successfully");
		
		// code to select start date and end date

		driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]")).click();

		while (!driver.findElement(By.cssSelector("[class = 'datepicker-days'] [class = 'datepicker-switch']"))
				.getText().contains("April")) {
			driver.findElement(By.cssSelector("[class = 'datepicker-days'] [class = 'next']")).click();
		}

		int count1 = driver.findElements(By.cssSelector(".day")).size();

		for (int i = 0; i < count1; i++) {
			String text = driver.findElements(By.cssSelector(".day")).get(i).getText();

			if (text.equalsIgnoreCase("21")) {
				driver.findElements(By.cssSelector(".day")).get(i).click();
				// System.out.println(driver.findElements(By.cssSelector(".day")).get(i).getText());
				break;
			}
		}
		
		test.pass("Start date selected successfully");

		driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[2]")).click();
		int count2 = driver.findElements(By.cssSelector(".day")).size();

		for (int i = 0; i < count2; i++) {
			String text = driver.findElements(By.cssSelector(".day")).get(i).getText();

			if (text.equalsIgnoreCase("25")) {
				driver.findElements(By.cssSelector(".day")).get(i).click();
				// System.out.println(driver.findElements(By.cssSelector(".day")).get(i).getText());
				break;
			}
		}
		test.pass("End date selected successfully");

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
