package SalesforceAutomation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SalesforceBaseTest.SFBaseTest;
import SalesforceUtilities.ExtentReportsUtility;

public class SFUserMenuTCs extends SFBaseTest {
	
protected Logger SFUserMenuLog= LogManager.getLogger();
protected ExtentReportsUtility usermenuReport = ExtentReportsUtility.getInstance();

@BeforeMethod
@Parameters("browserName")
public void setUpBeforeMethod(@Optional("chrome") String name, ITestResult result)
{
	//extentReport.startExtentReport();	
	extentReport.startSingleTestReport(result.getMethod().getMethodName());
	SFUserMenuLog.info("......................BeforeMethod setupBeforeMethod started.............");
	launchBrowser(name);
	goToUrl("https://login.salesforce.com");	
}

@AfterMethod
public void tearDownAfterTestMethod()
{
	closeBrowser();
	SFUserMenuLog.info("********tearDownAfterTestMethod executed***************");
}


@Test

	public void TC05_UM() throws InterruptedException 
	{
	
		//checkUserMenuItems();
			/*SoftAssert sa = new SoftAssert();
			sfLogin();
			//Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			//gotoHomeSF();
			WebElement userMenuDD= driver.findElement(By.xpath("//div[@id='userNav']"));
			userMenuDD.click();
			Thread.sleep(5000);
			
			WebElement myProfileItem = driver.findElement(By.xpath("//a[text()='My Profile']"));
			WebElement mySettingsItem = driver.findElement(By.xpath("//a[text()='My Settings']"));
			WebElement devConItem = driver.findElement(By.xpath("//a[text()='Developer Console']"));
			WebElement switchToLghtItem = driver.findElement(By.xpath("//a[text()='Switch to Lightning Experience']"));
			WebElement logoutItem = driver.findElement(By.xpath("//a[text()='Logout']"));
			
			sa.assertTrue(myProfileItem.isDisplayed(),"My Profile item not displayed in user menu");
			SFUserMenuLog.info("Chking for 'My Profile' Item in user menu drop down");
			usermenuReport.logTestInfo("Chking for 'My Profile' Item in user menu drop down");
			
			sa.assertTrue(mySettingsItem.isDisplayed(),"My Settings item not displayed in user menu");
			SFUserMenuLog.info("Chking for 'My Settings' Item in user menu drop down");
			usermenuReport.logTestInfo("Chking for 'My Settings' Item in user menu drop down");
				
			sa.assertTrue(devConItem.isDisplayed(),"Developer Console item not displayed in user menu");
			SFUserMenuLog.info("Chking for 'Developer Console' Item in User Menu dropdown");
			usermenuReport.logTestInfo("Chking for 'Developer Console' Item in User Menu dropdowm");
			
			sa.assertTrue(switchToLghtItem.isDisplayed(),"'Switch to Lightning' item not displayed in user menu");
			SFUserMenuLog.info("Chking for 'Switch to Lightning' Item in user menu drop down");
			usermenuReport.logTestInfo("Chking for 'Switch to Lightning' Item in user menu drop down");
			
			sa.assertTrue(logoutItem.isDisplayed(),"'Logout' item not displayed in user menu");
			SFUserMenuLog.info("Chking for 'Logout' Item in user meny drop down");
			usermenuReport.logTestInfo("Chking for 'Logout' Item in user menu drop down");
			
			sa.assertAll();*/
			
	}
@Test

		public void TC08_UM() throws InterruptedException 
		{
			SoftAssert sa = new SoftAssert();
			sfLogin();
			WebElement userProfileLinkMenuItem= driver.findElement(By.xpath("//div[@id='userNav']"));
			userProfileLinkMenuItem.click();
			Thread.sleep(5000);
			//sfbaseTestLog.info("User Profile page opened");
			WebElement devConItem = driver.findElement(By.xpath("//a[text()='Developer Console']"));
			
			String winHandleBefore = driver.getWindowHandle();
			SFUserMenuLog.info("current window handle :" + winHandleBefore);
			extentReport.logTestInfo("current window handle :" + winHandleBefore);
			
			devConItem.click();
			Thread.sleep(5000);
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			  }
			String actTitle=driver.getTitle();
			String expTitle="Developer Console";
			
			 SFUserMenuLog.info("current window handle :" +  driver.getTitle());
			 extentReport.logTestInfo("current window handle :" + driver.getTitle());
			
			sa.assertEquals(actTitle, expTitle,"Developer Console Page NOT displayed");
			driver.close();
			Thread.sleep(5000);
			 driver.switchTo().window(winHandleBefore);
			 String winTitle = driver.getTitle();
			 String actTitle1=driver.getTitle();
			 String expTitle1="Home Page ~ Salesforce - Developer Edition";
			 sa.assertTrue(actTitle1.contains("Home Page"), "Error closing dev console window using Close link ");
			 sa.assertAll();

			
		}

		
@Test

		public void TC09_UM() throws InterruptedException 
		{
			SoftAssert sa = new SoftAssert();
			checkUserMenuItems();
			WebElement logoutItem = driver.findElement(By.xpath("//a[text()='Logout']"));
			logoutItem.click();
			Thread.sleep(5000);
			String actTitle=driver.getTitle();
			String expTitle="Login | Salesforce";
			sa.assertEquals(actTitle, expTitle,"Login page not displayed on clicking Logout link");
			sa.assertAll();	
			
			
		}
}
