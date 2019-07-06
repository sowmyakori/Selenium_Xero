import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestID04_Test {
	
	WebDriver driver;
	
	@Test
	public void logoutTest()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell-Latitude-E6430\\Selenium_training\\geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.get("http://login.xero.com");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kr.sowmya1@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("welcome123");
		
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		loginButton.click();
		
		WebElement userMenu = driver.findElement(By.xpath("//li[@class='xrh-addon xrh-addon-lastvisible']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
		userMenu.click();
		
		WebElement logoutLink = driver.findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Log out')]"));
		logoutLink.click();
		
		String text = driver.findElement(By.xpath("//h2[@class='x-boxed noBorder']")).getText();
		Assert.assertEquals(text, "Welcome to Xero");
		
	}

}
