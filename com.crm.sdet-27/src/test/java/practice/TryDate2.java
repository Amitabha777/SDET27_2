package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TryDate2 {

	public static void main(String[] args)
	{
		
	
	Date date= new Date();
	
	String currentDate= date.toString();
	
	System.out.println("Current Date:"+currentDate);
	
	System.out.println("CR Date="+date);
	
	Calendar cal = Calendar.getInstance();
	
	Date dt = cal.getTime();
	String dat= dt.toString();
	
	
	System.out.println("Calendar DAte:"+dt);
	
	String Year= currentDate.split(" ")[5];
	System.out.println(Year);
	
	String Day= currentDate.split(" ")[2];
	System.out.println(Day);
	
	int Month= date.getMonth()+1;
	
	String FormattedDate= Day+"-"+Month+"-"+Year;
	
	System.out.println("Formatted Date:"+FormattedDate);
	
	String Yr= dat.split(" ")[5];
	System.out.println(Yr);
	
	String Dy= dat.split(" ")[2];
	System.out.println(Dy);
	
	int Mnth= cal.MONTH;
	System.out.println("month:"+Mnth);
	
	
	String FrmtDate= Dy+"-"+Mnth+"-"+Yr;
	
	System.out.println("Formatted Date2:"+FrmtDate);
	
	
	SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
	
	String reqDate=sdf.format(dt);
	System.out.println("ReqDate:"+ reqDate);
	
	
	}
}
