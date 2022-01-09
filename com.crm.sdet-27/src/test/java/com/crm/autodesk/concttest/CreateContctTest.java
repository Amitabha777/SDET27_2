package com.crm.autodesk.concttest;

import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.objectrepository.ContactInformationPage;
import com.crm.autodesk.objectrepository.ContactsPage;
import com.crm.autodesk.objectrepository.CreateContactsPage;
import com.crm.autodesk.objectrepository.HomePage;

public class CreateContctTest extends BaseClass{

	@Test(groups="SmokeSuite")
	public void contactCreate() throws Throwable
	{
		
		//Objects Of POM Class
				HomePage homePage= new HomePage(driver);
				ContactsPage contactsPage= new ContactsPage(driver);
				CreateContactsPage createContactsPage = new CreateContactsPage(driver);
				ContactInformationPage contactInformationPage = new ContactInformationPage(driver);

		
		int randomNum=jLib.getRandomNumber();
				
		
		//Data To be Verified
		String lastName=eLib.getDataFromExcelSheet("contct", 5, 5)+randomNum;
		
				
		//Enter into Contacts
		homePage.clickOnContactsLink();
		
		//Click On Create Contact
		contactsPage.clickOnCreateContacts();
		
		//Add LastName
		
		createContactsPage.addLastName(lastName);
		
		//Click On Upper Save Button
		createContactsPage.clickOnContactSave();
		
		//Verify Added or Not
		String headerText=contactInformationPage.headerText();
		jLib.verify(headerText, lastName);
		
		
	}
	
	@Test(groups="SmokeSuite")
	public void demo()
	{
		System.out.println("Demo");
	}
}
