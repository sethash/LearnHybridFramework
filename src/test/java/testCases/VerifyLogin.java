package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;
import pages.HomePage;
import pages.Login;

public class VerifyLogin {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	@Test
	public void testHomePage()
	{
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getTitle();
		Assert.assertTrue(title.contains("Execute Automation"));
		Login log = PageFactory.initElements(driver, Login.class);
		log.EnterUsername(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		log.verifySignOutLink();
	}
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
