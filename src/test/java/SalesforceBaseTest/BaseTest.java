package SalesforceBaseTest;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.io.Files;

import SalesforceUtilities.ExtentReportsUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected static WebDriver  driver = null;
	protected Logger baseTestLog = LogManager.getLogger();
	protected ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();
	
	 public  void launchBrowser(String browserName) {

	        switch (browserName.toLowerCase()) {
	            case "chrome":
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	                baseTestLog.info("Chrome browser has started");
	                extentReport.logTestInfo("Chrome browser has started");
	                driver.manage().window().maximize();
	                break;

	            case "firefox":
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	                baseTestLog.info("Firefox browser has started");
	                extentReport.logTestInfo("Firefox browser has started");
	                driver.manage().window().maximize();
	                break;

	            case "edge":
	                WebDriverManager.edgedriver().setup();
	                driver = new EdgeDriver();
	                baseTestLog.info("Edge browser has started");
	                extentReport.logTestInfo("Edge browser has started");
	                driver.manage().window().maximize();
	                break;

	            case "opera":
	                WebDriverManager.operadriver().setup();
	                driver = new OperaDriver();
	                baseTestLog.info("Opera browser has started");
	                extentReport.logTestInfo("Opera browser has started");
	                driver.manage().window().maximize();
	                break;

	            case "safari":
	                // Safari does not require a separate driver setup, as it is included with macOS
	                driver = new SafariDriver();
	                break;

	            default:
	                baseTestLog.info("Unsupported browser: " + browserName);
	        }

	        //return driver;
	    }
	 
	 
	 public void enterText(WebElement ele, String data, String objectName) {
			if (ele.isDisplayed()) {
				ele.clear();
				ele.sendKeys(data);
				baseTestLog.info("username data is entered in " + objectName + " textbox");
				extentReport.logTestInfo("username data is entered in \" + objectName + \" textbox");
			} else {
				baseTestLog.info(objectName + " element is not displayed");
				extentReport.logTestInfo(objectName + " element is not displayed");
			}
		}
		
		public void clickElement(WebElement ele, String objectName) {
			if (ele.isEnabled()) {
				ele.click();
				baseTestLog.info(objectName + "button is clicked");
				extentReport.logTestInfo(objectName + "button is clicked");
				
			} else {
				baseTestLog.info(objectName+" element is not enabled");
				extentReport.logTestInfo(objectName+" element is not enabled");
				
			}
		}
		
		public void goToUrl(String url) {
			driver.get(url);
			baseTestLog.info(url + "is entered");
			extentReport.logTestInfo(url + "is entered");
			
		}
		
		public String getTextFromElement(WebElement ele, String objectName) {
			String data = ele.getText();
			baseTestLog.info("text is extracted from "+objectName);
			extentReport.logTestInfo("text is extracted from "+objectName);
			return data;
		}
		
		public void closeBrowser() {
			driver.quit();
			baseTestLog.info("browser instance closed");
			extentReport.logTestInfo("browser instance closed");
			driver=null;
		
		}
		
		public void takescreenshot(String filepath)
		{
			TakesScreenshot screenCapture = (TakesScreenshot)driver;
			File src=screenCapture.getScreenshotAs(OutputType.FILE);
			File destination = new File(filepath);
			try {
				Files.copy(src, destination);
				baseTestLog.info("captured the screen");
				extentReport.logTestInfo("captured the screen");
			}catch (IOException e)
			{
				e.printStackTrace();
				baseTestLog.info("captured the screen");
				extentReport.logTestInfo("captured the screen");
			}
		}
		
		public void takescreenshot(WebElement element, String filepath)
		{
			File src=element.getScreenshotAs(OutputType.FILE);
			File destination = new File(filepath);
			try {
				Files.copy(src, destination);
				baseTestLog.info("captured element screenshot");
				extentReport.logTestInfo("captured element screenshot");
			}catch (IOException e)
			{
				e.printStackTrace();
				baseTestLog.info("went wrong when capturing the screen");
				extentReport.logTestInfo("went wrong when capturing the screen");
			}
		}
		
		

}