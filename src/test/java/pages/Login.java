package pages;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

	public class Login {
		WebDriver driver;
		public Login(WebDriver idriver)
		{
			this.driver = idriver;
			
		}
		
		@FindBy(xpath = ".//*[@id='userName']/p[1]/input")WebElement UserName;
		@FindBy(xpath = ".//*[@id='userName']/p[2]/input")WebElement Password;
		@FindBy(xpath = ".//*[@id='userName']/p[3]/input")WebElement Login;
		
		By signout = By.xpath(".//*[@id='cssmenu']/ul/li[1]/a");
		
		public void EnterUsername(String username,String pass)
		{
			UserName.sendKeys(username);
		
			Password.sendKeys(pass);
		
			Login.click();
		}
		

		public void verifySignOutLink()
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			WebElement ele =wait.until(ExpectedConditions.presenceOfElementLocated(signout));
			String text = ele.getText();
			System.out.println(text);
			Assert.assertEquals(text,"LOGOUT","link not verified");
		}
	}


