package MyAssiggnmentPracticeFrameWork.ExtentReports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	public ExtentReports extent;
	@BeforeTest
	public void configuration() {
		//ExtentReports, ExtentSparkReporter
		String path =System.getProperty("user.dir")+"//reports/index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Girish Web Automation Reports");
		reporter.config().setDocumentTitle("Test Results");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Girish");
		
	}
	@Test
	public void invokeDriver() {
		
		ExtentTest test =extent.createTest("Initial Demo");
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.quit();
		test.fail("Results do not match");
		
		extent.flush();
		
	

}
	
}
