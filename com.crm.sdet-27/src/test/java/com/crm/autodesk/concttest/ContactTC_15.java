package com.crm.autodesk.concttest;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.objectrepository.ContactInformationPage;
import com.crm.autodesk.objectrepository.ContactsPage;
import com.crm.autodesk.objectrepository.CreateContactsPage;
import com.crm.autodesk.objectrepository.CreateOrganisationPage;
import com.crm.autodesk.objectrepository.EditContactInformationPage;
import com.crm.autodesk.objectrepository.HomePage;
import com.crm.autodesk.objectrepository.OrganisationInformationPage;
import com.crm.autodesk.objectrepository.OrganisationPage;
import com.crm.autodesk.objectrepository.SearchOrganisationPage;

/**
 * 
 * @author AMITABHA
 *
 */

public class ContactTC_15 extends BaseClass{

	@Test
	public void tc15() throws Throwable {
		
		
		//Objects Of POM Class
		HomePage homePage= new HomePage(driver);
		ContactsPage contactsPage= new ContactsPage(driver);
		EditContactInformationPage editContactInformationPage = new EditContactInformationPage(driver);
		
		
		String reqLastName=eLib.getDataFromExcelSheet("contct", 5, 5);
		int randomNum= jLib.getRandomNumber();
		
		
				//Click On Contacts
				homePage.clickOnContactsLink();
		
				//Click on the Desired Checkbox
				driver.findElement(By.xpath("//td[text()='CON3 ']/../td[1]/input[@type='checkbox']")).click();
				
				//Click On Edit
				driver.findElement(By.xpath("//td[text()='CON3 ']/../td[10]/a[text()='edit']")).click();
				
				//Edit Last Name
				WebElement lastName= editContactInformationPage.lastNameEdit();
				lastName.sendKeys(reqLastName+randomNum);
				
								
				//Click on Organisation to Change it
				editContactInformationPage.organisationChange();
				
				
				//Organisation Window Handle
				String mainId= driver.getWindowHandle();
				Set<String> allIds= driver.getWindowHandles();
				
				wLib.windowHandles(driver, allIds, "Accounts");
				
				//Search On Organisation Window
				driver.findElement(By.id("search_txt")).sendKeys("Amitabha");
				
				//Click On Search
				driver.findElement(By.name("search")).click();
				
				//Select the Required Organisation
				driver.findElement(By.xpath("//a[text()='Amitabha']")).click();
				
				//Switching to Main Window
				driver.switchTo().window(mainId);
				
				//Click on Contacts Save Button
				editContactInformationPage.clickOnContactSave();
				
										
				//Click on In CheckBox
				contactsPage.inCheckBox();
				
				//Click On Search Text Box
				contactsPage.searchBox(reqLastName);
				
				//Click on Search
				contactsPage.searchButton();
				
				String modifiedLastName=driver.findElement(By.xpath("//td[text()='CON3 ']/../td[4]")).getText();
				
				
				//Verification Code
				jLib.verify(modifiedLastName,reqLastName);
							
				
	}
}
