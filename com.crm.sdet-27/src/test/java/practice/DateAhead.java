package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAhead {

	public static void main(String []args) 
	{
	
		Calendar cal= Calendar.getInstance();
		
		Date date=cal.getTime();
		
		System.out.println("Current Date: "+date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy");
		
		String reqDate=sdf.format(date);
		
		System.out.println("Current Date= "+reqDate);
		
		
		cal.add(Calendar.DAY_OF_YEAR, 37);
		
		date=cal.getTime();
		
		SimpleDateFormat sdf2= new SimpleDateFormat("dd-MMM-YYY");
		String newDate=sdf2.format(date);
		
		System.out.println("New Date: "+newDate);
	}
}
