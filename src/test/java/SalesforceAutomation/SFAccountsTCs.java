package SalesforceAutomation;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import SalesforceBaseTest.SFBaseTest;

public class SFAccountsTCs extends SFBaseTest {
	
	protected Logger SFAccountsLog = LogManager.getLogger();
	
	
	public void TC10_CreateAcct(String browserName,String userName, String password,String nameOfTab) throws Exception
	{
		sfLogin(browserName, userName, password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		customizeTab_addTab(nameOfTab);
		sfLogoutClassic();
		sfLogin(browserName, userName, password);
		WebElement menuBar=driver.findElement(By.id("tabBar"));
		List<WebElement> links = menuBar.findElements(By.tagName("li"));
		boolean isPresent=false;
		 for (int i = 1; i < links.size(); i++)
		 {
		     SFAccountsLog.info(links.get(i).getText());
		     String itemVal= links.get(i).getText();
		     if (itemVal.equals(nameOfTab))
		     {
		    	 SFAccountsLog.info("PASS:Item added to the menu bar : "+nameOfTab);
		    	 isPresent=true;
		     }
	   }
		 if(!isPresent)
	     {
	    	SFAccountsLog.info("FAIL:Item NOT added to menu bar");
	     }
		 driver.quit();
	}
		
		
	

	/*public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SFAccountsTCs sfAcct = new SFAccountsTCs();
		File propFile= new File("");
		
		sfAcct.TC10_CreateAcct("Chrome","renu@xyzcorp.com","salesforce24","Accounts");
		
		
	}*/

}
