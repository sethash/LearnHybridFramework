package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver idriver)
	{
		this.driver = idriver;
		
	}
	
	@FindBy(xpath = ".//*[@id='userName']/p[1]/input")WebElement UserName;
	@FindBy(xpath = ".//*[@id='userName']/p[2]/input")WebElement Password;
	@FindBy(xpath = ".//*[@id='userName']/p[3]/input")WebElement Login;
	
	
	public String getTitle()
	{
		 return driver.getTitle();
	}
	
	

}
