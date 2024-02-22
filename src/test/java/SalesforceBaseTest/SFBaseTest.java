package SalesforceBaseTest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import SalesforceUtilities.ExtentReportsUtility;
import SalesforceUtilities.PropertiesUtility;
import SalesforceUtilities.SFConstants;

public class SFBaseTest extends BaseTest {
	
	protected Logger sfbaseTestLog = LogManager.getLogger();
	protected ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();
			
	
	public String currDayOfWeek()
	{
		String dayOfWeek="";
		java.util.Date date = new java.util.Date();    
	    sfbaseTestLog.info(date);   
	    String DATE_FORMAT = "E MMM d, yyyy HH:mm a";
		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
	    String strDate = formatter.format(date);  
	    String[] dateSplit = strDate.split(" ");
	    for(int i=0;i<dateSplit.length;i++)
	    {
	    	sfbaseTestLog.info(dateSplit[i]);
	    	//sfbaseTestLog.info.info(dateSplit[i]);
	    	
	    	
	    }
	    if (dateSplit[0]=="Sun")
		{
			dayOfWeek="Sunday";
		}
		else if(dateSplit[1]=="Mon")
		{
			dayOfWeek="Monday";
		}
		else if(dateSplit[2]=="Tue")
		{
			dayOfWeek="Tuesday";
		}
		else if(dateSplit[3]=="Wed")
		{
			dayOfWeek="Wednesday";
		}
		else if(dateSplit[4]=="Thu")
		{
			dayOfWeek="Thursday";
		}
		else if(dateSplit[5]=="Fri")
		{
			dayOfWeek="Friday";
		}
	    return dayOfWeek;
	    
	}	
	
	public void chkDayOfWeekSelected_Recurrence(String dayOfWeek,WebElement sunday,
			WebElement monday,WebElement tuesday,
			WebElement wednesday,WebElement thursday,WebElement friday, WebElement saturday)
	{
		if(dayOfWeek.equals("Sunday"))
		{
			
				
				switch(dayOfWeek)
				{
				
				case "Sunday":
					if(!sunday.isSelected())
					{
						sunday.click();
						sfbaseTestLog.info("Sunday CB is selected");
					}
					if(monday.isSelected())
					
						monday.click();
						sfbaseTestLog.info("unselecting monday CB");
					
					if(tuesday.isSelected())
						tuesday.click();
						sfbaseTestLog.info("unselecting tuesday CB");
					}
					if(wednesday.isSelected())
						wednesday.click();
						sfbaseTestLog.info("unselecting wednesday CB");
					}
					if(thursday.isSelected())
						thursday.click();
						sfbaseTestLog.info("unselecting thursday CB");
					
					if(friday.isSelected())
						friday.click();
						sfbaseTestLog.info("unselecting friday CB");
					
					if(saturday.isSelected())
						saturday.click();
						sfbaseTestLog.info("unselecting saturday CB");
					
			
				if(monday.isSelected())
				{
					monday.click();
				}
			}
			
			public void chkCBSelection(String dayOfWeek,WebElement sunday,
					WebElement monday,WebElement tuesday,
					WebElement wednesday,WebElement thursday,WebElement friday, WebElement saturday)
			{
			if(dayOfWeek.equals("Monday"))
			{
				if(monday.isSelected())
					sfbaseTestLog.info("INFO:recurrence CB correctly checked");
				else
					sfbaseTestLog.info("ERROR:recurrence CB correctly checked");
			}
			else if(dayOfWeek.equals("Tuesday"))
			{
				if(tuesday.isSelected())
					sfbaseTestLog.info("INFO:recurrence CB correctly checked");
				else
					sfbaseTestLog.info("ERROR:recurrence CB correctly checked");
			}
			else if(dayOfWeek.equals("Wednesday"))
			{
				if(wednesday.isSelected())
					sfbaseTestLog.info("INFO:recurrence CB correctly checked");
				else
					sfbaseTestLog.info("ERROR:recurrence CB correctly checked");
			}
			else if(dayOfWeek.equals("Thursday"))
			{
				if(thursday.isSelected())
					sfbaseTestLog.info("INFO:recurrence CB correctly checked");
				else
					sfbaseTestLog.info("ERROR:recurrence CB correctly checked");
			}
			else if(dayOfWeek.equals("Friday"))
			{
				if(friday.isSelected())
					sfbaseTestLog.info("INFO:recurrence CB correctly checked");
				else
					sfbaseTestLog.info("ERROR:recurrence CB NOT correctly checked");
			}
			else if(dayOfWeek.equals("Saturday"))
			{
				if(saturday.isSelected())
					sfbaseTestLog.info("INFO:recurrence CB correctly checked");
				else
					sfbaseTestLog.info("ERROR:recurrence CB NOT correctly checked");
			}
			
			
			
		}
			
		
	
	

	
	
	public void sfLogin() throws InterruptedException
	{
		String username=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"username");
		String password1=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"password");
		SoftAssert sftAsrt = new SoftAssert();
		goToUrl("https://login.salesforce.com/");
		String expTitle="Login | Salesforce";
		String title=driver.getTitle();
		sfbaseTestLog.info("title="+title);
		sftAsrt.assertEquals(title, expTitle,"Not on Salesforce login page");
		Thread.sleep(5000);
		WebElement username1= driver.findElement(By.xpath("//input[@name='username']"));	
		sftAsrt.assertTrue(username1.isDisplayed(),"username element is not displayed");
		username1.clear();
		username1.sendKeys(username);
		Thread.sleep(5000);
		WebElement password=driver.findElement(By.cssSelector("input#password"));
		sftAsrt.assertTrue(password.isDisplayed(),"password element is not displayed");
		password.sendKeys(password1);
		sfbaseTestLog.info("password data is entered in password textbox");
		sfbaseTestLog.info("password element is not displayed");
		Thread.sleep(5000);
		WebElement loginButton= driver.findElement(By.cssSelector("input#Login"));
		sftAsrt.assertTrue(loginButton.isDisplayed(),"login button is not displayed");
		loginButton.click();
		sfbaseTestLog.info("login element is clicked");
		sfbaseTestLog.info("login element is not displayed");
		Thread.sleep(6000);
		//Home Page ~ Salesforce - Developer Edition]
		String expTitle1="Home | Salesforce";
		String title1=driver.getTitle();
		sfbaseTestLog.info("title1="+title1);
		sftAsrt.assertEquals(title1.contains("Home"), true, "Not on Salesforce Home page");
		sfbaseTestLog.info("Salesforce Home Page opens");
		sftAsrt.assertAll();
	}
	
	
	public void gotoHomeSF() throws InterruptedException
	{
		
		//sfLogin(browserName,userName,password1);
		
		Thread.sleep(5000);
		
		WebElement hometab= driver.findElement(By.xpath("//span[text()='Home']"));	
		if(hometab.isDisplayed()) {
			hometab.click();
			Thread.sleep(5000);
			sfbaseTestLog.info("homepage displayed");
		}
		else {
			sfbaseTestLog.info("homepage not displayed");
		}
		//driver.close();
		
	}
	 
	public void gotoHomeSFClassic() throws InterruptedException
	  {
		  WebElement profileImg= driver.findElement(By.xpath("//img[@class='profileTrigger branding-user-profile circular']"));	
			if(profileImg.isDisplayed()) {
				profileImg.click();
				Thread.sleep(5000);
				WebElement switchToSFClassicLink= driver.findElement(By.xpath("//a[text()=\"Switch to Salesforce Classic\"]"));
				switchToSFClassicLink.click();
				Thread.sleep(5000);
				WebElement switchToLighteningLink= driver.findElement(By.className("switch-to-lightning"));
				if(switchToLighteningLink != null)
				{
					sfbaseTestLog.info("Salesforce Classic page displayed");
				}
				else
				{sfbaseTestLog.info("Error while going to Salesforce Classic page");}
				
			}
			
	  }
	
		public void sfLogoutClassic() throws InterruptedException
		{
			SoftAssert sa = new SoftAssert();
			WebElement userProfileLinkMenuItem= driver.findElement(By.xpath("//div[@id='userNav']"));
			userProfileLinkMenuItem.click();
			Thread.sleep(5000);
			//sfbaseTestLog.info("User Profile page opened");
			WebElement logout= driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			logout.click();
			Thread.sleep(5000);
			String actTitle=driver.getTitle();
			String expTitle="Login | Salesforce";
			sa.assertEquals(actTitle, expTitle,"Login page not displayed on clicking Logout link");
			sa.assertAll();		
		}
		
		
	
		public void switchToSFLightening()
		{
			
		}
		
		
		
		public void matchProfilePages() throws InterruptedException
		{
			WebElement classicHome= driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]"));
			classicHome.click();
			Thread.sleep(5000);
			WebElement userProfileLink= driver.findElement(By.cssSelector(".currentStatusUserName > a:nth-child(1)"));
			userProfileLink.click();
			String userProfileTitle=driver.getTitle();
			WebElement userProfileLinkMenuItem= driver.findElement(By.xpath("//div[@id='userNav']"));
			userProfileLinkMenuItem.click();
			sfbaseTestLog.info("User Profile page opened");
			Thread.sleep(5000);
			WebElement myProfileLink=driver.findElement(By.xpath("//a[text()='My Profile']"));
			myProfileLink.click();
			sfbaseTestLog.info("My profile page opened");
			Thread.sleep(5000);
			String linkUPMP=driver.getTitle();
			
			if(userProfileTitle.equals(linkUPMP))
			{
				sfbaseTestLog.info("PASS:Both profile pages are same");
				//sfLogoutClassic();
				driver.close();
			}
			else
			{
				sfbaseTestLog.info("FAIL:Both profile pages are not same");
				//sfLogoutClassic();
				driver.close();
			}
			
		}
		 
		public void getItemsFromTable()
		{
			 WebElement Webtable=driver.findElement(By.id("TableID"));
			 WebElement availableTabsList=driver.findElement(By.id("duel_select_0"));
			 WebElement selectedTabsList=driver.findElement(By.id("duel_select_1"));
			 WebElement moveToSelListIcon=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
			 WebElement moveToAvailListIcon=driver.findElement(By.xpath("//img[@class='leftArrowIcon']"));
			 WebElement saveButton=driver.findElement(By.xpath("//input[@value=' Save ']"));
			 
			 
			 
			//img[@class='rightArrowIcon']
			//input[@value=' Save ']
			 List<WebElement> TotalRowCount=Webtable.findElements(By.xpath("//*[@id='TableID']/tbody/tr"));
			    sfbaseTestLog.info("No. of Rows in the WebTable: "+TotalRowCount.size());
			    // Now we will Iterate the Table and print the Values   
			    int RowIndex=1;
			    for(WebElement rowElement:TotalRowCount)
			    {
			        List<WebElement> TotalColumnCount=rowElement.findElements(By.xpath("td"));
			        int ColumnIndex=1;
			        for(WebElement colElement:TotalColumnCount)
			        {
			            sfbaseTestLog.info("Row "+RowIndex+" Column "+ColumnIndex+" Data "+colElement.getText());
			            ColumnIndex=ColumnIndex+1;
			        }
			        RowIndex=RowIndex+1;
			    }
			
		}
		
		  public void customizeTab_addTab(String nameOfTab) throws InterruptedException
		  {
			 
			  WebElement allTabsIcon = driver.findElement(By.id("AllTab_Tab"));
			  Thread.sleep(5000);
			  Actions action=new Actions(driver);
			  action.moveToElement(allTabsIcon).build().perform();
			  Thread.sleep(5000);
			   allTabsIcon.click();
			   Thread.sleep(5000);
			  String title=driver.getTitle();
			  sfbaseTestLog.info("All Tabs Title:"+ title);
			  if(title.contains("All Tabs"))
			  {
				sfbaseTestLog.info("INFO: All Tabs page is displayed");
				 WebElement customizeTabButton = driver.findElement(By.xpath("//input[@value='Customize My Tabs']"));
							if(customizeTabButton.isDisplayed())
							{
								customizeTabButton.click();
								Thread.sleep(5000);
								sfbaseTestLog.info("INFO: 'Customize My Tabs' button clicked"); 
							}
							String customizePageTitle = driver.getTitle();
							if(customizePageTitle.contains("Customize My Tabs"))
							{
								sfbaseTestLog.info("INFO: 'Customize My Tabs' page is displayed"); 
								 WebElement availableTabsList=driver.findElement(By.id("duel_select_0"));
								Select select = new Select(availableTabsList);
								 List<WebElement> optionList = select.getOptions();
								 select.selectByVisibleText(nameOfTab);
								 WebElement moveToSelListIcon=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
								 moveToSelListIcon.click();
								 
								 WebElement selectedTabsList=driver.findElement(By.id("duel_select_1"));
								 Select select1 = new Select(selectedTabsList);
								 List<WebElement> optionList1 = select1.getOptions();
								 select1.selectByVisibleText(nameOfTab);
								 WebElement saveButton=driver.findElement(By.xpath("//input[@value=' Save ']"));
								 Thread.sleep(5000);
								 saveButton.click();
								 Thread.sleep(5000);
								 WebElement menuBar=driver.findElement(By.id("tabBar"));
								 List<WebElement> links = menuBar.findElements(By.tagName("li"));
								 boolean isPresent=false;
								 for (int i = 1; i < links.size(); i++)
								 {
								     sfbaseTestLog.info(links.get(i).getText());
								     String itemVal= links.get(i).getText();
								     
								     if (itemVal.equals(nameOfTab))
								     {
								    	 //sfbaseTestLog.info("INFO:Item add to the menu bar");
								    	 sfbaseTestLog.info("INFO:Item added to the menu bar"+nameOfTab);
								    	 isPresent=true;
								     }
								    
								 }
								 if(!isPresent)
							     {
							    	sfbaseTestLog.info("FAIL:Item NOT added to menu bar");
							     }
							}
							else
							{
								sfbaseTestLog.info("ERROR: 'Customize My Tabs' page NOT displayed"); 
							}
				  	}
			  
			  else
			  {
				  sfbaseTestLog.info("ERROR: Error displaying All Tabs page" );
			  
			  }
		
		  }
		  
		  
		  
		  public void gotoLeadsPage() throws InterruptedException
		  {
			  
				Thread.sleep(5000);
				WebElement leadsTab = driver.findElement(By.id("Lead_Tab"));
				leadsTab.click();
				String leadPgTitle= driver.getTitle();
				if(leadPgTitle.equals("Leads: Home ~ Salesforce - Developer Edition"))
				{
					sfbaseTestLog.info("PASS: Leads page is displayed on clicking Leads tab");
				}
				else 
				{
					sfbaseTestLog.info("FAIL: Leads page is NOT displayed on clicking Leads tab");
				}
		  }
		  
		  public void gotoOpptysPage() throws InterruptedException
		  {
			  
				Thread.sleep(5000);
				WebElement opptyTab = driver.findElement(By.id("Opportunity_Tab"));
				opptyTab.click();
				String opptyPgTitle= driver.getTitle();
				if(opptyPgTitle.equals("Opportunities: Home ~ Salesforce - Developer Edition"))
				{
					sfbaseTestLog.info("PASS: Opportunities page is displayed on clicking opportunity tab");
				}
				else 
				{
					sfbaseTestLog.info("FAIL: Opportunities page is NOT displayed on clicking opportunity tab");
				}
		  }
		  
		  public void calendarSF(String monthInLetters, String yearInFourDigit, String dateInTwoNum) throws InterruptedException
		  {
			   WebElement calendar=driver.findElement(By.id("datePicker"));
				WebElement monthPicker= driver.findElement(By.id("calMonthPicker"));
				WebElement yearPicker= driver.findElement(By.id("calYearPicker"));
				
				
				WebElement calBody = driver.findElement(By.id("datePickerCalendar"));
				//WebElement yearPicker= driver.findElement(By.id("calYearPicker"));
				List<WebElement> calRows= calendar.findElements(By.tagName("tr"));
				sfbaseTestLog.info("totRows: "+calRows.size());
				List<WebElement> calCols= calendar.findElements(By.tagName("th"));
				sfbaseTestLog.info("totCols: "+calCols.size());
				List<WebElement> calData= calendar.findElements(By.tagName("td"));
				sfbaseTestLog.info("totDays: "+calData.size());
				
				Select newSelectMon = new Select(monthPicker);
				//newSelectMon.selectByVisibleText("July");
				newSelectMon.selectByVisibleText(monthInLetters);
				Thread.sleep(5000);
				
				yearPicker.click();
				Thread.sleep(5000);
				
				Select newSelectYear = new Select(yearPicker);
				//newSelectYear.selectByValue("2025");
				newSelectYear.selectByVisibleText(yearInFourDigit);
				
			
				for (WebElement d:calData)
				{ 
					sfbaseTestLog.info(d.getText());
					//if(d.getText().equals("15"))
					if(d.getText().equals(dateInTwoNum))
					{
						d.click();
						Thread.sleep(10000);
						//return;
					}
				}

			  
		  }
		  
		  
		  public void checkUserMenuItems() throws InterruptedException
		  {
			  SoftAssert sa = new SoftAssert();
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
				sfbaseTestLog.info("Chking for 'My Profile' Item in user menu drop down");
				extentReport.logTestInfo("Chking for 'My Profile' Item in user menu drop down");
				
				sa.assertTrue(mySettingsItem.isDisplayed(),"My Settings item not displayed in user menu");
				sfbaseTestLog.info("Chking for 'My Settings' Item in user menu drop down");
				extentReport.logTestInfo("Chking for 'My Settings' Item in user menu drop down");
					
				sa.assertTrue(devConItem.isDisplayed(),"Developer Console item not displayed in user menu");
				sfbaseTestLog.info("Chking for 'Developer Console' Item in User Menu dropdown");
				extentReport.logTestInfo("Chking for 'Developer Console' Item in User Menu dropdowm");
				
				sa.assertTrue(switchToLghtItem.isDisplayed(),"'Switch to Lightning' item not displayed in user menu");
				sfbaseTestLog.info("Chking for 'Switch to Lightning' Item in user menu drop down");
				extentReport.logTestInfo("Chking for 'Switch to Lightning' Item in user menu drop down");
				
				sa.assertTrue(logoutItem.isDisplayed(),"'Logout' item not displayed in user menu");
				sfbaseTestLog.info("Chking for 'Logout' Item in user meny drop down");
				extentReport.logTestInfo("Chking for 'Logout' Item in user menu drop down");
				
				sa.assertAll();
		  }
		  
		  
}
	
	
	

