import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestID01_Test {
	WebDriver driver;
	
	@BeforeMethod
	public void launchApp()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell-Latitude-E6430\\Selenium_training\\geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.get("http://login.xero.com");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled=false)
	public void loginTest()
	{
		
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kr.sowmya1@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("welcome123");
		
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		loginButton.click();
		
		String welcomeText = driver.findElement(By.xpath("//div[@class='xdash-setupwidget__setup--header___2XPuQ']")).getText();
		Assert.assertEquals("Welcome to Xero", welcomeText);
		
	}
	
	@Test(enabled=false)
	public void incorrectPasswordTest()
	{

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kr.sowmya1@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password");
		
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		loginButton.click();
		
		String errorMsg = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]")).getText();
		Assert.assertEquals("Your email or password is incorrect", errorMsg);
	}
	
	@Test(enabled=false)
	public void incorrectEmailTest()
	{
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kr.sowmya1@mail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password");
		
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		loginButton.click();
		
		String errorMsg = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]")).getText();
		Assert.assertEquals("Your email or password is incorrect", errorMsg);
	}
	
	@Test(enabled=true)
	public void forgotPwdTest() throws InterruptedException
	{
		WebElement forgotPwdLink = driver.findElement(By.xpath("//a[@class='forgot-password-advert']"));
		forgotPwdLink.click();
		
		String email = "kr.sowmya1@gmail.com";
		WebElement emailId= driver.findElement(By.id("UserName"));
		
		emailId.clear();
		emailId.sendKeys(email);
		
		WebElement sendLinkButton = driver.findElement(By.id("submitButton"));
		sendLinkButton.click();
		Thread.sleep(3000);
		String displayText = driver.findElement(By.xpath("//div[@class='x-boxed noBorder']//p[1]")).getText();

		Assert.assertTrue(displayText.contains(email));
		
	}
}
