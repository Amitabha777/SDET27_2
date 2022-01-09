package practice;

import com.crm.autodesk.genericutility.JavaUtility;

public class TryDate {

	public static void main(String[] args) {
		
		JavaUtility jLib= new JavaUtility();
		
		String date= jLib.getSystemDateAndTime();
		
		System.out.println("System Date "+ date);
		
		
		String fDate= jLib.getDateInFormatYYYMMDD();
		System.out.println("Formatted: "+fDate);
		
	}
}
