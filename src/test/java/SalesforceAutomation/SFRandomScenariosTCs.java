package SalesforceAutomation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import SalesforceBaseTest.BaseTest;
import SalesforceBaseTest.SFBaseTest;
import SalesforceUtilities.PropertiesUtility;
import SalesforceUtilities.SFConstants;

public class SFRandomScenariosTCs extends SFBaseTest{
	
		
			public void sfloginTC33(String browserName,String userName, String password1) throws InterruptedException
			{
				sfLogin(browserName, userName, password1);
				Thread.sleep(5000);
				
				WebElement switchToLightningLinkClassic = driver.findElement(By.xpath("//a[contains(@class,'switch-to-lightning')]"));
				
				if(switchToLightningLinkClassic.isDisplayed())//switchToLightningLinkClassic.click();
				{
						
					matchProfilePages();
				}
				else
				{
					gotoHomeSFClassic();
					matchProfilePages();
				}
			}
			
			public void sfloginTC34(String browserName,String userName, String password1,String changeLastNameStr) throws InterruptedException
			{
				sfLogin(browserName, userName, password1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				Thread.sleep(5000);
				WebElement classicHome= driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]"));
				classicHome.click();
				Thread.sleep(5000);
				WebElement userProfileLink= driver.findElement(By.cssSelector(".currentStatusUserName > a:nth-child(1)"));
				userProfileLink.click();
				String userProfileTitle=driver.getTitle();
				System.out.println("User profile page is displayed");
				WebElement editProfileIcon= driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
				
				editProfileIcon.click();
				Thread.sleep(5000);
				WebElement editProfileWin= driver.findElement(By.id("contactInfoTitle"));
				Thread.sleep(5000);
				if(editProfileWin.isDisplayed())
				{
					System.out.println("PASS:Edit Contact page displayed" +editProfileWin);
				}
				else
				{
					System.out.println("FAIL:Edit Contact page not displayed");
				}
				//String currWin=driver.getTitle();
				//System.out.println("Looking for EditContact Page.Page displayed is:  " +currWin);
				/*if(editProfileWin.isSelected())
				{
					System.out.println("PASS:Edit Contact page displayed");
				}
				else
				{
					System.out.println("FAIL:Edit Contact page not displayed");
				}
				WebElement contactWE= driver.findElement(By.id("contactTab"));
				if(contactWE.isSelected())
				{
					System.out.println("PASS: Edit Profile Page displayed.Contact tab selected on 'Edit Contact' page");
				}
				else
				{
					System.out.println("FAIL: Edit Profile Page NOT displayed.Contact tab not selected 'Edit Contact' page");
				}
				/*WebElement emailEditContact= driver.findElement(By.id("email"));
				if(emailEditContact.isEnabled())
				{
					System.out.println("Focus on email textbox");	
				}
				else
				{
					System.out.println("Focus NOT on email textbox");	
				}*/
				Thread.sleep(10000);
				try {
				WebElement aboutWE= driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
				Actions aboutAction = new Actions(driver);
				aboutAction.moveToElement(aboutWE).build().perform();
				System.out.println("web element:"+aboutWE);
				//aboutWE.
				aboutWE.click();
				}catch (Exception e) 
				{
					System.out.println(e);
				}
				WebElement fnAbout= driver.findElement(By.id("firstName"));
				if(fnAbout.isSelected())
				{
					System.out.println("First Name textbox is selected");	
				}
				else
				{
					System.out.println("First Name textbox is NOT selected");	
				}
				WebElement lnAbout= driver.findElement(By.id("lastName"));
				String changeLastName=changeLastNameStr;
				lnAbout.sendKeys(changeLastName);
				WebElement saveallButton= driver.findElement(By.xpath("//input[@value='Save All']"));
				saveallButton.click();
				Thread.sleep(5000);
				String winTitle=driver.getTitle();
				if(winTitle.contains("User: "))
				{
					System.out.println("PASS: Edit Popup Closed");	
				}
				else
				{
					System.out.println("FAIL: Error in closing edit contact popup");	
				}
				
				
				//web elements to check the updated name
				WebElement userNameLink= driver.findElement(By.id("tailBreadcrumbNode"));
				String untext=userNameLink.getText();
				if(untext.contains(changeLastName))
				{
					System.out.println("PASS: User name changed at top left ");
				}
				else 
				{
					System.out.println("FAIL: User name not changed at top left ");
				}
				WebElement userNameLinkTopRt= driver.findElement(By.id("userNav"));
				String untextRt=userNameLink.getText();
				if(untextRt.contains(changeLastName))
				{
					System.out.println("PASS: User name changed at top left ");
				}
				else 
				{
					System.out.println("FAIL: User name not changed at top left ");
				}
				
				driver.close();
				
				
			}
			
			public void sfloginTC35(String browserName,String userName, String password1) throws InterruptedException
			{
				sfLogin(browserName, userName, password1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				WebElement plusTab= driver.findElement(By.xpath("//img[@class='allTabsArrow']"));
				WebElement customizemyTab= driver.findElement(By.xpath("//input[@value='Customize My Tabs']"));
				WebElement selectedTabs= driver.findElement(By.id("duel_select_1"));
				WebElement availableTabs= driver.findElement(By.id("duel_select_0"));
				WebElement removeButton= driver.findElement(By.xpath("//img[@class='leftArrowIcon']"));
				WebElement saveButton= driver.findElement(By.xpath("//input[@class='btn primary']"));
				WebElement tabToRemove= driver.findElement(By.xpath("//option[@value='ContentSubscriptions']"));
				WebElement removedTabinAllTabs= driver.findElement(By.xpath("//a[@class='listRelatedObject contentSubscriptionsBlock title']"));
				
				
				Actions aboutAction = new Actions(driver);
				aboutAction.moveToElement(plusTab).build().perform();
				System.out.println("web element:"+plusTab);
				Thread.sleep(5000);
				plusTab.click();
				Thread.sleep(5000);
				customizemyTab.click();
				tabToRemove.click();
				removeButton.click();
				availableTabs.click();
				if(tabToRemove.isDisplayed())
				{
					System.out.println("PASS:Removed item in available tab" +tabToRemove);
				}
				else
				{
					System.out.println("FAIL:Removed item in NOT available tab" +tabToRemove);
				}
				saveButton.click();
				
				if(removedTabinAllTabs.isDisplayed())
				{
					System.out.println("PASS:Removed item seen on All tabs Page" +tabToRemove);
				}
				else
				{
					System.out.println("FAIL:Removed item in NOT on All tabs Page" +tabToRemove);
				}
				
				sfLogoutClassic();
				sfLogin(browserName, userName, password1);
				plusTab.click();
				
				if(removedTabinAllTabs.isDisplayed())
				{
					System.out.println("PASS:Removed item seen on All tabs Page after logging inagain" +tabToRemove);
				}
				else
				{
					System.out.println("FAIL:Removed item in NOT on All tabs Page after logging in again" +tabToRemove);
				}
							
				/*List<String> allAvailableItems = new ArrayList<String>();
				for(int i=0;i<allAvailableItems.size();i++)
				{
				}*/
				sfLogoutClassic();
				driver.close();
				
			}
			
			public void sfLoginTC36(String browserName,String userName, String password1) throws InterruptedException
			{
				
				sfLogin(browserName, userName, password1);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				WebElement classicHome= driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]"));
				classicHome.click();
				WebElement dateHome= driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
				WebElement calPageTitle = driver.findElement(By.xpath("//title[text()='Calendar for Renu Dixit ~ Salesforce - Developer Edition']"));
				WebElement eightpmLink= driver.findElement(By.id("p:f:j_id25:j_id61:28:j_id64"));
				//div[@id='p:f:j_id25:j_id61:28:j_id64']
				WebElement newEventPage= driver.findElement(By.xpath("//title[text()='Calendar: New Event ~ Salesforce - Developer Edition']"));
				WebElement subjectTB= driver.findElement(By.id("evt5"));
				WebElement subjectIcon= driver.findElement(By.xpath("//img[@title='Subject Combo (New Window)']"));
				
				WebElement subjectCB= driver.findElement(By.xpath("//h1[text()='Select a Subject below.']"));
				WebElement otherText = driver.findElement(By.xpath("//li[@class='listItem4']"));
				WebElement EndDateTimeDD = driver.findElement(By.id("EndDateTime_time"));
				WebElement saveButton = driver.findElement(By.xpath("//td[@id='bottomButtonRow']"));
				
				WebElement OtherLink = driver.findElement(By.xpath("//a[@title='Busy - Other']"));
				//td[@id='bottomButtonRow']
				//a[@title='Busy - Call']
				String expTitle="Calendar for Renu Dixit ~ Salesforce - Developer Edition";
				String actualTitle= calPageTitle.getText();
				System.out.println("Date is:" +dateHome);	
				String dateStr= dateHome.getText();
				System.out.println("Date is:" +dateStr);
				String dateStrNoComma= dateStr.replace(",", "");	
				System.out.println("dateStr:"+dateStr);
				//matchDate(dateStrNoComma);
				String expDate= "Sunday February 4, 2024";
				if(dateStr.equals(expDate))
				{
					System.out.println("INFO: Date displayed as expected");	
				}
				else
				{
					System.out.println("ERROR:Date not displayed correctly");
				}
				Point dateHomeLoc=dateHome.getLocation();
				int xcord = dateHomeLoc.getX();
				System.out.println("Position of the DateTimeField from left side is "+xcord +" pixels");
				int ycord = dateHomeLoc.getY();
				System.out.println("Position of the DateTimeField from top side is "+ycord +" pixels");
				
				
				if(( actualTitle).contains("~ Salesforce - Developer Edition"))
				{
					System.out.println("INFO: Calendar page displayed");	
				}
				else
				{
					System.out.println("ERROR: Calendar page NOT displayed");
				}
				
				eightpmLink.click();
				Thread.sleep(5000);
				String newEventPageTitle=newEventPage.getText();
				if(newEventPageTitle.contains("Calendar: New Event ~ Salesforce" ))
				{
					System.out.println("INFO: Calendar New Event Page displayed");
				}
				else
				{
					System.out.println("ERROR: Calendar New Event Page NOT displayed");
				}	
				if(subjectTB.isEnabled())
				{
					System.out.println("INFO: cursor on subject textbox");
				}
				else
				{
					System.out.println("ERROR:cursor not on subject text box");
				}	
				subjectIcon.click();
				String cbText=subjectCB.getText();
				if(cbText.contains("Select a Subject below"))
				{
					System.out.println("INFO: Combo Box pop up displayed");
					otherText.click();
					if(subjectIcon.isDisplayed())
					{
						System.out.println("INFO: Combo Box pop up closed after selecting a subject");
						String subText=subjectTB.getText();
						if(subText.equals("Other"))
						{
							System.out.println("INFO: Subject getting selected correctly");
						}
						else
						{
							System.out.println("ERROR: Subject NOT getting selected correctly");
						}
						
					}
					else
					{
						System.out.println("ERROR: Combo Box pop up NOT closed after selecting a subject");
					}
					
				}
				else
				{
					System.out.println("FAIL: Combo Box pop up  NOT displayed");
				}
				if(EndDateTimeDD.isDisplayed())
				{
					System.out.println("INFO: End Time field is visible");
					String endTimeVal= EndDateTimeDD.getText();
					if(endTimeVal.contains("9:00 PM") && endTimeVal.contains("10:00 PM") && endTimeVal.contains("11:00 PM") && endTimeVal.contains("11:30 PM"))
					{
						System.out.println("INFO: Time values in end Time field showing correctly"+endTimeVal);
						Select endTime = new Select(driver.findElement(By.id("EndDateTime_time")));
						endTime.selectByVisibleText("9:00 PM");
						WebElement o = endTime.getFirstSelectedOption();
					    String selectedoption = o.getText();
					    System.out.println("Selected element: " + selectedoption);
					    if(selectedoption.equals("9:00 PM"))
					    {
					    	System.out.println("INFO: time correctly selected" );
					    }
					    {
					    	System.out.println("ERROR: time selection not correct" +selectedoption);
					    }
						if(saveButton.isDisplayed())
						{
							System.out.println("INFO: Save button displayed" );
							saveButton.click();
							Thread.sleep(5000);
							if(OtherLink.isDisplayed())
							{
								System.out.println("INFO: Selected event displayed in calendar details" );
								String otherLinkVal=OtherLink.getAttribute("href");
								if(otherLinkVal.contains("URL"))
								{
									System.out.println("PASS: Selected event displayed in calendar details as a link" );
								}
								else
									System.out.println("FAIL: Selected event NOTs displayed in calendar details as a link" );
							}
							else 
							{
								System.out.println("ERROR: Selected event not displayed in calender details" );
							}
							
						}
						else
						{
							System.out.println("ERROR: Save button displayed" );
						}
							
						
					}
					else
					{
						System.out.println("ERROR: Time values in end Time field NOT showing correctly"+endTimeVal);
					}
					
				}
				else
				{
					System.out.println("ERROR: End Time field is visible");
				}
	
			}
			
			public void sfLoginTC37(String browserName,String userName, String password1) throws InterruptedException
			{
			
			sfLogin(browserName, userName, password1);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			WebElement classicHome= driver.findElement(By.xpath("//a[contains(@title,'Home Tab')]"));
			classicHome.click();
			WebElement dateHome= driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
			WebElement calPageTitle = driver.findElement(By.xpath("//title[text()='Calendar for Renu Dixit ~ Salesforce - Developer Edition']"));
			WebElement eightpmLink= driver.findElement(By.id("p:f:j_id25:j_id61:28:j_id64"));
			//div[@id='p:f:j_id25:j_id61:28:j_id64']
			WebElement newEventPage= driver.findElement(By.xpath("//title[text()='Calendar: New Event ~ Salesforce - Developer Edition']"));
			WebElement subjectTB= driver.findElement(By.id("evt5"));
			WebElement subjectIcon= driver.findElement(By.xpath("//img[@title='Subject Combo (New Window)']"));
			
			WebElement subjectCB= driver.findElement(By.xpath("//h1[text()='Select a Subject below.']"));
			WebElement otherText = driver.findElement(By.xpath("//li[@class='listItem4']"));
			WebElement EndDateTimeDD = driver.findElement(By.id("EndDateTime_time"));
			WebElement saveButton = driver.findElement(By.xpath("//td[@id='bottomButtonRow']"));
			
			WebElement OtherLink = driver.findElement(By.xpath("//a[@title='Busy - Other']"));
			WebElement recurrenceCB = driver.findElement(By.id("IsRecurrence"));
			WebElement freqSection = driver.findElement(By.xpath("//table[@class='recurrenceTable']"));
			WebElement freqStartDate = driver.findElement(By.id("RecurrenceStartDateTime"));
			WebElement freqEndDate = driver.findElement(By.id("RecurrenceEndDateOnly"));
			
			WebElement weeklyRB = driver.findElement(By.id("rectypeftw"));
			WebElement recursTB = driver.findElement(By.id("wi"));
			WebElement sundayCB = driver.findElement(By.id("1"));
			WebElement mondayCB = driver.findElement(By.id("2"));
			WebElement tuesdayCB = driver.findElement(By.id("4"));
			WebElement wednesdayCB = driver.findElement(By.id("8"));
			WebElement thursdayCB = driver.findElement(By.id("16"));
			WebElement fridayCB = driver.findElement(By.id("32"));
			WebElement saturdayCB = driver.findElement(By.id("64"));
			WebElement maxRecurrDateLink = driver.findElement(By.id("maxRecurrence"));
			WebElement recurrEndTB = driver.findElement(By.id("RecurrenceEndDateOnly"));
			WebElement recurrStartTB = driver.findElement(By.id("RecurrenceStartDateTime"));
			WebElement monthViewIcon = driver.findElement(By.xpath("//img[@alt='Month View']"));
			WebElement monthViewCell1 = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[2]/div[1]/div[1]/table/tbody/tr[5]/td[6]"));
			WebElement monthViewCell2 = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[2]/div[1]/div[1]/table/tbody/tr[6]/td[6]"));
			
			String expTitle="Calendar for Renu Dixit ~ Salesforce - Developer Edition";
			String actualTitle= calPageTitle.getText();
			System.out.println("Date is:" +dateHome);	
			String dateStr= dateHome.getText();
			System.out.println("Date is:" +dateStr);
			String dateStrNoComma= dateStr.replace(",", "");	
			System.out.println("dateStr:"+dateStr);
			//matchDate(dateStrNoComma);
			String expDate= "Sunday February 4, 2024";
			if(dateStr.equals(expDate))
						System.out.println("INFO: Date displayed as expected");	
			else
						System.out.println("ERROR:Date not displayed correctly");
			Point dateHomeLoc=dateHome.getLocation();
			int xcord = dateHomeLoc.getX();
			System.out.println("Position of the DateTimeField from left side is "+xcord +" pixels");
			int ycord = dateHomeLoc.getY();
			System.out.println("Position of the DateTimeField from top side is "+ycord +" pixels");
					
			if(( actualTitle).contains("~ Salesforce - Developer Edition"))
					System.out.println("INFO: Calendar page displayed");	
			else
					System.out.println("ERROR: Calendar page NOT displayed");
					
			eightpmLink.click();
			Thread.sleep(5000);
			String newEventPageTitle=newEventPage.getText();
			if(newEventPageTitle.contains("Calendar: New Event ~ Salesforce" ))
					System.out.println("INFO: Calendar New Event Page displayed");
			else
					System.out.println("ERROR: Calendar New Event Page NOT displayed");
			if(subjectTB.isEnabled())
					System.out.println("INFO: cursor on subject textbox");
			else
				System.out.println("ERROR:cursor not on subject text box");
	
			subjectIcon.click();
			String cbText=subjectCB.getText();
			if(cbText.contains("Select a Subject below"))
			{
				System.out.println("INFO: Combo Box pop up displayed");
				otherText.click();
				if(subjectIcon.isDisplayed())
				{
					System.out.println("INFO: Combo Box pop up closed after selecting a subject");
					String subText=subjectTB.getText();
					if(subText.equals("Other"))
							System.out.println("INFO: Subject getting selected correctly");
					else

						System.out.println("ERROR: Subject NOT getting selected correctly");
				
				}
				else
					System.out.println("ERROR: Combo Box pop up NOT closed after selecting a subject");
			}
			else
			{
				System.out.println("FAIL: Combo Box pop up  NOT displayed");
			}
			if(EndDateTimeDD.isDisplayed())
			{
				System.out.println("INFO: End Time field is visible");
				//String endTimeVal= EndDateTimeDD.getText();
				Select dropdown= new Select(EndDateTimeDD);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
				System.out.println(option.getText());
				String endTimeVal=option.getText();
				
				if(endTimeVal.contains("5:00 PM") && endTimeVal.contains("6:00 PM") && endTimeVal.contains("7:00 PM") && endTimeVal.contains("8:00 PM") && endTimeVal.contains("9:00 PM") && endTimeVal.contains("10:00 PM") && endTimeVal.contains("11:00 PM") && endTimeVal.contains("11:30 PM"))
				{
					System.out.println("INFO: Time values in end Time field showing correctly"+endTimeVal);
					Select endTime = new Select(driver.findElement(By.id("EndDateTime_time")));
					endTime.selectByVisibleText("7:00 PM");
					WebElement o = endTime.getFirstSelectedOption();
				    String selectedoption = o.getText();
				    System.out.println("Selected element: " + selectedoption);
				    if(selectedoption.equals("7:00 PM"))
				    {
				       	System.out.println("INFO: time correctly selected" );
				       	
				    }
				    else
				    {
				    	System.out.println("ERROR: time selection not correct" +selectedoption);
				    }
				   
				}
				 else
				{
					System.out.println("ERROR: Time values in end Time field NOT showing correctly"+endTimeVal);
				}
				
				if (recurrenceCB.isDisplayed())
				{
					System.out.println("Info: recurrence CB displayed");
					recurrenceCB.click();
					boolean freqSecChk = freqSection.isDisplayed();
					boolean freqStDateChk = freqStartDate.isDisplayed();
					boolean freqEndDateChk = freqEndDate.isDisplayed();
					if(freqStartDate.isDisplayed())
					{
						System.out.println("Info: frequency start date field displayed");
					}
					else
					{
						System.out.println("Error:  frequency start date field NOT displayed");
					}
					if(freqEndDate.isDisplayed())
					{
						System.out.println("Info: freqEndDate field displayed");
					}
					else
					{
						System.out.println("Error: freqEndDate field NOT displayed");
					}
					
					if(weeklyRB.isDisplayed())
					{
						weeklyRB.click();
						String recursTBStr=recursTB.getText();
						if(recursTBStr=="1")
						{
							System.out.println("INFO: Number set to 1 when weekly RB is selected");
						}
						else 
						{
							System.out.println("ERROR: Number not set to 1 when weekly RB is selected");
						}
						String dayOfWeek= currDayOfWeek();
						chkCBSelection(dayOfWeek,sundayCB,mondayCB,tuesdayCB,wednesdayCB,thursdayCB,fridayCB,saturdayCB);
						if(maxRecurrDateLink.isDisplayed())
						{
							maxRecurrDateLink.click();
							Thread.sleep(5000);
							if(recurrEndTB.isDisplayed())
							{
								String getTextEndDate = recurrEndTB.getText();
								String getTextStartDate = recurrStartTB.getText();
								//Date dt=new Date();
								//int dateCurr = dt.getDate();
								System.out.println("ERROR: Need to test the condition if end date is showing as 2 months plus of startdate");
								
								
							}
							if(saveButton.isEnabled())
							{
								saveButton.click();
								Thread.sleep(5000);
								System.out.println("Info: Save button is clicked");
								if(monthViewIcon.isDisplayed())
								{
									monthViewIcon.click();
									System.out.println("Info: month view icon clicked");
									if(monthViewCell1.isDisplayed())
									{
										System.out.println("PASS: Month View Calendar displayed" );
										monthViewCell1.getText();
										if(monthViewCell2.isDisplayed())
										{
											String cellText1=monthViewCell1.getText();
											String cellText2=monthViewCell1.getText();
											if(OtherLink.isDisplayed())
											{
												System.out.println("INFO: Selected event displayed in calendar details" );
												String otherLinkVal=OtherLink.getAttribute("href");
												if(otherLinkVal.contains("URL"))
												{
													System.out.println("PASS: Selected event displayed in calendar details as a link" );
												}
												else
													System.out.println("FAIL: Selected event NOTs displayed in calendar details as a link" );
											}
											else 
											{
												System.out.println("ERROR: Selected event not displayed in calender details" );
											}
											
										}
										System.out.println("FAIL: Month View Calendar NOT displayed" );
									}
									
									
								}
								else
									System.out.println("Error: Month view icon not displayed");
									
								}
								
								
							}
							}
							
							
						}
						
					}
					
				}
				else
				{
					System.out.println("Error: recurrence CB not displayed");
				}
				
			{
				System.out.println("ERROR: End Time field is visible");
			}
		}
			
			
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String browser=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"browser");
		String username=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"username");
		String password=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"password");
		
		SFRandomScenariosTCs sLogin = new SFRandomScenariosTCs();
		//sLogin.sfLogin(browser,username,password);
		//sLogin.gotoHomeSF();
		//sLogin.sfloginTC33(browser,username,password,"salesforce24");
		//sLogin.sfloginTC34(browser,username,password,"abcd");
		//sLogin.sfloginTC35(browser,username,password);
		 //sLogin.sfLoginTC36(browser,username,password);
		//sLogin.sfLoginTC37(browser,username,password);
		
		
	}

}
