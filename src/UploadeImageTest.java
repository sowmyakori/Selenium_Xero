import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadeImageTest {
	WebDriver driver;
	
	@Test
	public void uploadProfileImageTest() throws InterruptedException
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
		
		WebElement editProfile = driver.findElement(By.xpath("//h4[@class='xrh-verticalmenuitem--heading']"));
		editProfile.click();
		
		WebElement uploadImage = driver.findElement(By.xpath("//span[@id='button-1043-btnInnerEl']"));
		uploadImage.click();
		
		WebElement browseButton = driver.findElement(By.xpath("//input[@id='filefield-1174-button-fileInputEl']"));
		browseButton.sendKeys("C:\\Users\\Dell-Latitude-E6430\\Desktop\\Sampledox\\SampleImg.jpg");
		Thread.sleep(4000);
		
		WebElement uploadButton = driver.findElement(By.xpath("//div[@id='button-1192-btnWrap']"));
	
		uploadButton.click();
		
		int size = driver.findElements(By.xpath("//div[@id='button-1043']")).size();
		Assert.assertTrue(size>0);
		
	}

}
