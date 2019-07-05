import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AddOrganizationTest {
	
	WebDriver driver;
	
	@Test
	public void addAnotherOrgTest() throws InterruptedException
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
		
		WebElement downArrow = driver.findElement(By.xpath("//div[@class='xrh-appbutton--body']"));
		downArrow.click();
		
		WebElement myXeroLink = driver.findElement(By.xpath("//a[contains(text(),'My Xero')]"));
		myXeroLink.click();
		Thread.sleep(3000);
		
		String parentWindow = driver.getWindowHandle();
		for(String childWindow : driver.getWindowHandles())
		{
			if(!childWindow.equals(parentWindow))
			{
				driver.switchTo().window(childWindow);
				Thread.sleep(3000);
				System.out.println(driver.getTitle());
				WebElement addOrganization = driver.findElement(By.xpath("//a[@id='ext-gen1042']"));
				addOrganization.click();
				
				WebElement name = driver.findElement(By.cssSelector("body.xui-body.xui-background-white:nth-child(2) div.xui-page-width-standard.xui-u-flex.xui-u-flex-justify-center.padding-top-large__2ARN9 div.margin-bottom-large__3eVb7.xui-panel div.panel-width-max__3nkEZ.xui-panel--section form.xui-form-layout div.xui-field-layout:nth-child(2) > div.xui-textinputwrapper"));
		
				name.sendKeys("self");
				
				WebElement timeZone = driver.findElement(By.xpath("//div[@class='xui-autocompleter--trigger-focus']//div//div//div[@class='xui-iconwrapper xui-iconwrapper-medium']"));
				timeZone.click();
				
				WebElement pst = driver.findElement(By.xpath("//li[@id='TIMEZONE/PACIFICSTANDARDTIME']//span[@class='xui-pickitem--text']"));
				pst.click();
				
				WebElement organization = driver.findElement(By.xpath("//input[@id='f4893584-39cf-4bd4-a164-f57ed252c1f1-control']")) ;
				organization.sendKeys("Accounting");
				
				WebElement startTrail = driver.findElement(By.xpath("//button[contains(text(),'Start trial')]"));
				startTrail.click();
				
				
				
			}
		}
	}

}
