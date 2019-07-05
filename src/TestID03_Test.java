import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestID03_Test {
	
	WebDriver driver;
	
	@BeforeMethod
	public void login()
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
	
	
	@Test(enabled=true)
	public void allTabsTest() throws InterruptedException
	{
		Thread.sleep(3000);
		SoftAssert softAssert = new SoftAssert();
		
		WebElement dashBoard = driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]"));
		dashBoard.click();
		String dashboardText = driver.findElement(By.xpath("//div[@class='xui-page-title xdash-setupwidget__setup--header-title___1obD5']")).getText();
		softAssert.assertEquals(dashboardText, "Welcome to Xero");
		
		WebElement accounts = driver.findElement(By.xpath("//button[contains(text(),'Accounting')]"));
		accounts.click();
		softAssert.assertTrue(driver.findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-nav--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionleft']")).isDisplayed());
		
		WebElement reports = driver.findElement(By.xpath("//a[contains(text(),'Reports')]"));
		reports.click();
		String reportsText = driver.findElement(By.xpath("//h1[@class='xui-pageheading--title']")).getText();
		softAssert.assertEquals(reportsText, "Reports");
		
		WebElement contacts = driver.findElement(By.xpath("//button[contains(text(),'Contacts')]"));
		contacts.click();
		int size = driver.findElements(By.xpath("//div[@class='xrh-dropdown-layout xrh-nav--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionleft']//ol[@class='xrh-verticalmenu']")).size();
		softAssert.assertTrue(size>0);
		WebElement downArrow = driver.findElement(By.xpath("//*[@class='xrh-icon xrh-appbutton--caret xrh-icon-svg']"));
		downArrow.click();
		WebElement settings = driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
		settings.click();
		String settingText = driver.findElement(By.xpath("//span[contains(text(),'Organization settings')]")).getText();
		softAssert.assertEquals(settingText, "Organization settings");
		
		downArrow = driver.findElement(By.xpath("//*[@class='xrh-icon xrh-appbutton--caret xrh-icon-svg']"));
		downArrow.click();
		WebElement files=driver.findElement(By.xpath("//a[contains(text(),'Files')]"));
		files.click();
		String filesText = driver.findElement(By.xpath("//h1[contains(text(),'Files')]")).getText();
		softAssert.assertEquals(filesText, "Files");
		Thread.sleep(3000);
		WebElement createNew = driver.findElement(By.xpath("//button[@title='Create new']"));
		createNew.click();
		int newSize = driver.findElements(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']")).size();
		softAssert.assertTrue(newSize>0);

		WebElement notification = driver.findElement(By.xpath("//button[@title='Notifications']"));
		notification.click();
//		String notificationText = driver.findElement(By.xpath("//li[@id='NOTIFICATIONS']")).getText();
//		softAssert.assertEquals(notificationText, "Notifications");
		
		WebElement search = driver.findElement(By.xpath("//button[@title='Search']"));
		search.click();
		Thread.sleep(3000);
//		int searchSize = driver.findElements(By.xpath("//input[@id='queryInput']")).size();
//		softAssert.assertTrue(searchSize>0);
		
		WebElement help = driver.findElement(By.xpath("//button[@title='Help']"));
		help.click();
//		String helpText = driver.findElement(By.xpath("//h3[contains(text(),'Help')]")).getText();
//		softAssert.assertEquals(helpText, "Help");
		softAssert.assertAll();
	}

}
