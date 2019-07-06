import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestID08_Test {
	
	WebDriver driver;
	
	@BeforeMethod
	public void launchApp()
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
		
		
	}
	
	@Test(enabled=false)
	public void addAnotherOrgTest() throws InterruptedException
	{
	
		Thread.sleep(5000);
		
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
				WebElement addOrganization = driver.findElement(By.xpath("//a[contains(text(),'Add an organization')]"));
				addOrganization.click();
				
				String orgName = "self";
				WebElement name = driver.findElement(By.xpath("(//div[@class='xui-textinput xui-textinput-medium']//input)[1]"));
		
				name.sendKeys(orgName);
				
				WebElement timeZone = driver.findElement(By.xpath("(//div[@class='xui-iconwrapper xui-iconwrapper-medium'])[2]"));
				timeZone.click();
				
				WebElement pst = driver.findElement(By.xpath("//li[@id='TIMEZONE/PACIFICSTANDARDTIME']//span[@class='xui-pickitem--text']"));
				pst.click();
				
			//	Thread.sleep(5000);
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='xui-textinputwrapper']/div//input)[4]")));
				WebElement organization = driver.findElement(By.xpath("(//div[@class='xui-textinputwrapper']/div//input)[4]")) ;
				organization.sendKeys("Accounting");			
				driver.findElement(By.xpath("(//div[@class='xui-dropdown--scrollable-content']//ul//li//span//strong[contains(text(),'Acc')])[1]")).click();
				
				WebElement startTrail = driver.findElement(By.xpath("//button[contains(text(),'Start trial')]"));
				startTrail.click();
				
				Thread.sleep(5000);
				String heading = driver.findElement(By.xpath("//h1[@class='xui-pageheading--title']")).getText();
				System.out.println(heading);
				Assert.assertEquals(heading, orgName);
				
				
			}
		}
	}
	
	@Test(enabled=true)
	public void addOrg_paidVersionTest() throws InterruptedException
	{

		Thread.sleep(5000);
		
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
				WebElement addOrganization = driver.findElement(By.xpath("//a[contains(text(),'Add an organization')]"));
				addOrganization.click();
				
				String orgName = "self";
				WebElement name = driver.findElement(By.xpath("(//div[@class='xui-textinput xui-textinput-medium']//input)[1]"));
		
				name.sendKeys(orgName);
				
				WebElement timeZone = driver.findElement(By.xpath("(//div[@class='xui-iconwrapper xui-iconwrapper-medium'])[2]"));
				timeZone.click();
				
				WebElement pst = driver.findElement(By.xpath("//li[@id='TIMEZONE/PACIFICSTANDARDTIME']//span[@class='xui-pickitem--text']"));
				pst.click();
				
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='xui-textinputwrapper']/div//input)[4]")));
				WebElement organization = driver.findElement(By.xpath("(//div[@class='xui-textinputwrapper']/div//input)[4]")) ;
				organization.sendKeys("Accounting");			
				driver.findElement(By.xpath("(//div[@class='xui-dropdown--scrollable-content']//ul//li//span//strong[contains(text(),'Acc')])[1]")).click();
				
				WebElement buyNewButton = driver.findElement(By.xpath("//button[contains(text(),'Buy now')]"));
				buyNewButton.click();
				Thread.sleep(3000);
				
				WebElement displayText = driver.findElement(By.xpath("//span[contains(text(),'Select a plan')]"));
				Assert.assertTrue(displayText.isDisplayed());
			}

		}
	}
}	
