package com.crm.autodesk.concttest;

import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.objectrepository.ContactsPage;
import com.crm.autodesk.objectrepository.HomePage;

public class ContactTC_16 extends BaseClass{

	@Test(groups="RegressionSuite") 
	public void test16()
	{
		
		//Objects Of POM Class
		HomePage homePage= new HomePage(driver);
		ContactsPage contactsPage= new ContactsPage(driver);
				
		//Click On Contacts
		homePage.clickOnContactsLink();
		
		
		//Click on Last Viewed
		contactsPage.clickOnLastViewed();
		
		//Display The Options Showed in Last View
		contactsPage.showLastViewList();
			}
}
