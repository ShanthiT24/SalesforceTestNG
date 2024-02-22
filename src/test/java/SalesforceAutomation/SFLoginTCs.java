package SalesforceAutomation;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SalesforceBaseTest.SFBaseTest;

public class SFLoginTCs extends SFBaseTest{
	
protected Logger SFLoginLog = LogManager.getLogger();
	
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeMethod(@Optional("chrome") String name, ITestResult result)
	{
		//extentReport.startExtentReport();	
		extentReport.startSingleTestReport(result.getMethod().getMethodName());
		SFLoginLog.info("......................BeforeMethod setupBeforeMethod started.............");
		launchBrowser(name);
		goToUrl("https://login.salesforce.com");	
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod()
	{
		closeBrowser();
		SFLoginLog.info("********tearDownAfterTestMethod executed***************");
	}
	
	

	@Test
	public void sfLoginTC1() throws InterruptedException{
		SoftAssert sftAsrt = new SoftAssert();
		String loginPgTitle = driver.getTitle();
		SFLoginLog.info("SF Title page:"+loginPgTitle);
		sftAsrt.assertEquals( loginPgTitle,"Login | Salesforce", "ERROR: Salesforce login page NOT displayed");
		WebElement userNameTB= driver.findElement(By.id("username"));
		userNameTB.sendKeys("User@gmail.com");
		Thread.sleep(5000);
		String uName=userNameTB.getAttribute("value");
		SFLoginLog.info("INFO: user name value:"+uName);
		sftAsrt.assertEquals( uName,"User@gmail.com", "Error User name not displayed");
		WebElement passwordTB= driver.findElement(By.id("password"));
		passwordTB.clear();
		String pwText=passwordTB.getAttribute("value");
		sftAsrt.assertEquals(pwText,"", "ERROR: password input box is NOT empty");
		WebElement loginButton = driver.findElement(By.id("Login"));
		loginButton.click();
		WebElement pwErrText= driver.findElement(By.xpath("//div[text()='Please enter your password.']"));
		String pwTextErr= pwErrText.getText();
		SFLoginLog.info("INFO:pwd error msg is: "+ pwTextErr);
		sftAsrt.assertEquals( pwTextErr,"Please enter your password.","FAIL: password Error Msg not displayed or different ");
		sftAsrt.assertAll();
	}
	
	@Test
	public void sfLoginTC2() throws InterruptedException
	{
		
		sfLogin();
		
		
	}
	
	@Test
	public void sfLoginTC3() throws InterruptedException
	{
		SoftAssert sftAsrt1= new SoftAssert();
		WebElement userNameTB= driver.findElement(By.id("username"));
		userNameTB.sendKeys("renu@xyzcorp.com");
		Thread.sleep(5000);
		WebElement passwordTB= driver.findElement(By.id("password"));
		passwordTB.sendKeys("salesforce24");
		WebElement loginButton = driver.findElement(By.id("Login"));
		WebElement rememberMeCB = driver.findElement(By.id("rememberUn"));
		rememberMeCB.click();
		Thread.sleep(5000);
		loginButton.click();
		Thread.sleep(5000);
		String hPage= driver.getTitle();
		sftAsrt1.assertEquals(hPage.contains("Home Page"),true,"ERROR: salesforce Home page NOT displayed");
		SFLoginLog.info("INFO: salesforce Home page displayed");
		sfLogoutClassic();
		Thread.sleep(5000);
		String loginPgTitle = driver.getTitle();
		SFLoginLog.info("SF Title page:"+loginPgTitle);
		sftAsrt1.assertEquals(loginPgTitle,"Login | Salesforce","ERROR: Salesforce login page NOT displayed");
		SFLoginLog.info("INFO: Salesforce login page displayed after logout");
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		WebElement uNameTB2 = driver.findElement(By.id("idcard-identity"));
		String userNameTB2=uNameTB2.getText();
		SFLoginLog.info("INFO: user name value seen in username TB :"+userNameTB2);
		SFLoginLog.info("INFO: expected user name value is 'renu@xyzcorp.com'");
		sftAsrt1.assertEquals(userNameTB2, "renu@xyzcorp.com","FAIL: User name entered not displayed on selecting remember me CB");
		sftAsrt1.assertAll();		
	}
	
	
	@Test
	public void sfLoginTC4A() throws InterruptedException
	{
		SoftAssert sftAsrt1= new SoftAssert();
		Thread.sleep(5000);
		WebElement forgotPwdLink = driver.findElement(By.id("forgot_password_link"));
		forgotPwdLink.click();
		Thread.sleep(5000);
		String forgotPwdPage = driver.getTitle();
		SFLoginLog.info("INFO: Forgot your passwd page title "+forgotPwdPage);
		sftAsrt1.assertEquals(forgotPwdPage.contains("Forgot Your Password"), true, "ERROR: Forgot your passwd page NOT displayed");
		SFLoginLog.info("INFO: Forgot your passwd page displayed");
		WebElement userEmailTB = driver.findElement(By.id("un"));
		userEmailTB.sendKeys("renu@xyzcorp.com");
		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();
		Thread.sleep(5000);
		String chkYourEmailPge = driver.getTitle();
		sftAsrt1.assertEquals(chkYourEmailPge.contains("Check Your Email"),true, "ERROR: check your email page is NOT displayed");
		SFLoginLog.info("INFO: check your email page is displayed");
		WebElement returnToLoginButton = driver.findElement(By.xpath("//a[text()='Return to Login']"));
		sftAsrt1.assertEquals(returnToLoginButton.isDisplayed(),true,"PASS: check your email page with 'return to login' button displayed");
		sftAsrt1.assertAll();			
	}
	
	@Test
	public void sfLoginTC4B() throws InterruptedException
	{
		SoftAssert sftAsrt1= new SoftAssert();
		launchBrowser("Chrome");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		Thread.sleep(5000);
		WebElement userNameTB= driver.findElement(By.id("username"));
		userNameTB.sendKeys("Username 123");
		Thread.sleep(5000);
		WebElement passwordTB= driver.findElement(By.id("password"));
		passwordTB.sendKeys("22131");
		WebElement loginButton = driver.findElement(By.id("Login"));
		loginButton.click();
		Thread.sleep(5000);
		WebElement errorText = driver.findElement(By.id("error"));
		String errText = errorText.getText();
		String expErrText ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		sftAsrt1.assertEquals(errText,expErrText,"FAIL: error msg is NOT displayed if wrong username/password is entered to login");
		sftAsrt1.assertAll();
	}
	
	
	/*public static void main(String[] args) throws InterruptedException 
	{
		SFLoginTCs sfLogin = new SFLoginTCs();
		//sfLogin.sfLoginTC1();
		//sfLogin.sfLoginTC2("Chrome","renu@xyzcorp.com","salesforce24");
		//sfLogin.sfLoginTC3();
		//sfLogin.sfLoginTC4A();
		sfLogin.sfLoginTC4B();
		
	}*/

}
