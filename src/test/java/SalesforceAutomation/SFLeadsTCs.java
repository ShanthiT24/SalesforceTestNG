package SalesforceAutomation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.Array;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import SalesforceBaseTest.SFBaseTest;
import SalesforceUtilities.SFConstants;
import SalesforceUtilities.PropertiesUtility;

public class SFLeadsTCs extends SFBaseTest{
	
	protected Logger SFLeadLog = LogManager.getLogger();
	
	public void sfLeadsTC20(String browserName,String userName,String password) throws InterruptedException
	{
		launchBrowser("Chrome");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		sfLogin(browserName, userName, password);
		Thread.sleep(5000);
		gotoLeadsPage();
		driver.quit();
		
	}
	
	public void sfLeadsTC21(String browserName,String userName,String password) throws InterruptedException
	{
		ArrayList<String> al = new ArrayList();
		Collections.addAll(al, "All Open Leads", "My Unread Leads","Recently Viewed Leads","Today's Leads","View - Custom 1","View - Custom 2");
		Object[] kk =al.toArray();
		sfLogin(browserName, userName, password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		gotoLeadsPage();
		Thread.sleep(5000);
		WebElement leadsDD = driver.findElement(By.id("fcf"));
		Select leadSelect = new Select(leadsDD);
		List<WebElement>  leadItems = leadSelect.getOptions();
		for(WebElement l : leadItems)
		{
			SFLeadLog.info(l.getText());
			String qq = (l.getText());
		
		}
		for(int i=0;i<al.size();i++)
		{
			if(al.get(i).equals(leadItems.get(i).getText()))
			{
				SFLeadLog.info("PASS :Value matched: " +al.get(i)+ " ,"+ leadItems.get(i).getText() );
			}
			else 
			{
				SFLeadLog.info("FAIL Value NOT matched: " +al.get(i)+ " , "+ leadItems.get(i).getText());
			}
		}
		
		
		SFLeadLog.info(al);
		boolean boolval = al.contains(leadItems); //returns true because lists are equal  
		SFLeadLog.info(boolval);  
		
		Thread.sleep(5000);
		driver.close();
		
	}
	
	
	public void sfLeadsTC22(String browserName,String userName,String password) throws InterruptedException
	{
		sfLogin(browserName, userName, password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		gotoLeadsPage();
		Thread.sleep(5000);
		WebElement leadsDD = driver.findElement(By.id("fcf"));
		Select leadSelect = new Select(leadsDD);
		//List<WebElement>  leadItems = leadSelect.getOptions();
		leadSelect.selectByVisibleText("My Unread Leads");
		Thread.sleep(5000);
		WebElement leadsDD1= driver.findElement(By.id("00Bao000000IC6u_listSelect"));
		Select leadSelect1 = new Select(leadsDD1);
		String leadSelectedOption=leadSelect1.getFirstSelectedOption().getText();
		if(leadSelectedOption.equals("My Unread Leads"))
		{
			SFLeadLog.info("INFO: My unread leads List displayed");
		}
		else
		{
			SFLeadLog.info("ERROR: unread leads page NOT List displayed");
		}
		
		sfLogoutClassic();
		sfLogin(browserName, userName, password);
		gotoLeadsPage();
		Thread.sleep(5000);
		WebElement goButton=driver.findElement(By.xpath("//input[@value=' Go! ']"));
		goButton.click();
		Thread.sleep(5000);
	
		WebElement leadsDD2= driver.findElement(By.id("00Bao000000IC6u_listSelect"));
		Select leadSelect2 = new Select(leadsDD2);
		String leadSelectedOption2=leadSelect2.getFirstSelectedOption().getText();
		if(leadSelectedOption2.equals("My Unread Leads"))
		{
			SFLeadLog.info("PASS: Go Button takes to 'My unread leads' List page");
		}
		else
		{
			SFLeadLog.info("FAIL: Go Button does NOT navigate to 'My unread leads' page ");
		}
		
		driver.quit();
	}
	
	public void sfLeadsTC23(String browserName,String userName,String password) throws InterruptedException
	{
		//sfLogoutClassic();
		sfLogin(browserName, userName, password);
		gotoLeadsPage();
		Thread.sleep(5000);
		
		WebElement leadsDD = driver.findElement(By.id("fcf"));
		Select leadSelect = new Select(leadsDD);
		//List<WebElement>  leadItems = leadSelect.getOptions();
		leadSelect.selectByVisibleText("Today's Leads");
		Thread.sleep(5000);
		
		//WebElement goButton=driver.findElement(By.xpath("//input[@value=' Go! ']"));
		//goButton.click();
		//Thread.sleep(5000);
		
		WebElement leadsDD2= driver.findElement(By.id("00Bao000000IC78_listSelect"));
		Select leadSelect2 = new Select(leadsDD2);
		String leadSelectedOption2=leadSelect2.getFirstSelectedOption().getText();
		if(leadSelectedOption2.equals("Today's Leads"))
		{
			SFLeadLog.info("PASS: Go Button takes to 'Today's Leads' List page");
		}
		else
		{
			SFLeadLog.info("FAIL: Go Button does NOT navigate to 'Today's Leads' page ");
		}
		
		driver.quit();
		
		
	}
	
	public void sfLeadsTC24(String browserName,String userName,String password) throws InterruptedException
	{
		sfLogin(browserName, userName, password);
		gotoLeadsPage();
		Thread.sleep(5000);
		WebElement newLeadButton = driver.findElement(By.xpath("//input[@name='new']"));
		newLeadButton.click();
		Thread.sleep(5000);
		String newLeadPgTitle= driver.getTitle();
		if(newLeadPgTitle.equals("Lead Edit: New Lead ~ Salesforce - Developer Edition"))
		{
			SFLeadLog.info("INFO: New Lead Edit page displayed on clicking New Button");
			WebElement lNameTB= driver.findElement(By.id("name_lastlea2"));
			lNameTB.sendKeys("ABCD");
			WebElement compNameTB= driver.findElement(By.id("lea3"));
			compNameTB.sendKeys("ABCD");
			WebElement saveButton= driver.findElement(By.xpath("//input[@value=' Save ']"));
			saveButton.click();
			Thread.sleep(5000);
			String newLeadAddPgTitle = driver.getTitle();
			SFLeadLog.info("INFO: Title page after adding a Lead:"+newLeadAddPgTitle);
			if (newLeadAddPgTitle.contains("ABCD"))
				SFLeadLog.info("PASS: New Lead added successfully");
			else
				SFLeadLog.info("FAIL: New Lead NOT added successfully");
			
		}
		else
		{
			SFLeadLog.info("ERROR: New Lead Edit page NOT displayed on clicking New Button");
		}
		driver.quit();
		
	}
	

	/*public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String browser=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"browser");
		String username=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"username");
		String password=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"password");
		
		SFLeadsTCs sfLeads = new SFLeadsTCs();
		//sfLeads.sfLeadsTC20(browser,username, password);
		//sfLeads.sfLeadsTC21(browser,username, password);
		//sfLeads.sfLeadsTC22(browser,username, password);
		//sfLeads.sfLeadsTC23(browser,username, password);
		//SsfLeads.sfLeadsTC24(browser,username, password);
	}*/

}
