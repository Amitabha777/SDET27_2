package com.crm.autodesk.concttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.objectrepository.ContactInformationPage;
import com.crm.autodesk.objectrepository.ContactsPage;
import com.crm.autodesk.objectrepository.CreateContactsPage;
import com.crm.autodesk.objectrepository.CreateOrganisationPage;
import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.OrganisationInformationPage;
import com.crm.autodesk.objectrepository.OrganisationPage;
import com.crm.autodesk.objectrepository.SearchOrganisationPage;

/**
 * 
 * @author AMITABHA
 *
 */

public class AddContactWithOrganisationAndVerify extends BaseClass{
/**
 * It's used to add Contact with Organisation In It
 * @param args
 * @throws Throwable 
 */
	
					
		@Test
		public void contactWithOrganisation() throws Throwable
		{

					
		//Generate Random Number
		int ranDomNum= jLib.getRandomNumber();
				
		
		//Loading TestDetails Excel File
		
		String orgName= eLib.getDataFromExcelSheet("contct", 5, 2) + ranDomNum;				
		String industries= eLib.getDataFromExcelSheet("contct", 5, 3);					
		String types= eLib.getDataFromExcelSheet("contct", 5, 4);					
		String lastName=eLib.getDataFromExcelSheet("contct", 5, 5);				
		
		
		
		//Objects Of POM Class
		HomePage homePage= new HomePage(driver);
		OrganisationPage organisationPage= new OrganisationPage(driver);
		CreateOrganisationPage createOrganisationPage= new CreateOrganisationPage(driver);
		OrganisationInformationPage organisationInformationPage= new OrganisationInformationPage(driver);
		ContactsPage contactsPage= new ContactsPage(driver);
		CreateContactsPage createContactsPage = new CreateContactsPage(driver);
		SearchOrganisationPage searchOrganisationPage = new SearchOrganisationPage(driver);
		ContactInformationPage contactInformationPage = new ContactInformationPage(driver);
		
		
		
		
		//Click on Organizations
		homePage.clickOnOrganisationsLink();
		
		//Click on Add Organization (+ Sign)
		organisationPage.clickOnAddOrganisationLink();
		
		
		//Entering Organisation Details
		createOrganisationPage.createAndSaveOrganisationDetails(orgName, industries, types);
		
		
		//Handling Explicit Wait
		organisationInformationPage.headerTextVisibility(driver,"visibilityof");
		
		//Go To Contacts Page
		homePage.clickOnContactsLink();
	
		//Add Contacts Details
		contactsPage.clickOnCreateContacts();
		createContactsPage.addContactsDetails(lastName);
		
	
		//Search Organisation Window Handling
		String mainId= driver.getWindowHandle();
		searchOrganisationPage.selectOrganisation(driver, orgName);
		
		
		//Dynamic Xpath
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		
		//Switching To Main Window
		driver.switchTo().window(mainId);
		
		
		//Click On Contacts Save
		contactsPage.clickOnContactSave();
		
		
		//Verify Contact Added or Not
		String headerText=contactInformationPage.headerText();
		jLib.verify(headerText, lastName);
		
						
	}
}
