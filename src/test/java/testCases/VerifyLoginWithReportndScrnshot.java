package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;
import pages.HomePage;
import pages.Login;
import utility.Helper;

public class VerifyLoginWithReportndScrnshot {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setup()
	{
		report = new ExtentReports("./Reports/LoginPageReport.html",true);
		logger = report.startTest("verify login");
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "app is up and running");
	}
	@Test
	public void testHomePage()
	{
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getTitle();
		Assert.assertTrue(title.contains("Execute Automation"));
		logger.log(LogStatus.PASS, "home page load successfully");
		Login log = PageFactory.initElements(driver, Login.class);
		
		log.EnterUsername(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		log.verifySignOutLink();
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.CaptureScreenshot(driver, "validation2")));
		logger.log(LogStatus.PASS, "Signout link is present");
	}
	@AfterMethod
	public void tearDown(ITestResult result)//ITest result is an interface in testng, it stores every result.
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path =Helper.CaptureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
			
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
