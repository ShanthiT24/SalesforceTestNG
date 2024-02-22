package SalesforceAutomation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import SalesforceBaseTest.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFunc extends BaseTest{
	
		
		enum DayOfWeek {
			Sunday, 
		    Monday, 
			Tuesday, 
			Wednesday, 
			Thursday, 
			Friday, 
			Saturday}
		
		enum MonthOfYear {
			January, 
		    February, 
			March, 
			April, 
			May, 
			June, 
			July,
			August,
			September,
			October,
			November,
			December}
	
	public void matchDate(String str)
	{
		
		Calendar dt = Calendar.getInstance();
		/*dt.setTime(new Date(str));
		dt.is
		//System.out.println(dt.getDay());
		System.out.println(dt.DAY_OF_WEEK);
		System.out.println(dt.DAY_OF_MONTH);
		System.out.println(dt.DAY_OF_YEAR);
		*/
		
		//System.out.println(dt.DAY_OF_MONTH);
		String[] strSplit = str.split(" ");
		List<String> ls =  new ArrayList<String>();
		for(int j=0;j<strSplit.length;j++)
		{
			ls.add(strSplit[j]);
			if(j==0)
			{
				if(isDayOfWeek(ls.get(j)))
				{
					System.out.println(ls.get(j) + "is Valid day of the week");
				}
				
			}
			if(j==1)
			{
				if(isMonthOfYear(ls.get(j)))
				{
					System.out.println(ls.get(j) + "is Valid month of the year");
				}
				
			}
			if(j==2)
			{
				if(isDayOfTheMonth(ls.get(j)))
				{
					System.out.println(ls.get(j) + "is Valid day of the month");
				}
				
			}
			if(j==3)
			{
				if(isCorrectYear(ls.get(j)))
				{
					System.out.println(ls.get(j) + "is a Valid Year");
				}
				
			}
			
		}	
			
			
		 //Arrays.asList(strSplit); 
		 System.out.println(ls);
		 for (String k: ls)
		 {
			 System.out.println(k); 
		 }

	}
	
	public boolean isDayOfWeek(String str)
	{
		for (DayOfWeek c : DayOfWeek.values()) {
	        if (c.name().equals(str)) {
	            return true;
	        }
	    }

	    return false;
	}
	
	public boolean isMonthOfYear(String str)
	{
		for (MonthOfYear c : MonthOfYear.values()) {
	        if (c.name().equals(str)) {
	            return true;
	        }
	    }

	    return false;
	}
	
	public boolean isDayOfTheMonth(String str)
	{
	   java.lang.Integer dayOfMonth = new java.lang.Integer(str);
	   if(dayOfMonth >=1 && dayOfMonth <=31) {
	            return true;
	        
	    }

	    return false;
	}
	public boolean isCorrectYear(String str)
	{
	   java.lang.Integer yearValue = new java.lang.Integer(str);
	   if(yearValue >= 1970 && yearValue <=3000) {
	            return true;
	        
	    }

	    return false;
	}
	
	private boolean getDayOfWeek(String value){
	    boolean day = false;
	    switch(value){
	    case "Sunday":
	        day=true;
	        break;
	    case "Monday":
	        day=true;
	        break;
	    case "Tuesday":
	        day=true;
	        break;
	    case "Wednesday":
	        day=true;
	        break;
	    case "Thursday":
	        day=true;
	        break;
	    case "Friday":
	        day=true;
	        break;
	    case "Saturday":
	        day=true;
	        break;
	    }
	    return day;
	}
	
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}
}
