import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class TestID02_Test {

WebDriver driver;
	
	@BeforeMethod
	public void launchApp()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell-Latitude-E6430\\Selenium_training\\geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.get("http://www.xero.com/us");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled=false)
	public void signUpTest() throws InterruptedException
	{
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		freeTrail.click();
		
		WebElement fname = driver.findElement(By.name("FirstName"));
		fname.sendKeys("alexa");
		
		WebElement lname = driver.findElement(By.name("LastName"));
		lname.sendKeys("amzon");
		
		WebElement email = driver.findElement(By.name("EmailAddress"));
		email.sendKeys("sowmya.kori1987@gmail.com");
		
		WebElement phone = driver.findElement(By.name("PhoneNumber"));
		phone.sendKeys("9087654321");
		
		Select country = new Select(driver.findElement(By.xpath("//select[@name='LocationCode']")));
		country.selectByVisibleText("United States");
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark']")));
//		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark']"));
		driver.switchTo().defaultContent();
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@name='TermsAccepted']"));
		checkbox.click();
		
		
		WebElement getStartedButton = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		getStartedButton.click();
	}
	
	@Test(enabled=false)
	public void emptyFieldsSubmitTest()
	{
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		freeTrail.click();
		

		WebElement getStartedButton = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		getStartedButton.click();
		
		String fnameError = driver.findElement(By.xpath("//span[@id='signup-form-error-message-1']")).getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(fnameError, "First name can't be empty");
		
		String lnameError = driver.findElement(By.xpath("//span[@id='signup-form-error-message-2']")).getText();		
		softAssert.assertEquals(lnameError, "Last name can't be empty");
		
		String emailError = driver.findElement(By.xpath("//span[@id='signup-form-error-message-3']")).getText();		
		softAssert.assertEquals(emailError, "Email address can't be empty");
		
		String phoneError = driver.findElement(By.xpath("//span[@id='signup-form-error-message-4']")).getText();		
		softAssert.assertEquals(phoneError, "Phone number can't be empty");
		
		WebElement email = driver.findElement(By.name("EmailAddress"));
		email.sendKeys("sowmya.kori1987");
		
		 getStartedButton = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		getStartedButton.click();
		
		emailError = driver.findElement(By.xpath("//span[@id='signup-form-error-message-3']")).getText();
		softAssert.assertEquals(emailError, "Email address is invalid");
		
		softAssert.assertAll();		
		
	}
	
	@Test(enabled=false)
	public void termsAndPivacyTest() throws InterruptedException
	{
		
		SoftAssert softAssert = new SoftAssert();
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		freeTrail.click();
		
		WebElement termsLink = driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
		termsLink.click();
		Thread.sleep(4000);
		String parentTab = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();
		
		for(String newTab : tabs)
		{
			if(!newTab.equals(parentTab))
			{
				driver.switchTo().window(newTab);
				Thread.sleep(3000);
				String pageTitle = driver.getTitle();
				System.out.println("Page Title***************"+pageTitle);
				softAssert.assertEquals(pageTitle, "Terms of Use | Xero US");
				driver.close();
			}
			
		}
		driver.switchTo().window(parentTab);
		
		WebElement privacyLink = driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]"));
		privacyLink.click();
		Thread.sleep(4000);
		for(String newTab : driver.getWindowHandles())
		{
			if(!newTab.equals(parentTab))
			{
				driver.switchTo().window(newTab);
				Thread.sleep(3000);
				String pageTitle = driver.getTitle();
				System.out.println("Page Title***************"+pageTitle);
				softAssert.assertEquals(pageTitle, "Privacy Notice | Xero US");
				driver.close();
			}
		}
		driver.switchTo().window(parentTab);
		softAssert.assertAll();
	}
	
	@Test(enabled=false)
	public void offerDetailsTest() throws InterruptedException
	{
		SoftAssert softAssert = new SoftAssert();
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		freeTrail.click();
		
		WebElement termsLink = driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
		termsLink.click();
		Thread.sleep(4000);
		String parentTab = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();
		
		for(String newTab : tabs)
		{
			if(!newTab.equals(parentTab))
			{
				driver.switchTo().window(newTab);
				Thread.sleep(3000);
				String pageTitle = driver.getTitle();
				System.out.println("Page Title***************"+pageTitle);
				softAssert.assertEquals(pageTitle, "Offer details | Xero US");
				driver.close();
			}
			
		}
		driver.switchTo().window(parentTab);
		softAssert.assertAll();
		
	}
	
	@Test(enabled=true)
	public void accountantLinkTest() throws InterruptedException
	{
		WebElement freeTrail = driver.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		freeTrail.click();
		
		WebElement accountantLink =driver.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"));
		accountantLink.click();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//div[@class='component title-text-component text text-center']//h2[@class='title title-2']")).getText();
		Assert.assertFalse(text.isEmpty());
		
				
	}
}
