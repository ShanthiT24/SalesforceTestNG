package SalesforceAutomation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import SalesforceBaseTest.SFBaseTest;
import SalesforceUtilities.SFConstants;
import SalesforceUtilities.PropertiesUtility;

public class SFOppurtunitiesTCs extends SFBaseTest {
	
	protected Logger SFOpptyLog = LogManager.getLogger();
	
	public void sfOpptyTC15() throws InterruptedException
	{
		ArrayList<String> al = new ArrayList();
		Collections.addAll(al,"All Opportunities","Closing Next Month","Closing This Month","My Opportunities","New Last Week",
				"New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won");
		//launchBrowser("Chrome");
		sfLogin();
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		gotoOpptysPage();
		WebElement opptyDD = driver.findElement(By.id("fcf"));
		Select opptySelect = new Select(opptyDD);
		List<WebElement>  opptyItems = opptySelect.getOptions();
		for(WebElement l : opptyItems)
		{
			SFOpptyLog.info(l.getText());
			String qq = (l.getText());
		
		}
		for(int i=0;i<al.size();i++)
		{
			if(al.get(i).equals(opptyItems.get(i).getText()))
			{
				SFOpptyLog.info("PASS :Value matched: " +al.get(i)+ " ,"+ opptyItems.get(i).getText() );
			}
			else 
			{
				SFOpptyLog.info("FAIL Value NOT matched: " +al.get(i)+ " , "+ opptyItems.get(i).getText());
			}
		}
		
		
		driver.quit();
	}
	
	public void sfOpptyTC16(String browserName,String userName,String password) throws InterruptedException
	{
		sfLogin(browserName, userName, password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		gotoOpptysPage();
		WebElement opptyDD = driver.findElement(By.xpath("//input[@value=' New ']"));
		Thread.sleep(5000);
		WebElement opptyNameTB1 = driver.findElement(By.id("opp3"));
		opptyNameTB1.sendKeys("ABCD_Oppty");
		WebElement opptyStageDD = driver.findElement(By.id("opp11"));
		Select opptyStageSelect = new Select(opptyStageDD);
		opptyStageSelect.selectByVisibleText("Qualification");
		WebElement closeDateTB=driver.findElement(By.id("opp9"));
		Thread.sleep(5000);
		closeDateTB.click();
		calendarSF("July","2025","15");
		Thread.sleep(5000);
		WebElement opptySaveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		opptySaveButton.click();
		Thread.sleep(5000);
		String newOpptyTitle=driver.getTitle();
		if (newOpptyTitle.contains("ABCD_Oppty"))
			SFOpptyLog.info("PASS: New Oppurtunity is added");
		else
			SFOpptyLog.info("FAIL: error adding new Oppurtunity");	
	}
	
	public void sfOpptyTC17(String browserName,String userName,String password) throws InterruptedException
	{
		
	}

	/*public static void main(String[] args) throws InterruptedException {
		String browser=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"browser");
		String username=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"username");
		String password=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"password");
		// TODO Auto-generated method stub
		SFOppurtunitiesTCs sfOppty = new SFOppurtunitiesTCs();
		//sfOppty.sfOpptyTC15(browser,username,password);
		//sfOppty.sfOpptyTC16(browser,username,password);
		
	}*/

}
