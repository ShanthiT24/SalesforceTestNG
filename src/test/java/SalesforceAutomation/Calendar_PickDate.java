package SalesforceAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import SalesforceBaseTest.SFBaseTest;

public class Calendar_PickDate extends SFBaseTest{
	
	
	String Date ="July 17 2025";
	public void calPickDate(String Date) throws InterruptedException
	{
		
		WebElement menuBar=driver.findElement(By.id("tabBar"));
		WebElement oppTab = driver.findElement(By.id("Opportunity_Tab"));
		Thread.sleep(5000);
		oppTab.click();
		Thread.sleep(5000);
		WebElement newOppButton=driver.findElement(By.xpath("//input[@value=' New ']"));
		newOppButton.click();
		Thread.sleep(5000);
		WebElement closeDateTB=driver.findElement(By.id("opp9"));
		Thread.sleep(5000);
		closeDateTB.click();
		WebElement calendar=driver.findElement(By.id("datePicker"));
		WebElement monthPicker= driver.findElement(By.id("calMonthPicker"));
		WebElement yearPicker= driver.findElement(By.id("calYearPicker"));
		
		
		WebElement calBody = driver.findElement(By.id("datePickerCalendar"));
		//WebElement yearPicker= driver.findElement(By.id("calYearPicker"));
		List<WebElement> calRows= calendar.findElements(By.tagName("tr"));
		System.out.println("totRows: "+calRows.size());
		List<WebElement> calCols= calendar.findElements(By.tagName("th"));
		System.out.println("totCols: "+calCols.size());
		List<WebElement> calData= calendar.findElements(By.tagName("td"));
		System.out.println("totDays: "+calData.size());
		
		Select newSelectMon = new Select(monthPicker);
		newSelectMon.selectByVisibleText("July");
		Thread.sleep(5000);
		
		yearPicker.click();
		Thread.sleep(5000);
		
		Select newSelectYear = new Select(yearPicker);
		//newSelectYear.selectByValue("2025");
		newSelectYear.selectByVisibleText("2025");
		
	
		for (WebElement d:calData)
		{ 
			System.out.println(d.getText());
			if(d.getText().equals("15"))
			{
				d.click();
				Thread.sleep(10000);
				//return;
			}
		}

		driver.quit();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Calendar_PickDate calDate= new Calendar_PickDate();
		calDate.sfLogin("Chrome","renu@xyzcorp.com", "salesforce24");
		calDate.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		calDate.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String Date ="July 17 2025";
		calDate.calPickDate(Date);
		
	}

}
